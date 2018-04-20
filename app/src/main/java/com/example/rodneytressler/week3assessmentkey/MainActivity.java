package com.example.rodneytressler.week3assessmentkey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;



public class MainActivity extends AppCompatActivity implements AccountFragment.ActivityCallback {

    @BindView(R.id.fate_world_textview)
    protected TextView fateOfWorldText;
    @BindView(R.id.hero_info_textview)
    protected TextView heroInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fateOfWorldText.setVisibility(View.INVISIBLE);
        heroInfo.setVisibility(View.INVISIBLE);

    }
    @Override
    protected void onStart() {
        super.onStart();
        AccountFragment accountFragment = AccountFragment.newInstance();
        accountFragment.attachParent(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder,accountFragment).commit();
    }


    @Override
    public void accountInformation(String heroName, String heroClass) {
        fateOfWorldText.setVisibility(View.VISIBLE);
        heroInfo.setVisibility(View.VISIBLE);
        heroInfo.setText(getString(R.string.hero_textview_info, heroName,heroClass));
    }
}
