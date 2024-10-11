import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.List;
import java.util.*;
import java.io.File;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/eduard/Developer/projects/Mersul Trenurilor Java/Mersul Trenurilor OOP/src/RuteTrenuri");
        CitireFisier cf = new CitireFisier();
        CautaTren ct = new CautaTren();
        ArrayList<Tren> trenuri = new ArrayList<>();
        trenuri = cf.citireFisier(file);

        JFrame frame =  new JFrame("Mersul Trenurilor");
        JLabel image;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(1050 , 1500);
        File f= new File("/Users/eduard/Developer/projects/Mersul Trenurilor Java/Mersul Trenurilor OOP/src/Locatii.txt");
        String[] s = new String[7];
        try {
            BufferedReader br = new BufferedReader( new FileReader(f));
            String l;
            int i = 0;
            while ((l = br.readLine())!= null) {
                s[i] = l;
                i++;
            }
        }catch (IOException exception) {
            exception.printStackTrace();
        }

        JComboBox c1= new JComboBox(s);
        c1.setSelectedItem(null);
        c1.setBounds(100,100,30,5);
        JComboBox c2= new JComboBox(s);
        c2.setSelectedItem(null);
        c2.setBounds(100,100,30,5);
        File ff= new File("/Users/eduard/Developer/projects/Mersul Trenurilor Java/Mersul Trenurilor OOP/src/clase.txt");
        String[] c = new String[2];
        try {
            BufferedReader br = new BufferedReader( new FileReader(ff));
            String l;
            int i = 0;
            while ((l = br.readLine())!= null) {
                c[i] = l;
                i++;
            }
        }catch (IOException exception) {
            exception.printStackTrace();
        }
        JComboBox c3 = new JComboBox(c);
        c3.setSelectedItem(null);
        c3.setBounds(100,100,5,2);
        File f5= new File("/Users/eduard/Developer/projects/Mersul Trenurilor Java/Mersul Trenurilor OOP/src/tip.txt");
        String[] bb = new String[4];
        try {
            BufferedReader br = new BufferedReader( new FileReader(f5));
            String l;
            int i = 0;
            while ((l = br.readLine())!= null) {
                bb[i] = l;
                i++;
            }
        }catch (IOException exception) {
            exception.printStackTrace();
        }
        JComboBox c5 = new JComboBox(bb);
        c5.setSelectedItem(null);
        File f4= new File("/Users/eduard/Developer/projects/Mersul Trenurilor Java/Mersul Trenurilor OOP/src/om.txt");
        String[] cc = new String[4];
        try {
            BufferedReader br = new BufferedReader( new FileReader(f4));
            String l;
            int i = 0;
            while ((l = br.readLine())!= null) {
                cc[i] = l;
                i++;
            }
        }catch (IOException exception) {
            exception.printStackTrace();
        }
        c5.setBounds(100,100,3,2);

        JComboBox c4 = new JComboBox(cc);
        c4.setSelectedItem(null);
        c4.setBounds(100,100,5,2);
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(20 , 1));
        panel.setBackground(Color.white);
        ImageIcon logo;
        try {
            logo = new ImageIcon(Main.class.getResource("logoCFR.jpeg"));
            Image img = logo.getImage();
            Image newimg = img.getScaledInstance(100 , 100 , Image.SCALE_SMOOTH);
            logo = new ImageIcon(newimg);
            image = new JLabel(logo);
            panel.add(image);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        JLabel l1 = new JLabel("Plecare :");
        l1.setBounds(4, 5, 150, 222);
        l1.setFont(new Font("ARIAL",Font.BOLD,20));
        JTextField tf1 = new JTextField(30);
        JLabel l2 = new JLabel("Sosire :");
        l2.setFont(new Font("ARIAL",Font.BOLD,20));
        JLabel l4 = new JLabel("Clasa :");
        l4.setFont(new Font("ARIAL",Font.BOLD,20));
        JLabel l5 = new JLabel("Tipul de tren :");
        l5.setFont(new Font("ARIAL",Font.BOLD,20));
        JLabel l6 = new JLabel("Pentru :");
        l6.setFont(new Font("ARIAL",Font.BOLD,20));
        JLabel l7 = new JLabel("Pret maxim bilet: ");
        l7.setFont(new Font("ARIAL",Font.BOLD,20));
        JTextField tf7 = new JTextField(30);

        JButton button = new JButton("Cautati");

        ArrayList<Tren> ruteTrenuri = trenuri;
        button.addActionListener(new ActionListener() {
            JFrame f;

            @Override
            public void actionPerformed(ActionEvent e) {
                //  if(e.getSource())
                String gara_plecare = c1.getSelectedItem().toString();
                String gara_sosire = c2.getSelectedItem().toString();
                int clasa = Integer.parseInt(c3.getSelectedItem().toString());
                String tip_tren = c5.getSelectedItem().toString();
                String persoana = c4.getSelectedItem().toString();
                float pretMax = Float.parseFloat(tf7.getText());
                List<Tren> ruteGasite = new ArrayList<>();
                ruteGasite = ct.cautaTren(gara_plecare, gara_sosire, tip_tren, ruteTrenuri , pretMax);
                for (Tren tr : ruteGasite) {
                    float pret = tr.getPret(clasa);
                    if (persoana.equals("Student") || persoana.equals("Pensionar")) {
                        pret /= 2;
                    } else if (persoana.equals("Soldat")) {
                        pret = 0;
                    }
                }
                f = new Frame2(ruteGasite , gara_plecare , gara_sosire , clasa , persoana);
            }
        });

        panel.add(l1);
        panel.add(c1);
        panel.add(l2);
        panel.add(c2);
        panel.add(l4);
        panel.add(c3);
        panel.add(l5);
        panel.add(c5);
        panel.add(l6);
        panel.add(c4);
        panel.add(l7);
        panel.add(tf7);
        panel.add(button);
        panel.repaint();
        frame.add(panel);
        frame.revalidate();
        frame.repaint();
    }
}