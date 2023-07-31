package study.javalang.ch05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class PracticalTest {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        System.out.println(find2011Trans(transactions));
        System.out.println(findCities(transactions));
        System.out.println(workInCambridge(transactions));
        System.out.println(getMaxTransaction(transactions));
        System.out.println(getMinTransaction(transactions));
    }

    public static List<Transaction> find2011Trans(List<Transaction> transactions){
        return transactions.stream()
                .filter((t) -> t.getYear() == 2011)
                .toList();
    }

    public static List<String> findCities(List<Transaction> transactions){
        return transactions.stream()
                .map((t) -> t.getTrader().getCity())
                .distinct()
                .toList();
    }

    public static List<Trader> findTraders(List<Transaction> transactions){
        return transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
//                .sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
                .sorted(Comparator.comparing(Trader::getName))
                .toList();
    }

    public static boolean isTraderInMilan(List<Transaction> transactions){
        return transactions.stream()
                .map(Transaction::getTrader)
                .anyMatch(trader -> trader.getCity().equals("Milan"));
    }

    public static List<Integer> workInCambridge(List<Transaction> transactions){
        return transactions.stream()
                .filter((t) -> t.getTrader().getCity().equals("Cambridge"))
                .map((t) -> t.getValue())
                .toList();
    }

    public static int getMaxTransaction(List<Transaction> transactions){
        return transactions.stream()
                .map(Transaction::getValue)
                .reduce(0,Integer::max);
    }

    public static int getMinTransaction(List<Transaction> transactions){
        return transactions.stream()
                .map(Transaction::getValue)
                .reduce(0,Integer::min);
    }
}
