package au.com.optus.test.model;

/**
 * @author rhasanov
 */
public class Word {

    private final String word;
    private int frequency;

    public Word(String word) {
        this.word = word;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
