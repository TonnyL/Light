/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Lizhaotailang
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.github.tonnyl.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.widget.Toast;

import io.github.tonnyl.light.Light;

import static android.graphics.Typeface.BOLD_ITALIC;

/**
 * Created by lizhaotailang on 03/10/2017.
 */

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = findViewById(R.id.fab);

        findViewById(R.id.button_success).setOnClickListener(v1 ->
                Light.success(fab, "Success", Snackbar.LENGTH_SHORT)
                        .setAction("Action", v2 ->
                                Toast.makeText(SettingsActivity.this, "Hello, Light!", Toast.LENGTH_SHORT).show())
                        .show());

        findViewById(R.id.button_info).setOnClickListener(v ->
                Light.info(fab, "Info", Snackbar.LENGTH_SHORT).show());

        findViewById(R.id.button_warning).setOnClickListener(v ->
                Light.warning(fab, "Warning", Snackbar.LENGTH_SHORT).show());

        findViewById(R.id.button_error).setOnClickListener(v ->
                Light.error(fab, "Error", Snackbar.LENGTH_SHORT).show());

        findViewById(R.id.button_normal).setOnClickListener(v -> {
            String prefix = "Formatted ";
            String highlight = "bold italic";
            String suffix = " text";
            SpannableStringBuilder ssb = new SpannableStringBuilder(prefix).append(highlight).append(suffix);
            int prefixLen = prefix.length();
            ssb.setSpan(new StyleSpan(BOLD_ITALIC),
                    prefixLen, prefixLen + highlight.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            Light.normal(fab, ssb.toString(), Snackbar.LENGTH_SHORT).show();
        });

        findViewById(R.id.button_custom).setOnClickListener(v1 ->
                Light.make(
                        fab,
                        "Awesome Snackbar",
                        Snackbar.LENGTH_SHORT,
                        R.drawable.ic_album_white_24dp,
                        R.color.color_cyan,
                        android.R.color.white,
                        R.drawable.ic_done_all_white_24dp,
                        R.color.colorAccent)
                        .setAction("Done all", v2 ->
                                Toast.makeText(SettingsActivity.this, "Hello, Light!", Toast.LENGTH_SHORT).show())
                        .show());

    }
}
