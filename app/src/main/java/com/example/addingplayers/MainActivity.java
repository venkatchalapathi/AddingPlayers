package com.example.addingplayers;

import android.app.AlertDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.addingplayers.Models.Player;
import com.example.addingplayers.Models.Team;
import com.thesurix.gesturerecycler.DefaultItemClickListener;
import com.thesurix.gesturerecycler.RecyclerItemTouchListener;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_IMAGE = 100;
    View v;
    EditText about_image;
    ImageView imageView;
    Button insertBtn;
    AlertDialog.Builder builder;
    String note;
    Bitmap bitmap;

    ImageViewModel viewModel;

    RecyclerView recyclerView;
    AlertDialog.Builder dialog;
    View v1;
    EditText get_team;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        v1 = LayoutInflater.from(this).inflate(R.layout.new_team, null, false);
        get_team = v1.findViewById(R.id.new_team_view_id);
        viewModel = ViewModelProviders.of(this).get(ImageViewModel.class);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //final ImageAdapter adapter = new ImageAdapter();

       /* SwipeAndDragHelper swipeAndDragHelper = new SwipeAndDragHelper(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(swipeAndDragHelper);
        adapter.setTouchHelper(touchHelper);
        recyclerView.setAdapter(adapter);
        touchHelper.attachToRecyclerView(recyclerView);

        viewModel.getMlist().observe(this, new Observer<List<Team>>() {
            @Override
            public void onChanged(@Nullable List<Team> imageInfos) {
                adapter.setUserList(imageInfos);
                Toast.makeText(MainActivity.this, "" + imageInfos.size(), Toast.LENGTH_SHORT).show();
            }
        });*/
        viewModel.getMlist().observe(this, new Observer<List<Team>>() {
            @Override
            public void onChanged(@Nullable List<Team> teams) {
                recyclerView.setAdapter(new TeamAdapter(MainActivity.this, teams));
            }
        });
    }

    public byte[] toByteArray(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        bitmap.recycle();
        return byteArray;
    }

    public void addPlayers(View view) {
        dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Add New Team");
        dialog.setView(v1);
        dialog.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                addNewTeam();
            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
       /* Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);*/

    }

    private void addNewTeam() {
        Team team = new Team();
        team.setMatches(0);
        team.setMatches_won(0);
        team.setMatches_lost(0);
        team.setTeam_name(get_team.getText().toString());
        team.setPlayersList(new ArrayList<Player>());

        viewModel.insert(team);
        Toast.makeText(this, "Team Added", Toast.LENGTH_SHORT).show();
    }


}
