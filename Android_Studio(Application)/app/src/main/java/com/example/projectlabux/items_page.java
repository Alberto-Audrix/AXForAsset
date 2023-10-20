package com.example.projectlabux;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class items_page extends AppCompatActivity {

    ImageView menu;
    TextView home,item,profile,logout;
    Button mako,nick,mhs,pokemon,ml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_page);
        menu = (ImageView) findViewById(R.id.menu);
        home = findViewById(R.id.homeBtn);
        item = findViewById(R.id.itemsBtn);
        profile = findViewById(R.id.profileBtn);
        logout = findViewById(R.id.logOutBtn);
        mako = findViewById(R.id.mako);
        nick = findViewById(R.id.nick);
        mhs =  findViewById(R.id.mhs2);
        pokemon = findViewById(R.id.pokemon);
        ml = findViewById(R.id.lightborn);
        showMenu();
        menuNav();
        detailListener();
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
            Intent intent = new Intent(items_page.this,Login_page.class);
            items_page.this.startActivity(intent);
        });
        item.setOnClickListener(e->{
            Intent intent = new Intent(items_page.this,items_page.class);
            items_page.this.startActivity(intent);
        });

        profile.setOnClickListener(e->{
            Intent intent = new Intent(items_page.this,profile_page.class);
            items_page.this.startActivity(intent);
        });

        home.setOnClickListener(e->{
            Intent intent = new Intent(items_page.this,home_page.class);
            items_page.this.startActivity(intent);
        });
    }
    void detailListener(){
        mako.setOnClickListener(e->{
            Intent intent = new Intent(items_page.this,mako_asset.class);
            items_page.this.startActivity(intent);
        });
        nick.setOnClickListener(e->{
            Intent intent = new Intent(items_page.this,nick_asset.class);
            items_page.this.startActivity(intent);
        });
        mhs.setOnClickListener(e->{
            Intent intent = new Intent(items_page.this,mhs2_asset.class);
            items_page.this.startActivity(intent);
        });
        pokemon.setOnClickListener(e->{
            Intent intent = new Intent(items_page.this,pokemon_asset.class);
            items_page.this.startActivity(intent);
        });
        ml.setOnClickListener(e->{
            Intent intent = new Intent(items_page.this,ml_asset.class);
            items_page.this.startActivity(intent);
        });
    }
}