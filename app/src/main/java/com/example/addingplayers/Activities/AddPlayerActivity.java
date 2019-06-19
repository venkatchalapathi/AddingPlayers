package com.example.addingplayers.Activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import com.example.addingplayers.Adapters.ImageAdapter;
import com.example.addingplayers.Database.ImageViewModel;
import com.example.addingplayers.Models.TeamWithPlayers;
import com.example.addingplayers.R;
import com.example.addingplayers.SwipeAndDragHelper;

import java.util.List;

public class AddPlayerActivity extends AppCompatActivity {

    ImageViewModel viewModel;

    RecyclerView recyclerView;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        viewModel = ViewModelProviders.of(this).get(ImageViewModel.class);

        recyclerView = findViewById(R.id.players_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        id = getIntent().getIntExtra("team_id",0);

        final ImageAdapter adapter = new ImageAdapter();

        SwipeAndDragHelper swipeAndDragHelper = new SwipeAndDragHelper(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(swipeAndDragHelper);
        adapter.setTouchHelper(touchHelper);
        recyclerView.setAdapter(adapter);
        touchHelper.attachToRecyclerView(recyclerView);

        viewModel.getPlayerList(id).observe(this, new Observer<List<TeamWithPlayers>>() {
            @Override
            public void onChanged(@Nullable List<TeamWithPlayers> imageInfos) {
                if (imageInfos!=null) {
                    adapter.setUserList(imageInfos);
                    Toast.makeText(AddPlayerActivity.this, "" + imageInfos.size(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void addPlayersToDB(View view) {
        Intent intent = new Intent(this, AddActivity.class);
        intent.putExtra("team_id_key",id);
        startActivity(intent);
    }
}
