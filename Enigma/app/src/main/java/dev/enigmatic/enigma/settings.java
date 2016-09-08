package dev.enigmatic.enigma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Rushabh on 18-03-2016.
 */
public class settings extends Fragment
{
    ListView lv1,lv2;
    // Defined Array values to show in ListView
    String[] services_array = new String[] { "SMS",
            "Call"
    };
    String[] settings_array = new String[] { "Wi-Fi",
            "Bluetooth",
            "Track Me"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.settings_xml, container, false);

        ///////////////// List 1 ///////////////////////////////
        lv1 = (ListView)v.findViewById(R.id.service_list);

        lv1.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.list_text_view, services_array));

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // ListView Clicked item index
                int itemPosition = position;

                if (itemPosition == 0) {
                    Intent i1 = new Intent(getActivity(), SMSActivity.class);
                    startActivity(i1);
                }
                if (position == 1) {
                    Intent i2 = new Intent(getActivity(), CallActivity.class);
                    startActivity(i2);
                }
            }
        });

        //////////////List 2/////////////////////////////////
        lv2 = (ListView)v.findViewById(R.id.settings_list);

        lv2.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.list_text_view, settings_array));

        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // ListView Clicked item index
                int itemPosition = position;

                if (itemPosition == 0) {
                    Intent i1 = new Intent(getActivity(), WifiActivity.class);
                    startActivity(i1);
                }
                if (position == 1) {
                    Intent i1 = new Intent(getActivity(), BluetoothActivity.class);
                    startActivity(i1);
                }
                if (position == 2) {
                    Intent i1 = new Intent(getActivity(), GPSActivity.class);
                    startActivity(i1);
                }
            }
        });
        return v;
    }
}
