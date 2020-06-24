package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        System.out.println("Query "+query);
        String resp = "undefined";
        if(query == null)
            resp = "undefined";
        if (query.toLowerCase().contains("romeo and juliet")) {
            resp = "William Shakespeare";
        }
        if (query.toLowerCase().contains("what is your name")) {
            resp = "roger day";
        }
        return resp;
    }
}
