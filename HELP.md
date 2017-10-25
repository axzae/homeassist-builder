# HomeAssist

This will be the HomeAssist wiki page.

You can help to update by modifying this file. At the moment, below are a bunch of lorem ipsums showing the capability of this markdown engine.

## Setup

Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

## Using Emojies
##### Without internet
Add the dependency:
```gradle
compile 'com.github.tiagohm.MarkdownView:emoji:LATEST-VERSION'
```

##### With internet
Add the permission:
```xml
<uses-permission android:name="android.permission.INTERNET"/>
```

```java
mMarkdownView.setEmojiRootPath("http://emojione.com/wp-content/uploads/assets/emojis/");
mMarkdownView.setEmojiImageExtension("svg");
```

## Custom CSS

```java
//InternalStyleSheet css = new InternalStyleSheet();
InternalStyleSheet css = new Github();
css.addFontFace("MyFont", "condensed", "italic", "bold", "url('myfont.ttf')");
css.addMedia("screen and (min-width: 1281px)");
css.addRule("h1", "color: orange");
css.endMedia();
css.addRule("h1", "color: green", "font-family: MyFont");
mMarkdownView.addStyleSheet(css);

mMarkdownView.addStyleSheet(ExternalStyleSheet.fromAsset("github.css", null);
mMarkdownView.addStyleSheet(ExternalStyleSheet.fromAsset("github2.css", "screen and (min-width: 1281px)");
```

## JavaScript
```java
JavaScript js = new ExternalJavaScript(url, async, defer);
mMarkdownView.addJavascript(js);
```

## Twitter

#### Embed a Single Tweet
From *https://twitter.com/RealGrumpyCat/status/845101936550469634*
* `#[tweet](845101936550469634)`
* `#[tweet-hide-cards](845101936550469634)`

#### Follow Button
From *https://twitter.com/tiag0hm*
* `#[follow](tiag0hm)`

## Tap Events
```java
mMarkdownView.setOnElementListener(new MarkdownView.OnElementListener(){ /*...*/ });
```

## Localization

See more [here](https://developer.android.com/guide/topics/resources/localization.html#managing-strings)

## Themes
* GitHub

## Support

- [x] Bold `**Text**` or `__Text__`
- [x] Italic `*Text*` or `_Text_`
- [x] Strikethrough `~~Text~~`
- [x] Horizontal Rules `---`
- [x] Headings `#`
- [x] Links `[alt](url)`
- [x] Images `![alt](url)`
- [x] Code
- [x] Blockquote
- [x] Nested Blockquote
- [x] Lists
- [x] Tables
- [x] TaskList
- [x] AutoLink
- [x] Abbreviation
- [x] Mark `==Text==`
- [x] Subscript `H~2~O`
- [x] Superscript `10^-10^`
- [x] Keystroke `@ctrl+alt+del@`
- [x] MathJax `$x = {-b \pm \sqrt{b^2-4ac} \over 2a}$`
- [x] Footnotes
- [x] Image Resizing `![alt](url@100px|auto)`
- [x] Syntax Highlighting (using [Highlight.js](https://highlightjs.org/))
- [x] Emoji ([EmojiOne](http://emojione.com)) `:smile:`
- [x] Custom CSS
- [x] Youtube `@[youtube](fM-J08X6l_Q)`
- [x] Twitter
- [x] JavaScripts
- [x] Label `--DEFAULT--` `---SUCCESS---` `----WARNING----` `-----DANGER-----`
- [x] Button `B[text](id)`
- [x] Click/Tap Events
- [x] Localization `{{resource_name}}`

<img width='380' src='https://raw.githubusercontent.com/tiagohm/MarkdownView/master/1.png'/>
<img width='380' src='https://raw.githubusercontent.com/tiagohm/MarkdownView/master/2.png'/>
<img width='380' src='https://raw.githubusercontent.com/tiagohm/MarkdownView/master/3.png'/>
<img width='380' src='https://raw.githubusercontent.com/tiagohm/MarkdownView/master/4.png'/>
<img width='380' src='https://raw.githubusercontent.com/tiagohm/MarkdownView/master/5.png'/>
<img width='380' src='https://raw.githubusercontent.com/tiagohm/MarkdownView/master/6.png'/>
<img width='380' src='https://raw.githubusercontent.com/tiagohm/MarkdownView/master/7.png'/>
<img width='380' src='https://raw.githubusercontent.com/tiagohm/MarkdownView/master/8.png'/>
<img width='380' src='https://raw.githubusercontent.com/tiagohm/MarkdownView/master/9.png'/>
