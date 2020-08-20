package com.example.myapplicationrxretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplicationrxretrofit.Adapters.RepositoryAdapter;
import com.example.myapplicationrxretrofit.apis.WebServices;
import com.example.myapplicationrxretrofit.models.GitHubreppo;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RxRetrofitActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RepositoryAdapter repositoryAdapter;
    private List<GitHubreppo> gitHubreppoList;
    private CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_retrofit);


        setUpView();

        retrofitSenzaRx();

    }

    private void retrofitSenzaRx() {
        Call<List<GitHubreppo>> call = WebServices
                .getInstance()
               .createService()
                .getReposForUser("angiof");

        call.enqueue(new Callback<List<GitHubreppo>>() {
            @Override
            public void onResponse(Call<List<GitHubreppo>> call, Response<List<GitHubreppo>> response) {

                gitHubreppoList = response.body();
                repositoryAdapter.setdata(gitHubreppoList);
            }

            @Override
            public void onFailure(Call<List<GitHubreppo>> call, Throwable t) {
                Log.d("tg","error"+t.getMessage());

            }
        });



    }

    private void setUpView() {
        compositeDisposable = new CompositeDisposable();
        gitHubreppoList = new ArrayList<>();
        repositoryAdapter = new RepositoryAdapter(gitHubreppoList);
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager lim = new LinearLayoutManager(this);
        lim.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(lim);
        recyclerView.setAdapter(repositoryAdapter);
    }


}