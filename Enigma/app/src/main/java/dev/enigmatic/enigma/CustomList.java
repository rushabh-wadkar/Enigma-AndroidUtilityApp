package dev.enigmatic.enigma;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Rushabh on 19-03-2016.
 */
public class CustomList extends ArrayAdapter<String>
{
    private final Activity context;
    private final String[] name;
    private final Integer[] imageId;

    public CustomList(Activity context, String[] name, Integer[] imageId)
    {
        super(context, R.layout.layout,name);
        this.context = context;
        this.name = name;
        this.imageId = imageId;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View rv = inflater.inflate(R.layout.layout, null, true);
        TextView tv = (TextView)rv.findViewById(R.id.textView);
        ImageView iw = (ImageView)rv.findViewById(R.id.kunal);
        tv.setText(name[position]);
        iw.setImageResource(imageId[position]);
        return rv;
    }

}

