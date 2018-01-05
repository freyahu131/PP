package com.project.pp.parentparadise.amber;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.pp.parentparadise.MainActivity;
import com.project.pp.parentparadise.R;

public class FavoriteAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_recyclerview_main);
        setTitle("我的收藏");
        //setSubTitle();
        //getSupportActionBar().hide();
    }

    private void setSubTitle() {
        TextView tvSubTitle = findViewById(R.id.tvSubTitle);
        tvSubTitle.setText("親子活動");
        ImageView ivFLogo = findViewById(R.id.ivFLogo);
        ivFLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FavoriteAct.this, MainActivity.class);
                intent.putExtra("id",1);
                startActivity(intent);
            }
        });
    }


}
