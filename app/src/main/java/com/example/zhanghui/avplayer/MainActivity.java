package com.example.zhanghui.avplayer;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import com.tbruyelle.rxpermissions2.RxPermissions;

public class MainActivity extends Activity {

    private Button mPlayButton;
    private static final String DEFAULT_FILE_URL = Environment.getExternalStorageDirectory() + "/冲浪_4k.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestRxPermissions(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        mPlayButton = (Button) findViewById(R.id.play_button);
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, PlayerActivity.class).setData(Uri.parse(DEFAULT_FILE_URL));
                    startActivity(intent);
            }
        });
    }

    //请求权限
    private void requestRxPermissions(String... permissions) {
        RxPermissions rxPermissions = new RxPermissions(this);
        io.reactivex.Observable<Boolean> obser = rxPermissions.request(permissions);
        obser.subscribe(new io.reactivex.functions.Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {

            }
        });
    }
}
