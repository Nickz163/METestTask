import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberTranslator {
    private int firstRadix;
    private int secondRadix;

    private NumberTranslator(int firstRadix, int secondRadix) {
        this.firstRadix = firstRadix;
        this.secondRadix = secondRadix;
    }

    public static NumberTranslator from(int firstRadix, int secondRadix) {
        if (firstRadix < 2 || secondRadix < 2 || firstRadix > 36 || secondRadix > 36)
            throw new NumberFormatException("radix should be in the range of 2 to 36");
        return new NumberTranslator(firstRadix, secondRadix);
    }

    public String translate(String number) throws NumberFormatException {
        BigInteger bigInteger = new BigInteger(number, firstRadix);
        return bigInteger.toString(secondRadix);
    }

    public String translate(int number) {
        return translate(String.valueOf(number));
    }


    public int getFirstRadix() {
        return firstRadix;
    }

    public int getSecondRadix() {
        return secondRadix;
    }


}
