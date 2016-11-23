package com.testography.castermaterialdesign;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("Action Bar Title");

        setCustomView(toolbar);
    }

    private void setCustomView(Toolbar toolbar) {
        View customView = getLayoutInflater().inflate(R.layout.view_toolbar, null);
        toolbar.addView(customView);

        ImageView happyFace = (ImageView) customView.findViewById(R.id.toolbar_image);
        happyFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeImage();
            }
        });
    }

    private void changeImage() {
        ImageView backdropIV = (ImageView) findViewById(R.id.backdrop);
        backdropIV.setImageResource(R.drawable.hero_statues);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        CoordinatorLayout cl = (CoordinatorLayout) findViewById(R.id.main_content);
        switch (item.getItemId()) {
            case R.id.action_heart:
                Snackbar.make(cl, "HEART HEART HEART HEART", Snackbar.LENGTH_LONG).show();
                return true;
            case R.id.action_star:
                Snackbar.make(cl, "STAR STAR STAR STAR", Snackbar.LENGTH_LONG)
                        .show();
                return true;
            case R.id.action_joystick:
                Snackbar.make(cl, "JOYSTICK JOYSTICK JOYSTICK JOYSTICK", Snackbar
                        .LENGTH_LONG).show();
                return true;
        }
        return true;
    }
}
