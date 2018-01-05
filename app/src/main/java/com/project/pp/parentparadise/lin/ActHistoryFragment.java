package com.project.pp.parentparadise.lin;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.project.pp.parentparadise.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ActHistoryFragment extends Fragment {


    View view;
    public ActHistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_activities_history, container, false);

        ListView lvHistoryList = (ListView) view.findViewById(R.id.lvHistoryList);
        List<ActHistoryList> historyList = getHistoryList();
        lvHistoryList.setAdapter(new ActHistoryFragment.HistoryAdapter(getActivity(), historyList));

        return view;
    }

    private class HistoryAdapter extends BaseAdapter {
        Context context;
        List<ActHistoryList> historyList;

        HistoryAdapter(Context context, List<ActHistoryList> historyList) {
            this.context = context;
            this.historyList = historyList;
        }

        @Override
        public int getCount() {
            return historyList.size();
        }

        @Override
        public View getView(int position, View itemView, ViewGroup parent) {
            if (itemView == null) {
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                itemView = layoutInflater.inflate(R.layout.activity_item_view, parent, false);
            }



            ActHistoryList activitiesHistoryList = historyList.get(position);
            ImageView ivActivitiesImage = (ImageView) itemView
                    .findViewById(R.id.ivActivitiesImage);
            ivActivitiesImage.setImageResource(activitiesHistoryList.getImage());

            LinearLayout llTitle = (LinearLayout)itemView
                    .findViewById(R.id.llTitle);
            llTitle.setVisibility(View.GONE);

            TextView tvTitle = (TextView) itemView
                    .findViewById(R.id.tvTitle);
            tvTitle.setText(activitiesHistoryList.getTitle());

            Button btLike = (Button) itemView
                    .findViewById(R.id.btLike);
            //btLike.setText(activitiesWatchList.getTitle());

            TextView tvLike = (TextView) itemView
                    .findViewById(R.id.tvLike);
            tvLike.setText(String.valueOf(activitiesHistoryList.getLike()));

            Button btWatch = (Button) itemView
                    .findViewById(R.id.btWatch);
            //btLike.setText(activitiesWatchList.getTitle());

            TextView tvWatch = (TextView) itemView
                    .findViewById(R.id.tvWatch);
            tvWatch.setText(String.valueOf(activitiesHistoryList.getWatch()));

            Button btMsg = (Button) itemView
                    .findViewById(R.id.btMsg);
            //btLike.setText(activitiesWatchList.getTitle());

            TextView tvMsg = (TextView) itemView
                    .findViewById(R.id.tvMsg);
            tvMsg.setText(String.valueOf(activitiesHistoryList.getMsg()));

            Button btRegister = (Button) itemView
                    .findViewById(R.id.btRegister);


            return itemView;
        }

        @Override
        public Object getItem(int position) {
            return historyList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return historyList.get(position).getImage();
        }
    }

    private List<ActHistoryList> getHistoryList() {
        List<ActHistoryList> historyList = new ArrayList<>();
        historyList.add(new ActHistoryList(R.drawable.lin_test01, "2018 小騎士馬術冬令營 - 小牛仔也很忙！", 10, 20,30));
        historyList.add(new ActHistoryList(R.drawable.lin_test01, "2030 小騎士馬術冬令營 - 小牛仔也很忙！", 1, 7,122));
        historyList.add(new ActHistoryList(R.drawable.lin_test01, "2040 小騎士馬術冬令營 - 小牛仔也很忙！", 5, 0,14));
        historyList.add(new ActHistoryList(R.drawable.lin_test01, "2018 小騎士馬術冬令營 - 小牛仔也很忙！", 10, 20,30));
        historyList.add(new ActHistoryList(R.drawable.lin_test01, "2030 小騎士馬術冬令營 - 小牛仔也很忙！", 1, 7,122));
        historyList.add(new ActHistoryList(R.drawable.lin_test01, "2018 小騎士馬術冬令營 - 小牛仔也很忙！", 10, 20,30));
        historyList.add(new ActHistoryList(R.drawable.lin_test01, "2030 小騎士馬術冬令營 - 小牛仔也很忙！", 1, 7,122));
        historyList.add(new ActHistoryList(R.drawable.lin_test01, "2040 小騎士馬術冬令營 - 小牛仔也很忙！", 5, 0,14));
        historyList.add(new ActHistoryList(R.drawable.lin_test01, "2018 小騎士馬術冬令營 - 小牛仔也很忙！", 10, 20,30));
        historyList.add(new ActHistoryList(R.drawable.lin_test01, "2030 小騎士馬術冬令營 - 小牛仔也很忙！", 1, 7,122));

        return historyList;
    }

}
