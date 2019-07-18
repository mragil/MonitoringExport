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

import com.example.monitoringexport.Adapter.AdapterUsers;
import com.example.monitoringexport.Model.GetUser;
import com.example.monitoringexport.Model.Proforma;
import com.example.monitoringexport.Model.User;
import com.example.monitoringexport.Rest.ApiClient;
import com.example.monitoringexport.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public MainActivity ma;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dl = findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl,R.string.Open,R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences sharedPreferences = getSharedPreferences("UserInfo",MODE_PRIVATE);
        token = sharedPreferences.getString("userInfo","No Token");
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.buildService(ApiInterface.class);
        ma=this;

        nv = (NavigationView)findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id){
                    case R.id.home:
                        Toast.makeText(MainActivity.this, "Home",Toast.LENGTH_SHORT).show();break;
                    case R.id.proforma:
                        startActivity(new Intent(MainActivity.this, Proforma_activity.class));
                    case R.id.commercial:
                        Toast.makeText(MainActivity.this, "PEB Commercial",Toast.LENGTH_SHORT).show();break;
                    case R.id.laporan:
                        Toast.makeText(MainActivity.this, "Laporan",Toast.LENGTH_SHORT).show();break;
                    default:
                        return true;

                }

                return true;
            }
        });

        refresh();

    }

    public void refresh() {
        Call<List<User>> userCall = mApiInterface.getUser(token);
        userCall.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>>
                    response) {
                List<User> UserList = response.body();
                Log.d("Retrofit Get", "Jumlah data Kontak: " +
                        String.valueOf(UserList.size()));
                mAdapter = new AdapterUsers(UserList);
                mRecyclerView.setAdapter(mAdapter);
                Log.d("??","MASUK REFRESH3");
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
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
