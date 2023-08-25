import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CashflowManager cashflowManager = new CashflowManager();
        String separator = "==============================\n";

        // вывод приветствия
        System.out.println("Запуск приложения...");
        System.out.println("Добро пожаловать!\n");

        // бесконечный вывод меню
        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {         // 1 - Считать все месячные отчёты
                cashflowManager.loadMonthsReports();
            } else if (command == 2) {  // 2 - Считать годовой отчёт
                cashflowManager.loadYearReport();
            } else if (command == 3) {  // 3 - Сверить отчёты
                cashflowManager.checkReports();
            } else if (command == 4) {  // 4 - Вывести информацию обо всех месячных отчётах
                cashflowManager.printMonthsInfo();
            } else if (command == 5) {  // 5 - Вывести информацию о годовом отчёте
                cashflowManager.printYearInfo();
            } else if (command == 0) {  // 0 - Выход
                System.out.println("\nДля подтверждения выхода введите exit:");
                System.out.print(">> ");
                String exit = scanner.next();
                if (exit.equals("exit")) {
                    System.out.println("\nЗавершение работы приложения.");
                    System.out.println(separator);
                    break;
                } else {
                    System.out.println("\nВыход отменён, возврат в основное меню.");
                    System.out.println(separator);
                }
            } else {
                System.out.println("\nТакой команды нет, проверьте введённое значение и повторите ввод.");
                System.out.println(separator);
            }
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию обо всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");
        System.out.print(">> ");
    }
}