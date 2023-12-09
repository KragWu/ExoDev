package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ElementCalcul {
    String element;
    int x;
    int y;
    boolean isNumber;
    boolean isSymbol;

    List<ElementCalcul> nearNumber;

    public ElementCalcul(String element, int x, int y, boolean isNumber, boolean isSymbol) {
        this.element = element;
        this.x = x;
        this.y = y;
        this.isNumber = isNumber;
        this.isSymbol = isSymbol;
        this.nearNumber = new ArrayList<>();
    }

    public String getElement() {
        return element;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isNumber() {
        return isNumber;
    }

    public boolean isSymbol() {
        return isSymbol;
    }

    public void add(ElementCalcul element) {
        if (this.isSymbol != element.isSymbol && !this.nearNumber.contains(element)) {
            nearNumber.add(element);
        }
    }

    public List<ElementCalcul> getNearNumber() {
        return nearNumber;
    }

    @Override
    public String toString() {
        return "{" +
                "'" + element + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElementCalcul that = (ElementCalcul) o;
        return x == that.x && y == that.y && isNumber == that.isNumber && isSymbol == that.isSymbol && Objects.equals(element, that.element);
    }

    public int compute() {
        if (nearNumber.size() < 2) {
            return 0;
        } else if (nearNumber.size() == 2 && element.equals("*")) {
            return Integer.parseInt(nearNumber.get(0).getElement()) * Integer.parseInt(nearNumber.get(1).getElement());
        } else {
            return nearNumber.stream().map(ElementCalcul::getElement).map(Integer::parseInt).reduce(Integer::sum).orElse(0);
        }
    }
}
