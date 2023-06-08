import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class MainRefactored {
    public static void main(String[] args) throws Exception {
        String csvFile = "./dataset.csv";
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));
        Set<String> singleLines = new HashSet<>();
        Map<String, Integer> counts = new HashMap<>();
        Map<String, Double> sums = new HashMap<>();
        Map<String, Double> averageByAccount = new LinkedHashMap<>();

        reader.readLine(); // skipping the table header
        String line;
        int numberOfLines = 0;
        int accountsWith500OrOverTransaction = 0;
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            String account = fields[3];
            double transaction = Double.parseDouble(fields[2]);

            counts.merge(account, 1, Integer::sum);
            sums.merge(account, transaction, Double::sum);
            singleLines.add(line);
            numberOfLines++;
        }
        reader.close();

        for (int count : counts.values()) {
            if (count >= 500) accountsWith500OrOverTransaction++;
        }

        for (String id : counts.keySet()) {
            int count = counts.get(id);
            double sum = sums.get(id);
            double average = sum / count;
            averageByAccount.put(id, average);
        }

        var thirdHighestAverage = averageByAccount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3).toList().get(2).getKey();

        System.out.println("Total number of lines: " + numberOfLines);
        System.out.println("Number of unique lines: " + singleLines.size());
        System.out.println("Number of accounts that executed at least 500 transactions: " + accountsWith500OrOverTransaction);
        System.out.println("Account with 3rd highest average : " + thirdHighestAverage);
    }
}
