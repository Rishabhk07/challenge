package com.example.hptouchsmart.facebookchallenge;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.hptouchsmart.facebookchallenge.Fragments.ProfileFragment;
import com.example.hptouchsmart.facebookchallenge.Fragments.TopicFragment;
import com.example.hptouchsmart.facebookchallenge.Fragments.challengeFragment;

public class UserLoginActivity extends AppCompatActivity {

    AHBottomNavigation ahBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        final ProfileFragment profileFragment = new ProfileFragment();
        final challengeFragment challengeFragment = new challengeFragment();
        final TopicFragment topicFragment = new TopicFragment();

        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameReplace , profileFragment , null);
        fragmentTransaction.commit();



        ahBottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);

        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Feed" , R.drawable.activity , R.color.colorPrimaryDark);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("User" , R.drawable.user , R.color.colorPrimary);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Topics" , R.drawable.topics, R.color.colorAccent);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem("challenges" , R.drawable.trophy , R.color.colorBottomNavigationNotification);

        ahBottomNavigation.addItem(item1);
        ahBottomNavigation.addItem(item2);
        ahBottomNavigation.addItem(item3);
        ahBottomNavigation.addItem(item4);

        ahBottomNavigation.setBackgroundColor(Color.parseColor("#FEFEFE"));

        ahBottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                FragmentTransaction newFragTRans = getSupportFragmentManager().beginTransaction();
                switch(position){
                    case 0:

                        newFragTRans.replace(R.id.frameReplace , profileFragment , null);
                        break;
                    case 1:
                        newFragTRans.replace(R.id.frameReplace , profileFragment , null);
                        break;
                    case 2:
                        newFragTRans.replace(R.id.frameReplace , topicFragment , null);
                        break;
                    case 3:

                        break;
                }

                newFragTRans.commit();

                return true;
            }
        });

        ahBottomNavigation.setOnNavigationPositionListener(new AHBottomNavigation.OnNavigationPositionListener() {
            @Override
            public void onPositionChange(int y) {

            }
        });
    }
}
