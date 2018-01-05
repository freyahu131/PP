package com.project.pp.parentparadise.lin;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.project.pp.parentparadise.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ActFragment extends Fragment {

    RadioGroup rgActivity;
    RadioButton rbList, rbHistory, rbWatch;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_activities, container, false);

        findviews();
        initContent();

        rgActivity.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                Fragment fragment;
                rbDefault();
                switch (checkedId)
                {
                    case R.id.rbList:
                        fragment = new ActListFragment();
                        switchFragment(fragment);
                        rbList.setTextColor(Color.WHITE);
                        break;
                    case R.id.rbHistory:
                        fragment = new ActHistoryFragment();
                        switchFragment(fragment);
                        rbHistory.setTextColor(Color.WHITE);
                        break;
                    case R.id.rbWatch:
                        fragment = new ActWatchFragment();
                        switchFragment(fragment);
                        rbWatch.setTextColor(Color.WHITE);
                        break;
                    default:
                        break;
                }
            }
        });
        return view;
    }

    private void findviews(){
        rgActivity = view.findViewById(R.id.rgActivity);
        rbList = view.findViewById(R.id.rbList);
        rbHistory = view.findViewById(R.id.rbHistory);
        rbWatch = view.findViewById(R.id.rbWatch);

    }

    private void rbDefault(){
        rbList.setTextColor(Color.BLACK);
        rbHistory.setTextColor(Color.BLACK);
        rbWatch.setTextColor(Color.BLACK);
    }

    private void initContent() {
        rbList.setTextColor(Color.WHITE);
        Fragment fragment = new ActListFragment();
        switchFragment(fragment);

    }

    private void switchFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activityContent, fragment);
        fragmentTransaction.commit();

    }

}
