package juegodados;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GUI_Juego extends JFrame{
    private JPanel panel_1;
    private JPanel panel_2;
    private JLabel etiqueta1; 
    
    public GUI_Juego (){
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("JUEGO DE DADOS");
        this.setMinimumSize(new Dimension(500,500));
        this.setMaximumSize(new Dimension(500,500));
        PonerPaneles();
    }
    public void PonerPaneles(){
        panel_1 = new JPanel();
        panel_1.setBackground(Color.LIGHT_GRAY);
        this.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        ColocarEtiquetas();
    }
    
    public void ColocarEtiquetas(){
        etiqueta1 = new JLabel();
        etiqueta1.setText("GANADOR");
        etiqueta1.setOpaque(true);
        etiqueta1.setSize(250, 80);
        etiqueta1.setBackground(Color.white);
        etiqueta1.setFont(new Font("arial",Font.BOLD,50));
        etiqueta1.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta1.setBounds(120, 20, 250, 80);
        panel_1.add(etiqueta1); 
    }
}
