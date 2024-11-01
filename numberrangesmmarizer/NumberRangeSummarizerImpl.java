package numberrangesmmarizer;
import numberrangesmmarizer.NumberRangeSummarizer;
import java.util.Collection;
import java.util.ArrayList;

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer{
    @Override
    public Collection<Integer> collect(String input) {
        String[] parts = input.split(",");

        Collection<Integer> numbers = new ArrayList<Integer>();

        for(String part : parts){
            numbers.add(Integer.parseInt(part.trim()));
        }
        return numbers;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input){
        
    }
}
