package nima.test.com.websockettest.Login;

public interface LoginView {

    void setUsernameError();
    void setPasswordError();

    void success();
    void networkFaield();

}
