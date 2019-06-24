package com.example.practical4;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private TextView mTimeView;
    private TextView mDateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        Button myButton = (Button) findViewById(R.id.my_button);

        mTimeView = (TextView) findViewById(R.id.showTime);
        mDateView = (TextView) findViewById(R.id.showDate);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

//        String [] myStringArray = {"Hello", "World", "Testing123"};
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, myStringArray);
//
//        ListView listView = (ListView) findViewById(R.id.list_view);
//        listView.setAdapter(adapter);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                Toast.makeText(this, getString(R.string.settings_clicked), Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_favorite:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                Toast.makeText(this, getString(R.string.favorite_clicked), Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_share:
                Toast.makeText(this, getString(R.string.share_clicked), Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_search:
                Toast.makeText(this, getString(R.string.search_clicked), Toast.LENGTH_SHORT).show();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

//        return super.onCreateOptionsMenu(menu);

        // Get the MenuItem for the action item
        MenuItem actionMenuSearch = menu.findItem(R.id.action_search);

        // Define the listener
        actionMenuSearch.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                // Do something when action item collapses
                Toast.makeText(getBaseContext(), getString(R.string.expand), Toast.LENGTH_LONG).show();
                return true;  // Return true to collapse action view
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                // Do something when expanded
                Toast.makeText(getBaseContext(), getString(R.string.collapse), Toast.LENGTH_LONG).show();
                return true;  // Return true to expand action view
            }
        });

        final SearchView searchView = (SearchView) actionMenuSearch.getActionView();

        searchView.setQueryHint("Hint: try searching = {Hello, World! or Bye, World!}");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                //Do something
                if (s.equals("Hello, World!")) {
                    Toast.makeText(getBaseContext(), "Hello, World! 😆😃😃", Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (s.equals("Bye, World!")) {
                    Toast.makeText(getBaseContext(), "Bye, World! 😆😃😃", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                // do something
                return false;
            }
        });

        return true;
    }

    public void showTimePicker(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void processTimePickerResult(int hourOfDay, int minute) {
        String hourOfDay_string = Integer.toString(hourOfDay);
        String minute_string = Integer.toString(minute);

        String timeMessage = (hourOfDay_string + ":" + minute_string);
        mTimeView.setText(timeMessage);
        Toast.makeText(this, timeMessage, Toast.LENGTH_SHORT).show();
    }

    public void processDatePickerResult(int year, int month, int dayOfMonth) {
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(dayOfMonth);
        String year_string = Integer.toString(year);

        String dateMessage = (day_string + "/" + month_string + "/" + year_string);
        mDateView.setText(dateMessage);
        Toast.makeText(this, dateMessage, Toast.LENGTH_SHORT).show();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }


    public void launchAlertDialogActivity(View view) {
        Intent intent = new Intent(this, AlertDialogActivity.class);
        startActivity(intent);
    }
}
