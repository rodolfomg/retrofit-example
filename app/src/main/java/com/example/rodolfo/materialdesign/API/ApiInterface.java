package com.example.rodolfo.materialdesign.API;

/**
 * Created by rodolfo on 11/03/17.
 */

import com.example.rodolfo.materialdesign.Models.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("{username}/{password}")                                       // Indicamos el tipo de conexion y la ruta a la que nos conectaremos
    Call<String> loginValidation(@Path("username") String username,     // Sustituye la variable username en el Path del GET
                                 @Path("password") String password);    // Sustituye la variable password en el Path del GET

    @GET("{username}")
    Call<User> getUserData(@Path("username") String username);
}
