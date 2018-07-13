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

package io.github.tonnyl.sample

import android.content.Intent
import android.graphics.Typeface.BOLD_ITALIC
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import io.github.tonnyl.light.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private var position = BOTTOM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        button_success.setOnClickListener {
            success(fab, R.string.success, Snackbar.LENGTH_SHORT, position)
                    .setAction("Action", {
                        Toast.makeText(this@MainActivity, "Hello, Light!", Toast.LENGTH_SHORT).show()
                    })
                    .show()
        }

        button_info.setOnClickListener {
            info(fab, R.string.info, Snackbar.LENGTH_SHORT, position).show()
        }

        button_warning.setOnClickListener {
            warning(fab, R.string.warning, Snackbar.LENGTH_SHORT, position).show()
        }

        button_error.setOnClickListener {
            error(fab, R.string.error, Snackbar.LENGTH_SHORT, position).show()
        }

        button_normal.setOnClickListener {
            val prefix = "Formatted "
            val highlight = "bold italic"
            val suffix = " text"
            val ssb = SpannableStringBuilder(prefix)
                    .append(highlight)
                    .append(suffix)
                    .apply {
                        setSpan(StyleSpan(BOLD_ITALIC), prefix.length, prefix.length + highlight.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    }
            normal(fab, ssb.toString(), Snackbar.LENGTH_SHORT, position).show()
        }

        button_custom.setOnClickListener {
            make(
                    fab,
                    "Awesome Snackbar",
                    Snackbar.LENGTH_SHORT,
                    R.drawable.ic_album_white_24dp,
                    R.color.color_cyan,
                    android.R.color.white,
                    R.drawable.ic_done_all_white_24dp,
                    R.color.colorAccent, position)
                    .setAction("Done all", {
                        Toast.makeText(this@MainActivity, "Hello, Light!", Toast.LENGTH_SHORT).show()
                    })
                    .show()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> {
                startActivity(Intent(this@MainActivity, SettingsActivity::class.java))
            }
            else -> {
                position = if (position == BOTTOM) {
                    item.title = "TOP"
                    TOP
                } else {
                    item.title = "BOTTOM"
                    BOTTOM
                }
            }
        }
        return true
    }

}
