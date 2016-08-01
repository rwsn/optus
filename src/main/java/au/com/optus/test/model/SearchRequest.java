package au.com.optus.test.model;

import java.util.List;

/**
 * @author rhasanov
 */
public class SearchRequest {

    private List<String> searchText;

    public List<String> getSearchText() {
        return searchText;
    }

    public void setSearchText(List<String> searchText) {
        this.searchText = searchText;
    }
}
