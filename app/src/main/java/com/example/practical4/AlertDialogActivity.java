package com.example.practical4;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class AlertDialogActivity extends AppCompatActivity {

    private Button mbtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
    }

    public void showFireMissilesDialog(View view) {
        DialogFragment newFragment = new FireMissilesDialogFragment();
        newFragment.show(getSupportFragmentManager(), "fireMissiles");
    }

}
