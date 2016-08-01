package au.com.optus.test.service;

import au.com.optus.test.model.Text;

import java.util.List;
import java.util.Map;

/**
 * @author rhasanov
 */
public interface TextService {

    public Text parseText(String string);
    public Map<String, Integer> findWordStats(Text text, List<String> words);
    public Map<String, Integer> findTopWords(Text text, int topCount);
}
