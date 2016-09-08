package dev.enigmatic.enigma;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


/**
 * Created by Rushabh on 18-03-2016.
 */
public class aboutus extends android.support.v4.app.Fragment {


    ListView list;
    String[] name = {"Kunal Shinde","Rushabh Wadkar","Sadhna Singh","Swapnil Velunde"};
    Integer[] imageId = {R.mipmap.kunal1,R.mipmap.rushabh,R.mipmap.sadhna1,R.mipmap.swapnil};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.aboutus_xml, container, false);


        CustomList adapter = new CustomList(getActivity(), name,imageId);
        list = (ListView)v.findViewById(R.id.listView);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if(position==0)
                {
                    Uri uri = Uri.parse("http://google.com/+KunalShindekun4lshinde");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(launchBrowser);
                }

                else if(position==1)
                {
                    Uri uri = Uri.parse("https://www.facebook.com/rushabh6792");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(launchBrowser);
                }

                else if(position==2)
                {
                    Uri uri = Uri.parse("https://www.facebook.com/sadhna.singh.9849");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(launchBrowser);
                }

                else
                {
                    Uri uri = Uri.parse("https://plus.google.com/100712078722337707742/posts");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(launchBrowser);
                }
            }
        });

        return v;
    }
}
