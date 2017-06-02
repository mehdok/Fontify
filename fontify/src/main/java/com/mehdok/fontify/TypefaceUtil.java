package com.mehdok.fontify;

import android.content.Context;
import android.graphics.Typeface;
import android.util.LruCache;

import java.util.Locale;
import java.util.Map;

/**
 * @author mehdok (mehdok@gmail.com) on 6/2/2017.
 */

public class TypefaceUtil {
    private LruCache<String, Typeface> typefaceLruCache;
    private static TypefaceUtil instance;

    private Map<String, String> fontsNormal;
    private Map<String, String> fontsBold;
    private Map<String, String> fontsThin;
    private String fontDefault;

    public static void createInstance(Map<String, String> fontsNormal, Map<String, String> fontsBold,
                                      Map<String, String> fontsThin, String fontDefault, int cacheSize) {
        instance = new TypefaceUtil(fontsNormal, fontsBold, fontsThin, fontDefault, cacheSize);
    }

    public static TypefaceUtil getInstance() {
        if (instance == null) {
            throw new RuntimeException("You must init Fontify in Your Application class, before any use.");
        }

        return instance;
    }

    TypefaceUtil(Map<String, String> fontsNormal, Map<String, String> fontsBold,
                 Map<String, String> fontsThin, String fontDefault, int cacheSize) {
        typefaceLruCache = new LruCache<>(cacheSize);
        this.fontsNormal = fontsNormal;
        this.fontsBold = fontsBold;
        this.fontsThin = fontsThin;
        this.fontDefault = fontDefault;
    }

    /**
     * return specific font from cache or create it
     *
     * @param context
     * @param fontPath
     * @return
     */
    private Typeface getTypeFaceForPath(Context context, String fontPath) {
        if (typefaceLruCache.get(fontPath) != null) {
            return typefaceLruCache.get(fontPath);
        }
        final Typeface typeface = Typeface.createFromAsset(context.getAssets(), fontPath);
        if (typeface != null) {
            typefaceLruCache.put(fontPath, typeface);
        }
        return typeface;
    }

    public Typeface getFontNormal(Context context, String langCode) {
        Typeface typeface = null;
        if (fontsNormal != null && fontsNormal.get(langCode) != null) {
            typeface = getTypeFaceForPath(context, fontsNormal.get(langCode));
        }

        if (typeface == null && fontDefault != null) {
            typeface = getTypeFaceForPath(context, fontDefault);
        }

        return typeface;
    }

    public Typeface getFontBold(Context context, String langCode) {
        Typeface typeface = null;
        if (fontsBold != null && fontsBold.get(langCode) != null) {
            typeface = getTypeFaceForPath(context, fontsBold.get(langCode));
        }

        if (typeface == null && fontDefault != null) {
            typeface = getTypeFaceForPath(context, fontDefault);
        }

        return typeface;
    }

    public Typeface getFontThin(Context context, String langCode) {
        Typeface typeface = null;
        if (fontsThin != null && fontsThin.get(langCode) != null) {
            typeface = getTypeFaceForPath(context, fontsThin.get(langCode));
        }

        if (typeface == null && fontDefault != null) {
            typeface = getTypeFaceForPath(context, fontDefault);
        }

        return typeface;
    }

    public Typeface getTypeFace(Context context, FontType fontType) {
        Typeface typeface = null;
        String langCode = Locale.getDefault().getLanguage();
        switch (fontType) {
            case NORMAL:
                typeface = getFontNormal(context, langCode);
                break;
            case BOLD:
                typeface = getFontBold(context, langCode);
                break;
            case THIN:
                typeface = getFontThin(context, langCode);
                break;
        }

        return typeface;
    }
}
