# Trestle [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Trestle-green.svg?style=flat)](https://android-arsenal.com/details/1/1916) <a href="http://www.methodscount.com/?lib=com.github.lawloretienne%3Atrestle%3A0.0.7"><img src="https://img.shields.io/badge/Methods and size-112 | 10 KB-e91e63.svg"></img></a>

![Trestle](https://raw.githubusercontent.com/lawloretienne/Trestle/master/images/ic_launcher.png)

## Overview

A framework used to bridge one or more spans for use with a TextView

Supports the following spans :

`ForegroundColorSpan`
`BackgroundColorSpan`
`CustomTypefaceSpan`
`RelativeSizeSpan`
`AbsoluteSizeSpan`
`URLSpan`
`UnderlineSpan`
`StrikethroughSpan`
`QuoteSpan`
`SubscriptSpan`
`SuperscriptSpan`
`ClickableSpan`
`ScaleXSpan`

Also supports one or more spans, spanning the length of a regex match

## Screenshots

![Trestle](https://raw.githubusercontent.com/lawloretienne/Trestle/master/images/Trestle_Screenshot_3.png)

## Setup

#### Gradle

`compile 'com.github.lawloretienne:trestle:0.0.10'`

#### Maven
```
<dependency>
    <groupId>com.github.lawloretienne</groupId>
    <artifactId>trestle</artifactId>
    <version>0.0.10</version>
</dependency>
```

## Sample Usage

```java
// Setup single span
TextView tv1 = (TextView) view.findViewById(R.id.tv1);

CharSequence formattedText1 = Trestle.getFormattedText(
        new Span.Builder("ForegroundSpan, BackgroundSpan, and CustomTypefaceSpan")
                .foregroundColor(getContext(), R.color.purple_100)
                .backgroundColor(getContext(), R.color.green_500)
                .typeface(italicFont)
                .build());

tv1.setText(formattedText1);

// Setup multiple spans
TextView tv2 = (TextView) view.findViewById(R.id.tv2);

List<Span> spans1 = new ArrayList<>();
spans1.add(new Span.Builder("ForegroundSpan")
        .foregroundColor(getContext(), R.color.red_500)
        .build());
spans1.add(new Span.Builder("BackgroundSpan")
        .backgroundColor(getContext(), R.color.yellow_500) 
        .build());
spans1.add(new Span.Builder("ForegroundSpan and BackgroundSpan")
        .foregroundColor(getContext(), R.color.blue_500)
        .backgroundColor(getContext(), R.color.blue_300)
        .build());
spans1.add(new Span.Builder("ForegroundSpan, BackgroundSpan, and CustomTypefaceSpan")
        .foregroundColor(getContext(), R.color.yellow_500)
        .backgroundColor(getContext(), R.color.indigo_200) 
        .typeface(regularFont)
        .build());

CharSequence formattedText2 = Trestle.getFormattedText(spans1);

tv2.setText(formattedText2);
```

## Developed By

* Etienne Lawlor 
 
&nbsp;&nbsp;&nbsp;**Email** - lawloretienne@gmail.com

&nbsp;&nbsp;&nbsp;**Website** - https://medium.com/@etiennelawlor

## Projects/Apps using Trestle

- <a href="https://play.google.com/store/apps/details?id=com.getsomeheadspace.android">Headspace</a>
- <a href="https://play.google.com/store/apps/details?id=com.biggu.shopsavvy&hl=en">ShopSavvy</a>

Feel free to contact me to add yours to this list.

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
