package br.com.jeanpandolfi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FuncoesUtils {

    /**
     * Diz se duas palvras são anagramas.
     * @param palavra1 primeira palvra a ser comparada
     * @param palavra2 segunda palavra a ser comparada com a primeira.
     * @return true se as palavras são anagramas e false se não forem.
     * */
    static Boolean isAnagrama(String palavra1, String palavra2){
        if(palavra1.length() != palavra2.length()) return false;

        char[] arrayChar1 = palavra1.toCharArray();
        char[] arrayChar2 = palavra2.toCharArray();
        Arrays.sort(arrayChar1);
        Arrays.sort(arrayChar2);

        return Arrays.equals(arrayChar1, arrayChar2);
    }

    /**
     * Separa uma lista de palvras em uma lista de anagramas
     * @param palavras lista de palavras a serem separadas
     * @param anagramas lista de anagramas a ser preenchido a partir da lista de palavras
     * */
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

    /**
     * Diz se um número inteiro é primo.
     * @param number número a ser analizado
     * @return true se number for primo e false se não for.
     * */
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
