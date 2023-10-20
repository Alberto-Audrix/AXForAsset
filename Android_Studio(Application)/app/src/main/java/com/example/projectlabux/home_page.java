package com.example.projectlabux;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Slide;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class home_page extends AppCompatActivity {

    ImageView menu;
    TextView home,item,profile,logout;
    Button terms;
    TextView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        menu = (ImageView) findViewById(R.id.menu);
        home = findViewById(R.id.homeBtn);
        item = findViewById(R.id.itemsBtn);
        profile = findViewById(R.id.profileBtn);
        logout = findViewById(R.id.logOutBtn);
        terms = findViewById(R.id.termsBtn);
        user = findViewById(R.id.welcome);
        showMenu();
        showTerms();
        menuNav();
        ArrayList <Integer> items = new ArrayList<>();
        items.add(R.drawable.pro);
        items.add(R.drawable.pubg);
        items.add(R.drawable.mhs);
        items.add(R.drawable.depth);
        RecyclerView carousel = findViewById(R.id.carousel);
        MyAdapter adapter = new MyAdapter(items);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);

        carousel.setAdapter(adapter);
        carousel.setLayoutManager(layoutManager);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(layoutManager.findLastCompletelyVisibleItemPosition() < adapter.getItemCount() - 1){
                    layoutManager.smoothScrollToPosition(carousel, new RecyclerView.State(), layoutManager.findLastCompletelyVisibleItemPosition()+1 );
                } else if (layoutManager.findLastCompletelyVisibleItemPosition() >= adapter.getItemCount() - 1) {
                    layoutManager.smoothScrollToPosition(carousel, new RecyclerView.State(), 0);
                }
            }
        },0,2000);
    }

    void showMenu(){
        menu.setOnClickListener(e->{
            home.setVisibility(TextView.VISIBLE);
            item.setVisibility(TextView.VISIBLE);
            profile.setVisibility(TextView.VISIBLE);
            logout.setVisibility(TextView.VISIBLE);
        });
    }


    public void alertTerms(){
        AlertDialog.Builder error = new AlertDialog.Builder(home_page.this);
        error.setCancelable(false);
        error.setMessage("Welcome to \"AXForAsset\", our digital marketplace where we provide various game assets to be used on your game projects.\n" +
                "\n" +
                "Every transactions made is must acknowledged by you who is 18 years old or above. For those who are under 18 years old, please seek guidance and direction from your guardian before making a purchase.\n" +
                "\n" +
                "Please do not give away or share any details regarding your private information. If some of your private information is leaked and misused due to your own mistake and fault, we do not hold any kinds of responsibility.\n" +
                "\n" +
                "By accepting to our terms and conditions means you, as a user / client of this application service, agree and must follow every rules and regulations we established.");
        error.setTitle("Terms & Condition");
        error.setNegativeButton("Decline",(DialogInterface.OnClickListener) (dialog, which) ->{
            dialog.cancel();
        });
        error.setPositiveButton("Accept",(DialogInterface.OnClickListener) (dialog, which) ->{
            dialog.cancel();
        });
        AlertDialog alert = error.create();
        alert.show();
    }

    void showTerms(){
        terms.setOnClickListener(e->{
            alertTerms();
        });
    }
    void menuNav(){
        logout.setOnClickListener(e->{
            Intent intent = new Intent(home_page.this,Login_page.class);
            home_page.this.startActivity(intent);
        });
        item.setOnClickListener(e->{
            Intent intent = new Intent(home_page.this,items_page.class);
            home_page.this.startActivity(intent);
        });

        profile.setOnClickListener(e->{
            Intent intent = new Intent(home_page.this,profile_page.class);
            home_page.this.startActivity(intent);
        });

        home.setOnClickListener(e->{
            Intent intent = new Intent(home_page.this,home_page.class);
            home_page.this.startActivity(intent);
        });
    }


}