package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List <String> words =readFile();
        List <String> anagrams= new ArrayList<>();
        for(List<String> list : groupAnagrams(words)) {
            if (list.size() > 1) {
                anagrams.addAll(list);
                System.out.println(list);

            }

        }
        System.out.println("Quantity: "+ anagrams.size());
    }
    public static List<ArrayList<String>> groupAnagrams(List<String> words) {

        List<ArrayList<String>> wordGroups = new ArrayList<ArrayList<String>>();
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();

        for(String word : words) {

            int sum = 0;
            for(char c : word.toCharArray())
                sum += c;
            if(map.containsKey(sum))
                map.get(sum).add(word);
            else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(word);
                map.put(sum, list);
            }

        }

        for(ArrayList<String> list : map.values())
            wordGroups.add(list);

        return wordGroups;
    }
    private static List<String> readFile(){
        BufferedReader reader;
        List<String> words= new ArrayList<>();
        try {
            System.getProperty("user.dir");
            String path=System.getProperty("user.dir");
            String rest="\\src\\main\\resources\\words.txt";
            Scanner scanner = new Scanner(new File(path+rest));

            while (scanner.hasNextLine()) {
                words.add(scanner.nextLine());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return  words;

    }
}
