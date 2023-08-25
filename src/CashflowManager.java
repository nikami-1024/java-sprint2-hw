import java.util.spi.AbstractResourceBundleProvider;

public class CashflowManager {
    String januaryReportFilepath = "m.202101.csv";
    String februaryReportFilepath = "m.202102.csv";
    String marchReportFilepath = "m.202103.csv";
    String yearReportFilepath = "y.2021.csv";
    boolean isLoadedMonths = false;
    boolean isLoadedYear = false;

    MonthlyReport januaryReport;
    MonthlyReport februaryReport;
    MonthlyReport marchReport;
    YearlyReport yearReport;

    public void loadMonthsReports() {
        januaryReport = new MonthlyReport(januaryReportFilepath);
        System.out.println("Загружен месяц: " + januaryReport.monthName);
        februaryReport = new MonthlyReport(februaryReportFilepath);
        System.out.println("Загружен месяц: " + februaryReport.monthName);
        marchReport = new MonthlyReport(marchReportFilepath);
        System.out.println("Загружен месяц: " + marchReport.monthName);
        isLoadedMonths = true;
        printSeparator();
    }

    public void loadYearReport() {
        yearReport = new YearlyReport(yearReportFilepath);
        System.out.println("Загружен год: " + yearReport.yearName);
        isLoadedYear = true;
        printSeparator();
    }

    public void checkReports() {
        if (isLoadedMonths && isLoadedYear) {
            // сверка
            boolean isCorrectCheck = true;

            boolean janSale = (januaryReport.getSaleSum() == yearReport.getSaleSum("01"));
            boolean janBuy = (januaryReport.getBuySum() == yearReport.getBuySum("01"));
            boolean febSale = (februaryReport.getSaleSum() == yearReport.getSaleSum("02"));
            boolean febBuy = (februaryReport.getBuySum() == yearReport.getBuySum("02"));
            boolean marSale = (marchReport.getSaleSum() == yearReport.getSaleSum("03"));
            boolean marBuy = (marchReport.getBuySum() == yearReport.getBuySum("03"));

            isCorrectCheck = janSale && janBuy && febSale && febBuy && marSale && marBuy;

            System.out.println("Выполняется сверка отчётов...");
            if (isCorrectCheck) {
                System.out.println("Сверка успешно завершена!");
            } else {
                if (!janSale) {
                    System.out.println(januaryReport.monthCode + " " +
                            januaryReport.monthName + ": расхождения в доходах!");
                }
                if (!janBuy) {
                    System.out.println(januaryReport.monthCode + " " +
                            januaryReport.monthName + ": расхождения в расходах!");
                }
                if (!febSale) {
                    System.out.println(februaryReport.monthCode + " " +
                            februaryReport.monthName + ": расхождения в доходах!");
                }
                if (!febBuy) {
                    System.out.println(februaryReport.monthCode + " " +
                            februaryReport.monthName + ": расхождения в расходах!");
                }
                if (!marSale) {
                    System.out.println(marchReport.monthCode + " " +
                            marchReport.monthName + ": расхождения в доходах!");
                }
                if (!marBuy) {
                    System.out.println(marchReport.monthCode + " " +
                            marchReport.monthName + ": расхождения в расходах!");
                }
            }
            printSeparator();
        } else {
            if (!isLoadedMonths) {
                System.out.println("Месячные отчёты ещё не загружены.");
            }
            if (!isLoadedYear) {
                System.out.println("Годовой отчёт ещё не загружен.");
            }
            printSeparator();
        }
    }

    public void printMonthsInfo() {
        if (isLoadedMonths) {
            januaryReport.printInfo();
            printSeparator();
            februaryReport.printInfo();
            printSeparator();
            marchReport.printInfo();
            printSeparator();
        } else {
            System.out.println("Месячные отчёты ещё не загружены.");
            printSeparator();
        }
    }

    public void printYearInfo() {
        if (isLoadedYear) {
            yearReport.printInfo();
            printSeparator();
        } else {
            System.out.println("Годовой отчёт ещё не загружен.");
            printSeparator();
        }
    }

    public static void printSeparator() {
        System.out.println("==============================");
        System.out.println();
    }
}
