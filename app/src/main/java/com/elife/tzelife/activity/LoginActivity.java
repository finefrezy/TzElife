package com.elife.tzelife.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.elife.tzelife.R;
import com.elife.tzelife.net.RetrofitClient;
import com.elife.tzelife.net.RetrofitService;
import com.elife.tzelife.net.RxJavaApply;

import java.io.IOException;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.edit_name)
    EditText editName;
    @BindView(R.id.linear_name)
    LinearLayout linearName;
    @BindView(R.id.edit_pwd)
    EditText editPwd;
    @BindView(R.id.linear_pwd)
    LinearLayout linearPwd;
    @BindView(R.id.linear_rem)
    LinearLayout linearRem;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.img_line)
    ImageView imgLine;
    @BindView(R.id.forget_pwd)
    TextView forgetPwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbarTitle.setText(R.string.login_text);

    }

    @OnClick({R.id.login, R.id.register, R.id.forget_pwd})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
//                observableType();
                login();
                break;
            case R.id.register:
                break;
            case R.id.forget_pwd:
                break;
        }
    }

    private void login() {

        Subscriber subscriber = new Subscriber<HashMap<String, String>>() {
            @Override
            public void onCompleted() {
                Log.e(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, e.getMessage());
            }

            @Override
            public void onNext(HashMap<String, String> responseBody) {
                Log.e(TAG, "onNext");
                if(!responseBody.get("status").equals("error")) {
                    Intent intent = new Intent();
                    intent.setClass(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, R.string.error_up, Toast.LENGTH_SHORT).show();
                }
            }
        };

        RxJavaApply.getInstance().login(subscriber, editName.getText().toString(), editPwd.getText().toString());
    }

    private void callType() {
                RetrofitService rs = RetrofitClient.getClient();
        Call<ResponseBody> call = rs.loginUser("admin", "admin");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void observableType() {
        RetrofitService rs = RetrofitClient.getClient();
        rs.loginUser1("adminss", "admin").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<ResponseBody>() {
            @Override
            public void onCompleted() {
                Log.e(TAG,"onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG,"onError");
            }

            @Override
            public void onNext(ResponseBody responseBody) {
                try {
                    Log.e(TAG,"onNext->" + responseBody.string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
