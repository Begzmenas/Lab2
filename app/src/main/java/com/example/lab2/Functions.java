package com.example.lab2;

import android.content.Context;
import android.widget.Toast;

public class Functions {
    public static int countText(Context context, String option, String text){
        if(text == null || text.trim().isEmpty()){
            showToast(context, "Nothing is written");
            return 0;
        }
        switch (option){
            case "Words":
                return countWords(text);
            case "Symbols":
                return countCharacters(text);
            default:
                showToast(context, "Invalid option selected");
                return 0;
        }
    }

    private static int countWords(String text) {
        if(text.trim().isEmpty())return 0;
        return text.trim().split("\\s+").length;
    }
    private static int countCharacters(String text){
        return text.length();
    }
    private static void showToast(Context context, String message){
        Toast.makeText(context, message,Toast.LENGTH_SHORT).show();
    }
}
