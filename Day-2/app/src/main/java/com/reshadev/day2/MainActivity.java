package com.reshadev.day2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login_button = findViewById(R.id.login_button);
        setupOnClick();
    }

    private void setupOnClick() {
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usrname = username.getText().toString();
                String pwd = password.getText().toString();
                if (usrname.isEmpty() || pwd.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Username And Password Field Should Not be Empty", Toast.LENGTH_LONG).show();
                } else {
                    if(isValidEmail(usrname))
                    {
                        Intent intent = new Intent(MainActivity.this,ActivityB.class);
                        intent.putExtra("keyUsername",usrname);
                        intent.putExtra("keyPassword",pwd);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this,"Enter Valid Email address",Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(email).matches();
    }
}