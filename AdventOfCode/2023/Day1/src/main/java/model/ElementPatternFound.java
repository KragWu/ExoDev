package model;

import java.util.Objects;

public class ElementPatternFound {

    String patternFound;
    int size;
    int position;

    public ElementPatternFound(String patternFound, int size, int position) {
        this.patternFound = patternFound;
        this.size = size;
        this.position = position;
    }

    public String getPatternFound() {
        return patternFound;
    }

    public int getPosition() {
        return position;
    }

    public int getSize() {
        return size;
    }

    public boolean isOverlap(ElementPatternFound other) {
        boolean result = false;
        if (this.position > other.position) {
            if (other.position + other.size - 1 >= this.position) {
                result = true;
            }
        }
        return result;
    }

    public String convert() {
        String result = "";
        switch (this.patternFound) {
            case "0", "zero": result="0";break;
            case "1", "one": result="1";break;
            case "2", "two": result="2";break;
            case "3", "three": result="3";break;
            case "4", "four": result="4";break;
            case "5", "five": result="5";break;
            case "6", "six": result="6";break;
            case "7", "seven": result="7";break;
            case "8", "eight": result="8";break;
            case "9", "nine": result="9";break;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElementPatternFound that = (ElementPatternFound) o;
        return size == that.size && position == that.position && Objects.equals(patternFound, that.patternFound);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patternFound, size, position);
    }

    @Override
    public String toString() {
        return "ElementPatternFound{" +
                "patternFound='" + patternFound + '\'' +
                ", size=" + size +
                ", position=" + position +
                '}';
    }
}
