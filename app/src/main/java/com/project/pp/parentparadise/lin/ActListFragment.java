package com.project.pp.parentparadise.lin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
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


public class ActListFragment extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_activities_list, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(
                new StaggeredGridLayoutManager(
                        1, StaggeredGridLayoutManager.HORIZONTAL));
        List<ActRecommend> activitiesRecommendList = getActivitiesRecommend();
        recyclerView.setAdapter(new ActivitiesRecommendAdapter(getActivity(), activitiesRecommendList));

        ListView lvList = (ListView) view.findViewById(R.id.lvList);
        List<ActOurdoor> activitiesOurdoorList = getActivitiesOurdoorList();
        lvList.setAdapter(new ActivitiesOurdoorAdapter(getActivity(), activitiesOurdoorList));

        Button btSearch = view.findViewById(R.id.btSearch);

        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ActSearchActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private class ActivitiesRecommendAdapter extends
            RecyclerView.Adapter<ActivitiesRecommendAdapter.MyViewHolder> {
        private Context context;
        private List<ActRecommend> activitiesRecommendList;

        ActivitiesRecommendAdapter(Context context, List<ActRecommend> activitiesRecommendList) {
            this.context = context;
            this.activitiesRecommendList = activitiesRecommendList;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView ivActivitiesRecommendImage;
            TextView tvRecommendTitle;

            MyViewHolder(View itemView) {
                super(itemView);
                ivActivitiesRecommendImage = (ImageView) itemView.findViewById(R.id.ivActivitiesRecommendImage);
                tvRecommendTitle = (TextView) itemView.findViewById(R.id.tvRecommendTitle);
            }
        }

        @Override
        public int getItemCount() {
            return activitiesRecommendList.size();
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View itemView = layoutInflater.inflate(R.layout.activity_recommend_item_view, viewGroup, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder viewHolder, int position) {
            final ActRecommend activitiesRecommend = activitiesRecommendList.get(position);
            viewHolder.ivActivitiesRecommendImage.setImageResource(activitiesRecommend.getImage());
            viewHolder.tvRecommendTitle.setText(activitiesRecommend.getTitle());

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

    private List<ActRecommend> getActivitiesRecommend() {
        List<ActRecommend> activitiesRecommendList = new ArrayList<>();
        activitiesRecommendList.add(new ActRecommend(R.drawable.lin_test01, "2018 小騎士馬術冬令營 - 小牛仔也很忙！"));
        activitiesRecommendList.add(new ActRecommend(R.drawable.lin_test01, "2018 小騎士馬術冬令營 - 小牛仔也很忙！"));
        activitiesRecommendList.add(new ActRecommend(R.drawable.lin_test01, "2018 小騎士馬術冬令營 - 小牛仔也很忙！"));
        activitiesRecommendList.add(new ActRecommend(R.drawable.lin_test01, "2018 小騎士馬術冬令營 - 小牛仔也很忙！"));
        activitiesRecommendList.add(new ActRecommend(R.drawable.lin_test01, "2018 小騎士馬術冬令營 - 小牛仔也很忙！"));
        activitiesRecommendList.add(new ActRecommend(R.drawable.lin_test01, "2018 小騎士馬術冬令營 - 小牛仔也很忙！"));
        activitiesRecommendList.add(new ActRecommend(R.drawable.lin_test01, "2018 小騎士馬術冬令營 - 小牛仔也很忙！"));

        return activitiesRecommendList;
    }

    private class ActivitiesOurdoorAdapter extends BaseAdapter {
        Context context;
        List<ActOurdoor> activitiesOurdoorList;

        ActivitiesOurdoorAdapter(Context context, List<ActOurdoor> activitiesOurdoorList) {
            this.context = context;
            this.activitiesOurdoorList = activitiesOurdoorList;
        }

        @Override
        public int getCount() {
            return activitiesOurdoorList.size();
        }

        @Override
        public View getView(int position, View itemView, final ViewGroup parent) {
            if (itemView == null) {
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                itemView = layoutInflater.inflate(R.layout.activity_item_view, parent, false);
            }



            ActOurdoor activitiesOurdoor = activitiesOurdoorList.get(position);
            ImageView ivActivitiesImage = (ImageView) itemView
                    .findViewById(R.id.ivActivitiesImage);
            ivActivitiesImage.setImageResource(activitiesOurdoor.getImage());

            LinearLayout llTitle = (LinearLayout)itemView
                    .findViewById(R.id.llTitle);
            llTitle.setVisibility(View.GONE);

            TextView tvTitle = (TextView) itemView
                    .findViewById(R.id.tvTitle);
            tvTitle.setText(activitiesOurdoor.getTitle());

            Button btLike = (Button) itemView
                    .findViewById(R.id.btLike);
            //btLike.setText(activitiesWatchList.getTitle());

            TextView tvLike = (TextView) itemView
                    .findViewById(R.id.tvLike);
            tvLike.setText(String.valueOf(activitiesOurdoor.getLike()));

            Button btWatch = (Button) itemView
                    .findViewById(R.id.btWatch);
            //btLike.setText(activitiesWatchList.getTitle());

            TextView tvWatch = (TextView) itemView
                    .findViewById(R.id.tvWatch);
            tvWatch.setText(String.valueOf(activitiesOurdoor.getWatch()));

            Button btMsg = (Button) itemView
                    .findViewById(R.id.btMsg);
            //btLike.setText(activitiesWatchList.getTitle());

            TextView tvMsg = (TextView) itemView
                    .findViewById(R.id.tvMsg);
            tvMsg.setText(String.valueOf(activitiesOurdoor.getMsg()));

            Button btRegister = (Button) itemView
                    .findViewById(R.id.btRegister);

            btRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), ActRegisterActivity.class);
                    startActivity(intent);
                }
            });

            return itemView;
        }

        @Override
        public Object getItem(int position) {
            return activitiesOurdoorList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return activitiesOurdoorList.get(position).getImage();
        }
    }

    private List<ActOurdoor> getActivitiesOurdoorList() {
        List<ActOurdoor> activitiesOurdoorList = new ArrayList<>();
        activitiesOurdoorList.add(new ActOurdoor(R.drawable.lin_test01, "2018 小騎士馬術冬令營 - 小牛仔也很忙！", 10, 20,30));
        activitiesOurdoorList.add(new ActOurdoor(R.drawable.lin_test01, "2030 小騎士馬術冬令營 - 小牛仔也很忙！", 1, 7,122));
        activitiesOurdoorList.add(new ActOurdoor(R.drawable.lin_test01, "2040 小騎士馬術冬令營 - 小牛仔也很忙！", 5, 0,14));
        return activitiesOurdoorList;
    }

}
