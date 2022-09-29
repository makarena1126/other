import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static char operation;
    static int result;
    static int number1, number2;
    public static void main (String[] args) {
        System.out.println("Enter 2 numbers with operation(Roman numbers same)");
        String chislo = scanner.nextLine();
        calc(chislo);
    }

    public static String calc(String input){
        char[] new_stroka = new char[10];
        for (int i = 0; i < input.length(); i++) {
            new_stroka[i] = input.charAt(i);
            if (new_stroka[i] == '+') {
                operation = '+';
            }
            if (new_stroka[i] == '-') {
                operation = '-';
            }
            if (new_stroka[i] == '*') {
                operation = '*';
            }
            if (new_stroka[i] == '/') {
                operation = '/';
            }
        }
        String arifmStroka = String.valueOf(new_stroka);
        String[] razdelenie = arifmStroka.split("[+-/*]");
        String block1 = razdelenie[0];
        String block2 = razdelenie[1];
        String block3 = block2.trim();
        number1 = romanToArabic(block1);
        number2 = romanToArabic(block3);
        if (number1 < 0 && number2 < 0) {
            result = 0;
        } else {
            result = calculated(number1,number2,operation);
            String resultRoman = convertArabToRome(result);
            System.out.println(block1 + " " + operation + " " + block3 + " = " + resultRoman);

        }
        number1 = Integer.parseInt(block1);
        number2 = Integer.parseInt(block3);
        result = calculated(number1, number2, operation);
        System.out.println(number1 + " " + operation + " " + number2 + " = " + result);
        return input;
    }

    private static String convertArabToRome(int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];
        return s;
    }

    private static int romanToArabic(String roman){
        try{
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")){
                return 2;
            }   else if (roman.equals("III")){
                return  3;
            } else if (roman.equals("IV")){
                return 4;
            }   else if (roman.equals("V")){
                return 5;
            } else if (roman.equals("VI")){
                return 6;
            } else if (roman.equals("VII")){
                return 7;
            } else if (roman.equals("VIII")){
                return 8;
            } else if (roman.equals("IX")){
                return 9;
            } else if (roman.equals("X")){
                return 10;
            }
        } catch (InputMismatchException e){
            throw new InputMismatchException("Roman numbers only I - X");
        }
        return -1;
    }

    private static int calculated (int number1, int number2, char operation){
        int result = 0;
        switch (operation) {
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
                    System.out.println("Only integer non-zero parameters allowed");
                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Need operation( + - * / )");
        }
        return result;
    }

}