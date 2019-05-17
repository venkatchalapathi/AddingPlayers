package com.example.addingplayers;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class ImageViewModel extends AndroidViewModel {
    private ImageRepository imageRepository;
    private LiveData<List<ImageInfo>> mlist;

    public ImageViewModel(Application application) {
        super(application);
        imageRepository = new ImageRepository(application);
        mlist = imageRepository.getmAllMeals();
    }
    public LiveData<List<ImageInfo>> getMlist() {
        return mlist;
    }
    public void insert(ImageInfo mealInfo){
        imageRepository.insert(mealInfo);
    }
    public void delete(ImageInfo mealInfo){
        imageRepository.delete(mealInfo);
    }


}
