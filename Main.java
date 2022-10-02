import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static char operation;
    static int result;
    static int chast1, chast2;

    public static void main(String[] args) {
        System.out.println("Enter 2 numbers with operation(Roman numbers same)");
        String chislo = scanner.nextLine();
        calc(chislo);

    }

    public static String calc(String input) {

        char[] znak = new char[10];
        for (int i = 0; i < input.length(); i++) {
            znak[i] = input.charAt(i);
            if (znak[i] == '+') {
                operation = '+';
            }
            if (znak[i] == '-') {
                operation = '-';
            }
            if (znak[i] == '*') {
                operation = '*';
            }
            if (znak[i] == '/') {
                operation = '/';
            }
        }
        String arifmStroka = String.valueOf(znak);
        String[] razdelenie = arifmStroka.split("[+-/*]");
        String block1 = razdelenie[0];
        String block2 = razdelenie[1];
        String block3 = block2.trim();
        chast1 = Enum.romanToArabic(block1);
        chast2 = Enum.romanToArabic(block3);
        if (razdelenie.length > 2)
            throw new ArrayIndexOutOfBoundsException("No more, than 2 operands!");
        else
            razdelenie = Arrays.copyOf(razdelenie, 2);
        try {
            block1 = razdelenie[0].trim();
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
        if (chast1 < 0 && chast2 < 0) {
            result = 0;
        }
        if (chast1 > 0 && chast2 > 0){
            result = Enum.calculated(chast1, chast2, operation);
            System.out.println("Roman: ");
            String resultRoman = Enum.convertArabToRome(result);
            System.out.println(block1 + " " + operation + " " + block3 + " = " + resultRoman);

        } else {
            chast1 = Enum.romanToArabic(block1);
            if (chast1 == -1) {
                chast1 = Integer.parseInt(block1);

            }
            chast2 = Enum.romanToArabic(block3);
            if (chast2 == -1) {
                chast2 = Integer.parseInt(block3);
            }
            result = Enum.calculated(chast1, chast2, operation);
            System.out.println("Arab: ");
            System.out.println(chast1 + " " + operation + " " + chast2 + " = " + result);
            return input;
        }
        return arifmStroka;
    }

    class Enum {
        private static String convertArabToRome(int numArabian) {
            String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                    "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                    "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                    "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                    "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                    "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                    "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
            };
            return roman[numArabian];
        }

        private static int romanToArabic(String roman) {
            try {
                switch (roman) {
                    case "I":
                        return 1;
                    case "II":
                        return 2;
                    case "III":
                        return 3;
                    case "IV":
                        return 4;
                    case "V":
                        return 5;
                    case "VI":
                        return 6;
                    case "VII":
                        return 7;
                    case "VIII":
                        return 8;
                    case "IX":
                        return 9;
                    case "X":
                        return 10;
                }
            } catch (InputMismatchException e) {
                throw new InputMismatchException();
            }
            return -1;
        }

        private static int calculated(int number1, int number2, char znak) {
            if (number1 <= 0 || number1 > 10 || number2 <= 0 || number2 > 10) {
                throw new IllegalArgumentException("Numbers can't be more than 10 and lower than 1!");
            }
            int result = 0;
            switch (znak) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
                    try {
                        result = number1 / number2;
                    } catch (ArithmeticException | InputMismatchException e) {
                        System.out.println("Exception : " + e);
                        System.out.println("Допускаются только целые числа");

                        break;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Не верный знак!");
            }
            return result;
        }
    }
}


