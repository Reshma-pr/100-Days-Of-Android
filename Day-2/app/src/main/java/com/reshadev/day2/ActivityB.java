package com.reshadev.day2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {
    private TextView usernameDisplay;
    private TextView password_Display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        usernameDisplay=findViewById(R.id.user_name_display_input);
        password_Display=findViewById(R.id.pasword_display);
        String usrname_input=getIntent().getStringExtra("keyUsername");
        String password_input= getIntent().getStringExtra("keyPassword");
        usernameDisplay.setText(usrname_input);
        password_Display.setText(password_input);
    }
}