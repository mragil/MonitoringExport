package com.example.monitoringexport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btn_login;
    TextView tvEmail,tvPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_login = findViewById(R.id.btn_login);
        tvEmail = findViewById(R.id.AddNamaProduk);
        tvPassword = findViewById(R.id.Addtanggal_peb);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });
    }

    public boolean verify(){
        boolean valid = false;
        String email = tvEmail.getText().toString();
        String password = tvPassword.getText().toString();

        if (email.isEmpty()) {
            valid = false;
            Toast.makeText(this, "Masukkan Alamat Email Yang Valid!", Toast.LENGTH_SHORT).show();
        } else {
            valid = true;
        }

        if (password.isEmpty()){
            valid = false;
            Toast.makeText(this, "Password Tidak Boleh Kosong!", Toast.LENGTH_SHORT).show();
        } else {
            valid = true;
        }
        return valid;
    }
}
