package com.example.baitapgiuaki_ltdtdd;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Activity_profile extends AppCompatActivity {
        private ImageView imgSignup,logout;
    private com.google.android.material.bottomnavigation.BottomNavigationView BottomNavigationView;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_profile);
            Toolbar toolbar=findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            imgSignup =findViewById(R.id.imgSignup);
            logout=findViewById(R.id.logout);
            BottomNavigationView =findViewById(R.id.BottomNavigationView);
            imgSignup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(getApplicationContext(), Activity_home_page.class);
                    startActivity(intent);
                }
            });
            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            });
            BottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int id=item.getItemId();
                    if(id== R.id.nav_home){
                        Intent intent=new Intent(getApplicationContext(), Activity_home_page.class);
                        startActivity(intent);
                    }if (id==R.id.nav_file){
                        Intent intent=new Intent(getApplicationContext(), Activity_profile.class);
                        startActivity(intent);
                    }
                    if (id==R.id.nav_file){
                        Intent intent=new Intent(getApplicationContext(), Activity_File.class);
                        startActivity(intent);
                    }if (id==R.id.nav_logout){
                        Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                    return false;
                }
            });
        }

    }