import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class App {

    public static void main(String[] args) {

        final String USAGE_STRING = "usage: java -jar <program name>     <radix of first notation (2-36)> " +
                "   <radix of second notation (2-36)>     <number for translation (according to the first notation)>";

        if (args.length != 3)
            System.out.println(USAGE_STRING);
        else {

            try {
                String number = args[2];
                int firstRadix = Integer.parseInt(args[0]);
                int secondRadix = Integer.parseInt(args[1]);

                NumberTranslator numberTranslator = NumberTranslator.from(firstRadix, secondRadix);
                System.out.println(numberTranslator.translate(number));

            } catch (NumberFormatException nfe) {
                System.err.println("Wrong input args: " + nfe.getMessage());
                System.out.println(USAGE_STRING);
            }

        }
    }
}
