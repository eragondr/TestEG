package com.example.pc.testeg.main;

import android.graphics.Typeface;
import android.text.Spannable;
import android.view.View;

import com.example.pc.testeg.CustomsText.CustomsText;
import com.example.pc.testeg.R;

import java.util.List;
import java.util.Random;

/**
 * Created by toanpc on 07/05/2017.
 */
public class CommonUtils {
    public static Boolean Contains(String input, List<Vocabulary> vocabularyList) {
        if (vocabularyList == null) return false;
        for (Vocabulary arr : vocabularyList) {
            if (arr.IsContain(input)) {
                return true;
            }
        }
        return false;
    }
}
