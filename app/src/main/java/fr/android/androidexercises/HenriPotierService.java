package fr.android.androidexercises;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public interface HenriPotierService {

    // TODO Method GET books which return a List<Book>
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://henri-potier.xebia.fr/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    HenriPotierService service = retrofit.create(HenriPotierService.class);

}
