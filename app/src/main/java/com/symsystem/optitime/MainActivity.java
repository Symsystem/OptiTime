package com.symsystem.optitime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.symsystem.optitime.repository.DBHandler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHandler.createDBHandler(this);
    }
}
