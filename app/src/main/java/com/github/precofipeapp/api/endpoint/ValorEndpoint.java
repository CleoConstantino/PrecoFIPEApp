package com.github.precofipeapp.api.endpoint;

import com.github.precofipeapp.api.model.Anos;
import com.github.precofipeapp.api.model.Valor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ValorEndpoint {

    @GET("carros/marcas/{codigo}/modelos/{codigo_modelo}/anos/{codigo_ano}")
    Call<Valor> getValor(@Path("codigo") int codigo, @Path("codigo_modelo") int codigo_modelo, @Path("codigo_ano") String codigo_ano);
}
