import java.util.Scanner;

public class calculator {
    public static void main(String[] args){
        Scanner inSc = new Scanner(System.in);
        String s = inSc.nextLine();
        String[] ss = s.split(" ");

        if(ss.length < 3) {
            System.out.println("throws Exception //т.к. строка не является математической операцией");
            return;
        } else if(ss.length > 3){               // Не дает выдать ошибку, если выражение написано правильно, но с пробелом в конце "1 + 2_"
            if(ss[3] != null){
                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                return;
            }
        }

        String aa = ss[0];
        String bb = ss[2];
        String c = ss[1];

        if((aa.contains("I") || aa.contains("V") || aa.contains("X")) && (bb.contains("I") || bb.contains("V") || bb.contains("X"))) {
            if (aa.contains("-") || bb.contains("-")){              // не дает указывать отрицательные Римские цифры "-I"
                System.out.println("throws Exception //т.к. в условии задачи сказано, что должны быть положительные числа");
            }
            int a = CountAndRoman.valueOf(aa).toInt();
            int b = CountAndRoman.valueOf(bb).toInt();
            System.out.println(roman(calc(a, b, c)));
        }else if((aa.contains("1") || aa.contains("2") || aa.contains("3") || aa.contains("4") || aa.contains("5") || aa.contains("6") || aa.contains("7") || aa.contains("8") || aa.contains("9") || aa.contains("0"))
                    &&
                    (bb.contains("1") || bb.contains("2") || bb.contains("3") || bb.contains("4") || bb.contains("5") || bb.contains("6") || bb.contains("7") || bb.contains("8") || bb.contains("9") || bb.contains("0"))) {
            if (aa.contains("-") || bb.contains("-")){              // не дает указывать отрицательные Арабские цифры, т.к. по условию должны быть цифры от 1 до 10 (не указано, что в абсолюте)
                System.out.println("throws Exception //т.к. в условии задачи сказано, что должны быть положительные числа");
            }
            int a = Integer.valueOf(aa);
            int b = Integer.valueOf(bb);
            System.out.println(calc(a, b, c));
        } else{
            System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
        }
    }

    public static String calc(int a1, int b1, String c1) {
        int count;
        String concl;
        switch (c1) {
            case "/":
                count = a1 / b1;
                concl = String.valueOf(count);
                break;
            case "*":
                count = a1 * b1;
                concl = String.valueOf(count);
                break;
            case "+":
                count = a1 + b1;
                concl = String.valueOf(count);
                break;
            case "-":
                count = a1 - b1;
                concl = String.valueOf(count);
                break;
            default:
                concl = "throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)";
        }
        return concl;
    }

    public static String roman(String s_calc){
        String concl;
        int number = Integer.valueOf(s_calc);
        String[] rim = new String[] {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] count = new int[] {100, 90, 50, 40, 10, 9, 5, 4, 1};

        if(s_calc == "throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)") {
            concl = s_calc;
        } else if (number <= 0){
            concl = "throws Exception //т.к. в римской системе нет отрицательных чисел";
        } else {
            StringBuilder str_b = new StringBuilder();
            int ind = 0;
            while (ind < rim.length) {
                while (number >= count[ind]) {
                    var d = number / count[ind];
                    number = number % count[ind];
                    for (int i = 0; i < d; i++) {
                        str_b.append(rim[ind]);
                    }
                } ind++;
            } concl = str_b.toString();
        } return concl;
    }
}
