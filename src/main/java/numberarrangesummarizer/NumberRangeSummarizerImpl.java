package numberarrangesummarizer;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Scanner;

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer{
    @Override
    public Collection<Integer> collect(String input) {
        String[] parts = input.split(","); // Split list into sperate integer parts

        Collection<Integer> numbers = new ArrayList<Integer>();

        for(String part : parts){
            try {
                numbers.add(Integer.parseInt(part.trim())); // Add parts to the collection
            } catch (NumberFormatException e) {
                System.err.println("Invalid input: '" + part.trim() + "' is not a valid integer.");
            }
        }
        return numbers;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input){
        ArrayList<Integer> numbers = new ArrayList<>(input);
        StringBuilder output = new StringBuilder(); // Create output string builder
        int inputSize = numbers.size();

        for(int i = 0; i < inputSize; i++){
            int start = numbers.get(i);
            int end = start;

            // Check if the current integer is at the end of the list and if it is one less than the next item in the list
            while(i + 1 < inputSize && numbers.get(i + 1) == numbers.get(i) + 1){ 
                end = numbers.get(i + 1);
                i++;
            }
            // If there is no sequential pattern then number has its own group
            if(start == end){
                output.append(start);
            }
            // If not then add the start of the sequence with the end spaced by a hyphen 
            else{
                output.append(start).append("-").append(end);
            }
            // Add a comma after every entry besides the last
            if (i < inputSize - 1) {
                output.append(", ");
            }
        } 
        return output.toString();
    }

    public static void main(String[] args){
        NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();
        Scanner keyboard = new Scanner(System.in);

        // Get input from the user 
        try {
            System.out.println("Enter a comma-separated list of numbers:");
            String input = keyboard.nextLine();
            Collection<Integer> collectedNumbers = summarizer.collect(input);
            String summarized = summarizer.summarizeCollection(collectedNumbers);
            System.out.println(summarized);
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            keyboard.close();
        }
    }
}
