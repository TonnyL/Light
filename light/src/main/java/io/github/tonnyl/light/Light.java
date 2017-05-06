/*
 * Copyright 2017 lizhaotailang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.tonnyl.light;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by lizhaotailang on 2017/5/5.
 *
 * <p>
 * {@link Light} is an expand class of {@link Snackbar}, in order to custom
 * the text color, the background color, the action text color and so on.
 * Definitely, you can use {@link Light} as {@link Snackbar} as you always do.
 * </p>
 * <p>
 * Several methods are defined that returns the customized {@link Snackbar}
 * and you can call them anytime. And you can create your own {@link Snackbar}.
 * </p>
 *
 * <p>
 * {@link Light} is inspired by <a href="https://github.com/GrenderG/Toasty">Toasty</a>.
 * </p>
 */

public class Light {

    /**
     * The symbol of success type.
     * Called in {@link Light#make(View,CharSequence, int, int)}.
     */
    public static final int TYPE_SUCCESS = 0x00;

    /**
     * The symbol of info type.
     * Called in {@link Light#make(View,CharSequence, int, int)}.
     */
    public static final int TYPE_INFO = 0x01;

    /**
     * The symbol of warning type.
     * Call in {@link Light#make(View,CharSequence, int, int)}.
     *
     */
    public static final int TYPE_WARNING = 0x02;

    /**
     * The symbol of error type.
     * Call in {@link Light#make(View,CharSequence, int, int)}.
     */
    public static final int TYPE_ERROR = 0x03;

    /**
     * The symbol of normal type.
     * Call in {@link Light#make(View,CharSequence, int, int)}.
     */
    public static final int TYPE_NORMAL = 0x04;

    /**
     * Show the Snackbar for a short period of time.
     * Same as {@link Snackbar#LENGTH_SHORT}.
     */
    public static final int LENGTH_SHORT = Snackbar.LENGTH_SHORT;

    /**
     * Show the Snackbar for a long period of time.
     *
     * Same as {@link Snackbar#LENGTH_LONG}.
     */
    public static final int LENGTH_LONG = Snackbar.LENGTH_LONG;

    /**
     * Show the Snackbar indefinitely. The Snackbar will not dismissed
     * until next Snackbar will be displayed.
     *
     * Same as {@link Snackbar#LENGTH_INDEFINITE}.
     */
    public static final int LENGTH_INDEFINITE = Snackbar.LENGTH_INDEFINITE;

    // Prevent direct instantiation
    private Light() {}

    /**
     * Make a {@link Snackbar} to display a message.
     *
     * @param view The view to find a parent from.
     * @param text The message to display. Formatted text is supported.
     * @param type The type of the Snackbar to show.
     *             See {@link Light#TYPE_SUCCESS}, {@link Light#TYPE_INFO}, {@link Light#TYPE_NORMAL},
     *             {@link Light#TYPE_WARNING}, {@link Light#TYPE_ERROR}.
     * @param duration How long to show the message.
     *                 Either {@link Light#LENGTH_SHORT} or {@link Light#LENGTH_LONG}.
     * @return The Snackbar that will be displayed.
     */
    public static Snackbar make(@NonNull View view, @NonNull CharSequence text, int type, int duration) {
        switch (type) {
            case TYPE_ERROR:
                return error(view, text, duration);
            case TYPE_WARNING:
                return info(view, text, duration);
            case TYPE_INFO:
                return info(view, text, duration);
            case TYPE_SUCCESS:
                return success(view, text, duration);
            case TYPE_NORMAL:
                // Default type is TYPE_NORMAL.
            default:
                return Snackbar.make(view, text, duration);
        }
    }

    /**
     * Make a Snackbar of {@link Light#TYPE_SUCCESS} to display a message.
     * The method {@link Light#make(View, CharSequence, Drawable, int, int, int)}
     * is called internal.
     *
     * @param view The view to find a parent from.
     * @param text The message to display. Formatted text is supported.
     * @param duration How long to show the message.
     *                 Either {@link Light#LENGTH_SHORT} or {@link Light#LENGTH_LONG}.
     * @return The Snackbar that will be displayed.
     */
    public static Snackbar success(@NonNull View view, @NonNull CharSequence text, int duration) {
        Context context = view.getContext();
        return make(view,
                text,
                // DO NOT use the resource id directly.
                // It should be a resolved drawable or color.
                ContextCompat.getDrawable(context, R.drawable.ic_success_white_24dp),
                // getResources().getColor() is deprecated.
                ContextCompat.getColor(context, R.color.color_success),
                ContextCompat.getColor(context, android.R.color.white),
                duration);
    }

    /**
     * Make a Snackbar of {@link Light#TYPE_ERROR} to display a message.
     * The method {@link Light#make(View, CharSequence, Drawable, int, int, int)}
     * is called internal.
     *
     * @param view The view to find a parent from.
     * @param text The message to display. Formatted text is supported.
     * @param duration How long to show the message.
     *                 Either {@link Light#LENGTH_SHORT} or {@link Light#LENGTH_LONG}.
     * @return The Snackbar that will be displayed.
     */
    public static Snackbar error(@NonNull View view, @NonNull CharSequence text, int duration) {
        Context context = view.getContext();
        return make(view,
                text,
                // DO NOT use the resource id directly.
                // It should be a resolved drawable or color.
                ContextCompat.getDrawable(context, R.drawable.ic_error_24dp),
                // getResources().getColor() is deprecated.
                ContextCompat.getColor(context, R.color.color_error),
                ContextCompat.getColor(context, android.R.color.white),
                duration);
    }

    /**
     * Make a Snackbar of {@link Light#TYPE_INFO} to display a message.
     * The method {@link Light#make(View, CharSequence, Drawable, int, int, int)}
     * is called internal.
     *
     * @param view The view to find a parent from.
     * @param text The message to display. Formatted text is supported.
     * @param duration How long to show the message.
     *                 Either {@link Light#LENGTH_SHORT} or {@link Light#LENGTH_LONG}.
     * @return The Snackbar that will be displayed.
     */
    public static Snackbar info(@NonNull View view, @NonNull CharSequence text, int duration) {
        Context context = view.getContext();
        return make(view,
                text,
                // DO NOT use the resource id directly.
                // It should be a resolved drawable or color.
                ContextCompat.getDrawable(context, R.drawable.ic_info_outline_white_24dp),
                // getResources().getColor() is deprecated.
                ContextCompat.getColor(context, R.color.color_info),
                ContextCompat.getColor(context, android.R.color.white),
                duration);
    }

    /**
     * Make a Snackbar of {@link Light#TYPE_WARNING} to display a message.
     * The method {@link Light#make(View, CharSequence, Drawable, int, int, int)}
     * is called internal.
     *
     * @param view The view to find a parent from.
     * @param text The message to display. Formatted text is supported.
     * @param duration How long to show the message.
     *                 Either {@link Light#LENGTH_SHORT} or {@link Light#LENGTH_LONG}.
     * @return The Snackbar that will be displayed.
     */
    public static Snackbar warning(@NonNull View view, @NonNull CharSequence text, int duration) {
        Context context = view.getContext();
        return make(view,
                text,
                // DO NOT use the resource id directly.
                // It should be a resolved drawable or color.
                ContextCompat.getDrawable(context, R.drawable.ic_warning_outline_white_24dp),
                // getResources().getColor() is deprecated.
                ContextCompat.getColor(context, R.color.color_warning),
                ContextCompat.getColor(context, android.R.color.white),
                duration);
    }

    /**
     * Make a Snackbar of {@link Light#TYPE_NORMAL} to display a message.
     * The method {@link Snackbar#make(View, int, int)}
     * is called internal.
     *
     * @param view The view to find a parent from.
     * @param text The message to display. Formatted text is supported.
     * @param duration How long to show the message.
     *                 Either {@link Light#LENGTH_SHORT} or {@link Light#LENGTH_LONG}.
     * @return The Snackbar that will be displayed.
     */
    public static Snackbar normal(@NonNull View view, @NonNull CharSequence text, int duration) {
        return Snackbar.make(view, text, duration);
    }

    /**
     * Make a customized {@link Snackbar} to display a message without any action.
     *
     * @param view The view to find a parent from.
     * @param text The message to display. Formatted text is supported.
     * @param textIcon The left icon of the message.
     * @param backgroundColor The background color of the Snackbar. It should be a resolved color.
     * @param textColor The color of message text.
     * @param duration How long to show the message.
     *                 Either {@link Light#LENGTH_SHORT} or {@link Light#LENGTH_LONG}.
     *
     * @return The customized Snackbar that will be displayed.
     */
    public static Snackbar make(@NonNull View view, @NonNull CharSequence text, Drawable textIcon,
                                @ColorInt int backgroundColor, @ColorInt int textColor, int duration) {
        // Get a usual Snackbar
        Snackbar snackbar = Snackbar.make(view, text, duration);

        // Get the view of it.
        View mView = snackbar.getView();
        // Change the background color.
        mView.setBackgroundColor(backgroundColor);

        // Get the TextView of message.
        TextView textView = (TextView) mView.findViewById(android.support.design.R.id.snackbar_text);
        // Set the left icon of message.
        textView.setCompoundDrawablesWithIntrinsicBounds(textIcon, null, null, null);
        // Set the padding between message and icon.
        textView.setCompoundDrawablePadding(16);
        // To make icon and message aligned.
        textView.setGravity(Gravity.CENTER);
        // Change color of message text.
        textView.setTextColor(textColor);

        return snackbar;
    }

    /**
     * Make a customized {@link Snackbar} to display a message without any action.
     * Method {@link Light#make(View, CharSequence, Drawable, int, int, int)} is called internal.
     *
     * @param view The view to find a parent from.
     * @param text The message to display. Formatted text is supported.
     * @param textIcon The left icon of the message.
     * @param backgroundColor The background color of the Snackbar. It should be a resolved color.
     * @param textColor The color of message text.
     * @param duration How long to show the message.
     *                 Either {@link Light#LENGTH_SHORT} or {@link Light#LENGTH_LONG}.
     * @param actionIcon The left icon of action message text.
     * @param actionTextColor The color of action message text. Resolved color required.
     *
     * @return The customized Snackbar that will be displayed.
     */

    public static Snackbar make(@NonNull View view, @NonNull CharSequence text, Drawable textIcon,
                                @ColorInt int backgroundColor, @ColorInt int textColor,
                                int duration, Drawable actionIcon, @ColorInt int actionTextColor) {
        // Call the {@link Light#make(View, CharSequence, Drawable, int, int, int)}
        // and get the Snackbar whose message text is customized.
        Snackbar snackbar = make(view, text, textIcon, backgroundColor, textColor, duration);

        // Get the button of action.
        Button actionButton = (Button) snackbar.getView().findViewById(android.support.design.R.id.snackbar_action);
        // Same to TextView of message, set the left icon of action.
        actionButton.setCompoundDrawablesWithIntrinsicBounds(actionIcon, null, null, null);
        // Set the padding between action text and icon.
        actionButton.setCompoundDrawablePadding(16);
        // To make icon and action text aligned.
        actionButton.setGravity(Gravity.CENTER);
        // Change color of action text.
        actionButton.setTextColor(actionTextColor);

        return snackbar;
    }

    /**
     * Make a customized {@link Snackbar} to display a message without any action.
     * Method {@link Light#make(View, CharSequence, Drawable, int, int, int)}
     *
     * @param view The view to find a parent from.
     * @param textRes The message to display. Formatted text is supported.
     *                String id required.
     * @param textIconRes The left icon of the message. Drawable resource id required.
     * @param backgroundColorRes The background color of the Snackbar. Color resource id required.
     * @param textColorRes The color of action message text. Color resource id required.
     * @param duration How long to show the message.
     *                 Either {@link Light#LENGTH_SHORT} or {@link Light#LENGTH_LONG}.
     * @return The customized Snackbar that will be displayed.
     */
    public static Snackbar make(@NonNull View view, @StringRes int textRes, @DrawableRes int textIconRes,
                                @ColorRes int backgroundColorRes, @ColorRes int textColorRes, int duration) {
        Context context = view.getContext();
        return make(view,
                context.getString(textRes),
                // DO NOT use the resource id directly.
                // It should be a resolved drawable or color.
                ContextCompat.getDrawable(context, textIconRes),
                // getResources().getColor() is deprecated.
                ContextCompat.getColor(context, backgroundColorRes),
                ContextCompat.getColor(context, textColorRes),
                duration);
    }

    /**
     * Make a customized {@link Snackbar} to display a message without any action.
     * Method {@link Light#make(View, int, int, int, int, int, int, int)} is called internal.
     *
     * @param view The view to find a parent from.
     * @param textRes The message to display. String resource id required.
     * @param textIconRes The left icon of the message. Drawable resource id required.
     * @param backgroundColorRes The background color of the Snackbar. Color resource id required.
     * @param textColorRes The color of action message text. Color resource id required.
     * @param duration How long to show the message.
     *                 Either {@link Light#LENGTH_SHORT} or {@link Light#LENGTH_LONG}.
     * @param actionIconRes The left icon of action message text. Drawable resource id required.
     * @param actionTextColorRes The color of action message text. Color resource id required.
     *
     * @return The customized Snackbar that will be displayed.
     */
    public static Snackbar make(@NonNull View view, @StringRes int textRes, @DrawableRes int textIconRes,
                                @ColorRes int backgroundColorRes, @ColorRes int textColorRes,
                                int duration, @DrawableRes int actionIconRes, @ColorRes int actionTextColorRes) {
        Context context = view.getContext();
        return make(view,
                context.getString(textRes),
                // DO NOT use the resource id directly.
                // It should be a resolved drawable or color.
                ContextCompat.getDrawable(context, textIconRes),
                // getResources().getColor() is deprecated.
                ContextCompat.getColor(context, backgroundColorRes),
                ContextCompat.getColor(context, textColorRes),
                duration,
                ContextCompat.getDrawable(context, actionIconRes),
                ContextCompat.getColor(context, actionTextColorRes));
    }

    /**
     * Make a customized {@link Snackbar} to display a message without any action.
     * Method {@link Light#make(View, CharSequence, Drawable, int, int, int)}.
     *
     * @param view The view to find a parent from.
     * @param text The message to display. Formatted text is supported.
     * @param textIconRes The left icon of the message. Drawable resource id required.
     * @param backgroundColorRes The background color of the Snackbar. Color resource id required.
     * @param textColorRes The color of action message text. Color resource id required.
     * @param duration How long to show the message.
     *                 Either {@link Light#LENGTH_SHORT} or {@link Light#LENGTH_LONG}.
     *
     * @return The customized Snackbar that will be displayed.
     */
    public static Snackbar make(@NonNull View view, @NonNull CharSequence text, @DrawableRes int textIconRes,
                                @ColorRes int backgroundColorRes, @ColorRes int textColorRes, int duration) {
        Context context = view.getContext();
        return make(view,
                text,
                // DO NOT use the resource id directly.
                // It should be a resolved drawable or color.
                ContextCompat.getDrawable(context, textIconRes),
                // getResources().getColor() is deprecated.
                ContextCompat.getColor(context, backgroundColorRes),
                ContextCompat.getColor(context, textColorRes),
                duration);
    }

    /**
     * Make a customized {@link Snackbar} to display a message without any action.
     * Method {@link Light#make(View, CharSequence, Drawable, int, int, int, Drawable, int) }
     *
     * @param view The view to find a parent from.
     * @param text The message to display. Formatted text is supported.
     * @param textIconRes The left icon of the message. Drawable resource id required.
     * @param backgroundColorRes The background color of the Snackbar. Color resource id required.
     * @param textColorRes The color of action message text. Color resource id required.
     * @param duration How long to show the message.
     *                 Either {@link Light#LENGTH_SHORT} or {@link Light#LENGTH_LONG}.
     * @param actionIconRes The left icon of action message text. Drawable resource id required.
     * @param actionTextColorRes The color of action message text. Color resource id required.
     *
     * @return The customized Snackbar that will be displayed.
     */
    public static Snackbar make(@NonNull View view, @NonNull CharSequence text, @DrawableRes int textIconRes,
                                @ColorRes int backgroundColorRes, @ColorRes int textColorRes,
                                int duration, @DrawableRes int actionIconRes, @ColorRes int actionTextColorRes) {
        Context context = view.getContext();
        return make(view,
                text,
                // DO NOT use the resource id directly.
                // It should be a resolved drawable or color.
                ContextCompat.getDrawable(context, textIconRes),
                // getResources().getColor() is deprecated.
                ContextCompat.getColor(context, backgroundColorRes),
                ContextCompat.getColor(context, textColorRes),
                duration,
                ContextCompat.getDrawable(context, actionIconRes),
                ContextCompat.getColor(context, actionTextColorRes));
    }

}
