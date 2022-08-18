package com.github.precofipeapp.api.endpoint;

import com.github.precofipeapp.api.model.Marcas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MarcasEndpoint {

    @GET("carros/marcas")
    Call<List<Marcas>> getMarcas();
}
