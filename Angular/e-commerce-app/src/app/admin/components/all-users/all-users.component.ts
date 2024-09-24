import { Component } from '@angular/core';
import { AdminService, User } from '../../service/admin.service';

@Component({
  selector: 'app-all-users',
  templateUrl: './all-users.component.html',
  styleUrls: ['./all-users.component.scss']
})
export class AllUsersComponent {

  displayedColumns: string[] = ['id', 'email', 'name', 'role'];
  users: User[] = [];

  constructor(private adminService: AdminService) {}

  ngOnInit(): void {
    this.adminService.getAllUsers().subscribe((data: User[]) => {
      this.users = data;
    });
  }
}
