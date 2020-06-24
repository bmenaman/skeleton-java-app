package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if(query == null)
            return "";
        if (query.toLowerCase().contains("romeo and juliet")) {
            return "William Shakespeare";
        }
        if (query.toLowerCase().contains("what is your name")) {
            return "Roger";
        }
        return "";
    }
}
