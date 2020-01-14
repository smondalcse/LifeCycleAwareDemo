package com.sanat.nitolniloy.lifecycleawaredemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity2 extends AppCompatActivity {
    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final TextView txtRandomNumber = findViewById(R.id.txtRandomNumber);

        // Bellow mehtod will Generate the random number but when the orientation change every time
        // the data will be changed

//        MainActivity2DataGenerator mainActivity2DataGenerator = new MainActivity2DataGenerator();
//        String myRandomNumber = mainActivity2DataGenerator.getNumber();

        // Bellow method, The data will remain the same until the activity is destroyed
        // View model preserve the data
        final MainActivity2DataGenerator model = ViewModelProviders.of(this).get(MainActivity2DataGenerator.class);
        final LiveData<String> myRandomNumber = model.getNumber();
        myRandomNumber.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                txtRandomNumber.setText(s);
                Log.i(TAG, "onChanged: Data update in UI");
            }
        });

        Log.i(TAG, "onCreate: Random Number Set");

        Button btn_fetchdata = findViewById(R.id.btn_fetchdata);
        btn_fetchdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.createNumber();
            }
        });

    }
}
