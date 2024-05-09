import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppConfig } from '../app-config';

@Injectable({
  providedIn: 'root'
})
export class AdditionDetailsService {

  constructor(private httpClient:HttpClient) { }

  addAdditionalDetails(indidualList:any){
    return this.httpClient.post<any>(AppConfig.addAdditionalDetails,indidualList);

  }

  getAllData(allDataList:any){
    return this.httpClient.post<any>(AppConfig.getAllData,allDataList);
  }

  updateAdditionalDetails(indidualList:any){
    return this.httpClient.post<any>(AppConfig.updateAdditionalDetails,indidualList);
  }

  getTotalAmount(allDataList:any){
    return this.httpClient.post<any>(AppConfig.getTotalAmount,allDataList);
  }

  
}
