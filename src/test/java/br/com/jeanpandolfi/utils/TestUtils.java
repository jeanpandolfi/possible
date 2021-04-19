package br.com.jeanpandolfi.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TestUtils {
    public static String shuffle(String s) {
        List<Character> letters = s.chars().boxed().map(c -> (char) c.intValue()).collect(Collectors.toList());
        Collections.shuffle(letters);
        StringBuilder t = new StringBuilder(s.length());
        letters.forEach(t::append);
        return t.toString();
    }

    public static String gerarPalavra(){
        return RandomStringUtils.random(RandomUtils.nextInt(1,100));
    }
}
