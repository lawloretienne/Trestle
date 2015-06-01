package com.etiennelawlor.spannabletextview;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


// Set up 1 or more spans with a color and typeface
public class SpannableTextView extends TextView {

    //region Constructors
    public SpannableTextView(Context context) {
        super(context);
        init(null);
    }

    public SpannableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public SpannableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }
    //endregion

    // region Helper Methods
    private void init(AttributeSet attrs) {
        if (isInEditMode()) {
            return;
        }
    }

    // Set a single span
    public void setFormattedText(Span span) {
        if (span != null) {
            String text = span.getText();
            int color = span.getColor();
            Typeface typeface = span.getTypeface();

            if (!TextUtils.isEmpty(text)
                    && color != 0
                    && typeface != null) {

                SpannableString ss = setUpSpannableString(text, color, typeface);
                setText(ss);
            } else {
                Log.e("SpannableTextView", "Invalid input");
            }
        }
    }

    // Set multiple spans
    public void setFormattedText(List<Span> spans) {
        if (spans != null) {
            List<SpannableString> spannableStrings = new ArrayList<>();

            for (Span span : spans) {
                String text = span.getText();
                int color = span.getColor();
                Typeface typeface = span.getTypeface();

                if (!TextUtils.isEmpty(text)
                        && color != 0
                        && typeface != null) {

                    SpannableString ss = setUpSpannableString(text, color, typeface);
                    spannableStrings.add(ss);
                } else {
                    Log.e("SpannableTextView", "Invalid input");
                }
            }

            setText(TextUtils.concat(spannableStrings.toArray(new SpannableString[spannableStrings.size()])));
        }
    }

    private SpannableString setUpSpannableString(String text, @ColorRes int color, Typeface typeface) {
        SpannableString ss = new SpannableString(text);
        ss.setSpan(
                new ForegroundColorSpan(getContext().getResources().getColor(color)),
                0,
                text.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(
                new CustomTypefaceSpan("", typeface),
                0,
                text.length(),
                Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        return ss;
    }
    // endregion

    // region Inner Classes
    private class CustomTypefaceSpan extends TypefaceSpan {

        private final Typeface newType;

        public CustomTypefaceSpan(String family, Typeface type) {
            super(family);
            newType = type;
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            applyCustomTypeFace(ds, newType);
        }

        @Override
        public void updateMeasureState(TextPaint paint) {
            applyCustomTypeFace(paint, newType);
        }

        private void applyCustomTypeFace(Paint paint, Typeface tf) {
            int oldStyle;
            Typeface old = paint.getTypeface();
            if (old == null) {
                oldStyle = 0;
            } else {
                oldStyle = old.getStyle();
            }

            int fake = oldStyle & ~tf.getStyle();
            if ((fake & Typeface.BOLD) != 0) {
                paint.setFakeBoldText(true);
            }

            if ((fake & Typeface.ITALIC) != 0) {
                paint.setTextSkewX(-0.25f);
            }

            paint.setTypeface(tf);
        }
    }

    public static class Span {
        private String Text;
        private Integer Color;
        private Typeface Typeface;

        public Span(String text, Integer color, android.graphics.Typeface typeface) {
            Text = text;
            Color = color;
            Typeface = typeface;
        }

        public String getText() {
            return Text;
        }

        public Integer getColor() {
            return Color;
        }

        public android.graphics.Typeface getTypeface() {
            return Typeface;
        }
    }

    // endregion
}
