package com.zalyyh.yyh.view;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.zalyyh.yyh.zal.R;

public class ViewArrt {

    /**
     *  switch (attr) {
     case com.android.internal.R.styleable.TextAppearance_textColorHighlight:
     textColorHighlight = appearance.getColor(attr, textColorHighlight);
     break;

     case com.android.internal.R.styleable.TextAppearance_textColor:
     textColor = appearance.getColorStateList(attr);
     break;

     case com.android.internal.R.styleable.TextAppearance_textColorHint:
     textColorHint = appearance.getColorStateList(attr);
     break;

     case com.android.internal.R.styleable.TextAppearance_textColorLink:
     textColorLink = appearance.getColorStateList(attr);
     break;

     case com.android.internal.R.styleable.TextAppearance_textSize:
     textSize = appearance.getDimensionPixelSize(attr, textSize);
     break;

     case com.android.internal.R.styleable.TextAppearance_typeface:
     typefaceIndex = appearance.getInt(attr, -1);
     break;

     case com.android.internal.R.styleable.TextAppearance_fontFamily:
     if (!context.isRestricted() && context.canLoadUnsafeResources()) {
     try {
     fontTypeface = appearance.getFont(attr);
     } catch (UnsupportedOperationException
     | Resources.NotFoundException e) {
     // Expected if it is not a font resource.
     }
     }
     if (fontTypeface == null) {
     fontFamily = appearance.getString(attr);
     }
     break;

     case com.android.internal.R.styleable.TextAppearance_textStyle:
     styleIndex = appearance.getInt(attr, -1);
     break;

     case com.android.internal.R.styleable.TextAppearance_textAllCaps:
     allCaps = appearance.getBoolean(attr, false);
     break;

     case com.android.internal.R.styleable.TextAppearance_shadowColor:
     shadowcolor = appearance.getInt(attr, 0);
     break;

     case com.android.internal.R.styleable.TextAppearance_shadowDx:
     dx = appearance.getFloat(attr, 0);
     break;

     case com.android.internal.R.styleable.TextAppearance_shadowDy:
     dy = appearance.getFloat(attr, 0);
     break;

     case com.android.internal.R.styleable.TextAppearance_shadowRadius:
     r = appearance.getFloat(attr, 0);
     break;

     case com.android.internal.R.styleable.TextAppearance_elegantTextHeight:
     elegant = appearance.getBoolean(attr, false);
     break;

     case com.android.internal.R.styleable.TextAppearance_letterSpacing:
     letterSpacing = appearance.getFloat(attr, 0);
     break;

     case com.android.internal.R.styleable.TextAppearance_fontFeatureSettings:
     fontFeatureSettings = appearance.getString(attr);
     break;
     }
     }
     * */



    public static Object getobject(Object type, TypedArray a, int t) {
        for (int i = 0; i < a.getIndexCount(); i++) {
            int attr = a.getIndex(i);
            if (attr == t) {
                if (type instanceof Boolean) {
                    type = a.getBoolean(attr, true);
                }
                if (type instanceof String) {
                    type = a.getText(attr);
                }
                if (type instanceof Integer) {
                    type = a.getInt(attr,-1);
                }
                if (type instanceof ColorStateList) {
                    type = a.getColorStateList(attr);
                }
                if (type instanceof Drawable) {
                    type = a.getDrawable(attr);
                }
            }
        }
        return type;
    }

    public static Integer getIntType(TypedArray a, int t) {
        int n= -1;
        for (int i = 0; i < a.getIndexCount(); i++) {
            int attr = a.getIndex(i);
            if (attr == t) {
                n = attr;
            }
        }
        return n;
    }

}
