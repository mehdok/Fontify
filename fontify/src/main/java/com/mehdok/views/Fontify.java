package com.mehdok.views;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mehdok (mehdok@gmail.com) on 6/2/2017.
 */

public class Fontify {
    private Map<String, String> fontsNormal;
    private Map<String, String> fontsBold;
    private Map<String, String> fontsThin;
    private String fontDefault;
    private int cacheSize;

    private Fontify(Builder builder) {
        fontsNormal = builder.fontsNormal;
        fontsBold = builder.fontsBold;
        fontsThin = builder.fontsThin;
        fontDefault = builder.fontDefault;
        cacheSize = builder.cacheSize;

        TypefaceUtil.createInstance(fontsNormal, fontsBold, fontsThin, fontDefault, cacheSize);
    }

    public static Builder init(String fontDefault) {
        return new Builder(fontDefault);
    }

    public static final class Builder {
        private Map<String, String> fontsNormal;
        private Map<String, String> fontsBold;
        private Map<String, String> fontsThin;
        private String fontDefault;
        private int cacheSize;

        public Builder(String fontDefault) {
            fontsNormal = new HashMap<>();
            fontsBold = new HashMap<>();
            fontsThin = new HashMap<>();
            cacheSize = 3;
            this.fontDefault = fontDefault;
        }

        public Builder addFontNormal(String langCode, String assetsPath) {
            fontsNormal.put(langCode, assetsPath);
            return this;
        }

        public Builder addFontBold(String langCode, String assetsPath) {
            fontsBold.put(langCode, assetsPath);
            return this;
        }

        public Builder addFontThin(String langCode, String assetsPath) {
            fontsThin.put(langCode, assetsPath);
            return this;
        }

        public Builder fontDefault(String val) {
            fontDefault = val;
            return this;
        }

        public Builder cacheSize(int val) {
            cacheSize = val;
            return this;
        }

        public Fontify build() {
            return new Fontify(this);
        }
    }
}
