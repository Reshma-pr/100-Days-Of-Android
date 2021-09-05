package com.reshadev.a100daysofcode_day1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class ActivityB extends AppCompatActivity {
    private TextView randomnumberB;
    private Button activityBbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        randomnumberB= findViewById(R.id.activity_b_random_number);
        activityBbutton=findViewById(R.id.activity_b_button);
        Random rand = new Random();
        String random = getIntent().getStringExtra("keyval");
        randomnumberB.setText(random);
        activityBbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n= rand.nextInt(9)+1;
                String x = ""+n;
                Intent intent = new Intent(ActivityB.this,MainActivity.class);
                intent.putExtra("keypass",x);
                startActivity(intent);
            }
        });
    }
}