package com.badrudeen.myself;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import static com.badrudeen.myself.MainActivity.Email;
import static com.badrudeen.myself.MainActivity.Message;
import static com.badrudeen.myself.MainActivity.Name1;
import static com.badrudeen.myself.MainActivity.Phone;

public class Display extends AppCompatActivity {

    TextView name, phone, email, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        name = findViewById(R.id.displayname);
        phone = findViewById(R.id.displaynumber);
        email = findViewById(R.id.displayemail);
        message = findViewById(R.id.displaymessage);

        name.setText(Name1);
        phone.setText(Phone);
        email.setText(Email);
        message.setText(Message);


        findViewById(R.id.call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel:" + Phone));
                if (call.resolveActivity(getPackageManager()) != null){
                    startActivity(call);
                }
            }
        });

        findViewById(R.id.sentemail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" +Email));
                email.putExtra(Intent.EXTRA_SUBJECT, "Message From MyFreind App");
                email.putExtra(Intent.EXTRA_TEXT, Message);
                if (email.resolveActivity(getPackageManager()) != null){
                    startActivity(Intent.createChooser(email,"Send email..."));
                }
            }
        });
    }

}
