import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import javax.imageio.ImageIO;


public class Grafika extends JPanel {
    private BufferedImage intersectionImage;

    public Grafika(String path) {
        try {
            intersectionImage = ImageIO.read(new File(path));
        } catch (Exception e) {
            new Blad(e);
            return;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (intersectionImage != null) {
            g.drawImage(intersectionImage, 0, 0, this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (intersectionImage != null) {
            int width = intersectionImage.getWidth();
            int height = intersectionImage.getHeight();
            return new Dimension(width, height);
        }
        return super.getPreferredSize();
    }

}


