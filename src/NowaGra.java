import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Scanner;

public class NowaGra {

    public static int[][] mechanika = new int[Akari.rozmiar][Akari.rozmiar];


    public NowaGra(Grafika panel, JLabel powrot) {

        panel.removeAll();
        panel.add(powrot);

        for (int i = 0; i < Akari.rozmiar; i++)
            Arrays.fill(mechanika[i], 6);

        JLabel tytul = new JLabel();
        tytul.setIcon(new ImageIcon("grafika/napis_akari.png"));
        tytul.setBounds(0, 0, 800, 800);

        JLabel rozmiar = new JLabel();
        rozmiar.setIcon(new ImageIcon("grafika/rozmiar.png"));
        rozmiar.setBounds(0, 0, 800, 800);

        JLabel stworz = new JLabel();
        stworz.setIcon(new ImageIcon("grafika/stwórzGrę.png"));
        stworz.setBounds(100, 435, 600, 100);

        JLabel wczytaj = new JLabel();
        wczytaj.setIcon(new ImageIcon("grafika/wczytajZPliku.png"));
        wczytaj.setBounds(100, 565, 600, 100);

        JLabel pasek = new JLabel();
        pasek.setIcon(new ImageIcon("grafika/pasekRozmiar.png"));
        pasek.setBounds(100, 325, 600, 50);

        JLabel minus = new JLabel();
        minus.setIcon(new ImageIcon("grafika/minus.png"));
        minus.setBounds(25, 325, 50, 50);

        JLabel plus = new JLabel();
        plus.setIcon(new ImageIcon("grafika/plus.png"));
        plus.setBounds(725, 325, 50, 50);

        JLabel suwak = new JLabel();
        suwak.setIcon(new ImageIcon("grafika/suwak.png"));
        switch (Akari.rozmiar) {
            case 4:
                suwak.setBounds(105, 315, 10, 70);
                break;
            case 5:
                suwak.setBounds(170, 315, 10, 70);
                break;
            case 6:
                suwak.setBounds(245, 315, 10, 70);
                break;
            case 7:
                suwak.setBounds(320, 315, 10, 70);
                break;
            case 8:
                suwak.setBounds(395, 315, 10, 70);
                break;
            case 9:
                suwak.setBounds(470, 315, 10, 70);
                break;
            case 10:
                suwak.setBounds(545, 315, 10, 70);
                break;
            case 11:
                suwak.setBounds(620, 315, 10, 70);
                break;
            case 12:
                suwak.setBounds(680, 315, 10, 70);
                break;
            default:
                break;
        }

        JLabel powrot1 = new JLabel();
        powrot1.setIcon(new ImageIcon("grafika/powrot.png"));
        powrot1.setBounds(680, 725, 100, 50);


        stworz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                stworz.setIcon(new ImageIcon("grafika/stwórzGrę_najazd.png"));
            }
        });
        stworz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                stworz.setIcon(new ImageIcon("grafika/stwórzGrę.png"));
            }
        });
        stworz.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                stworz.setIcon(new ImageIcon("grafika/stwórzGrę_klik.png"));
            }
        });
        stworz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                stworz.setIcon(new ImageIcon("grafika/stwórzGrę.png"));
            }
        });
        stworz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    new Generator(panel, powrot1);
                }

            }
        });

        wczytaj.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                wczytaj.setIcon(new ImageIcon("grafika/wczytajZPliku_najazd.png"));
            }
        });
        wczytaj.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                wczytaj.setIcon(new ImageIcon("grafika/wczytajZPliku.png"));
            }
        });
        wczytaj.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                wczytaj.setIcon(new ImageIcon("grafika/wczytajZPliku_klik.png"));
            }
        });
        wczytaj.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                wczytaj.setIcon(new ImageIcon("grafika/wczytajZPliku.png"));
            }
        });
        wczytaj.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                    fileChooser.setDialogTitle("Wczytaj planszę");
                    int result = fileChooser.showOpenDialog(panel);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        try {
                            File selectedFile = fileChooser.getSelectedFile();
                            Scanner scanner = new Scanner(selectedFile);
                            Akari.rozmiar = Integer.parseInt(scanner.next());
                            if (Akari.rozmiar < 4 || Akari.rozmiar > 12) throw new EmptyStackException();
                            mechanika = new int[Akari.rozmiar][Akari.rozmiar];
                            for (int i = 0; i < Akari.rozmiar; i++) {
                                for (int j = 0; j < Akari.rozmiar; j++) {
                                    mechanika[i][j] = Integer.parseInt(scanner.next());
                                    if (mechanika[i][j] < 0 || mechanika[i][j] > 10)
                                        throw new EmptyStackException();
                                }
                            }
                            scanner.close();
                            new Plansza(panel);
                        } catch (Exception err) {
                            JOptionPane optionPane = new JOptionPane("Wybrany plik jest nieprawidłowy", JOptionPane.ERROR_MESSAGE);
                            JDialog dialog = optionPane.createDialog("Błąd!");
                            dialog.setAlwaysOnTop(true);
                            dialog.setVisible(true);
                            //err.printStackTrace();
                        }

                    }
                }

            }
        });

        plus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (Akari.rozmiar < 12) Akari.rozmiar++;
                    switch (Akari.rozmiar) {
                        case 4:
                            suwak.setBounds(105, 315, 10, 70);
                            break;
                        case 5:
                            suwak.setBounds(170, 315, 10, 70);
                            break;
                        case 6:
                            suwak.setBounds(245, 315, 10, 70);
                            break;
                        case 7:
                            suwak.setBounds(320, 315, 10, 70);
                            break;
                        case 8:
                            suwak.setBounds(395, 315, 10, 70);
                            break;
                        case 9:
                            suwak.setBounds(470, 315, 10, 70);
                            break;
                        case 10:
                            suwak.setBounds(545, 315, 10, 70);
                            break;
                        case 11:
                            suwak.setBounds(620, 315, 10, 70);
                            break;
                        case 12:
                            suwak.setBounds(680, 315, 10, 70);
                            break;
                        default:
                            break;
                    }
                    mechanika = new int[Akari.rozmiar][Akari.rozmiar];
                    for (int i = 0; i < Akari.rozmiar; i++)
                        Arrays.fill(mechanika[i], 6);
                }


            }
        });
        minus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (Akari.rozmiar > 4) Akari.rozmiar--;
                    switch (Akari.rozmiar) {
                        case 4:
                            suwak.setBounds(105, 315, 10, 70);
                            break;
                        case 5:
                            suwak.setBounds(170, 315, 10, 70);
                            break;
                        case 6:
                            suwak.setBounds(245, 315, 10, 70);
                            break;
                        case 7:
                            suwak.setBounds(320, 315, 10, 70);
                            break;
                        case 8:
                            suwak.setBounds(395, 315, 10, 70);
                            break;
                        case 9:
                            suwak.setBounds(470, 315, 10, 70);
                            break;
                        case 10:
                            suwak.setBounds(545, 315, 10, 70);
                            break;
                        case 11:
                            suwak.setBounds(620, 315, 10, 70);
                            break;
                        case 12:
                            suwak.setBounds(680, 315, 10, 70);
                            break;
                        default:
                            break;
                    }
                    mechanika = new int[Akari.rozmiar][Akari.rozmiar];
                    for (int i = 0; i < Akari.rozmiar; i++)
                        Arrays.fill(mechanika[i], 6);
                }

            }
        });

        powrot1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    panel.removeAll();
                    panel.add(suwak);
                    panel.add(plus);
                    panel.add(minus);
                    panel.add(pasek);
                    panel.add(wczytaj);
                    panel.add(tytul);
                    panel.add(stworz);
                    panel.add(rozmiar);
                    panel.add(powrot);
                    panel.revalidate();
                    panel.repaint();
                }

            }
        });

        powrot1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                powrot1.setIcon(new ImageIcon("grafika/powrót_klik.png"));
            }
        });


        powrot1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                powrot1.setIcon(new ImageIcon("grafika/powrot.png"));
            }
        });

        powrot1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                powrot1.setIcon(new ImageIcon("grafika/powrót_najazd.png"));
            }
        });

        powrot1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                powrot1.setIcon(new ImageIcon("grafika/powrot.png"));
            }
        });


        panel.add(suwak);
        panel.add(tytul);
        panel.add(plus);
        panel.add(minus);
        panel.add(pasek);
        panel.add(wczytaj);
        panel.add(stworz);
        panel.add(rozmiar);
        panel.revalidate();
        panel.repaint();

    }
}
