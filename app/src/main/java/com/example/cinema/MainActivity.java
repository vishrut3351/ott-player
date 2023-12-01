package com.example.cinema;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    int year;
    int month;
    int day;

    String emailpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.ll_birth);

        Calendar calendar = Calendar.getInstance();
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    final Calendar c = Calendar.getInstance();
                    year = calendar.get(Calendar.YEAR);
                    month = calendar.get(Calendar.MONTH);
                    day = calendar.get(Calendar.DAY_OF_MONTH);
                    DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            editText.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                        }
                    },year,month,day);
                    datePickerDialog.show();
            }
        });

        EditText name = findViewById(R.id.ll_name);
        EditText birth = findViewById(R.id.ll_birth);
        EditText username = findViewById(R.id.ll_username);
        EditText email = findViewById(R.id.ll_email);
        EditText number = findViewById(R.id.ll_number);
        EditText password = findViewById(R.id.ll_password);
        EditText confirm = findViewById(R.id.ll_confirm);

        CardView cardView = findViewById(R.id.cv_continue);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isUser = true;

                if (TextUtils.isEmpty(name.getText().toString())){
                    isUser = false;
                    name.setError("Invalid Name");
                }

                if (TextUtils.isEmpty(birth.getText().toString())){
                    isUser = false;
                    Toast.makeText(MainActivity.this, "Empty date", Toast.LENGTH_SHORT).show();
                }

                if (TextUtils.isEmpty(username.getText().toString())){
                    isUser = false;
                    username.setError("Invalid Username");
                }

                if (TextUtils.isEmpty(number.getText().toString())){
                    isUser = false;
                    number.setError("Invalid Number");
                }

                if (TextUtils.isEmpty(password.getText().toString())){
                    isUser = false;
                    password.setError("Invalid Password");
                }

                if (TextUtils.isEmpty(confirm.getText().toString())){
                    isUser = false;
                    confirm.setError("Invalid Confirm Password");
                }

                if (TextUtils.isEmpty(email.getText().toString())){
                    isUser = false;
                    email.setError("Enter your Email");
                }
                else {
                    if (!email.getText().toString().trim().matches(emailpattern)){
                        isUser = false;
                        Toast.makeText(MainActivity.this, "Invalid Email!", Toast.LENGTH_SHORT).show();
                        email.setError("Invalid Email");
                        Toast.makeText(MainActivity.this,birth.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                }

                if (isUser == true){
                    Intent intent = new Intent(MainActivity.this, Sign_in.class);
                    startActivity(intent);
                }
            }
        });

    }
}