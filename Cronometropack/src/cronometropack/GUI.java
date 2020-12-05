
package cronometropack;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.Timer;

class Main {
  public static void main(String[] args) {
    GUI ventana1 = new GUI();
    ventana1.setVisible(true);
  }
}
public class GUI extends JFrame{
       private JPanel panel;
       private JLabel etiqueta;
       private JButton Botoniniciar;
       private JButton Botonparar;
       private JButton Botonrestaurar;
       private static String texto;
       Cronometro crono = new Cronometro();
       
   public GUI(){
       this.setSize(500, 500);
       this.setLocationRelativeTo(null);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.setTitle("EL MEJOR CRONOMETRO");
       this.setMinimumSize (new Dimension(200, 200));
       PonerComponentes();
   }

    public static void setTexto(String texto) {
        GUI.texto = texto;
    }
   
   
   private void PonerComponentes(){
       panel = new JPanel();
       panel.setBackground(Color.lightGray);
       this.add(panel);
       panel.setLayout(null);
       colocarEtiqueta();
       colocarBoton();
   }
  
   private void colocarEtiqueta(){
       etiqueta = new JLabel("0 : 0 : 0");
       etiqueta.setOpaque(true);
       etiqueta.setSize(250, 80);
       etiqueta.setBackground(Color.white);
       etiqueta.setFont(new Font("arial",Font.BOLD,50));
       etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
       etiqueta.setBounds(120, 20, 250, 80);
       panel.add(etiqueta);
   }
  
   private void colocarBoton(){
   BotonIniciar();
   BotonParar();
   BotonRestaurar();
   }
   private void BotonIniciar(){
    Botoniniciar = new JButton("INICIAR");
    Botoniniciar.setLayout(null);
    Botoniniciar.setBounds(25, 150, 130, 50);
    Botoniniciar.setFont(new Font("arial", 1, 15));
    Botoniniciar.setBackground(Color.WHITE);
    panel.add(Botoniniciar);  
    
    ActionListener oyenteAccion = new ActionListener(){
        
        @Override
        public void actionPerformed(ActionEvent e){
            Botoniniciar.setEnabled(false);
            Botonparar.setEnabled(true);
            Botonrestaurar.setEnabled(false);
            tiempo.start();
            }
        };
    Botoniniciar.addActionListener(oyenteAccion);
   }
   
    private void BotonParar(){
    Botonparar = new JButton("PARAR");
    
    Botonparar.setLayout(null);
    Botonparar.setBounds(185, 150, 130, 50);
    Botonparar.setFont(new Font("arial", 1, 15));
    Botonparar.setBackground(Color.WHITE);
    Botonparar.setEnabled(false);
    panel.add(Botonparar);  
    
    ActionListener oyenteAccion2 = new ActionListener(){
        
        @Override
        public void actionPerformed(ActionEvent e){
            Botoniniciar.setEnabled(true);
            Botonparar.setEnabled(false);
            Botonrestaurar.setEnabled(true);
            tiempo.stop();
            }
        };
    Botonparar.addActionListener(oyenteAccion2);
   }
    
   private void BotonRestaurar(){
    Botonrestaurar = new JButton("RESTAURAR");
    Botonrestaurar.setLayout(null);
    Botonrestaurar.setBounds(340, 150, 130, 50);
    Botonrestaurar.setFont(new Font("arial", 1, 15));
    Botonrestaurar.setBackground(Color.WHITE);
    Botonrestaurar.setEnabled(false);
    panel.add(Botonrestaurar);  
    
    ActionListener oyenteAccion3 = new ActionListener(){
        
        @Override
        public void actionPerformed(ActionEvent e){
            Botoniniciar.setEnabled(true);
            Botonparar.setEnabled(false);
            Botonrestaurar.setEnabled(false);
            crono.resetear();
            etiqueta.setText(texto);
            }
        };
    Botonrestaurar.addActionListener(oyenteAccion3);
    
   }
   
   Timer tiempo = new Timer(1000, new ActionListener(){
       @Override
    public void actionPerformed(ActionEvent e) {
       crono.iniciar();
       etiqueta.setText(texto);
      }
   });
}