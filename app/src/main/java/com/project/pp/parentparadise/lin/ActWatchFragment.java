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
public class ActWatchFragment extends Fragment {


    public ActWatchFragment() {
        // Required empty public constructor
    }
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_activities_watch, container, false);

        ListView lvWatchList = (ListView) view.findViewById(R.id.lvWatchList);
        List<ActivitiesWatchList> watchList = getWatchList();
        lvWatchList.setAdapter(new WatchAdapter(getActivity(), watchList));

        return view;
    }

    private class WatchAdapter extends BaseAdapter {
        Context context;
        List<ActivitiesWatchList> watchList;

        WatchAdapter(Context context, List<ActivitiesWatchList> watchList) {
            this.context = context;
            this.watchList = watchList;
        }

        @Override
        public int getCount() {
            return watchList.size();
        }

        @Override
        public View getView(int position, View itemView, ViewGroup parent) {
            if (itemView == null) {
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                itemView = layoutInflater.inflate(R.layout.activity_item_view, parent, false);
            }



            ActivitiesWatchList activitiesWatchList = watchList.get(position);
            ImageView ivActivitiesImage = (ImageView) itemView
                    .findViewById(R.id.ivActivitiesImage);
            ivActivitiesImage.setImageResource(activitiesWatchList.getImage());

            LinearLayout llTitle = (LinearLayout)itemView
                    .findViewById(R.id.llTitle);
            llTitle.setVisibility(View.GONE);

            TextView tvTitle = (TextView) itemView
                    .findViewById(R.id.tvTitle);
            tvTitle.setText(activitiesWatchList.getTitle());

            Button btLike = (Button) itemView
                    .findViewById(R.id.btLike);
            //btLike.setText(activitiesWatchList.getTitle());

            TextView tvLike = (TextView) itemView
                    .findViewById(R.id.tvLike);
            tvLike.setText(String.valueOf(activitiesWatchList.getLike()));

            Button btWatch = (Button) itemView
                    .findViewById(R.id.btWatch);
            //btLike.setText(activitiesWatchList.getTitle());

            TextView tvWatch = (TextView) itemView
                    .findViewById(R.id.tvWatch);
            tvWatch.setText(String.valueOf(activitiesWatchList.getWatch()));

            Button btMsg = (Button) itemView
                    .findViewById(R.id.btMsg);
            //btLike.setText(activitiesWatchList.getTitle());

            TextView tvMsg = (TextView) itemView
                    .findViewById(R.id.tvMsg);
            tvMsg.setText(String.valueOf(activitiesWatchList.getMsg()));

            Button btRegister = (Button) itemView
                    .findViewById(R.id.btRegister);


            return itemView;
        }

        @Override
        public Object getItem(int position) {
            return watchList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return watchList.get(position).getImage();
        }
    }

    private List<ActivitiesWatchList> getWatchList() {
        List<ActivitiesWatchList> watchList = new ArrayList<>();
        watchList.add(new ActivitiesWatchList(R.drawable.lin_test01, "2018 小騎士馬術冬令營 - 小牛仔也很忙！", 10, 20,30));
        watchList.add(new ActivitiesWatchList(R.drawable.lin_test01, "2030 小騎士馬術冬令營 - 小牛仔也很忙！", 1, 7,122));
        watchList.add(new ActivitiesWatchList(R.drawable.lin_test01, "2040 小騎士馬術冬令營 - 小牛仔也很忙！", 5, 0,14));
        return watchList;
    }

}
