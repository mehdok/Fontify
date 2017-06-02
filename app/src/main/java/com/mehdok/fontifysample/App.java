package com.mehdok.fontifysample;

import android.app.Application;

import com.mehdok.fontify.Fontify;

/**
 * @author mehdok (mehdok@gmail.com) on 6/2/2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

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
    }
}
