package com.example.android.netsurf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class ShareDataActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_data);

        ImageView view = (ImageView) findViewById(R.id.cancelimg3);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShareDataActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        }
    public void showPopUp(View v){
        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Intent mainIntent1 = new Intent(this, SettingsActivity.class);
                startActivity(mainIntent1);
            case R.id.item2:
                Intent mainIntent2 = new Intent(this, SettingsActivity.class);
                startActivity(mainIntent2);
            default:
                return false;

        }
    }


}
