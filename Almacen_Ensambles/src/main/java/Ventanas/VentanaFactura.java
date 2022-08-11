package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import Conexion_BBDD.*;
import javax.swing.table.DefaultTableModel;

public class VentanaFactura extends JFrame {

    private int ancho = 550, alto = 550;
    private Panel panel_1, panel_2;
    private JTable tablaEnsamble;
    private DefaultTableModel modelo;
    private JScrollPane tabla;
    private int nivel, puntaje;

    private MetodosBD metodosBD = new MetodosBD();

    public VentanaFactura() {
        this.setSize(this.ancho, this.alto);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Registro");
        this.setResizable(false);
        ponerPaneles();
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }
    
    
    
    public void ponerPaneles() {
        panelFactura();
        panelRegistro();
        visibilidadInicial();
    }

    public void panelRegistro() {
        panel_1 = new Panel(this, metodosBD);
        panel_1.setBackground(Color.LIGHT_GRAY);
        panel_1.setLayout(null);
        panel_1.colocarEtiquetasP1();
        panel_1.colocarBotonesP1();
        this.add(panel_1);
    }

    public void panelFactura() {
        panel_2 = new Panel(this, metodosBD);
        panel_2.setBackground(Color.LIGHT_GRAY);
        panel_2.setLayout(null);
        panel_2.colocarEtiquetasP2();
        panel_2.colocarBotonesP2();
        panel_2.setOpaque(true);
        panel_2.setBounds(0, 0, 1000, 240);

        String[] nombresColumnas = {"Item", "Tipo Detalle", "Ref Producto", "Cantidad", "Precio"};

        Object[][] datosFila = {
            {"1", "Ensamble", "Xx", "1", "5000"},
            {"2", "Ensamble", "Xx", "2", "Xx"}
        };
        
        
        
        tablaEnsamble = new JTable();
        //tablaEnsamble = new JTable();
        modelo = (DefaultTableModel) tablaEnsamble.getModel();
        
        tabla = new JScrollPane(tablaEnsamble);
        tabla.setOpaque(true);
        tabla.setPreferredSize(new Dimension(500, 300));
        
        for (int i = 0; i < nombresColumnas.length; i++) {
            modelo.addColumn(nombresColumnas[i]);
        }
        
        modelo.addRow(datosFila[0]);
        modelo.addRow(datosFila[1]);

    }

    public void visibilidadInicial() {

        panel_1.setVisible(true);
        panel_2.setVisible(false);
        tabla.setVisible(false);
    }

    public void cambioPanel(String panel) {
        if (panel.equals("factura")) {
            panel_1.setVisible(false);
            panel_2.setVisible(true);
            tabla.setVisible(true);
            this.add(panel_2, BorderLayout.CENTER);
            this.add(tabla, BorderLayout.SOUTH);
            this.validate();
        }
    }

}

class Panel extends JPanel {

    private VentanaFactura miVentana;

    private JLabel titulo, et_tipoEmpleado, et_codEmpleado, et_cedulaCliente, et_codCliente, et_tipoDetalle, et_ensamble;
    private JButton bt_ingresar, bt_cliente;
    private JTextField txt_codEmpleado, txt_cedulaCliente;
    private JComboBox tiposEmpleado, tipoDetalle, ensamble;

    private String codEmpleado, cedulaCliente;

    private Direccionar cambiar = new Direccionar();
    private EventoCombo evCombo = new EventoCombo();
    private EventoCliente evCliente = new EventoCliente();

    private MetodosBD metodosBD;

    private String[] tiposDetalle = new String[200], ensamblesNF = new String[200];
    private String[][] ensambles = new String[200][200];

    public Panel(VentanaFactura miVentana, MetodosBD metodosBD) {
        this.miVentana = miVentana;
        this.metodosBD = metodosBD;
    }

    public void colocarEtiquetasP1() {
        titulo = new JLabel("REGISTRO");
        titulo.setOpaque(true);
        titulo.setBackground(Color.white);
        titulo.setFont(new Font("arial", Font.BOLD, 30));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBounds(90, 10, 370, 60);
        this.add(titulo);

        et_tipoEmpleado = new JLabel("Tipo de Empleado");
        et_tipoEmpleado.setOpaque(true);
        et_tipoEmpleado.setBackground(Color.LIGHT_GRAY);
        et_tipoEmpleado.setFont(new Font("arial", Font.BOLD, 20));
        et_tipoEmpleado.setBounds(75, 175, 200, 21);
        this.add(et_tipoEmpleado);

        tiposEmpleado = new JComboBox();
        //tiposEmpleado.setEditable(true); editarText
        tiposEmpleado.setBackground(Color.WHITE);
        tiposEmpleado.setFont(new Font("arial", Font.BOLD, 18));
        tiposEmpleado.setBounds(275, 175, 120, 21);
        tiposEmpleado.setForeground(Color.BLACK);

        tiposEmpleado.addItem("Auxiliar");

        tiposEmpleado.addActionListener(evCombo);
        this.add(tiposEmpleado);

        et_codEmpleado = new JLabel("Código Empleado");
        et_codEmpleado.setOpaque(true);
        et_codEmpleado.setBackground(Color.LIGHT_GRAY);
        et_codEmpleado.setFont(new Font("arial", Font.BOLD, 20));
        et_codEmpleado.setBounds(75, 210, 200, 21);
        this.add(et_codEmpleado);

        txt_codEmpleado = new JTextField();
        txt_codEmpleado.setBounds(275, 210, 130, 24);

        //txt_tipoEmpleado.addKeyListener(tecla);
        this.add(txt_codEmpleado);

    }

    public void colocarEtiquetasP2() {

        titulo = new JLabel("FACTURAR");
        titulo.setOpaque(true);
        titulo.setBackground(Color.white);
        titulo.setFont(new Font("arial", Font.BOLD, 30));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBounds(90, 10, 820, 60);
        this.add(titulo);

        et_cedulaCliente = new JLabel("Cédula Cliente");
        et_cedulaCliente.setOpaque(true);
        et_cedulaCliente.setBackground(Color.LIGHT_GRAY);
        et_cedulaCliente.setFont(new Font("arial", Font.BOLD, 20));
        et_cedulaCliente.setBounds(345, 100, 150, 21);
        et_cedulaCliente.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(et_cedulaCliente);

        txt_cedulaCliente = new JTextField();
        txt_cedulaCliente.setBounds(500, 100, 130, 25);

        //txt_tipoEmpleado.addKeyListener(tecla);
        this.add(txt_cedulaCliente);

        et_codCliente = new JLabel("El código del cliente es: ");
        et_codCliente.setOpaque(true);
        et_codCliente.setBackground(Color.LIGHT_GRAY);
        et_codCliente.setFont(new Font("arial", Font.BOLD, 15));
        et_codCliente.setBounds(300, 130, 400, 21);
        et_codCliente.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(et_codCliente);

        //et_tipoDetalle;
        et_tipoDetalle = new JLabel("Tipo Detalle");
        et_tipoDetalle.setOpaque(true);
        et_tipoDetalle.setBackground(Color.LIGHT_GRAY);
        et_tipoDetalle.setFont(new Font("arial", Font.BOLD, 20));
        et_tipoDetalle.setBounds(345, 156, 150, 21);
        et_tipoDetalle.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(et_tipoDetalle);

        tipoDetalle = new JComboBox();
        //tiposEmpleado.setEditable(true); editarText
        tipoDetalle.setBackground(Color.WHITE);
        tipoDetalle.setFont(new Font("arial", Font.BOLD, 17));
        tipoDetalle.setBounds(500, 156, 150, 21);
        tipoDetalle.setForeground(Color.BLACK);

        tiposDetalle = metodosBD.getDatosColumna("tipodetalle", "desctipodeta");
        if (tiposDetalle.length == 0) {
            tipoDetalle.addItem("vacío");
        } else {
            for (int i = 0; i < tiposDetalle.length; i++) {
                tipoDetalle.addItem(tiposDetalle[i]);
            }
        }

        tipoDetalle.addActionListener(evCombo);
        this.add(tipoDetalle);

        et_ensamble = new JLabel("Ensambles No Facturados");
        et_ensamble.setOpaque(true);
        et_ensamble.setBackground(Color.LIGHT_GRAY);
        et_ensamble.setFont(new Font("arial", Font.BOLD, 20));
        et_ensamble.setBounds(245, 182, 250, 21);
        et_ensamble.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(et_ensamble);

        ensamble = new JComboBox();
        //tiposEmpleado.setEditable(true); editarText
        ensamble.setBackground(Color.WHITE);
        ensamble.setFont(new Font("arial", Font.BOLD, 17));
        ensamble.setBounds(500, 182, 150, 21);
        ensamble.setForeground(Color.BLACK);

        if (ensamblesNF.length == 0) {
            ensamble.addItem("vacío");
        } else {
            for (int i = 0; i < ensamblesNF.length; i++) {
                ensamble.addItem(ensamblesNF[i]);
            }
        }

        ensamble.addActionListener(evCombo);
        this.add(ensamble);

    }

    public void colocarBotonesP1() {
        botonIngresar();
    }

    public void colocarBotonesP2() {
        botonBuscarCliente();
    }

    public void botonIngresar() {

        bt_ingresar = new JButton();
        bt_ingresar.setText("INGRESAR");
        bt_ingresar.setLayout(null);
        bt_ingresar.setBounds(210, 306, 130, 45);
        bt_ingresar.setFont(new Font("arial", Font.BOLD, 15));
        bt_ingresar.setForeground(Color.black);
        bt_ingresar.setBackground(Color.white);
        bt_ingresar.setEnabled(true);
        this.add(bt_ingresar);

        bt_ingresar.addActionListener(cambiar);

    }

    public void botonBuscarCliente() {

        bt_cliente = new JButton();
        bt_cliente.setText("BUSCAR");
        bt_cliente.setLayout(null);
        bt_cliente.setBounds(640, 95, 130, 35);
        bt_cliente.setFont(new Font("arial", Font.BOLD, 15));
        bt_cliente.setForeground(Color.black);
        bt_cliente.setBackground(Color.white);
        bt_cliente.setEnabled(true);
        this.add(bt_cliente);

        bt_cliente.addActionListener(evCliente);
    }

    private class Direccionar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object botonPulsado = e.getSource();

            if (botonPulsado.equals(bt_ingresar)) {
                if (botonPulsado.equals(bt_ingresar)) {
                    codEmpleado = (String) txt_codEmpleado.getText();
                    if (!codEmpleado.equals("")) {
                        codEmpleado = codEmpleado.trim();

                        miVentana.setSize(1000, 600);
                        miVentana.setLocationRelativeTo(null);
                        miVentana.setTitle("Factura");
                        miVentana.cambioPanel("factura");
                    }
                }

            }

        }
    }

    private class EventoCombo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object botonPulsado = e.getSource();
            //codEmpleado = (String) tiposEmpleado.getSelectedItem();
            if (botonPulsado.equals(tipoDetalle)) {
                ensambles[0] = metodosBD.getDatosColumna("ensamble", "consec");
                ensambles[1] = metodosBD.getDatosColumna("ensamble", "facturado");
                int contador = 0;

                if (!(ensambles[0].length == 0)) {
                    for (int i = 0; i < ensambles[1].length; i++) {
                        System.out.println(ensambles[1][i]);
                        if ("f".equals(ensambles[1][i].trim())) {
                            ensamblesNF[contador] = ensambles[0][i];
                            contador++;
                        }
                    }
                }

            } else if (botonPulsado.equals(ensamble)) {
                miVentana.getModelo().addRow(new String[]{"2", "Ensamble", "Xx", "2", "Xx"});
                if (ensamblesNF.length != 0) {
                    for (int i = 0; i < ensamblesNF.length; i++) {
                        ensambles[i+2] = metodosBD.getDatosRegistroDetalleFactura("consecfk", ensamblesNF[i]);
                    }
                    
                    for (int i = 2; i < ensambles.length; i++) {
                        miVentana.getModelo().addRow(ensambles[i]);
                    }
                    
                    
                }
            }

        }
    }

    private class EventoCliente implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object botonPulsado = e.getSource();

            if (botonPulsado.equals(bt_cliente)) {
                cedulaCliente = (String) txt_cedulaCliente.getText();
                cedulaCliente = cedulaCliente.trim();

                String codCliente = metodosBD.getcodCliente(cedulaCliente);

                if (codCliente.equals("vacio")) {
                    et_codCliente.setText("Registrar cliente.");
                } else {
                    et_codCliente.setText("El código del cliente es: "
                            + codCliente);
                }
            }
        }
    }

}
