package movie.app.com.Interface;

import movie.app.com.model.MoviModel;
import movie.app.com.model.VedioDetails;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by user on 12/10/2018.
 */

public interface RetrofitInterface {
    //
    @GET("upcoming")
    Call<MoviModel> getMovies(@Query("api_key") String api_key,
                                    @Query("language") String language);
    @GET("upcoming")
    Call<VedioDetails> getMoviedetails(@Query("move_id")String moveId,@Query("api_key") String api_key,
                                       @Query("language") String language);
}
