package doapps.shna.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import doapps.shna.R;

/**
 * Created by Bryam Soto on 25/07/2016.
 */
public class SplashActivity extends AppCompatActivity {

    private Animation animation;
    private LinearLayout lytSplash;
    private ImageView imgSplash;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        lytSplash = (LinearLayout) findViewById(R.id.lyt_splash);
        imgSplash = (ImageView) findViewById(R.id.img_splash);

        startAnimations();
    }

    private void startAnimations() {

        animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        animation.reset();

        lytSplash.clearAnimation();
        lytSplash.startAnimation(animation);

        animation = AnimationUtils.loadAnimation(this, R.anim.translate);
        animation.reset();

        imgSplash.clearAnimation();
        imgSplash.startAnimation(animation);

        Thread splashThread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while (waited < 3500) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(SplashActivity.this, SelectionActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    finish();
                }
            }
        };
        splashThread.start();
    }
}