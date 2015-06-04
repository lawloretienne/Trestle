package com.etiennelawlor.spannabletextview.fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.etiennelawlor.spannabletextview.R;
import com.etiennelawlor.spannabletextview.Span;
import com.etiennelawlor.spannabletextview.SpannableTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    // region Member Variables
    private Typeface mRegularFont;
    private Typeface mBoldFont;
    private Typeface mItalicFont;
    private Typeface mBoldItalicFont;
    // endregion

    // Constructors
    public MainActivityFragment() {
    }
    // endregion

    // region Lifecycle Methods
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBoldFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Bold.ttf");
        mItalicFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Italic.ttf");
        mRegularFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Regular.ttf");
        mBoldItalicFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-BoldItalic.ttf");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Setup single span
        SpannableTextView tv1 = (SpannableTextView) view.findViewById(R.id.tv1);

        Span span1 =
                new Span.Builder("ForegroundSpan, BackgroundSpan, and CustomTypefaceSpan")
                        .foregroundColor(R.color.purple_100)
                        .backgroundColor(R.color.green_500)
                        .typeface(mItalicFont)
                        .build();

        tv1.setFormattedText(span1);

        // Setup multiple spans
        SpannableTextView tv2 = (SpannableTextView) view.findViewById(R.id.tv2);

        List<Span> spans1 = new ArrayList<>();
        spans1.add(new Span.Builder("ForegroundSpan")
                .foregroundColor(R.color.red_500)
                .build());
        spans1.add(new Span.Builder("BackgroundSpan")
                .backgroundColor(R.color.yellow_500)
                .build());
        spans1.add(new Span.Builder("ForegroundSpan and BackgroundSpan")
                .foregroundColor(R.color.brown_500)
                .backgroundColor(R.color.blue_300)
                .build());
        spans1.add(new Span.Builder("ForegroundSpan, BackgroundSpan, and CustomTypefaceSpan")
                .foregroundColor(R.color.green_700)
                .backgroundColor(R.color.indigo_200)
                .typeface(mRegularFont)
                .build());

        tv2.setFormattedText(spans1);

        // Setup single span
        SpannableTextView tv3 = (SpannableTextView) view.findViewById(R.id.tv3);

        Span span2 = new Span.Builder("RelativeSizeSpan")
                .relativeSize(2.0f)
                .build();

        tv3.setFormattedText(span2);

        // Setup single span
        SpannableTextView tv4 = (SpannableTextView) view.findViewById(R.id.tv4);

        Span span3 = new Span.Builder("URLSpan")
                .isUrl(true)
                .build();

        tv4.setFormattedText(span3);

        // Setup single span
        SpannableTextView tv5 = (SpannableTextView) view.findViewById(R.id.tv5);

        Span span4 = new Span.Builder("UnderlineSpan")
                .isUnderline(true)
                .build();

        tv5.setFormattedText(span4);

        // Setup single span
        SpannableTextView tv6 = (SpannableTextView) view.findViewById(R.id.tv6);

        Span span5 = new Span.Builder("StrikethroughSpan")
                .isStrikethru(true)
                .build();

        tv6.setFormattedText(span5);


        // Setup single span
        SpannableTextView tv7 = (SpannableTextView) view.findViewById(R.id.tv7);

        Span span6 = new Span.Builder("QuoteSpan")
                .quoteColor(R.color.green_500)
                .build();

        tv7.setFormattedText(span6);

        // Setup single span
        SpannableTextView tv8 = (SpannableTextView) view.findViewById(R.id.tv8);

        List<Span> spans2 = new ArrayList<>();
        spans2.add(new Span.Builder("No Span ")
                .build());
        spans2.add(new Span.Builder("SubscriptSpan ")
                .subscript(true)
                .build());
        spans2.add(new Span.Builder("No Span ")
                .build());
        spans2.add(new Span.Builder("SuperscriptSpan ")
                .superscript(true)
                .build());

        tv8.setFormattedText(spans2);

        // Setup single span
        SpannableTextView tv9 = (SpannableTextView) view.findViewById(R.id.tv9);

        Span span7 = new Span.Builder("Regex - ForegroundColorSpan, BackgroundColorSpan, and CustomTypefaceSpan")
                .regex("Span")
                .foregroundColor(R.color.green_500)
                .backgroundColor(R.color.red_200)
                .typeface(mBoldItalicFont)
                .build();

        tv9.setFormattedText(span7);

    }
    // endregion

}
