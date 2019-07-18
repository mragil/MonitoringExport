package com.example.monitoringexport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.monitoringexport.Model.PostPutDelProforma;
import com.example.monitoringexport.Rest.ApiClient;
import com.example.monitoringexport.Rest.ApiInterface;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Add_Activity extends AppCompatActivity {

    EditText namaprod,pembuat;
    String tglpeb;
    Button btnadd;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        namaprod = findViewById(R.id.AddNamaProduk);
        pembuat = findViewById(R.id.Addpembuat);
        LocalDateTime dateTime = LocalDateTime.now(); // gets the current date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        tglpeb = dateTime.format(formatter);

        mApiInterface = ApiClient.buildService(ApiInterface.class);
        btnadd = findViewById(R.id.btn_add);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Void> postProformaCall = mApiInterface.postProforma(namaprod.getText().toString(),tglpeb,pembuat.getText().toString());
                postProformaCall.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        startActivity(new Intent(Add_Activity.this, MainActivity.class));
                        Log.d("STATUS","STATUS"+response.message());
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(Add_Activity.this, "Error Nya : "+t, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
