package com.app.navigationdrawer;



import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.onCreateDrawer();
        //Action bar needs to be instatiate in every Activity that has layout
        setUpActionBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //Set up Action Bar
    private void setUpActionBar() {
        //Uses superclass method to instantiate ActionBar
        mActionBarToolbar = getActionBarToolbar();
        mActionBarToolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        //Set up Icon for the Navigation Drawer
        mActionBarToolbar.setNavigationIcon(R.drawable.ic_drawer);
        //Set up Action for the Navigation Drawer Icon
        mActionBarToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drawerList.isShown()){
                    //Close Navigation Drawer
                    drawerLayout.closeDrawer(Gravity.START);
                }else {
                    //Open Navigation Drawer
                    drawerLayout.openDrawer(Gravity.START);
                }
            }
        });

    }

}
