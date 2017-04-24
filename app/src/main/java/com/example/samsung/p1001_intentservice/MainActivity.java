package com.example.samsung.p1001_intentservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickStart(View view) {
        startService(new Intent(this, MyIntentService.class).
                putExtra(getString(R.string.time), 3).
                putExtra(getString(R.string.label), getString(R.string.call_1)));
        startService(new Intent(this, MyIntentService.class).
                putExtra(getString(R.string.time), 1).
                putExtra(getString(R.string.label), getString(R.string.call_2)));
        startService(new Intent(this, MyIntentService.class).
                putExtra(getString(R.string.time), 4).
                putExtra(getString(R.string.label), getString(R.string.call_3)));
    }
}
