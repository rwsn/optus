package au.com.optus.test.model;

import java.util.Map;

/**
 * @author rhasanov
 */
public class SearchResponse {

    private final Map<String, Integer> counts;

    public SearchResponse(Map<String, Integer> counts) {
        this.counts = counts;
    }

    public Map<String, Integer> getCounts() {
        return counts;
    }
}
