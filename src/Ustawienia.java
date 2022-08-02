import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;


public class Ustawienia {

    public Ustawienia(Grafika panel, JLabel powrot) {

        panel.removeAll();

        JLabel ustawienia = new JLabel();
        ustawienia.setIcon(new ImageIcon("grafika/ustawienia_strona.png"));
        ustawienia.setBounds(0, 0, 800, 800);

        JLabel tytul = new JLabel();
        tytul.setIcon(new ImageIcon("grafika/napis_akari.png"));
        tytul.setBounds(0, 0, 800, 800);

        JLabel motyw1 = new JLabel();
        if (Akari.motyw == 1) motyw1.setIcon(new ImageIcon("grafika/motyw_glowny_klik.png"));
        else motyw1.setIcon(new ImageIcon("grafika/motyw_glowny.png"));
        motyw1.setBounds(416, 586, 100, 100);

        JLabel motyw2 = new JLabel();
        if (Akari.motyw == 2) motyw2.setIcon(new ImageIcon("grafika/motyw_niebieski_klik.png"));
        else motyw2.setIcon(new ImageIcon("grafika/motyw_niebieski.png"));
        motyw2.setBounds(543, 586, 100, 100);

        JLabel motyw3 = new JLabel();
        if (Akari.motyw == 3) motyw3.setIcon(new ImageIcon("grafika/motyw_teczowy_klik.png"));
        else motyw3.setIcon(new ImageIcon("grafika/motyw_teczowy.png"));
        motyw3.setBounds(670, 586, 100, 100);

        JLabel glosik = new JLabel();
        if (Akari.dzwiek == 1) glosik.setIcon(new ImageIcon("grafika/glosnik.png"));
        else glosik.setIcon(new ImageIcon("grafika/glosnikNIE.png"));
        glosik.setBounds(550, 470, 100, 100);

        JLabel pasek = new JLabel();
        pasek.setIcon(new ImageIcon("grafika/pasek_głośność.png"));
        pasek.setBounds(424, 372, 300, 50);

        JLabel minus = new JLabel();
        minus.setIcon(new ImageIcon("grafika/minus.png"));
        minus.setBounds(370, 370, 50, 50);

        JLabel plus = new JLabel();
        plus.setIcon(new ImageIcon("grafika/plus.png"));
        plus.setBounds(728, 370, 50, 50);

        JLabel suwak = new JLabel();
        suwak.setIcon(new ImageIcon("grafika/suwak.png"));
        switch (Akari.glosnosc) {
            case 1:
                suwak.setBounds(450, 362, 10, 70);
                break;
            case 2:
                suwak.setBounds(510, 362, 10, 70);
                break;
            case 3:
                suwak.setBounds(570, 362, 10, 70);
                break;
            case 4:
                suwak.setBounds(630, 362, 10, 70);
                break;
            case 5:
                suwak.setBounds(690, 362, 10, 70);
                break;
            default:
                break;
        }

        JLabel zapisz = new JLabel();
        zapisz.setIcon(new ImageIcon("grafika/zapiszUstawienia.png"));
        zapisz.setBounds(20, 725, 100, 50);

        JLabel potwierdzenie = new JLabel();
        potwierdzenie.setIcon(new ImageIcon("grafika/zapisano.png"));
        potwierdzenie.setBounds(140, 725, 300, 50);
        potwierdzenie.setVisible(false);


        zapisz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                zapisz.setIcon(new ImageIcon("grafika/zapiszUstawienia_najazd.png"));
            }
        });

        zapisz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                zapisz.setIcon(new ImageIcon("grafika/zapiszUstawienia.png"));
            }
        });

        zapisz.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                zapisz.setIcon(new ImageIcon("grafika/zapiszUstawienia_klik.png"));
            }
        });

        zapisz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                zapisz.setIcon(new ImageIcon("grafika/zapiszUstawienia.png"));
            }
        });

        zapisz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    try {
                        FileWriter myWriter = new FileWriter("mechanika/ustawienia.txt");
                        myWriter.write(Akari.glosnosc + "\n");
                        myWriter.write(Akari.dzwiek + "\n");
                        myWriter.write(Akari.motyw + "\n");
                        myWriter.close();
                        potwierdzenie.setVisible(true);
                        Timer timer = new Timer(1000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent arg0) {
                                potwierdzenie.setVisible(false);
                            }
                        });
                        timer.setRepeats(false);
                        timer.start();
                    } catch (Exception err) {
                        err.printStackTrace();
                        new Blad(err);
                        return;
                    }
                }

            }
        });


        motyw1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (Akari.motyw != 1) motyw1.setIcon(new ImageIcon("grafika/motyw_glowny_najazd.png"));
            }
        });

        motyw1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (Akari.motyw != 1) motyw1.setIcon(new ImageIcon("grafika/motyw_glowny.png"));
            }
        });

        motyw1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    Akari.motyw = 1;
                    motyw1.setIcon(new ImageIcon("grafika/motyw_glowny_klik.png"));
                    motyw2.setIcon(new ImageIcon("grafika/motyw_niebieski.png"));
                    motyw3.setIcon(new ImageIcon("grafika/motyw_teczowy.png"));
                }

            }
        });

        motyw2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (Akari.motyw != 2) motyw2.setIcon(new ImageIcon("grafika/motyw_niebieski_najazd.png"));
            }
        });

        motyw2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (Akari.motyw != 2) motyw2.setIcon(new ImageIcon("grafika/motyw_niebieski.png"));
            }
        });

        motyw2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    Akari.motyw = 2;
                    motyw1.setIcon(new ImageIcon("grafika/motyw_glowny.png"));
                    motyw2.setIcon(new ImageIcon("grafika/motyw_niebieski_klik.png"));
                    motyw3.setIcon(new ImageIcon("grafika/motyw_teczowy.png"));
                }

            }
        });

        motyw3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (Akari.motyw != 3) motyw3.setIcon(new ImageIcon("grafika/motyw_teczowy_najazd.png"));
            }
        });

        motyw3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (Akari.motyw != 3) motyw3.setIcon(new ImageIcon("grafika/motyw_teczowy.png"));
            }
        });


        motyw3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    Akari.motyw = 3;
                    motyw1.setIcon(new ImageIcon("grafika/motyw_glowny.png"));
                    motyw2.setIcon(new ImageIcon("grafika/motyw_niebieski.png"));
                    motyw3.setIcon(new ImageIcon("grafika/motyw_teczowy_klik.png"));
                }

            }
        });

        glosik.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (Akari.dzwiek == 0) glosik.setIcon(new ImageIcon("grafika/glosnikNIE_najazd.png"));
                else glosik.setIcon(new ImageIcon("grafika/glosnik_najazd.png"));

            }
        });

        glosik.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (Akari.dzwiek == 1) glosik.setIcon(new ImageIcon("grafika/glosnik.png"));
                else glosik.setIcon(new ImageIcon("grafika/glosnikNIE.png"));
            }
        });

        glosik.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (Akari.dzwiek == 1) {
                        glosik.setIcon(new ImageIcon("grafika/glosnikNIE.png"));
                        Akari.clip.stop();
                        Akari.dzwiek = 0;
                    } else {
                        glosik.setIcon(new ImageIcon("grafika/glosnik.png"));
                        Akari.clip.loop(Clip.LOOP_CONTINUOUSLY);
                        Akari.dzwiek = 1;
                    }
                }

            }
        });


        plus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (Akari.glosnosc < 5) Akari.glosnosc++;
                    switch (Akari.glosnosc) {
                        case 1:
                            Akari.volume.setValue(-30f);
                            suwak.setBounds(450, 362, 10, 70);
                            break;
                        case 2:
                            Akari.volume.setValue(-20f);
                            suwak.setBounds(510, 362, 10, 70);
                            break;
                        case 3:
                            Akari.volume.setValue(-10f);
                            suwak.setBounds(570, 362, 10, 70);
                            break;
                        case 4:
                            Akari.volume.setValue(0f);
                            suwak.setBounds(630, 362, 10, 70);
                            break;
                        case 5:
                            Akari.volume.setValue(6f);
                            suwak.setBounds(690, 362, 10, 70);
                            break;
                        default:
                            break;
                    }
                }

            }
        });

        minus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (Akari.glosnosc > 0) Akari.glosnosc--;
                    switch (Akari.glosnosc) {
                        case 1:
                            Akari.volume.setValue(-30f);
                            suwak.setBounds(450, 362, 10, 70);
                            break;
                        case 2:
                            Akari.volume.setValue(-20f);
                            suwak.setBounds(510, 362, 10, 70);
                            break;
                        case 3:
                            Akari.volume.setValue(-10f);
                            suwak.setBounds(570, 362, 10, 70);
                            break;
                        case 4:
                            Akari.volume.setValue(0f);
                            suwak.setBounds(630, 362, 10, 70);
                            break;
                        case 5:
                            Akari.volume.setValue(6f);
                            suwak.setBounds(690, 362, 10, 70);
                            break;
                        default:
                            break;
                    }
                }

            }
        });

        panel.add(potwierdzenie);
        panel.add(zapisz);
        panel.add(plus);
        panel.add(minus);
        panel.add(suwak);
        panel.add(pasek);
        panel.add(glosik);
        panel.add(motyw1);
        panel.add(motyw2);
        panel.add(motyw3);
        panel.add(tytul);
        panel.add(powrot);
        panel.add(ustawienia);
        panel.revalidate();
        panel.repaint();

    }
}
