package com.example.rodolfo.materialdesign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.rodolfo.materialdesign.API.ApiClient;
import com.example.rodolfo.materialdesign.API.ApiInterface;
import com.example.rodolfo.materialdesign.Models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by rodolfo on 18/03/17.
 */

public class UserActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
    }

    protected User loadUserData(){
        final User[] user = {new User()};

        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<User> call = apiInterface.getUserData("rodolfo");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    user[0] = response.body();
                }
                else {
                    String message = "Codigo: "+response.code()+
                                     " Respuesta: "+response.errorBody();

                    Toast.makeText(UserActivity.this, message, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                call.cancel();
            }
        });

        return user[0];
    }
}
