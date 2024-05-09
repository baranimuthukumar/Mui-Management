import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';
import { AdminList, AllDataList } from '../mui-application';

@Component({
  selector: 'app-admin-portal',
  templateUrl: './admin-portal.component.html',
  styleUrls: ['./admin-portal.component.css']
})
export class AdminPortalComponent {

  mainCategory:any = {};
  name:string='';
  adminPage:AdminList = new AdminList();
  allDataList:AllDataList = new AllDataList();

  constructor(private router:Router,
    private adminService:AdminService) {};

  mainGroups = [
    {
      trustName: '',
      adminId: 0
    }
  ];

  ngOnInit(){
    this.adminService.additionDetailsAdminId=this.mainGroups[0].adminId;
    this.adminService.trustName=this.mainGroups[0].trustName;
    this.getAllTrustDetails();
  }

  onCategorySelected(event:any){
    this.adminService.additionDetailsAdminId=this.mainCategory.adminId;
    this.adminService.trustName=this.mainCategory.trustName;
   }

   onGetDetails(){
    this.adminService.getExisting=true;
    this.adminService.setAdminDetailsById(this.adminService.additionDetailsAdminId);
    this.router.navigate(["addition-details"]);
   }

   startUpdateDetails(){
    this.adminService.setAdminDetailsById(this.adminService.additionDetailsAdminId);
    this.router.navigate(["addition-details"]);
   }

   onAddTrust(){
    this.adminService.additionDetailsAdminId=this.mainCategory.category;
    this.adminPage.trustName=this.name;
    this.adminService.registerAdminUser(this.adminPage).subscribe(response =>{
      this.getAllTrustDetails();
      this.name='';
    });
   }
   
   getAllTrustDetails(){
    this.adminService.getTrustDetails().subscribe(response =>{
      this.mainGroups=response;
      if(this.mainGroups.length > 0){
        this.adminService.additionDetailsAdminId=this.mainGroups[0].adminId;
        this.adminService.trustName=this.mainGroups[0].trustName;
      }
    });
   }

   downloadPDF(){
    this.allDataList.adminId=this.adminService.additionDetailsAdminId;
    this.adminService.downloadPdf(this.allDataList,this.adminService.trustName);
   }
}
