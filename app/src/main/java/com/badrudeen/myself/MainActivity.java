package com.badrudeen.myself;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public   static  String Name1,Phone,Email,Message;

    EditText name, phone, emial,message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        emial = findViewById(R.id.emial);
        message = findViewById(R.id.message);


        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validation()){
                    Name1 = name.getText().toString().trim();
                    Phone = phone.getText().toString().trim();
                    Email = emial.getText().toString().trim();
                    Message = message.getText().toString().trim();

                    Intent gotodisplay = new Intent(MainActivity.this, Display.class);
                    startActivity(gotodisplay);
                }
            }
        });
    }

    private  boolean validation(){
        if (name.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this, "Enter Your Name", Toast.LENGTH_LONG).show();
            return  false;
        } else  if (phone.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this, "Enter Your Phone Number ", Toast.LENGTH_LONG).show();
            return  false;
        } else  if (emial.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this, "Enter Your Emails Address", Toast.LENGTH_LONG).show();
            return  false;
        } else  if (message.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this, "Enter Your Message", Toast.LENGTH_LONG).show();
            return  false;
        } else {
            return true;
        }
    }

}