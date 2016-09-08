package dev.enigmatic.enigma;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Rushabh on 19-03-2016.
 */
public class WifiActivity extends AppCompatActivity {
    Switch s1;
    WifiManager w1;
    TextView t1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        s1=(Switch)findViewById(R.id.switch2);
        t1=(TextView)findViewById(R.id.st);
        w1=(WifiManager)getSystemService(Context.WIFI_SERVICE);

        if(w1.isWifiEnabled()==false)
        {
            t1.setText("Status: OFF");
            s1.setChecked(false);
        }
        else
        {
            t1.setText("Status: ON");
            s1.setChecked(true);
        }
        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true)
                {
                    t1.setText("Status: ON");
                    w1.setWifiEnabled(true);
                    Toast.makeText(getApplicationContext(), "Wifi Enabled", Toast.LENGTH_SHORT).show();
                }
                if(isChecked==false)
                {
                    t1.setText("Status: OFF");
                    w1.setWifiEnabled(false);
                    Toast.makeText(getApplicationContext(), "Wifi Disabled", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
