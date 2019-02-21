package panel;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public class Calculation {
    public static void main(String[] args) {
        System.out.println(calcHex("16", 8));
        //  System.out.println(Convertion.multiplyMethod("16", 8));
    }
    public static String[] binMassive = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001"};
    public static HashMap<String, String> binHex = new HashMap<>();
    public static String[] letterMas = {"A", "B", "C", "D", "E", "F"};
    static {
        binHex.put("A", "1010");
        binHex.put("B", "1011");
        binHex.put("C", "1100");
        binHex.put("D", "1101");
        binHex.put("E", "1110");
        binHex.put("F", "1111");
    }
    // public static String[] numbHex = {"A", "B", "C", "D", "E", "F"};
    public static void calculation(String k, int temp) {
      /*  if () calcDec();
            if () calcHex();
                if () calcOct();
                    if () */
    }
    public static String calcBin(String k, int temp) {
        String rec = ""; // sum = "";
        int number = 0;
        try {
            number = Integer.parseInt(k);
            if (temp == 10) {
                rec = Convertion.divisionToNumb(number, 2);
                System.out.println("rec: " + rec);
            }
            if (temp == 8) {
                rec = Convertion.convertToBin(k, 8);
                System.out.println("rec " + rec);
            }
        } catch (NumberFormatException e) {
            if (temp == 16) {
                for (Character c : k.toCharArray()) {
                    if (Character.isDigit(c)) {
                        rec += Convertion.convertationNumbToBin(Character.getNumericValue(c)) + "";
                    } else {
                        for (Map.Entry<String, String> pair : binHex.entrySet()) {
                            if (String.valueOf(c).equals(pair.getKey()))
                                rec += pair.getValue() + "";
                        }
                    }
                }
            }
            System.out.println("rec_Hex " + rec);
        }
        return rec;
    }
    public static String calcOct(String k, int temp) {
        String rec = "", sum = "";
        if (temp == 2) {
            for (Character charac : String.valueOf(k).toCharArray()) {
                for (int i = 0; i < binMassive.length - 2; i++) {
                    if (i == Character.getNumericValue(charac))
                        sum +=  binMassive[i].substring(1, 4) + "";
                }
            }
        }
        if (temp == 10) {
            sum = Convertion.multiplyMethod(k, 8);
            //  System.out.println("rec: " + sum);
        }
        if (temp == 16) {
            for (Character ch : k.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    for (Map.Entry<String, String> pair : binHex.entrySet()) {
                        if (pair.getKey().equals(String.valueOf(ch)))
                            rec = rec + pair.getValue();
                    }
                } else {
                    for (int i = 0; i < binMassive.length; i++) {
                        if (Character.getNumericValue(ch) == i)
                            rec += binMassive[i];
                    }
                }
            }
            sum = Convertion.convertToBin(rec, 8);
            System.out.println("sumHex = " + sum);
        }
        return sum;
    }
    public static String calcHex(String k, int temp) {
        String rec = "", sum = "";
        int number = 0, h = 0;
        if (temp == 10) {
            try {
                number = Integer.parseInt(k);
                while (number > 0) {
                    h = number % 16;
                    if (number % 16 >= 10) {
                        for (int i = 0; i < letterMas.length; i++) {
                            if (String.valueOf(number % 16).equals("1" + i))
                                rec += letterMas[i] + "";
                        }
                    } else {
                        rec += String.valueOf(number % 16) + "";
                    }
                    number = number / 16;
                }
                sum = Convertion.returnOperation(rec);
                System.out.println("recHex = " + sum);
            } catch (NumberFormatException e) {
                System.out.println("Wrong value is detected in calcHex");
            }
        }
        if (temp == 2) {
            k = Convertion.zeroAddition(k, 4);
            for (int i = 0; i < k.length(); i += 4) {
                rec = k.substring(i, i + 4);
                for (int j = 0; j < Calculation.binMassive.length; j++) {
                    if (rec.equals(Calculation.binMassive[j].substring(0, 4)))
                        sum += j;
                }
                for (Map.Entry<String, String> pair : binHex.entrySet()) {
                    if (pair.getValue().equals(rec))
                        sum += pair.getKey();
                }
            }
            System.out.println("recHex = " + sum);
        }
        if (temp == 8) {
            sum = Convertion.multiplyMethod(k, 8);

            // sum = Convertion.divisionToNumb(Integer.parseInt(sum), 16);
        }
        return sum;
    }
}