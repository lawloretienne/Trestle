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
import android.text.style.QuoteSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

            int start;
            int end;

            String regex = span.getRegex();
            if(!TextUtils.isEmpty(regex)){
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(text);
                while (matcher.find()) {

                    start = matcher.start();
                    end = matcher.end();

                    setUpForegroundColorSpan(span, ss, start, end);
                    setUpBackgroundColorSpan(span, ss, start, end);
                    setUpTypefaceSpan(span, ss, start, end);
                    setUpRelativeSizeSpan(span, ss, start, end);
                    setUpUrlSpan(span, ss, text, start, end);
                    setUpUnderlineSpan(span, ss, start, end);
                    setUpStrikethruSpan(span, ss, start, end);
                    setUpQuoteSpan(span, ss, start, end);
                    setUpSubscriptSpan(span, ss, start, end);
                    setUpSuperscriptSpan(span, ss, start, end);
                }
            } else {
                start = 0;
                end = text.length();

                setUpForegroundColorSpan(span, ss, start, end);
                setUpBackgroundColorSpan(span, ss, start, end);
                setUpTypefaceSpan(span, ss, start, end);
                setUpRelativeSizeSpan(span, ss, start, end);
                setUpUrlSpan(span, ss, text, start, end);
                setUpUnderlineSpan(span, ss, start, end);
                setUpStrikethruSpan(span, ss, start, end);
                setUpQuoteSpan(span, ss, start, end);
                setUpSubscriptSpan(span, ss, start, end);
                setUpSuperscriptSpan(span, ss, start, end);
            }
        }

        return ss;
    }

    private void setUpForegroundColorSpan(Span span, SpannableString ss, int start, int end){
        int fgColor = span.getForegroundColor();
        if (fgColor != 0) {
            ss.setSpan(
                    new ForegroundColorSpan(getContext().getResources().getColor(fgColor)),
                    start,
                    end,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    private void setUpBackgroundColorSpan(Span span, SpannableString ss, int start, int end){
        int bgColor = span.getBackgroundColor();
        if (bgColor != 0) {
            ss.setSpan(
                    new BackgroundColorSpan(getContext().getResources().getColor(bgColor)),
                    start,
                    end,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    private void setUpTypefaceSpan(Span span, SpannableString ss, int start, int end){
        Typeface typeface = span.getTypeface();
        if (typeface != null) {
            ss.setSpan(
                    new CustomTypefaceSpan("", typeface),
                    start,
                    end,
                    Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        }
    }

    private void setUpRelativeSizeSpan(Span span, SpannableString ss, int start, int end){
        float relativeSize = span.getRelativeSize();
        if (relativeSize != 0.0f) {
            ss.setSpan(
                    new RelativeSizeSpan(relativeSize),
                    start,
                    end,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    private void setUpUrlSpan(Span span, SpannableString ss, String text, int start, int end){
        boolean isUrl = span.isUrl();
        if (isUrl) {
            ss.setSpan(
                    new URLSpan(text),
                    start,
                    end,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    private void setUpUnderlineSpan(Span span, SpannableString ss, int start, int end){
        boolean isUnderline = span.isUnderline();
        if (isUnderline) {
            ss.setSpan(
                    new UnderlineSpan(),
                    start,
                    end,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    private void setUpStrikethruSpan(Span span, SpannableString ss, int start, int end){
        boolean isStrikethru = span.isStrikethru();
        if (isStrikethru) {
            ss.setSpan(
                    new StrikethroughSpan(),
                    start,
                    end,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    private void setUpQuoteSpan(Span span, SpannableString ss, int start, int end){
        int quoteColor = span.getQuoteColor();
        if (quoteColor != 0) {
            ss.setSpan(
                    new QuoteSpan(quoteColor),
                    start,
                    end,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    private void setUpSubscriptSpan(Span span, SpannableString ss, int start, int end){
        boolean isSubscript = span.isSubscript();
        if (isSubscript) {
            ss.setSpan(
                    new SubscriptSpan(),
                    start,
                    end,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    private void setUpSuperscriptSpan(Span span, SpannableString ss, int start, int end){
        boolean isSuperscript = span.isSuperscript();
        if (isSuperscript) {
            ss.setSpan(
                    new SuperscriptSpan(),
                    start,
                    end,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
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
