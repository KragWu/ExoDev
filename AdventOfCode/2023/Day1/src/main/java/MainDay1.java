import utils.SearchPatternUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MainDay1 {

    static List<String> pattern = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9",//); //,
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

    public static void main(String[] args) {
        System.out.println("Advent of Code 2023 - Day 1");
        Path path = Paths.get("AdventOfCode/2023/Day1/src/main/resources/input.txt");
        try {
            List<String> lines = Files.readAllLines(path);
            System.out.println(lines);
            int result = 0;
            for (String line: lines) {
                System.out.println(line);
                int resultNumberForLine = SearchPatternUtils.findFirstAndLastNumberIn(line, pattern);
                System.out.println(resultNumberForLine);
                result = result + resultNumberForLine;
                System.out.println(result);
            }
            System.out.println("Last result = " + result);

        } catch (IOException e) {
            System.out.println("Not lines in file");
        }

    }
}
