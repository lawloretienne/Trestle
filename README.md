# SpannableTextView [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-SpannableTextView-green.svg?style=flat)](https://android-arsenal.com/details/1/1916)
A TextView that accepts one or more spans with a color and Typeface

![SpannableTextView](https://raw.githubusercontent.com/lawloretienne/SpannableTextView/master/images/SpannableTextView_Screenshot.png)

## Sample Usage

```java
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
```
