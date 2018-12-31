package com.example.piyali.liveduelsample2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.uniprogy.outquiz.LiveDuelSdk;

public class MainActivity extends AppCompatActivity {

    Button btn_test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_test=(Button)findViewById(R.id.btn_test);

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LiveDuelSdk ld= new LiveDuelSdk(MainActivity.this,R.drawable.ic_launcher_background,R.mipmap.ic_launcher, "http://54.202.198.121","D1E2M3O4");
                ld.openLiveDuelSdk();
            }
        });
    }
}
