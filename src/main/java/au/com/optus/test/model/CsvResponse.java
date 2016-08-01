package au.com.optus.test.model;

import java.util.Map;

/**
 * @author rhasanov
 */
public class CsvResponse {

    private final String filename;
    private final Map<String, Integer> records;

    public CsvResponse(String filename, Map<String, Integer> records) {
        this.filename = filename;
        this.records = records;
    }

    public String getFilename() {
        return filename;
    }

    public Map<String, Integer> getRecords() {
        return records;
    }
}
