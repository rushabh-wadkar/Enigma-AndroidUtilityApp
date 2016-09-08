package dev.enigmatic.enigma;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by Rushabh on 17-03-2016.
 */
public class Splash extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        final ImageView iv = (ImageView)findViewById(R.id.imageView);
        final Animation an_fadein = AnimationUtils.loadAnimation(getBaseContext(), R.anim.fade_in);
        final Animation an_fadeout = AnimationUtils.loadAnimation(getBaseContext(), R.anim.fade_out);

        iv.startAnimation(an_fadein);

        an_fadein.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                iv.startAnimation(an_fadeout);
                finish();
                Intent i = new Intent(getApplicationContext(), index.class);
                startActivity(i);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
