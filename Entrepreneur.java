import java.util.Scanner;

public class Entrepreneur {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int earnings = 0;
        int spendings = 0;

        boolean isContinue = true;

        while (isContinue) {
            showMenu();
            String operation = sc.nextLine();
            switch (operation) {
                case "end":
                    isContinue = false;
                    break;
                case "1":
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = sc.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case "2":
                    System.out.println("Введите сумму расхода:");
                    moneyStr = sc.nextLine();
                    money = Integer.parseInt(moneyStr);
                    spendings += money;
                    break;
                case "3":
                    calcResult(earnings, spendings);
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
        System.out.println("Программа завершена!");
    }

    public static void calcResult(int earnings, int spendings) {
        int tax6 = calcTax6(earnings);
        int tax15 = calcTax15(spendings);

        String taxType = tax6 < tax15 ? "УСН Доходы" : "УСН доходы минус расходы";
        int minTax = Math.min(tax6, tax15);
        int maxTax = Math.max(tax6, tax15);

        if (minTax != maxTax) {
            System.out.printf("Мы советуем Вам %s\n", taxType);
            System.out.printf("Ваш налог составит %d\n", minTax);
            System.out.printf("Налог по другой сиистеме будет %d\n", maxTax);
            System.out.printf("Экономия %d рублей\n", maxTax - minTax);
        } else {
            System.out.println("Выбирайте любую систему");
            System.out.printf("Ваш налог составит: %d\n", minTax);
        }
    }

    public static int calcTax15(int earnings) {
        int tax = (earnings - earnings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int calcTax6(int earnings) {
        int fix = earnings * 6 / 100;
        if (fix >= 0) {
            return fix;
        } else {
            return 0;
        }
    }

    public static void showMenu() {
        System.out.println("Выберите операцию и введите её номер:\n" +
                "1 Добавить новый доход;\n" +
                "2 Добавить новый расход:\n" +
                "3 Выбирите систему налогооблажения\n");
    }
}