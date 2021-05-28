package Vista;

import Modelo.Segundo.Algorithm.*;
import Modelo.Segundo.Grafo.Arco;
import Modelo.Segundo.Grafo.Grafo;
import Modelo.Segundo.Grafo.Nodo;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SegundoParcial extends JFrame {

    private JButton actualizarMatrix = new JButton("UPDATE MATRIX");

    private JTextArea areaTextoSalidaListaNodos;
    private JTextArea areaTextoSalidaMatrix;
    private JTextArea areaTextoSalidaAlgoritmos;


    //diseñar grafo
    private JLabel etiquetaCrearGrafo = new JLabel("DISEÑAR GRAFO");
    private JComboBox<String> comboTipoGrafos1 = new JComboBox<String>();
    private JComboBox<String> comboTipoGrafos2 = new JComboBox<>();
    private JButton botonCrearGrafo = new JButton("DISEÑAR GRAFO");

    //crear nodo
    private JLabel etiquetaValorNodo = new JLabel("Valor");
    private JTextField cajaValorNodo = new JTextField();
    private JButton botonCrearNodo = new JButton("CREAR NODO");

    //deshabilitar nodo
    private JLabel etiquetaNodoDeshabilitar = new JLabel("Deshabilitar");
    private JTextField cajaIdNodoDeshabilitar = new JTextField();
    private JButton botonDeshabilitarNodo = new JButton("DESHABILITAR");

    //eliminar nodo


    //crear arco
    private JLabel etiquetaNodoEmisor = new JLabel("Emisor");
    private JTextField cajaEmisor = new JTextField();
    private JLabel etiquetaNodoDestino = new JLabel("Destino");
    private JTextField cajaDestino = new JTextField();
    private JLabel etiquetaPeso = new JLabel("Peso");
    private JTextField cajaPeso = new JTextField();
    private JButton botonCrearArco = new JButton("CREAR ARCO");

    //eliminar arco




    //algoritmos
    public JComboBox<String> comboAlgoritmos = new JComboBox<>();
    private JLabel etiquetaRoot = new JLabel("ROOT");
    private JTextField cajaRoot = new JTextField();
    private JButton botonEjecutar = new JButton("EJECUTAR");



    private JButton botonResetGrafo = new JButton("RESET GRAPH");
    private JButton botonResetArcos = new JButton("RESET EDGES");
    private JButton botonEliminarArco = new JButton("ELIMINAR ARCO");
    private JButton botonEliminarNodo = new JButton("ELIMINAR NODO");

    Font fuente = new Font("Comic Sans MS", Font.ITALIC, 17);
    JPanel panel;

    public static boolean digrafo = false;
    public static boolean weight = false;

    public SegundoParcial(){
        super("Programacion Avanzada - Segundo Parcial");
        this.setSize(1160, 720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        cargarComponentes();
    }

    private void cargarComponentes() {
        panel = new JPanel();
        panel.setLayout(null);

        areaTextoSalidaListaNodos = new JTextArea();
        areaTextoSalidaListaNodos.setFont(fuente);
        areaTextoSalidaListaNodos.setBackground(Color.gray);
        areaTextoSalidaListaNodos.setBounds(2, 10, 200, 400);
        areaTextoSalidaListaNodos.setEditable(false);

        JScrollPane scrollListaNodos = new JScrollPane(areaTextoSalidaListaNodos);
        scrollListaNodos.setBounds(2, 275, 200, 400);
        scrollListaNodos.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollListaNodos.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel.add(scrollListaNodos);


        areaTextoSalidaMatrix = new JTextArea();
        areaTextoSalidaMatrix.setFont(fuente);
        areaTextoSalidaMatrix.setBackground(Color.gray);
        areaTextoSalidaMatrix.setBounds(205, 10, 300, 400);
        areaTextoSalidaMatrix.setEditable(false);

        JScrollPane scroll = new JScrollPane(areaTextoSalidaMatrix);
        scroll.setBounds(205, 275, 300, 400);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel.add(scroll);




        areaTextoSalidaAlgoritmos = new JTextArea();
        areaTextoSalidaAlgoritmos.setFont(fuente);
        areaTextoSalidaAlgoritmos.setBackground(Color.gray);
        areaTextoSalidaAlgoritmos.setBounds(510, 10, 650, 400);
        areaTextoSalidaAlgoritmos.setEditable(false);

        JScrollPane scrollAlgoritmos = new JScrollPane(areaTextoSalidaAlgoritmos);
        scrollAlgoritmos.setBounds(510,275, 650, 400);
        scrollAlgoritmos.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollAlgoritmos.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel.add(scrollAlgoritmos);

        combos();
        cajasDeTexto();
        etiquetas();
        botones();

        panel.setBackground(Color.darkGray);
        this.getContentPane().add(panel);
        Border borde = new EmptyBorder (4,6,6,10);
        panel.setBorder(borde);
        eventos();
    }

    private void eventos() {
        comboTipoGrafos1.addActionListener(v-> visibilidadCombo1());
        comboTipoGrafos2.addActionListener(v-> visibilidadCombo2());
        botonCrearGrafo.addActionListener(v-> crearGrafoMetodo());
        botonCrearArco.addActionListener(v-> {
                try{
                    addArco();
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Ingresa un valor numerico "+e);
                }
            });
        botonCrearNodo.addActionListener(v-> {
            try{
                addNodo();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Ingresa un valor numerico "+e);
            }
        });
        botonDeshabilitarNodo.addActionListener(v-> {
            try{
                deshabilitarNodo();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Ingresa un valor numerico "+e);
            }
        });
        actualizarMatrix.addActionListener(v-> actualizarMatrixx());
        botonEjecutar.addActionListener(v-> {
            try{
                ejecutarAlgoritmo();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Ingresa un valor numerico "+e);
            }
        });

        botonResetGrafo.addActionListener(v->{
            try{
                resetarGrafo();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"No se pudo resetar el grafo "+e);
            }
        });

        botonEliminarArco.addActionListener(v->{
            try{
                eliminarArco();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"No se pudo eliminar el arco "+ e);
            }
        });

        botonResetArcos.addActionListener(v->{
            try{
                resetArcos();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"No se pudo resetear la matrix"+ e);
            }
        });
    }

    //ajustes de GUI

    private void combos(){
        comboTipoGrafos1.setModel(new DefaultComboBoxModel<>(new String[]{"SELECCIONA"
                ,"DIRIGIDO","NO DIRIGIDO"}));
        comboTipoGrafos1.setBounds(10, 30, 200, 25);
        panel.add(comboTipoGrafos1);

        comboTipoGrafos2.setModel(new DefaultComboBoxModel<>(new String[]{"SELECCIONA"
                ,"PESADO","NO PESADO"}));
        comboTipoGrafos2.setBounds(250, 30, 200, 25);
        panel.add(comboTipoGrafos2);
        comboTipoGrafos2.setVisible(false);

        comboAlgoritmos.setModel(new DefaultComboBoxModel<>(new String[]{"SELECCIONA"
                ,"ANCHURA","PROFUNDIDAD","PRIM","KRUSKAL","BELLMAN-FORD","DIJSTRA"}));
        comboAlgoritmos.setBounds(900, 30, 200, 25);
        panel.add(comboAlgoritmos);
        comboAlgoritmos.setVisible(false);
    }

    private void etiquetas(){

        etiquetaCrearGrafo.setBounds(200, 1, 200, 20);
        etiquetaCrearGrafo.setForeground(Color.BLACK);

        etiquetaNodoEmisor.setBounds(250, 120, 75, 20);
        etiquetaNodoEmisor.setForeground(Color.BLACK);
        etiquetaNodoEmisor.setVisible(false);

        etiquetaNodoDestino.setBounds(250, 150, 75, 20);
        etiquetaNodoDestino.setForeground(Color.BLACK);
        etiquetaNodoDestino.setVisible(false);

        etiquetaPeso.setBounds(250,180,75,20);
        etiquetaPeso.setForeground(Color.BLACK);
        etiquetaPeso.setVisible(false);

        etiquetaRoot.setBounds(900,210,75,20);
        etiquetaRoot.setForeground(Color.BLACK);
        etiquetaRoot.setVisible(false);

        etiquetaValorNodo.setBounds(10, 120, 75, 20);
        etiquetaValorNodo.setForeground(Color.BLACK);
        etiquetaValorNodo.setVisible(false);

        etiquetaNodoDeshabilitar.setBounds(10,190,75,20);
        etiquetaNodoDeshabilitar.setForeground(Color.BLACK);
        etiquetaNodoDeshabilitar.setVisible(false);

        panel.add(etiquetaCrearGrafo);
        panel.add(etiquetaNodoEmisor);
        panel.add(etiquetaNodoDestino);
        panel.add(etiquetaPeso);
        panel.add(etiquetaRoot);
        panel.add(etiquetaValorNodo);
        panel.add(etiquetaNodoDeshabilitar);
    }

    private void cajasDeTexto(){
        cajaEmisor.setBounds(350, 120, 50, 20);
        panel.add(cajaEmisor);
        cajaEmisor.setVisible(false);

        cajaDestino.setBounds(350,150,50,20);
        panel.add(cajaDestino);
        cajaDestino.setVisible(false);

        cajaPeso.setBounds(350,180,50,20);
        panel.add(cajaPeso);
        cajaPeso.setVisible(false);

        cajaRoot.setBounds(1000,210,50,20);
        panel.add(cajaRoot);
        cajaRoot.setVisible(false);

        cajaValorNodo.setBounds(100,120,50,20);
        panel.add(cajaValorNodo);
        cajaValorNodo.setVisible(false);

        cajaIdNodoDeshabilitar.setBounds(100,190,50,20);
        panel.add(cajaIdNodoDeshabilitar);
        cajaIdNodoDeshabilitar.setVisible(false);
    }

    private void botones(){
        botonCrearGrafo.setHorizontalAlignment(0);
        botonCrearGrafo.setFont(new Font("arial", Font.BOLD, 13));
        botonCrearGrafo.setForeground(Color.BLACK);
        botonCrearGrafo.setBackground(Color.gray);
        botonCrearGrafo.setBounds(100, 80, 200, 25);
        botonCrearGrafo.setVisible(false);
        panel.add(botonCrearGrafo);


        botonCrearArco.setHorizontalAlignment(0);
        botonCrearArco.setFont(new Font("arial", Font.BOLD, 13));
        botonCrearArco.setForeground(Color.BLACK);
        botonCrearArco.setBackground(Color.gray);
        botonCrearArco.setBounds(205,240, 150, 25);
        botonCrearArco.setVisible(false);
        panel.add(botonCrearArco);

        actualizarMatrix.setHorizontalAlignment(0);
        actualizarMatrix.setFont(new Font("arial", Font.BOLD, 13));
        actualizarMatrix.setForeground(Color.BLACK);
        actualizarMatrix.setBackground(Color.gray);
        actualizarMatrix.setBounds(550, 240, 150, 25);
        actualizarMatrix.setVisible(false);
        panel.add(actualizarMatrix);


        botonCrearNodo.setHorizontalAlignment(0);
        botonCrearNodo.setFont(new Font("arial", 1, 13));
        botonCrearNodo.setForeground(Color.BLACK);
        botonCrearNodo.setBackground(Color.gray);
        botonCrearNodo.setBounds(30, 150, 150, 25);
        botonCrearNodo.setVisible(false);
        panel.add(botonCrearNodo);

        botonDeshabilitarNodo.setHorizontalAlignment(0);
        botonDeshabilitarNodo.setFont(new Font("arial", 1, 13));
        botonDeshabilitarNodo.setForeground(Color.BLACK);
        botonDeshabilitarNodo.setBackground(Color.gray);
        botonDeshabilitarNodo.setBounds(30, 240, 150, 25);
        botonDeshabilitarNodo.setVisible(false);
        panel.add(botonDeshabilitarNodo);

        botonEjecutar.setHorizontalAlignment(0);
        botonEjecutar.setFont(new Font("arial", 1, 13));
        botonEjecutar.setForeground(Color.BLACK);
        botonEjecutar.setBackground(Color.gray);
        botonEjecutar.setBounds(900, 240, 150, 25);
        botonEjecutar.setVisible(false);
        panel.add(botonEjecutar);


        botonResetGrafo.setHorizontalAlignment(0);
        botonResetGrafo.setFont(new Font("arial", 1, 13));
        botonResetGrafo.setForeground(Color.BLACK);
        botonResetGrafo.setBackground(Color.gray);
        botonResetGrafo.setBounds(600, 30, 150, 25);
        botonResetGrafo.setVisible(true);
        panel.add(botonResetGrafo);

        botonResetArcos.setHorizontalAlignment(0);
        botonResetArcos.setFont(new Font("arial", 1, 13));
        botonResetArcos.setForeground(Color.BLACK);
        botonResetArcos.setBackground(Color.gray);
        botonResetArcos.setBounds(600, 60, 150, 25);
        botonResetArcos.setVisible(true);
        panel.add(botonResetArcos);

        botonEliminarArco.setHorizontalAlignment(0);
        botonEliminarArco.setFont(new Font("arial", Font.BOLD, 13));
        botonEliminarArco.setForeground(Color.BLACK);
        botonEliminarArco.setBackground(Color.gray);
        botonEliminarArco.setBounds(380,240, 150, 25);
        botonEliminarArco.setVisible(true);
        panel.add(botonEliminarArco);
    }


    //eventos de botones

    private void addNodo() {
        int valor = Integer.parseInt(cajaValorNodo.getText());
        Grafo crearGrafo = new Grafo();
        crearGrafo.addNodo(valor);

        areaTextoSalidaListaNodos.setText(null);
        //grafo con peso
        areaTextoSalidaListaNodos.setText("Lista de Nodos \n \n" +
                "ID \t valor \n");
        for (Nodo virtual : Grafo.nodos) {
            areaTextoSalidaListaNodos.append(virtual.getId()+" \t "+virtual.getValor()+"\n");
        }
    }

    private void deshabilitarNodo() {
        int id = Integer.parseInt(cajaIdNodoDeshabilitar.getText());
        Grafo grafo = new Grafo();
        grafo.deshabilitarNodo(id);
        areaTextoSalidaListaNodos.setText(null);
        areaTextoSalidaListaNodos.setText("Lista de Nodos \n \n" +
                "ID \t valor \n");
        for (Nodo virtual : Grafo.nodos) {
            //esto y solo esto sirve para reasignar el id cuando se elimina un nodo
            //un poco de programación reactiva, aunque no sé si sea del necesario
            //virtual.setId(Grafo.nodos.indexOf(virtual) + 1);
            //hasta aquí (solo con arraylist(?))

            //esto ya es para recorrer e imprimir
            areaTextoSalidaListaNodos.append(virtual.getId()+" \t "+virtual.getValor()+"\n");
        }
    }

    private void addArco() {
        int emisor = Integer.parseInt(cajaEmisor.getText());
        int destino = Integer.parseInt(cajaDestino.getText());
        Grafo crearGrafo = new Grafo();
        if(digrafo && weight){
            int peso = Integer.parseInt(cajaPeso.getText());
            areaTextoSalidaMatrix.append(crearGrafo.addArcoDirigidoPesado(emisor,destino,peso));
        }else if(digrafo){
            areaTextoSalidaMatrix.append(crearGrafo.addArcoDirigidoNoPesado(emisor, destino));
        }else if(weight){
            int peso = Integer.parseInt(cajaPeso.getText());
            areaTextoSalidaMatrix.append(crearGrafo.addArcoNoDirigidoPesado(emisor,destino,peso));
        }else{
            areaTextoSalidaMatrix.append(crearGrafo.addArcoNoDirigidoNoPesado(emisor, destino));
        }
    }

    private void eliminarArco(){
        Grafo grafo = new Grafo();
        int emisor = Integer.parseInt(cajaEmisor.getText());
        int destino = Integer.parseInt(cajaDestino.getText());
        areaTextoSalidaMatrix.append(grafo.deleteArcoNoPesado(emisor,destino));
        areaTextoSalidaAlgoritmos.setText(null);
    }

    private void resetArcos(){
        Grafo grafo = new Grafo();
        Grafo.matrix.clear();
        Grafo.arcos.clear();
        grafo.buildInitialMatrix();
        areaTextoSalidaAlgoritmos.setText(null);
    }

    private void actualizarMatrixx() {
        areaTextoSalidaMatrix.setText(null);
        for (int i = 0; i < Grafo.matrix.size(); i++) {
            areaTextoSalidaMatrix.append(Grafo.matrix.get(i)+"\n");
        }
        for (Arco imprimir: Grafo.arcos) {

            areaTextoSalidaMatrix.append(imprimir.toString());
        }
    }

    private void crearGrafoMetodo() {
        String comboGrafosD = (String) comboTipoGrafos1.getSelectedItem();
        String comboGrafosP = (String) comboTipoGrafos2.getSelectedItem();

        //nodos
        //etiquetas
        etiquetaValorNodo.setVisible(true);
        //cajas
        cajaValorNodo.setVisible(true);
        //botones
        botonCrearNodo.setVisible(true);

        //cuando existe al menos un nodo se activan los campos de arcos y el de eliminar nodo
        if(Grafo.nodos.size()>0){
            //etiquetas
            etiquetaNodoDeshabilitar.setVisible(true);
            etiquetaNodoEmisor.setVisible(true);
            etiquetaNodoDestino.setVisible(true);

            //cajas
            cajaIdNodoDeshabilitar.setVisible(true);
            cajaEmisor.setVisible(true);
            cajaDestino.setVisible(true);

            //botones
            botonDeshabilitarNodo.setVisible(true);
            botonCrearArco.setVisible(true);
            actualizarMatrix.setVisible(true);
            visibilidadGuiAlgoritmos();
        }
        assert comboGrafosP != null;
        assert comboGrafosD != null;
        if(comboGrafosP.equals("PESADO") && comboGrafosD.equals("DIRIGIDO")){
            digrafo = true;
            weight = true;
            if(Grafo.nodos.size()>0) {
                etiquetaPeso.setVisible(true);
                cajaPeso.setVisible(true);
            }
        }else if(comboGrafosP.equals("NO PESADO") && comboGrafosD.equals("NO DIRIGIDO")){
            digrafo = false;
            weight = false;
            etiquetaPeso.setVisible(false);
            cajaPeso.setVisible(false);

        }else if(comboGrafosP.equals("NO PESADO") && comboGrafosD.equals("DIRIGIDO")){
            digrafo = true;
            weight = false;
            etiquetaPeso.setVisible(false);
            cajaPeso.setVisible(false);
        }else if(comboGrafosP.equals("PESADO") && comboGrafosD.equals("NO DIRIGIDO")){
            digrafo = false;
            weight = true;
            if(Grafo.nodos.size()>0) {
                etiquetaPeso.setVisible(true);
                cajaPeso.setVisible(true);
            }
        }
        else {
            //etiquetas
            etiquetaValorNodo.setVisible(false);
            etiquetaNodoDeshabilitar.setVisible(false);
            etiquetaNodoEmisor.setVisible(false);
            etiquetaNodoDestino.setVisible(false);
            etiquetaPeso.setVisible(false);
            etiquetaRoot.setVisible(false);
        }
    }





    private void resetarGrafo(){
        weight = false;
        digrafo = false;
        Grafo.nodos.clear();
        Grafo.arcos.clear();
        Grafo.matrix.clear();
        Grafo.autoIncrementId = 1;
        areaTextoSalidaListaNodos.setText(null);
        areaTextoSalidaMatrix.setText(null);
        areaTextoSalidaAlgoritmos.setText(null);


        etiquetaValorNodo.setVisible(false);
        cajaValorNodo.setVisible(false);
        cajaValorNodo.setText(null);

        etiquetaNodoDeshabilitar.setVisible(false);
        cajaIdNodoDeshabilitar.setVisible(false);
        cajaIdNodoDeshabilitar.setText(null);

        etiquetaNodoEmisor.setVisible(false);
        cajaEmisor.setVisible(false);
        cajaEmisor.setText(null);

        etiquetaNodoDestino.setVisible(false);
        cajaDestino.setText(null);
        cajaDestino.setVisible(false);

        etiquetaPeso.setVisible(false);
        cajaPeso.setText(null);
        cajaPeso.setVisible(false);

        etiquetaRoot.setVisible(false);
        cajaRoot.setText(null);
        cajaRoot.setVisible(false);

        comboAlgoritmos.setVisible(false);

        botonEjecutar.setVisible(false);
        botonCrearNodo.setVisible(false);
        botonCrearArco.setVisible(false);
        botonDeshabilitarNodo.setVisible(false);

    }

    private void visibilidadGuiAlgoritmos(){
        if(Grafo.arcos.size()>0){
            //cuando hay nodos y arcos se activan la de los algoritmos (por ahora solo está root)
            //etiquetas
            etiquetaRoot.setVisible(true);
            cajaRoot.setVisible(true);
            comboAlgoritmos.setVisible(true);
            botonEjecutar.setVisible(true);
        }
    }

    private void ejecutarAlgoritmo(){
        String algoritmo = (String) comboAlgoritmos.getSelectedItem();
        int root = Integer.parseInt(cajaRoot.getText());
        assert algoritmo != null;
        switch (algoritmo) {
            case "ANCHURA":
                Anchura anchura = new Anchura();
                for (Nodo auxiliar : Grafo.nodos) {
                    if (auxiliar.getId() == root) {
                        anchura.breadthFrist(auxiliar);
                        break;
                    }
                }
                imprimirAlgoritmo();
                break;
            case "PROFUNDIDAD":
                Profundidad profundidad = new Profundidad();
                profundidad.DephtFirst();
                imprimirAlgoritmo();
                break;
            case "PRIM":
                Prim prim = new Prim();
                for (Nodo auxiliar : Grafo.nodos) {
                    if (auxiliar.getId() == root) {
                        prim.MSTPrim(auxiliar);
                        break;
                    }
                }
                imprimirAlgoritmo();
                break;
            case "BELLMAN-FORD":
                BellmanFord bellmanFord = new BellmanFord();
                for (Nodo auxiliar : Grafo.nodos) {
                    if (auxiliar.getId() == root) {
                        bellmanFord.bellmanFordA(auxiliar);
                        break;
                    }
                }
                imprimirAlgoritmo();
                areaTextoSalidaAlgoritmos.append(bellmanFord.costo());
                break;
            case "DIJSTRA":
                Dijstra dijstra = new Dijstra();
                for (Nodo auxiliar : Grafo.nodos) {
                    if (auxiliar.getId() == root) {
                        dijstra.DijstraA(auxiliar);
                        break;
                    }
                }
                imprimirAlgoritmo();
                break;
            case "KRUSKAL":
                Kruskal kruskal = new Kruskal();
                imprimirAlgoritmo();
                areaTextoSalidaAlgoritmos.append(kruskal.kruskal().toString());
        }
    }



    //eventos de combos
    private void visibilidadCombo1() {
        String comboGrafosD = (String) comboTipoGrafos1.getSelectedItem();
        assert comboGrafosD != null;
        if(!comboGrafosD.equals("SELECCIONA")){
            comboTipoGrafos2.setVisible(true);

        }
        else{
            comboTipoGrafos2.setVisible(false);
            botonCrearGrafo.setVisible(false);
        }
    }

    private void visibilidadCombo2() {
        String comboGrafosP = (String) comboTipoGrafos2.getSelectedItem();
        assert comboGrafosP != null;
        botonCrearGrafo.setVisible(!comboGrafosP.equals("SELECCIONA"));
    }

    private void imprimirAlgoritmo(){
        areaTextoSalidaAlgoritmos.setText(null);
        areaTextoSalidaAlgoritmos.setText("Lista de Nodos \n \n" + "ID \t padre \t color \t D \t F \tKey \n");
        for (Nodo virtual : Grafo.nodos) {
            areaTextoSalidaAlgoritmos.append(virtual.toString());
        }
    }
}
