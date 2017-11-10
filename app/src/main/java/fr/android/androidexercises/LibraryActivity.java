package fr.android.androidexercises;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        // Plant logger cf. Android Timber
        Timber.plant(new Timber.DebugTree());

        // TODO build Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http:/henri-potier.xebia.fr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HenriPotierService service = retrofit.create(HenriPotierService.class);

        service.getBooks().enqueue(new Callback<List<Book>>()) {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response){
                for(Book book : response.body()){
                    Log.d("lol", book.getTitle());
                }
            }
        }
        // TODO create a service

        // TODO listBooks()

        // TODO enqueue call and display book title

        // TODO log books

        // TODO display book as a list
    }

}
