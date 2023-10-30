import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserAuthService } from './user-auth.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  PathOfApi = 'http://localhost:9090';
  requestHeader = new HttpHeaders(
    { "NO-AUTH": "True" }
  );

  constructor(private httpClient: HttpClient, private userAuthService: UserAuthService) { }

  public login(loginData: NgForm) {
    return this.httpClient.post(this.PathOfApi + "/authenticate", loginData, { headers: this.requestHeader });
  }

  public checkRoles(allowedRoles: string[]): boolean {
    let roleMatch = false;
    const userRoles:any = this.userAuthService.getRole();
    
    for(const allowedRole of allowedRoles){
      for(const userRole of userRoles){
         if(userRole.role === allowedRole){
            roleMatch = true;
         }
      }
    }
    return roleMatch;
  }
}

