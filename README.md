TextView, EditText and Button with custom fonts with normal, bold and thin style for different languages.

When the language of device changes the library automatically use the font for that language.

## Installation
1) Configure your top-level `build.gradle` to include my repository
```groovy
allprojects {
    repositories {
        jcenter()
        maven { url "http://dl.bintray.com/meh-dok/public-maven" }
    }
}
```
Then config your app-level `build.gradle` to include the library as dependency:
``` groovy
compile 'com.mehdok.views:fontify:1.0.0-beta1'
```

## Usage
1) Use the View in you xml layout like this:
```xml
<com.mehdok.views.TextViewNormal
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="@dimen/item_margin_bottom"
        android:text="@string/normal"
        android:textSize="@dimen/text_size"
        />
        
<com.mehdok.views.EditTextBold
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="@dimen/item_margin_bottom"
        android:text="@string/bold"
        android:textSize="@dimen/text_size"
        />
        
<com.mehdok.views.ButtonThin
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="@dimen/item_margin_bottom"
        android:text="@string/thin"
        android:textSize="@dimen/text_size"
        />
```

in your application class you need to init the fontify like this:
```java
Fontify
       .init("fonts/Roboto-Regular.ttf")
       .addFontNormal("en", "fonts/Roboto-Regular.ttf")
       .addFontNormal("fa", "fonts/FreeFarsi.ttf")
       .addFontNormal("ar", "fonts/FreeFarsi.ttf")
       .addFontBold("en", "fonts/Roboto-Bold.ttf")
       .addFontBold("fa", "fonts/FreeFarsi-Bold.ttf")
       .addFontBold("ar", "fonts/FreeFarsi-Bold.ttf")
       .addFontThin("en", "fonts/Roboto-Thin.ttf")
       .addFontThin("fa", "fonts/FreeFarsi-Mono.ttf")
       .addFontThin("ar", "fonts/FreeFarsi-Mono.ttf")
       .cacheSize(5)
       .build();
```

* `init` the library with a default font, the path must be complete path in your assets.
* add as many font as you need for different language and styles. the first parameter must be 
language code and second one is the complete path of font in your assets.
* finally set the cache size to indicate how many font you want to keep in ram, the default is `3`,
more cache size mean faster view loading (maybe slightly) and more ram usage.

*for an example look the app.*
