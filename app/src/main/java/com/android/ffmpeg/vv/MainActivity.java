package com.android.ffmpeg.vv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public native String avcodecinfo();

    public native int stream(String inputurl, String outputurl);

    static {

        System.loadLibrary("avutil-55");
        System.loadLibrary("swresample-2");
        System.loadLibrary("avcodec-57");
        System.loadLibrary("avformat-57");
        System.loadLibrary("swscale-4");
        System.loadLibrary("avfilter-6");
        System.loadLibrary("ffmpegvice");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView infoText = (TextView) findViewById(R.id.label_info);
        infoText.setMovementMethod(ScrollingMovementMethod.getInstance());
        findViewById(R.id.button_avcodec).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoText.setText(avcodecinfo());
            }
        });

    }
}
