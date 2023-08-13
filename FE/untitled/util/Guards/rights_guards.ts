import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree} from "@angular/router";
import {Observable} from "rxjs";


@Injectable()
export class RightGuard implements CanActivate {
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    const userRole = localStorage.getItem('right');
    const receivedRole = route.data['right'];

    return (userRole === receivedRole);
  }
}
