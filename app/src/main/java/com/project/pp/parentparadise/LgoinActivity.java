package com.project.pp.parentparadise;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.pp.parentparadise.ppmain.Member;
import com.project.pp.parentparadise.utl.Common;
import com.project.pp.parentparadise.utl.SessionManager;

import java.util.List;


public class LgoinActivity extends AppCompatActivity {
    private final static String TAG = "LgoinActivity";
    private Button btnLogin;
    private Button btnLinkToRegister;
    private EditText inputEmail;
    private EditText inputPassword;
    private ProgressDialog pDialog;
    private SessionManager session;
//    private SQLiteHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lgoin);
        //設定隱藏標題
        getSupportActionBar().hide();
        //設定隱藏狀態
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        findViews();

        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        // Session manager
        session = new SessionManager(getApplicationContext());
        // Check if user is already logged in or not
        if (session.isLoggedIn()) {
            Intent intent = new Intent(LgoinActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        // Login button Click Event
        btnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

                if (!email.isEmpty() && !password.isEmpty()) {
                    checkLogin(email, password);
                    Member loginMember = session.getLoginMemberInfo();
                    List<Member> friends = loginMember.getFriends();
                    Member friend1 = friends.get(0);
                    Member friend2 = friends.get(1);

                    String msg = loginMember.getFirst_name() + "Login OK !" +
                            " friend1 is " + friend1.getFirst_name() +
                            " friend2 is " + friend2.getFirst_name();

                    Toast.makeText(LgoinActivity.this,
                            msg, Toast.LENGTH_LONG)
                            .show();
                } else {
                    Toast.makeText(LgoinActivity.this,
                            "Please enter the email and pasword!", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });

        // Link to Register Screen
        btnLinkToRegister.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(LgoinActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void checkLogin(String email, String password) {
        // TO DO Check WebLogin
        if (Common.networkConnected(this)) {
            String url = Common.URL + "/NewsServlet";
            session.setLogin(true);
//            List<News> newsList = null;
//            try {
//                JsonObject jsonObject = new JsonObject();
//                jsonObject.addProperty("action", "getAll");
//                String jsonOut = jsonObject.toString();
//                newsGetAllTask = new MyTask(url, jsonOut);
//                String jsonIn = newsGetAllTask.execute().get();
//                Log.d(TAG, jsonIn);
//                Gson gson = new Gson();
//                Type listType = new TypeToken<List<News>>(){ }.getType();
//                newsList = gson.fromJson(jsonIn, listType);
//            } catch (Exception e) {
//                Log.e(TAG, e.toString());
//            }
//            if (newsList == null || newsList.isEmpty()) {
//                Common.showToast(getActivity(), R.string.msg_NoNewsFound);
//            } else {
//                rvNews.setAdapter(new NewsRecyclerViewAdapter(getActivity(), newsList));
//            }
//        } else {
//            Common.showToast(getActivity(), R.string.msg_NoNetwork);
        }
    }

    private void findViews() {
        inputEmail = findViewById(R.id.email);
        inputPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);
        btnLinkToRegister = findViewById(R.id.btnLinkToRegisterScreen);
    }
}
