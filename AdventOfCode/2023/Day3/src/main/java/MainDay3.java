import domain.MapReader;
import model.ElementCalcul;
import utils.NeighborUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MainDay3 {

    public static void main(String[] args) {
        System.out.println("Advent of Code 2023 - Day 3");
        Path path = Paths.get("AdventOfCode/2023/Day3/src/main/resources/input.txt");
        try {
            List<String> lines = Files.readAllLines(path);
            System.out.println(lines);
            int result = 0;
            List<ElementCalcul> listElementFile = new ArrayList<>();
            List<ElementCalcul> listElementValid = new ArrayList<>();
            int indexLine = 0;
            for (String line: lines) {
                System.out.println(line);
                List<ElementCalcul> listElementLine = MapReader.read(line, indexLine);
                indexLine++;
                listElementFile.addAll(listElementLine);
                System.out.println(listElementLine);
            }
            List<ElementCalcul> listSymbol = listElementFile.stream().filter(ElementCalcul::isSymbol).toList();
            List<ElementCalcul> listNumber = listElementFile.stream().filter(ElementCalcul::isNumber).toList();
            for(ElementCalcul element : listNumber) {
                List<Integer> listElementX = NeighborUtils.searchNeighbor(element.getX(), element.getElement().length(), 'x');
                List<Integer> listElementY = NeighborUtils.searchNeighbor(element.getY(), 0, 'y');
                listSymbol.forEach(symbol -> {
                    if (listElementX.contains(symbol.getX()) && listElementY.contains(symbol.getY()) && !listElementValid.contains(element)) {
                        symbol.add(element);
                        listElementValid.add(element);
                    }
                });
            }
            System.out.println(listElementValid);
            System.out.println(listSymbol);
            result = listElementValid.stream().map(ElementCalcul::getElement).map(Integer::parseInt).reduce(Integer::sum).orElse(0);
            System.out.println("result = " + result);
            result = listSymbol.stream().map(ElementCalcul::compute).reduce(Integer::sum).orElse(0);
            System.out.println("result bis = " + result);
        } catch (IOException e) {
            System.out.println("Not lines in file");
        }

    }
}
