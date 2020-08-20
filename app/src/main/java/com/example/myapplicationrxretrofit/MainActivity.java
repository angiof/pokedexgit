package com.example.myapplicationrxretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setUpview();


    }

    private void setUpview() {

        button=findViewById(R.id.btnrxretrofit);
        button.setOnClickListener((View view)->{
            startActivity(new Intent(this,RxRetrofitActivity.class));
        });


    }
}