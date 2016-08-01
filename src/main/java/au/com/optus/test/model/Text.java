package au.com.optus.test.model;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author rhasanov
 */
public class Text {

    private String text;
    private Map<String, Word> words;

    public Text(String text) {
        this.text = text;
        // map sorted by descending frequency of words
        words = new HashMap<>();
    }

    public void addWord(String string) {
        Word word = words.get(string);
        if (null == word) {
            word = new Word(string);
            word.setFrequency(1);
            words.put(string, word);
        } else {
            word.setFrequency(word.getFrequency() + 1);
        }
    }

    public Word getWord(String string) {
        return words.get(string);
    }

    public SortedMap<String, Word> getSortedWords() {
        SortedMap<String, Word> sorted = new TreeMap<>((o1, o2) -> words.get(o2).getFrequency() - words.get(o1).getFrequency());
        sorted.putAll(words);
        return sorted;
    }
}
