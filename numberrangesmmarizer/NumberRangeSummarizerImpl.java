package numberrangesmmarizer;
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
        ArrayList<Integer> numbers = new ArrayList<>(input);
        StringBuilder output = new StringBuilder();

        for(int i = 0; i < numbers.size(); i++){
            int start = numbers.get(i);
            int end = start;

            while(i + 1 < numbers.size() && numbers.get(i + 1) == numbers.get(i) + 1){
                end = numbers.get(i + 1);
                i++;
            }

            if(start == end){
                output.append(start);
            }
            else{
                output.append(start).append("-").append(end);
            }

            if (i < numbers.size() - 1) {
                output.append(", ");
            }
        } 
        return output.toString();
    }

    public static void main(String[] args){
        NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();

        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> collectedNumbers = summarizer.collect(input);
        String summarized = summarizer.summarizeCollection(collectedNumbers);

        System.out.println(summarized);
    }
}
