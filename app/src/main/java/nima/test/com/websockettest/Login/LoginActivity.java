package nima.test.com.websockettest.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import nima.test.com.websockettest.Main.MainActivity;
import nima.test.com.websockettest.R;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener{

    private EditText username, password;
    private Button submitBtn;
    private ProgressBar progressBar;

    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initWidget();

        presenter = new LoginPresenterLmpl(this, new LoginIntractorLmpl());
    }

    @Override
    public void setUsernameError() {
        Toast.makeText(this, "Username is wrong", Toast.LENGTH_SHORT).show();
        hideProgressBar();
    }

    @Override
    public void setPasswordError() {
        Toast.makeText(this, "Password is wrong", Toast.LENGTH_SHORT).show();
        hideProgressBar();
    }

    @Override
    public void success() {

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        hideProgressBar();
    }

    @Override
    public void networkFaield() {
        Toast.makeText(this, "OOOpps, Can not access to network", Toast.LENGTH_SHORT).show();
        hideProgressBar();
    }

    public void displayProgressBar() {
//        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgressBar() {
//        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {

        Log.e("State", "Clicked");

        presenter.validate(LoginActivity.this, username.getText().toString(), password.getText().toString());
        displayProgressBar();
    }

    private void initWidget(){

        username = (EditText) findViewById(R.id.loginUsernameEd);
        password = (EditText) findViewById(R.id.loginPasswordEd);

        progressBar = (ProgressBar) findViewById(R.id.loginProgressBar);

        submitBtn = (Button) findViewById(R.id.loginSubmit);
        submitBtn.setOnClickListener(this);

        progressBar.setVisibility(View.GONE);

    }
}
