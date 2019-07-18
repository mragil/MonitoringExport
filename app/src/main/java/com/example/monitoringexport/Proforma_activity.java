package com.example.monitoringexport;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.monitoringexport.Adapter.AdapterProforma;
import com.example.monitoringexport.Adapter.AdapterUsers;
import com.example.monitoringexport.Model.Proforma;
import com.example.monitoringexport.Model.User;
import com.example.monitoringexport.Rest.ApiClient;
import com.example.monitoringexport.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Proforma_activity extends AppCompatActivity {
    private ActionBarDrawerToggle t;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    Button btn_add;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proforma);

        DrawerLayout dl = findViewById(R.id.activity_proforma);
        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo",MODE_PRIVATE);
        token = sharedPreferences.getString("userInfo","No Token");
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview1);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.buildService(ApiInterface.class);

        NavigationView nv = (NavigationView) findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id){
                    case R.id.home:
                        startActivity(new Intent(Proforma_activity.this, MainActivity.class));
                    case R.id.proforma:
                        Toast.makeText(Proforma_activity.this, "PEB Proforma", Toast.LENGTH_SHORT).show();
                    case R.id.commercial:
                        Toast.makeText(Proforma_activity.this, "PEB Commercial",Toast.LENGTH_SHORT).show();break;
                    case R.id.laporan:
                        Toast.makeText(Proforma_activity.this, "Laporan",Toast.LENGTH_SHORT).show();break;
                    default:
                        return true;

                }

                return true;
            }
        });
        Log.d("??","TES MASUK PROFORMA");
        refresh();

        btn_add = findViewById(R.id.btn_keadd);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Proforma_activity.this, Add_Activity.class));
            }
        });

    }

    public void refresh() {
        Call<List<Proforma>> proformaCall = mApiInterface.getProforma(token);
        proformaCall.enqueue(new Callback<List<Proforma>>() {
            @Override
            public void onResponse(Call<List<Proforma>> call, Response<List<Proforma>>
                    response) {
                List<Proforma> ProformaList = response.body();
                Log.d("Retrofit Get", "Jumlah data Proforma: " +
                        String.valueOf(ProformaList.size()));
                Log.d("Get Proforma Status",response.message());
                mAdapter = new AdapterProforma(ProformaList);
                mRecyclerView.setAdapter(mAdapter);
                Log.d("??","MASUK PROFORMA");
            }

            @Override
            public void onFailure(Call<List<Proforma>> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(t.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
