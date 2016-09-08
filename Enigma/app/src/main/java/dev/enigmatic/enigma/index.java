package dev.enigmatic.enigma;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;


public class index extends FragmentActivity
{

    ViewPager viewPager = null;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_index);

        viewPager = (ViewPager)findViewById(R.id.pager);

        FragmentManager fragmentManager=getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(fragmentManager));

    }
}


class MyAdapter extends FragmentPagerAdapter
{
    public MyAdapter(FragmentManager f)
    {
        super(f);
    }
    public Fragment getItem(int i)
    {
        Fragment f = null;
        if(i==0)
        {
            f = new settings();
        }
        if(i==1)
        {
            f = new aboutus();
        }
        return f;
    }
    public int getCount()
    {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        if(position==0)
            return "Settings";
        if(position==1)
            return "About Us";
        return null;
    }
}