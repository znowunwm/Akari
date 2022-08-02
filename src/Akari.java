/**
 * autorzy:
 * Krystian Bogusz
 * Marta Obłoza
 * Przemysław Pustelnik
 */


import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;


public class Akari {

    public static int glosnosc;
    public static int dzwiek;
    public static int motyw;
    public static Clip clip;

    public static int rozmiar = 4;
    public static FloatControl volume;

    public static JLabel powrot;

    public Akari() {

        try {
            File myObj = new File("mechanika/ustawienia.txt");
            Scanner myReader = new Scanner(myObj);
            glosnosc = Integer.parseInt(myReader.next());
            if (glosnosc < 1 || glosnosc > 5) throw new Exception();
            dzwiek = Integer.parseInt(myReader.next());
            if (dzwiek < 0 || dzwiek > 1) throw new Exception();
            motyw = Integer.parseInt(myReader.next());
            if (motyw < 1 || motyw > 3) throw new Exception();
            myReader.close();
        } catch (Exception e) {
            new Blad(e);
            return;
        }
        //Frame

        JFrame frame = new JFrame("Gra Akari");
        ImageIcon icon = new ImageIcon("grafika/icon.png");
        frame.setIconImage(icon.getImage());

        //Panel

        Grafika panel = new Grafika("grafika/plansza_strona.png");
        panel.setLayout(null);


        //Labele

        JLabel tytul = new JLabel();
        tytul.setIcon(new ImageIcon("grafika/napis_akari.png"));
        tytul.setBounds(0, 0, 800, 800);

        JLabel nowaGra = new JLabel();
        nowaGra.setIcon(new ImageIcon("grafika/NowaGra.png"));
        nowaGra.setBounds(100, 250, 600, 100);

        //zasady Label

        JLabel zasady = new JLabel();
        zasady.setIcon(new ImageIcon("grafika/zasady.png"));
        zasady.setBounds(50, 400, 300, 50);

        //ustawienia Label

        JLabel ustawienia = new JLabel();
        ustawienia.setIcon(new ImageIcon("grafika/ustawienia.png"));
        ustawienia.setBounds(450, 400, 300, 50);


        //autorzy Label

        JLabel autorzy = new JLabel();
        autorzy.setIcon(new ImageIcon("grafika/autorzy.png"));
        autorzy.setBounds(50, 500, 300, 50);


        //instrukcja Label

        JLabel instrukcja = new JLabel();
        instrukcja.setIcon(new ImageIcon("grafika/instrukcja.png"));
        instrukcja.setBounds(450, 500, 300, 50);

        //exit Label

        JLabel exit = new JLabel();
        exit.setIcon(new ImageIcon("grafika/Wyjscie.png"));
        exit.setBounds(100, 600, 600, 100);

        //powrot Label

        powrot = new JLabel();
        powrot.setIcon(new ImageIcon("grafika/powrot.png"));
        powrot.setBounds(680, 725, 100, 50);

        //nowaGra akcje

        nowaGra.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    new NowaGra(panel, powrot);
                }

            }
        });

        nowaGra.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                nowaGra.setIcon(new ImageIcon("grafika/NowaGra_klik.png") {
                });
            }
        });


        nowaGra.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                nowaGra.setIcon(new ImageIcon("grafika/NowaGra.png"));
            }
        });


        nowaGra.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                nowaGra.setIcon(new ImageIcon("grafika/Nowagra_najazd.png"));
            }
        });


        nowaGra.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                nowaGra.setIcon(new ImageIcon("grafika/NowaGra.png"));
            }
        });

        //zasady akcje

        zasady.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    super.mouseClicked(e);
                    panel.removeAll();
                    JLabel zasady = new JLabel();
                    zasady.setIcon(new ImageIcon("grafika/zasady_strona.png"));
                    zasady.setBounds(0, -50, 800, 800);
                    panel.add(zasady);
                    panel.add(powrot);
                    panel.add(tytul);
                    panel.revalidate();
                    panel.repaint();
                }


            }
        });


        zasady.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                zasady.setIcon(new ImageIcon("grafika/zasady_klik.png") {
                });
            }
        });


        zasady.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                zasady.setIcon(new ImageIcon("grafika/zasady.png"));
            }
        });


        zasady.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                zasady.setIcon(new ImageIcon("grafika/zasady_najazd.png"));
            }
        });


        zasady.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                zasady.setIcon(new ImageIcon("grafika/zasady.png"));
            }
        });


        //ustawienia akcje

        ustawienia.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    new Ustawienia(panel, powrot);
                }


            }
        });

        ustawienia.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                ustawienia.setIcon(new ImageIcon("grafika/ustawienia_klik.png") {
                });
            }
        });


        ustawienia.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                ustawienia.setIcon(new ImageIcon("grafika/ustawienia.png"));
            }
        });


        ustawienia.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                ustawienia.setIcon(new ImageIcon("grafika/ustawienia_najazd.png"));
            }
        });


        ustawienia.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                ustawienia.setIcon(new ImageIcon("grafika/ustawienia.png"));
            }
        });

        // autorzy akcje

        autorzy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    panel.removeAll();
                    JLabel autorzy = new JLabel();
                    autorzy.setIcon(new ImageIcon("grafika/autorzy_strona.png"));
                    autorzy.setBounds(0, -23, 800, 800);
                    panel.add(autorzy);
                    panel.add(powrot);
                    panel.add(tytul);
                    panel.revalidate();
                    panel.repaint();
                }

            }
        });

        autorzy.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                autorzy.setIcon(new ImageIcon("grafika/autorzy_klik.png") {
                });
            }
        });


        autorzy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                autorzy.setIcon(new ImageIcon("grafika/autorzy.png"));
            }
        });


        autorzy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                autorzy.setIcon(new ImageIcon("grafika/autorzy_najazd.png"));
            }
        });


        autorzy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                autorzy.setIcon(new ImageIcon("grafika/autorzy.png"));
            }
        });

        // instruckja akcje

        instrukcja.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    panel.removeAll();
                    panel.add(tytul);
                    JLabel instrukcja = new JLabel();
                    instrukcja.setIcon(new ImageIcon("grafika/instrukcja_strona.png"));
                    instrukcja.setBounds(0, 0, 800, 800);
                    panel.add(instrukcja);
                    panel.add(powrot);
                    panel.revalidate();
                    panel.repaint();
                }

            }
        });

        instrukcja.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                instrukcja.setIcon(new ImageIcon("grafika/instrukcja_klik.png") {
                });
            }
        });


        instrukcja.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                instrukcja.setIcon(new ImageIcon("grafika/instrukcja.png"));
            }
        });


        instrukcja.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                instrukcja.setIcon(new ImageIcon("grafika/instrukcja_najazd.png"));
            }
        });


        instrukcja.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                instrukcja.setIcon(new ImageIcon("grafika/instrukcja.png"));
            }
        });

        //exit akcje

        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    System.exit(0);
                }
            }
        });

        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                exit.setIcon(new ImageIcon("grafika/Wyjscie_klik.png") {
                });
            }
        });


        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                exit.setIcon(new ImageIcon("grafika/Wyjscie.png"));
            }
        });


        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                exit.setIcon(new ImageIcon("grafika/Wyjscie_najazd.png"));
            }
        });


        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                exit.setIcon(new ImageIcon("grafika/Wyjscie.png"));
            }
        });

        //powrot akcje


        powrot.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        panel.removeAll();
                        panel.add(nowaGra);
                        panel.add(zasady);
                        panel.add(tytul);
                        panel.add(ustawienia);
                        panel.add(autorzy);
                        panel.add(instrukcja);
                        panel.add(exit);
                        panel.revalidate();
                        panel.repaint();
                    }
                }


            }
        });


        powrot.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                powrot.setIcon(new ImageIcon("grafika/powrót_klik.png"));
            }
        });


        powrot.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                powrot.setIcon(new ImageIcon("grafika/powrot.png"));
            }
        });

        powrot.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                powrot.setIcon(new ImageIcon("grafika/powrót_najazd.png"));
            }
        });

        powrot.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                powrot.setIcon(new ImageIcon("grafika/powrot.png"));
            }
        });

        //muza

        try {
            File f = new File("mechanika/muzyczka.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(f);
            clip = AudioSystem.getClip();
            clip.open(ais);
            FloatControl vol = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volume = vol;
            switch (glosnosc) {
                case 1:
                    volume.setValue(-30f);
                    break;
                case 2:
                    volume.setValue(-20f);
                    break;
                case 3:
                    volume.setValue(-10f);
                    break;
                case 4:
                    volume.setValue(0f);
                    break;
                case 5:
                    volume.setValue(6f);
                    break;
                default:
                    break;
            }
            if (dzwiek == 1) clip.loop(Clip.LOOP_CONTINUOUSLY);


        } catch (Exception exception) {
            new Blad(exception);
            return;
        }


        //KONIEC
        panel.add(nowaGra);
        panel.add(tytul);
        panel.add(zasady);
        panel.add(ustawienia);
        panel.add(autorzy);
        panel.add(instrukcja);
        panel.add(exit);

        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Akari();
    }
}
