package com.example.pc.testeg.CustomsText;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;

/**
 * Created by PC on 5/5/2017.
 */

public class CustomsText {


    public static Spannable CustomsText(Context context, String text, int start, int end, float proportion, int color, int styleTyle) {
        Spannable spanText = new SpannableString(text);
        spanText.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, color)), start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        spanText.setSpan(new RelativeSizeSpan(proportion), start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        spanText.setSpan(new StyleSpan(styleTyle), start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

        spanText.setSpan(new UnderlineSpan(), start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spanText;
    }
}


