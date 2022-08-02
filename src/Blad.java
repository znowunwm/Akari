import javax.swing.*;

public class Blad {
    public Blad(Exception e) {
        JFrame blad = new JFrame("Błąd");
        ImageIcon icon = new ImageIcon("grafika/icon.png");
        blad.setIconImage(icon.getImage());
        JLabel grafika = new JLabel();
        grafika.setIcon(new ImageIcon("grafika/błąd.png"));
        blad.add(grafika);
        blad.setResizable(false);
        blad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        blad.pack();
        blad.setLocationRelativeTo(null);
        blad.setVisible(true);
        e.printStackTrace();
    }
}
