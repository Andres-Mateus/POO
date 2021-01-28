package juegodados;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GUI_Juego extends JFrame{
    private JPanel panel_1, panel_2;
    private JLabel titulo, et_usuario, nom_usuario, et_credito, et_monto, et_resultado, et_ndado, et_recompensa, et_bono, et_muestra; 
    private JButton bt_tirar, bt_terminarjg;
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
        ColocarBotones();
    }
    
    public void ColocarEtiquetas(){
        titulo = new JLabel("*Juego de los Dados*");
        titulo.setOpaque(true);
        titulo.setBackground(Color.white);
        titulo.setFont(new Font("arial",Font.BOLD,30));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBounds(70, 20, 350, 60);
        panel_1.add(titulo); 
        
        et_usuario = new JLabel("Usuario: ");
        et_usuario.setOpaque(true);
        et_usuario.setBackground(Color.LIGHT_GRAY);
        et_usuario.setFont(new Font("arial",Font.BOLD,20));
        et_usuario.setBounds(15, 100, 88, 20);
        panel_1.add(et_usuario);
        
        nom_usuario = new JLabel("NINGUNO");
        nom_usuario.setOpaque(true);
        nom_usuario.setBackground(Color.white);
        nom_usuario.setFont(new Font("arial",Font.BOLD,17));
        nom_usuario.setHorizontalAlignment(SwingConstants.CENTER);
        nom_usuario.setBounds(110, 100, 150, 20);
        panel_1.add(nom_usuario); 
        
        et_credito = new JLabel("Créditos: ");
        et_credito.setOpaque(true);
        et_credito.setBackground(Color.LIGHT_GRAY);
        et_credito.setFont(new Font("arial",Font.BOLD,20));
        et_credito.setBounds(15, 130, 95, 20);
        panel_1.add(et_credito);
        
        et_monto = new JLabel("0");
        et_monto.setOpaque(true);
        et_monto.setBackground(Color.white);
        et_monto.setFont(new Font("arial",Font.BOLD,20));
        et_monto.setHorizontalAlignment(SwingConstants.CENTER);
        et_monto.setBounds(110, 130, 150, 20);
        panel_1.add(et_monto); 
        
        et_resultado = new JLabel("RESULTADO");
        et_resultado.setOpaque(true);
        et_resultado.setBackground(Color.LIGHT_GRAY);
        et_resultado.setFont(new Font("arial",Font.BOLD,20));
        et_resultado.setBounds(70, 185, 130, 21);
        panel_1.add(et_resultado);
        
        et_ndado = new JLabel("0");
        et_ndado.setOpaque(true);
        et_ndado.setBackground(Color.white);
        et_ndado.setFont(new Font("arial",Font.BOLD,20));
        et_ndado.setHorizontalAlignment(SwingConstants.CENTER);
        et_ndado.setBounds(56, 216, 150, 30);
        panel_1.add(et_ndado);
        
        et_recompensa = new JLabel("RECOMPENSA");
        et_recompensa.setOpaque(true);
        et_recompensa.setBackground(Color.LIGHT_GRAY);
        et_recompensa.setFont(new Font("arial",Font.BOLD,20));
        et_recompensa.setBounds(280, 185, 140, 21);
        panel_1.add(et_recompensa);
        
        et_bono = new JLabel("0");
        et_bono.setOpaque(true);
        et_bono.setBackground(Color.white);
        et_bono.setFont(new Font("arial",Font.BOLD,20));
        et_bono.setHorizontalAlignment(SwingConstants.CENTER);
        et_bono.setBounds(274, 216, 150, 30);
        panel_1.add(et_bono);
        
        et_muestra = new JLabel("**!GANASTE¡**");
        et_muestra.setOpaque(true);
        et_muestra.setBackground(Color.white);
        et_muestra.setFont(new Font("arial",Font.BOLD,30));
        et_muestra.setHorizontalAlignment(SwingConstants.CENTER);
        et_muestra.setBounds(90, 257, 320, 40);
        panel_1.add(et_muestra); 
    }
    
    public void ColocarBotones(){
        BotonTirar();
        BotonTerminarJuego();
    }
    
    public void BotonTirar(){
        bt_tirar = new JButton();
        bt_tirar.setText("TIRAR");
        bt_tirar.setLayout(null);
        bt_tirar.setBounds(185, 315, 130, 45);
        bt_tirar.setFont(new Font("arial",Font.BOLD, 15));
        bt_tirar.setForeground(Color.black);
        bt_tirar.setBackground(Color.white);
        panel_1.add(bt_tirar);
    }
    public void BotonTerminarJuego(){
        bt_terminarjg = new JButton();
        bt_terminarjg.setText("TERMINAR");
        bt_terminarjg.setLayout(null);
        bt_terminarjg.setBounds(348, 408, 130, 45);
        bt_terminarjg.setFont(new Font("arial",Font.BOLD, 15));
        bt_terminarjg.setForeground(Color.black);
        bt_terminarjg.setBackground(Color.white);
        panel_1.add(bt_terminarjg);
    }
}
