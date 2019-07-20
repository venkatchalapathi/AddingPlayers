package com.example.addingplayers.Activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.addingplayers.Database.ImageViewModel;
import com.example.addingplayers.Fragments.BattingFragment;
import com.example.addingplayers.Fragments.BowlingFragment;
import com.example.addingplayers.Fragments.FieldingFragment;
import com.example.addingplayers.Models.TeamWithPlayers;
import com.example.addingplayers.R;
import com.example.addingplayers.Adapters.TabAdapter;

import java.util.List;

public class PlayerDetailsActivity extends AppCompatActivity {
    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    ImageView profileImage;

    ImageViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_details);
        model = ViewModelProviders.of(this).get(ImageViewModel.class);
        profileImage = findViewById(R.id.header);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new BattingFragment(), "Batting");
        adapter.addFragment(new BowlingFragment(), "Bowling");
        adapter.addFragment(new FieldingFragment(), "Fielding");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        int id = getIntent().getIntExtra("id_key",0);

        //String image = getIntent().getStringExtra("image_key");
        Log.i("imageLink-->2",""+toBitmap(model.getPlayer(id)));
        Glide.with(this).load(toBitmap(model.getPlayer(id))).apply(new RequestOptions()
                .placeholder(R.drawable.ic_account_circle_black_24dp)).into(profileImage);
        Toast.makeText(this, "image-"+id, Toast.LENGTH_SHORT).show();
    }
    public Bitmap toBitmap(byte[] byteArray) {
        if (byteArray!=null) {
            return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        }else{
            Toast.makeText(this, "check", Toast.LENGTH_SHORT).show();
            return null;
        }

    }
}
