import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserAuthService {

  constructor() { }

  public setRole(role: []) {
    localStorage.setItem('roles', JSON.stringify(role));
  }

  public getRole(): [] {
    const roles = localStorage.getItem('roles');
    if (roles != null) {
      return JSON.parse(roles);
    } else {
      return [];
    }
  }

  public setToken(token: string) {
    localStorage.setItem('token', token);
  }

  public getToken(): string {
    const token = localStorage.getItem('token');
    if (token != null) {
      return token;
    } else {
      return '';
    }
  }

  public clear() {
    localStorage.clear();
  }

  public isLoggedin(): boolean {
    if (this.getRole() && this.getToken()) {
      return true;
    } else {
      return false;
    }
  }

  
}
