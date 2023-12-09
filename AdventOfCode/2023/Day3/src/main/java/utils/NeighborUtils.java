package utils;

import java.util.ArrayList;
import java.util.List;

public class NeighborUtils {

    public static List<Integer> searchNeighbor(int position, int size, char axe) {
        List<Integer> listPosition = new ArrayList<>();
        if (axe == 'x') {
            if (position - 1 > 0) {
                listPosition.add(position - 1);
            }
            for (int index = 0; index < size + 1; index++) {
                listPosition.add(position + index);
            }
        } else if (axe == 'y') {
            if (position - 1 > 0) {
                listPosition.add(position - 1);
            }
            listPosition.add(position);
            listPosition.add(position + 1);
        }
        return listPosition;
    }
}
