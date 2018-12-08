import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { PageContainerComponent } from './page-container/page-container.component';
import { TaskListComponent } from './post-list/post-list.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { SearchComponent } from './search/search.component';
import { TagCloudComponent } from './tag-cloud/tag-cloud.component';
import { HomePageComponent } from './feladatok-page/feladatok-page.component';
import { AboutPageComponent } from './about-page/about-page.component';
import { PostListByTagComponent } from './post-list-by-tag/post-list-by-tag.component';
import { SearchResultsPageComponent } from './search-results-page/search-results-page.component';
import { SignInPageComponent } from './sign-in-page/sign-in-page.component';
import { SignUpPageComponent } from './sign-up-page/sign-up-page.component';
import { EditPostPageComponent } from './edit-post-page/edit-post-page.component';
import { ConfirmTasktDeletionPageComponent } from './confirm-post-deletion-page/confirm-post-deletion-page.component';

const routes: Routes = [
  {
    path: 'feladatok',
    component: HomePageComponent
  },
  {
    path: 'csaladtagok',
    component: AboutPageComponent
  },
  {
    path: 'sign-in',
    component: SignInPageComponent
  },
  {
    path: 'sign-up',
    component: SignUpPageComponent
  },
  {
    path: 'tag/:tag',
    component: PostListByTagComponent
  },
  {
    path: 'search/:keywords',
    component: SearchResultsPageComponent
  },
  {
    path: 'post/:postNo/edit',
    component: EditPostPageComponent
  },
  {
    path: 'post/:postNo/confirm-delete',
  component: ConfirmTasktDeletionPageComponent
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  }
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    PageContainerComponent,
    TaskListComponent,
    SidebarComponent,
    SearchComponent,
    TagCloudComponent,
    HomePageComponent,
    AboutPageComponent,
    PostListByTagComponent,
    SearchResultsPageComponent,
    SignInPageComponent,
    SignUpPageComponent,
    EditPostPageComponent,
    ConfirmTasktDeletionPageComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
