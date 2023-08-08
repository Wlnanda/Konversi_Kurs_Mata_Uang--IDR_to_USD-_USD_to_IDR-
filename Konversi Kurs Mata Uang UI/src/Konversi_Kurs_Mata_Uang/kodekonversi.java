import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class kodekonversi {
    private static final BigDecimal idr_ke_usd_286 = new BigDecimal("0.000067"); // 1 IDR = 0.000067 USD

    public static BigDecimal convertIDRtoUSD(BigDecimal jumIDR) {
        return jumIDR.multiply(idr_ke_usd_286).setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal convertUSDtoIDR(BigDecimal jumUSD) {
        return jumUSD.divide(idr_ke_usd_286, 2, RoundingMode.HALF_UP);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueConversion = true;

        while (continueConversion) {
            // Menu
            System.out.println("Konversi Mata Uang");
            System.out.println("------------------");
            System.out.println("1. IDR ke USD");
            System.out.println("2. USD ke IDR");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan (1, 2, atau 3): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan Jumlah IDR: ");
                    BigDecimal jumIDR = scanner.nextBigDecimal();
                    BigDecimal jumUSD = convertIDRtoUSD(jumIDR);
                    System.out.println(jumIDR + " IDR = " + jumUSD + " USD");
                    break;

                case 2:
                    System.out.print("Masukkan Jumlah USD: ");
                    BigDecimal jumUSD2 = scanner.nextBigDecimal();
                    BigDecimal jumIDR2 = convertUSDtoIDR(jumUSD2);
                    System.out.println(jumUSD2 + " USD = " + jumIDR2 + " IDR");
                    break;

                case 3:
                    System.out.println("Goodbye!...");
                    continueConversion = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid, Coba lagi.");
                    break;
            }

            if (continueConversion) {
                System.out.print("Apakah Anda ingin melakukan konversi lainnya? (Y/N): ");
                String answer = scanner.next();
                if (!answer.equalsIgnoreCase("Y")) {
                    continueConversion = false;
                }
            }
        }
        scanner.close();
    }
}