package movie.app.com.Presenter;

import android.content.Context;
import android.graphics.Color;

import java.util.HashMap;

import cc.cloudist.acplibrary.ACProgressConstant;
import cc.cloudist.acplibrary.ACProgressFlower;
import movie.app.com.ConstantClasss.Constanturl;
import movie.app.com.Interface.Movview;
import movie.app.com.Interface.RetrofitInterface;
import movie.app.com.model.MoviModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by user on 16/07/2018.
 */

public class MoviesPresenter {
    Movview view;
    Context context;
    ACProgressFlower dialog;
    public MoviesPresenter(Movview view, Context context){
        this.view=view;
        this.context=context;
    }
    public void getMovies() {
            dialog =  new ACProgressFlower.Builder(context)
                    .direction(ACProgressConstant.DIRECT_CLOCKWISE)
                    .themeColor(Color.WHITE)
                    .fadeColor(Color.DKGRAY).build();

        dialog.show();

        HashMap input=new HashMap();
        input.put("", "");
        // Log.e("inpp", input + "");
        Constanturl.createService(RetrofitInterface.class).getMovies("f68538dfc50740a2285e4c22f5205d66","en-US").enqueue(new Callback<MoviModel>() {
            @Override
            public void onResponse(Call<MoviModel> call, Response<MoviModel> response) {
                if (dialog.isShowing())
                    dialog.dismiss();
                if (response.isSuccessful()) {
                    MoviModel model = response.body();
                    view.getMovies(model.getResults());
                   // contactview.getContacts(model.getAbout());
                    // view.getProductdetails(model.getService());


                } else {

                }

            }

            @Override
            public void onFailure(Call<MoviModel> call, Throwable t) {
                if (dialog.isShowing())
                    dialog.dismiss();
            }
        });
    }

}
