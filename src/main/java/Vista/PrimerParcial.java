package Vista;

import Modelo.Recursividad.*;
import Modelo.Sort.Iterativo.*;
import Modelo.Sort.Recursivo.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Arrays;
import java.util.Objects;

public class PrimerParcial extends JFrame{

    private static int longitudDeRandom = 5;
    private JButton calcular = new JButton("CALCULAR");
    private JButton ordenar = new JButton("ORDENAR");
    private JButton random = new JButton("RANDOM");
    private int [] vectorRandomDesordenado = new int[longitudDeRandom];

    private JTextArea areaTextoSalida;
    private JComboBox comboRecursivosIterativos = new JComboBox();
    private JLabel etiquetaRecursivos = new JLabel("RECURSIVOS-ITERATIVOS");

    private JComboBox comboOrdenamientos = new JComboBox();
    private JLabel etiquetaOrdenamientos = new JLabel("METODOS DE ORDENAMIENTO");


    private JComboBox comboMetodos = new JComboBox();

    private JLabel etiquetaInteractiva1 = new JLabel();
    private JLabel etiquetaInteractiva2 = new JLabel();
    private JTextField cajaInteractiva = new JTextField();
    private JTextField longitud = new JTextField();


    private JTextField cociente1Text = new JTextField();
    private JTextField cociente2Text = new JTextField();
    private JTextField potencia = new JTextField();
    Font fuente = new Font("Comic Sans MS", Font.ITALIC, 17);
    JPanel panel;

    DefaultCategoryDataset datosIniciales = new DefaultCategoryDataset();
    JFreeChart graficaVectorDesordenado;
    ChartPanel panelGraficaVectorDesordenado;

    public PrimerParcial(){
        super("Programacion Avanzada - Primer Parcial");
        this.setSize(1020, 720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        cargarComponentes();
    }

    private void cargarComponentes() {
        panel = new JPanel();
        panel.setLayout(null);
        calcular.setHorizontalAlignment(0);
        calcular.setFont(new Font("arial", 1, 14));
        calcular.setForeground(Color.BLACK);
        calcular.setBackground(Color.gray);
        calcular.setBounds(100, 220, 200, 30);

        ordenar.setHorizontalAlignment(0);
        ordenar.setFont(new Font("arial", 1, 14));
        ordenar.setForeground(Color.BLACK);
        ordenar.setBackground(Color.gray);
        ordenar.setBounds(575, 220, 200, 30);

        random.setHorizontalAlignment(0);
        random.setFont(new Font("arial", 1, 14));
        random.setForeground(Color.BLACK);
        random.setBackground(Color.gray);
        random.setBounds(400, 25, 100, 25);




        areaTextoSalida = new JTextArea();
        areaTextoSalida.setFont(fuente);
        areaTextoSalida.setBackground(Color.gray);
        areaTextoSalida.setBounds(2, 10, 500, 400);
        areaTextoSalida.setEditable(false);

        JScrollPane scroll = new JScrollPane(areaTextoSalida);
        scroll.setBounds(2, 275, 500, 400);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


        comboRecursivosIterativos.setModel(new DefaultComboBoxModel<>(new String[]{"SELECCIONA", "FIBONACCI",
                "FACTORIAL", "TORRES DE HANOI", "MAXIMO COMUN DIVISOR", "TRIANGULO DE PASCAL", "VECTOR DOBLE",
                "SUMA N UNIDADES (FORMULA GAUSS)", "SUMA DESCOMPOSICION", "SUMA DE ELEMENTOS DE UN VECTOR",
                "TEOREMA DEL BINOMIO", "BUSQUEDA BINARIA"}));
        comboRecursivosIterativos.setBounds(10, 25, 300, 25);
        etiquetaRecursivos.setBounds(10, 1, 200, 20);
        etiquetaRecursivos.setForeground(Color.BLACK);

        comboOrdenamientos.setModel(new DefaultComboBoxModel<>(new String[]{"SELECCIONA", "BURBUJA",
                "INSERCION", "SELECCION", "QUICKSORT", "SHELL", "MERGESORT", "RADIX","HEAPSORT","BUCKET","COUNTING"}));
        comboOrdenamientos.setBounds(575, 25, 300, 25);
        etiquetaOrdenamientos.setBounds(575, 1, 200, 20);
        etiquetaOrdenamientos.setForeground(Color.BLACK);

        comboMetodos.setModel(new DefaultComboBoxModel<>(new String[]{"RECURSIVO", "ITERATIVO"}));
        comboMetodos.setBounds(220, 100, 150, 25);


        etiquetaInteractiva1.setBounds(10, 100, 250, 20);
        etiquetaInteractiva1.setForeground(Color.BLACK);
        etiquetaInteractiva2.setBounds(10, 150, 250, 20);
        etiquetaInteractiva2.setForeground(Color.BLACK);
        cajaInteractiva.setBounds(220, 150, 50, 20);

        comboMetodos.setVisible(false);
        cajaInteractiva.setVisible(false);
        calcular.setVisible(false);
        ordenar.setVisible(false);
        random.setVisible(false);


        cociente1Text.setVisible(false);
        panel.add(calcular);
        panel.add(ordenar);
        panel.add(random);
        panel.add(scroll);
        panel.add(comboRecursivosIterativos);
        panel.add(etiquetaRecursivos);
        panel.add(comboOrdenamientos);
        panel.add(etiquetaOrdenamientos);
        panel.add(etiquetaInteractiva1);
        panel.add(etiquetaInteractiva2);
        panel.add(comboMetodos);
        panel.add(cajaInteractiva);

        panel.add(cociente1Text);



        panel.setBackground(Color.darkGray);

        this.getContentPane().add(panel);
        Border borde = new EmptyBorder (4,6,6,10);
        panel.setBorder(borde);
        eventos();
    }

    private void eventos(){

        comboRecursivosIterativos.addActionListener(e -> accionComboRecursivoIterativo());
        comboOrdenamientos.addActionListener(e -> accionComboOrdenamientos());
        calcular.addActionListener(e -> calcular());
        random.addActionListener(e -> vectorRandom());
        ordenar.addActionListener( e-> ordenarVector());
    }

    public void accionComboRecursivoIterativo() {
        String recursivoIterativoSeleccionado = (String) comboRecursivosIterativos.getSelectedItem();
        assert recursivoIterativoSeleccionado != null;
        if(!recursivoIterativoSeleccionado.equals("SELECCIONA")){
            etiquetaInteractiva1.setText("SELECCIONA EL METODO");
            etiquetaInteractiva2.setText("INGRESA EL OPERANDO");
            comboMetodos.setVisible(true);
            cajaInteractiva.setVisible(true);
            calcular.setVisible(true);
            random.setVisible(false);


            cociente1Text.setVisible(false);

            if(recursivoIterativoSeleccionado.equals("VECTOR DOBLE") ||
                    recursivoIterativoSeleccionado.equals("SUMA DE ELEMENTOS DE UN VECTOR")){
                random.setVisible(true);
                cajaInteractiva.setVisible(false);

                cociente1Text.setVisible(false);

            }
            if(recursivoIterativoSeleccionado.equals("BUSQUEDA BINARIA")){
                random.setVisible(true);
                cajaInteractiva.setVisible(true);

                cociente1Text.setVisible(false);

            }
        }else{
            comboMetodos.setVisible(false);
            cajaInteractiva.setVisible(false);
            calcular.setVisible(false);
            etiquetaInteractiva1.setText(null);
            etiquetaInteractiva2.setText(null);
        }
    }

    public void accionComboOrdenamientos(){
        String ordenamientoSeleccionado = (String) comboOrdenamientos.getSelectedItem();
        assert ordenamientoSeleccionado != null;
        if(!ordenamientoSeleccionado.equals("SELECCIONA")){
            ordenar.setVisible(true);
            random.setVisible(true);
        }else{
            ordenar.setVisible(false);
            random.setVisible(false);
        }
    }

    public void calcular(){
        String programaSaleccionado = (String) comboRecursivosIterativos.getSelectedItem();
        String metodoSeleccionado = (String) comboMetodos.getSelectedItem();
        int numero;
        assert metodoSeleccionado != null;
        switch (Objects.requireNonNull(programaSaleccionado)) {
            case "FIBONACCI":
                numero = Integer.parseInt(cajaInteractiva.getText());
                Fibonacci fibonacci = new Fibonacci();
                areaTextoSalida.append(fibonacci.fiboTime(numero, metodoSeleccionado));
                break;
            case "FACTORIAL":
                numero = Integer.parseInt(cajaInteractiva.getText());
                Factorial factorial = new Factorial();
                areaTextoSalida.append(factorial.factorialTime(numero, metodoSeleccionado));
                break;
            case "SUMA DESCOMPOSICION":
                numero = Integer.parseInt(cajaInteractiva.getText());
                sumaUnidades sumaUnidades = new sumaUnidades();
                areaTextoSalida.append(sumaUnidades.sumaUnidadesTime(numero, metodoSeleccionado));
                break;
            case "TRIANGULO DE PASCAL":
                numero = Integer.parseInt(cajaInteractiva.getText());
                TrianguloPascal triangulo = new TrianguloPascal();
                areaTextoSalida.append(triangulo.pascalTime(numero*2 , numero, metodoSeleccionado));
                break;
            case "MAXIMO COMUN DIVISOR":
                numero = Integer.parseInt(cajaInteractiva.getText());
                MCD mcd = new MCD();
                areaTextoSalida.append(mcd.MCDTime(numero, (int) (numero * 0.75), metodoSeleccionado));
                break;
            case "SUMA N UNIDADES (FORMULA GAUSS)":
                numero = Integer.parseInt(cajaInteractiva.getText());
                Gauss gauss = new Gauss();
                areaTextoSalida.append(gauss.GaussTime(numero, metodoSeleccionado));
                break;
            case "SUMA DE ELEMENTOS DE UN VECTOR":
                SumaVector suma = new SumaVector();
                areaTextoSalida.append(suma.vectorTime(vectorRandomDesordenado, metodoSeleccionado));
                break;
            case "VECTOR DOBLE":
                VectorDoble doble = new VectorDoble();
                areaTextoSalida.append(doble.dobleTime(vectorRandomDesordenado, metodoSeleccionado));
                break;
            case "TORRES DE HANOI":
                numero = Integer.parseInt(cajaInteractiva.getText());
                Hanoi hanoi = new Hanoi();
                areaTextoSalida.append(hanoi.hanoiTime(numero, metodoSeleccionado));
                break;
            case "TEOREMA DEL BINOMIO":
                numero = Integer.parseInt(cajaInteractiva.getText());
                Newton newton = new Newton();
                areaTextoSalida.append(newton.newtonTime(numero,metodoSeleccionado));
                break;
            case "BUSQUEDA BINARIA":
                numero = Integer.parseInt(cajaInteractiva.getText());
                BusquedaBinaria busquedaBinaria = new BusquedaBinaria();
                areaTextoSalida.append(busquedaBinaria.busquedaBinariaTime(ordenado,numero,metodoSeleccionado));
                break;
        }
    }

    private static int[] ordenado;

    public void ordenarVector(){
        String programaSeleccionado = (String) comboOrdenamientos.getSelectedItem();
        switch (Objects.requireNonNull(programaSeleccionado)) {
            case "BURBUJA":
                ordenarPorBurbuja();
                break;
            case "INSERCION":
                ordenarPorInsercion();
                break;
            case "QUICKSORT":
                ordenarPorQuickSort();
                break;
            case "SHELL":
                ordenarPorShell();
                break;
            case "SELECCION":
                ordenarPorSeleccion();
                break;
            case "MERGESORT":
                ordenarPorMergeSort();
                break;
            case "RADIX":
                ordenarPorRadix();
                break;
            case "HEAPSORT":
                ordenarPorHeap();
                break;
            case "BUCKET":
                ordenarPorBucket();
                break;
            case "COUNTING":
                ordenarPorCounting();
                break;
        }
    }

    public void vectorRandom(){
        areaTextoSalida.append("\nVector Random: ");
        for(int i = 0; i<vectorRandomDesordenado.length; i++){
            int numeroRandom = ((int) (Math.random() *20 ) + 1);
            vectorRandomDesordenado[i] = numeroRandom;
            datosIniciales.setValue(vectorRandomDesordenado[i],"posicion "+i," ");
        }
        graficaVectorDesordenado = ChartFactory.createBarChart(
                "vector",
                null,
                null,
                datosIniciales,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        panelGraficaVectorDesordenado = new ChartPanel(graficaVectorDesordenado);
        panelGraficaVectorDesordenado.setMouseWheelEnabled(true);
        panelGraficaVectorDesordenado.setBounds(505,275,490,400);
        panel.add(panelGraficaVectorDesordenado);
        repaint();
        areaTextoSalida.append("\n"+Arrays.toString(vectorRandomDesordenado)+"\n");
    }

    private void ordenarPorBurbuja(){
       Burbuja burbujaOriginal = new Burbuja();
       areaTextoSalida.append(burbujaOriginal.burbujaTime(vectorRandomDesordenado));
       for (int i = 0; i < Burbuja.ordenado.length; i++) {
           datosIniciales.setValue(Burbuja.ordenado[i]," posicion "+i," " );
       }
       graficaVectorDesordenado = ChartFactory.createBarChart(
               "vector",
               null,
               null,
               datosIniciales,
               PlotOrientation.VERTICAL,
               true,
               true,
               false
       );
       panelGraficaVectorDesordenado = new ChartPanel(graficaVectorDesordenado);
       panelGraficaVectorDesordenado.setMouseWheelEnabled(true);
       panelGraficaVectorDesordenado.setBounds(505,275,490,400);
       panel.add(panelGraficaVectorDesordenado);
       repaint();
       ordenado = Burbuja.ordenado;
   }

    private void ordenarPorInsercion(){
       Insercion insercion = new Insercion();
       areaTextoSalida.append(insercion.insercionTime(vectorRandomDesordenado));
       for (int i = 0; i < Insercion.ordenado.length; i++) {
           datosIniciales.setValue(Insercion.ordenado[i]," posicion "+i," " );
       }
       graficaVectorDesordenado = ChartFactory.createBarChart(
               "vector",
               null,
               null,
               datosIniciales,
               PlotOrientation.VERTICAL,
               true,
               true,
               false
       );
       panelGraficaVectorDesordenado = new ChartPanel(graficaVectorDesordenado);
       panelGraficaVectorDesordenado.setMouseWheelEnabled(true);
       panelGraficaVectorDesordenado.setBounds(505,275,490,400);
       panel.add(panelGraficaVectorDesordenado);
       repaint();
       ordenado = Insercion.ordenado;
   }

    private void ordenarPorQuickSort(){
       QuickSort quickSort = new QuickSort();
       areaTextoSalida.append(quickSort.quickTime(vectorRandomDesordenado));
       for (int i = 0; i < QuickSort.ordenado.length; i++) {
           datosIniciales.setValue(QuickSort.ordenado[i]," posicion "+i," " );
       }
       graficaVectorDesordenado = ChartFactory.createBarChart(
               "vector",
               null,
               null,
               datosIniciales,
               PlotOrientation.VERTICAL,
               true,
               true,
               false
       );
       panelGraficaVectorDesordenado = new ChartPanel(graficaVectorDesordenado);
       panelGraficaVectorDesordenado.setMouseWheelEnabled(true);
       panelGraficaVectorDesordenado.setBounds(505,275,490,400);
       panel.add(panelGraficaVectorDesordenado);
       repaint();
       ordenado = QuickSort.ordenado;
   }

    private void ordenarPorShell(){
       Shell shell = new Shell();
       areaTextoSalida.append(shell.shellTime(vectorRandomDesordenado));
       for (int i = 0; i < Shell.ordenado.length; i++) {
           datosIniciales.setValue(Shell.ordenado[i]," posicion "+i," " );
       }
       graficaVectorDesordenado = ChartFactory.createBarChart(
               "vector",
               null,
               null,
               datosIniciales,
               PlotOrientation.VERTICAL,
               true,
               true,
               false
       );
       panelGraficaVectorDesordenado = new ChartPanel(graficaVectorDesordenado);
       panelGraficaVectorDesordenado.setMouseWheelEnabled(true);
       panelGraficaVectorDesordenado.setBounds(505,275,490,400);
       panel.add(panelGraficaVectorDesordenado);
       repaint();
       ordenado = Shell.ordenado;
   }

    private void ordenarPorSeleccion(){
       Seleccion seleccion = new Seleccion();
       areaTextoSalida.append(seleccion.seleccionTime(vectorRandomDesordenado));
       for (int i = 0; i < Seleccion.ordenado.length; i++) {
           datosIniciales.setValue(Seleccion.ordenado[i]," posicion "+i," " );
       }
       graficaVectorDesordenado = ChartFactory.createBarChart(
               "vector",
               null,
               null,
               datosIniciales,
               PlotOrientation.VERTICAL,
               true,
               true,
               false
       );
       panelGraficaVectorDesordenado = new ChartPanel(graficaVectorDesordenado);
       panelGraficaVectorDesordenado.setMouseWheelEnabled(true);
       panelGraficaVectorDesordenado.setBounds(505,275,490,400);
       panel.add(panelGraficaVectorDesordenado);
       repaint();
       ordenado = Seleccion.ordenado;
   }

    private void ordenarPorMergeSort(){
       Merge merge = new Merge();
       areaTextoSalida.append(merge.mergeTime(vectorRandomDesordenado));
       for (int i = 0; i < Merge.ordenado.length; i++) {
           datosIniciales.setValue(Merge.ordenado[i]," posicion "+i," " );
       }
       graficaVectorDesordenado = ChartFactory.createBarChart(
               "vector",
               null,
               null,
               datosIniciales,
               PlotOrientation.VERTICAL,
               true,
               true,
               false
       );
       panelGraficaVectorDesordenado = new ChartPanel(graficaVectorDesordenado);
       panelGraficaVectorDesordenado.setMouseWheelEnabled(true);
       panelGraficaVectorDesordenado.setBounds(505,275,490,400);
       panel.add(panelGraficaVectorDesordenado);
       repaint();
       ordenado = Merge.ordenado;
   }

    private void ordenarPorRadix(){
        Radix radix = new Radix();
        areaTextoSalida.append(radix.radixTime(vectorRandomDesordenado));
        for (int i = 0; i < Radix.ordenado.length; i++) {
            datosIniciales.setValue(Radix.ordenado[i]," posicion "+i," " );
        }
        graficaVectorDesordenado = ChartFactory.createBarChart(
                "vector",
                null,
                null,
                datosIniciales,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        panelGraficaVectorDesordenado = new ChartPanel(graficaVectorDesordenado);
        panelGraficaVectorDesordenado.setMouseWheelEnabled(true);
        panelGraficaVectorDesordenado.setBounds(505,275,490,400);
        panel.add(panelGraficaVectorDesordenado);
        repaint();
        ordenado = Radix.ordenado;
    }

    private void ordenarPorHeap(){
        Heap heap = new Heap();
        areaTextoSalida.append(heap.heapTime(vectorRandomDesordenado));
        for (int i = 0; i < Heap.ordenado.length; i++) {
            datosIniciales.setValue(Heap.ordenado[i]," posicion "+i," " );
        }
        graficaVectorDesordenado = ChartFactory.createBarChart(
                "vector",
                null,
                null,
                datosIniciales,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        panelGraficaVectorDesordenado = new ChartPanel(graficaVectorDesordenado);
        panelGraficaVectorDesordenado.setMouseWheelEnabled(true);
        panelGraficaVectorDesordenado.setBounds(505,275,490,400);
        panel.add(panelGraficaVectorDesordenado);
        repaint();
        ordenado = Heap.ordenado;
    }

    private void ordenarPorBucket(){
        Bucket bucket = new Bucket();
        areaTextoSalida.append(bucket.bucketTime(vectorRandomDesordenado));

        for (int i = 0; i < Bucket.ordenado.length; i++) {
            datosIniciales.setValue(Bucket.ordenado[i]," posicion "+i," " );
        }
        graficaVectorDesordenado = ChartFactory.createBarChart(
                "vector",
                null,
                null,
                datosIniciales,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        panelGraficaVectorDesordenado = new ChartPanel(graficaVectorDesordenado);
        panelGraficaVectorDesordenado.setMouseWheelEnabled(true);
        panelGraficaVectorDesordenado.setBounds(505,275,490,400);
        panel.add(panelGraficaVectorDesordenado);
        repaint();
        ordenado = Bucket.ordenado;

    }

    private void ordenarPorCounting(){
        Counting counting = new Counting();
        areaTextoSalida.append(counting.countingTime(vectorRandomDesordenado));
        for (int i = 0; i < Counting.ordenado.length; i++) {
            datosIniciales.setValue(Counting.ordenado[i]," posicion "+i," " );
        }
        graficaVectorDesordenado = ChartFactory.createBarChart(
                "vector",
                null,
                null,
                datosIniciales,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        panelGraficaVectorDesordenado = new ChartPanel(graficaVectorDesordenado);
        panelGraficaVectorDesordenado.setMouseWheelEnabled(true);
        panelGraficaVectorDesordenado.setBounds(505,275,490,400);
        panel.add(panelGraficaVectorDesordenado);
        repaint();
        ordenado = Counting.ordenado;
    }
}