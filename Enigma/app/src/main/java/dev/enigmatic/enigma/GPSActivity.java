package dev.enigmatic.enigma;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Rushabh on 20-03-2016.
 */
public class GPSActivity extends AppCompatActivity {

    Button b,b1;
    TextView t1,t2;
    Gps gp;
    double la,lo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);
        b=(Button)findViewById(R.id.button);
        b1=(Button)findViewById(R.id.button2);
        b1.setVisibility(View.INVISIBLE);
        t1=(TextView)findViewById(R.id.textView);
        t2=(TextView)findViewById(R.id.textView2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gp = new Gps(GPSActivity.this);
                if (gp.canGetLocation()) {
                    la = gp.getLatitude();
                    lo = gp.getLongitude();
                }
                if ((la == 0.0) && (lo == 0.0)) {
                    Toast.makeText(getApplicationContext(), "Please put on your GPS!!!", Toast.LENGTH_LONG).show();
                } else {
                    String s1, s2;
                    s1 = Double.toString(la);
                    s2 = Double.toString(lo);
                    t1.setText("Latitude : " + s1);
                    t2.setText("Longitude: " + s2);
                    b1.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "Tracked your location.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/maps/place/@" + la + "," + lo + ",17z"));
                startActivity(i);
            }
        });

    }
}
