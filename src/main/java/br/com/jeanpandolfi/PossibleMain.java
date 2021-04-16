package br.com.jeanpandolfi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PossibleMain {

    public static void main(String[] args) {
        System.out.println(isAnagrama("!@#$%&*()", ")(*&$#@!%"));

        List<String> palavras = List.of("amor", "roma", "ramo", "remo", "orem", "mero", "ripa", "pair");
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
            //TODO Pode ser revisto filtrar duas vezes
            List<String> umAnagrama = palavras.stream().filter( palavra -> isAnagrama(palavra, palavras.get(0))).collect(Collectors.toList());
            List<String> palavrasRestantes = palavras.stream().filter( palavra -> !isAnagrama(palavra, palavras.get(0))).collect(Collectors.toList());
            anagramas.add(umAnagrama);
            separarEmAnagramas(palavrasRestantes, anagramas);
        }
    }

    static Boolean isPrimo(Integer numero){
        if(numero < 2) return false;
        List<Integer> divisores = List.of(2,3,5,7);

        for (Integer divisor : divisores){
            if(numero % divisor == 0 && !numero.equals(divisor)){
                return false;
            }
        }
        return true;
    }
}
