package com.example.addingplayers;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.addingplayers.Models.Player;
import com.thesurix.gesturerecycler.GestureAdapter;
import com.thesurix.gesturerecycler.GestureViewHolder;

import java.util.Collections;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
        implements SwipeAndDragHelper.ActionCompletionContract{
    List<Player> imageInfos;
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
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
        //ImageInfo info = getItem(i);
        ((ImageViewHolder)viewHolder).textView.setText(imageInfos.get(i).getPlayer_name());
        Log.i("POS-->","Adapter "+i+":DB "+imageInfos.get(i).getPlayer_id());
        Glide.with(viewHolder.itemView)
                .load(toBitmap(imageInfos.get(i).getPlayer_Image())).into(((ImageViewHolder)viewHolder).imageView);

        ((ImageViewHolder)viewHolder).drag.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                    touchHelper.startDrag(viewHolder);
                }
                return false;
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
        Collections.swap(imageInfos , oldPosition, newPosition);
        /*for(int i = 0; i < imageInfos.size(); i++) {
            ImageInfo currentItem = imageInfos.get(i);
            //viewModel.update(currentItem );
        }
        ImageInfo targetUser = imageInfos.get(oldPosition);
        ImageInfo user = new ImageInfo(targetUser);
        imageInfos.remove(oldPosition);
        imageInfos.add(newPosition, user);*/
        int i = oldPosition + 1;
        int j = newPosition + 1;
       /* ImageInfo info = new ImageInfo(i,imageInfos.get(oldPosition).getImage(),imageInfos.get(oldPosition).getImage_name());
        ImageInfo info1 = new ImageInfo(j,imageInfos.get(newPosition).getImage(),imageInfos.get(newPosition).getImage_name());
*/
       /* model.update(info);
        model.update(info1);*/
        Toast.makeText(context, "Updated", Toast.LENGTH_SHORT).show();
        notifyItemMoved(oldPosition, newPosition);
       // model.update(targetUser);
        //notifyItemMoved(oldPosition, newPosition);
    }

    @Override
    public void onViewSwiped(int position,int direction) {

       /* imageInfos.remove(position);

        ImageInfo info = new ImageInfo();
        info.setId(imageInfos.get(position).getId());
        info.setImage(imageInfos.get(position).getImage());
        info.setImage_name(imageInfos.get(position).getImage_name());
        model.delete(info);
        Toast.makeText(context, "Deleted..", Toast.LENGTH_SHORT).show();
        notifyDataSetChanged();*/
    }

    public void setTouchHelper(ItemTouchHelper touchHelper) {

        this.touchHelper = touchHelper;
    }
    public void setUserList(List<Player> usersList) {
        this.imageInfos = usersList;
        notifyDataSetChanged();
    }

}
