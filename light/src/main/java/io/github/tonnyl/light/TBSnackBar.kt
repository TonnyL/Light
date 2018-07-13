package io.github.tonnyl.light

import android.graphics.drawable.Drawable
import android.support.annotation.CheckResult
import android.support.annotation.ColorInt
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.androidadvance.topsnackbar.TSnackbar


/**
 * Created by hd on 2018/7/13 .
 * manage top or bottom Snackbar
 */
class TBSnackBar {

    private var bSnackbar: Snackbar? = null

    private var tSnackbar: TSnackbar? = null

    private var showPosition = BOTTOM

    @CheckResult
    fun make(view: View,
             text: CharSequence,
             duration: Int = Snackbar.LENGTH_SHORT,
             textIcon: Drawable?,
             @ColorInt backgroundColorInt: Int = ContextCompat.getColor(view.context, R.color.color_normal),
             @ColorInt textColorInt: Int = ContextCompat.getColor(view.context, android.R.color.white),
             actionIcon: Drawable?,
             @ColorInt actionTextColorInt: Int = ContextCompat.getColor(view.context, android.R.color.white),
             gravity: Int = BOTTOM
    ): TBSnackBar {
        if (gravity == TOP) {
            tSnackbar = with(make(view, text, duration, textIcon, backgroundColorInt, textColorInt, gravity).getSnackbar() as TSnackbar) {
                setSnackbarText(this.view, actionIcon, actionTextColorInt, com.androidadvance.topsnackbar.R.id.snackbar_action)
                this
            }
        } else {
            bSnackbar = with(make(view, text, duration, textIcon, backgroundColorInt, textColorInt).getSnackbar() as Snackbar) {
                setSnackbarText(this.view, actionIcon, actionTextColorInt, android.support.design.R.id.snackbar_action)
                this
            }
        }
        return this
    }

    @CheckResult
    fun make(view: View,
             text: CharSequence,
             duration: Int = Snackbar.LENGTH_SHORT,
             textIcon: Drawable?,
             @ColorInt backgroundColorInt: Int = ContextCompat.getColor(view.context, R.color.color_normal),
             @ColorInt textColorInt: Int = ContextCompat.getColor(view.context, android.R.color.white),
             gravity: Int = BOTTOM
    ): TBSnackBar {
        showPosition = gravity
        if (gravity == TOP) {
            tSnackbar = with(TSnackbar.make(view, text, duration)) {
                this.view.apply {
                    setBackgroundColor(backgroundColorInt)
                }
                setSnackbarText(this.view, textIcon, textColorInt, com.androidadvance.topsnackbar.R.id.snackbar_text)
                this
            }
        } else {
            bSnackbar = with(Snackbar.make(view, text, duration)) {
                this.view.apply {
                    setBackgroundColor(backgroundColorInt)
                }
                setSnackbarText(this.view, textIcon, textColorInt, android.support.design.R.id.snackbar_text)
                this
            }
        }
        return this
    }

    inline fun setAction(@StringRes resId: Int, crossinline click: () -> Unit): TBSnackBar {
        return setAction(resId, View.OnClickListener { click() })
    }

    inline fun setAction(text: CharSequence, crossinline click: () -> Unit): TBSnackBar {
        return setAction(text, View.OnClickListener { click() })
    }

    fun setAction(@StringRes resId: Int, listener: View.OnClickListener): TBSnackBar {
        tSnackbar?.setAction(resId, listener)
        bSnackbar?.setAction(resId, listener)
        return this
    }

    fun setAction(text: CharSequence, listener: View.OnClickListener): TBSnackBar {
        tSnackbar?.setAction(text, listener)
        bSnackbar?.setAction(text, listener)
        return this
    }

    fun show() {
        tSnackbar?.show()
        bSnackbar?.show()
    }

    fun dismiss() {
        tSnackbar?.dismiss()
        bSnackbar?.dismiss()
    }

    fun getSnackbar(): Any? {
        return if (showPosition == BOTTOM) bSnackbar else tSnackbar
    }

    private fun setSnackbarText(view: View, drawableIcon: Drawable?, @ColorInt textColorInt: Int, @IdRes textViewId: Int) {
        view.findViewById<TextView>(textViewId)
                .apply {
                    // Set the left icon of message.
                    setCompoundDrawablesWithIntrinsicBounds(drawableIcon, null, null, null)
                    // Set the padding between message and icon.
                    compoundDrawablePadding = 16
                    // To make icon and message aligned.
                    this.gravity = Gravity.START or Gravity.CENTER
                    // Chan
                    // ge color of message text.
                    setTextColor(textColorInt)
                }
    }

}