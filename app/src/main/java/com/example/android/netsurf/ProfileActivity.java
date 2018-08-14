package com.example.android.netsurf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.android.netsurf.SharedPrefManager.*;

public class ProfileActivity extends AppCompatActivity {

    private TextView USERNAME;
    private TextView NAME;
    private TextView EMAIL;
    private TextView MATNUM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        USERNAME = findViewById(R.id.username);
        NAME = findViewById(R.id.name);
        EMAIL = findViewById(R.id.email);
        MATNUM = findViewById(R.id.matnum);

        User user = getInstance(getApplicationContext()).getUser();

        USERNAME.setText(user.getUsername());
        EMAIL.setText(user.getEmail());
        NAME.setText(user.getName());
        MATNUM.setText(user.getMatnum());

        Button closeButton = (Button) findViewById(R.id.closeprofile);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
