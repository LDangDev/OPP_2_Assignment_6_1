package model;

import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> dictionary;

    public Dictionary() {
        dictionary = new HashMap<>();
    }

    public void addWord(String word, String meaning) {
        dictionary.put(word, meaning);
    }

    public String getMeaning(String word) {
        return dictionary.get(word);
    }
}