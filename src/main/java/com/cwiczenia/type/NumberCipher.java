package com.cwiczenia.type;

import com.cwiczenia.IEncoder;

import java.util.HashMap;

public class NumberCipher implements IEncoder {
    private final HashMap<String, String> KEY_MAP;

    // Konstruktor domyślny inicjujacy mape zawierającą mapowanie klawiszy na wartości numeryczne
    public NumberCipher(){
        KEY_MAP = initMap();
    }

    // Prosta metoda zamieniająca Stringa wejściowego na zapis numeryczny
    @Override
    public String encodeText(String line){
        line = line.toUpperCase();
        String[] args = line.split("");
        StringBuilder encodedString = new StringBuilder();

        for(String arg : args)
            encodedString.append(KEY_MAP.getOrDefault(arg, arg));

        return encodedString.toString();
    }

    // Metoda rekurencyjna, co iteracje skraca długosć podanego Stringa o jeden index zamieniając po kolei pojedyńcze litery na wartości numeryczne
    @Override
    public String encodeTextWithRecursion(String line){
        line = line.toUpperCase();
        if(line.length()>0){
            String result = convertLetter(String.valueOf(line.charAt(0)));
            return result + encodeTextWithRecursion(line.substring(1));
        }
        return "";
    }

    // Konwertuje pojedyńczą litere na jej numeryczny odpowiednik, jeśli nie posiada odpowiednika pozostawia ją bez zmian
    private String convertLetter(String letter){
        return KEY_MAP.getOrDefault(letter, letter);
    }

    // Metoda zwracająca mape zawierającą numeryczne odwzorowania liter
    private HashMap<String, String> initMap(){
        HashMap<String, String> keyMap = new HashMap<>();
        keyMap.put(" ", "0");
        keyMap.put("A", "2");
        keyMap.put("B", "22");
        keyMap.put("C", "222");
        keyMap.put("D", "3");
        keyMap.put("E", "33");
        keyMap.put("F", "333");
        keyMap.put("G", "4");
        keyMap.put("H", "44");
        keyMap.put("I", "444");
        keyMap.put("J", "5");
        keyMap.put("K", "55");
        keyMap.put("L", "555");
        keyMap.put("M", "6");
        keyMap.put("N", "66");
        keyMap.put("O", "666");
        keyMap.put("P", "7");
        keyMap.put("Q", "77");
        keyMap.put("R", "777");
        keyMap.put("S", "7777");
        keyMap.put("T", "8");
        keyMap.put("U", "88");
        keyMap.put("V", "888");
        keyMap.put("W", "9");
        keyMap.put("X", "99");
        keyMap.put("Y", "999");
        keyMap.put("Z", "9999");

        return keyMap;
    }


}
