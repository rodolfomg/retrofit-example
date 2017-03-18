package com.example.rodolfo.materialdesign.API;

/**
 * Created by rodolfo on 11/03/17.
 */

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "http://192.168.15.7:8888/api/";                // Nuestro server con nuestra API
    private static Retrofit retrofit = null;                                    // Objeto retrofit para las conexiones

    public static Retrofit getClient() {
        if (retrofit == null){                                                  // Nos aseguramos que no se haya creado un objeto retrofit
            retrofit = new Retrofit.Builder()                                   // Inicializamos el objeto Retrofit
                        .baseUrl(BASE_URL)                                      // Indicamos a cual sitio se estará conectando
                        .addConverterFactory(GsonConverterFactory.create())     // Indicamos cual será nuestro serializador y deserializador de objetos (JSON)
                        .build();                                               // Construimos el objeto
        }
        return retrofit;
    }

}
