package com.example.projectlabux;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class profile_page extends AppCompatActivity {


    ImageView menu;
    TextView home,item,profile,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        menu = (ImageView) findViewById(R.id.menu);
        home = findViewById(R.id.homeBtn);
        item = findViewById(R.id.itemsBtn);
        profile = findViewById(R.id.profileBtn);
        logout = findViewById(R.id.logOutBtn);
        showMenu();
        menuNav();
    }

    void showMenu(){
        menu.setOnClickListener(e->{
            home.setVisibility(TextView.VISIBLE);
            item.setVisibility(TextView.VISIBLE);
            profile.setVisibility(TextView.VISIBLE);
            logout.setVisibility(TextView.VISIBLE);
        });
    }

    void menuNav(){
        logout.setOnClickListener(e->{
            Intent intent = new Intent(profile_page.this,Login_page.class);
            profile_page.this.startActivity(intent);
        });
        item.setOnClickListener(e->{
            Intent intent = new Intent(profile_page.this,items_page.class);
            profile_page.this.startActivity(intent);
        });

        profile.setOnClickListener(e->{
            Intent intent = new Intent(profile_page.this,profile_page.class);
            profile_page.this.startActivity(intent);
        });

        home.setOnClickListener(e->{
            Intent intent = new Intent(profile_page.this,home_page.class);
            profile_page.this.startActivity(intent);
        });
    }
}