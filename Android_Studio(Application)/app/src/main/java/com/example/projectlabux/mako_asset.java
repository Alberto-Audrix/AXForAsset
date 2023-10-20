package com.example.projectlabux;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

public class mako_asset extends AppCompatActivity {

    String[] payment = {"Visa","Master Card","Credit Card"};
    AutoCompleteTextView autoCompleteTextView;

    EditText email;
    Button buy,back;
    ArrayAdapter<String> adapterList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mako_asset);
        buy = findViewById(R.id.buyBtn);
        back = findViewById(R.id.backBtn);
        email = findViewById(R.id.email);
        buttonListener();
        autoCompleteTextView = findViewById(R.id.autoText);
        adapterList = new ArrayAdapter<String>(this,R.layout.payment_list,payment);
        autoCompleteTextView.setAdapter(adapterList);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
            }
        });
    }

    public void alertMailEmpty(){
        AlertDialog.Builder error = new AlertDialog.Builder(mako_asset.this);
        error.setCancelable(false);
        error.setMessage("Email must be filled!");
        error.setTitle("Error");
        error.setNegativeButton("Ok",(DialogInterface.OnClickListener) (dialog, which) ->{
            dialog.cancel();
        });
        AlertDialog alert = error.create();
        alert.show();
    }


    public void confirmSuccess(){
        AlertDialog.Builder error = new AlertDialog.Builder(mako_asset.this);
        error.setCancelable(false);
        error.setMessage("Confirmation email has been sent to your email");
        error.setTitle("Success");
        error.setNegativeButton("Ok",(DialogInterface.OnClickListener) (dialog, which) ->{
            dialog.cancel();
        });
        AlertDialog alert = error.create();
        alert.show();
    }


    void buttonListener(){
        back.setOnClickListener(e->{
            Intent intent = new Intent(mako_asset.this,home_page.class);
            mako_asset.this.startActivity(intent);
        });
        buy.setOnClickListener(e->{
            String mail = email.getText().toString();
            if(mail.isEmpty()){
                alertMailEmpty();
            }else {
                confirmSuccess();
                Intent intent = new Intent(mako_asset.this,items_page.class);
                mako_asset.this.startActivity(intent);
            }
        });
    }
}