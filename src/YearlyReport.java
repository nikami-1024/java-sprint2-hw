import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
    int yearName;
    ArrayList<YearItem> items;
    FileReader file = new FileReader();

    public YearlyReport(String filePath) {
        yearName = Integer.parseInt(filePath.substring(2, 6));
        items = new ArrayList<>();

        ArrayList<String> lines = file.readFileContents(filePath);
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(","); // month,amount,is_expense
            String month = parts[0];
            int amount = Integer.parseInt(parts[1]);
            boolean isExpense = Boolean.parseBoolean(parts[2]);

            YearItem item = new YearItem(month, amount, isExpense);
            items.add(item);
        }
    }

    public int getSaleSum(String monthCode) {
        int sum = 0;
        for (YearItem item : items) {
            if (item.month.equals(monthCode)) {
                if (!item.isExpense) {
                    sum = item.amount;
                }
            }
            // sum = (item.month == monthCode && !item.isExpense) ? item.amount : sum;
        }
        return sum;
    }

    public int getBuySum(String monthCode) {
        int sum = 0;
        for (YearItem item : items) {
            if (item.month.equals(monthCode)) {
                if (item.isExpense) {
                    sum = item.amount;
                }
            }
            // sum = (item.month == monthCode && item.isExpense) ? item.amount : sum;
        }
        return sum;
    }

    public void printInfo() {
        // рассматриваемый год
        // прибыль по каждому месяцу
        // средний расход за все имеющиеся операции в году
        // средний доход за все имеющиеся операции в году

        HashMap<String, Integer> profitByMonth = new HashMap<>();
        ArrayList<String> months = new ArrayList<>();
        MonthCodes monthCodes = new MonthCodes();
        int monthCounter = 0;
        int sumExpense = 0;
        int sumProfit = 0;
        int avgExpense = 0;
        int avgProfit = 0;

        for (YearItem item : items) {
            if (!months.contains(item.month)) {
                months.add(item.month);
            }
        }

        monthCounter = months.size();

        for (YearItem item : items) {
            if (item.isExpense) {
                sumExpense += item.amount;
            } else {
                profitByMonth.put(item.month, item.amount);
                sumProfit += item.amount;
            }
        }

        avgExpense = sumExpense / monthCounter;
        avgProfit = sumProfit / monthCounter;

        System.out.println("Отчёт за " + yearName + " год:");
        System.out.println("Помесячная прибыль:");
        for (String monthCode : profitByMonth.keySet()) {
            System.out.println(monthCodes.monthCodesMap.get(monthCode) + ": " +
                    profitByMonth.get(monthCode));
        }
        System.out.println("Средний расход: " + avgExpense);
        System.out.println("Средний доход: " + avgProfit);
    }


}
