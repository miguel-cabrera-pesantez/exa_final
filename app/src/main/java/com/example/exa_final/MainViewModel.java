package com.example.exa_final;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.exa_final.Apis.ProductoService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainViewModel extends ViewModel {

    private static MutableLiveData<List<Product>> producto_list = new MutableLiveData<>();

    public LiveData<List<Product>> getProducto() {
        return producto_list;
    }

    public void listarproductos(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://fipo.equisd.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ProductoService service=retrofit.create(ProductoService.class);
        Call<Responseproducto> call= service.getProductos();
        call.enqueue(new Callback<Responseproducto>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<Responseproducto> call, Response<Responseproducto> response) {
                if (!response.isSuccessful()){
                    Log.e("Response err: ",response.message());
                    return;
                }

                Responseproducto rp= response.body();
                producto_list.setValue(rp.getObjects());
                System.out.println("EXITO");
            }

            @Override
            public void onFailure(Call<Responseproducto> call, Throwable t) {
                System.out.println("Fallo");
                System.out.println(t.getMessage());

            }
        });
    }
}


