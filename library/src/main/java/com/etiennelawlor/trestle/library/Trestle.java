package com.etiennelawlor.trestle.library;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.QuoteSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by etiennelawlor on 6/4/15.
 */
public class Trestle {
    // Set a single span
    public static SpannableString getFormattedText(Span span) {
        SpannableString ss = null;
        if (span != null) {
            ss = setUpSpannableString(span);
        }
        return ss;
    }

    // Set multiple spans
    public static CharSequence getFormattedText(List<Span> spans) {
        CharSequence formattedText = null;

        if (spans != null) {
            int size = spans.size();
            List<SpannableString> spannableStrings = new ArrayList<>(size);

            for (Span span : spans) {
                SpannableString ss = setUpSpannableString(span);
                spannableStrings.add(ss);
            }

            formattedText = TextUtils.concat(spannableStrings.toArray(new SpannableString[size]));
        }

        return formattedText;
    }

    private static SpannableString setUpSpannableString(Span span) {
        SpannableString ss = null;
        if (span != null) {
            String text = span.getText();

            ss = new SpannableString(text);

            int start;
            int end;

            String regex = span.getRegex();
            if (!TextUtils.isEmpty(regex)) {
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(text);
                while (matcher.find()) {

                    start = matcher.start();
                    end = matcher.end();

                    setUpForegroundColorSpan(span, ss, start, end);
                    setUpBackgroundColorSpan(span, ss, start, end);
                    setUpTypefaceSpan(span, ss, start, end);
                    setUpRelativeSizeSpan(span, ss, start, end);
                    setUpAbsoluteSizeSpan(span, ss, start, end);
                    setUpUrlSpan(span, ss, text, start, end);
                    setUpUnderlineSpan(span, ss, start, end);
                    setUpStrikethruSpan(span, ss, start, end);
                    setUpQuoteSpan(span, ss, start, end);
                    setUpSubscriptSpan(span, ss, start, end);
                    setUpSuperscriptSpan(span, ss, start, end);
                    setUpClickableSpan(span, ss, start, end);
                    setUpScaleXSpan(span, ss, start, end);
                }
            } else {
                start = 0;
                end = text.length();

                setUpForegroundColorSpan(span, ss, start, end);
                setUpBackgroundColorSpan(span, ss, start, end);
                setUpTypefaceSpan(span, ss, start, end);
                setUpRelativeSizeSpan(span, ss, start, end);
                setUpAbsoluteSizeSpan(span, ss, start, end);
                setUpUrlSpan(span, ss, text, start, end);
                setUpUnderlineSpan(span, ss, start, end);
                setUpStrikethruSpan(span, ss, start, end);
                setUpQuoteSpan(span, ss, start, end);
                setUpSubscriptSpan(span, ss, start, end);
                setUpSuperscriptSpan(span, ss, start, end);
                setUpClickableSpan(span, ss, start, end);
                setUpScaleXSpan(span, ss, start, end);
            }
        }

        return ss;
    }

    private static void setUpForegroundColorSpan(Span span, SpannableString ss, int start, int end) {
        int fgColor = span.getForegroundColor();
        if (fgColor != 0) {
            ss.setSpan(
                new ForegroundColorSpan(fgColor),
                start,
                end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    private static void setUpBackgroundColorSpan(Span span, SpannableString ss, int start, int end) {
        int bgColor = span.getBackgroundColor();
        if (bgColor != 0) {
            ss.setSpan(
                new BackgroundColorSpan(bgColor),
                start,
                end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    private static void setUpTypefaceSpan(Span span, SpannableString ss, int start, int end) {
        Typeface typeface = span.getTypeface();
        if (typeface != null) {
            ss.setSpan(
                new CustomTypefaceSpan("", typeface),
                start,
                end,
                Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        }
    }

    private static void setUpRelativeSizeSpan(Span span, SpannableString ss, int start, int end) {
        float relativeSize = span.getRelativeSize();
        if (relativeSize != 0) {
            ss.setSpan(
                new RelativeSizeSpan(relativeSize),
                start,
                end,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    private static void setUpAbsoluteSizeSpan(Span span, SpannableString ss, int start, int end) {
        int absoluteSize = span.getAbsoluteSize();
        if (absoluteSize != 0) {
            ss.setSpan(
                new AbsoluteSizeSpan(absoluteSize, true),
                start,
                end,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    private static void setUpUrlSpan(Span span, SpannableString ss, String text, int start, int end) {
        if (span.isUrl()) {
            ss.setSpan(
                new URLSpan(text),
                start,
                end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    private static void setUpUnderlineSpan(Span span, SpannableString ss, int start, int end) {
        if (span.isUnderline()) {
            ss.setSpan(
                new UnderlineSpan(),
                start,
                end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    private static void setUpStrikethruSpan(Span span, SpannableString ss, int start, int end) {
        if (span.isStrikethru()) {
            ss.setSpan(
                new StrikethroughSpan(),
                start,
                end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    private static void setUpQuoteSpan(Span span, SpannableString ss, int start, int end) {
        int quoteColor = span.getQuoteColor();
        if (quoteColor != 0) {
            ss.setSpan(
                new QuoteSpan(quoteColor),
                start,
                end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    private static void setUpSubscriptSpan(Span span, SpannableString ss, int start, int end) {
        if (span.isSubscript()) {
            ss.setSpan(
                new SubscriptSpan(),
                start,
                end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    private static void setUpSuperscriptSpan(Span span, SpannableString ss, int start, int end) {
        if (span.isSuperscript()) {
            ss.setSpan(
                new SuperscriptSpan(),
                start,
                end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    private static void setUpClickableSpan(Span span, SpannableString ss, int start, int end) {
        ClickableSpan clickableSpan = span.getClickableSpan();
        if (clickableSpan != null) {
            ss.setSpan(
                clickableSpan,
                start,
                end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    private static void setUpScaleXSpan(Span span, SpannableString ss, int start, int end) {
        float scaleX = span.getScaleX();
        if (scaleX != 0) {
            ss.setSpan(
                new ScaleXSpan(scaleX),
                start,
                end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }
    // endregion

    // region Inner Classes
    private static class CustomTypefaceSpan extends TypefaceSpan {
        private final Typeface newType;

        public CustomTypefaceSpan(String family, Typeface type) {
            super(family);
            this.newType = type;
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            applyCustomTypeFace(ds, this.newType);
        }

        @Override
        public void updateMeasureState(TextPaint paint) {
            applyCustomTypeFace(paint, this.newType);
        }

        private static void applyCustomTypeFace(Paint paint, Typeface tf) {
            int oldStyle;
            Typeface old = paint.getTypeface();
            oldStyle = old == null ? 0 : old.getStyle();

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
