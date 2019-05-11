import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberTranslatorTest {

    @Test
    public void decimalToBinaryTest() {
        NumberTranslator decimalToBinary = NumberTranslator.from(10, 2);
        //act
        String actual = decimalToBinary.translate("10");
        String expected = "1010";
        //assert
        assertEquals(expected, actual);

    }

    @Test
    public void binaryToDecimalTest() {
        NumberTranslator decimalToBinary = NumberTranslator.from(2, 10);
        //act
        String actual = decimalToBinary.translate("1010");
        String expected = "10";
        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void maxRadixToDecimal() {
        NumberTranslator decimalToBinary = NumberTranslator.from(36, 10);
        //act
        String actual = decimalToBinary.translate("z");
        String expected = "35";
        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void decimalToMaxRadix() {
        NumberTranslator decimalToBinary = NumberTranslator.from(10, 36);
        //act
        String actual = decimalToBinary.translate("35");
        String expected = "z";
        //assert
        assertEquals(expected, actual);
    }



    @Test(expected = NumberFormatException.class)
    public void wrongFirstRadixTest() {
        NumberTranslator numberTranslator = NumberTranslator.from(1, 10);
    }

    @Test(expected = NumberFormatException.class)
    public void wrongSecondRadixTest() {
        NumberTranslator numberTranslator = NumberTranslator.from(2, 37);
    }

    @Test(expected = NumberFormatException.class)
    public void wrongNumberTest() {
        NumberTranslator binaryToDecimal = NumberTranslator.from(2,10);
        String actual = binaryToDecimal.translate("12a");
    }
}