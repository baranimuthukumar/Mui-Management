import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AdminList } from '../components/mui-application';
import { AppConfig } from '../app-config';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private httpClient:HttpClient,) { }

  private getAdminDetailsById$ = new BehaviorSubject<any>({});

  additionDetailsAdminId:any;
  trustName:any;
  getExisting:boolean=false;

  setAdminDetailsById(product: any) {
    this.getAdminDetailsById$.next(product);
  }

  getAdminDetailsById(){
    return this.getAdminDetailsById$.asObservable();
  }

  registerAdminUser(adminList: AdminList){
    return this.httpClient.post<any>(AppConfig.registerUrl,adminList);
  }

  getTrustDetails(){
    return this.httpClient.get<any>(AppConfig.getTrustDetails);
  }

  downloadPdf(allDataList:any,trustName:any){
    var downloadReportUrl=AppConfig.downloadPdf;
    downloadReportUrl += '/' + allDataList.adminId + '/'+ trustName;
    var a = document.createElement('a');
    a.setAttribute ('style','display:none');
    a.href=downloadReportUrl;
    a.download = 'TotalContribution.pdf';
    a.target='_blank';
    a.click();
    window.URL.revokeObjectURL(downloadReportUrl);
    a.remove();
  }
}
