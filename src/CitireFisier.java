import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class CitireFisier {
    public ArrayList<Tren> citireFisier(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        Tren tr = new Tren();
        ArrayList<Tren> rute = new ArrayList<Tren>();
        int count = 1;
        String val = "";
        while (sc.hasNextLine()) {
            String linie = sc.nextLine();
            for (int i = 0; i < linie.length(); ++i) {
                if (linie.charAt(i) != ' ') {
                    val = val + linie.charAt(i);
                } else {
                    if (count == 1) {
                        tr.numar = val;
                        ++count;
                        val = "";
                    }
                    else if (count == 2) {
                        tr.setTipTren(val);
                        ++count;
                        val = "";
                    } else if (count == 3) {
                        tr.setPretClasaI(Float.parseFloat(val));
                        ++count;
                        val = "";
                    } else if (count == 4) {
                        tr.setPretClasaII(Float.parseFloat(val));
                        ++count;
                        val = "";
                    } else if (count == 5) {
                        tr.setPlecare(val);
                        ++count;
                        val = "";
                    } else if (count == 6) {
                        tr.setSosire(val);
                        ++count;
                        val = "";
                    } else if (count == 7) {
                        tr.setOra_plecare(val);
                        ++count;
                        val = "";
                    } else if (count == 8) {
                        tr.setOra_sosire(val);
                        ++count;
                        val = "";
                    } else if (count == 9) {
                        String gara = val;
                        val = "";
                        ++i;
                        while (linie.charAt(i) != ' ' && i < linie.length()) {
                            val = val + linie.charAt(i);
                            ++i;
                            if (i == linie.length())
                                break;
                        }
                        tr.adaugaGariParcurse(gara, val);
                        val = "";
                        if (i == linie.length())
                        {
                            rute.add(tr);
                            tr = new Tren();
                            count = 1;
                            val = "";
                        }
                    }
                }
            }
        }
        return rute;
    }
}