package fcercle;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface BookService {

    @GET("books")
    Call<List<Book>> listBooks();

}
