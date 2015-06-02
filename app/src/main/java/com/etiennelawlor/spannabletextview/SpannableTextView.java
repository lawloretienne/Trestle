package com.etiennelawlor.spannabletextview;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.util.AttributeSet;
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
            SpannableString ss = setUpSpannableString(span);
            setText(ss);
        }
    }

    // Set multiple spans
    public void setFormattedText(List<Span> spans) {
        if (spans != null) {
            List<SpannableString> spannableStrings = new ArrayList<>();

            for (Span span : spans) {
                SpannableString ss = setUpSpannableString(span);
                spannableStrings.add(ss);
            }

            setText(TextUtils.concat(spannableStrings.toArray(new SpannableString[spannableStrings.size()])));
        }
    }

    private SpannableString setUpSpannableString(Span span) {
        SpannableString ss = null;
        if (span != null) {

            String text = span.getText();

            if (!TextUtils.isEmpty(text)) {
                ss = new SpannableString(text);
            }

            int fgColor = span.getForegroundColor();
            if (fgColor != 0) {
                ss.setSpan(
                        new ForegroundColorSpan(getContext().getResources().getColor(fgColor)),
                        0,
                        text.length(),
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }

            int bgColor = span.getBackgroundColor();
            if (bgColor != 0) {
                ss.setSpan(
                        new BackgroundColorSpan(getContext().getResources().getColor(bgColor)),
                        0,
                        text.length(),
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }

            Typeface typeface = span.getTypeface();
            if (typeface != null) {
                ss.setSpan(
                        new CustomTypefaceSpan("", typeface),
                        0,
                        text.length(),
                        Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
            }

            float relativeSize = span.getRelativeSize();
            if (relativeSize != 0.0f) {
                ss.setSpan(
                        new RelativeSizeSpan(relativeSize),
                        0,
                        text.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }

            boolean isUrl = span.isUrl();
            if (isUrl) {
                ss.setSpan(
                        new URLSpan(text),
                        0,
                        text.length(),
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }

        }

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

    // endregion
}
