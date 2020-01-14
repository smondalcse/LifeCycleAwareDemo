package com.sanat.nitolniloy.lifecycleawaredemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private String TAG = this.getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Owner onCreate: ");
        getLifecycle().addObserver(new MainActivityObserver());
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "Owner onStart: ");
        super.onStart();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "Owner onPause: ");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "Owner onResume: ");
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "Owner onDestroy: ");
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "Owner onStop: ");
        super.onStop();
    }
}
