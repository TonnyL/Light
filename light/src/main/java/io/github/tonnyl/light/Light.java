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
import android.widget.TextView;

/**
 * Created by lizhaotailang on 2017/5/5.
 */

public class Light {

    public static final int TYPE_SUCCESS = 0x00;
    public static final int TYPE_INFO = 0x01;
    public static final int TYPE_WARNING = 0x02;
    public static final int TYPE_ERROR = 0x03;
    public static final int TYPE_NORMAL = 0x04;

    public static final int LENGTH_SHORT = Snackbar.LENGTH_SHORT;
    public static final int LENGTH_LONG = Snackbar.LENGTH_LONG;
    public static final int LENGTH_INDEFINITE = Snackbar.LENGTH_INDEFINITE;

    // Prevent direct instantiation
    private Light() {}

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
            default:
                return Snackbar.make(view, text, duration);
        }
    }

    public static Snackbar success(@NonNull View view, @NonNull CharSequence text, int duration) {
        return make(view,
                text,
                R.drawable.ic_success_white_24dp,
                R.color.color_success,
                R.color.accent_color_success,
                duration);
    }

    public static Snackbar error(@NonNull View view, @NonNull CharSequence text, int duration) {
        return make(view,
                text,
                R.drawable.ic_error_24dp,
                R.color.color_error,
                R.color.accent_color_error,
                duration);
    }

    public static Snackbar info(@NonNull View view, @NonNull CharSequence text, int duration) {
        return make(view,
                text,
                R.drawable.ic_info_outline_white_24dp,
                R.color.color_info,
                R.color.accent_color_info,
                duration);
    }

    public static Snackbar warning(@NonNull View view, @NonNull CharSequence text, int duration) {
        return make(view,
                text,
                R.drawable.ic_warning_outline_white_24dp,
                R.color.color_warning,
                R.color.accent_color_warning,
                duration);
    }

    public static Snackbar make(@NonNull View view, @NonNull CharSequence text, Drawable textIcon,
                                @ColorInt int backgroundColor, @ColorInt int textColor, int duration) {
        Snackbar snackbar = Snackbar.make(view, text, duration);

        View mView = snackbar.getView();
        mView.setBackgroundColor(backgroundColor);

        TextView textView = (TextView) mView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setCompoundDrawablesWithIntrinsicBounds(textIcon, null, null, null);
        textView.setCompoundDrawablePadding(16);
        textView.setGravity(Gravity.CENTER);

        return snackbar;
    }

    public static Snackbar make(@NonNull View view, @NonNull CharSequence text, Drawable textIcon,
                                @ColorInt int backgroundColor, @ColorInt int textColor,
                                int duration, @NonNull CharSequence action, Drawable actionIcon, @ColorInt int actionTextColor) {
        Snackbar snackbar = Snackbar.make(view, text, duration);

        View mView = snackbar.getView();
        mView.setBackgroundColor(backgroundColor);

        return snackbar;
    }

    public static Snackbar make(@NonNull View view, @StringRes int textRes, @DrawableRes int textIconRes,
                                @ColorRes int backgroundColorRes, @ColorRes int textColorRes, int duration) {
        Context context = view.getContext();
        return make(view,
                context.getString(textRes),
                ContextCompat.getDrawable(context, textIconRes),
                ContextCompat.getColor(context, backgroundColorRes),
                ContextCompat.getColor(context, textColorRes),
                duration);
    }

    public static Snackbar make(@NonNull View view, @StringRes int textRes, @DrawableRes int textIconRes,
                                @ColorRes int backgroundColorRes, @ColorRes int textColorRes,
                                int duration, @StringRes int actionRes, @DrawableRes int actionIconRes, @ColorRes int actionTextColorRes) {
        Context context = view.getContext();
        return make(view,
                context.getString(textRes),
                ContextCompat.getDrawable(context, textIconRes),
                ContextCompat.getColor(context, backgroundColorRes),
                ContextCompat.getColor(context, textColorRes),
                duration,
                context.getString(actionRes),
                ContextCompat.getDrawable(context, actionIconRes),
                ContextCompat.getColor(context, actionTextColorRes));
    }

    public static Snackbar make(@NonNull View view, @NonNull CharSequence text, @DrawableRes int textIconRes,
                                @ColorRes int backgroundColorRes, @ColorRes int textColorRes, int duration) {
        Context context = view.getContext();
        return make(view,
                text,
                ContextCompat.getDrawable(context, textIconRes),
                ContextCompat.getColor(context, backgroundColorRes),
                ContextCompat.getColor(context, textColorRes),
                duration);
    }

    public static Snackbar make(@NonNull View view, @NonNull CharSequence text, @DrawableRes int textIconRes,
                                @ColorRes int backgroundColorRes, @ColorRes int textColorRes,
                                int duration, @NonNull CharSequence action, @DrawableRes int actionIconRes, @ColorRes int actionTextColorRes) {
        Context context = view.getContext();
        return make(view,
                text,
                ContextCompat.getDrawable(context, textIconRes),
                ContextCompat.getColor(context, backgroundColorRes),
                ContextCompat.getColor(context, textColorRes),
                duration,
                action,
                ContextCompat.getDrawable(context, actionIconRes),
                ContextCompat.getColor(context, actionTextColorRes));
    }

}
