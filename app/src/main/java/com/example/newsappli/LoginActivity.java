package com.example.newsappli;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.newsappli.Adapter.LoginInSigInAdapter;
import com.google.android.material.tabs.TabLayout;

public class LoginActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private LoginInSigInAdapter loginInSigInAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        loginInSigInAdapter = new LoginInSigInAdapter(getSupportFragmentManager());
        // add fragments
        loginInSigInAdapter.AddFragment(new LogIn(),"LogIn");
        loginInSigInAdapter.AddFragment(new SignIn(),"signIn");
        // set adapter
        viewPager.beginFakeDrag();
        viewPager.setAdapter(loginInSigInAdapter);
        //connect with viewpager
        tabLayout.setupWithViewPager(viewPager);
    }
}