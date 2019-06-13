package com.example.addingplayers;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class ImageInfo {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] image;

    private String image_name;

    public ImageInfo(int id, byte[] image, String image_name) {
        this.id = id;
        this.image = image;
        this.image_name = image_name;
    }

    public ImageInfo() {
    }

    public ImageInfo(ImageInfo targetUser) {
        this.id = targetUser.id;
        this.image_name = targetUser.image_name;
        this.image = targetUser.image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }
}
