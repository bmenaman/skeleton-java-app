package com.develogical;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

    public String process(String query) {
        String resp = "";
        if(query == null)
            resp = "";
        if (query.toLowerCase().contains("romeo and juliet")) {
            resp = "William Shakespeare";
        }
        if (query.toLowerCase().contains("what is your name")) {
            resp = "roger day";
        }
        if (query.toLowerCase().contains("which of the following numbers is the largest:")) {
            resp = largestNum(query.toLowerCase());
        }
        if (query.toLowerCase().contains("what is") && query.toLowerCase().contains("plus")) {
            resp = plus(query.toLowerCase());
        }
        return resp;
    }

    private String plus(String q) {
        System.out.println(q);
        String patternString1 = "what is (.*) plus (.*)";

        Pattern pattern = Pattern.compile(patternString1);
        Matcher matcher = pattern.matcher(q);
        matcher.find();

        int x = Integer.parseInt(matcher.group(1));
        int y = Integer.parseInt(matcher.group(2));

        return String.valueOf(x+y);
    }

    private String largestNum(String q) {
        System.out.println(q);
        String patternString1 = "which of the following numbers is the largest: (.*)";

        Pattern pattern = Pattern.compile(patternString1);
        Matcher matcher = pattern.matcher(q);
        matcher.find();

        String nums = matcher.group(1);
        String[] numsarr = nums.split(", ");

        List<Integer> intnums = new ArrayList<>();
        for(String s: numsarr){
            intnums.add(Integer.parseInt(s));
        }
        return Collections.max(intnums).toString();

    }

    public String todo(){
        String text    =
                "John writes about this, and John writes about that," +
                        " and John writes about everything. "
                ;

        String patternString1 = "(John)";

        Pattern pattern = Pattern.compile(patternString1);
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()) {
            System.out.println("found: " + matcher.group(1));
        }
        return "";
    }
}
