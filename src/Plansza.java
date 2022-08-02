import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;

public class Plansza {

    private final JLabel[][] plansza = new JLabel[Akari.rozmiar][Akari.rozmiar];
    private final int[][] koniec = new int[Akari.rozmiar][Akari.rozmiar];
    private String dodatek = "";
    private final Grafika panel;


    private void Oswietlacz(int a, int b) {


        boolean czyKoniec = false;
        plansza[a][b].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "poleZarowka" + dodatek + ".png"));
        NowaGra.mechanika[a][b] = 8;
        koniec[a][b] = 1;


        for (int z = a + 1; z < Akari.rozmiar; z++) {
            if (NowaGra.mechanika[z][b] < 6) break;
            else {
                switch (NowaGra.mechanika[z][b]) {
                    case 6:
                        NowaGra.mechanika[z][b] = 7;
                        koniec[z][b] = 1;
                        plansza[z][b].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "poleOswietlone" + dodatek + ".png"));
                        break;
                    case 9:
                        NowaGra.mechanika[z][b] = 10;
                        koniec[z][b] = 1;
                        plansza[z][b].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "poleOswietloneX" + dodatek + ".png"));
                        break;
                    default:
                        break;
                }
            }
        }
        for (int z = a - 1; z > -1; z--) {
            if (NowaGra.mechanika[z][b] < 6) break;
            else {
                switch (NowaGra.mechanika[z][b]) {
                    case 6:
                        NowaGra.mechanika[z][b] = 7;
                        koniec[z][b] = 1;
                        plansza[z][b].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "poleOswietlone" + dodatek + ".png"));
                        break;
                    case 9:
                        NowaGra.mechanika[z][b] = 10;
                        koniec[z][b] = 1;
                        plansza[z][b].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "poleOswietloneX" + dodatek + ".png"));
                        break;
                    default:
                        break;
                }
            }
        }
        for (int z = b + 1; z < Akari.rozmiar; z++) {
            if (NowaGra.mechanika[a][z] < 6) break;
            else {
                switch (NowaGra.mechanika[a][z]) {
                    case 6:
                        NowaGra.mechanika[a][z] = 7;
                        koniec[a][z] = 1;
                        plansza[a][z].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "poleOswietlone" + dodatek + ".png"));
                        break;
                    case 9:
                        NowaGra.mechanika[a][z] = 10;
                        koniec[a][z] = 1;
                        plansza[a][z].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "poleOswietloneX" + dodatek + ".png"));
                        break;
                    default:
                        break;
                }
            }
        }
        for (int z = b - 1; z > -1; z--) {
            if (NowaGra.mechanika[a][z] < 6) break;
            else {
                switch (NowaGra.mechanika[a][z]) {
                    case 6:
                        NowaGra.mechanika[a][z] = 7;
                        koniec[a][z] = 1;
                        plansza[a][z].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "poleOswietlone" + dodatek + ".png"));
                        break;
                    case 9:
                        NowaGra.mechanika[a][z] = 10;
                        koniec[a][z] = 1;
                        plansza[a][z].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "poleOswietloneX" + dodatek + ".png"));
                        break;
                    default:
                        break;
                }
            }
        }


        int ileOboka = 0;
        int ileObokb = 0;
        int ileObokc = 0;
        int ileObokd = 0;

        if (a - 1 > -1) {
            if (NowaGra.mechanika[a - 1][b] < 5) {
                if (b - 1 > -1) if (NowaGra.mechanika[a - 1][b - 1] == 8) ileOboka++;
                if (b + 1 < Akari.rozmiar) if (NowaGra.mechanika[a - 1][b + 1] == 8) ileOboka++;
                if (a - 2 > -1) if (NowaGra.mechanika[a - 2][b] == 8) ileOboka++;
                if (NowaGra.mechanika[a][b] == 8) ileOboka++;

                if (NowaGra.mechanika[a - 1][b] < ileOboka) {
                    plansza[a - 1][b].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "polePelne" + NowaGra.mechanika[a - 1][b] + "NO" + dodatek + ".png"));
                    koniec[a - 1][b] = 0;
                } else if (NowaGra.mechanika[a - 1][b] == ileOboka) {
                    plansza[a - 1][b].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "polePelne" + NowaGra.mechanika[a - 1][b] + "OK" + dodatek + ".png"));
                    koniec[a - 1][b] = 1;
                }
            }
        }

        if (a + 1 < Akari.rozmiar) {
            if (NowaGra.mechanika[a + 1][b] < 5) {
                if (b - 1 > -1) if (NowaGra.mechanika[a + 1][b - 1] == 8) ileObokb++;
                if (b + 1 < Akari.rozmiar) if (NowaGra.mechanika[a + 1][b + 1] == 8) ileObokb++;
                if (a + 2 < Akari.rozmiar) if (NowaGra.mechanika[a + 2][b] == 8) ileObokb++;
                if (NowaGra.mechanika[a][b] == 8) ileObokb++;

                if (NowaGra.mechanika[a + 1][b] < ileObokb) {
                    plansza[a + 1][b].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "polePelne" + NowaGra.mechanika[a + 1][b] + "NO" + dodatek + ".png"));
                    koniec[a + 1][b] = 0;
                } else if (NowaGra.mechanika[a + 1][b] == ileObokb) {
                    plansza[a + 1][b].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "polePelne" + NowaGra.mechanika[a + 1][b] + "OK" + dodatek + ".png"));
                    koniec[a + 1][b] = 1;
                }
            }
        }

        if (b + 1 < Akari.rozmiar) {
            if (NowaGra.mechanika[a][b + 1] < 5) {
                if (a + 1 < Akari.rozmiar) if (NowaGra.mechanika[a + 1][b + 1] == 8) ileObokc++;
                if (a - 1 > -1) if (NowaGra.mechanika[a - 1][b + 1] == 8) ileObokc++;
                if (b + 2 < Akari.rozmiar) if (NowaGra.mechanika[a][b + 2] == 8) ileObokc++;
                if (NowaGra.mechanika[a][b] == 8) ileObokc++;

                if (NowaGra.mechanika[a][b + 1] < ileObokc) {
                    plansza[a][b + 1].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "polePelne" + NowaGra.mechanika[a][b + 1] + "NO" + dodatek + ".png"));
                    koniec[a][b + 1] = 0;
                } else if (NowaGra.mechanika[a][b + 1] == ileObokc) {
                    plansza[a][b + 1].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "polePelne" + NowaGra.mechanika[a][b + 1] + "OK" + dodatek + ".png"));
                    koniec[a][b + 1] = 1;
                }
            }
        }

        if (b - 1 > -1) {
            if (NowaGra.mechanika[a][b - 1] < 5) {
                if (a - 1 > -1) if (NowaGra.mechanika[a - 1][b - 1] == 8) ileObokd++;
                if (a + 1 < Akari.rozmiar) if (NowaGra.mechanika[a + 1][b - 1] == 8) ileObokd++;
                if (b - 2 > -1) if (NowaGra.mechanika[a][b - 2] == 8) ileObokd++;
                if (NowaGra.mechanika[a][b] == 8) ileObokd++;

                if (NowaGra.mechanika[a][b - 1] < ileObokd) {
                    plansza[a][b - 1].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "polePelne" + NowaGra.mechanika[a][b - 1] + "NO" + dodatek + ".png"));
                    koniec[a][b - 1] = 0;
                } else if (NowaGra.mechanika[a][b - 1] == ileObokd) {
                    plansza[a][b - 1].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "polePelne" + NowaGra.mechanika[a][b - 1] + "OK" + dodatek + ".png"));
                    koniec[a][b - 1] = 1;
                }
            }
        }

        boolean semiKoniec = true;
        for (int i = 0; i < Akari.rozmiar; i++) {
            for (int j = 0; j < Akari.rozmiar; j++) {
                if (koniec[i][j] == 0) {
                    semiKoniec = false;
                    break;
                }
            }
            if (!semiKoniec) {
                czyKoniec = false;
                break;
            } else czyKoniec = true;
        }


        if (czyKoniec) {
            JDialog koniec = new JDialog();
            koniec.setTitle("Wygrana!");
            ImageIcon icon = new ImageIcon("grafika/icon.png");
            koniec.setIconImage(icon.getImage());

            Grafika tlo = new Grafika("grafika/wygrana.png");
            tlo.setLayout(null);

            JLabel powrot = new JLabel();
            powrot.setIcon(new ImageIcon("grafika/powrótDoGry.png"));
            powrot.setBounds(100, 335, 200, 50);


            powrot.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    powrot.setIcon(new ImageIcon("grafika/powrótDoGry_najazd.png"));
                }
            });

            powrot.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    powrot.setIcon(new ImageIcon("grafika/powrótDoGry.png"));
                }
            });

            powrot.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    powrot.setIcon(new ImageIcon("grafika/powrótDoGry_klik.png"));
                }
            });

            powrot.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    super.mouseReleased(e);
                    powrot.setIcon(new ImageIcon("grafika/powrótDoGry.png"));
                }
            });

            powrot.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        new NowaGra(panel, Akari.powrot);
                        koniec.dispose();
                    }

                }
            });

            tlo.add(powrot);
            koniec.add(tlo);
            koniec.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            koniec.setResizable(false);
            koniec.pack();
            koniec.setLocationRelativeTo(null);
            koniec.setVisible(true);
        }

    }

    public boolean Poziomo(int a, int b) {

        boolean czy = false;
        boolean czy1 = false;
        boolean ret;
        for (int i = b + 1; i < Akari.rozmiar; i++) {
            if (NowaGra.mechanika[a][i] < 6) break;
            else if (NowaGra.mechanika[a][i] == 8) {
                czy = true;
                break;
            }
        }
        for (int i = b - 1; i > -1; i--) {
            if (NowaGra.mechanika[a][i] < 6) break;
            else if (NowaGra.mechanika[a][i] == 8) {
                czy1 = true;
                break;
            }
        }
        ret = czy || czy1;

        return ret;
    }

    public boolean Pionowo(int a, int b) {
        boolean czy = false;
        boolean czy1 = false;
        boolean ret;
        for (int i = a + 1; i < Akari.rozmiar; i++) {
            if (NowaGra.mechanika[i][b] < 6) break;
            else if (NowaGra.mechanika[i][b] == 8) {
                czy = true;
                break;
            }
        }
        for (int i = a - 1; i > -1; i--) {
            if (NowaGra.mechanika[i][b] < 6) break;
            else if (NowaGra.mechanika[i][b] == 8) {
                czy1 = true;
                break;
            }
        }
        ret = czy || czy1;

        return ret;
    }

    private void Zgaszacz(int a, int b) {


        plansza[a][b].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "polePuste.png"));
        NowaGra.mechanika[a][b] = 6;
        koniec[a][b] = 0;

        for (int z = a + 1; z < Akari.rozmiar; z++) {
            if (NowaGra.mechanika[z][b] < 6) break;
            else {
                if (Poziomo(z, b)) continue;
                else {
                    switch (NowaGra.mechanika[z][b]) {
                        case 7:
                            NowaGra.mechanika[z][b] = 6;
                            koniec[z][b] = 0;
                            plansza[z][b].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "polePuste.png"));
                            break;
                        case 10:
                            NowaGra.mechanika[z][b] = 9;
                            koniec[z][b] = 0;
                            plansza[z][b].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "polePusteX.png"));
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        for (int z = a - 1; z > -1; z--) {
            if (NowaGra.mechanika[z][b] < 6) break;
            else {
                if (Poziomo(z, b)) continue;
                else {
                    switch (NowaGra.mechanika[z][b]) {
                        case 7:
                            NowaGra.mechanika[z][b] = 6;
                            koniec[z][b] = 0;
                            plansza[z][b].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "polePuste.png"));
                            break;
                        case 10:
                            NowaGra.mechanika[z][b] = 9;
                            koniec[z][b] = 0;
                            plansza[z][b].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "polePusteX.png"));
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        for (int z = b + 1; z < Akari.rozmiar; z++) {
            if (NowaGra.mechanika[a][z] < 6) break;
            else {
                if (Pionowo(a, z)) continue;
                else {
                    switch (NowaGra.mechanika[a][z]) {
                        case 7:
                            NowaGra.mechanika[a][z] = 6;
                            koniec[a][z] = 0;
                            plansza[a][z].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "polePuste.png"));
                            break;
                        case 10:
                            NowaGra.mechanika[a][z] = 9;
                            koniec[a][z] = 0;
                            plansza[a][z].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "polePusteX.png"));
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        for (int z = b - 1; z > -1; z--) {
            if (NowaGra.mechanika[a][z] < 6) break;
            else {
                if (Pionowo(a, z)) continue;
                else {
                    switch (NowaGra.mechanika[a][z]) {
                        case 7:
                            NowaGra.mechanika[a][z] = 6;
                            koniec[a][z] = 0;
                            plansza[a][z].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "polePuste.png"));
                            break;
                        case 10:
                            NowaGra.mechanika[a][z] = 9;
                            koniec[a][z] = 0;
                            plansza[a][z].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "polePusteX.png"));
                            break;
                        default:
                            break;
                    }
                }
            }
        }


        int ileOboka = 0;
        int ileObokb = 0;
        int ileObokc = 0;
        int ileObokd = 0;

        if (a - 1 > -1) {
            if (NowaGra.mechanika[a - 1][b] < 5) {
                if (b - 1 > -1) if (NowaGra.mechanika[a - 1][b - 1] == 8) ileOboka++;
                if (b + 1 < Akari.rozmiar) if (NowaGra.mechanika[a - 1][b + 1] == 8) ileOboka++;
                if (a - 2 > -1) if (NowaGra.mechanika[a - 2][b] == 8) ileOboka++;
                if (NowaGra.mechanika[a][b] == 8) ileOboka++;

                if (NowaGra.mechanika[a - 1][b] > ileOboka) {
                    plansza[a - 1][b].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "polePelne" + NowaGra.mechanika[a - 1][b] + dodatek + ".png"));
                    koniec[a - 1][b] = 0;
                } else if (NowaGra.mechanika[a - 1][b] == ileOboka) {
                    plansza[a - 1][b].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "polePelne" + NowaGra.mechanika[a - 1][b] + "OK" + dodatek + ".png"));
                    koniec[a - 1][b] = 1;
                }
            }
        }

        if (a + 1 < Akari.rozmiar) {
            if (NowaGra.mechanika[a + 1][b] < 5) {
                if (b - 1 > -1) if (NowaGra.mechanika[a + 1][b - 1] == 8) ileObokb++;
                if (b + 1 < Akari.rozmiar) if (NowaGra.mechanika[a + 1][b + 1] == 8) ileObokb++;
                if (a + 2 < Akari.rozmiar) if (NowaGra.mechanika[a + 2][b] == 8) ileObokb++;
                if (NowaGra.mechanika[a][b] == 8) ileObokb++;

                if (NowaGra.mechanika[a + 1][b] > ileObokb) {
                    plansza[a + 1][b].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "polePelne" + NowaGra.mechanika[a + 1][b] + dodatek + ".png"));
                    koniec[a + 1][b] = 0;
                } else if (NowaGra.mechanika[a + 1][b] == ileObokb) {
                    plansza[a + 1][b].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "polePelne" + NowaGra.mechanika[a + 1][b] + "OK" + dodatek + ".png"));
                    koniec[a + 1][b] = 1;
                }
            }
        }

        if (b + 1 < Akari.rozmiar) {
            if (NowaGra.mechanika[a][b + 1] < 5) {
                if (a + 1 < Akari.rozmiar) if (NowaGra.mechanika[a + 1][b + 1] == 8) ileObokc++;
                if (a - 1 > -1) if (NowaGra.mechanika[a - 1][b + 1] == 8) ileObokc++;
                if (b + 2 < Akari.rozmiar) if (NowaGra.mechanika[a][b + 2] == 8) ileObokc++;
                if (NowaGra.mechanika[a][b] == 8) ileObokc++;

                if (NowaGra.mechanika[a][b + 1] > ileObokc) {
                    plansza[a][b + 1].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "polePelne" + NowaGra.mechanika[a][b + 1] + dodatek + ".png"));
                    koniec[a][b + 1] = 0;
                } else if (NowaGra.mechanika[a][b + 1] == ileObokc) {
                    plansza[a][b + 1].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "polePelne" + NowaGra.mechanika[a][b + 1] + "OK" + dodatek + ".png"));
                    koniec[a][b + 1] = 1;
                }
            }
        }

        if (b - 1 > -1) {
            if (NowaGra.mechanika[a][b - 1] < 5) {
                if (a - 1 > -1) if (NowaGra.mechanika[a - 1][b - 1] == 8) ileObokd++;
                if (a + 1 < Akari.rozmiar) if (NowaGra.mechanika[a + 1][b - 1] == 8) ileObokd++;
                if (b - 2 > -1) if (NowaGra.mechanika[a][b - 2] == 8) ileObokd++;
                if (NowaGra.mechanika[a][b] == 8) ileObokd++;

                if (NowaGra.mechanika[a][b - 1] > ileObokd) {
                    plansza[a][b - 1].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "polePelne" + NowaGra.mechanika[a][b - 1] + dodatek + ".png"));
                    koniec[a][b - 1] = 0;
                } else if (NowaGra.mechanika[a][b - 1] == ileObokd) {
                    plansza[a][b - 1].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "polePelne" + NowaGra.mechanika[a][b - 1] + "OK" + dodatek + ".png"));
                    koniec[a][b] = 1;
                }
            }
        }

    }

    public Plansza(Grafika panel) {
        this.panel = panel;
        panel.removeAll();

        JLabel zapisz = new JLabel();
        zapisz.setIcon(new ImageIcon("grafika/zapiszDoPliku.png"));
        zapisz.setBounds(50, 675, 200, 100);

        JLabel zakoncz = new JLabel();
        zakoncz.setIcon(new ImageIcon("grafika/zakończ.png"));
        zakoncz.setBounds(550, 675, 200, 100);

        JLabel podpowiedz = new JLabel();
        podpowiedz.setIcon(new ImageIcon("grafika/podpowiedz.png"));
        podpowiedz.setBounds(300, 675, 200, 100);

        podpowiedz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                podpowiedz.setIcon(new ImageIcon("grafika/podpowiedz_najazd.png"));
            }
        });

        podpowiedz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                podpowiedz.setIcon(new ImageIcon("grafika/podpowiedz.png"));
            }
        });

        podpowiedz.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                podpowiedz.setIcon(new ImageIcon("grafika/podpowiedz_klik.png"));
            }
        });

        podpowiedz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                podpowiedz.setIcon(new ImageIcon("grafika/podpowiedz.png"));
            }
        });


        zakoncz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz zakończyć rozgrywkę?\n     Niezapisany postęp zostanie utracony.", "Ostrzeżenie!",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        new NowaGra(panel, Akari.powrot);
                    }
                }

            }
        });

        zakoncz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                zakoncz.setIcon(new ImageIcon("grafika/zakończ_najazd.png"));
            }
        });

        zakoncz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                zakoncz.setIcon(new ImageIcon("grafika/zakończ.png"));
            }
        });

        zakoncz.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                zakoncz.setIcon(new ImageIcon("grafika/zakończ_klik.png"));
            }
        });

        zakoncz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                zakoncz.setIcon(new ImageIcon("grafika/zakończ.png"));
            }
        });

        zapisz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                zapisz.setIcon(new ImageIcon("grafika/zapiszDoPliku_najazd.png"));
            }
        });

        zapisz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                zapisz.setIcon(new ImageIcon("grafika/zapiszDoPliku.png"));
            }
        });

        zapisz.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                zapisz.setIcon(new ImageIcon("grafika/zapiszDoPliku_klik.png"));
            }
        });

        zapisz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                zapisz.setIcon(new ImageIcon("grafika/zapiszDoPliku.png"));
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


        switch (Akari.motyw) {
            case 2:
                dodatek = "_niebieski";
                break;
            case 3:
                dodatek = "_teczowy";
                break;
            default:
                break;
        }

        int rozmiarKafelka = 0;
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

        int x = 100;
        int y = 50;
        String jakaGrafika;

        for (int i = 0; i < Akari.rozmiar; i++) {
            for (int j = 0; j < Akari.rozmiar; j++) {
                plansza[i][j] = new JLabel();
                int ileObok = 0;
                switch (NowaGra.mechanika[i][j]) {
                    case 0:
                        if (i - 1 > -1) if (NowaGra.mechanika[i - 1][j] == 8) ileObok++;
                        if (i + 1 < Akari.rozmiar) if (NowaGra.mechanika[i + 1][j] == 8) ileObok++;
                        if (j - 1 > -1) if (NowaGra.mechanika[i][j - 1] == 8) ileObok++;
                        if (j + 1 < Akari.rozmiar) if (NowaGra.mechanika[i][j + 1] == 8) ileObok++;
                        if (ileObok == 0) {
                            jakaGrafika = "grafika/" + Akari.rozmiar + "polePelne0OK" + dodatek + ".png";
                            koniec[i][j] = 1;
                        } else {
                            jakaGrafika = "grafika/" + Akari.rozmiar + "polePelne0NO" + dodatek + ".png";
                            koniec[i][j] = 0;
                        }
                        plansza[i][j].setIcon(new ImageIcon(jakaGrafika));
                        break;
                    case 1:
                        if (i - 1 > -1) if (NowaGra.mechanika[i - 1][j] == 8) ileObok++;
                        if (i + 1 < Akari.rozmiar) if (NowaGra.mechanika[i + 1][j] == 8) ileObok++;
                        if (j - 1 > -1) if (NowaGra.mechanika[i][j - 1] == 8) ileObok++;
                        if (j + 1 < Akari.rozmiar) if (NowaGra.mechanika[i][j + 1] == 8) ileObok++;
                        if (ileObok < 1) {
                            jakaGrafika = "grafika/" + Akari.rozmiar + "polePelne1" + dodatek + ".png";
                            koniec[i][j] = 0;
                        } else if (ileObok == 1) {
                            jakaGrafika = "grafika/" + Akari.rozmiar + "polePelne1OK" + dodatek + ".png";
                            koniec[i][j] = 1;
                        } else {
                            jakaGrafika = "grafika/" + Akari.rozmiar + "polePelne1NO" + dodatek + ".png";
                            koniec[i][j] = 0;
                        }
                        plansza[i][j].setIcon(new ImageIcon(jakaGrafika));
                        break;
                    case 2:
                        if (i - 1 > -1) if (NowaGra.mechanika[i - 1][j] == 8) ileObok++;
                        if (i + 1 < Akari.rozmiar) if (NowaGra.mechanika[i + 1][j] == 8) ileObok++;
                        if (j - 1 > -1) if (NowaGra.mechanika[i][j - 1] == 8) ileObok++;
                        if (j + 1 < Akari.rozmiar) if (NowaGra.mechanika[i][j + 1] == 8) ileObok++;
                        if (ileObok < 2) {
                            jakaGrafika = "grafika/" + Akari.rozmiar + "polePelne2" + dodatek + ".png";
                            koniec[i][j] = 0;
                        } else if (ileObok == 2) {
                            jakaGrafika = "grafika/" + Akari.rozmiar + "polePelne2OK" + dodatek + ".png";
                            koniec[i][j] = 1;
                        } else {
                            jakaGrafika = "grafika/" + Akari.rozmiar + "polePelne2NO" + dodatek + ".png";
                            koniec[i][j] = 0;
                        }
                        plansza[i][j].setIcon(new ImageIcon(jakaGrafika));
                        break;
                    case 3:
                        if (i - 1 > -1) if (NowaGra.mechanika[i - 1][j] == 8) ileObok++;
                        if (i + 1 < Akari.rozmiar) if (NowaGra.mechanika[i + 1][j] == 8) ileObok++;
                        if (j - 1 > -1) if (NowaGra.mechanika[i][j - 1] == 8) ileObok++;
                        if (j + 1 < Akari.rozmiar) if (NowaGra.mechanika[i][j + 1] == 8) ileObok++;
                        if (ileObok < 3) {
                            jakaGrafika = "grafika/" + Akari.rozmiar + "polePelne3" + dodatek + ".png";
                            koniec[i][j] = 0;
                        } else if (ileObok == 3) {
                            jakaGrafika = "grafika/" + Akari.rozmiar + "polePelne3OK" + dodatek + ".png";
                            koniec[i][j] = 1;
                        } else {
                            jakaGrafika = "grafika/" + Akari.rozmiar + "polePelne3NO" + dodatek + ".png";
                            koniec[i][j] = 0;
                        }
                        plansza[i][j].setIcon(new ImageIcon(jakaGrafika));
                        break;
                    case 4:
                        if (i - 1 > -1) if (NowaGra.mechanika[i - 1][j] == 8) ileObok++;
                        if (i + 1 < Akari.rozmiar) if (NowaGra.mechanika[i + 1][j] == 8) ileObok++;
                        if (j - 1 > -1) if (NowaGra.mechanika[i][j - 1] == 8) ileObok++;
                        if (j + 1 < Akari.rozmiar) if (NowaGra.mechanika[i][j + 1] == 8) ileObok++;
                        if (ileObok < 4) {
                            jakaGrafika = "grafika/" + Akari.rozmiar + "polePelne4" + dodatek + ".png";
                            koniec[i][j] = 0;
                        } else {
                            jakaGrafika = "grafika/" + Akari.rozmiar + "polePelne4OK" + dodatek + ".png";
                            koniec[i][j] = 1;
                        }
                        plansza[i][j].setIcon(new ImageIcon(jakaGrafika));
                        break;
                    case 5:
                        jakaGrafika = "grafika/" + Akari.rozmiar + "polePelne" + dodatek + ".png";
                        plansza[i][j].setIcon(new ImageIcon(jakaGrafika));
                        koniec[i][j] = 1;
                        break;
                    case 6:
                        jakaGrafika = "grafika/" + Akari.rozmiar + "polePuste.png";
                        plansza[i][j].setIcon(new ImageIcon(jakaGrafika));
                        koniec[i][j] = 0;
                        break;
                    case 7:
                        jakaGrafika = "grafika/" + Akari.rozmiar + "poleOswietlone" + dodatek + ".png";
                        plansza[i][j].setIcon(new ImageIcon(jakaGrafika));
                        koniec[i][j] = 1;
                        break;
                    case 8:
                        jakaGrafika = "grafika/" + Akari.rozmiar + "poleZarowka" + dodatek + ".png";
                        plansza[i][j].setIcon(new ImageIcon(jakaGrafika));
                        koniec[i][j] = 1;
                        break;
                    case 9:
                        jakaGrafika = "grafika/" + Akari.rozmiar + "polePusteX.png";
                        plansza[i][j].setIcon(new ImageIcon(jakaGrafika));
                        koniec[i][j] = 0;
                        break;
                    case 10:
                        jakaGrafika = "grafika/" + Akari.rozmiar + "poleOswietloneX" + dodatek + ".png";
                        plansza[i][j].setIcon(new ImageIcon(jakaGrafika));
                        koniec[i][j] = 1;
                        break;
                    default:
                        break;
                }
                plansza[i][j].setBounds(x, y, rozmiarKafelka, rozmiarKafelka);
                x += rozmiarKafelka;
                panel.add(plansza[i][j]);
            }
            x = 100;
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
                                switch (NowaGra.mechanika[a][b]) {
                                    case 6:
                                        Oswietlacz(a, b);
                                        break;
                                    case 8:
                                        Zgaszacz(a, b);
                                        break;
                                    default:
                                        break;
                                }
                            }
                            if (e.getButton() == MouseEvent.BUTTON3) {
                                switch (NowaGra.mechanika[a][b]) {
                                    case 6:
                                        NowaGra.mechanika[a][b] = 9;
                                        plansza[a][b].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "polePusteX.png"));
                                        koniec[a][b] = 0;
                                        break;
                                    case 7:
                                        NowaGra.mechanika[a][b] = 10;
                                        plansza[a][b].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "poleOswietloneX" + dodatek + ".png"));
                                        koniec[a][b] = 1;
                                        break;
                                    case 9:
                                        NowaGra.mechanika[a][b] = 6;
                                        plansza[a][b].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "polePuste.png"));
                                        koniec[a][b] = 0;
                                        break;
                                    case 10:
                                        NowaGra.mechanika[a][b] = 7;
                                        plansza[a][b].setIcon(new ImageIcon("grafika/" + Akari.rozmiar + "poleOswietlone" + dodatek + ".png"));
                                        koniec[a][b] = 1;
                                        break;
                                    default:
                                        break;
                                }
                            }


                    }
                });
            }
        }

        panel.add(podpowiedz);
        panel.add(zakoncz);
        panel.add(zapisz);
        panel.revalidate();
        panel.repaint();

    }
}
