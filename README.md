# SpannableTextView [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-SpannableTextView-green.svg?style=flat)](https://android-arsenal.com/details/1/1916)
A TextView that accepts one or more spans

Support the following spans :

`ForegroundColorSpan`
`BackgroundColorSpan`
`CustomTypefaceSpan`
`RelativeSizeSpan`
`URLSpan`
`UnderlineSpan`
`StrikethroughSpan`
`QuoteSpan`
`SubscriptSpan`
`SuperscriptSpan`

![SpannableTextView](https://raw.githubusercontent.com/lawloretienne/SpannableTextView/master/images/SpannableTextView_Screenshot2.png)

## Sample Usage

```java
 // Setup single span
SpannableTextView tv1 = (SpannableTextView) view.findViewById(R.id.tv1);

Span span1 =
        new Span.Builder("ForegroundSpan, BackgroundSpan, and CustomTypefaceSpan")
                .foregroundColor(R.color.purple_500)
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
        .foregroundColor(R.color.orange_500)
        .backgroundColor(R.color.blue_500)
        .build());
spans1.add(new Span.Builder("ForegroundSpan, BackgroundSpan, and CustomTypefaceSpan")
        .foregroundColor(R.color.green_500)
        .backgroundColor(R.color.indigo_500)
        .typeface(mRegularFont)
        .build());

tv2.setFormattedText(spans1);
```

## License

```
Copyright 2015 Etienne Lawlor

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
