import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from 'src/app/services/auth-service.service';
import { TokenstorageService } from 'src/app/services/tokenstorage.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  form: any = {
    username: null,
    password: null,
  };
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  loading: boolean = false;

  constructor(
    private authService: AuthServiceService,
    private tokenStorage: TokenstorageService,
    private router: Router
  ) {}

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;
    }
  }

  onSubmit(): void {
    const { username, password } = this.form;
    this.loading = true;

    this.authService.login(username, password).subscribe({
      next: (data) => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUser(data);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getUser().roles;
        this.reloadPage();
        this.loading = false;
        this.router.navigate(['/pensioner/admin']).then();
      },
      error: (err) => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
        this.loading = false;
        this.router.navigate(['/pensioner/admin']).then();
      },
    });
  }

  reloadPage(): void {
    window.location.reload();
  }
}
