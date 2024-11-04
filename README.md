# Number Range Summarizer

A Java project implementing an interface to produce a comma-delimited list of numbers, grouping them into ranges when they are sequential.

## Project Overview
This program implements the `NumberRangeSummarizer` interface, which collects a list of integers from a comma-separated string, identifies sequential numbers, and outputs them in a summarized form, combining sequential numbers into ranges.

### Interface
The `NumberRangeSummarizer` interface includes:
- `collect(String input)`: Parses a comma-separated string of integers and returns a `Collection<Integer>` object.
- `summarizeCollection(Collection<Integer> input)`: Takes a collection of integers, identifies consecutive numbers, and returns a summarized string, e.g., `1, 3, 6-8, 12-15`.

### Prerequisites
- **Java 8** or higher
- **Apache Maven** for building the project

### Usage
Excecute the main method in the `NumberRangeSummarizerImpl` file. You will be prompted to enter a comma delimited list of integers.

### Example
`1,3,6,7,8,12,13,14,15,21,22,23,24,31` will become `1, 3, 6-8, 12-15, 21-24, 31`.

### Testing
In the root project folder, run the maven unit tests using `mvn test`.

