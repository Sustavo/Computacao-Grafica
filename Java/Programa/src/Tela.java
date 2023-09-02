import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

import java.awt.Graphics2D;
import javax.swing.JPanel;
public class Tela extends JPanel {

    public Vetor[][] buffer;
    double linhas;
    double colunas;

    Tela(double linhas, double colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.gerarBuffer();
    }

    public Tela gerarBuffer() {
        buffer = new Vetor[(int)linhas][(int)colunas];
        for (int i = 0; i < linhas; i++)
            for (int j = 0; j < linhas; j++)
                buffer[i][j] = new Vetor(100.0/255.0, 100.0/255.0, 100.0/255.0);
        return this;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                drawPixel(image, i, j);
            }
        }

        g.drawImage(image, 0, 0, null);
    }

    void drawPixel(BufferedImage image, int i, int j) {
        int hsize = (int) Math.round((double) getHeight() / linhas);
        int wsize = (int) Math.round((double) getWidth() / colunas);
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(getCor(i, j));
        g2d.fillRect(i * wsize, j * hsize, wsize, hsize);
        g2d.dispose();
    }

    Color getCor(int i, int j) {
        return buffer[i][j].getCor();
    }

}