package panel;

public class Convertion {
    public static String divisionToNumb(int number, int temp){
        String rec = "", sum = "";
        while (number > 0) {
            rec += String.valueOf(number % temp) + "";
            number = number / temp;
        }
        for (int i = rec.length() - 1; i >= 0; i--) {
            sum += rec.charAt(i) + "";
        }
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
    public static String convertToBin(String k){
        String rec = "", sum = "";
        int m = k.length()%3;
        int h = k.length() - k.length()%3;
        if(k.length()%3 != 0){
            for(int i = (k.length() - (k.length()%3)); i >= 0; i--){
                k = "0" + k;
            }
        }
        for(int i = 0; i < k.length(); i+=3){
            rec = k.substring(i, i+3);
            for (int j = 0; j < Calculation.binMassive.length-2; j++){
                if(rec.equals(Calculation.binMassive[j].substring(1,4)))
                    sum += j;
            }
        }
        return sum;
    }
}
