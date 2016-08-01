package au.com.optus.test.service.impl;

import au.com.optus.test.model.Text;
import au.com.optus.test.model.Word;
import au.com.optus.test.service.TextService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author rhasanov
 */
@Service
public class TextServiceImpl implements TextService {

    @Override
    public Text parseText(String string) {
        Text text = new Text(string);
        for (String word : string.split("[^0-9a-zA-Z]")) {
            // keep the dictionary of words in lowercase
            text.addWord(word.toLowerCase());
        }
        return text;
    }

    @Override
    public Map<String, Integer> findWordStats(Text text, List<String> words) {
        Map<String, Integer> wordStats = new HashMap<>();
        for (String word : words) {
            Word found = text.getWord(word.toLowerCase());
            wordStats.put(word, null != found ? found.getFrequency() : 0);
        }
        return wordStats;
    }

    @Override
    public Map<String, Integer> findTopWords(Text text, int topCount) {
        Map<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Word> entry : text.getSortedWords().entrySet()) {
            result.put(entry.getKey(), entry.getValue().getFrequency());
            if (--topCount == 0) break;
        }
        return result;
    }
}
