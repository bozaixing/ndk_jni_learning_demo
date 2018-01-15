package com.example.administrator.ndk;

import android.media.audiofx.EnvironmentalReverb;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ndk.use.JniUtils;
import com.ndk.use.NdkC;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        //调用jni中的方法
        tv.setText(JniUtils.stringFromJNI());
        testNdk();

    }

    private void testNdk() {
        //String s = NdkC01.ndkc01();
        //String s = NdkC01.ndkc02();
        //String s = NdkC.ndkc03();
        //String s = NdkC.ndkc04();
        //String s = NdkC.ndkc05();

        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        String s = NdkC.ndkc06(absolutePath + File.separatorChar + "boy.txt");
        Log.d("myDemo-jni", absolutePath + File.separatorChar + "boy.txt");//   /storage/emulated/0/boy.txt

    }
}
