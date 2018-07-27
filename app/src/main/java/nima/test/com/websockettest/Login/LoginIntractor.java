package nima.test.com.websockettest.Login;

import android.content.Context;

public interface LoginIntractor {

    void validate(Context context, String username, String password, LoginStateListiner stateListiner);

    public interface LoginStateListiner{
        void onSuccess();
        void onUsernameError();
        void onPasswordError();
        void onNetworkError();
    }
}
