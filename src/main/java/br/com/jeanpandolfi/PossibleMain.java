package br.com.jeanpandolfi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossibleMain {

    public static void main(String[] args) {
        System.out.println(isAnagrama("!@#$%&*()", ")(*&$#@!%"));
        List<String> palavras = List.of("ripa", "amor","orem" , "ramo", "remo", "mero", "pair", "roma");
        List<List<String>> anagramas = new ArrayList<>();
        separarEmAnagramas(palavras, anagramas);
        System.out.println(anagramas);

        for (int i = 0; i < 100; i++){
            if(isPrimo(i)) System.out.println(i);
        }
    }

    static Boolean isAnagrama(String palavra1, String palavra2){
        if(palavra1.length() != palavra2.length()) return false;

        char[] arrayChar1 = palavra1.toCharArray();
        char[] arrayChar2 = palavra2.toCharArray();
        Arrays.sort(arrayChar1);
        Arrays.sort(arrayChar2);

        return Arrays.equals(arrayChar1, arrayChar2);
    }

    static void separarEmAnagramas(List<String> palavras, List<List<String>> anagramas){
        if(!palavras.isEmpty()){
            List<String> umAnagrama = new ArrayList<>();
            List<String> palavrasRestantes = new ArrayList<>();
            palavras.forEach( palavra -> {
                if(isAnagrama(palavra, palavras.get(0))){
                    umAnagrama.add(palavra);
                }else{
                    palavrasRestantes.add(palavra);
                }
            });
            anagramas.add(umAnagrama);
            separarEmAnagramas(palavrasRestantes, anagramas);
        }
    }

    public static boolean isPrimo(Integer number) {
        if (number % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
