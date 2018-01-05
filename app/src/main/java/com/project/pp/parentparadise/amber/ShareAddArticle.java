package com.project.pp.parentparadise.amber;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.project.pp.parentparadise.R;

import static android.view.WindowManager.*;

/**
 * Created by amberyang on 2017/12/7.
 */

public class ShareAddArticle extends AppCompatActivity {

    private Spinner spClassify1, spClassify2;
    private Button btScan, btTake, btPick;
    private EditText etAddIsbn;
    LinearLayout llActMain, llActSub, llBookData;
    ScrollView svAddArticle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_add_article_main);
        setTitle("新增分享文章");
        getWindow().setSoftInputMode(LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        findviews();
        initContent2();
        initContent1();
    }

    private void findviews() {
        spClassify1 = findViewById(R.id.spClassify1);
        spClassify2 = findViewById(R.id.spClassify2);
        btScan = findViewById(R.id.btScan);
        btTake = findViewById(R.id.btTake);
        btPick = findViewById(R.id.btPick);
        etAddIsbn = findViewById(R.id.etAddIsbn);
        llActMain = findViewById(R.id.llActMain);
        llActSub = findViewById(R.id.llActSub);
        llBookData = findViewById(R.id.llBookData);
        svAddArticle = findViewById(R.id.svAddArticle);

        spClassify1.setSelection(0, true);
        spClassify1.setOnItemSelectedListener(spListener1);

        spClassify2.setSelection(0, true);
        spClassify2.setOnItemSelectedListener(spListener2);
    }

    private void initContent1() {
        llActSub.setVisibility(View.GONE);
        llBookData.setVisibility(View.GONE);
        svAddArticle.setVisibility(View.GONE);
    }

    Spinner.OnItemSelectedListener spListener1 = new Spinner.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            switch (pos) {
                case 0:
                    initContent1();
                    break;
                case 1:
                    initContent1();
                    svAddArticle.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    initContent1();
                    initContent2();
                    llActSub.setVisibility(View.VISIBLE);
                    break;
                case 3:
                    initContent1();
                    llBookData.setVisibility(View.VISIBLE);
                    btScan.setVisibility(View.VISIBLE);
                    svAddArticle.setVisibility(View.VISIBLE);
                    break;
                case 4:
                    initContent1();
                    svAddArticle.setVisibility(View.VISIBLE);
                    break;
                case 5:
                    initContent1();
                    svAddArticle.setVisibility(View.VISIBLE);
                    break;
                default:
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    };

    private void initContent2() {
        btScan.setVisibility(View.GONE);
        svAddArticle.setVisibility(View.GONE);
    }
    Spinner.OnItemSelectedListener spListener2 = new Spinner.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            switch (pos) {
                case 0:
                    initContent2();
                    break;
                default:
                    llBookData.setVisibility(View.GONE);
                    svAddArticle.setVisibility(View.VISIBLE);
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    };


    public void OnScanClick(View view) {

        IntentIntegrator integrator = new IntentIntegrator(this);
        // Set to true to enable saving the barcode image and sending its path in the result Intent.
        integrator.setBarcodeImageEnabled(true);
        // Set to false to disable beep on scan.
        integrator.setBeepEnabled(false);
        //後鏡頭0  前鏡頭1
        integrator.setCameraId(0);
        // By default, the orientation is locked. Set to false to not lock.
        integrator.setOrientationLocked(false);
        // Set a prompt to display on the capture screen.
        integrator.setPrompt("請掃描條碼或QRcode");
        // Initiates a scan
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("qrcode", "onActivityResult");

        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (intentResult != null && intentResult.getContents() != null) {
            Log.d("qrcode", "intentResult.getContents() = " + intentResult.getContents());

            etAddIsbn.setText(intentResult.getContents());
        } else {
            etAddIsbn.setText("Result Not Found");
        }
    }














}

