package com.example.myapplicationrxretrofit.apis;

import com.example.myapplicationrxretrofit.models.GitHubreppo;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
public  interface WebApis {


    //Sin Rx
    @GET("/users/{user}/repos")
    Call<List<GitHubreppo>> getReposForUser(@Path("user") String user);


    //con rx
    @GET("/users/{user}/repos")
    Single<List<GitHubreppo>> getReposForUserWithRx(@Path("user") String user);



}

