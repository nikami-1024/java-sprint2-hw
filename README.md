# java-sprint2-hw
Second sprint homework

## Cashflow Manager v1.0

Приложение, которое упростит работу бухгалтерии и снизит число ошибок в расчётах.

Версия 1.0: приложение рассчитано на работу с тремя месячными отчётами и частичным годовым отчётом.

### Функционал программы:

- Консольный интерфейс для управления программой.
- Считывание месячных и годового отчётов бухгалтерии из файлов формата CSV.
- Сверка данных по месячным и годовому отчётам.
- Вывод информации о месячных и годовом отчётах.

### Входные файлы данных:

Файлы расположены в папке *resources/*.

Имена файлов для считывания программой настраиваются в файле *CashflowManager.java*.

#### Месячный отчёт

Имя файла в формате *m.YYYYMM.csv*.

Месячный отчёт за январь 2021 года: *m.202101.csv*.

*is_expense* - признак траты (TRUE) или дохода (FALSE).

*unit_price* - стоимость одной единицы товара. Целое число.


| item_name            | is_expense | quantity | unit_price |
|----------------------|------------|----------|------------|
| Автоматы с мороженым | TRUE       | 12       | 15000      |
| Продажа мороженого   | FALSE      | 1000     | 120        |

```csv
item_name,is_expense,quantity,unit_price
Автоматы с мороженым,TRUE,12,15000
Продажа мороженого,FALSE,1000,120
```

#### Годовой отчёт

Имя файла в формате *y.YYYY.csv*.

Годовой отчёт за 2021 год: *y.2021.csv*.

*is_expense* - признак траты (TRUE) или дохода (FALSE).

| month | amount | is_expense |
|-------|--------|------------|
| 01    | 100000 | false      |
| 01    | 30000  | true       |
| 02    | 321690 | false      |
| 02    | 130000 | true       |


```csv
month,amount,is_expense
01,100000,false
01,30000,true
02,321690,false
02,130000,true
```

