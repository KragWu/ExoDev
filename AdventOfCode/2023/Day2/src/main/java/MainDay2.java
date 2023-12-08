import domain.SearchGameValid;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MainDay2 {

    public static void main(String[] args) {
        System.out.println("Advent of Code 2023 - Day 1");
        Path path = Paths.get("AdventOfCode/2023/Day2/src/main/resources/input.txt");
        try {
            List<String> lines = Files.readAllLines(path);
            System.out.println(lines);
            int result = 0;
            for (String line: lines) {
                System.out.println(line);
                int resultNumberForLine = SearchGameValid.isItValid(line, 2);
                System.out.println("ID Game = " + resultNumberForLine);
                result = result + resultNumberForLine;
                System.out.println("Add result = " + result);
            }
            System.out.println("Last result = " + result);

        } catch (IOException e) {
            System.out.println("Not lines in file");
        }

    }
}
