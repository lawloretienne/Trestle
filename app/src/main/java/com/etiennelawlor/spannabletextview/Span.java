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
    // endregion

    // region Constructor
    private Span(Builder builder) {
        Text = builder.Text;
        ForegroundColor = builder.ForegroundColor;
        BackgroundColor = builder.BackgroundColor;
        Typeface = builder.Typeface;
        RelativeSize = builder.RelativeSize;
        IsUrl = builder.IsUrl;
    }
    //

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

        public Span build() {
            return new Span(this);
        }
    }
    // endregion

}
