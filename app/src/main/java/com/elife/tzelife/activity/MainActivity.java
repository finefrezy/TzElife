package com.elife.tzelife.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.elife.tzelife.R;
import com.elife.tzelife.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    private MainFragment mMainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addMainFragment();
    }

    private void addMainFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        mMainFragment = new MainFragment();
        // 避免view显示的重复
        transaction.replace(R.id.content, mMainFragment, MainFragment.TAG);
        transaction.commit();
    }
}
