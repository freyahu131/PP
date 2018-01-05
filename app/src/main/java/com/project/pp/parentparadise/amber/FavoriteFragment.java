package com.project.pp.parentparadise.amber;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.project.pp.parentparadise.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {
    private static final String TAG = "FavoriteFragment";
    private PieChart pieChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.favorite_main, container, false);
        pieChart = view.findViewById(R.id.pieChart);

        /* 設定可否旋轉 */
        pieChart.setRotationEnabled(true);

        /* 設定圓心文字 */
        pieChart.setCenterText("我的收藏");
        /* 設定圓心文字大小 */
        pieChart.setCenterTextSize(25);
        Description description = new Description();
        description.setText("");
        description.setTextSize(25);
        pieChart.setDescription(description);

        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry entry, Highlight highlight) {
                PieEntry pieEntry = (PieEntry) entry;
                String text = pieEntry.getLabel();
                Intent intent;

                switch (text){
                    case "甜蜜家庭":
                        intent = new Intent(getActivity(), FavoriteSweet.class);
                        startActivity(intent);
                        break;
                    case "親子活動":
                        intent = new Intent(getActivity(), FavoriteAct.class);
                        startActivity(intent);
                        break;
                    case "閱讀":
                        intent = new Intent(getActivity(), FavoriteBook.class);
                        startActivity(intent);
                        break;
                    case "影音":
                        intent = new Intent(getActivity(), FavoriteMedia.class);
                        startActivity(intent);
                        break;
                    case "生活":
                        intent = new Intent(getActivity(), FavoriteLife.class);
                        startActivity(intent);
                        break;
                }

            }

            @Override
            public void onNothingSelected() {

            }
        });

        /* 取得各類別收藏資料 */
        List<PieEntry> pieEntries = getFavoriteEntries();

        PieDataSet pieDataSet = new PieDataSet(pieEntries,"");
        pieDataSet.setValueTextColor(Color.BLUE);
        pieDataSet.setValueTextSize(20);
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(20);

        /* 使用官訂顏色範本，顏色不能超過5種，否則官定範本要加顏色 */
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
        return view;
    }


    private List<PieEntry> getFavoriteEntries() {
        List<PieEntry> favoriteEntries = new ArrayList<>();
        favoriteEntries.add(new PieEntry(29, "甜蜜家庭"));
        favoriteEntries.add(new PieEntry(35, "親子活動"));
        favoriteEntries.add(new PieEntry(68, "閱讀"));
        favoriteEntries.add(new PieEntry(25, "影音"));
        favoriteEntries.add(new PieEntry(22, "生活"));
        return favoriteEntries;
    }

}