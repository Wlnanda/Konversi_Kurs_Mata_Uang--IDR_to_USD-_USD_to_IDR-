import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class CurrencyConverter {
    private static final BigDecimal idr_ke_usd_286 = new BigDecimal("0.000067"); // 1 IDR = 0.000067 USD

    public static BigDecimal convertIDRtoUSD(BigDecimal jumIDR) {
        return jumIDR.multiply(idr_ke_usd_286).setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal convertUSDtoIDR(BigDecimal jumUSD) {
        return jumUSD.divide(idr_ke_usd_286, 2, RoundingMode.HALF_UP);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Menggunakan "Scanner" untuk menerima input pengguna.

        System.out.println("Konversi Mata Uang");
        System.out.println("------------------");
        System.out.println("1. IDR ke USD");
        System.out.println("2. USD ke IDR");
        System.out.print("Masukkan pilihan (1 atau 2): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Masukkan Jumlah IDR: ");
            BigDecimal jumIDR = scanner.nextBigDecimal();
            BigDecimal jumUSD = convertIDRtoUSD(jumIDR);
            System.out.println(jumIDR + " IDR = " + jumUSD + " USD");
        } else if (choice == 2) {
            System.out.print("Masukkan Jumlah USD: ");
            BigDecimal jumUSD = scanner.nextBigDecimal();
            BigDecimal jumIDR = convertUSDtoIDR(jumUSD);
            System.out.println(jumUSD + " USD = " + jumIDR + " IDR");
        } else {
            System.out.println("Pilihan tidak valid, Coba lagi.");
        }

        scanner.close();
    }
}