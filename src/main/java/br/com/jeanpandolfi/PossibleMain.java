package br.com.jeanpandolfi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossibleMain {

    public static void main(String[] args) {
        System.out.println(FuncoesUtils.isAnagrama("!@#$%&*()", ")(*&$#@!%"));
        List<String> palavras = List.of("ripa", "amor","orem" , "ramo", "remo", "mero", "pair", "roma");
        List<List<String>> anagramas = new ArrayList<>();
        FuncoesUtils.separarEmAnagramas(palavras, anagramas);
        System.out.println(anagramas);

        for (int i = 0; i < 100; i++){
            if(FuncoesUtils.isPrimo(i)) System.out.println(i);
        }
    }


}
