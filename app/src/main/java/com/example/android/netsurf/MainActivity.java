package com.example.android.netsurf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText Name;
    public EditText Password;
    public Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.Username);
        Password = (EditText) findViewById(R.id.password);
        Login = (Button) findViewById(R.id.button1);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
    }

    public void validate(String userName, String userPassword) {
        if ((userName.equals("M")) && (userPassword.equals("123"))) {

            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();


        } else if ((userName.equals("Adeniyi.Mayokun")) && (!userPassword.equals("123"))) {
            Toast.makeText(this, "Incorrect Password!", Toast.LENGTH_SHORT).show();

        } else if ((!userName.equals("Adeniyi.Mayokun")) && (userPassword.equals("123"))) {
            Toast.makeText(this, "Incorrect Username", Toast.LENGTH_SHORT).show();
        } else if ((!userName.equals("Adeniyi.Mayokun")) && (!userPassword.equals("123"))) {
            Toast.makeText(this, "Incorrect Username and Password", Toast.LENGTH_SHORT).show();
        }
    }
}
