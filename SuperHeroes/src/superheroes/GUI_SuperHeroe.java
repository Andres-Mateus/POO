
package superheroes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class main {
    public static void main(String[] args) {
        GUI_SuperHeroe ventana1 = new GUI_SuperHeroe();
        ventana1.setVisible(true);
    }   
}

public class GUI_SuperHeroe extends JFrame{
    public Panel panel_inicio, panel_muestra;
    Alien alien = new Alien();
    Dios dios = new Dios();
    Humano humano = new Humano();
    Mago mago = new Mago();
    int nheroe=0;
    String texto="";
    
    
    public GUI_SuperHeroe(){
        this.setSize(700,550);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("JUEGO DE DADOS");
        this.setResizable(false);
        ponerPaneles();
    }
       
    public void ponerPaneles(){
        panelMuestra();
        panelIngreso();
        visibilidadInicial();
    }    
    
    public void panelIngreso(){
        panel_inicio = new Panel();
        panel_inicio.setBackground(Color.LIGHT_GRAY);
        panel_inicio.setLayout(null);
        panel_inicio.etiquetasPanelI();
        panel_inicio.botonesPanelI();
        this.add(panel_inicio);
    }
    public void panelMuestra(){
        panel_muestra = new Panel();
        panel_muestra.setBackground(Color.LIGHT_GRAY);
        panel_muestra.setLayout(null);
        panel_muestra.etiquetasPanelM();
        panel_muestra.botonesPanelM();
        this.add(panel_muestra);
    }
    
    public void visibilidadInicial(){
        panel_inicio.setVisible(true);
        panel_muestra.setVisible(false);
    }
    
    public void cambioPanel(int cambio){
        if(cambio==1){
            panel_inicio.setVisible(false);
            panel_muestra.setVisible(true);
            this.add(panel_muestra);
            this.validate();
        }else if(cambio==2){
            panel_muestra.setVisible(false);
            panel_inicio.setVisible(true);
            this.add(panel_inicio);
            this.validate();
        }
    }
    
        class Panel extends JPanel implements ActionListener{

        private JLabel titulo, et_orden1;
        private JLabel titulo_heroe = new JLabel("");
        private JTextArea txtmuestra  = new JTextArea("");
        private JButton bt_alien, bt_dios, bt_humano, bt_mago, bt_terminar, bt_volver, bt_mostrar;
        
        public JLabel getTitulo_heroe() {
            return titulo_heroe;
        }

        public void setTitulo_heroe(JLabel titulo_heroe) {
            this.titulo_heroe = titulo_heroe;
        }

        public JTextArea getTxtmuestra() {
            return txtmuestra;
        }

        public void setTxtmuestra(JTextArea txtmuestra) {
            this.txtmuestra = txtmuestra;
        }
        
        public void establecerTexto(String texto){
            titulo_heroe.setText(texto);
        }
        
        public void etiquetasPanelI(){
            titulo = new JLabel("*Super Héroes*");
            titulo.setOpaque(true);
            titulo.setBackground(Color.white);
            titulo.setFont(new Font("Cooper Black",Font.BOLD,45));
            titulo.setHorizontalAlignment(SwingConstants.CENTER);
            titulo.setBounds(150, 10, 400, 70);
            this.add(titulo);

            et_orden1 = new JLabel("Presione algún botón para observar las habilidades del tipo de héroe");
            et_orden1.setOpaque(true);
            et_orden1.setBackground(Color.LIGHT_GRAY);
            et_orden1.setFont(new Font("times new roman",Font.BOLD, 17));
            et_orden1.setHorizontalAlignment(SwingConstants.CENTER);
            et_orden1.setBounds(95, 100, 510, 40);
            this.add(et_orden1);

        }

        public void etiquetasPanelM(){
            titulo_heroe.setOpaque(true);
            titulo_heroe.setBackground(Color.white);
            titulo_heroe.setFont(new Font("Impact",Font.BOLD,35));
            titulo_heroe.setHorizontalAlignment(SwingConstants.CENTER);
            titulo_heroe.setBounds(150, 10, 400, 70);
            this.add(titulo_heroe);

            
            txtmuestra.setBounds(5, 90, 680, 310);
            txtmuestra.setBackground(Color.white);
            txtmuestra.setFont(new Font("times new roman",Font.BOLD, 15));
            this.add(txtmuestra);
        }

        public void botonesPanelI(){
            botonAlien();
            botonDios();
            botonHumano();
            botonMago();
            botonTerminar();
        }

        public void botonAlien(){
            bt_alien = new JButton();
            bt_alien.setText("ALIEN");
            bt_alien.setLayout(null);
            bt_alien.setBounds(250, 180, 200, 60);
            bt_alien.setFont(new Font("Cooper Black",Font.BOLD, 18));
            bt_alien.setForeground(Color.black);
            bt_alien.setBackground(Color.white);
            this.add(bt_alien);
            
            bt_alien.addActionListener(this);
        }

        public void botonDios(){
            bt_dios = new JButton();
            bt_dios.setText("DIOS");
            bt_dios.setLayout(null);
            bt_dios.setBounds(250, 255, 200, 60);
            bt_dios.setFont(new Font("Cooper Black",Font.BOLD, 18));
            bt_dios.setForeground(Color.black);
            bt_dios.setBackground(Color.white);
            this.add(bt_dios);
            
            bt_dios.addActionListener(this);
        }

        public void botonHumano(){
            bt_humano = new JButton();
            bt_humano.setText("HUMANO");
            bt_humano.setLayout(null);
            bt_humano.setBounds(250, 330, 200, 60);
            bt_humano.setFont(new Font("Cooper Black",Font.BOLD, 18));
            bt_humano.setForeground(Color.black);
            bt_humano.setBackground(Color.white);
            this.add(bt_humano);
            
            bt_humano.addActionListener(this);
        }

        public void botonMago(){
            bt_mago = new JButton();
            bt_mago.setText("MAGO");
            bt_mago.setLayout(null);
            bt_mago.setBounds(250, 405, 200, 60);
            bt_mago.setFont(new Font("Cooper Black",Font.BOLD, 18));
            bt_mago.setForeground(Color.black);
            bt_mago.setBackground(Color.white);
            this.add(bt_mago);
            
            bt_mago.addActionListener(this);
        }

        public void botonTerminar(){
            bt_terminar = new JButton();
            bt_terminar.setText("TERMINAR");
            bt_terminar.setLayout(null);
            bt_terminar.setBounds(520, 450, 150, 50);
            bt_terminar.setFont(new Font("Cooper Black",Font.BOLD, 16));
            bt_terminar.setForeground(Color.black);
            bt_terminar.setBackground(Color.white);
            this.add(bt_terminar);
            
            bt_terminar.addActionListener(this);
        }

        public void botonesPanelM(){
            botonMostrar();
            botonVolver();
            
        }

        public void botonMostrar(){
            bt_mostrar = new JButton();
            bt_mostrar.setText("MOSTRAR");
            bt_mostrar.setLayout(null);
            bt_mostrar.setBounds(250, 430, 200, 60);
            bt_mostrar.setFont(new Font("Cooper Black",Font.BOLD, 18));
            bt_mostrar.setForeground(Color.black);
            bt_mostrar.setBackground(Color.white);
            this.add(bt_mostrar);
            
            bt_mostrar.addActionListener(this);
        }
        
        public void botonVolver(){
            bt_volver = new JButton();
            bt_volver.setText("VOLVER");
            bt_volver.setLayout(null);
            bt_volver.setBounds(15, 430, 200, 60);
            bt_volver.setFont(new Font("Cooper Black",Font.BOLD, 18));
            bt_volver.setForeground(Color.black);
            bt_volver.setBackground(Color.white);
            this.add(bt_volver);
            
            bt_volver.addActionListener(this);
        }
        
        @Override
            public void actionPerformed(ActionEvent e) {
                    Object btpulsado = e.getSource();
                    
                    if(btpulsado==bt_volver){
                        titulo_heroe.setText("");
                        txtmuestra.setText("");
                        cambioPanel(2);
                    }else if(btpulsado==bt_terminar){
                        txtmuestra.setText("");
                        System.exit(0);
                    }else if(btpulsado==bt_alien){
                        cambioPanel(1);
                        texto=("Telequinesis:\n"+alien.lanzarObjetos()+"\n"+alien.elevarObjetos()+"\n"+alien.aplastarObjetos()+"\n"+alien.levitarObjetos()+"\n"+
                                "Volar:\n"+alien.levitar()+"\n"+alien.impulsar()+"\n"+alien.volar()+"\n"+alien.aterrizar()+"\n"+
                                "Combatir:\n"+alien.posicionAtaque()+"\n"+alien.concentracion()+"\n"+alien.golpear()+"\n"+alien.esquivar());
                        nheroe=1;
                    }else if(btpulsado==bt_dios){
                        cambioPanel(1);
                        texto=("Volar:\n"+dios.impulsar()+"\n"+dios.levitar()+"\n"+dios.volar()+"\n"+dios.aterrizar()+"\n"+
                                "SuperFuerza:\n"+dios.romper()+"\n"+dios.saltarconimpulso()+"\n"+dios.resistenciacorporal()+"\n"+
                                "Elemental:\n"+dios.generarElemento()+"\n"+dios.controlarElemento()+"\n"+dios.combinarElemento()+"\n"+dios.desaparecerElemento());
                        nheroe=2;
                    }else if(btpulsado==bt_humano){
                        cambioPanel(1);
                        texto=("Combatir:\n"+humano.posicionAtaque()+"\n"+humano.concentracion()+"\n"+humano.golpear()+"\n"+humano.esquivar()+"\n"+
                                "Super Fuerza:\n"+humano.romper()+"\n"+humano.cargar()+"\n"+humano.saltarconimpulso()+"\n"+humano.resistenciacorporal());
                        nheroe=3;
                    }else if(btpulsado==bt_mago){
                        cambioPanel(1);
                        texto=("Transformación:\n"+mago.copiarobjeto()+"\n"+mago.modificarmateria()+"\n"+mago.modificarse()+"\n"+mago.restaurarmateria()+"\n"+
                                "Elemental:\n"+mago.generarElemento()+"\n"+mago.controlarElemento()+"\n"+mago.combinarElemento()+"\n"+mago.desaparecerElemento()+"\n"+
                                 "Telequinesis:\n"+mago.lanzarObjetos()+"\n"+mago.elevarObjetos()+"\n"+mago.aplastarObjetos()+"\n"+mago.levitarObjetos()); 
                        nheroe=4;
                    }else if(btpulsado==bt_mostrar){
                        if(nheroe==1){
                            titulo_heroe.setText("Habilidades Alien");
                            titulo_heroe.setForeground(Color.green);
                        }else if(nheroe==2){
                            titulo_heroe.setText("Habilidades Dios");
                            titulo_heroe.setForeground(Color.CYAN);
                        }else if(nheroe==3){
                            titulo_heroe.setText("Habilidades Humano");
                            titulo_heroe.setForeground(Color.DARK_GRAY);
                        }else if(nheroe==4){
                            titulo_heroe.setText("Habilidades mago");
                            titulo_heroe.setForeground(Color.MAGENTA);
                        }
                        txtmuestra.setText(texto);
                    }   
            }
        }
}

