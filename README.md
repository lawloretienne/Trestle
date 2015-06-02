# SpannableTextView [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-SpannableTextView-green.svg?style=flat)](https://android-arsenal.com/details/1/1916)
A TextView that accepts one or more spans

![SpannableTextView](https://raw.githubusercontent.com/lawloretienne/SpannableTextView/master/images/SpannableTextView_Screenshot.png)

## Sample Usage

```java
// Setup single span
SpannableTextView tv1 = (SpannableTextView) view.findViewById(R.id.tv1);

Span span =
        new Span.Builder(getString(R.string.orange_and_bold_italic))
                .foregroundColor(R.color.purple_500)
                .backgroundColor(R.color.green_500)
                .typeface(mItalicFont)
                .build();

tv1.setFormattedText(span);

// Setup multiple spans
SpannableTextView tv2 = (SpannableTextView) view.findViewById(R.id.tv2);

List<Span> spans = new ArrayList<>();
spans.add(new Span.Builder(getString(R.string.purple_and_bold))
        .foregroundColor(R.color.purple_500)
        .backgroundColor(R.color.yellow_500)
        .build());
spans.add(new Span.Builder(getString(R.string.blue_and_italic))
        .backgroundColor(R.color.red_500)
        .typeface(mItalicFont)
        .build());
spans.add(new Span.Builder(getString(R.string.green_and_regular))
        .foregroundColor(R.color.green_500)
        .typeface(mRegularFont)
        .build());
spans.add(new Span.Builder(getString(R.string.green_and_regular))
        .foregroundColor(R.color.blue_500)
        .typeface(mBoldFont)
        .relativeSize(2.0f)
        .build());
spans.add(new Span.Builder(getString(R.string.blue_and_italic))
        .typeface(mItalicFont)
        .isUrl(true)
        .build());

tv2.setFormattedText(spans);
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