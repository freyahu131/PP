package com.project.pp.parentparadise.amber;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.project.pp.parentparadise.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amber on 2017/12/5.
 */

public class ShareFragmentSweet extends Fragment {
    View view;
    RecyclerView recyclerView;
    FloatingActionButton fabAdd;
    ImageSwitcher imageSwitcher;
    private int currentPosition;        //當前頁面位置
    private float downX;                //按下的Ｘ座標
    private int[] imgIds;             //圖片的Id數組合
    private ImageView[] tips;           //點點數組合

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.share_recyclerview_add, container, false);
        findView();
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        List<ShareData> dataList = getDataList();
        recyclerView.setAdapter(new DataAdapter(getActivity(), dataList));

        return view;
    }

    private void findView() {
        recyclerView = view.findViewById(R.id.recyclerView_with_add);
        fabAdd = view.findViewById(R.id.fabAdd);

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  從1 Activity的fragment跳轉到 2 Activity，要取得getActivity()
                Intent intent = new Intent(getActivity(), ShareAddArticle.class);
                startActivity(intent);
            }
        });
    }

    class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {
        private Context context;
        private List<ShareData> dataList;
        DataAdapter(Context context, List<ShareData> dataList) {
            this.context = context;
            this.dataList = dataList;
        }
        class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView ivHead;
            TextView tvName;
            TextView tvTime;
            ImageSwitcher imageSwitcher;
            LinearLayout linearLayout;
            TextView tvDescribe;
            TextView tvMCount;
            TextView tvGCount;
            TextView tvMore;
            TextView tvMIcon;
            MyViewHolder(View itemView) {
                super(itemView);
                ivHead = itemView.findViewById(R.id.ivHead);
                tvName = itemView.findViewById(R.id.tvName);
                tvTime = itemView.findViewById(R.id.tvTime);
                imageSwitcher  = view.findViewById(R.id.imageSwitcher1);
                linearLayout = view.findViewById(R.id.llviewGroup);
                tvDescribe = itemView.findViewById(R.id.tvDescribe);
                tvMCount = itemView.findViewById(R.id.tvMCount);
                tvGCount = itemView.findViewById(R.id.tvGCount);
                tvMore = itemView.findViewById(R.id.tvMore);
                tvMIcon = itemView.findViewById(R.id.tvMIcon);
            }
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View itemView = layoutInflater.inflate(R.layout.share_itemview_sweet, viewGroup, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {
            final ShareData data = dataList.get(position);
            holder.ivHead.setImageResource(data.getHead());
            holder.tvName.setText(data.getName());
            holder.tvTime.setText(data.getTime());

            if(data.getDescribe().length() > 15) {
                holder.tvMore.setVisibility(View.VISIBLE);
                holder.tvDescribe.setText(data.getDescribe().substring(0,14));
            } else {
                holder.tvDescribe.setText(data.getDescribe());
                holder.tvMore.setVisibility(View.GONE);
            }

            holder.tvGCount.setText(String.valueOf(data.getGoodCount()));
            holder.tvMCount.setText(String.valueOf(data.getMessageCount()));

            holder.tvMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.tvMore.setVisibility(View.GONE);
                    LayoutParams ll =
                            new LayoutParams(LayoutParams.MATCH_PARENT,
                                    LayoutParams.WRAP_CONTENT);
                    holder.tvDescribe.setText(data.getDescribe());
                    holder.tvDescribe.setLayoutParams(ll);
                }
            });

            holder.tvMIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), ShareAddMessage.class);
                    startActivity(intent);
                }
            });

//            holder.imageSwitcher.setFactory(viewFactory);
//            holder.imageSwitcher.setOnTouchListener(imageTouch);
//            tips = new ImageView[imgIds.length];
//            for(int i=0; i<imgIds.length; i++){
//                ImageView mImageView = new ImageView(getActivity());
//                tips[i] = mImageView;
//                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT,
//                        LayoutParams.WRAP_CONTENT));
//                layoutParams.rightMargin = 3;
//                layoutParams.leftMargin = 3;
//
//                mImageView.setBackgroundResource(R.drawable.amber_icon_dotgrey);
//                holder.linearLayout.addView(mImageView, layoutParams);
//                holder.imageSwitcher.setImageResource(imgIds[currentPosition]);
//                setImageBackground(currentPosition);
//            }

        }
    }


    //設定圖片被選的點點的背景圖案
    private void setImageBackground(int selectItems){
        for(int i=0; i<tips.length; i++){
            if(i == selectItems){
                tips[i].setBackgroundResource(R.drawable.amber_icon_dotwhite);
            }else{
                tips[i].setBackgroundResource(R.drawable.amber_icon_dotgrey);
            }
        }
    }

//    ViewSwitcher.ViewFactory viewFactory = new ViewSwitcher.ViewFactory() {
//        @Override
//        public View makeView() {
//            final ImageView i = new ImageView(getActivity());
//            i.setBackgroundColor(0xff000000);
//            i.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            i.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
//            return i ;
//        }
//    };
//
//    //設定觸碰（onTouch）照片的事件
//    View.OnTouchListener imageTouch = new View.OnTouchListener() {
//        @Override
//        public boolean onTouch(View v, MotionEvent event) {
//
//            switch (event.getAction()) {
//                case MotionEvent.ACTION_DOWN: {
//                    //手指按下的座標
//                    downX = event.getX();
//                    break;
//                }
//                case MotionEvent.ACTION_UP:{
//                    float lastX = event.getX();
//
//                    //抬起時的X座標大於按下時座標就顯示上一張
//                    if(lastX > downX){
//                        if(currentPosition > 0){
//                            //設定顯示時的動畫
//                            imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(getActivity().getApplication(), R.anim.left_in));
//                            imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(getActivity().getApplication(), R.anim.right_out));
//                            currentPosition --;
//                            imageSwitcher.setImageResource(imgIds[currentPosition % imgIds.length]);
//                            setImageBackground(currentPosition);
//                        }else{
//                            Toast.makeText(getActivity().getApplication(), "已經到第一張", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                    if(lastX < downX){
//                        if(currentPosition < imgIds.length - 1){
//                            imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(getActivity().getApplication(), R.anim.right_in));
//                            imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(getActivity().getApplication(), R.anim.left_out));
//                            currentPosition ++ ;
//                            imageSwitcher.setImageResource(imgIds[currentPosition]);
//                            setImageBackground(currentPosition);
//                        }else{
//                            Toast.makeText(getActivity().getApplication(), "已經是最後一張", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                }
//                break;
//            }
//            return true;
//        }
//    };


    public List<ShareData> getDataList() {
        List<ShareData> dateList = new ArrayList<>();
        int[] photos1 = new int[]{R.drawable.amber_sweet00101,R.drawable.amber_sweet00102,R.drawable.amber_sweet00103,R.drawable.amber_sweet00104};
        int[] photos2 = new int[]{R.drawable.amber_sweet00201,R.drawable.amber_sweet00202,R.drawable.amber_sweet00203};
        int[] photos3 = new int[]{R.drawable.amber_sweet00301,R.drawable.amber_sweet00302,R.drawable.amber_sweet00303};
        int[] photos4 = new int[]{R.drawable.amber_sweet00401,R.drawable.amber_sweet00402};
        int[] photos5 = new int[]{R.drawable.amber_sweet00501};

        dateList.add(new ShareData(R.drawable.amber_icon_head01, "Amily", "10分鐘前",photos1, "今天帶寶寶出來玩！！寶寶穿西瓜裝，超級超級超級超級超級超級超級超級超級超級超級超級超級超級超級超級可愛", 35, 3));
        dateList.add(new ShareData(R.drawable.amber_icon_head02, "Carol", "13分鐘前",photos2, "寶寶畫畫好棒棒，非常非常非常非常非常非常非常非常非常非常非常非常非常非常非常非常非常非常非常非常厲害", 16, 2));
        dateList.add(new ShareData(R.drawable.amber_icon_head03, "Elsa", "24分鐘前",photos3,"帶寶寶去拍寫真，好可愛！！", 55, 3));
        dateList.add(new ShareData(R.drawable.amber_icon_head04, "Anna", "50分鐘前",photos4, "難得拍了全家福，超開心", 55, 3));
        dateList.add(new ShareData(R.drawable.amber_icon_head05, "Jackey", "56分鐘前",photos5, "今天帶孩子們去公園玩，被樹上的小松鼠吸引了！", 55, 3));
        return dateList;
    }



}
