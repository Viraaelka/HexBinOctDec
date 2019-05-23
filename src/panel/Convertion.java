package panel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*------------------------Additional class to simplify calculations in the Calculation class ------------------------*/
public class Convertion {
    public static String divisionToNumb(int number, int temp){
        String rec = "", sum = "";
        while (number > 0) {
            rec += String.valueOf(number % temp) + "";
            number = number / temp;
        }
        sum = returnOperation(rec);
        return sum;
    }

    public static String convertationNumbToBin(int number){
        String rec = "";
        for (Character charac : String.valueOf(number).toCharArray()) {
            for (int i = 0; i < Calculation.binMassive.length; i++) {
                if (i == Character.getNumericValue(charac))
                    rec += Calculation.binMassive[i] + "";
            }
        }
        return rec;
    }
    public static String convertToBin(String k, int temp){
        String rec = "", sum = "";
        if (temp == 8) temp = 2;
        else temp = 0;
        k = zeroAddition(k, 3);

        for(int i = k.length(); i > 0; i-=3) {
            rec = k.substring(i-3, i);
            for (int j = 0; j < Calculation.binMassive.length - temp; j++){
                if (rec.equals(Calculation.binMassive[j].substring(1, 4)))
                    sum += j;
            }
        }
        sum = returnOperation(sum);
        return sum;
    }

    public static String zeroAddition(String kup, int t){
        if(kup.length()%t != 0){
            for(int i = t - kup.length()%t; i > 0; i--){
                kup = "0" + kup;
            }
        }
        return kup;
    }
    public static String returnOperation(String rec){
        String sum = "";
        for (int i = rec.length() - 1; i >= 0; i--) {
            sum += rec.charAt(i) + "";
        }
        return sum;
    }




    public static String multiplyMethod(String str, int temp){
        int number = 0, d = 0, p = 0, m = 0, result = 0;
        String sum = "", res = "";
        int index = 0;
        for(int i = 0; i < str.length(); i++) {

            if (!Character.isDigit(str.charAt(i))) {
                for (int j = 0; j < Calculation.letterMas.length; j++) {
                    if (String.valueOf(str.charAt(i)).equals(Calculation.letterMas[j]))
                        number = Integer.parseInt("1" + j);
                }
            } else {
                number = Integer.parseInt(String.valueOf(str.charAt(i)));
            }
            d = (int) Math.pow(temp, str.length()-i-1);
            result += d * number;
        }
        return String.valueOf(result);
    }
    public static String regexZero(String rec){
        Pattern pattern = Pattern.compile("^\\d(0)*");
        Matcher matcher = pattern.matcher(rec);
        String kup = matcher.replaceAll("");
        return kup;
    }
}