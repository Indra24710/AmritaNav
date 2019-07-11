package amrita.design.com.amritanavigator;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.TimeUtils;
import android.widget.ImageView;

import java.util.concurrent.TimeUnit;

/**
 * Created by aditya on 08-07-2019.
 */

public class main extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Thread background = new Thread(){
            public void run(){
                try{
                    sleep(1300);

                    Intent i=new Intent(main.this,Amrita_Maps.class);
                    startActivity(i);

                    finish();
                }
                catch (Exception e){

                }
            }
        };
        background.start();
    }
}
