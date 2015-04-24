package com.factory.asv.mtglifecounter;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class FullscreenActivity extends Activity {


    Button btnReset;
    CounterCtrl ctrlUp;
    CounterCtrl ctrlDown;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        btnReset = (Button) findViewById(R.id.BtnReset);
        ctrlUp = (CounterCtrl) findViewById(R.id.CtrlUp);
        ctrlDown = (CounterCtrl) findViewById(R.id.CtrlDown);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ctrlUp.reset();
                ctrlDown.reset();
            }
        });


    }


}
