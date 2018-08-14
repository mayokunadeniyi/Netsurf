package com.example.android.netsurf;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.android.netsurf.SharedPrefManager.*;

public class quit extends AppCompatActivity {

    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quit);
    }


    public void displayPopUp(View view) {


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
                logout();
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

    public void logout() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Logging Out...");
        progressDialog.show();

        Call<LogoutResponse> call = ApiClient.getInstance().getApiInterface().logout();
        call.enqueue(new Callback<LogoutResponse>() {
            @Override
            public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {
                progressDialog.dismiss();

                LogoutResponse lr = response.body();
                if (!lr.isError()) {
                    getInstance(getApplicationContext()).clear();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    Toast.makeText(quit.this, lr.getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(quit.this, lr.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LogoutResponse> call, Throwable t) {

            }
        });
    }
}
