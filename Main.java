import java.util.ArrayList;
import java.util.Scanner;

class Mahasiswa {
    String nama;
    int nilai;

    Mahasiswa(String inputNama, int inputNilai) {
        nama = inputNama;
        nilai = inputNilai;
    }

    String getGrade() {
        if (nilai >= 85 && nilai <= 100) {
            return "A";
        } else if (nilai >= 70) {
            return "B";
        } else if (nilai >= 55) {
            return "C";
        } else if (nilai >= 40) {
            return "D";
        } else {
            return "E";
        }
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Nilai: " + nilai + ", Grade: " + getGrade();
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Mahasiswa> mahasiswaList = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\nData Nilai Mata Kuliah Perpajakan \nMenu :");
            System.out.println("1. Tambah data mahasiswa");
            System.out.println("2. Update data mahasiswa");
            System.out.println("3. Delete data mahasiswa");
            System.out.println("4. Lihat semua data mahasiswa");
            System.out.println("5. Cari data mahasiswa berdasarkan nama");
            System.out.println("6. Keluar dari program");
            System.out.print("Pilih: ");
            int pilih = input.nextInt();
            input.nextLine(); // Konsumsi newline

            if (pilih == 1) {
                System.out.print("Nama: ");
                String nama = input.nextLine();
                System.out.print("Nilai: ");
                int nilai = input.nextInt();

                mahasiswaList.add(new Mahasiswa(nama, nilai));
                System.out.println("Data mahasiswa berhasil ditambahkan!");

            } else if (pilih == 2) {
                System.out.print("Nama : ");
                String nama = input.nextLine();
                Mahasiswa mahasiswa = cariMahasiswaBerdasarkanNama(mahasiswaList, nama);
                if (mahasiswa != null) {
                    System.out.print("Nilai baru: ");
                    int nilai = input.nextInt();
                    mahasiswa.nilai = nilai;
                    System.out.println("Data mahasiswa berhasil diupdate!");
                } else {
                    System.out.println("Mahasiswa dengan nama " + nama + " tidak ditemukan.");
                }
            } else if (pilih == 3) {
                System.out.print("Masukkan nama mahasiswa yang akan dihapus: ");
                String nama = input.nextLine();
                Mahasiswa mahasiswa = cariMahasiswaBerdasarkanNama(mahasiswaList, nama);
                if (mahasiswa != null) {
                    mahasiswaList.remove(mahasiswa);
                    System.out.println("Data mahasiswa berhasil dihapus!");
                } else {
                    System.out.println("Mahasiswa dengan nama " + nama + " tidak ditemukan.");
                }
            } else if (pilih == 4) {
                if (mahasiswaList.isEmpty()) {
                    System.out.println("Tidak ada data mahasiswa.");
                } else {
                    for (Mahasiswa mhs : mahasiswaList) {
                        System.out.println(mhs);
                    }
                }
            } else if (pilih == 5) {
                System.out.print("Masukkan nama mahasiswa yang dicari: ");
                String nama = input.nextLine();
                Mahasiswa mahasiswa = cariMahasiswaBerdasarkanNama(mahasiswaList, nama);
                if (mahasiswa != null) {
                    System.out.println(mahasiswa);
                } else {
                    System.out.println("Mahasiswa dengan nama " + nama + " tidak ditemukan.");
                }
            } else if (pilih == 6) {
                System.out.println("Keluar dari program.");
                System.exit(0);
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private static Mahasiswa cariMahasiswaBerdasarkanNama(ArrayList<Mahasiswa> mahasiswaList, String nama) {
        for (Mahasiswa mhs : mahasiswaList) {
            if (mhs.nama.equalsIgnoreCase(nama)) {
                return mhs;
            }
        }
        return null;
    }
}
