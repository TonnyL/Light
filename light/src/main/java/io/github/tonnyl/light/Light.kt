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
@file:JvmName("Light")
package io.github.tonnyl.light

import android.graphics.drawable.Drawable
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView

/**
 * Created by lizhaotailang on 2017/5/5.
 *
 * [Light] is an expand class of [Snackbar], in order to custom
 * the text color, the background color, the action text color and so on.
 * Definitely, you can use [Light] as [Snackbar] as you always do.
 *
 * Several methods are defined that return the customized [Snackbar]
 * and you can call them anytime. And you can create your own [Snackbar].
 *
 * [Light] is inspired by [Toasty](https://github.com/GrenderG/Toasty).
 *
 */

/**
 * Make a Snackbar to display a success message.
 * The method [make] is called internal.
 *
 * @param view The view to find a parent from.
 * @param text The message to display. Formatted text is supported.
 * @param duration How long to show the message. Either [Snackbar.LENGTH_SHORT] or [Snackbar.LENGTH_LONG].
 * Default length is [Snackbar.LENGTH_SHORT].
 *
 * @return The Snackbar that will be displayed.
 */
fun success(view: View,
            text: CharSequence,
            duration: Int = Snackbar.LENGTH_SHORT
): Snackbar = make(
        view,
        text,
        // DO NOT use the resource id directly.
        // It should be a resolved drawable or color.
        duration,
        ContextCompat.getDrawable(view.context, R.drawable.ic_success_white_24dp),
        // getResources().getColor() is deprecated.
        ContextCompat.getColor(view.context, R.color.color_success),
        ContextCompat.getColor(view.context, android.R.color.white))


/**
 * Make a Snackbar to display a success message.
 * The method [Light.make] is called internal.
 *
 * @param view The view to find a parent from.
 * @param textId The message to display. String resource id ([StringRes]) required.
 * @param duration How long to show the message. Either [Snackbar.LENGTH_SHORT] or [Snackbar.LENGTH_LONG].
 * Default length is [Snackbar.LENGTH_SHORT].
 *
 * @return The Snackbar that will be displayed.
 */
fun success(view: View,
            @StringRes textId: Int,
            duration: Int = Snackbar.LENGTH_SHORT
): Snackbar = make(
        view,
        view.context.getString(textId),
        // DO NOT use the resource id directly.
        // It should be a resolved drawable or color.
        duration,
        ContextCompat.getDrawable(view.context, R.drawable.ic_success_white_24dp),
        // getResources().getColor() is deprecated.
        ContextCompat.getColor(view.context, R.color.color_success),
        ContextCompat.getColor(view.context, android.R.color.white))

/**
 * Make a Snackbar to display an error message.
 * The method [Light.make] is called internal.
 *
 * @param view The view to find a parent from.
 * @param text The message to display. Formatted text is supported.
 * @param duration How long to show the message. Either [Snackbar.LENGTH_SHORT] or [Snackbar.LENGTH_LONG].
 * Default length is [Snackbar.LENGTH_SHORT].
 *
 * @return The Snackbar that will be displayed.
 */
fun error(view: View,
          text: CharSequence,
          duration: Int = Snackbar.LENGTH_SHORT
): Snackbar = make(view,
        text,
        duration,
        // DO NOT use the resource id directly.
        // It should be a resolved drawable or color.
        ContextCompat.getDrawable(view.context, R.drawable.ic_error_24dp),
        // getResources().getColor() is deprecated.
        ContextCompat.getColor(view.context, R.color.color_error),
        ContextCompat.getColor(view.context, android.R.color.white))

/**
 * Make a Snackbar to display an error message.
 * The method [Light.make] is called internal.
 *
 * @param view The view to find a parent from.
 * @param textId The message to display. String resource id ([StringRes]) is required.
 * @param duration How long to show the message. Either [Snackbar.LENGTH_SHORT] or [Snackbar.LENGTH_LONG].
 * Default length is [Snackbar.LENGTH_SHORT].
 *
 * @return The Snackbar that will be displayed.
 */
fun error(view: View,
          @StringRes textId: Int,
          duration: Int = Snackbar.LENGTH_SHORT
): Snackbar = make(view,
        view.context.getText(textId),
        duration,
        // DO NOT use the resource id directly.
        // It should be a resolved drawable or color.
        ContextCompat.getDrawable(view.context, R.drawable.ic_error_24dp),
        // getResources().getColor() is deprecated.
        ContextCompat.getColor(view.context, R.color.color_error),
        ContextCompat.getColor(view.context, android.R.color.white))

/**
 * Make a Snackbar to display an info message.
 * The method [Light.make] is called internal.
 *
 * @param view The view to find a parent from.
 * @param text The message to display. Formatted text is supported.
 * @param duration How long to show the message. Either [Snackbar.LENGTH_SHORT] or [Snackbar.LENGTH_LONG].
 * Default length is [Snackbar.LENGTH_SHORT].
 *
 * @return The Snackbar that will be displayed.
 */
fun info(view: View,
         text: CharSequence,
         duration: Int = Snackbar.LENGTH_SHORT
): Snackbar = make(
        view,
        text,
        duration,
        // DO NOT use the resource id directly.
        // It should be a resolved drawable or color.
        ContextCompat.getDrawable(view.context, R.drawable.ic_info_outline_white_24dp),
        // getResources().getColor() is deprecated.
        ContextCompat.getColor(view.context, R.color.color_info),
        ContextCompat.getColor(view.context, android.R.color.white))

/**
 * Make a Snackbar to display an info message.
 * The method [Light.make] is called internal.
 *
 * @param view The view to find a parent from.
 * @param textId The message to display. String resource id ([StringRes]) is required.
 * @param duration How long to show the message. Either [Snackbar.LENGTH_SHORT] or [Snackbar.LENGTH_LONG].
 * Default length is [Snackbar.LENGTH_SHORT].
 *
 * @return The Snackbar that will be displayed.
 */
fun info(view: View,
         @StringRes textId: Int,
         duration: Int = Snackbar.LENGTH_SHORT
): Snackbar = make(
        view,
        view.context.getString(textId),
        duration,
        // DO NOT use the resource id directly.
        // It should be a resolved drawable or color.
        ContextCompat.getDrawable(view.context, R.drawable.ic_info_outline_white_24dp),
        // getResources().getColor() is deprecated.
        ContextCompat.getColor(view.context, R.color.color_info),
        ContextCompat.getColor(view.context, android.R.color.white))

/**
 * Make a Snackbar to display a warning message.
 * The method [Light.make] is called internal.
 *
 * @param view The view to find a parent from.
 * @param text The message to display. Formatted text is supported.
 * @param duration How long to show the message. Either [Snackbar.LENGTH_SHORT] or [Snackbar.LENGTH_LONG].
 * Default length is [Snackbar.LENGTH_SHORT].
 *
 * @return The Snackbar that will be displayed.
 */
fun warning(view: View,
            text: CharSequence,
            duration: Int = Snackbar.LENGTH_SHORT
): Snackbar = make(
        view,
        text,
        duration,
        // DO NOT use the resource id directly.
        // It should be a resolved drawable or color.
        ContextCompat.getDrawable(view.context, R.drawable.ic_warning_outline_white_24dp),
        // getResources().getColor() is deprecated.
        ContextCompat.getColor(view.context, R.color.color_warning),
        ContextCompat.getColor(view.context, android.R.color.white))

/**
 * Make a Snackbar to display a warning message.
 * The method [Light.make] is called internal.
 *
 * @param view The view to find a parent from.
 * @param textId The message to display. String resource id ([StringRes]) is required.
 * @param duration How long to show the message. Either [Snackbar.LENGTH_SHORT] or [Snackbar.LENGTH_LONG].
 * Default length is [Snackbar.LENGTH_SHORT].
 *
 * @return The Snackbar that will be displayed.
 */
fun warning(view: View,
            @StringRes textId: Int,
            duration: Int = Snackbar.LENGTH_SHORT
): Snackbar = make(
        view,
        view.context.getString(textId),
        duration,
        // DO NOT use the resource id directly.
        // It should be a resolved drawable or color.
        ContextCompat.getDrawable(view.context, R.drawable.ic_warning_outline_white_24dp),
        // getResources().getColor() is deprecated.
        ContextCompat.getColor(view.context, R.color.color_warning),
        ContextCompat.getColor(view.context, android.R.color.white))

/**
 * Make a Snackbar to display a normal message.
 * The method [Snackbar.make] is called internal.
 *
 * @param view The view to find a parent from.
 * @param text The message to display. Formatted text is supported.
 * @param duration How long to show the message. Either [Snackbar.LENGTH_SHORT] or [Snackbar.LENGTH_LONG].
 * Default length is [Snackbar.LENGTH_SHORT].
 *
 * @return The Snackbar that will be displayed.
 */
fun normal(view: View,
           text: CharSequence,
           duration: Int = Snackbar.LENGTH_SHORT
): Snackbar = make(
        view,
        text,
        duration,
        // DO NOT use the resource id directly.
        // It should be a resolved drawable or color.
        ContextCompat.getDrawable(view.context, R.drawable.ic_warning_outline_white_24dp),
        // getResources().getColor() is deprecated.
        ContextCompat.getColor(view.context, R.color.color_warning),
        ContextCompat.getColor(view.context, android.R.color.white))

/**
 * Make a Snackbar to display a normal message.
 * The method [Snackbar.make] is called internal.
 *
 * @param view The view to find a parent from.
 * @param textId The message to display. String resource id ([StringRes]) is required.
 * @param duration How long to show the message. Either [Snackbar.LENGTH_SHORT] or [Snackbar.LENGTH_LONG].
 * Default length is [Snackbar.LENGTH_SHORT].
 *
 * @return The Snackbar that will be displayed.
 */
fun normal(view: View,
           @StringRes textId: Int,
           duration: Int = Snackbar.LENGTH_SHORT
): Snackbar = make(
        view,
        view.context.getString(textId),
        duration,
        // DO NOT use the resource id directly.
        // It should be a resolved drawable or color.
        ContextCompat.getDrawable(view.context, R.drawable.ic_warning_outline_white_24dp),
        // getResources().getColor() is deprecated.
        ContextCompat.getColor(view.context, R.color.color_warning),
        ContextCompat.getColor(view.context, android.R.color.white))

/**
 * Make a customized [Snackbar] to display a message without any action.
 *
 * @param view The view to find a parent from.
 * @param text The message to display. Formatted text is supported.
 * @param duration How long to show the message. Either [Snackbar.LENGTH_SHORT] or [Snackbar.LENGTH_LONG].
 * Default length is [Snackbar.LENGTH_SHORT].
 * @param textIcon The left icon of the message. [Drawable] is required.
 * @param backgroundColorInt The background color of the Snackbar. It should be a resolved color ([ColorInt]).
 * @param textColorInt The color of message text. Resolved color ([ColorInt]) is required.
 *
 * @return The customized Snackbar that will be displayed.
 */
fun make(view: View,
         text: CharSequence,
         duration: Int = Snackbar.LENGTH_SHORT,
         textIcon: Drawable?,
         @ColorInt backgroundColorInt: Int,
         @ColorInt textColorInt: Int = ContextCompat.getColor(view.context, android.R.color.white)
): Snackbar =
        with(Snackbar.make(view, text, duration)) {
            this.view.apply {
                setBackgroundColor(backgroundColorInt)
            }
            this.view.findViewById<TextView>(android.support.design.R.id.snackbar_text)
                    .apply {
                        // Set the left icon of message.
                        setCompoundDrawablesWithIntrinsicBounds(textIcon, null, null, null)
                        // Set the padding between message and icon.
                        compoundDrawablePadding = 16
                        // To make icon and message aligned.
                        gravity = Gravity.CENTER
                        // Change color of message text.
                        setTextColor(textColorInt)
                    }
            this
        }


/**
 * Make a customized [Snackbar] to display a message without any action.
 * Method [Light.make] is called internal.
 *
 * @param view The view to find a parent from.
 * @param text The message to display. Formatted text is supported.
 * @param duration How long to show the message. Either [Snackbar.LENGTH_SHORT] or [Snackbar.LENGTH_LONG].
 * Default length is [Snackbar.LENGTH_SHORT].
 * @param textIcon The left icon of the message. [Drawable] is required.
 * @param backgroundColorInt The background color of the Snackbar. It should be a resolved color.
 * @param textColorInt The color of message text. Resolved color ([ColorInt]) is required.
 * @param actionIcon The left icon of action message text. [Drawable] is required.
 * @param actionTextColorInt The color of action message text. Resolved color ([ColorInt]) is required.
 *
 * @return The customized Snackbar that will be displayed.
 */
fun make(view: View,
         text: CharSequence,
         duration: Int = Snackbar.LENGTH_SHORT,
         textIcon: Drawable?,
         @ColorInt backgroundColorInt: Int,
         @ColorInt textColorInt: Int,
         actionIcon: Drawable?,
         @ColorInt actionTextColorInt: Int = ContextCompat.getColor(view.context, android.R.color.white)
): Snackbar =
        with(make(view, text, duration, textIcon, backgroundColorInt, textColorInt)) {
            // Get the button of action.
            this.view.findViewById<Button>(android.support.design.R.id.snackbar_action)
                    .apply {
                        // Set the left drawable of action button.
                        setCompoundDrawablesWithIntrinsicBounds(actionIcon, null, null, null)
                        // Set the padding of drawable.
                        compoundDrawablePadding = 16
                        // Make icon and action text aligned.
                        gravity = Gravity.CENTER
                        // Set color of action text.
                        setTextColor(actionTextColorInt)
                    }
            this
        }


/**
 * Make a customized [Snackbar] to display a message without any action.
 * Method [Light.make] is called internal.
 *
 * @param view The view to find a parent from.
 * @param textRes The message to display. Formatted text is supported.
 * String resource id ([StringRes]) is required.
 * @param duration How long to show the message. Either [Snackbar.LENGTH_SHORT] or [Snackbar.LENGTH_LONG].
 * Default length is [Snackbar.LENGTH_SHORT].
 * @param textIconRes The left icon of the message. Drawable resource id ([DrawableRes]) is required.
 * @param backgroundColorRes The background color of the Snackbar. Color resource id ([ColorRes]) is required.
 * @param textColorRes The color of action message text. Color resource id ([ColorRes]) is required.
 *
 * @return The customized Snackbar that will be displayed.
 */
fun make(view: View,
         @StringRes textRes: Int,
         duration: Int,
         @DrawableRes textIconRes: Int,
         @ColorRes backgroundColorRes: Int,
         @ColorRes textColorRes: Int
): Snackbar = make(
        view,
        view.context.getString(textRes),
        duration,
        // DO NOT use the resource id directly.
        // It should be a resolved drawable or color.
        ContextCompat.getDrawable(view.context, textIconRes),
        // getResources().getColor() is deprecated.
        ContextCompat.getColor(view.context, backgroundColorRes),
        ContextCompat.getColor(view.context, textColorRes))

/**
 * Make a customized [Snackbar] to display a message without any action.
 * Method [Light.make] is called internal.
 *
 * @param view The view to find a parent from.
 * @param textRes The message to display. String resource id ([StringRes]) is required.
 * @param textIconRes The left icon of the message. Drawable resource id ([DrawableRes]) is required.
 * @param backgroundColorRes The background color of the Snackbar. Color resource id ([ColorRes]) is required.
 * @param textColorRes The color of action message text. Color resource id ([ColorRes]) is required.
 * @param duration How long to show the message. Either [Snackbar.LENGTH_SHORT] or [Snackbar.LENGTH_LONG].
 * Default length is [Snackbar.LENGTH_SHORT].
 * @param actionIconRes The left icon of action message text. Drawable resource id ([DrawableRes]) is required.
 * @param actionTextColorRes The color of action message text. Color resource id ([ColorRes]) is required.
 *
 * @return The customized Snackbar that will be displayed.
 */
fun make(view: View,
         @StringRes textRes: Int,
         duration: Int,
         @DrawableRes textIconRes: Int,
         @ColorRes backgroundColorRes: Int,
         @ColorRes textColorRes: Int,
         @DrawableRes actionIconRes: Int,
         @ColorRes actionTextColorRes: Int
): Snackbar = make(
        view,
        view.context.getString(textRes),
        duration,
        // DO NOT use the resource id directly.
        // It should be a resolved drawable or color.
        ContextCompat.getDrawable(view.context, textIconRes),
        // getResources().getColor() is deprecated.
        ContextCompat.getColor(view.context, backgroundColorRes),
        ContextCompat.getColor(view.context, textColorRes),
        ContextCompat.getDrawable(view.context, actionIconRes),
        ContextCompat.getColor(view.context, actionTextColorRes))

/**
 * Make a customized [Snackbar] to display a message without any action.
 * Method [Light.make] is called internal.
 *
 * @param view The view to find a parent from.
 * @param text The message to display. Formatted text is required.
 * @param textIconRes The left icon of the message. Drawable resource id ([DrawableRes]) is required.
 * @param backgroundColorRes The background color of the Snackbar. Color resource id ([ColorRes]) is required.
 * @param textColorRes The color of action message text. Color resource id ([ColorRes]) is required.
 * @param duration How long to show the message. Either [Snackbar.LENGTH_SHORT] or [Snackbar.LENGTH_LONG].
 * Default length is [Snackbar.LENGTH_SHORT].
 * @param actionIconRes The left icon of action message text. Drawable resource id ([DrawableRes]) is required.
 * @param actionTextColorRes The color of action message text. Color resource id ([ColorRes]) is required.
 *
 * @return The customized Snackbar that will be displayed.
 */
fun make(view: View,
         text: CharSequence,
         duration: Int,
         @DrawableRes textIconRes: Int,
         @ColorRes backgroundColorRes: Int,
         @ColorRes textColorRes: Int,
         @DrawableRes actionIconRes: Int,
         @ColorRes actionTextColorRes: Int
): Snackbar = make(
        view,
        text,
        duration,
        // DO NOT use the resource id directly.
        // It should be a resolved drawable or color.
        ContextCompat.getDrawable(view.context, textIconRes),
        // getResources().getColor() is deprecated.
        ContextCompat.getColor(view.context, backgroundColorRes),
        ContextCompat.getColor(view.context, textColorRes),
        ContextCompat.getDrawable(view.context, actionIconRes),
        ContextCompat.getColor(view.context, actionTextColorRes))

/**
 * Make a customized [Snackbar] to display a message without any action.
 * Method [Light.make] is called internal.
 *
 * @param view The view to find a parent from.
 * @param text The message to display. Formatted text is supported.
 * @param duration How long to show the message. Either [Snackbar.LENGTH_SHORT] or [Snackbar.LENGTH_LONG].
 * Default length is [Snackbar.LENGTH_SHORT].
 * @param textIconRes The left icon of the message. Drawable resource id ([DrawableRes]) is required.
 * @param backgroundColorRes The background color of the Snackbar. Color resource id ([ColorRes]) is required.
 * @param textColorRes The color of action message text. Color resource id ([ColorRes]) is required.
 *
 * @return The customized Snackbar that will be displayed.
 */
fun make(view: View,
         text: CharSequence,
         duration: Int,
         @DrawableRes textIconRes: Int,
         @ColorRes backgroundColorRes: Int,
         @ColorRes textColorRes: Int
): Snackbar = make(
        view,
        text,
        // DO NOT use the resource id directly.
        // It should be a resolved drawable or color.
        duration,
        ContextCompat.getDrawable(view.context, textIconRes),
        // getResources().getColor() is deprecated.
        ContextCompat.getColor(view.context, backgroundColorRes),
        ContextCompat.getColor(view.context, textColorRes))