package Vista;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {

    JButton primer = new JButton("Primer parcial");
    JButton segundo = new JButton("Segundo Parcial");

    PrimerParcial ventana1 = new PrimerParcial();
    SegundoParcial ventana2 = new SegundoParcial();
    JPanel panel;

    public Menu(){
        super("Programacion Avanzada");
        this.setSize(450, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cargarComponentes();
    }

    private void cargarComponentes() {
        panel = new JPanel();
        panel.setLayout(null);


        primer.setHorizontalAlignment(0);
        primer.setFont(new Font("arial", 1, 14));
        primer.setForeground(Color.BLACK);
        primer.setBackground(Color.gray);
        primer.setBounds(150,50 , 150, 30);

        segundo.setHorizontalAlignment(0);
        segundo.setFont(new Font("arial", 1, 14));
        segundo.setForeground(Color.BLACK);
        segundo.setBackground(Color.gray);
        segundo.setBounds(150,100 , 150, 30);

        panel.add(primer);
        panel.add(segundo);

        panel.setBackground(Color.darkGray);

        this.getContentPane().add(panel);
        eventos();
    }

    private void eventos() {
        primer.addActionListener(v ->{
            if(!ventana2.isVisible()){
                ventana1.setVisible(true);
            }
        });
        segundo.addActionListener(v->{
            if(!ventana1.isVisible()){
                ventana2.setVisible(true);
            }
        });
    }
}
