package br.com.jeanpandolfi;


import br.com.jeanpandolfi.utils.TestUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PossibleMainTest{

    @Test
    public void deveAcertarSeEAnagrama(){
        String palavra = TestUtils.gerarPalavra();
        assertTrue(FuncoesUtils.isAnagrama(palavra, TestUtils.shuffle(palavra)));
    }

    @Test
    public void deveErrarSeEAnagrama(){
        assertFalse(FuncoesUtils.isAnagrama(TestUtils.gerarPalavra(), TestUtils.gerarPalavra()));
    }

    @Test
    public void deveSepararCorretamenteEmAnagramas(){
        List<String> palavras = new ArrayList<>();
        List<List<String>> anagramas = new ArrayList<>();

        int tamanho = RandomUtils.nextInt(1,1000);
        for (int i = 0; i < tamanho; i++){
            String palavra = TestUtils.gerarPalavra();
            palavras.add(palavra);
            palavras.add(TestUtils.shuffle(palavra));
        }

        FuncoesUtils.separarEmAnagramas(palavras, anagramas);
        assertTrue(anagramas.get(RandomUtils.nextInt(1,tamanho)).size() == 2);
    }

    @Test
    public void deveErrarAoSepararEmAnagramas(){
        List<String> palavras = new ArrayList<>();
        List<List<String>> anagramas = new ArrayList<>();

        int tamanho = RandomUtils.nextInt(1,1000);
        for (int i = 0; i < tamanho; i++){
            String palavra = TestUtils.gerarPalavra();
            palavras.add(palavra);
            palavras.add(TestUtils.shuffle(palavra));
        }

        FuncoesUtils.separarEmAnagramas(palavras, anagramas);
        assertFalse(anagramas.get(RandomUtils.nextInt(1,tamanho)).size() == 1);
    }

    @Test
    public void deveAcertarSeEPrimo(){
        int quantidadeNumerosPrimos = 0;
        for(int i = 0; i < 1000000; i++){
            if(FuncoesUtils.isPrimo(i)){
                quantidadeNumerosPrimos++;
            }
        }
        assertTrue(quantidadeNumerosPrimos == 78498);
    }
}
