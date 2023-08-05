public class RentCount {
    public static void main(String[] args) {

        double rentPerMonth = 1300d;
        double totalRent = 0d;
        int n = 15;
        double raiseRate = 1.03d;

        System.out.println("初始月房租：" + rentPerMonth);


        for (int i = 0; i < n; i++) {
            double monthlyRent = rentPerMonth * (Math.pow(raiseRate, i));
            System.out.println("第" + (i + 1) + "年的房租为：" + monthlyRent);
            totalRent += monthlyRent * 12;
        }

        System.out.println(n + "年的总房租为：" + totalRent);
        System.out.println(n + "年固定租金房租为：" + rentPerMonth * 12 * n);
        System.out.println(n + "年相差：" + (totalRent - rentPerMonth * 12 * n));

        double money = 340000d;
        double newMoney = money;
        int total = 3;
        for (int i = 0; i < total; i++) {
            newMoney = newMoney + newMoney * 0.035 * 5;
            System.out.println("第" + (i + 1) + "期后本金为:" + newMoney);
        }
        System.out.println("第" + total + "期后收益为：" + (newMoney - money));
    }
}
