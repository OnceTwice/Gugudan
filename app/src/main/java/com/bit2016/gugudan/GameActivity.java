package com.bit2016.gugudan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {
    private static final int TIME_LIMIT = 20;
    private Timer timer = new Timer();
    private TextView tvLastTime;
    int[] num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tvLastTime = (TextView)findViewById(R.id.textView_second);
        timer.schedule(new GameTimerTask(), 10, 1000);

        TextView textView1 = (TextView)findViewById(R.id.num1);
        TextView textView2 = (TextView)findViewById(R.id.num2);

        textView1.setText(Integer.toString(makeRandom()));
        textView2.setText(Integer.toString(makeRandom()));

        makeRandomButton();
    }

    private void makeRandomButton() {
        TextView textView11 = (TextView)findViewById(R.id.button_11);
        TextView textView12 = (TextView)findViewById(R.id.button_12);
        TextView textView13 = (TextView)findViewById(R.id.button_13);

        TextView textView21 = (TextView)findViewById(R.id.button_21);
        TextView textView22 = (TextView)findViewById(R.id.button_22);
        TextView textView23 = (TextView)findViewById(R.id.button_23);

        TextView textView31 = (TextView)findViewById(R.id.button_31);
        TextView textView32 = (TextView)findViewById(R.id.button_32);
        TextView textView33 = (TextView)findViewById(R.id.button_33);

        nineButton();

        textView11.setText(Integer.toString(num[0]));
        textView12.setText(Integer.toString(num[1]));
        textView13.setText(Integer.toString(num[2]));

        textView21.setText(Integer.toString(num[3]));
        textView22.setText(Integer.toString(num[4]));
        textView23.setText(Integer.toString(num[5]));

        textView31.setText(Integer.toString(num[6]));
        textView32.setText(Integer.toString(num[7]));
        textView33.setText(Integer.toString(num[8]));
    }

    private int makeRandom() {
        return ((int)(Math.random()*9) +1);
    }

    private void nineButton() {
        HashSet<Integer> set = new HashSet<Integer>();
        num = new int[9];
        int a = 0;

        for(int i=0; i<8; i++) {
            set.add(makeRandom());
        }

        Iterator<Integer> i = set.iterator();
        while(i.hasNext()) {
            num[a++] = i.next();
        }
    }

    private void updateLastTime(int seconds) {
        tvLastTime.setText(""+(TIME_LIMIT - seconds));
    }

    private class GameTimerTask extends TimerTask {
        private int seconds;

        @Override
        public void run() {
            seconds++;
            if(seconds >= TIME_LIMIT) {
                timer.cancel();
                Intent intent = new Intent(GameActivity.this, ResultActivity.class);
                startActivity(intent);
                finish();
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    updateLastTime(seconds);
                }
            });
        }
    }
}
