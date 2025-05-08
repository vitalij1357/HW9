package HW;

public class CheckerTest {
    public static void main(String[] args) {
        HttpStatusChecker check = new HttpStatusChecker();
        int[] code = {200, 300, 400, 1000};
        for (int cod : code) {
            System.out.println(check.getStatusImage(cod));
        }
    }
}
