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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.pp.parentparadise.R;

import java.util.ArrayList;
import java.util.List;



public class CommunityFragment_family extends Fragment {

    View view;
    Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        onCreateView自動幫忙建好view
        view = inflater.inflate(R.layout.fragment_community_family, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_family);
        recyclerView.setLayoutManager(
                new StaggeredGridLayoutManager(
                        1, StaggeredGridLayoutManager.VERTICAL));
        List <Object> list = getList();
        recyclerView.setAdapter(new ObjectAdapter(getContext(), list));

        ImageButton button = view.findViewById(R.id.btAdd);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CommunityAdd.class);
                startActivity(intent);
            }
        });


        return view;
    }


    public class ObjectAdapter extends RecyclerView.Adapter {

        private AdapterView itemview;
        private Context context;
        private List <Object> list;
        private CommunityMember member;


        //        因為是private 所以要再重設一個itemlist

        ObjectAdapter(Context context, List <Object> list) {
            this.context = context;
            this.list = list;
        }


        class MyViewHolder0 extends RecyclerView.ViewHolder {

            TextView tv_title;

            MyViewHolder0(View itemView) {
                super(itemView);
                tv_title = itemView.findViewById(R.id.tv_title);
            }
        }

        class MyViewHolder1 extends RecyclerView.ViewHolder {
            public View itemview;
            ImageView ivImage;
            TextView tvName;



                MyViewHolder1(View itemView) {
                super(itemView);
                ivImage = itemView.findViewById(R.id.ivImage);
                tvName = itemView.findViewById(R.id.tvName);


                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getActivity(), CommunityChatActivity.class);
                        getActivity().startActivity(intent);

                    }
                });

            }
        }


        @Override

        public int getItemCount() {

            return list.size();

        }

        @Override
        public int getItemViewType(int position) {
            Object obj = list.get(position);
            if (obj instanceof String) {
                return 0;
            } else {
                return 1;
            }
        }


        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            switch (viewType) {
                case 0:
                    View itemView0 = layoutInflater.inflate(R.layout.community_item_title, viewGroup, false);
                    return new MyViewHolder0(itemView0);
                default:
                    View itemView1 = layoutInflater.inflate(R.layout.fragment_community_item01, viewGroup, false);
                    return new MyViewHolder1(itemView1);
            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
            Object obj = list.get(position);
            MyViewHolder1 itemView;



            switch (getItemViewType(position)) {
//                My ViewHolder0 為 title view
                case 0:
                    MyViewHolder0 myViewHolder0 = (MyViewHolder0) viewHolder;
                    myViewHolder0.tv_title.setText(obj.toString());
                    break;
                default:
//                 My ViewHolder0 為 會員item
                    member = (CommunityMember) obj;
                    MyViewHolder1 myViewHolder1 = (MyViewHolder1) viewHolder;
                    myViewHolder1.tvName.setText(member.getName());
                    myViewHolder1.ivImage.setImageResource(member.getImage());
                    break;
            }


            }

        }



            public List <Object> getList(){
                List <Object> list = new ArrayList <>();
                list.add("我的家人");
                list.add(new CommunityMember(R.drawable.freya_robot, "PP管理員"));
                list.add(new CommunityMember(R.drawable.freya_01, "宋仲基"));
                list.add(new CommunityMember(R.drawable.freya_sun, "孫儷"));
                list.add("我的朋友");
                list.add(new CommunityMember(R.drawable.freya_dong, "鄧紫棋"));
                list.add(new CommunityMember(R.drawable.freya_song02, "宋慧喬"));
                list.add(new CommunityMember(R.drawable.freya_02, "孔劉"));
                list.add("加入好友？");
                list.add(new CommunityMember(R.drawable.freya_hu, "胡瓜"));
                return list;
            }

        }

//        public class ItemDialogFragment extends DialogFragment {
//         @Override
//        public Dialog onCreateDialog(Bundle savedInstanceState) {
//        // Use the Builder class for convenient dialog construction
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        builder.setMessage(R.string.dialog_fire_missiles)
//                .setPositiveButton(R.string.fire, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        // FIRE ZE MISSILES!
//                    }
//                })
//                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        // User cancelled the dialog
//                    }
//                });
//        // Create the AlertDialog object and return it
//        return builder.create();
//    }
