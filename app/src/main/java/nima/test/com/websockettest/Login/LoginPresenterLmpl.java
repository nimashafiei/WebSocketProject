package nima.test.com.websockettest.Login;

import android.content.Context;

public class LoginPresenterLmpl implements LoginPresenter, LoginIntractor.LoginStateListiner {

    LoginView mView;
    LoginIntractor mIntractor;

    public LoginPresenterLmpl(LoginView view, LoginIntractor intractor){
        this.mView = view;
        this.mIntractor = intractor;
    }

    @Override
    public void validate(Context context, String username, String password) {
        mIntractor.validate(context, username, password, this);
    }

    @Override
    public void onSuccess() {
        mView.success();
    }

    @Override
    public void onUsernameError() {
        mView.setUsernameError();
    }

    @Override
    public void onPasswordError() {
        mView.setPasswordError();
    }

    @Override
    public void onNetworkError() {
        mView.networkFaield();
    }
}
