package com.example.exa_final.Apis;

import com.example.exa_final.Responseproducto;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductoService {

    @GET("products.json")
    public Call<Responseproducto> getProductos();
}
