package ex01;

import java.io.*;
import java.util.*;

public class Similarity {
    private final String dictPath;
    private final String textA;
    private final String textB;
    private final List<String> wordsA = new ArrayList<>();
    private final List<String> wordsB = new ArrayList<>();
    private final Set<String> dict = new HashSet<>();
    private int[] a;
    private int[] b;
    private double similarity = 0.0;
    private static final int BUFFER_SIZE = 10 * 1024 * 1024;

    public Similarity(String textA, String textB, String dictPath) {
        this.textA = textA;
        this.textB = textB;
        this.dictPath = dictPath;
    }

    void startApp() {
        textToStringArray(textA, wordsA);
        textToStringArray(textB, wordsB);
        createDict();
        a = occurrence(wordsA);
        b = occurrence(wordsB);
        similarity();
        writeDictInFile();
    }

    void textToStringArray(String text, List<String> words) {
        try (BufferedReader reader = new BufferedReader(new FileReader(text), BUFFER_SIZE)) {
            String line;
            while ((line = reader.readLine()) != null) {
                Collections.addAll(words, line.split("\\W+"));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    void createDict() {
        dict.addAll(wordsA);
        dict.addAll(wordsB);
    }


int[] occurrence(List<String> words) {
    Map<String, Integer> wordCount = new HashMap<>();
    
    for (String word : words) {
        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
    }

    int[] countOccurrence = new int[dict.size()];
    
    int j = 0;
    for (String word : dict) {
        countOccurrence[j] = wordCount.getOrDefault(word, 0);
        ++j;
    }
    
    return countOccurrence;
}


    public void similarity() {
        int numeratorAB = numeratorAB();
        double denominator = denominator();
        if (denominator != 0) {
            similarity = roundWithPrecision((numeratorAB / denominator), 100);
        }
        System.out.println("Similarity = " + similarity);
    }

    int numeratorAB() {
        int ab = 0;
        for (int i = 0; i < a.length; ++i) {
            ab += a[i] * b[i];
        }
        return ab;
    }
    double denominator() {
        int arrB = 0;
        int arrA = 0;
        double numeratorAB;
        double degree = 2;
        for (int i = 0; i < a.length; ++i) {
            arrA += (Math.pow(a[i], degree));
            arrB += (Math.pow(b[i], degree));
        }
        numeratorAB = (roundWithPrecision(Math.sqrt(arrA), 100))
                * (roundWithPrecision(Math.sqrt(arrB), 100));
        return roundWithPrecision(numeratorAB, 100);
    }

    double roundWithPrecision(double r, double units) {
        return Math.floor(r * units) / units;
    }
    private void writeDictInFile() {
        try (BufferedWriter fileOut = new BufferedWriter(new FileWriter(dictPath), BUFFER_SIZE)) {
            for (String s : dict) {
                fileOut.write(s + " ");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
