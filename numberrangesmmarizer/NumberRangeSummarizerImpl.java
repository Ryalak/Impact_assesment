package numberrangesmmarizer;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Scanner;

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
        int inputSize = numbers.size();

        for(int i = 0; i < inputSize; i++){
            int start = numbers.get(i);
            int end = start;

            while(i + 1 < inputSize && numbers.get(i + 1) == numbers.get(i) + 1){
                end = numbers.get(i + 1);
                i++;
            }

            if(start == end){
                output.append(start);
            }
            else{
                output.append(start).append("-").append(end);
            }

            if (i < inputSize - 1) {
                output.append(", ");
            }
        } 
        return output.toString();
    }

    public static void main(String[] args){
        NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();
        Scanner keyboard = new Scanner(System.in);

        String input = keyboard.nextLine();
        keyboard.close();
        Collection<Integer> collectedNumbers = summarizer.collect(input);
        String summarized = summarizer.summarizeCollection(collectedNumbers);

        System.out.println(summarized);
    }
}
