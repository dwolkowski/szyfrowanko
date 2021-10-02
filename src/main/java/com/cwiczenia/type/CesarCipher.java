package com.cwiczenia.type;

import com.cwiczenia.IEncoder;

import java.util.*;

public class CesarCipher implements IEncoder {
    private final HashMap<String, String> KEY_MAP;
    private final HashMap<String, String> DECODE_KEY_MAP;
    private final int numberOfPlaces;

    // Konstruktor domyślny inicjujacy mape potrzebna do szyfracji jak i deszyfracji
    public CesarCipher(int numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
        KEY_MAP = initMap(numberOfPlaces);
        DECODE_KEY_MAP = initDecodeMap();
    }

    // Szyfruje słowa na szyfr cezara
    @Override
    public String encodeText(String line) {
        line = line.toUpperCase();
        String[] args = line.split("");
        StringBuilder encodedString = new StringBuilder();

        for (String arg : args)
            encodedString.append(KEY_MAP.getOrDefault(arg, arg));

        return encodedString.toString();
    }

    // Dekoduje szyfr cezara
    public String decodeText(String line) {
        line = line.toUpperCase();
        String[] args = line.split("");
        StringBuilder encodedString = new StringBuilder();

        for (String arg : args)
            encodedString.append(DECODE_KEY_MAP.getOrDefault(arg, arg));

        return encodedString.toString();
    }

    // Szyfruje rekurencyjnie
    @Override
    public String encodeTextWithRecursion(String line) {
        line = line.toUpperCase();
        if (line.length() > 0) {
            String result = convertLetter(String.valueOf(line.charAt(0)));
            return result + encodeTextWithRecursion(line.substring(1));
        }
        return "";
    }


    // Konwertuje pojedyncza litere
    public String convertLetter(String letter) {
        return KEY_MAP.getOrDefault(letter, letter);
    }

    // Getter
    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    // Metoda zwracająca mape < K - litera alfabetu, V - litera odpowiadajaca w szyfrze cezara >
    private HashMap<String, String> initMap(int numberOfPlaces) {
        List<String> plainText = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
        List<String> cesarText = new ArrayList<>();
        HashMap<String, String> keyMap = new HashMap<>();

        // Przesunięcie do przodu dla wartości dodatnich
        if (numberOfPlaces >= 0) {
            numberOfPlaces = numberOfPlaces % plainText.size();
            int plainTextIndex = numberOfPlaces;
            for (int i = 0; i < plainText.size(); i++) {
                if (plainTextIndex >= plainText.size())
                    plainTextIndex = 0;

                cesarText.add(plainText.get(plainTextIndex));
                plainTextIndex++;
            }
        }
        // Przesunięcie do tyłu dla wartości ujemnych
        else {
            numberOfPlaces = numberOfPlaces % plainText.size();
            int plainTextIndex = plainText.size() + numberOfPlaces;
            for (int i = 0; i < plainText.size(); i++) {
                if (plainTextIndex >= plainText.size())
                    plainTextIndex = 0;

                cesarText.add(plainText.get(plainTextIndex));
                plainTextIndex++;
            }
        }

        // Tworzenie mapy znaków < K->watość jawna , V-> wartość zaszyfrowana >
        for (int i = 0; i < plainText.size(); i++)
            keyMap.put(plainText.get(i), cesarText.get(i));

        return keyMap;
    }

    // Zwraca mape odwróconą do mapy  ( < V=K, K=V >
    private HashMap<String, String> initDecodeMap() {
        HashMap<String, String> keyMap = new HashMap<>();
        for (Map.Entry<String, String> mapaSzyfrowana : KEY_MAP.entrySet())
            keyMap.put(mapaSzyfrowana.getValue(), mapaSzyfrowana.getKey());
        return keyMap;
    }

}
