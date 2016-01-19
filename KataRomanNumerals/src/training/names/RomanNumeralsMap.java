package training.names;

import java.util.*;

/**
 * Created by Romina DRUTA on 07.01.2016.
 */
 final class RomanNumeralsMap {


    public static Map<Integer, String> romanNumeralsMap = new TreeMap<Integer, String>(Collections.reverseOrder());

    static {
        romanNumeralsMap.put(1000, "M");
        romanNumeralsMap.put(900, "CM");
        romanNumeralsMap.put(500, "D");
        romanNumeralsMap.put(400, "CD");
        romanNumeralsMap.put(100, "C");
        romanNumeralsMap.put(90, "XC");
        romanNumeralsMap.put(50, "L");
        romanNumeralsMap.put(40, "XL");
        romanNumeralsMap.put(10, "X");
        romanNumeralsMap.put(9, "IX");
        romanNumeralsMap.put(5, "V");
        romanNumeralsMap.put(4, "IV");
        romanNumeralsMap.put(1, "I");
    }
    public static Map<Integer, String> getRomanNumeralsMap() {
        return romanNumeralsMap;
    }


    public static Set<Integer> getNumeralsList() {
        return romanNumeralsMap.keySet();
    }


    public static String getRoman(Integer numeral) {
        return romanNumeralsMap.get(numeral);
    }


    public static Integer getCorrespondingNumberforRomanDigit(Object value) {
        for (Object o : romanNumeralsMap.keySet()) {
            if (romanNumeralsMap.get(o).toString().equals(value.toString())) {
                return (Integer) o;
            }

        }
        return null;
    }


}
