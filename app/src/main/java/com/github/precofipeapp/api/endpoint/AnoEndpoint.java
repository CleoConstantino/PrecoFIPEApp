package com.github.precofipeapp.api.endpoint;

import com.github.precofipeapp.api.model.Anos;
import com.github.precofipeapp.api.model.Modelos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AnoEndpoint {

    @GET("carros/marcas/{codigo}/modelos/{codigo_modelo}/anos")
    Call<List<Anos>> getAnos(@Path("codigo") int codigo, @Path("codigo_modelo") int codigo_modelo);
}
