package com.factory.asv.mtglifecounter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by nuborisar on 22/03/2015.
 */
public class CounterCtrl extends LinearLayout {
    Button btnPlus;
    Button btnMinus;
    TextView lblTotal;
    String mlytCtrl = "";
    int mCounterInit = 20;
    int mCounterCurrent;
    int mResScheme;
    Runnable ColorResetRun;
    Handler titiritero;

    public CounterCtrl(Context context, int maximun) {
        super(context);
        this.mCounterInit = maximun;
        initControl();
    }

    public CounterCtrl(Context context) {
        super(context);

        initControl();
    }

    public CounterCtrl(Context context, AttributeSet attrs) {
        super(context, attrs);

        // Procesamos los atributos XML personalizados
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.ControlCtrl);

        mCounterInit = a.getInt(R.styleable.ControlCtrl_CtrlValue, 10);
        String txtScheme = a.getString(R.styleable.ControlCtrl_CtrlScheme);


        mResScheme = getControlLayoutScheme(txtScheme);
        // btnLogin.setText(textoBoton);

        //  a.recycle();
        initControl();
    }

    private int getControlLayoutScheme(String txtScheme) {

        if (txtScheme.contains("bbv"))
            return R.layout.ctrl_counterbbv;

        if (txtScheme.contains("bvb"))
            return R.layout.ctrl_counterbvb;

        if (txtScheme.contains("vbb"))
            return R.layout.ctrl_countervbb;
        return -1;
    }

    private void initControl() {
        try {

            String infService = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater li =
                    (LayoutInflater) getContext().getSystemService(infService);
            li.inflate(mResScheme, this, true);

            //Obtenemoslas referencias a los distintos control

            btnPlus = (Button) findViewById(R.id.BtnPlus);
            btnMinus = (Button) findViewById(R.id.BtnMinus);
            lblTotal = (TextView) findViewById(R.id.LblTotal);
            lblTotal.setText("" + mCounterInit);
            mCounterCurrent = mCounterInit;
            //Asociamos los eventos necesarios
            setControlEvents();

            titiritero = new Handler();
            ColorResetRun = new Runnable() {
                @Override
                public void run() {
                    btnPlus.setBackgroundColor(Color.TRANSPARENT);
                    btnMinus.setBackgroundColor(Color.TRANSPARENT);

                }
            };
        } catch (Exception e) {
            logg.printE(e);
        }
    }

    public void reset() {
        lblTotal.setText("" + mCounterInit);
        mCounterCurrent = mCounterInit;
    }

    private void setControlEvents() {
        try {
            btnPlus.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnPlus.setBackgroundColor(Color.parseColor("#66000000"));
                    mCounterCurrent = mCounterCurrent + 1;
                    lblTotal.setText("" + mCounterCurrent);
                    titiritero.postDelayed(ColorResetRun,200);
                }
            });
            btnMinus.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                   btnMinus.setBackgroundColor(Color.parseColor("#66000000"));
                    mCounterCurrent = mCounterCurrent - 1;
                    lblTotal.setText("" + mCounterCurrent);
                    titiritero.postDelayed(ColorResetRun,200);
                }
            });

        } catch (Exception e) {
            logg.printE(e);
        }
    }

}
