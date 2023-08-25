import java.util.ArrayList;

public class MonthlyReport {
    String monthName;
    String monthCode;
    ArrayList<MonthItem> items;

    public MonthlyReport(String filePath) {
        MonthCodes monthCodes = new MonthCodes();

        monthCode = filePath.substring(6,8);
        monthName = monthCodes.monthCodesMap.get(monthCode);
        items = new ArrayList<>();

        ArrayList<String> lines = FileReader.readFileContents(filePath);
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(","); // item_name,is_expense,quantity,unit_price
            String itemName = parts[0].trim();
            boolean isExpense = Boolean.parseBoolean(parts[1]);
            int quantity = Integer.parseInt(parts[2]);
            int price = Integer.parseInt(parts[3]);

            MonthItem item = new MonthItem(itemName, isExpense, quantity, price);
            items.add(item);
        }
    }

    public int getSaleSum() {
        int sum = 0;
        for (MonthItem item : items) {
            if (!item.isExpense) {          // isExpense = false -> sale
                sum += item.quantity * item.price;
            }
        }
        return sum;
    }

    public int getBuySum() {
        int sum = 0;
        for (MonthItem item : items) {
            if (item.isExpense) {           // isExpense = true -> buy
                sum += item.quantity * item.price;
            }
        }
        return sum;
    }

    public int getMaxSaleSum() {
        int biggestSaleSum = 0;
        for (MonthItem item : items) {
            if (!item.isExpense) {          // isExpense = false -> sale
                int sum = item.quantity * item.price;
                if (sum > biggestSaleSum) {
                    biggestSaleSum = sum;
                }
            }
        }
        return biggestSaleSum;
    }

    public String getMaxSaleTitle() {
        int biggestSaleSum = 0;
        String biggestSaleTitle = "";
        for (MonthItem item : items) {
            if (!item.isExpense) {          // isExpense = false -> sale
                int sum = item.quantity * item.price;
                if (sum > biggestSaleSum) {
                    biggestSaleSum = sum;
                    biggestSaleTitle = item.itemName;
                }
            }
        }
        return biggestSaleTitle;
    }

    public int getMaxBuySum() {
        int biggestBuySum = 0;
        for (MonthItem item : items) {
            if (item.isExpense) {           // isExpense = true -> buy
                int sum = item.quantity * item.price;
                if (sum > biggestBuySum) {
                    biggestBuySum = sum;
                }
            }
        }
        return biggestBuySum;
    }

    public String getMaxBuyTitle() {
        int biggestBuySum = 0;
        String biggestBuyTitle = "";
        for (MonthItem item : items) {
            if (item.isExpense) {           // isExpense = true -> buy
                int sum = item.quantity * item.price;
                if (sum > biggestBuySum) {
                    biggestBuySum = sum;
                    biggestBuyTitle = item.itemName;
                }
            }
        }
        return biggestBuyTitle;
    }

    public void printInfo() {
        // самый прибыльный товар, название товара и сумма
        // самая большая трата, название товара и сумма

        System.out.println(monthCode + " " + monthName);
        System.out.println("Самый прибыльный товар: ");
        System.out.println(getMaxSaleTitle() + " " + getMaxSaleSum());
        System.out.println("Самая большая трата: ");
        System.out.println(getMaxBuyTitle() + " " + getMaxBuySum());
    }
}