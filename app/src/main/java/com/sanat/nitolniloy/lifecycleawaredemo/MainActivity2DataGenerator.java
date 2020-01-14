package com.sanat.nitolniloy.lifecycleawaredemo;

import android.util.Log;
import java.util.Random;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivity2DataGenerator extends ViewModel {

    private String TAG = this.getClass().getSimpleName();
    private MutableLiveData<String> myRandomNumber;

    public MutableLiveData<String> getNumber(){
        Log.i(TAG, "getNumber: ");
        if(myRandomNumber == null){
            createNumber();
        }
        return myRandomNumber;
    }

    public void createNumber(){
        Log.i(TAG, "createNumber: ");
        Random random = new Random();
        //myRandomNumber = "Number: " + (random.nextInt(10-1) + 1);
        myRandomNumber.setValue("Number: " + (random.nextInt(10-1) + 1));
    }


    // This method is called when the activity will be destroyed
    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "onCleared: ViewModel destroyed");
    }
}
