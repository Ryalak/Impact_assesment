package numberarrangesummarizer;

import org.junit.jupiter.api.Test;
import java.util.Collection;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class NumberRangeSummarizerImplTest {

    /**
    * @author Ryan Lake
    * 
    * Assuming the input has no duplicates and correct comma delimited list of numbers, it should handle all inputs.
    */

    private final NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();

    @Test
    void testCollectValidInput() {
        String input = "1, 2, 4, 6, 7, 8, 10";
        Collection<Integer> expected = Arrays.asList(1, 2, 4, 6, 7, 8, 10);
        Collection<Integer> result = summarizer.collect(input);
        assertEquals(expected, result, "Should collect numbers correctly from valid input");
    }

    @Test
    void testCollectManySpaces() {
        String input = "1, 2,  4,    7,8";
        Collection<Integer> expected = Arrays.asList(1, 2, 4, 7, 8); 
        Collection<Integer> result = summarizer.collect(input);
        assertEquals(expected, result, "Should ignore extra or no white spaces");
    }

    @Test
    void testSummarizeCollectionConsecutiveNumbers() {
        List<Integer> input = Arrays.asList(1, 2, 3, 6, 7, 8, 10);
        String expected = "1-3, 6-8, 10";
        String result = summarizer.summarizeCollection(input);
        assertEquals(expected, result, "Should correctly summarize consecutive ranges");
    }

    @Test
    void testSummarizeCollectionSingleElements() {
        List<Integer> input = Arrays.asList(1, 3, 5, 7, 9);
        String expected = "1, 3, 5, 7, 9";
        String result = summarizer.summarizeCollection(input);
        assertEquals(expected, result, "Should correctly handle single elements");
    }

    @Test
    void testSummarizeCollectionWithRangesAndSingles() {
        List<Integer> input = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        String expected = "1, 3, 6-8, 12-15, 21-24, 31";
        String result = summarizer.summarizeCollection(input);
        assertEquals(expected, result, "Should correctly handle mixed ranges and single elements");
    }

    @Test
    void testSummarizeCollectionEmpty() {
        List<Integer> input = Arrays.asList();
        String expected = "";
        String result = summarizer.summarizeCollection(input);
        assertEquals(expected, result, "Should return an empty string for an empty input");
    }
}
