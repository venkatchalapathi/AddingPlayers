package com.example.addingplayers.Adapters;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.addingplayers.Activities.AddPlayerActivity;
import com.example.addingplayers.Activities.PlayerDetailsActivity;
import com.example.addingplayers.Database.ImageViewHolder;
import com.example.addingplayers.Database.ImageViewModel;
import com.example.addingplayers.Models.TeamWithPlayers;
import com.example.addingplayers.R;
import com.example.addingplayers.SwipeAndDragHelper;

import java.util.Collections;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
        implements SwipeAndDragHelper.ActionCompletionContract {
    List<TeamWithPlayers> imageInfos;
    private ItemTouchHelper touchHelper;
    AddPlayerActivity context;
    ImageViewModel model;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = (AddPlayerActivity) viewGroup.getContext();
        //  model = ViewModelProviders.of(context).get(ImageViewModel.class);

        return new ImageViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i) {
        //ImageInfo info = getItem(i);
        ((ImageViewHolder) viewHolder).textView.setText(imageInfos.get(i).getPlayers().get(i).getPlayer_name());
        Log.i("POS-->", "Adapter " + i + ":DB " + imageInfos.get(i).getPlayers().get(i).getPlayer_id());
        Glide.with(viewHolder.itemView)
                .load(toBitmap(imageInfos.get(i).getPlayers().get(i).getPlayer_Image())).into(((ImageViewHolder) viewHolder).imageView);

        ((ImageViewHolder) viewHolder).drag.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                    touchHelper.startDrag(viewHolder);
                }
                return false;
            }
        });
        ((ImageViewHolder) viewHolder).itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlayerDetailsActivity.class);
                intent.putExtra("id_key",imageInfos.get(i).getPlayers().get(i).getPlayer_id());
                Log.i("imageLink-->",""+imageInfos.get(i).getPlayers().get(i).getPlayer_Image());
                //intent.putExtra("image_key",imageInfos.get(i).getPlayers().get(i).getPlayer_Image());
                context.startActivity(intent);
            }
        });
    }

    public Bitmap toBitmap(byte[] byteArray) {
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

    }

    @Override
    public int getItemCount() {
        return imageInfos == null ? 0 : imageInfos.size();
    }

    @Override
    public void onViewMoved(int oldPosition, int newPosition) {
        Collections.swap(imageInfos, oldPosition, newPosition);
        int i = oldPosition + 1;
        int j = newPosition + 1;

        Toast.makeText(context, "Updated", Toast.LENGTH_SHORT).show();
        notifyItemMoved(oldPosition, newPosition);
    }

    @Override
    public void onViewSwiped(int position, int direction) {

    }

    public void setTouchHelper(ItemTouchHelper touchHelper) {

        this.touchHelper = touchHelper;
    }

    public void setUserList(List<TeamWithPlayers> usersList) {
        this.imageInfos = usersList;
        notifyDataSetChanged();
    }

}
