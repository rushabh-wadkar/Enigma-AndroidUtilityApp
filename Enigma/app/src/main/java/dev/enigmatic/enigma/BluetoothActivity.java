package dev.enigmatic.enigma;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Rushabh on 19-03-2016.
 */
public class BluetoothActivity extends AppCompatActivity {
    Switch s;
    BluetoothAdapter ba;
    TextView t2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        s=(Switch)findViewById(R.id.switch1);
        t2=(TextView)findViewById(R.id.sta);

        ba=BluetoothAdapter.getDefaultAdapter();

        if(ba.isEnabled())
        {
            t2.setText("Status: ON");
            s.setChecked(true);
        }
        else
        {
            t2.setText("Status: OFF");
            s.setChecked(false);
        }
        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Intent i=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(i, 0);
                    Toast.makeText(getApplicationContext(), "Enabling Bluetooth", Toast.LENGTH_LONG).show();
                    t2.setText("Status: ON");
                }
                else
                {
                    ba.disable();
                    Toast.makeText(getApplicationContext(), "Disabling Bluetooth", Toast.LENGTH_LONG).show();
                    t2.setText("Status: OFF");
                }
            }
        });
    }
}