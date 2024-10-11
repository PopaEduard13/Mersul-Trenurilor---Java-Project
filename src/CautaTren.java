import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class CautaTren {
    public ArrayList<Tren> cautaTren(String gara_plecare , String gara_sosire , String tip , ArrayList<Tren> trenuri , float pretMax) {
        ArrayList<Tren> ruteGasite = new ArrayList<>();
        for (Tren tr : trenuri) {
            if (tr.getPlecare().equals(gara_plecare) && (tr.getSosire().equals(gara_sosire) || tr.getGari_parcurse().containsKey(gara_sosire)) && tr.getPret(1) < pretMax) {
                ruteGasite.add(tr);
            }
        }
        if (ruteGasite.size() == 0) {
            Tren plecareCompusa = new Tren();
            Tren sosireCompusa = new Tren();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            for (Tren tr : trenuri) {
                if (tr.getPlecare().equals(gara_plecare)) {
                    for (Tren tren : trenuri) {
                        try {
                            Date d1 = sdf.parse(tr.getOra_sosire().toString());
                            Date d2 = sdf.parse(tren.getOra_plecare().toString());
                            if (tren.getSosire().equals(gara_sosire) && tren.getPlecare().equals(tr.getSosire()) && d1.compareTo(d2) < 0) {
                                plecareCompusa = tr;
                                sosireCompusa = tren;
                                ruteGasite.add(plecareCompusa);
                                ruteGasite.add(sosireCompusa);
                            }
                        } catch (java.text.ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
        return ruteGasite;
    }
}