package com.sample.colormatrixtest;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    ImageView ivNew;

    SeekBar sk1;
    SeekBar sk2;
    SeekBar sk3;
    SeekBar sk4;
    SeekBar sk5;
    SeekBar sk6;
    SeekBar sk7;
    SeekBar sk8;
    SeekBar sk9;
    SeekBar sk10;
    SeekBar sk11;
    SeekBar sk12;

    SeekBar sk13;
    SeekBar sk14;
    SeekBar sk15;
    SeekBar sk16;

    SeekBar sk17;
    SeekBar sk18;
    SeekBar sk19;
    SeekBar sk20;

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivNew = (ImageView) findViewById(R.id.iv_new);

        sk1 = (SeekBar) findViewById(R.id.sk_1);
        sk1.setOnSeekBarChangeListener(this);
        sk2 = (SeekBar) findViewById(R.id.sk_2);
        sk2.setOnSeekBarChangeListener(this);
        sk3 = (SeekBar) findViewById(R.id.sk_3);
        sk3.setOnSeekBarChangeListener(this);
        sk4 = (SeekBar) findViewById(R.id.sk_4);
        sk4.setOnSeekBarChangeListener(this);
        sk5 = (SeekBar) findViewById(R.id.sk_5);
        sk5.setOnSeekBarChangeListener(this);
        sk6 = (SeekBar) findViewById(R.id.sk_6);
        sk6.setOnSeekBarChangeListener(this);
        sk7 = (SeekBar) findViewById(R.id.sk_7);
        sk7.setOnSeekBarChangeListener(this);
        sk8 = (SeekBar) findViewById(R.id.sk_8);
        sk8.setOnSeekBarChangeListener(this);
        sk9 = (SeekBar) findViewById(R.id.sk_9);
        sk9.setOnSeekBarChangeListener(this);
        sk10 = (SeekBar) findViewById(R.id.sk_10);
        sk10.setOnSeekBarChangeListener(this);
        sk11 = (SeekBar) findViewById(R.id.sk_11);
        sk11.setOnSeekBarChangeListener(this);
        sk12 = (SeekBar) findViewById(R.id.sk_12);
        sk12.setOnSeekBarChangeListener(this);

        sk13 = (SeekBar) findViewById(R.id.sk_13);
        sk13.setOnSeekBarChangeListener(this);
        sk14 = (SeekBar) findViewById(R.id.sk_14);
        sk14.setOnSeekBarChangeListener(this);
        sk15 = (SeekBar) findViewById(R.id.sk_15);
        sk15.setOnSeekBarChangeListener(this);
        sk16 = (SeekBar) findViewById(R.id.sk_16);
        sk16.setOnSeekBarChangeListener(this);

        sk17 = (SeekBar) findViewById(R.id.sk_17);
        sk17.setOnSeekBarChangeListener(this);
        sk18 = (SeekBar) findViewById(R.id.sk_18);
        sk18.setOnSeekBarChangeListener(this);
        sk19 = (SeekBar) findViewById(R.id.sk_19);
        sk19.setOnSeekBarChangeListener(this);
        sk20 = (SeekBar) findViewById(R.id.sk_20);
        sk20.setOnSeekBarChangeListener(this);

        tvResult = (TextView) findViewById(R.id.tv_result);


        refreshMatrix();
    }

    private void refreshMatrix() {
        float[] src = {
                getValue(sk1.getProgress()), getValue(sk2.getProgress()), getValue(sk3.getProgress()), getValue(sk4.getProgress()), getValueAlpha(sk17.getProgress()),
                getValue(sk5.getProgress()), getValue(sk6.getProgress()), getValue(sk7.getProgress()), getValue(sk8.getProgress()), getValueAlpha(sk18.getProgress()),
                getValue(sk9.getProgress()), getValue(sk10.getProgress()), getValue(sk11.getProgress()), getValue(sk12.getProgress()), getValueAlpha(sk19.getProgress()),
                getValueAlpha(sk13.getProgress()), getValueAlpha(sk14.getProgress()), getValueAlpha(sk15.getProgress()), getValueAlpha(sk16.getProgress()), getValueAlpha(sk20.getProgress()),
        };
        ColorMatrix cm = new ColorMatrix(src);
        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(cm);
        ivNew.setColorFilter(filter);

        updateResult(src);
    }

    private void updateResult (float[] src) {
        DecimalFormat df = new DecimalFormat("@@##");
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < src.length; ++i) {
            if (i != 0 && i % 5 == 0)
                sb.append("\n");
            sb.append(df.format(src[i]));
            sb.append(" , ");

        }
        sb.append("}");
        tvResult.setText(sb);
    }

    private float getValue(int data) {
        return data / 100.0f ;
    }

    private int getValueAlpha(int data) {
        return data - 1;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        refreshMatrix();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
