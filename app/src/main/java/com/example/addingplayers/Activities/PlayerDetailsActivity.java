package com.example.addingplayers.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.addingplayers.Fragments.BattingFragment;
import com.example.addingplayers.Fragments.BowlingFragment;
import com.example.addingplayers.Fragments.FieldingFragment;
import com.example.addingplayers.R;
import com.example.addingplayers.Adapters.TabAdapter;

public class PlayerDetailsActivity extends AppCompatActivity {
    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_details);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new BattingFragment(), "Batting");
        adapter.addFragment(new BowlingFragment(), "Bowling");
        adapter.addFragment(new FieldingFragment(), "Fielding");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        int id = getIntent().getIntExtra("id_key",0);
        Toast.makeText(this, ""+id, Toast.LENGTH_SHORT).show();
    }
}
