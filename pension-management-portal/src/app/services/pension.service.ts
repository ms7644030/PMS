import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { catchError, Observable, throwError } from 'rxjs';
import { PensionerDetails } from 'src/app/models/PensionerDetails';
import { PensionDetail } from 'src/app/models/PensionDetail';
import { Aadhaar } from '../models/Aadhaar';

@Injectable({
  providedIn: 'root',
})
export class PensionService {
  private serverUrl: string = `http://localhost:9001`; // pensionerDetail url

  private serverUrl1: string = `http://localhost:8081`; // pensionDetail url

  constructor(private http: HttpClient) {}

  //get pensionerDetails

  public getPensionerDetails(
    aadhaar: number
  ): Observable<PensionerDetails | String> {
    let dataURL: string = `${this.serverUrl}/pensionerDetail/${aadhaar}`;

    return this.http
      .get<PensionerDetails | String>(dataURL)
      .pipe(catchError(this.handleError));
  }

  //get pensionDetail

  public getPensionDetail(aadhaar: Aadhaar): Observable<PensionDetail> {
    let dataURL: string = `${this.serverUrl1}/processPension/aadhaar`;

    return this.http
      .post<PensionDetail>(dataURL, aadhaar)
      .pipe(catchError(this.handleError));
  }

  // Create pensionerDetail

  public createPensioner(
    pensioner: PensionerDetails
  ): Observable<PensionerDetails> {
    let dataURL: string = `${this.serverUrl}/pensionerDetail/save`;

    return this.http
      .post<PensionerDetails>(dataURL, pensioner)
      .pipe(catchError(this.handleError));
  }

  // Error handling

  public handleError(error: HttpErrorResponse) {
    let errorMessage: string = '';
    if (error.error instanceof ErrorEvent) {
      //client error

      errorMessage = `Error : ${error.error.message}`;
    } else {
      //server error

      if (error.status.valueOf() === 400) {
        errorMessage = 'Invalid Aadhaar';
      }

      // errorMessage = `Status : ${error.status} \n Message :${error.message}`
    }

    return throwError(() => new Error(errorMessage));
  }
}
