package controller;

import model.Dictionary;

public class DictionaryController {
    private Dictionary dictionary;

    public DictionaryController(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public void addWord(String word, String meaning) {
        dictionary.addWord(word, meaning);
    }

    public String searchWord(String word) {
        return dictionary.getMeaning(word);
    }
}