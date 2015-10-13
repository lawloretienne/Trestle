package com.etiennelawlor.trestle.library;

import android.graphics.Typeface;
import android.text.style.ClickableSpan;

/**
 * Created by etiennelawlor on 6/1/15.
 */
public final class Span {
    // region Member Variables
    private final String text;
    private int foregroundColor = -1;
    private int backgroundColor = -1;
    private final float relativeSize;
    private int absoluteSize = -1;
    private final Typeface typeface;
    private final boolean isUrl;
    private final boolean isUnderline;
    private final boolean isStrikethru;
    private int quoteColor = -1;
    private final boolean isSubscript;
    private final boolean isSuperscript;
    private final String regex;
    private final ClickableSpan clickableSpan;
    private final float scaleX;

    // endregion

    // region Constructor
    Span(Builder builder) {
        this.text = builder.text;
        this.foregroundColor = builder.foregroundColor;
        this.backgroundColor = builder.backgroundColor;
        this.typeface = builder.typeface;
        this.relativeSize = builder.relativeSize;
        this.absoluteSize = builder.absoluteSize;
        this.isUrl = builder.isUrl;
        this.isUnderline = builder.isUnderline;
        this.isStrikethru = builder.isStrikethru;
        this.quoteColor = builder.quoteColor;
        this.isSubscript = builder.isSubscript;
        this.isSuperscript = builder.isSuperscript;
        this.regex = builder.regex;
        this.clickableSpan = builder.clickableSpan;
        this.scaleX = builder.scaleX;
    }
    // endregion

    // region Getters
    public String getText() {
        return this.text;
    }

    public int getForegroundColor() {
        return this.foregroundColor;
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    public float getRelativeSize() {
        return this.relativeSize;
    }

    public int getAbsoluteSize() {
        return this.absoluteSize;
    }

    public boolean isUrl() {
        return this.isUrl;
    }

    public boolean isUnderline() {
        return this.isUnderline;
    }

    public boolean isStrikethru() {
        return this.isStrikethru;
    }

    public int getQuoteColor() {
        return this.quoteColor;
    }

    public boolean isSubscript() {
        return this.isSubscript;
    }

    public boolean isSuperscript() {
        return this.isSuperscript;
    }

    public String getRegex() {
        return this.regex;
    }

    public ClickableSpan getClickableSpan() {
        return this.clickableSpan;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    // endregion

    // region Builder class

    public static class Builder {
        // Required parameters
        private final String text;

        // Optional parameters - initialized to default values
        private int foregroundColor;
        private int backgroundColor;
        private Typeface typeface;
        private float relativeSize;
        private int absoluteSize;
        private boolean isUrl;
        private boolean isUnderline;
        private boolean isStrikethru;
        private int quoteColor;
        private boolean isSubscript;
        private boolean isSuperscript;
        private String regex = "";
        private ClickableSpan clickableSpan;
        private float scaleX;

        public Builder(String text) {
            this.text = text;
        }

        public Builder foregroundColor(int fgColor) {
            this.foregroundColor = fgColor;
            return this;
        }

        public Builder backgroundColor(int bgColor) {
            this.backgroundColor = bgColor;
            return this;
        }

        public Builder typeface(Typeface typeface) {
            this.typeface = typeface;
            return this;
        }

        public Builder relativeSize(float relativeSize) {
            this.relativeSize = relativeSize;
            return this;
        }

        public Builder absoluteSize(int absoluteSize) {
            this.absoluteSize = absoluteSize;
            return this;
        }

        public Builder isUrl(boolean isUrl) {
            this.isUrl = isUrl;
            return this;
        }

        public Builder isUnderline(boolean isUnderline) {
            this.isUnderline = isUnderline;
            return this;
        }

        public Builder isStrikethru(boolean isStrikethru) {
            this.isStrikethru = isStrikethru;
            return this;
        }

        public Builder quoteColor(int quoteColor) {
            this.quoteColor = quoteColor;
            return this;
        }

        public Builder subscript(boolean isSubscript) {
            this.isSubscript = isSubscript;
            return this;
        }

        public Builder superscript(boolean isSuperscript) {
            this.isSuperscript = isSuperscript;
            return this;
        }

        public Builder regex(String regex) {
            this.regex = regex;
            return this;
        }

        public Builder clickableSpan(ClickableSpan clickableSpan) {
            this.clickableSpan = clickableSpan;
            return this;
        }

        public Builder scaleX(float scaleX) {
            this.scaleX = scaleX;
            return this;
        }

        public Span build() {
            return new Span(this);
        }
    }
    // endregion

}
