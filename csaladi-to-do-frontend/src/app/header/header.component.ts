import { Component } from '@angular/core';
import { UserSessionService } from '../user-session.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  constructor(private userSessionService: UserSessionService) { }

  handleSignOut(event) {
    event.preventDefault();
    this.userSessionService.signOut();
  }
}
