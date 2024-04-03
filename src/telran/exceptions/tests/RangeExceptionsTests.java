package telran.exceptions.tests;

import org.junit.jupiter.api.Test;
import telran.exceptions.NumberGreaterRangeMaxException;
import telran.exceptions.NumberLessRangeMinException;
import telran.exceptions.RangeExceptions;

import static org.junit.jupiter.api.Assertions.*;

public class RangeExceptionsTests {
    @Test
    void factoryMethodTest() throws NumberGreaterRangeMaxException, NumberLessRangeMinException {
        RangeExceptions range = RangeExceptions.getRangeExceptions(3, 30);
        assertThrowsExactly(IllegalArgumentException.class, () -> RangeExceptions.getRangeExceptions(30, 3));
        range.checkNumber(5);
        assertThrowsExactly(NumberGreaterRangeMaxException.class, () -> range.checkNumber(35));
        assertThrowsExactly(NumberLessRangeMinException.class, () -> range.checkNumber(2));
    }
}
