package com.example.projectlabux;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Login_page extends AppCompatActivity {

    EditText user,pass;
    Button login_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        init();
        lgnListener();
    }


    void init(){
        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        login_btn = findViewById(R.id.lgn_btn);
    }

    public void alertUserEmpty(){
        AlertDialog.Builder error = new AlertDialog.Builder(Login_page.this);
        error.setCancelable(false);
        error.setMessage("Username must be filled!");
        error.setTitle("Error");
        error.setNegativeButton("Ok",(DialogInterface.OnClickListener) (dialog, which) ->{
            dialog.cancel();
        });
        AlertDialog alert = error.create();
        alert.show();
    }

    public void alertpassEmpty(){
        AlertDialog.Builder error = new AlertDialog.Builder(Login_page.this);
        error.setCancelable(false);
        error.setMessage("Password must be filled!");
        error.setTitle("Error");
        error.setNegativeButton("Ok",(DialogInterface.OnClickListener) (dialog, which) ->{
            dialog.cancel();
        });
        AlertDialog alert = error.create();
        alert.show();
    }

    public void alertpassLength(){
        AlertDialog.Builder error = new AlertDialog.Builder(Login_page.this);
        error.setCancelable(false);
        error.setMessage("Password must be at least 8 characters!");
        error.setTitle("Error");
        error.setNegativeButton("Ok",(DialogInterface.OnClickListener) (dialog, which) ->{
            dialog.cancel();
        });
        AlertDialog alert = error.create();
        alert.show();
    }



    void lgnListener(){
        login_btn.setOnClickListener(e->{
            String username = user.getText().toString();
            String password = pass.getText().toString();
            if(username.isEmpty()){
                alertUserEmpty();
            }
            else if(password.isEmpty()){
                alertpassEmpty();
            }
            else if(password.length() < 8){
                alertpassLength();
            }
            else{
                Intent intent = new Intent(Login_page.this, home_page.class);
                Login_page.this.startActivity(intent);
            }
        });
    }
}