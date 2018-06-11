package com.example.anshulsharma.timestables;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView list;

    public void generate(int table){

        ArrayList<Integer> num=new ArrayList<>();
        for (int i=1;i<11;i++){
            num.add(table*i);
        }
        ArrayAdapter<Integer> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,num);
        list.setAdapter(arrayAdapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final SeekBar time=findViewById(R.id.seekBar);
        list=findViewById(R.id.listView);
        time.setMax(20);
        time.setProgress(10);

        /*
        final Handler handler=new Handler();
        Runnable run=new Runnable() {
            int t=time.getProgress();
            @Override
            public void run() {
                time.setProgress(t++);
                handler.postDelayed(this,1000);
            }
        };
        handler.post(run);

*/


        time.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if(progress<1) {
                    generate(1);
                    time.setProgress(1);
                }else
                generate(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        generate(10);
    }
}
