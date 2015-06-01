package com.etiennelawlor.spannabletextview.fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.etiennelawlor.spannabletextview.R;
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

        SpannableTextView.Span span
                = new SpannableTextView.Span(getString(R.string.orange_and_bold_italic), R.color.orange_500, mBoldItalicFont);
        tv1.setFormattedText(span);

        // Setup multiple spans
        SpannableTextView tv2 = (SpannableTextView) view.findViewById(R.id.tv2);

        List<SpannableTextView.Span> spans = new ArrayList<>();
        spans.add(new SpannableTextView.Span(getString(R.string.purple_and_bold), R.color.purple_500, mBoldFont));
        spans.add(new SpannableTextView.Span(getString(R.string.blue_and_italic), R.color.blue_500, mItalicFont));
        spans.add(new SpannableTextView.Span(getString(R.string.green_and_regular), R.color.green_500, mRegularFont));

        tv2.setFormattedText(spans);
    }
    // endregion

}
