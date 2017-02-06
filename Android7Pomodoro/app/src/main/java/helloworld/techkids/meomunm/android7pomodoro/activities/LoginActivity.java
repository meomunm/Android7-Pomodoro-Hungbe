package helloworld.techkids.meomunm.android7pomodoro.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import helloworld.techkids.meomunm.android7pomodoro.R;
import helloworld.techkids.meomunm.android7pomodoro.networks.jsonmodel.LoginBodyJson;
import helloworld.techkids.meomunm.android7pomodoro.networks.jsonmodel.LoginResponseJson;
import helloworld.techkids.meomunm.android7pomodoro.networks.jsonmodel.RegisterBodyJson;
import helloworld.techkids.meomunm.android7pomodoro.networks.jsonmodel.RegisterReponseJson;
import helloworld.techkids.meomunm.android7pomodoro.networks.services.LoginService;
import helloworld.techkids.meomunm.android7pomodoro.networks.services.RegisterService;
import helloworld.techkids.meomunm.android7pomodoro.settings.LoginCredentials;
import helloworld.techkids.meomunm.android7pomodoro.settings.SharedPrefs;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";

    private String username;
    private String password;
    private String token;

    EditText etUsername;
    EditText etPassword;
    Button btRegister;
    Button btLogin;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://a-task.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //skipLoginIfPossible();
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        btLogin = (Button) findViewById(R.id.bt_login);
        btRegister = (Button) findViewById(R.id.bt_register);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptLogin();
            }
        });
        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptRegister();
            }
        });
        etPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE){
                    attemptLogin();
                    Log.d(TAG, "onEditorAction: done action");
                    return true;
                }
                return false;
            }
        });
    }

    private void sendLogin(String username, String password) {
        //1. create retrofit


        //2. create service

        LoginService loginService = retrofit.create(LoginService.class);

        //data & format
        //format => mediaType
        //data => Json
        MediaType JsonType = MediaType.parse("application/json");

        String loginJson = (new Gson().toJson(new LoginBodyJson(username, password)));

        RequestBody loginBody = RequestBody.create(JsonType, loginJson);

        //3. create Call là 1 khối hoàn chỉnh đã được lắp đầy đủ các phần với nhau

        Call<LoginResponseJson> loginCall = loginService.login(loginBody);

        loginCall.enqueue(new Callback<LoginResponseJson>() {
            @Override
            public void onResponse(Call<LoginResponseJson> call, Response<LoginResponseJson> response) {
                LoginResponseJson loginResponseJson = response.body();
                if (loginResponseJson == null) {
                    Log.d(TAG, String.format("onResponse login: Could not parse body, code: %s", response.code()));
                    if (response.code() == 401) {
                        Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.d(TAG, String.format("onResponse login, Oh Yeah: %s, code: %s", loginResponseJson, response.code()));
                    if (response.code() == 200) {
                        token = loginResponseJson.getAccessToken();
                        onLoginSuccess();
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginResponseJson> call, Throwable t) {
                Log.d(TAG, String.format("onFailure login: %s", t));
                Toast.makeText(LoginActivity.this, "No internet access", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sendRegister(String username, String password) {
        RegisterService registerService = retrofit.create(RegisterService.class);

        MediaType JsonType = MediaType.parse("application/json");
        final String registerJson = (new Gson()).toJson(new RegisterBodyJson(username, password));
        RequestBody registerBody = RequestBody.create(JsonType, registerJson);

        Call<RegisterReponseJson> callRegister = registerService.register(registerBody);

        callRegister.enqueue(new Callback<RegisterReponseJson>() {
            @Override
            public void onResponse(Call<RegisterReponseJson> call, Response<RegisterReponseJson> response) {
                if (response.code() == 400){
                    Toast.makeText(LoginActivity.this, "User already exists", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, String.format("onResponse register: register fail, code: %s", response.code()));
                }
                if (response.code() == 307){
                    Toast.makeText(LoginActivity.this, "Register success", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, String.format("onResponse register: register success, code: %s", response.code()));
                }
            }

            @Override
            public void onFailure(Call<RegisterReponseJson> call, Throwable t) {
                Log.d(TAG, String.format("onFailure register: %s", t));
                Toast.makeText(LoginActivity.this, "No access internet", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void onLoginSuccess() {
        SharedPrefs.getInstance().put(new LoginCredentials(username, password, token));
        Toast.makeText(this, "Logged in", Toast.LENGTH_SHORT).show();
        gotoTaskActivity();
    }

    private void skipLoginIfPossible() {
        if (SharedPrefs.getInstance().getAccessToken() != null) {
            gotoTaskActivity();
        }
    }

    private void attemptRegister() {
        username = etUsername.getText().toString();
        password = etPassword.getText().toString();

        sendRegister(username, password);
    }

    private void attemptLogin() {
        username = etUsername.getText().toString();
        password = etPassword.getText().toString();

        sendLogin(username, password);
    }

    private void gotoTaskActivity() {
        Intent intent = new Intent(this, TaskActivity.class);
        startActivity(intent);
    }
}
