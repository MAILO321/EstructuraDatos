import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;//importacion de las librerias


public class OrdenamientoInterfaz {//NOMBRE DE LA CLASE A UTILIZAR

    //AQUI SE VAN ALMACENANDO LOS BOTONES QUE SE VAN CRENDO
    //CADA UNO DE TIPO PRIVADO
    private JPanel panelPrincipal;
    private JTable tabla;
    private JButton bubujaButton;
    private JButton quickSortButton;
    private JButton mergeSortButton;
    private JLabel resultado;

    //CREACION DE LOS DATOS PARA LOS CLIENTES EN UN ARRAY PARA ALMACENARLO
    public static Object[] columnas = {"NOMBRE DEL CLIENTE", "NUMERO DE COMPRAS", "CATEGORIA", "SALDO A DEBER"};
    //CREACION DE DE ARRAY DE DATOS EN PUBLICO Y VISIBILIDAD ESTATICO
    public static Object[][] datos = {
            {"PATRICIA EUGENIO ", 20, 'A', 2000.50},
            {"KEVIN MOLINA", 20, 'A', 2000.50},
            {"ARAGON ELIANETH", 20, 'A', 2000.50},
            {"KEVIN JAVIER", 10, 'B', 10000.20},
            {"IRIS SAMAHI", 30, 'S', 200.00},
            {"ANDRES JAHIR ", 20, 'A', 2000.50},
    };
    //METODOS DE ORDENAMIENTO CREADOS EN EL FORMULARIO
    public OrdenamientoInterfaz() {

        quickSortButton.addActionListener(new ActionListener() {
            @Override
            //dentro de este valor publico y tipo de dato void
            //se manda a llamar el metodo de ordenar que se crea mas adelante
            public void actionPerformed(ActionEvent e) {

                ordenarQuickSort();

            }
        });


        mergeSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarMergeSort();
            }
        });


        bubujaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    //se crea aparte los metodos a ordenar
    public void ordenarQuickSort() {//nombre del metodo

        List<String> nombres = new ArrayList<String>();
        //crear una lista con los nombres y dar un nuevo array
        //se inicializa un ciclo for para llenar los datos
        //se agrega el nombre de la tabla para sacar los datos
        //y get es para el tamaño de la tabla con un incremento
        for (int i = 0; i < tabla.getRowCount(); i++) {
            //a la variable nombre se le añade la tabla y se consigue la pocision del dato
            //se le añade un string para que pueda imprimirlo
            nombres.add(tabla.getValueAt(i, 0).toString());
        }
        //se manda a llamar el metodo que realiza el ordenamiento de kotlin
        //se coloca el parametro de nombres por que lo esta pidiendo


        MetodosOrdenamientoKt.tiempoQuicksort(nombres);

    }


    public void ordenarMergeSort() {

        List<String> nombres = new ArrayList<String>();

        for (int i = 0; i < tabla.getRowCount(); i++) {
            nombres.add(tabla.getValueAt(i, 0).toString());
        }

        //   MainKotlinKt.tiempoQuicksort(nombres);

        //  MainKotlinKt.imprimirListas(nombres);

        MetodosOrdenamientoKt.tiempoMergeSort(nombres);


    }
    //EL METODO PRINCIPAL PARA CORRER LA INTERFAZ
    public static void main(String[] args) {
        JFrame frame = new JFrame("VENTANA");
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                frame.setContentPane(new OrdenamientoInterfaz().panelPrincipal);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                frame.setSize(512, 512);
                frame.setLocationRelativeTo(null);
            }
        });
    }

    //estructura creada a partir del formulario de la tabla
    private void createUIComponents() {
        //se anexan los datos de la tabla
        DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
        //a la tabla se le añade el valor que trae modelo
        tabla = new JTable(modelo);
    }
}
