package movie.app.com.ConstantClasss;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by asmaa.mostafa on 05/04/2017.
 */
public class Checkinternet {
    public static Context mContext;

    public Checkinternet(Context mContext) {
        this.mContext = mContext;
    }

    public static boolean isNetworkConnected() {
        try {
            ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);

            return cm.getActiveNetworkInfo() != null;
        } catch (Exception e) {
            return false;
        }

    }
}
