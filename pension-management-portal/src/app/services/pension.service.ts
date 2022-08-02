import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TokenstorageService } from 'src/app/services/tokenstorage.service';

import { catchError, Observable, throwError } from 'rxjs';
import { PensionerDetails } from 'src/app/models/PensionerDetails';
import { PensionDetail } from 'src/app/models/PensionDetail';
import { Aadhaar } from '../models/Aadhaar';

const TOKEN_KEY = 'auth-token';

let token = 'Bearer ' + window.sessionStorage.getItem(TOKEN_KEY);

// let httpOptions = new HttpHeaders();
// httpOptions = httpOptions.set('Authorization', 'Bearer ' + token);

const httpOptions = {
  headers: new HttpHeaders({
    Authorization: token,
  }),
};

@Injectable({
  providedIn: 'root',
})
export class PensionService {
  private serverUrl: string = `http://localhost:9002`; // pensionerDetail url

  // private serverUrl1: string = `http://localhost:8081`; // pensionDetail url
  // tokenservice = new TokenstorageService();
  // token = this.tokenservice.getToken();

  constructor(private http: HttpClient) {}

  //get pensionerDetails

  public getPensionerDetails(
    aadhaar: number
  ): Observable<PensionerDetails | String> {
    let dataURL: string = `${this.serverUrl}/pensionerDetail/${aadhaar}`;

    return this.http
      .get<PensionerDetails | String>(dataURL, httpOptions)
      .pipe(catchError(this.handleError));
  }

  //get pensionDetail

  public getPensionDetail(aadhaar: Aadhaar): Observable<PensionDetail> {
    let dataURL: string = `${this.serverUrl}/processPension/aadhaar`;
    console.log(token);

    return this.http
      .post<PensionDetail>(dataURL, aadhaar, httpOptions)
      .pipe(catchError(this.handleError));
  }

  // Create pensionerDetail

  public createPensioner(
    pensioner: PensionerDetails
  ): Observable<PensionerDetails> {
    let dataURL: string = `${this.serverUrl}/pensionerDetail/save`;

    return this.http
      .post<PensionerDetails>(dataURL, pensioner, httpOptions)
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

      // if (error.status.valueOf() === 400) {
      //   errorMessage = 'Invalid Aadhaar';
      // }

      errorMessage = `Status : ${error.status} \n Message :${error.message}`;
    }

    return throwError(() => new Error(errorMessage));
  }
}
