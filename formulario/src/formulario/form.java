package formulario;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.lang.*;
import java.io.*;
import static java.lang.Integer.parseInt;
import java.sql.*;
/**
 *
 * @author Vaca Méndez Dylan Josel
 * @version 1.0
 */
public class form extends JFrame implements ActionListener{
    String nomb, apep, apem, escu;
    JLabel nom, app, apm, esc;
    JTextField no, apa, ama, es;
    JButton gua;
    ConexionMySQL conexion;
    
    /**
     * Constructor Crea la ventana en Swing
     */
    public form(){
        setLayout(null);
        setBounds(100, 100, 500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        nom = new JLabel("Nombre");
        nom.setBounds(10, 10, 100, 20);
        add(nom);
        app = new JLabel("Apellido Paterno");
        app.setBounds(10, 40, 100, 20);
        add(app);
        apm = new JLabel("Apellido Materno");
        apm.setBounds(10, 70, 100, 20);
        add(apm);
        esc = new JLabel("Escuela");
        esc.setBounds(10, 100, 100, 20);
        add(esc);
        
        no = new JTextField();
        no.setBounds(115, 10, 150, 20);
        add(no);
        apa = new JTextField();
        apa.setBounds(115, 40, 150, 20);
        add(apa);
        ama = new JTextField();
        ama.setBounds(115, 70, 150, 20);
        add(ama);
        es = new JTextField();
        es.setBounds(115, 100, 150, 20);
        add(es);
        
        gua = new JButton("Guardar");
        gua.setBounds(82, 130, 100, 20);
        gua.addActionListener(this);
        add(gua);
        
        setVisible(true);
    }
    
    /**
    *
    * @param e recibe un evento y su origen
    */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == gua){
            conexion = new ConexionMySQL();
            try{
                conexion.Conexion();
                conexion.Agregar(no.getText(), apa.getText(), ama.getText(), es.getText());
                conexion.Cerrar();
                JOptionPane.showMessageDialog(rootPane, "La información se guardó correctamente");
                no.setText("");
                apa.setText("");
                ama.setText("");
                es.setText("");
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "ERROR");
            }
        }
    }
}
