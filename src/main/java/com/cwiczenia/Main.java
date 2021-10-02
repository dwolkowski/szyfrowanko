package com.cwiczenia;

import com.cwiczenia.type.CesarCipher;
import com.cwiczenia.type.NumberCipher;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
	    Scanner scan = new Scanner(System.in);

        NumberCipher e = new NumberCipher();
        CesarCipher c = new CesarCipher(-3);

        System.out.print("Wprowadź słowo do kodowania: ");
        String line = scan.nextLine();

        System.out.println(e.encodeText(line));
        System.out.println(e.encodeTextWithRecursion(line));

        System.out.println(c.encodeText(line));
        System.out.println(c.encodeTextWithRecursion(line));

        System.out.println(c.decodeText(c.encodeText(line)));


    }
}
