public class CashflowManager {
    String januaryReportFilepath = "m.202101.csv";
    String februaryReportFilepath = "m.202102.csv";
    String marchReportFilepath = "m.202103.csv";
    String yearReportFilepath = "y.2021.csv";
    boolean isLoadedMonths = false;
    boolean isLoadedYear = false;
    String separator = "==============================\n";

    MonthlyReport januaryReport;
    MonthlyReport februaryReport;
    MonthlyReport marchReport;
    YearlyReport yearReport;

    public void loadMonthsReports() {
        januaryReport = new MonthlyReport(januaryReportFilepath);
        System.out.println("\nЗагружен месяц: " + januaryReport.monthName);
        februaryReport = new MonthlyReport(februaryReportFilepath);
        System.out.println("Загружен месяц: " + februaryReport.monthName);
        marchReport = new MonthlyReport(marchReportFilepath);
        System.out.println("Загружен месяц: " + marchReport.monthName);
        isLoadedMonths = true;
        System.out.println(separator);
    }

    public void loadYearReport() {
        yearReport = new YearlyReport(yearReportFilepath);
        System.out.println("\nЗагружен год: " + yearReport.yearName);
        isLoadedYear = true;
        System.out.println(separator);
    }

    public void checkReports() {
        if (isLoadedMonths && isLoadedYear) {
            // сверка

            boolean janSale = (januaryReport.getSaleSum() == yearReport.getSaleSum("01"));
            boolean janBuy = (januaryReport.getBuySum() == yearReport.getBuySum("01"));
            boolean febSale = (februaryReport.getSaleSum() == yearReport.getSaleSum("02"));
            boolean febBuy = (februaryReport.getBuySum() == yearReport.getBuySum("02"));
            boolean marSale = (marchReport.getSaleSum() == yearReport.getSaleSum("03"));
            boolean marBuy = (marchReport.getBuySum() == yearReport.getBuySum("03"));

            boolean isCorrectCheck = janSale && janBuy && febSale && febBuy && marSale && marBuy;

            System.out.println("\nВыполняется сверка отчётов...");
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
            System.out.println(separator);
        } else {
            System.out.println();
            if (!isLoadedMonths) {
                System.out.println("Месячные отчёты ещё не загружены.");
            }
            if (!isLoadedYear) {
                System.out.println("Годовой отчёт ещё не загружен.");
            }
            System.out.println(separator);
        }
    }

    public void printMonthsInfo() {
        if (isLoadedMonths) {
            System.out.println();
            januaryReport.printInfo();
            System.out.println(separator);
            februaryReport.printInfo();
            System.out.println(separator);
            marchReport.printInfo();
            System.out.println(separator);
        } else {
            System.out.println("\nМесячные отчёты ещё не загружены.");
            System.out.println(separator);
        }
    }

    public void printYearInfo() {
        if (isLoadedYear) {
            yearReport.printInfo();
        } else {
            System.out.println("\nГодовой отчёт ещё не загружен.");
        }
        System.out.println(separator);
    }
}