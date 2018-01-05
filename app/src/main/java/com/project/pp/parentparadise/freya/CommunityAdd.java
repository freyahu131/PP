package com.project.pp.parentparadise.freya;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.pp.parentparadise.R;
import com.project.pp.parentparadise.ppmain.Member;
import com.project.pp.parentparadise.utl.SessionManager;

public class CommunityAdd extends Activity {

    private static final String TAG = "MainActivity";
    private EditText searchId;
    private Button btSubmit;
    private SessionManager session;
    public View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_community_add);
////        searchId = view.findViewById(R.id.searchId);
////        btSubmit = view.findViewById(R.id.btSubmit);
         findView();
//
        btSubmit.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {


                                      session = new SessionManager(getApplicationContext());

                                            String accCode = searchId.getText().toString().trim();
                                            Member member = new Member();
                                            member = member.getMemberInfo(accCode);

                                            if (accCode != null) {
                                                Toast.makeText(CommunityAdd.this,
                                                        R.string.text_Name,
                                                        Toast.LENGTH_SHORT).show();
                                            } else {
                                                Toast.makeText(CommunityAdd.this,
                                                        "No member info !",
                                                        Toast.LENGTH_SHORT).show();
                                            }



        }});
        }
    public void findView(){

         searchId = findViewById(R.id.searchId);
         btSubmit = findViewById(R.id.btSubmit);
   }



}
