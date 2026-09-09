
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class kalkulatorKeuangan {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double uangUser = 0;
        List<Map<String,String>> intihistory = new ArrayList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");


        while (true) {
            System.out.println("KALKULATOR KEUANGAN");
            System.out.println("by Nasrul Ardhiansyah");
            System.out.println("MENU\n1. CHECK SALDO\n2. PENGELUARAN\n3. PEMASUKAN");
            System.out.println("Pilih Nomer: ");

            
            if (!scn.hasNextInt()) {
                System.out.println("masukan angka yang valid");
                scn.next();
                continue;
            }
            int masukan = scn.nextInt();
            if (masukan == 2) {
                Map<String, String> history = new HashMap<>();
                System.out.println("PENGELUARAN");
                System.out.println("Masukan nominal anda");
                System.out.println("-Rp.");
                double pengeluaran = scn.nextDouble();
                System.out.println("saldo anda berkurang sejumlah Rp."+ pengeluaran);
                uangUser -= pengeluaran;
                String waktuSekarang= LocalDateTime.now().format(dtf);
                history.put("jenis", "Pengeluaran");
                history.put("nominal", "Rp." + pengeluaran);
                history.put("waktu", waktuSekarang);
                intihistory.add(history);

                
            } if (masukan == 1) {
                System.out.println("SALDO SAYA");
                System.out.println("Rp."+uangUser);
                System.out.println("HISTORY");
                for (Map<String, String> item : intihistory) {
                    System.out.println(item.get("jenis") + ": " + item.get("nominal" ) +"  " +item.get("waktu"));
                }


            } if (masukan == 3) {
                Map<String, String> history = new HashMap<>();
                System.out.println("Pemasukan");
                double pemasukan = scn.nextDouble();
                System.out.println("Saldo anda bertambah sejumlah Rp."+ pemasukan);
                uangUser += pemasukan;
                String waktuSekarang= LocalDateTime.now().format(dtf);
                history.put("jenis", "Pemasukan");
                history.put("nominal", "Rp." + pemasukan);
                history.put("waktu", waktuSekarang);
                intihistory.add(history);

            } else {
                System.out.println("masukan angka yang sesuai di MENU");
            }

        }


    }
}