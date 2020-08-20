package com.example.myapplicationrxretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editTextm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setUpview();


    }

    private void setUpview() {
        editTextm=findViewById(R.id.editTextTextPersonName);
        button=findViewById(R.id.btnrxretrofit);
        button.setOnClickListener((View view)->{
            startActivity(new Intent(this,RxRetrofitActivity.class)
            .putExtra("n",editTextm.getText().toString())
            );
        });


    }
}