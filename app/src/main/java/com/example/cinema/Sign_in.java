package com.example.cinema;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Sign_in extends AppCompatActivity {
    TextView forgetpass;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        forgetpass = findViewById(R.id.ll_forgetPass);
        username = findViewById(R.id.ll_username);
        password = findViewById(R.id.ll_password);
        CardView cardView = findViewById(R.id.cv_continue);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("")) {
                    username.setError("Enter valid user name");
                } else if (password.getText().toString().equals("")) {
                    password.setError("Enter valid password");
                } else {
                    Intent intent = new Intent(Sign_in.this, Home.class);
                    startActivity(intent);
                }
            }
        });

        forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Sign_in.this, Forget_Password.class);
                startActivity(intent);
            }
        });
    }
}