import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { UserAuthService } from '../_services/user-auth.service';
import { UserService } from '../_services/user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private userAuthService: UserAuthService, private router: Router, private userService: UserService) { }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): boolean | UrlTree {
    if (this.userAuthService.getToken() !== null) {
      const roles = route.data["roles"] as Array<string>;
      if (roles) {
        const match = this.userService.checkRoles(roles);
        if (match) {
          return true; // User is authorized to access the route
        } else {
          return this.router.createUrlTree(['/forbidden']); // User is not authorized, navigate to 'forbidden'
        }
      } else {
        return false; // No roles specified, allow access by default
      }
    } else {
      return this.router.createUrlTree(['/login']); // User is not authenticated, navigate to 'login'
    }
  }
}
