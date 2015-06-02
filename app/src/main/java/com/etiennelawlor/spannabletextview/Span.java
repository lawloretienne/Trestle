package com.etiennelawlor.spannabletextview;

import android.graphics.Typeface;

/**
 * Created by etiennelawlor on 6/1/15.
 */
public class Span {

    // region Member Variables
    private String Text;
    private Integer ForegroundColor;
    private Integer BackgroundColor;
    private float RelativeSize;
    private android.graphics.Typeface Typeface;
    private boolean IsUrl;
    private boolean IsUnderline;
    private boolean IsStrikethru;
    private Integer QuoteColor;
    private boolean IsSubscript;
    private boolean IsSuperscript;
    // endregion

    // region Constructor
    private Span(Builder builder) {
        Text = builder.Text;
        ForegroundColor = builder.ForegroundColor;
        BackgroundColor = builder.BackgroundColor;
        Typeface = builder.Typeface;
        RelativeSize = builder.RelativeSize;
        IsUrl = builder.IsUrl;
        IsUnderline = builder.IsUnderline;
        IsStrikethru = builder.IsStrikethru;
        QuoteColor = builder.QuoteColor;
        IsSubscript = builder.IsSubscript;
        IsSuperscript = builder.IsSuperscript;
    }
    // endregion

    // region Getters
    public String getText() {
        return Text;
    }

    public Integer getForegroundColor() {
        return ForegroundColor;
    }

    public Integer getBackgroundColor() {
        return BackgroundColor;
    }

    public android.graphics.Typeface getTypeface() {
        return Typeface;
    }

    public float getRelativeSize() {
        return RelativeSize;
    }

    public boolean isUrl() {
        return IsUrl;
    }

    public boolean isUnderline() {
        return IsUnderline;
    }

    public boolean isStrikethru() {
        return IsStrikethru;
    }

    public Integer getQuoteColor() {
        return QuoteColor;
    }

    public boolean isSubscript() {
        return IsSubscript;
    }

    public boolean isSuperscript() {
        return IsSuperscript;
    }
    // endregion

    // region Builder class

    public static class Builder {
        // Required parameters
        private final String Text;

        // Optional parameters - initialized to default values
        private Integer ForegroundColor = 0;
        private Integer BackgroundColor = 0;
        private android.graphics.Typeface Typeface = null;
        private float RelativeSize = 0.0f;
        private boolean IsUrl = false;
        private boolean IsUnderline = false;
        private boolean IsStrikethru = false;
        private Integer QuoteColor = 0;
        private boolean IsSubscript = false;
        private boolean IsSuperscript = false;

        public Builder(String text) {
            this.Text = text;
        }

        public Builder foregroundColor(int fgColor) {
            ForegroundColor = fgColor;
            return this;
        }

        public Builder backgroundColor(int bgColor) {
            BackgroundColor = bgColor;
            return this;
        }

        public Builder typeface(Typeface typeface) {
            Typeface = typeface;
            return this;
        }

        public Builder relativeSize(float relativeSize) {
            RelativeSize = relativeSize;
            return this;
        }

        public Builder isUrl(boolean isUrl) {
            IsUrl = isUrl;
            return this;
        }

        public Builder isUnderline(boolean isUnderline) {
            IsUnderline = isUnderline;
            return this;
        }

        public Builder isStrikethru(boolean isStrikethru) {
            IsStrikethru = isStrikethru;
            return this;
        }

        public Builder quoteColor(int quoteColor) {
            QuoteColor = quoteColor;
            return this;
        }

        public Builder subscript(boolean isSubscript) {
            IsSubscript = isSubscript;
            return this;
        }

        public Builder superscript(boolean isSuperscript) {
            IsSuperscript = isSuperscript;
            return this;
        }

        public Span build() {
            return new Span(this);
        }
    }
    // endregion

}
