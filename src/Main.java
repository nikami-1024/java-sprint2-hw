import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CashflowManager cashflowManager = new CashflowManager();

        // вывод приветствия
        System.out.println("Запуск приложения...");
        System.out.println("Добро пожаловать!");
        System.out.println();

        // бесконечный вывод меню
        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {         // 1 - Считать все месячные отчёты
                System.out.println();
                cashflowManager.loadMonthsReports();
            } else if (command == 2) {  // 2 - Считать годовой отчёт
                System.out.println();
                cashflowManager.loadYearReport();
            } else if (command == 3) {  // 3 - Сверить отчёты
                System.out.println();
                cashflowManager.checkReports();
            } else if (command == 4) {  // 4 - Вывести информацию обо всех месячных отчётах
                System.out.println();
                cashflowManager.printMonthsInfo();
            } else if (command == 5) {  // 5 - Вывести информацию о годовом отчёте
                System.out.println();
                cashflowManager.printYearInfo();
            } else if (command == 0) {  // 0 - Выход
                System.out.println();
                System.out.println("Для подтверждения выхода введите exit:");
                System.out.print(">> ");
                String exit = scanner.next();
                if (exit.equals("exit")) {
                    System.out.println();
                    System.out.println("Завершение работы приложения.");
                    printSeparator();
                    break;
                } else {
                    System.out.println();
                    System.out.println("Выход отменён, возврат в основное меню.");
                    printSeparator();
                }
            } else {
                System.out.println();
                System.out.println("Такой команды нет, проверьте введённое значение и повторите ввод.");
                printSeparator();
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

    public static void printSeparator() {
        System.out.println("==============================");
        System.out.println();
    }
}

