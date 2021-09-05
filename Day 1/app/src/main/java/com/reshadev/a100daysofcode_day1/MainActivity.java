package com.reshadev.a100daysofcode_day1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView randomnumberA;
    private Button activityAbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Random rand = new Random();
        setContentView(R.layout.activity_main);
        randomnumberA = findViewById(R.id.activity_a_random_number);
        activityAbutton = findViewById(R.id.activity_a_button);
        Intent x = getIntent();
        String randomn;

        int num = rand.nextInt(9)+1;
        if (x.hasExtra("keypass")) {
            randomn = getIntent().getStringExtra("keypass");
            randomnumberA.setText(randomn);
        } else {
            randomn = "" + num;
            randomnumberA.setText(randomn);

        }
        activityAbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rnum = rand.nextInt(10);
                String numTe = "" + rnum;
                Intent intent = new Intent(MainActivity.this, ActivityB.class);
                intent.putExtra("keyval", numTe);
                startActivity(intent);

            }
        });

    }

}