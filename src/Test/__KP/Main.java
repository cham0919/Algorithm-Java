package Test.__KP;

public class Main {

    public static void main(String[] args) {
        int originmoney = 12_345_678;
        int money = 12_345_600;
        double ratio = 19;
        System.out.println((ratio/100));
        System.out.println(money * (ratio/100));
        System.out.println(money * ((100 - ratio)/100));
        System.out.println(originmoney -  (money * (ratio/100)));
    }
}
