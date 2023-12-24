import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class MainDay4 {

    public static void main(String[] args) {
        System.out.println("Advent of Code 2023 - Day 4");
        Path path = Paths.get("AdventOfCode/2023/Day4/src/main/resources/input.txt");
        int result = 0;
        try {
            List<String> lines = Files.readAllLines(path);
            System.out.println(lines);
            int numberLine = 0;
            Map<Integer, Integer> mapTryLine = new HashMap<>();
            for (String line : lines) {

                numberLine = numberLine + 1;
                if (mapTryLine.containsKey(numberLine)) {
                    mapTryLine.replace(numberLine, mapTryLine.get(numberLine) + 1);
                } else {
                    mapTryLine.put(numberLine, 1);
                }

                AtomicBoolean firstTry = new AtomicBoolean(true);
                for (int index = 0; index < mapTryLine.get(numberLine); index++) {

                    AtomicInteger indexLine = new AtomicInteger(numberLine);
                    AtomicInteger cptResult = new AtomicInteger();

                    String[] splitLine = line.split("\\|");
                    System.out.println(Arrays.toString(splitLine));
                    List<String> numberWin = Arrays.stream(splitLine[0].split(":")[1].split(" ")).filter(elem -> !elem.isEmpty()).toList();
                    List<String> numberPlayed = Arrays.stream(splitLine[1].split(" ")).filter(elem -> !elem.isEmpty()).toList();
                    System.out.println(numberWin);
                    System.out.println(numberPlayed);

                    numberPlayed.forEach(number -> {
                        if (numberWin.contains(number)) {

                            indexLine.set(indexLine.get() + 1);

                            if (mapTryLine.containsKey(indexLine.get())) {
                                mapTryLine.replace(indexLine.get(), mapTryLine.get(indexLine.get()) + 1);
                            } else {
                                mapTryLine.put(indexLine.get(), 1);
                            }

                            if (firstTry.get()) {

                                if (cptResult.get() < 2) {
                                    cptResult.set(cptResult.get() + 1);
                                } else {
                                    cptResult.set(cptResult.get() * 2);
                                }
                            }
                        }
                    });
                    firstTry.set(false);
                    result = result + cptResult.get();
                }
            }
            System.out.println("result = " + result);
            List<Integer> newResult = mapTryLine.values().stream().toList();
            System.out.println(newResult);
            System.out.println(newResult.stream().reduce(Integer::sum));
        } catch (IOException e) {
            System.out.println("Not lines in file");
        }

    }
}
