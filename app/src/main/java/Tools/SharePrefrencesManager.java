package Tools;

import android.content.Context;
import android.content.SharedPreferences;

import java.security.Key;

public class SharePrefrencesManager {
    private static final String SETTING = "APP_SETTING";
    private static final String TOKEN = "APP_SETTING";

    private static SharedPreferences getSharePrefrence(Context context){
        return context.getSharedPreferences(SETTING, Context.MODE_PRIVATE);
    }

    public static String getToken(Context context){
        return getSharePrefrence(context).getString(TOKEN, "NULL");
    }
    public static void setToken(Context context, String tokenValue){
        SharedPreferences.Editor editor = getSharePrefrence(context).edit();
        editor.putString(TOKEN, tokenValue);
        editor.commit();
    }
}
