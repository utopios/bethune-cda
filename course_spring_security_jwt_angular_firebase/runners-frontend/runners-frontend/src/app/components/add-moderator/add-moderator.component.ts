import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {elementAt, Observable} from "rxjs";
import {UserService} from "../../services/user-service/user.service";
import {User} from "../../models/user";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-add-moderator',
  templateUrl: './add-moderator.component.html',
  styleUrls: ['./add-moderator.component.css']
})
export class AddModeratorComponent implements OnInit {

  displayedColumns: string[] = ['userId', 'username', 'email', 'actions'];

  users: User[] = []; // the data is not from type Observable because with Observable we cannot add it,

  successMessage!: string;

  constructor(private userService : UserService,
              private _snackBar: MatSnackBar){}

  ngOnInit(): void {
    this.userService.getAllUsers().subscribe(data => {
      console.log("Data received from front end:" + data);
      this.users = data;
      console.log("Users: " + this.users)
      for (let i = 0; i < this.users.length; i++) {
        if (this.users[i].moderator) {
          console.log(this.users[i].username + " is moderator");
        } else {
          console.log(this.users[i].username + " is moderator");
        }
      }
    });
  }


  addModeratorRoleToUser(userId: number) {
    this.userService.addModeratorRoleToUser(userId).subscribe(data => {
      console.log(data);
      this.successMessage = data.message;
      console.log(this.successMessage)
      this.openSnackBar(this.successMessage);
      // here you need to refresh the page after adding user as moderator
      this.ngOnInit();

    });
    console.log("clicked" + userId);
  }

  openSnackBar(message: string) {
    this._snackBar.open(message, '',{
      duration: 3000
    });
  }
}
