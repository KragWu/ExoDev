package utils;

import model.ElementPatternFound;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SearchPatternUtils {

    public static Integer findFirstAndLastNumberIn(String line, List<String> pattern) {
        int result = 0;
        List<ElementPatternFound> listResult = findPattern(line, pattern);
        listResult.sort(Comparator.comparingInt(ElementPatternFound::getPosition));
        System.out.println(listResult);
        if (listResult.size() > 1) {
            result = Integer.parseInt(listResult.get(0).convert() + listResult.get(listResult.size() - 1).convert());
        } else if (listResult.size() == 1) {
            result = Integer.parseInt(listResult.get(0).convert() + listResult.get(0).convert());
        }
        return result;
    }

    public static List<ElementPatternFound> findPattern(String line, List<String> pattern) {
        List<ElementPatternFound> result = new ArrayList<>();
        pattern.forEach(element -> {
            List<Integer> positions = findPositionElement(element, line);
            for (int position: positions) {
                ElementPatternFound elementFound = new ElementPatternFound(element, element.length(), position);
                result.add(elementFound);
            }
        });
        return result;
    }

    public static List<Integer> findPositionElement(String pattern, String line) {
        List<Integer> lIndex = new ArrayList<>();
        int indexSaved = -1;
        for (int indexLine = 0; indexLine < line.length(); indexLine++) {
            boolean allPatternRead = false;
            if ((line.charAt(indexLine) == pattern.charAt(0)) && (indexLine + pattern.length() <= line.length())) {
                allPatternRead = true;
                indexSaved = indexLine;
                for (int indexPattern = 1; indexPattern < pattern.length(); indexPattern++) {
                    allPatternRead = allPatternRead && line.charAt(indexLine + indexPattern) == pattern.charAt(indexPattern);
                }
            }
            if (allPatternRead) {
                lIndex.add(indexSaved);

            }
        }
        return lIndex;
    }

}
