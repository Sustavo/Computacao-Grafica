import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Camera camera = new Camera(500,500,500,500,new Vetor(0,0,500));
        JFrame window = new JFrame();
        window.setSize(new Dimension(500, 500));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        window.setFocusable(true);

        Tela canvas = new Tela(500,500);
        canvas.setPreferredSize(new Dimension(500, 500));

        Esfera esfera = new Esfera(500, new Vetor(0,0,-1000));

        double w = camera.wJanela;
        double h = camera.hJanela;

        double deltax = w / camera.linhas;
        double deltay = h / camera.colunas;

        for (int l = 0; l < camera.linhas; l++) {
            double y = h / 2 - deltay / 2 - deltay * l;
            for (int c = 0; c < camera.colunas; c++) {
                double x = w / 2 - deltax / 2 - deltax * c;
                Vetor p0 = new Vetor(x,y,0);
                Vetor direcao = p0.Subtracao(camera.foco).Unitario();
                if (esfera.Colidir(p0,direcao)) {
                    canvas.buffer[l][c] = new Vetor(1,0,0);
                }


            }
        }

        window.add(canvas, BorderLayout.NORTH);

        window.setVisible(true);
    }
}