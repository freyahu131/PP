package com.project.pp.parentparadise.amber;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.project.pp.parentparadise.R;

/**
 * Created by Amber on 2017/12/5.
 */

public class ShareFragment extends Fragment {

    RadioGroup rgShare;
    RadioButton rbSweet, rbAct, rbBook, rbMedia, rbLife;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.share_main, container, false);
        findviews();
        initContent();
        rgShare.setOnCheckedChangeListener(rgListener);
        rbAct.setOnClickListener(listener);
        return view;
    }

    private void findviews() {
        rgShare = view.findViewById(R.id.rgShare);
        rbSweet = view.findViewById(R.id.rbSweet);
        rbAct = view.findViewById(R.id.rbAct);
        rbBook = view.findViewById(R.id.rbBook);
        rbMedia = view.findViewById(R.id.rbMedia);
        rbLife = view.findViewById(R.id.rbLife);
    }

    private void rbDefault() {
        rbSweet.setTextColor(Color.BLACK);
        rbAct.setTextColor(Color.BLACK);
        rbBook.setTextColor(Color.BLACK);
        rbMedia.setTextColor(Color.BLACK);
        rbLife.setTextColor(Color.BLACK);
    }

    private void initContent() {
        rbSweet.setTextColor(Color.WHITE);
        Fragment fragment = new ShareFragmentSweet();
        switchFragment(fragment);
    }

    private void switchFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.llContent, fragment);
        fragmentTransaction.commit();
    }

    RadioGroup.OnCheckedChangeListener rgListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            Fragment fragment;
            rbDefault();
            switch (checkedId) {
                case R.id.rbSweet:
                    fragment = new ShareFragmentSweet();
                    switchFragment(fragment);
                    rbSweet.setTextColor(Color.WHITE);
                    break;
                case R.id.rbAct:
                    fragment = new ShareFragmentAct();
                    switchFragment(fragment);
                    rbAct.setTextColor(Color.WHITE);
                    break;
                case R.id.rbBook:
                    fragment = new ShareFragmentBook();
                    switchFragment(fragment);
                    rbBook.setTextColor(Color.WHITE);
                    break;
                case R.id.rbMedia:
                    fragment = new ShareFragmentMedia();
                    switchFragment(fragment);
                    rbMedia.setTextColor(Color.WHITE);
                    break;
                case R.id.rbLife:
                    fragment = new ShareFragmentLife();
                    switchFragment(fragment);
                    rbLife.setTextColor(Color.WHITE);
                    break;
                default:
                    break;
            }
        }
    };


    View.OnClickListener listener = new View.OnClickListener() {

      //  @SuppressLint("RestrictedApi")
        @Override
        public void onClick(View v) {
            final PopupMenu popupMenu = new PopupMenu(getActivity(), rbAct);
            popupMenu.getMenuInflater().inflate(R.menu.share_popup_menu,popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    Fragment fragment;
                    switch (item.getItemId()) {
                        case R.id.pmOutdoor:
                            fragment = new ShareFragmentActivityOutdoor();
                            switchFragment(fragment);
                            break;
                        case R.id.pmExperience:
                            fragment = new ShareFragmentActExperience();
                            switchFragment(fragment);
                            break;
                        case R.id.pmTheme:
                            fragment = new ShareFragmentActivityTheme();
                            switchFragment(fragment);
                            break;
                        case R.id.pmOther:
                            fragment = new ShareFragmentActOthers();
                            switchFragment(fragment);
                            break;
                        default:
                            break;
                    }
                    return true;
                }
            });



//            try{
//                Field field = popupMenu.getClass().getDeclaredField("mPopup");
//                field.setAccessible(true);
//                MenuPopupHelper mHelper = (MenuPopupHelper) field.get(popupMenu);
//                mHelper.setForceShowIcon(true);
//
//            } catch (Exception e) {
//
//            }
            popupMenu.show();
        }
    };
}
