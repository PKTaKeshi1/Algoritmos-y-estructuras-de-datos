import javax.swing.*;
import java.awt.*;

public class PythagorasTree extends JPanel {
    private int profundidad;

    public PythagorasTree(int profundidad) {
        this.profundidad = profundidad;
        setPreferredSize(new Dimension(800, 800));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setColor(Color.GREEN);

        // Llamada inicial para la recursión
        trazaArbol(g2d, 350, 600, 100, -90, profundidad);
    }

    private void trazaArbol(Graphics2D g, int x, int y, int lado, double angulo, int nivel) {
        if (nivel == 0 || lado < 2) return;

        int x2 = x + (int) (lado * Math.cos(Math.toRadians(angulo)));
        int y2 = y + (int) (lado * Math.sin(Math.toRadians(angulo)));

        g.drawLine(x, y, x2, y2);

        int nuevoLado = (int) (lado * 0.7);

        // Rama izquierda
        trazaArbol(g, x2, y2, nuevoLado, angulo - 45, nivel - 1);

        // Rama derecha
        trazaArbol(g, x2, y2, nuevoLado, angulo + 45, nivel - 1);
    }

    public class Main {
        public static void main(String[] args) {
            // Creamos la ventana principal
            JFrame ventana = new JFrame("Árbol de Pitágoras");
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
            // Creamos el panel con la profundidad deseada
            PythagorasTree arbol = new PythagorasTree(8); // Puedes cambiar la profundidad
    
            // Agregamos el panel al JFrame
            ventana.add(arbol);
            ventana.pack(); // Ajusta el tamaño según el panel
            ventana.setLocationRelativeTo(null); // Centra la ventana
            ventana.setVisible(true); // La hace visible
        }
    }
 
}