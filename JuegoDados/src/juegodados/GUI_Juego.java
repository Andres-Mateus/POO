package juegodados;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.*;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;

class Main {
    public static void main(String[] args) {
        GUI_Juego ventana1 = new GUI_Juego();
        ventana1.setVisible(true);
    }
}
public class GUI_Juego extends JFrame{
    public Panel panel_1, panel_2, panel_3, panel_4;
    private JButton bt_ingresar, bt_registro, bt_ingresar2, bt_registro2, bt_volver;
    Registro registro_us = new Registro();
    
    Jugador jugador1 = new Jugador("", "", 0);
    Juego dado1 = new Dado(0, jugador1, 0);
    
    public GUI_Juego (){
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("JUEGO DE DADOS");
        this.setResizable(false);
        registro_us.comprobararchivo();
        PonerPaneles();
        
        EventoVentana oyenteventana = new EventoVentana();
        this.addWindowListener(oyenteventana);
    }

    public Panel getPanel_1() {
        return panel_1;
    }

    public void setPanel_1(Panel panel_1) {
        this.panel_1 = panel_1;
    }

    public Panel getPanel_2() {
        return panel_2;
    }

    public void setPanel_2(Panel panel_2) {
        this.panel_2 = panel_2;
    }

    public Panel getPanel_3() {
        return panel_3;
    }

    public void setPanel_3(Panel panel_3) {
        this.panel_3 = panel_3;
    }

    public Panel getPanel_4() {
        return panel_4;
    }

    public void setPanel_4(Panel panel_4) {
        this.panel_4 = panel_4;
    }

    
    
    public void PonerPaneles(){
        
        panelregistro();
        paneljuego();
        panelingreso();
        panelinicio();
        visibilidadinicial();
    }
    
    public void paneljuego(){
        panel_1 = new Panel();
        panel_1.setBackground(Color.LIGHT_GRAY);
        panel_1.setLayout(null);
        panel_1.ColocarEtiquetasP1();
        panel_1.ColocarBotonesP1();
        this.add(panel_1);
    }
    public void panelinicio(){
        panel_2 = new Panel();
        panel_2.setBackground(Color.LIGHT_GRAY);
        panel_2.setLayout(null);
        panel_2.ColocarEtiquetasP2();
        panel_2.ColocarBotonesP2();
        this.add(panel_2);
    }
    public void panelregistro(){
        panel_3 = new Panel();
        panel_3.setBackground(Color.LIGHT_GRAY);
        panel_3.setLayout(null);
        panel_3.ColocarEtiquetasP3();
        panel_3.ColocarBotonesP3();
        this.add(panel_3);
    }
    
    public void panelingreso(){
        panel_4 = new Panel();
        panel_4.setBackground(Color.LIGHT_GRAY);
        panel_4.setLayout(null);
        panel_4.ColocarEtiquetasP4();
        panel_4.ColocarBotonesP4();
        this.add(panel_4);
    }
    
    public void visibilidadinicial(){
        panel_2.setVisible(true);
        panel_4.setVisible(false);
        panel_1.setVisible(false);
        panel_3.setVisible(false);
    }
    
    public void CambioPanel(int numpanel){
        if(numpanel==1){
            panel_2.setVisible(false);
            panel_4.setVisible(true);
            this.add(panel_4);
            this.validate();
        }else if(numpanel==2){
            panel_4.setVisible(false);
            panel_1.setVisible(true);
            paneljuego();
            this.validate();
        }else if(numpanel==3){
            panel_2.setVisible(false);
            panel_3.setVisible(true);
            this.add(panel_3);
            this.validate();
        }else if(numpanel==4){
            panel_3.setVisible(false);
            panel_4.setVisible(true);
            this.add(panel_4);
            this.validate();
        }else if(numpanel==5){
            panel_4.setVisible(false);
            panel_2.setVisible(true);
            this.add(panel_2);
            this.validate();
        }else if(numpanel==6){
            panel_3.setVisible(false);
            panel_2.setVisible(true);
            this.add(panel_2);
            this.validate();
        }
    }
    
    class Panel extends JPanel implements ActionListener{
        
        private JLabel nom_usuario; 
        private JLabel et_monto = new JLabel("0");        
        private JLabel titulo, et_usuario, et_credito, et_resultado, et_ndado, et_recompensa, et_bono, et_muestra; 
        private JLabel titulo2, titulo3, titulo4, et_usuario2, et_credito2, et_usuario3;
        private JLabel et_ordeningreso ,et_ordenregistro, et_contrasena, et_contrasena2;
        private JButton bt_tirar, bt_terminarjg,bt_volver;
        private JTextField txt_usuario, txt_credito, txt_usuario2, txt_apuesta, txt_contrasena, txt_contrasena2;
        private JTextArea txtmuestra;
        
        
        Direccionar cambiar = new Direccionar();
        EventoTeclado tecla = new EventoTeclado();
        
        public void ColocarEtiquetasP1(){
            titulo = new JLabel("*JUEGO DE LOS DADOS*");
            titulo.setOpaque(true);
            titulo.setBackground(Color.white);
            titulo.setFont(new Font("arial",Font.BOLD,30));
            titulo.setHorizontalAlignment(SwingConstants.CENTER);
            titulo.setBounds(65, 10, 370, 60);
            this.add(titulo);

            et_usuario = new JLabel("Usuario: ");
            et_usuario.setOpaque(true);
            et_usuario.setBackground(Color.LIGHT_GRAY);
            et_usuario.setFont(new Font("arial",Font.BOLD,20));
            et_usuario.setBounds(15, 90, 88, 20);
            this.add(et_usuario);
            
            
            nom_usuario = new JLabel();
            nom_usuario.setText(jugador1.getNombre());
            nom_usuario.setOpaque(true);
            nom_usuario.setBackground(Color.white);
            nom_usuario.setFont(new Font("arial",Font.BOLD,17));
            nom_usuario.setHorizontalAlignment(SwingConstants.CENTER);
            nom_usuario.setBounds(110, 90, 150, 20);
            this.add(nom_usuario); 
            
            
            et_credito = new JLabel("Créditos: ");
            et_credito.setOpaque(true);
            et_credito.setBackground(Color.LIGHT_GRAY);
            et_credito.setFont(new Font("arial",Font.BOLD,20));
            et_credito.setBounds(15, 120, 95, 20);
            this.add(et_credito);

            et_monto.setText(Integer.toString(jugador1.getCredito()));
            et_monto.setOpaque(true);
            et_monto.setBackground(Color.white);
            et_monto.setFont(new Font("arial",Font.BOLD,20));
            et_monto.setHorizontalAlignment(SwingConstants.CENTER);
            et_monto.setBounds(110, 120, 150, 20);
            this.add(et_monto); 

            txtmuestra = new JTextArea("");
            txtmuestra.setBounds(10, 145, 340, 110);
            txtmuestra.setBackground(Color.LIGHT_GRAY);
            txtmuestra.setFont(new Font("times new roman",Font.BOLD, 16));
            String texto="¡BIENVENIDO al juego de los dados!\n"
                    + "Ingrese la cantidad de dinero a apostar.\n"
                      + "Cuando termine presione Enter.";
            txtmuestra.setText(texto);
            this.add(txtmuestra);

            txt_apuesta = new JTextField();
            txt_apuesta.setBounds(360, 162, 100, 38);

            txt_apuesta.addKeyListener(tecla);
            this.add(txt_apuesta);


            et_resultado = new JLabel("RESULTADO");
            et_resultado.setOpaque(true);
            et_resultado.setBackground(Color.LIGHT_GRAY);
            et_resultado.setFont(new Font("arial",Font.BOLD,20));
            et_resultado.setBounds(70, 265, 130, 21);
            this.add(et_resultado);

            et_ndado = new JLabel("0");
            et_ndado.setOpaque(true);
            et_ndado.setBackground(Color.white);
            et_ndado.setFont(new Font("arial",Font.BOLD,20));
            et_ndado.setHorizontalAlignment(SwingConstants.CENTER);
            et_ndado.setBounds(56, 296, 150, 30);
            this.add(et_ndado);

            et_recompensa = new JLabel("RECOMPENSA");
            et_recompensa.setOpaque(true);
            et_recompensa.setBackground(Color.LIGHT_GRAY);
            et_recompensa.setFont(new Font("arial",Font.BOLD,20));
            et_recompensa.setBounds(280, 265, 140, 21);
            this.add(et_recompensa);

            et_bono = new JLabel("0");
            et_bono.setOpaque(true);
            et_bono.setBackground(Color.white);
            et_bono.setFont(new Font("arial",Font.BOLD,20));
            et_bono.setHorizontalAlignment(SwingConstants.CENTER);
            et_bono.setBounds(274, 296, 150, 30);
            this.add(et_bono);

            et_muestra = new JLabel("");
            et_muestra.setOpaque(true);
            et_muestra.setBackground(Color.white);
            et_muestra.setFont(new Font("arial",Font.BOLD,30));
            et_muestra.setHorizontalAlignment(SwingConstants.CENTER);
            et_muestra.setBounds(90, 337, 320, 40);
            this.add(et_muestra); 
        }

        public void ColocarEtiquetasP2(){
            titulo2 = new JLabel("JUEGO DE LOS DADOS");
            titulo2.setOpaque(true);
            titulo2.setBackground(Color.white);
            titulo2.setFont(new Font("arial",Font.BOLD,30));
            titulo2.setHorizontalAlignment(SwingConstants.CENTER);
            titulo2.setBounds(70, 20, 350, 60);
            this.add(titulo2);    
        }

        public void ColocarEtiquetasP3(){
            titulo3 = new JLabel("REGISTRO");
            titulo3.setOpaque(true);
            titulo3.setBackground(Color.white);
            titulo3.setFont(new Font("arial",Font.BOLD,30));
            titulo3.setHorizontalAlignment(SwingConstants.CENTER);
            titulo3.setBounds(70, 20, 350, 60);
            this.add(titulo3);

            et_usuario2 = new JLabel("Usuario");
            et_usuario2.setOpaque(true);
            et_usuario2.setBackground(Color.LIGHT_GRAY);
            et_usuario2.setFont(new Font("arial",Font.BOLD,23));
            et_usuario2.setForeground(Color.black);
            et_usuario2.setBounds(35, 110, 88, 20);
            this.add(et_usuario2);

            txt_usuario = new JTextField();
            txt_usuario.setBounds(180, 110, 140, 38);

            txt_usuario.addKeyListener(tecla);
            this.add(txt_usuario);
            
            et_contrasena2 = new JLabel("Contraseña");
            et_contrasena2.setOpaque(true);
            et_contrasena2.setBackground(Color.LIGHT_GRAY);
            et_contrasena2.setFont(new Font("arial",Font.BOLD,23));
            et_contrasena2.setForeground(Color.black);
            et_contrasena2.setBounds(35, 163, 130, 30);
            this.add(et_contrasena2);

            txt_contrasena2 = new JTextField();
            txt_contrasena2.setBounds(180, 163, 140, 38);
            txt_contrasena2.setEnabled(false);

            txt_contrasena2.addKeyListener(tecla);
            this.add(txt_contrasena2);
            
            et_credito2 = new JLabel("Creditos");
            et_credito2.setOpaque(true);
            et_credito2.setBackground(Color.LIGHT_GRAY);
            et_credito2.setFont(new Font("arial",Font.BOLD,23));
            et_credito2.setForeground(Color.black);
            et_credito2.setBounds(35, 216, 95, 30);
            this.add(et_credito2);

            txt_credito = new JTextField();
            txt_credito.setBounds(180, 216, 140, 38);
            txt_credito.setEnabled(false);

            txt_credito.addKeyListener(tecla);
            this.add(txt_credito);
            
            et_ordenregistro = new JLabel("Después de ingresar un dato, presione ENTER");
            et_ordenregistro.setOpaque(true);
            et_ordenregistro.setBackground(Color.LIGHT_GRAY);
            et_ordenregistro.setFont(new Font("arial",Font.BOLD,16));
            et_ordenregistro.setForeground(Color.black);
            et_ordenregistro.setBounds(65, 340, 380, 40);
            this.add(et_ordenregistro);
        }

        public void ColocarEtiquetasP4(){
            titulo4 = new JLabel("INGRESO");
            titulo4.setOpaque(true);
            titulo4.setBackground(Color.white);
            titulo4.setFont(new Font("arial",Font.BOLD,30));
            titulo4.setHorizontalAlignment(SwingConstants.CENTER);
            titulo4.setBounds(70, 20, 350, 60);
            this.add(titulo4);

            et_usuario3 = new JLabel("Usuario");
            et_usuario3.setOpaque(true);
            et_usuario3.setBackground(Color.LIGHT_GRAY);
            et_usuario3.setFont(new Font("arial",Font.BOLD,23));
            et_usuario3.setForeground(Color.black);
            et_usuario3.setBounds(176, 120, 88, 20);
            this.add(et_usuario3);

            txt_usuario2 = new JTextField();
            txt_usuario2.setBounds(171, 150, 140, 38);

            txt_usuario2.addKeyListener(tecla);
            this.add(txt_usuario2);
            
            et_contrasena = new JLabel("Contraseña");
            et_contrasena.setOpaque(true);
            et_contrasena.setBackground(Color.LIGHT_GRAY);
            et_contrasena.setFont(new Font("arial",Font.BOLD,23));
            et_contrasena.setForeground(Color.black);
            et_contrasena.setBounds(176, 198, 130, 30);
            this.add(et_contrasena);

            txt_contrasena = new JTextField();
            txt_contrasena.setBounds(171, 235, 140, 38);
            txt_contrasena.setEnabled(false);

            txt_contrasena.addKeyListener(tecla);
            this.add(txt_contrasena);
            
            et_ordeningreso = new JLabel("Después de ingresar un dato, presione ENTER");
            et_ordeningreso.setOpaque(true);
            et_ordeningreso.setBackground(Color.LIGHT_GRAY);
            et_ordeningreso.setFont(new Font("arial",Font.BOLD,16));
            et_ordeningreso.setForeground(Color.black);
            et_ordeningreso.setBounds(65, 340, 380, 40);
            this.add(et_ordeningreso);
        }

        public void ColocarBotonesP1(){
            BotonTirar();
            BotonTerminarJuego();
        }

        public void BotonTirar(){
            bt_tirar = new JButton();
            bt_tirar.setText("TIRAR");
            bt_tirar.setLayout(null);
            bt_tirar.setBounds(185, 395, 130, 45);
            bt_tirar.setFont(new Font("arial",Font.BOLD, 15));
            bt_tirar.setForeground(Color.black);
            bt_tirar.setBackground(Color.white);
            bt_tirar.setEnabled(false);
            this.add(bt_tirar);

            
            bt_tirar.addActionListener(this);
        }

        public void actualizaretiquetas_p1(String usuario1, Jugador jugadortemp ){
            jugador1 = registro_us.buscardatos(usuario1, jugadortemp);
        }

        @Override
        public void actionPerformed(ActionEvent e){
              
              txtmuestra.setText("¡BIENVENIDO al juego de los dados!\n"
                    + "Ingrese la cantidad de dinero a apostar.\n"
                      + "Cuando termine presione Enter.");
              
              dado1.setJugador(jugador1);
              dado1.setCredito(jugador1.getCredito());
              dado1.jugar();
              
              if(dado1.getTxtAviso()!=""){
                  txtmuestra.setText(dado1.getTxtAviso());
                  nom_usuario.setText(jugador1.getNombre());
                  et_bono.setText(Integer.toString(dado1.getRecompensa()));
                  et_monto.setText(Integer.toString(jugador1.getCredito()));
                  et_muestra.setText("");
                  dado1.setRecompensa(0);
                  if(dado1.getResultado()==-1){
                    et_ndado.setText("0");
                    bt_tirar.setEnabled(false); 
                        if(Dado.getTirada()==4){
                            Dado.setTirada(0);
                            txt_apuesta.setEnabled(true); 
                      }
                  }
                  
                if(Dado.getTirada()==-2){
                   txtmuestra.setText(dado1.getTxtAviso());
                   Dado.setTirada(1);
                   et_ndado.setText(Integer.toString(dado1.getNumero()));
                   et_bono.setText("0");
                   bt_tirar.setEnabled(true); 
                   txt_apuesta.setEnabled(true);
                  }
                  
              }else{
                  txtmuestra.setText("¡BIENVENIDO al juego de los dados!\n"
                    + "Ingrese la cantidad de dinero a apostar.\n"
                      + "Cuando termine presione Enter.");
                  nom_usuario.setText(jugador1.getNombre());
                  et_ndado.setText(Integer.toString(dado1.getNumero()));
                  et_bono.setText(Integer.toString(dado1.getRecompensa()));
                  et_monto.setText(Integer.toString(jugador1.getCredito()));
                  et_muestra.setText(dado1.getTxtResultado());
                  
                  registro_us.actualizar_datos(jugador1.getNombre(), jugador1);
                  
                  dado1.setTxtAviso("");
                  dado1.setRecompensa(0);
                  Dado.setTirada(0);
                  txt_apuesta.setEnabled(true);
                  bt_tirar.setEnabled(false);
              }
              
              dado1.setTxtAviso("");    
        }

        public void BotonTerminarJuego(){
            bt_terminarjg = new JButton();
            bt_terminarjg.setText("TERMINAR");
            bt_terminarjg.setLayout(null);
            bt_terminarjg.setBounds(348, 408, 130, 45);
            bt_terminarjg.setFont(new Font("arial",Font.BOLD, 15));
            bt_terminarjg.setForeground(Color.black);
            bt_terminarjg.setBackground(Color.white);
            this.add(bt_terminarjg);

            Restaurar cerrarjg = new Restaurar();
            bt_terminarjg.addActionListener(cerrarjg);
        }

        public void ColocarBotonesP2(){
            BotonIngresar();
            BotonRegistrar();
            BotonTerminarJuego();
        }

        public void BotonIngresar(){
            bt_ingresar = new JButton();
            bt_ingresar.setText("INGRESAR");
            bt_ingresar.setLayout(null);
            bt_ingresar.setBounds(185, 170, 130, 46);
            bt_ingresar.setFont(new Font("arial",Font.BOLD, 15));
            bt_ingresar.setForeground(Color.black);
            bt_ingresar.setBackground(Color.white);
            this.add(bt_ingresar);

            bt_ingresar.addActionListener(cambiar);
        }

        public void BotonRegistrar(){
            bt_registro = new JButton();
            bt_registro.setText("REGISTRAR");
            bt_registro.setLayout(null);
            bt_registro.setBounds(185, 226, 130, 46);
            bt_registro.setFont(new Font("arial",Font.BOLD, 15));
            bt_registro.setForeground(Color.black);
            bt_registro.setBackground(Color.white);
            this.add(bt_registro);

            bt_registro.addActionListener(cambiar);
        }

        public void ColocarBotonesP3(){
            BotonRegistar2();
            BotonVolver();
        }

        public void BotonRegistar2(){
            bt_registro2 = new JButton();
            bt_registro2.setText("REGISTRAR");
            bt_registro2.setLayout(null);
            bt_registro2.setBounds(185, 283, 130, 46);
            bt_registro2.setFont(new Font("arial",Font.BOLD, 15));
            bt_registro2.setForeground(Color.black);
            bt_registro2.setBackground(Color.white);
            bt_registro2.setEnabled(false);
            this.add(bt_registro2);

            bt_registro2.addActionListener(cambiar);
        }

        public void BotonVolver(){
            bt_volver = new JButton();
            bt_volver.setText("VOLVER");
            bt_volver.setLayout(null);
            bt_volver.setBounds(10, 408, 130, 46);
            bt_volver.setFont(new Font("arial",Font.BOLD, 15));
            bt_volver.setForeground(Color.black);
            bt_volver.setBackground(Color.white);
            this.add(bt_volver);

            bt_volver.addActionListener(cambiar);
        }

        public void ColocarBotonesP4(){
            BotonIngresar2();
            BotonVolver();
        }

        public void BotonIngresar2(){
            bt_ingresar2 = new JButton();
            bt_ingresar2.setText("INGRESAR");
            bt_ingresar2.setLayout(null);
            bt_ingresar2.setBounds(176, 288, 130, 46);
            bt_ingresar2.setFont(new Font("arial",Font.BOLD, 15));
            bt_ingresar2.setForeground(Color.black);
            bt_ingresar2.setBackground(Color.white);
            bt_ingresar2.setEnabled(false);
            this.add(bt_ingresar2);
                
            bt_ingresar2.addActionListener(cambiar);
        }

            class EventoTeclado extends KeyAdapter{

                @Override
                public void keyPressed(KeyEvent e){
                    int codtecla = e.getKeyCode();
                    Object txt_escrito = e.getSource();

                    if(codtecla==10 && (txt_escrito==txt_apuesta)){
                       try{
                        int apuesta = Integer.parseInt(txt_apuesta.getText().trim());
                        dado1.leerapuesta(apuesta);
                        txt_apuesta.setText("");
                        bt_tirar.setEnabled(true);
                        txt_apuesta.setEnabled(false);
                       }catch(NumberFormatException ex){
                           JOptionPane.showMessageDialog(null,"La apuesta deben ser numeros enteros");
                           txt_apuesta.setText("");
                       } 
                        
                    }else if(codtecla==10 && (txt_escrito==txt_usuario2)){
                        txt_contrasena.setEnabled(true);
                    }else if(codtecla==10 && (txt_escrito==txt_contrasena)){
                        String usuario1 =txt_usuario2.getText().trim();
                        String contrasena= txt_contrasena.getText().trim();
                        if(registro_us.comprobarUsuario(usuario1,contrasena)==true){
                            actualizaretiquetas_p1(usuario1, jugador1);
                            txt_usuario2.setText("");
                            txt_contrasena.setText("");
                            txt_contrasena.setEnabled(false);
                            bt_ingresar2.setEnabled(true); 
                        }else if(registro_us.comprobarUsuario(usuario1,contrasena)==false){
                            JOptionPane.showMessageDialog(null,"El usuario o contraseña son incorrectos");
                            txt_contrasena.setEnabled(false);
                        }
                          
                    }else if(codtecla==10 && (txt_escrito==txt_usuario)){
                        txt_contrasena2.setEnabled(true);
                        
                    }else if(codtecla==10 && (txt_escrito==txt_credito)){
                        try{
                        String usuario1 =txt_usuario.getText().trim();
                        int creditos = Integer.parseInt(txt_credito.getText().trim());
                        
                        if(registro_us.comprobarUsuario(usuario1,"")==false){
                            jugador1.setNombre(usuario1);
                            jugador1.setContrasena(txt_contrasena2.getText().trim());
                            jugador1.setCredito(creditos);
                            txt_usuario.setText("");
                            txt_contrasena2.setText("");
                            txt_credito.setText("");
                            txt_contrasena2.setEnabled(false);
                            txt_credito.setEnabled(false);

                            bt_registro2.setEnabled(true);
                        }else if(registro_us.comprobarUsuario(usuario1,"")==true){
                            JOptionPane.showMessageDialog(null,"El usuario ya existe, escriba uno nuevo");
                            txt_contrasena2.setText("");
                            txt_credito.setText("");
                            txt_contrasena2.setEnabled(false);
                            txt_credito.setEnabled(false);
                            }
                        }catch(NumberFormatException ex){
                            JOptionPane.showMessageDialog(null,"Los creditos deben ser numeros enteros");
                            txt_credito.setText("");
                        }
                        
                    }else if(codtecla==10 && (txt_escrito==txt_contrasena2)){
                        txt_credito.setEnabled(true);
                    }
                }
            }

            class Restaurar implements ActionListener{
                public void actionPerformed(ActionEvent e){
                    Object botonpulsado = e.getSource();

                    if(botonpulsado==bt_terminarjg){
                        jugador1.setCredito(0);
                        registro_us.actualizar_datos(jugador1.getNombre(), jugador1);
                        System.exit(0);
                    }
                }
            }

             class Direccionar implements ActionListener{
                public void actionPerformed(ActionEvent e){
                    Object botonpulsado = e.getSource();
                     boolean ver = panel_4.isVisible();
                     boolean ver2= panel_3.isVisible();

                    if(botonpulsado==bt_ingresar){     
                       CambioPanel(1);
                    }else if(botonpulsado==bt_ingresar2){
                       CambioPanel(2);
                    }else if(botonpulsado==bt_registro){
                       CambioPanel(3);
                    }else if(botonpulsado==bt_registro2){
                        registro_us.asignardatos(jugador1);
                        CambioPanel(4);
                    }else if(botonpulsado==bt_volver && panel_4.isVisible()){
                       CambioPanel(5); 
                    }else if(botonpulsado==bt_volver && panel_3.isVisible()){
                       CambioPanel(6);
                    }
                }
            }
        }
    class EventoVentana extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e){
            jugador1.setCredito(0);
            registro_us.actualizar_datos(jugador1.getNombre(), jugador1);         
        }
    }
}