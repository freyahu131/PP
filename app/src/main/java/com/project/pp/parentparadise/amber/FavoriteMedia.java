package com.project.pp.parentparadise.amber;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.pp.parentparadise.MainActivity;
import com.project.pp.parentparadise.R;

public class FavoriteMedia extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_recyclerview_main);
        setSubTitle();
    }

    private void setSubTitle() {
        TextView tvSubTitle = findViewById(R.id.tvSubTitle);
        tvSubTitle.setText("影音");
        ImageView ivFLogo = findViewById(R.id.ivFLogo);
        ivFLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FavoriteMedia.this, MainActivity.class);
                intent.putExtra("id",1);
                startActivity(intent);
            }
        });
    }
}
