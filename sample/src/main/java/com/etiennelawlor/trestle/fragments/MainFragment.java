package com.etiennelawlor.trestle.fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.etiennelawlor.trestle.R;
import com.etiennelawlor.trestle.library.Regex;
import com.etiennelawlor.trestle.library.Span;
import com.etiennelawlor.trestle.library.Trestle;

import java.util.ArrayList;
import java.util.List;


public class MainFragment extends Fragment {

    // region Member Variables
    private Typeface mRegularFont;
    private Typeface mItalicFont;
    private Typeface mBoldItalicFont;
    // endregion

    // Constructors
    public MainFragment() {
    }
    // endregion

    // region Lifecycle Methods
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        TextView tv1 = (TextView) view.findViewById(R.id.tv1);

        CharSequence formattedText1 = Trestle.getFormattedText(
                new Span.Builder("ForegroundSpan, BackgroundSpan, and CustomTypefaceSpan")
                        .foregroundColor(ContextCompat.getColor(getContext(), R.color.purple_100)) // Pass resolved color instead of resource id
                        .backgroundColor(ContextCompat.getColor(getContext(), R.color.green_500)) // Pass resolved color instead of resource id
                        .typeface(mItalicFont)
                        .build());

        tv1.setText(formattedText1);

        // Setup multiple spans
        TextView tv2 = (TextView) view.findViewById(R.id.tv2);

        List<Span> spans1 = new ArrayList<>();
        spans1.add(new Span.Builder("ForegroundSpan")
                .foregroundColor(ContextCompat.getColor(getContext(), R.color.red_500)) // Pass resolved color instead of resource id
                .build());
        spans1.add(new Span.Builder("BackgroundSpan")
                .backgroundColor(ContextCompat.getColor(getContext(), R.color.yellow_500)) // Pass resolved color instead of resource id
                .build());
        spans1.add(new Span.Builder("ForegroundSpan and BackgroundSpan")
                .foregroundColor(ContextCompat.getColor(getContext(), R.color.brown_500)) // Pass resolved color instead of resource id
                .backgroundColor(ContextCompat.getColor(getContext(), R.color.blue_300)) // Pass resolved color instead of resource id
                .build());
        spans1.add(new Span.Builder("ForegroundSpan, BackgroundSpan, and CustomTypefaceSpan")
                .foregroundColor(ContextCompat.getColor(getContext(), R.color.green_700)) // Pass resolved color instead of resource id
                .backgroundColor(ContextCompat.getColor(getContext(), R.color.indigo_200)) // Pass resolved color instead of resource id
                .typeface(mRegularFont)
                .build());

        CharSequence formattedText2 = Trestle.getFormattedText(spans1);

        tv2.setText(formattedText2);

        // Setup single span
        TextView tv3 = (TextView) view.findViewById(R.id.tv3);

        CharSequence formattedText3 = Trestle.getFormattedText(
                new Span.Builder("RelativeSizeSpan")
                        .relativeSize(2.0f)
                        .build());

        tv3.setText(formattedText3);

        // Setup single span
        TextView tv4 = (TextView) view.findViewById(R.id.tv4);

        CharSequence formattedText4 = Trestle.getFormattedText(
                new Span.Builder("AbsoluteSizeSpan")
                        .absoluteSize(20)
                        .build());

        tv4.setText(formattedText4);

        // Setup single span
        TextView tv5 = (TextView) view.findViewById(R.id.tv5);

        CharSequence formattedText5 = Trestle.getFormattedText(
                new Span.Builder("URLSpan")
                        .isUrl(true)
                        .build());

        tv5.setText(formattedText5);

        // Setup single span
        TextView tv6 = (TextView) view.findViewById(R.id.tv6);

        CharSequence formattedText6 = Trestle.getFormattedText(
                new Span.Builder("UnderlineSpan")
                        .isUnderline(true)
                        .build());

        tv6.setText(formattedText6);

        // Setup single span
        TextView tv7 = (TextView) view.findViewById(R.id.tv7);

        CharSequence formattedText7 = Trestle.getFormattedText(
                new Span.Builder("StrikethroughSpan")
                        .isStrikethru(true)
                        .build());

        tv7.setText(formattedText7);

        // Setup single span
        TextView tv8 = (TextView) view.findViewById(R.id.tv8);

        CharSequence formattedText8 = Trestle.getFormattedText(
                new Span.Builder("QuoteSpan")
                        .quoteColor(ContextCompat.getColor(getContext(), R.color.green_500)) // Pass resolved color instead of resource id
                        .build());

        tv8.setText(formattedText8);

        // Setup single span
        TextView tv9 = (TextView) view.findViewById(R.id.tv9);

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

        CharSequence formattedText9 = Trestle.getFormattedText(spans2);
        tv9.setText(formattedText9);

        // Setup single span
        TextView tv10 = (TextView) view.findViewById(R.id.tv10);

        CharSequence formattedText10 = Trestle.getFormattedText(
                new Span.Builder("Regex - ForegroundColorSpan, BackgroundColorSpan, and CustomTypefaceSpan (case sensitive)")
                        .regex(new Regex("c", Regex.CASE_SENSITIVE))
                        .foregroundColor(ContextCompat.getColor(getContext(), R.color.green_500)) // Pass resolved color instead of resource id
                        .backgroundColor(ContextCompat.getColor(getContext(), R.color.red_200)) // Pass resolved color instead of resource id
                        .typeface(mBoldItalicFont)
                        .build());

        tv10.setText(formattedText10);

        // Setup single span
        TextView tv11 = (TextView) view.findViewById(R.id.tv11);

        CharSequence formattedText11 = Trestle.getFormattedText(
                new Span.Builder("Regex - ForegroundColorSpan, BackgroundColorSpan, and CustomTypefaceSpan (case insensitive)")
                        .regex(new Regex("(", Regex.CASE_INSENSITIVE))
                        .foregroundColor(ContextCompat.getColor(getContext(), R.color.green_500)) // Pass resolved color instead of resource id
                        .backgroundColor(ContextCompat.getColor(getContext(), R.color.red_200)) // Pass resolved color instead of resource id
                        .typeface(mBoldItalicFont)
                        .build());

        tv11.setText(formattedText11);

        // Setup single span
        TextView tv12 = (TextView) view.findViewById(R.id.tv12);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                if (isAdded() && isResumed()) {
                    Toast.makeText(getActivity().getApplicationContext(), "You clicked on the ClickableSpan", Toast.LENGTH_SHORT).show();
                }
            }
        };

        CharSequence formattedText12 = Trestle.getFormattedText(
                new Span.Builder("ClickableSpan")
                        .clickableSpan(clickableSpan)
                        .build());

        tv12.setMovementMethod(LinkMovementMethod.getInstance());
        tv12.setText(formattedText12);

        // Setup single span
        TextView tv13 = (TextView) view.findViewById(R.id.tv13);

        CharSequence formattedText13 = Trestle.getFormattedText(
                new Span.Builder("ScaleX")
                        .scaleX(2.5f)
                        .build());

        tv13.setText(formattedText13);

    }
    // endregion

}
