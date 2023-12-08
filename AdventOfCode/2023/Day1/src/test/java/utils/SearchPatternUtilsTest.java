package utils;

import model.ElementPatternFound;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SearchPatternUtilsTest {

    List<String> pattern = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9",//); //,
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
    @Test
    public void findFirstAndLastNumberIn_Number() {
        int result = SearchPatternUtils.findFirstAndLastNumberIn("1aze2", pattern);
        Assert.assertSame(12, result);
    }

    @Test
    public void findPattern_Number() {
        List<ElementPatternFound> result = SearchPatternUtils.findPattern("1aze2", pattern);
        Assert.assertSame(2, result.size());
        Assert.assertSame("1", result.get(0).getPatternFound());
        Assert.assertSame(0, result.get(0).getPosition());
    }

    @Test
    public void findPositionElement_Number() {
        List<Integer> result = SearchPatternUtils.findPositionElement("1", "1aze2");
        Assert.assertSame(1, result.size());
        Assert.assertSame(0, result.get(0));
    }

    @Test
    public void findFirstAndLastNumberIn_Word() {
        int result = SearchPatternUtils.findFirstAndLastNumberIn("oneazetwo", pattern);
        Assert.assertSame(12, result);
    }

    @Test
    public void findPattern_Word() {
        List<ElementPatternFound> result = SearchPatternUtils.findPattern("oneazetwo", pattern);
        Assert.assertSame(2, result.size());
        Assert.assertSame("one", result.get(0).getPatternFound());
        Assert.assertSame(0, result.get(0).getPosition());
    }

    @Test
    public void findPositionElement_Word() {
        List<Integer> result = SearchPatternUtils.findPositionElement("one", "oneazetwo");
        Assert.assertSame(1, result.size());
        Assert.assertSame(0, result.get(0));
    }

    @Test
    public void findFirstAndLastNumberIn_OneNumber() {
        int result = SearchPatternUtils.findFirstAndLastNumberIn("oneaze", pattern);
        Assert.assertSame(11, result);
    }

    @Test
    public void findFirstAndLastNumberIn_ZeroNumber() {
        int result = SearchPatternUtils.findFirstAndLastNumberIn("aze", pattern);
        Assert.assertSame(0, result);
    }

    @Test
    public void findPattern_ZeroNumber() {
        List<ElementPatternFound> result = SearchPatternUtils.findPattern("aze", pattern);
        Assert.assertSame(0, result.size());
    }
}