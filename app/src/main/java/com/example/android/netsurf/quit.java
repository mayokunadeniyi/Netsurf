package com.example.android.netsurf;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class quit extends AppCompatActivity {

    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quit);
    }


    public void displayPopUp(View view){



        myDialog.setContentView(R.layout.activity_quit);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        myDialog.show();



    }

    public void closer1(View view) {
        TextView txtclose;
        txtclose = (TextView) myDialog.findViewById(R.id.textcloser1);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
    }

    public void yes1(View view) {
        Button bntflow2;
        bntflow2 = (Button) myDialog.findViewById(R.id.yesbutt1);



        bntflow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }

    public void no1(View view) {
        Button bntflow1;
        bntflow1 = (Button) myDialog.findViewById(R.id.nobutt1);
        bntflow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
    }
}
