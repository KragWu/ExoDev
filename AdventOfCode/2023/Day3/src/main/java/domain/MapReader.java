package domain;

import model.ElementCalcul;

import java.util.ArrayList;
import java.util.List;

public class MapReader {

    final static List<String> listNumber = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
    final static List<String> listSymbol = List.of("+", "-", "*", "/", "#", "$", "&", "=", "@", "%", "^");

    public static List<ElementCalcul> read(String line, int numberLine) {
        List<ElementCalcul> listElement = new ArrayList<>();
        String tmpElement = "";
        for(int index = 0; index < line.length(); index++) {
            if (listNumber.contains(String.valueOf(line.charAt(index)))) {
                tmpElement = tmpElement.concat(String.valueOf(line.charAt(index)));
            } else if (listSymbol.contains(String.valueOf(line.charAt(index)))) {
                listElement.add(new ElementCalcul(String.valueOf(line.charAt(index)), index, numberLine, false, true));
                if (!tmpElement.isEmpty()) {
                    listElement.add(new ElementCalcul(tmpElement, index - tmpElement.length(), numberLine, true, false));
                }
                tmpElement = "";
            } else {
                if (!tmpElement.isEmpty()) {
                    listElement.add(new ElementCalcul(tmpElement, index - tmpElement.length(), numberLine, true, false));
                }
                tmpElement = "";
            }
        }
        if (!tmpElement.isEmpty()) {
            listElement.add(new ElementCalcul(tmpElement, line.length() - tmpElement.length(), numberLine, true, false));
        }
        return listElement;
    }
}
