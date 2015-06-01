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

        String s4 = "This text is orange and bold italic";
        int color = R.color.orange_500;
        Typeface typeface = mBoldItalicFont;

        tv1.setFormattedText(s4, color, typeface);

        // Setup multiple spans
        SpannableTextView tv2 = (SpannableTextView) view.findViewById(R.id.tv2);

        String s1 = "This text is purple and bold ";
        String s2 = "This text is blue and italic ";
        String s3 = "This text is green and regular";

        List<String> stringList = new ArrayList<>();
        stringList.add(s1);
        stringList.add(s2);
        stringList.add(s3);

        List<Integer> colors = new ArrayList<>();
        colors.add(R.color.purple_500);
        colors.add(R.color.blue_500);
        colors.add(R.color.green_500);

        List<Typeface> typefaces = new ArrayList<>();
        typefaces.add(mBoldFont);
        typefaces.add(mItalicFont);
        typefaces.add(mRegularFont);

        tv2.setFormattedText(stringList, colors, typefaces);
    }
    // endregion

}
