package com.example.android.netsurf;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.android.netsurf.SharedPrefManager.*;


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
                login();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(getInstance(this).isLoggedIn()){
            Intent intent = new Intent(this, HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    private  void login(){
        final ProgressDialog progressDialog= new ProgressDialog(this);
        progressDialog.setMessage("Logging In...");
        progressDialog.show();

        String details = Name.getText().toString().trim();
        String password = Password.getText().toString().trim();

        Call<LoginResponse> call = ApiClient.getInstance().getApiInterface().login(details, password);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                progressDialog.dismiss();

                LoginResponse lr = response.body();
                    if(!lr.isError()) {
                        getInstance(getApplicationContext()).login(lr.getUser());
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        Toast.makeText(MainActivity.this, lr.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    else{
                       Toast.makeText(MainActivity.this, lr.getMessage(), Toast.LENGTH_SHORT).show();
                    }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }

}
