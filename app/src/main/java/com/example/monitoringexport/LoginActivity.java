package com.example.monitoringexport;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.monitoringexport.Model.Login;
import com.example.monitoringexport.Model.Session;
import com.example.monitoringexport.Rest.ApiClient;
import com.example.monitoringexport.Rest.ApiInterface;

import java.io.File;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    Button btn_login;
    TextView tvEmail,tvPassword;
    ApiInterface mApiInterface;
    boolean valid = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_login = findViewById(R.id.btn_login);
        tvEmail = findViewById(R.id.AddNamaProduk);
        tvPassword = findViewById(R.id.Addtanggal_peb);
        mApiInterface = ApiClient.buildService(ApiInterface.class);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verify();
            }
        });

    }

    public void verify(){
        String email = tvEmail.getText().toString();
        String password = tvPassword.getText().toString();

        Login login = new Login(email,password);
        Call<Session> loginCall = mApiInterface.login(login);
        Log.d("MASUK","SINI");
        loginCall.enqueue(new Callback<Session>() {
            @Override
            public void onResponse(Call<Session> call, Response<Session> response) {
                Log.d("CODENYA","INI "+response.code());
                if (response.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Selamat Datang : "+response.body().getNama(), Toast.LENGTH_SHORT).show();
                    Log.d("TOKEN",response.body().getToken());
                    SharedPreferences preferences = getSharedPreferences("UserInfo", MODE_PRIVATE);
                    preferences.edit().putString("userInfo", response.body().getToken()).apply();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    valid = true;
                }else {
                    Toast.makeText(LoginActivity.this, "Email/Password Salah!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Session> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Errornya : "+t, Toast.LENGTH_SHORT).show();
            }
        });
        File f = getDatabasePath("MyPrefsFile.xml");

        if (f != null)
            Log.i("TAG", f.getAbsolutePath());
    }
}
