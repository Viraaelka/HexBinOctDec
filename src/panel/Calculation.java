package panel;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;


public class Calculation {


    public static void main(String[]args){
        calcOct("110110101", 2);

    }

    public static String[] binMassive = {"0000", "0001","0010","0011", "0100", "0101", "0110", "0111", "1000", "1001"};
    public static HashMap<String, String> binHex = new HashMap<>();
    static {
        binHex.put("A", "1010");
        binHex.put("B", "1011");
        binHex.put("C", "1100");
        binHex.put("D", "1101");
        binHex.put("E", "1110");
        binHex.put("F", "1111");
    }

   // public static String[] numbHex = {"A", "B", "C", "D", "E", "F"};

    public static void  calculation(String k, int temp) {

      /*  if () calcDec();
            if () calcHex();
                if () calcOct();
                    if () */
    }
    public static void calcBin(String k, int temp){
        String rec = ""; // sum = "";
        int number = 0;
        try {
            number = Integer.parseInt(k);
            if (temp == 10) {
                rec = Convertion.divisionToNumb(number, 2);
                System.out.println("rec: " + rec);
            }
            if (temp == 8) {
                rec = Convertion.convertationNumbToBin(number);
                System.out.println("rec " + rec);
            }

        }catch (NumberFormatException e){
            if (temp == 16) {
                for (Character c : k.toCharArray()) {
                    if(Character.isDigit(c)){
                        rec += Convertion.convertationNumbToBin(Character.getNumericValue(c)) + "";
                    }else{
                         for (Map.Entry<String, String> pair : binHex.entrySet()) {
                             if (String.valueOf(c).equals(pair.getKey()))
                                 rec += pair.getValue() + "";
                         }
                      }
                }
            }
            System.out.println("rec_Hex " + rec);
        }
    }


    public static void calcOct(String k, int temp){
        String rec = "", sum = "";
        if(temp == 2){
            rec = Convertion.convertToBin(k);
            System.out.println("recOct = " + rec);
        }
        int number = 0;
        try{
            number = Integer.parseInt(k);
            if(temp == 10){
              rec = Convertion.divisionToNumb(number, 8);
                System.out.println("recOct = " + rec);
            }
        }
        catch(NumberFormatException e) {
            System.out.println("Wrong convertion to octavian");
        }
        if (temp == 16) {
                  for(Character ch : k.toCharArray()) {
                      if(!Character.isDigit(ch)) {
                          for (Map.Entry<String, String> pair : binHex.entrySet()) {
                              if (pair.getKey().equals(String.valueOf(ch)))
                                  rec = rec + pair.getValue();
                          }
                      }
                      else {
                        for (int i = 0; i < binMassive.length; i++) {
                            if (Character.getNumericValue(ch) == i)
                                rec += binMassive[i];
                        }
                    }
            }
                sum = Convertion.convertToBin(rec);
            System.out.println("sumHex = " + sum);
        }
    }
    public static void calcHex(String k, int temp){
        String rec = "", sum = "";
        int number = 0;
        try{
            number = Integer.parseInt(k);
            if(temp == 10){}
            if(temp == 2){}
            if(temp == 8){}
        }catch(NumberFormatException e){

        }
    }

}
