package com.example.addingplayers;

import android.app.AlertDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
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

    RecyclerView recyclerView;    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(ImageViewModel.class);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel.getMlist().observe(this, new Observer<List<ImageInfo>>() {
            @Override
            public void onChanged(@Nullable List<ImageInfo> imageInfos) {
                recyclerView.setAdapter(new ImageAdapter(MainActivity.this, imageInfos));
                Toast.makeText(MainActivity.this, "" + imageInfos.size(), Toast.LENGTH_SHORT).show();
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
        Intent intent = new Intent(this,AddActivity.class);
        startActivity(intent);
    }
}
