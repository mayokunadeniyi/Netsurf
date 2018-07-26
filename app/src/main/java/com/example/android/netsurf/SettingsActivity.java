package com.example.android.netsurf;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ImageView view = (ImageView) findViewById(R.id.cancelimg5);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        myDialog = new Dialog(this);
    }

    public void showPopUp(View v){
        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menusettings);
        popup.show();

    }

    public void displayPopUp(View view){
        TextView txtclose;
        Button bntflow1;
        Button bntflow2;
        myDialog.setContentView(R.layout.activity_popup);

        txtclose = (TextView) myDialog.findViewById(R.id.textcloser);
        bntflow1 = (Button) myDialog.findViewById(R.id.nobutt);
        bntflow2 = (Button) myDialog.findViewById(R.id.yesbutt);

        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        bntflow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
                Toast.makeText(SettingsActivity.this,"Okay then!",Toast.LENGTH_SHORT).show();
            }
        });
        bntflow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SettingsActivity.this,"Logging Out!",Toast.LENGTH_SHORT).show();
                Intent mainIntent = new Intent(SettingsActivity.this, MainActivity.class);
                startActivity(mainIntent);
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        myDialog.show();



    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Intent mainIntent1 = new Intent(this, SettingsActivity.class);
                startActivity(mainIntent1);
            default:
                return false;

        }
    }
}
