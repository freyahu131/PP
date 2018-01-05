package com.project.pp.parentparadise.freya;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.pp.parentparadise.R;

import java.util.ArrayList;
import java.util.List;


public class CommunityFragment_chatlist extends Fragment {

    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_community_chatlist, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycle_chatlist);
        recyclerView.setLayoutManager(
                new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));

        List<CommunityChatItem> chatitemlist = getChatItemList();

        recyclerView.setAdapter(new ItemListAdapter(getActivity(), chatitemlist));
        // Inflate the layout for this fragment

        return view;
    }


    public class ItemListAdapter extends RecyclerView.Adapter <ItemListAdapter.MyViewHolder> {

        private Context context;
        private List<CommunityChatItem> chatitemlist;
        private int position;

        //        因為是private 所以要再重設一個itemlist

        ItemListAdapter(Context context, List<CommunityChatItem> chatitemlist) {
            this.context = context;
            this.chatitemlist = chatitemlist;
        }


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
             // ＶiewGroup parent 所以 parent 也要寫在下面
            LayoutInflater inflater = LayoutInflater.from(context);
            View itemView = inflater.inflate(R.layout.fragment_community_item01,parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder viewHolder, int position) {

            CommunityChatItem chatitem = chatitemlist.get(position);
            viewHolder.ivImage.setImageResource(chatitem.getImage());
            viewHolder.tvName.setText(chatitem.getChatName());
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Intent intent = new Intent(getActivity(), CommunityChatActivity.class);
                    Bundle bundle = new Bundle();
                    getActivity().startActivity(intent);


                }
                });

        }

        @Override
        public int getItemCount() {
            return chatitemlist.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            ImageView ivImage;
            TextView tvName;


            public MyViewHolder(View itemView) {
                super(itemView);
                ivImage = (ImageView) itemView.findViewById(R.id.ivImage);
                tvName = (TextView) itemView.findViewById(R.id.tvName);


            }
        }




    }

    public List<CommunityChatItem> getChatItemList() {
        List<CommunityChatItem> chatitemlist = new ArrayList<>();
        chatitemlist.add(new CommunityChatItem(R.drawable.freya_01,"PP"));
        chatitemlist.add(new CommunityChatItem(R.drawable.freya_01,"宋仲基"));
        chatitemlist.add(new CommunityChatItem(R.drawable.freya_01,"帥哥彬華"));
        chatitemlist.add(new CommunityChatItem(R.drawable.freya_01,"本班諸葛亮"));

        return chatitemlist;
    }

}

