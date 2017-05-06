package io.github.tonnyl.sample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import io.github.tonnyl.light.Light;

import static android.graphics.Typeface.BOLD_ITALIC;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        findViewById(R.id.button_success).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Light.success(fab, "Success", Light.LENGTH_SHORT)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "Hello, Light!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });

        findViewById(R.id.button_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Light.info(fab, "Info", Light.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.button_warning).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Light.warning(fab, "Warning", Light.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.button_error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Light.error(fab, "Error", Light.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.button_normal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String prefix = "Formatted ";
                String highlight = "bold italic";
                String suffix = " text";
                SpannableStringBuilder ssb = new SpannableStringBuilder(prefix).append(highlight).append(suffix);
                int prefixLen = prefix.length();
                ssb.setSpan(new StyleSpan(BOLD_ITALIC),
                        prefixLen, prefixLen + highlight.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                Light.make(fab, ssb, Light.TYPE_NORMAL, Light.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.button_custom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Light.make(
                        fab,
                        "Awesome Snackbar",
                        R.drawable.ic_album_white_24dp,
                        R.color.color_cyan,
                        android.R.color.white,
                        Light.LENGTH_INDEFINITE,
                        R.drawable.ic_done_all_white_24dp,
                        R.color.colorAccent)
                        .setAction("Done all", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "Hello, Light!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });

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
}
