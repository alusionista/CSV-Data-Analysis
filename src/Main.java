/*
*  Java version: 18
*  Author: Gabriel Martins Silva
*  Date: June 7th, 2023
*  Contact: gabrielmarsilva@live.com
* */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        String csvFile = "./dataset.csv";
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        Set<String> singleLines = new HashSet<>();
        Map<String, Integer> counts = new HashMap<>();
        Map<String, Double> sums = new HashMap<>();
        Map<String, Double> averageByAccount = new  LinkedHashMap<>();
        Map<String, Double> sortedAverages;
        String line;
        int numberOfLines = 0;
        int accountsWith500OrOverTransaction = 0;

        reader.readLine(); // skipping the table header
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            String id = fields[3];
            double value = Double.parseDouble(fields[2]);
            if (counts.containsKey(id)) {
                counts.put(id, counts.get(id) + 1);
                sums.put(id, sums.get(id) + value);
            } else {
                counts.put(id, 1);
                sums.put(id, value);
            }

            singleLines.add(line);
            numberOfLines++;
        }
        reader.close();

        for (String value : counts.keySet()) {
            int count = counts.get(value);
            if (count >= 500) accountsWith500OrOverTransaction++;
        }

        for (String id : counts.keySet()) {
            int count = counts.get(id);
            double sum = sums.get(id);
            double average = sum / count;
            averageByAccount.put(id, average);
        }
        sortedAverages =
                averageByAccount.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)->e1));

        System.out.println("Total number of lines: " +numberOfLines);
        System.out.println("Number of unique lines: " + singleLines.size());
        System.out.println("Number of accounts that executed at least 500 transactions: " + accountsWith500OrOverTransaction);
        System.out.println("Account with 3rd highest average : " + sortedAverages.entrySet().toArray()[2]);
    }
}

