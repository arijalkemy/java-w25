package com.sfritz.linktracker.util;

import java.util.regex.Pattern;

public class UrlValidator {

    private static String regex = "^(https?|ftp|file)://www[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    public static Boolean validateUrl(String url){
        if(Pattern.matches(regex, url)){
            return true;
        }else{
            return false;
        }
    }
}
