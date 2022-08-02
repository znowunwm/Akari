import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;


public class Generator {

    private JLabel[][] plansza = new JLabel[Akari.rozmiar][Akari.rozmiar];
    private int wybor = -1;
    private final int x = 20;
    private final int y = 85;
    private String pole;
    private int rozmiarKafelka = 0;


    private void PustaPlansza(int x, int y, int rozmiarKafelka, String pole, Grafika panel) {
        try {
            plansza = new JLabel[Akari.rozmiar][Akari.rozmiar];
            for (int i = 0; i < Akari.rozmiar; i++) {
                for (int j = 0; j < Akari.rozmiar; j++) {
                    plansza[i][j] = new JLabel();
                    plansza[i][j].setIcon(new ImageIcon(pole));
                    plansza[i][j].setBounds(x, y, rozmiarKafelka, rozmiarKafelka);
                    x += rozmiarKafelka;
                    panel.add(plansza[i][j]);
                }
                x = 20;
                y += rozmiarKafelka;
            }

            for (int i = 0; i < Akari.rozmiar; i++) {
                for (int j = 0; j < Akari.rozmiar; j++) {
                    int a = i;
                    int b = j;
                    plansza[i][j].addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            super.mouseClicked(e);
                            String wstawiane;
                            switch (wybor) {
                                case -1:
                                    wstawiane = "grafika/" + Akari.rozmiar + "polePuste.png";
                                    plansza[a][b].setIcon(new ImageIcon(wstawiane));
                                    NowaGra.mechanika[a][b] = 6;
                                    break;
                                case 0:
                                    wstawiane = "grafika/" + Akari.rozmiar + "polePelne.png";
                                    plansza[a][b].setIcon(new ImageIcon(wstawiane));
                                    NowaGra.mechanika[a][b] = 5;
                                    break;
                                case 1:
                                    wstawiane = "grafika/" + Akari.rozmiar + "polePelne0.png";
                                    plansza[a][b].setIcon(new ImageIcon(wstawiane));
                                    NowaGra.mechanika[a][b] = 0;
                                    break;
                                case 2:
                                    wstawiane = "grafika/" + Akari.rozmiar + "polePelne1.png";
                                    plansza[a][b].setIcon(new ImageIcon(wstawiane));
                                    NowaGra.mechanika[a][b] = 1;
                                    break;
                                case 3:
                                    wstawiane = "grafika/" + Akari.rozmiar + "polePelne2.png";
                                    plansza[a][b].setIcon(new ImageIcon(wstawiane));
                                    NowaGra.mechanika[a][b] = 2;
                                    break;
                                case 4:
                                    wstawiane = "grafika/" + Akari.rozmiar + "polePelne3.png";
                                    plansza[a][b].setIcon(new ImageIcon(wstawiane));
                                    NowaGra.mechanika[a][b] = 3;
                                    break;
                                case 5:
                                    wstawiane = "grafika/" + Akari.rozmiar + "polePelne4.png";
                                    plansza[a][b].setIcon(new ImageIcon(wstawiane));
                                    NowaGra.mechanika[a][b] = 4;
                                    break;
                                default:
                                    break;
                            }
                        }
                    });
                }
            }
        } catch (Exception e) {
            new Blad(e);
            return;
        }
    }

    private void PlanszaReprint(int x, int y, int rozmiarKafelka, JPanel panel) {
        try {
            int bufx = x;
            String pole = "";
            plansza = new JLabel[Akari.rozmiar][Akari.rozmiar];
            for (int i = 0; i < Akari.rozmiar; i++) {
                for (int j = 0; j < Akari.rozmiar; j++) {
                    plansza[i][j] = new JLabel();
                    switch (NowaGra.mechanika[i][j]) {
                        case 0:
                            pole = "grafika/" + Akari.rozmiar + "polePelne0.png";
                            break;
                        case 1:
                            pole = "grafika/" + Akari.rozmiar + "polePelne1.png";
                            break;
                        case 2:
                            pole = "grafika/" + Akari.rozmiar + "polePelne2.png";
                            break;
                        case 3:
                            pole = "grafika/" + Akari.rozmiar + "polePelne3.png";
                            break;
                        case 4:
                            pole = "grafika/" + Akari.rozmiar + "polePelne4.png";
                            break;
                        case 5:
                            pole = "grafika/" + Akari.rozmiar + "polePelne.png";
                            break;
                        case 6:
                            pole = "grafika/" + Akari.rozmiar + "polePuste.png";
                            break;

                        default:
                            break;
                    }
                    plansza[i][j].setIcon(new ImageIcon(pole));
                    plansza[i][j].setBounds(bufx, y, rozmiarKafelka, rozmiarKafelka);
                    bufx += rozmiarKafelka;
                    panel.add(plansza[i][j]);
                }
                bufx = x;
                y += rozmiarKafelka;
            }

            for (int i = 0; i < Akari.rozmiar; i++) {
                for (int j = 0; j < Akari.rozmiar; j++) {
                    int a = i;
                    int b = j;
                    plansza[i][j].addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            super.mouseClicked(e);
                            if (e.getButton() == MouseEvent.BUTTON1) {
                                String wstawiane;
                                switch (wybor) {
                                    case -1:
                                        wstawiane = "grafika/" + Akari.rozmiar + "polePuste.png";
                                        plansza[a][b].setIcon(new ImageIcon(wstawiane));
                                        NowaGra.mechanika[a][b] = 6;
                                        break;
                                    case 0:
                                        wstawiane = "grafika/" + Akari.rozmiar + "polePelne.png";
                                        plansza[a][b].setIcon(new ImageIcon(wstawiane));
                                        NowaGra.mechanika[a][b] = 5;
                                        break;
                                    case 1:
                                        wstawiane = "grafika/" + Akari.rozmiar + "polePelne0.png";
                                        plansza[a][b].setIcon(new ImageIcon(wstawiane));
                                        NowaGra.mechanika[a][b] = 0;
                                        break;
                                    case 2:
                                        wstawiane = "grafika/" + Akari.rozmiar + "polePelne1.png";
                                        plansza[a][b].setIcon(new ImageIcon(wstawiane));
                                        NowaGra.mechanika[a][b] = 1;
                                        break;
                                    case 3:
                                        wstawiane = "grafika/" + Akari.rozmiar + "polePelne2.png";
                                        plansza[a][b].setIcon(new ImageIcon(wstawiane));
                                        NowaGra.mechanika[a][b] = 2;
                                        break;
                                    case 4:
                                        wstawiane = "grafika/" + Akari.rozmiar + "polePelne3.png";
                                        plansza[a][b].setIcon(new ImageIcon(wstawiane));
                                        NowaGra.mechanika[a][b] = 3;
                                        break;
                                    case 5:
                                        wstawiane = "grafika/" + Akari.rozmiar + "polePelne4.png";
                                        plansza[a][b].setIcon(new ImageIcon(wstawiane));
                                        NowaGra.mechanika[a][b] = 4;
                                        break;
                                    default:
                                        break;
                                }
                            }

                        }
                    });
                }
            }
        } catch (Exception e) {
            new Blad(e);
            return;
        }

    }


    public Generator(Grafika panel, JLabel powrot1) {


        this.pole = "grafika/" + Akari.rozmiar + "polePuste.png";
        switch (Akari.rozmiar) {
            case 4:
                rozmiarKafelka = 150;
                break;
            case 5:
                rozmiarKafelka = 120;
                break;
            case 6:
                rozmiarKafelka = 100;
                break;
            case 7:
                rozmiarKafelka = 86;
                break;
            case 8:
                rozmiarKafelka = 75;
                break;
            case 9:
                rozmiarKafelka = 67;
                break;
            case 10:
                rozmiarKafelka = 60;
                break;
            case 11:
                rozmiarKafelka = 55;
                break;
            case 12:
                rozmiarKafelka = 50;
                break;
            default:
                break;
        }
        panel.removeAll();

        JLabel twojaGra = new JLabel();
        twojaGra.setIcon(new ImageIcon("grafika/TwojaGra.png"));
        twojaGra.setBounds(0, 0, 800, 800);

        JLabel graj = new JLabel();
        graj.setIcon(new ImageIcon("grafika/graj.png"));
        graj.setBounds(630, 85, 150, 100);

        JLabel zapisz = new JLabel();
        zapisz.setIcon(new ImageIcon("grafika/zapisz.png"));
        zapisz.setBounds(630, 267, 150, 100);

        JLabel wyczysc = new JLabel();
        wyczysc.setIcon(new ImageIcon("grafika/wyczyść.png"));
        wyczysc.setBounds(630, 585, 150, 100);

        JLabel biale = new JLabel();
        biale.setIcon(new ImageIcon("grafika/polePuste_zaznaczone.png"));
        biale.setBounds(50, 705, 75, 75);

        JLabel czarne = new JLabel();
        czarne.setIcon(new ImageIcon("grafika/8polePelne.png"));
        czarne.setBounds(135, 705, 75, 75);

        JLabel pole0 = new JLabel();
        pole0.setIcon(new ImageIcon("grafika/8polePelne0.png"));
        pole0.setBounds(220, 705, 75, 75);

        JLabel pole1 = new JLabel();
        pole1.setIcon(new ImageIcon("grafika/8polePelne1.png"));
        pole1.setBounds(305, 705, 75, 75);

        JLabel pole2 = new JLabel();
        pole2.setIcon(new ImageIcon("grafika/8polePelne2.png"));
        pole2.setBounds(390, 705, 75, 75);

        JLabel pole3 = new JLabel();
        pole3.setIcon(new ImageIcon("grafika/8polePelne3.png"));
        pole3.setBounds(475, 705, 75, 75);

        JLabel pole4 = new JLabel();
        pole4.setIcon(new ImageIcon("grafika/8polePelne4.png"));
        pole4.setBounds(560, 705, 75, 75);

        JLabel drukuj = new JLabel();
        drukuj.setIcon(new ImageIcon("grafika/drukuj.png"));
        drukuj.setBounds(630, 434, 150, 100);

        PustaPlansza(x, y, rozmiarKafelka, pole, panel);


        graj.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                graj.setIcon(new ImageIcon("grafika/graj_najazd.png"));
            }
        });
        graj.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                graj.setIcon(new ImageIcon("grafika/graj.png"));
            }
        });
        graj.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                graj.setIcon(new ImageIcon("grafika/graj_klik.png"));
            }
        });
        graj.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                graj.setIcon(new ImageIcon("grafika/graj.png"));
            }
        });
        graj.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    new Plansza(panel);
                }

            }
        });

        biale.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (wybor != -1) {
                        biale.setIcon(new ImageIcon("grafika/polePuste_zaznaczone.png"));
                        czarne.setIcon(new ImageIcon("grafika/8polePelne.png"));
                        pole0.setIcon(new ImageIcon("grafika/8polePelne0.png"));
                        pole1.setIcon(new ImageIcon("grafika/8polePelne1.png"));
                        pole2.setIcon(new ImageIcon("grafika/8polePelne2.png"));
                        pole3.setIcon(new ImageIcon("grafika/8polePelne3.png"));
                        pole4.setIcon(new ImageIcon("grafika/8polePelne4.png"));
                        wybor = -1;
                    }
                }

            }
        });

        czarne.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (wybor != 0) {
                        czarne.setIcon(new ImageIcon("grafika/polePelne_zaznaczone.png"));
                        biale.setIcon(new ImageIcon("grafika/8polePuste.png"));
                        pole0.setIcon(new ImageIcon("grafika/8polePelne0.png"));
                        pole1.setIcon(new ImageIcon("grafika/8polePelne1.png"));
                        pole2.setIcon(new ImageIcon("grafika/8polePelne2.png"));
                        pole3.setIcon(new ImageIcon("grafika/8polePelne3.png"));
                        pole4.setIcon(new ImageIcon("grafika/8polePelne4.png"));
                        wybor = 0;
                    }
                }

            }
        });

        pole0.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (wybor != 1) {
                        pole0.setIcon(new ImageIcon("grafika/polePelne0_zaznaczone.png"));
                        biale.setIcon(new ImageIcon("grafika/8polePuste.png"));
                        czarne.setIcon(new ImageIcon("grafika/8polePelne.png"));
                        pole1.setIcon(new ImageIcon("grafika/8polePelne1.png"));
                        pole2.setIcon(new ImageIcon("grafika/8polePelne2.png"));
                        pole3.setIcon(new ImageIcon("grafika/8polePelne3.png"));
                        pole4.setIcon(new ImageIcon("grafika/8polePelne4.png"));
                        wybor = 1;
                    }
                }

            }
        });

        pole1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (wybor != 2) {
                        pole1.setIcon(new ImageIcon("grafika/polePelne1_zaznaczone.png"));
                        biale.setIcon(new ImageIcon("grafika/8polePuste.png"));
                        pole0.setIcon(new ImageIcon("grafika/8polePelne0.png"));
                        czarne.setIcon(new ImageIcon("grafika/8polePelne.png"));
                        pole2.setIcon(new ImageIcon("grafika/8polePelne2.png"));
                        pole3.setIcon(new ImageIcon("grafika/8polePelne3.png"));
                        pole4.setIcon(new ImageIcon("grafika/8polePelne4.png"));
                        wybor = 2;
                    }
                }

            }
        });

        pole2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (wybor != 3) {
                        pole2.setIcon(new ImageIcon("grafika/polePelne2_zaznaczone.png"));
                        biale.setIcon(new ImageIcon("grafika/8polePuste.png"));
                        pole0.setIcon(new ImageIcon("grafika/8polePelne0.png"));
                        pole1.setIcon(new ImageIcon("grafika/8polePelne1.png"));
                        czarne.setIcon(new ImageIcon("grafika/8polePelne.png"));
                        pole3.setIcon(new ImageIcon("grafika/8polePelne3.png"));
                        pole4.setIcon(new ImageIcon("grafika/8polePelne4.png"));
                        wybor = 3;
                    }
                }

            }
        });

        pole3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (wybor != 4) {
                        pole3.setIcon(new ImageIcon("grafika/polePelne3_zaznaczone.png"));
                        biale.setIcon(new ImageIcon("grafika/8polePuste.png"));
                        pole0.setIcon(new ImageIcon("grafika/8polePelne0.png"));
                        pole1.setIcon(new ImageIcon("grafika/8polePelne1.png"));
                        pole2.setIcon(new ImageIcon("grafika/8polePelne2.png"));
                        czarne.setIcon(new ImageIcon("grafika/8polePelne.png"));
                        pole4.setIcon(new ImageIcon("grafika/8polePelne4.png"));
                        wybor = 4;
                    }
                }

            }
        });

        pole4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (wybor != 5) {
                        pole4.setIcon(new ImageIcon("grafika/polePelne4_zaznaczone.png"));
                        biale.setIcon(new ImageIcon("grafika/8polePuste.png"));
                        pole0.setIcon(new ImageIcon("grafika/8polePelne0.png"));
                        pole1.setIcon(new ImageIcon("grafika/8polePelne1.png"));
                        pole2.setIcon(new ImageIcon("grafika/8polePelne2.png"));
                        pole3.setIcon(new ImageIcon("grafika/8polePelne3.png"));
                        czarne.setIcon(new ImageIcon("grafika/8polePelne.png"));
                        wybor = 5;
                    }
                }

            }
        });


        wyczysc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                wyczysc.setIcon(new ImageIcon("grafika/wyczyść_najazd.png"));
            }
        });

        wyczysc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                wyczysc.setIcon(new ImageIcon("grafika/wyczyść.png"));
            }
        });

        wyczysc.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                wyczysc.setIcon(new ImageIcon("grafika/wyczyść_klik.png"));
            }
        });

        wyczysc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                wyczysc.setIcon(new ImageIcon("grafika/wyczyść.png"));
            }
        });

        wyczysc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    panel.removeAll();
                    for (int i = 0; i < Akari.rozmiar; i++)
                        Arrays.fill(NowaGra.mechanika[i], 6);
                    PustaPlansza(x, y, rozmiarKafelka, pole, panel);
                    panel.add(powrot1);
                    panel.add(czarne);
                    panel.add(biale);
                    panel.add(drukuj);
                    panel.add(pole0);
                    panel.add(pole1);
                    panel.add(pole2);
                    panel.add(twojaGra);
                    panel.add(pole3);
                    panel.add(pole4);
                    panel.add(wyczysc);
                    panel.add(zapisz);
                    panel.add(graj);
                    panel.revalidate();
                    panel.repaint();
                }

            }
        });

        zapisz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                zapisz.setIcon(new ImageIcon("grafika/zapisz_najazd.png"));
            }
        });
        zapisz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                zapisz.setIcon(new ImageIcon("grafika/zapisz.png"));
            }
        });
        zapisz.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                zapisz.setIcon(new ImageIcon("grafika/zapisz_klik.png"));
            }
        });
        zapisz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                zapisz.setIcon(new ImageIcon("grafika/zapisz.png"));
            }
        });
        zapisz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

                    fileChooser.setDialogTitle("Zapisz planszę");
                    int result = fileChooser.showSaveDialog(panel);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        try {
                            File selectedFile = fileChooser.getSelectedFile();
                            FileWriter writer = new FileWriter(selectedFile);
                            writer.write(Akari.rozmiar + "\n");
                            for (int i = 0; i < Akari.rozmiar; i++) {
                                for (int j = 0; j < Akari.rozmiar; j++) {
                                    writer.write(NowaGra.mechanika[i][j] + " ");
                                }
                                writer.write("\n");
                            }
                            writer.close();
                        } catch (Exception err) {
                            JOptionPane optionPane = new JOptionPane("Błąd podczas zapisywania planszy", JOptionPane.ERROR_MESSAGE);
                            JDialog dialog = optionPane.createDialog("Błąd!");
                            dialog.setAlwaysOnTop(true);
                            dialog.setVisible(true);
                            new Blad(err);
                            return;
                        }

                    }
                }

            }
        });

        drukuj.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                drukuj.setIcon(new ImageIcon("grafika/drukuj_najazd.png"));
            }
        });

        drukuj.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                drukuj.setIcon(new ImageIcon("grafika/drukuj.png"));
            }
        });

        drukuj.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                drukuj.setIcon(new ImageIcon("grafika/drukuj_klik.png"));
            }
        });

        drukuj.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                drukuj.setIcon(new ImageIcon("grafika/drukuj.png"));
            }
        });

        drukuj.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

                    fileChooser.setDialogTitle("Zapisz zdjęcie planszy do wydruku");
                    int result = fileChooser.showSaveDialog(panel);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        try {
                            File selectedFile = fileChooser.getSelectedFile();
                            panel.removeAll();
                            PlanszaReprint(0, 0, rozmiarKafelka, panel);
                            BufferedImage image = new BufferedImage(rozmiarKafelka * Akari.rozmiar, rozmiarKafelka * Akari.rozmiar, BufferedImage.TYPE_INT_RGB);
                            Graphics2D g2 = image.createGraphics();
                            panel.paint(g2);
                            String filename = selectedFile.getName();
                            String ext = filename.substring(filename.lastIndexOf("."));
                            ext = ext.substring(1);
                            ImageIO.write(image, ext, selectedFile);

                        } catch (Exception err) {
                            JOptionPane optionPane = new JOptionPane("Błąd podczas zapisywania planszy", JOptionPane.ERROR_MESSAGE);
                            JDialog dialog = optionPane.createDialog("Błąd!");
                            dialog.setAlwaysOnTop(true);
                            dialog.setVisible(true);
                            new Blad(err);
                            return;
                        }

                    }

                    panel.removeAll();
                    PlanszaReprint(x, y, rozmiarKafelka, panel);
                    panel.add(biale);
                    panel.add(drukuj);
                    panel.add(powrot1);
                    panel.add(czarne);
                    panel.add(pole0);
                    panel.add(pole1);
                    panel.add(pole2);
                    panel.add(pole3);
                    panel.add(twojaGra);
                    panel.add(pole4);
                    panel.add(wyczysc);
                    panel.add(zapisz);
                    panel.add(graj);
                    panel.revalidate();
                    panel.repaint();
                }
            }


        });

        panel.add(biale);
        panel.add(drukuj);
        panel.add(powrot1);
        panel.add(czarne);
        panel.add(pole0);
        panel.add(pole1);
        panel.add(twojaGra);
        panel.add(pole2);
        panel.add(pole3);
        panel.add(pole4);
        panel.add(wyczysc);
        panel.add(zapisz);
        panel.add(graj);
        panel.revalidate();
        panel.repaint();

    }
}



