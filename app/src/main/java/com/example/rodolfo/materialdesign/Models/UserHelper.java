package com.example.rodolfo.materialdesign.Models;

import android.util.Log;
import android.widget.Toast;

import com.example.rodolfo.materialdesign.API.ApiClient;
import com.example.rodolfo.materialdesign.API.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static java.security.AccessController.getContext;

/**
 * Created by rodolfo on 25/09/17.
 */

public class UserHelper {
    User user;

    public User getUserByUsername(String username) {
        // 1. RETRO + INTERFACE
        Retrofit api = ApiClient.getClient();
        ApiInterface apiInterface = api.create(ApiInterface.class);

        // 2. CREAR CALL
        Call<User> call = apiInterface.getUserData(username);

        // 3. COLOCAR EN LA COLA (QUEUE)
        call.enqueue(

                // 4. LLAMADA A LA API

                // 5. CALLBACK
                new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response){
                        if(response.isSuccessful()){
                            user = response.body();
                        }
                        else {
                            String message = "Error code: " + response.code() +
                                             ", " + response.errorBody();

                            Log.d("CONECTION",message);
                        }

                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t){
                        call.cancel();
                    }
                }
        );

        return user;
    }



}
