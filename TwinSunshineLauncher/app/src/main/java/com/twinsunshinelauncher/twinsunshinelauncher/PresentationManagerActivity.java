package com.twinsunshinelauncher.twinsunshinelauncher;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.firebase.client.Firebase;
import com.twinsunshinelauncher.twinsunshinelauncher.dialogs.MyPresentationRecyclerViewAdapter;
import com.twinsunshinelauncher.twinsunshinelauncher.dialogs.PlusOneFragment;
import com.twinsunshinelauncher.twinsunshinelauncher.dialogs.PresentationFragment;
import com.twinsunshinelauncher.twinsunshinelauncher.models.Presentation;

public class PresentationManagerActivity extends AppCompatActivity
        implements
        MyPresentationRecyclerViewAdapter.OnListFragmentInteractionListener,
        PlusOneFragment.OnFragmentInteractionListener {

    private int REQUEST_CODE = 600;
    private static final String VR_PACKAGE_NAME = "com.nkspaun.TwinSunshine";
    private static final String SLIDE_EXTRA = "twin_sunshine_slide_extra";

    String[] permissions = {"android.permission.WRITE_EXTERNAL_STORAGE"};


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // save file
            } else {
                Toast.makeText(getApplicationContext(), "PERMISSION_DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation_manager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Fresco.initialize(this);
        Firebase.setAndroidContext(this);
        ActivityCompat.requestPermissions(this, permissions, REQUEST_CODE); // without sdk version check

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showCreateDialog();
                }
            });
        }
    }

    private void showCreateDialog() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Create and show the dialog.
        DialogFragment newFragment = PlusOneFragment.newInstance();
        newFragment.show(ft, "createDialog");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_presentation_manager, menu);
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

    @Override
    public void onListFragmentInteraction(Presentation presentation) {
        Context context = PresentationManagerActivity.this;
        PackageManager manager = context.getPackageManager();
        try {
            Intent intent = manager.getLaunchIntentForPackage(VR_PACKAGE_NAME);

            if (intent == null) {
                throw new PackageManager.NameNotFoundException();
            }

            intent.putStringArrayListExtra(SLIDE_EXTRA, presentation.getImageUrls());
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            context.startActivity(intent);
        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(context, "Please install TwinSunshine!", Toast.LENGTH_SHORT);
        }
    }

    @Override
    public void onFragmentInteraction(Presentation presentation) {
        PresentationFragment presentationFragment = (PresentationFragment) getSupportFragmentManager().findFragmentById(R.id.presentations);
        presentationFragment.addPresentation(presentation);
    }
}
