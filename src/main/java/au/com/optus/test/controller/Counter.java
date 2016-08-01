package au.com.optus.test.controller;

import au.com.optus.test.model.SearchRequest;
import au.com.optus.test.model.SearchResponse;
import au.com.optus.test.model.Text;
import au.com.optus.test.model.CsvResponse;
import au.com.optus.test.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

/**
 * @author rhasanov
 */
@RestController
@RequestMapping("/counter-api")
public class Counter {

    @Autowired
    private TextService textService;
    private final String rawText;
    private Text text;

    public Counter(String rawText) {
        this.rawText = rawText;
    }

    @RequestMapping(path = "/search", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public SearchResponse searchWord(@RequestBody SearchRequest request) {
        return new SearchResponse(textService.findWordStats(text, request.getSearchText()));
    }

    @RequestMapping(path = "/top/{count}", method = RequestMethod.GET, produces = "text/csv")
    public CsvResponse getTopWords(@PathVariable int count) {
        return new CsvResponse("result.csv", textService.findTopWords(text, count));
    }

    @PostConstruct
    private void initialize() {
        text = textService.parseText(rawText);
    }
}
