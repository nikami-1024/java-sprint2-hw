public class MonthItem {
    // item_name,is_expense,quantity,unit_price
    public String itemName;
    public boolean isExpense;
    public int quantity;
    public int price;

    public MonthItem(String itemName, boolean isExpense, int quantity, int price) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.price = price;
    }
}
