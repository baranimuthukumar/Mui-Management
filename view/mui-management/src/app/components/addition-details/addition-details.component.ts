import { Component, ViewChild } from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import { AdminList, AllDataList, PersonList } from '../mui-application';
import {MatDialog, MatDialogRef, MatDialogModule} from '@angular/material/dialog';
import { EditDialogComponent } from '../edit-dialog/edit-dialog.component';
import { AdminService } from 'src/app/services/admin.service';
import { AdditionDetailsService } from 'src/app/services/addition-details.service';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';

@Component({
  selector: 'app-addition-details',
  templateUrl: './addition-details.component.html',
  styleUrls: ['./addition-details.component.css']
})
export class AdditionDetailsComponent {

  personName:string='';
  personNative:string='';
  amountdetails:number = 0;
  totalAmount:number = 0;
  count:number = 0;
  displayedColumns: string[] = ['position', 'name', 'native', 'amount','actions'];
  indidualList: PersonList  = new PersonList();
  ELEMENT_DATA: PersonList[]  = [];
  allDataList:AllDataList = new AllDataList();
  dataSource = new MatTableDataSource<PersonList>([]);
  @ViewChild('paginator') paginator!: MatPaginator;
  @ViewChild('sort', { read: MatSort, static: true }) sort!: MatSort;

  constructor(public dialog: MatDialog,
    public adminService:AdminService,
    public additionDetailsService:AdditionDetailsService) {
      if(this.adminService.getExisting){
        this.adminService.getAdminDetailsById().subscribe((value) => {
        console.log('Barani-getDetails');
        console.log(value);
        this.allDataList.adminId=value;
        this.additionDetailsService.getAllData(this.allDataList).subscribe(response =>{
          console.log('Barani-getDetails');
          console.log(response);
          this.ELEMENT_DATA=response;
          this.count=this.ELEMENT_DATA.length;
          this.dataSource.data=this.ELEMENT_DATA;
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
          this.initalizeData();
          this.onGetTotalAmount();
        });
      });
      }else{
        this.ELEMENT_DATA=[];
        this.dataSource.data=this.ELEMENT_DATA;
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      }
    
  }

  ngOnInit(){
    this.allDataList.adminId=this.adminService.additionDetailsAdminId;
  }

  onAddPrice(){
    this.count=this.dataSource.data.length;
    this.indidualList= new PersonList();
    this.indidualList.postionSno = ++this.count;
    this.indidualList.personName = this.personName;
    this.indidualList.personNative = this.personNative;
    this.indidualList.amountdetails =this.amountdetails;
    this.indidualList.adminId=this.adminService.additionDetailsAdminId;
    this.additionDetailsService.addAdditionalDetails(this.indidualList).subscribe(response =>{
      this.ELEMENT_DATA.push(response);
      this.dataSource.data=this.ELEMENT_DATA;
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
      this.onGetTotalAmount();
      this.initalizeData();
    });
    
    
  }

  initalizeData(){
    this.amountdetails=0;
    this.personName='';
    this.personNative='';
  }

  onGetTotalAmount(){
    this.additionDetailsService.getTotalAmount(this.allDataList).subscribe(response =>{
      this.totalAmount=response;
    });
  }



  editRow(event: Event) {
 
    const dialogRef = this.dialog.open(EditDialogComponent, {
      width: '250px',
      data:event
    });

    dialogRef.afterClosed().subscribe(result => {
      this.additionDetailsService.updateAdditionalDetails(result.data).subscribe(response =>{
        this.updateRowData(response);
        this.onGetTotalAmount();
      });
        
    });
  }

  updateRowData(row_obj: any){
    var key= row_obj.adminId;
    this.dataSource.data = this.dataSource.data.filter((value,key)=>{
      if(value.additionalDetailsId == row_obj.additionalDetailsId){
        value.personName = row_obj.personName;
        value.personNative = row_obj.personNative;
        value.amountdetails = row_obj.amountdetails;
      }
      return true;
    });
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
  
}
