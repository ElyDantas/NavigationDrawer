package com.app.navigationdrawer;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * Created by ELY on 23/04/2015.
 */
public class BaseActivity extends ActionBarActivity {

    //Navigation Drawer
    public DrawerLayout drawerLayout;
    //Navigation Drawer List of items
    public ListView drawerList;
    //App's Toolbar
    protected Toolbar mActionBarToolbar;

    protected void onCreateDrawer() {
        //Instantiate Navigation Drawer
        setupNavDrawer();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }

    //Override this method in subclasses if you want a different toolbar for the activity
    protected Toolbar getActionBarToolbar() {
        if (mActionBarToolbar == null) {
            mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
            if (mActionBarToolbar != null) {
                setSupportActionBar(mActionBarToolbar);
            }
        }
        return mActionBarToolbar;
    }


    //Set up Navigation Drawer
    private void setupNavDrawer() {

        //Instantiate Navigation Drawer
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        //Instatiate Navigation Drawer List
        drawerList = (ListView) findViewById(R.id.left_drawer);

        //Populate Navigation Drawer with string.xml values
        drawerList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1,
                new String[]{
                        getString(R.string.title_section0),
                        getString(R.string.title_section1),
                        getString(R.string.title_section2),
                        getString(R.string.title_section3)
                }));

        //Manage here what happens after item clicked in the Navigation Drawer
        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,final int position, long id) {
                drawerLayout.closeDrawer(Gravity.START);

                Handler mHandler = new Handler();
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent;
                        switch (position) {
                            case 0:

                                intent = new Intent(BaseActivity.this, MainActivity.class);
                                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));


                                break;
                            case 1:

                                intent = new Intent(BaseActivity.this, Teste.class);
                                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));

                                break;
                            case 2:

                                intent = new Intent(BaseActivity.this, Teste2.class);
                                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));


                                break;
                            case 3:

                                intent = new Intent(BaseActivity.this, Teste3.class);
                                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));


                                break;

                        }
                    }
                }, 200);

            }
        });

    }

}
