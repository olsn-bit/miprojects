//////package Bingo;
////
////import javax.swing.*;
////import java.time.LocalDateTime;
////import java.time.format.DateTimeFormatter;
////import java.util.*;
////import javax.swing.border.MatteBorder;
////import java.awt.*;
////import java.awt.event.*;
////import java.io.*;
////import java.nio.charset.StandardCharsets;
////import java.nio.file.*;
////
////
////
////// 1. Afegir imatge a la part inferior dreta
////// 2. Poder guardar la llista a un txt: FileWriter();: https://stackoverflow.com/questions/22642415/way-to-save-jlist-data-into-a-txt-file/27588992#27588992
////// 3. Poder cargar del fitxer txt asta la llista: http://www.java2s.com/Tutorials/Java/Swing_How_to/JList/Load_a_TXT_File_into_a_JList.htm
////
////public class Main {
////    //Tenim que fer una llista amb un scrollbar per a visualitzar tots els elments de la llista https://stackoverflow.com/questions/14615888/list-of-jpanels-that-eventually-uses-a-scrollbar
////    //Com canviar/afegir valors a la llista amb els botons
////    //Disseny
////    //funcions importants "crec"
////    //validate();
////    //repaint();
////    static JTextField inputText;
////    final static ImageIcon Cofradia = new ImageIcon("https://www.google.com/imgres?imgurl=https://www.ebrebiosfera.org/sites/default/files/logo_web_8.jpg&imgrefurl=https://www.ebrebiosfera.org/es/copate/empreses/confraria-de-pescadors-verge-del-carme-de-sant-carles-de-la-rapita&tbnid=3bggvfYFt5S9lM&vet=1&docid=DDkVwE_QWzcMHM&w=960&h=720&source=sh/x/im");
////    static int contadorLlista = 0;
////    static DefaultListModel model = new DefaultListModel();
////    static JList b;
////    static Color color1=new Color(200, 255, 255);
////    static JMenuItem abrir;
////    static JMenuItem guardar;
////    static JMenuItem cerrar;
////
////    public static void main(String[] args){
////        System.out.println("--------------Gestio Projectes--------------\n" +
////                "1. Crear un Projecte nou\n" +
////                "2. Llistar Projectes\n" +
////                "3. Modificar un Projecte\n" +
////                "4. Sortir\n");
////        System.out.println("Escull una opció del menu superior:");
////    }
////    public static void suka(){
////        JFrame finestra = new JFrame("Bingo");
////        finestra.setSize(600, 440);
////        finestra.setLocationRelativeTo(null);
////        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////
////        JMenuBar barra=new JMenuBar();
////
////        JMenu archivo=new JMenu("Archivo");
////
////        abrir = new JMenuItem("Abrir");
////        abrir.addActionListener(new java.awt.event.ActionListener() {
////            public void actionPerformed(java.awt.event.ActionEvent evt) {
////                open(evt);
////            }
////        });
////
////        guardar = new JMenuItem("Guardar");
////        guardar.addActionListener(new java.awt.event.ActionListener() {
////            public void actionPerformed(java.awt.event.ActionEvent evt) {
////                save(evt);
////            }
////        });
////
////        cerrar = new JMenuItem("Cerrar");
////        cerrar.addActionListener(new java.awt.event.ActionListener() {
////            public void actionPerformed(java.awt.event.ActionEvent evt ) {
////                close(evt);
////            }
////        });
////
////        barra.add(archivo);
////        archivo.add(abrir);
////        archivo.add(guardar);
////        archivo.add(cerrar);
////        finestra.setJMenuBar(barra);
////
////        JPanel panel1 = new JPanel(); // el panel no está visible en la salida
////        JPanel panel2 = new JPanel(); // el panel no està visible en la salida
////        JPanel panel3 = new JPanel(); // el panel no esta visible en la salida
////        JButton addNew = new JButton("Afegir");
////        addNew.setBackground(color1);
////        addNew.setFont(new Font("Segoe UI", Font.BOLD, 14));
////        addNew.setPreferredSize(new Dimension(100,40));
////        addNew.addActionListener(new java.awt.event.ActionListener() {
////            public void actionPerformed(java.awt.event.ActionEvent evt) {
////                afegirBingo(evt);
////            }
////        });
////        Main.inputText =new JTextField(10);
////        inputText.setFont(new Font("Segoe UI", Font.PLAIN, 15));
////        JButton deleteBingo = new JButton("Eliminar");
////        deleteBingo.setFont(new Font("Segoe UI", Font.BOLD, 14));
////        deleteBingo.setBackground(color1);
////        deleteBingo.setPreferredSize(new Dimension(100,40));
////        deleteBingo.addActionListener(new java.awt.event.ActionListener() {
////            public void actionPerformed(java.awt.event.ActionEvent evt) {
////                eliminarBingo(evt);
////            }
////        });
////        JButton randomBingo = new JButton("Bingo");
////        randomBingo.setFont(new Font("Segoe UI", Font.BOLD, 16));
////        randomBingo.setBackground(color1);
////        randomBingo.setPreferredSize(new Dimension(300,40));
////        randomBingo.addActionListener(new java.awt.event.ActionListener() {
////            public void actionPerformed(java.awt.event.ActionEvent evt) {
////                bingoBingo(evt);
////            }
////        });
//////        addNew.addMouseListener(new MouseAdapter() {
//////            @Override
//////            public void mousePressed(MouseEvent e) {
//////                System.out.println("Funciona");
//////            }
//////        });
////
////
////
////        JScrollPane scrollPane = new JScrollPane();
////        //create list
////        b = new JList(model);
////        scrollPane.setViewportView(b);
////        //scrollPane.setSize(new Dimension(300,250));
////        scrollPane.setPreferredSize(new Dimension(300, 250));
////        b.setFont(new Font("Segoe UI", Font.BOLD, 15));
////        //CUIDAAAO model.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
////
////        panel1.add(scrollPane);
//////        scrollPane.setViewportView(b);
////        panel2.add(addNew);
////        panel2.add(inputText);
////        panel2.add(deleteBingo);
////        panel3.add(randomBingo);
////        Container contentPane = finestra.getContentPane();
////        contentPane.add(panel1, BorderLayout.NORTH);
////        contentPane.add(panel2, BorderLayout.CENTER);
////        contentPane.add(panel3, BorderLayout.SOUTH);
////        //PanelListener listener = new PanelListener();
////        finestra.setVisible(true);
////
////    }
////    public static void afegirBingo(java.awt.event.ActionEvent evt) {
////        //GET VALUE FROM INPUT
//////        inputText.getText();
////        String input = inputText.getText();
////        if ( !input.isEmpty()) {
////            contadorLlista++;
////            model.addElement(contadorLlista + ". " + input);
////            inputText.setText(null);
////        }
////        //ADD VALUE TO JLIST
////        //UPDATE
////    }
////
////    public static void eliminarBingo(java.awt.event.ActionEvent evt) {
////        String input = (String) b.getSelectedValue();
////        if ( input != null ) {
////            model.removeElement(input);
////            contadorLlista--;
////        }
////    }
////
////
////    public static void bingoBingo(java.awt.event.ActionEvent evt){
////        //System.out.println(model.elementAt( (int)(Math.random()*contadorLlista)))
////        JOptionPane.showMessageDialog(b,model.elementAt( (int)(Math.random()*contadorLlista)));
////    }
////
////    public static void open(java.awt.event.ActionEvent evt) {
////
////    }
////
////    public static void save(java.awt.event.ActionEvent evt) {
////        String elements = model.toString();
////        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-hh");
////        LocalDateTime now = LocalDateTime.now();
////        try {
////            FileWriter myWriter = new FileWriter("bingo"+dtf.format(now)+".txt");
////            myWriter.write(elements);
////            myWriter.close();
////        } catch (IOException e) {
////            System.out.println("An error occurred.");
////            e.printStackTrace();
////        }
////    }
////
////    public static void close(java.awt.event.ActionEvent evt) {
////        Object [] opciones ={"Si","No"};
////        int eleccion = JOptionPane.showOptionDialog(null,"¿Estas seguro que quieres cerrar el programa? \n Se perderán todos los datos no guardados.","Mensaje de Confirmacion",
////                JOptionPane.YES_NO_OPTION,
////                JOptionPane.QUESTION_MESSAGE,null,opciones,"Si");
////        if (eleccion == JOptionPane.YES_OPTION)
////        {
////            System.exit(0);
////        }else{
////        }
////    }
////
////}
////package Bingo;
//
//import javax.swing.*;
//import java.util.*;
//import javax.swing.border.MatteBorder;
//import javax.swing.filechooser.FileNameExtensionFilter;
//import java.awt.*;
//import java.awt.event.*;
//import java.io.*;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.*;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//
//// 1. Afegir imatge a la part inferior dreta
//// 3. Poder cargar del fitxer txt asta la llista: http://www.java2s.com/Tutorials/Java/Swing_How_to/JList/Load_a_TXT_File_into_a_JList.htm
//
//public class Main {
//    //Tenim que fer una llista amb un scrollbar per a visualitzar tots els elments de la llista https://stackoverflow.com/questions/14615888/list-of-jpanels-that-eventually-uses-a-scrollbar
//    //Com canviar/afegir valors a la llista amb els botons
//    //Disseny
//    //funcions importants "crec"
//    //validate();
//    //repaint();
//    static JTextField inputText;
//    final static ImageIcon Cofradia = new ImageIcon("https://www.google.com/imgres?imgurl=https://www.ebrebiosfera.org/sites/default/files/logo_web_8.jpg&imgrefurl=https://www.ebrebiosfera.org/es/copate/empreses/confraria-de-pescadors-verge-del-carme-de-sant-carles-de-la-rapita&tbnid=3bggvfYFt5S9lM&vet=1&docid=DDkVwE_QWzcMHM&w=960&h=720&source=sh/x/im");
//    static int contadorLlista = 0;
//    static DefaultListModel model = new DefaultListModel();
//    static JList b;
//    static Color color1 = new Color(200, 255, 255);
//    static JMenuItem abrir;
//    static JMenuItem guardar;
//    static JMenuItem cerrar;
//    static String input;
//    static int numBar = 100;
//    static String[] barques = new String[numBar];
//    static String bucle = null;
//    static JFrame finestra;
//
//
//    public static void main(String[] args) {
//        finestra = new JFrame("Bingo");
//        finestra.setSize(600, 440);
//        finestra.setLocationRelativeTo(null);
//        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JMenuBar barra = new JMenuBar();
//
//        JMenu archivo = new JMenu("Archivo");
//
//        abrir = new JMenuItem("Abrir");
//        abrir.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                open(evt);
//            }
//        });
//
//        guardar = new JMenuItem("Guardar");
//        guardar.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                save(evt);
//            }
//        });
//
//        cerrar = new JMenuItem("Cerrar");
//        cerrar.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                close(evt);
//            }
//        });
//
//        barra.add(archivo);
//        archivo.add(abrir);
//        archivo.add(guardar);
//        archivo.add(cerrar);
//        finestra.setJMenuBar(barra);
//
//        JPanel panel1 = new JPanel(); // el panel no está visible en la salida
//        JPanel panel2 = new JPanel(); // el panel no està visible en la salida
//        JPanel panel3 = new JPanel(); // el panel no esta visible en la salida
//        JButton addNew = new JButton("Afegir");
//        addNew.setBackground(color1);
//        addNew.setFont(new Font("Segoe UI", Font.BOLD, 14));
//        addNew.setPreferredSize(new Dimension(100, 40));
//        addNew.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                afegirBingo(evt);
//            }
//        });
//        Main.inputText = new JTextField(10);
//        inputText.setFont(new Font("Segoe UI", Font.PLAIN, 15));
//        JButton deleteBingo = new JButton("Eliminar");
//        deleteBingo.setFont(new Font("Segoe UI", Font.BOLD, 14));
//        deleteBingo.setBackground(color1);
//        deleteBingo.setPreferredSize(new Dimension(100, 40));
//        deleteBingo.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                eliminarBingo(evt);
//            }
//        });
//        JButton randomBingo = new JButton("Bingo");
//        randomBingo.setFont(new Font("Segoe UI", Font.BOLD, 16));
//        randomBingo.setBackground(color1);
//        randomBingo.setPreferredSize(new Dimension(300, 40));
//        randomBingo.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                bingoBingo(evt);
//            }
//        });
////        addNew.addMouseListener(new MouseAdapter() {
////            @Override
////            public void mousePressed(MouseEvent e) {
////                System.out.println("Funciona");
////            }
////        });
//
//
//        JScrollPane scrollPane = new JScrollPane();
//        //create list
//        b = new JList(model);
//        scrollPane.setViewportView(b);
//        //scrollPane.setSize(new Dimension(300,250));
//        scrollPane.setPreferredSize(new Dimension(300, 250));
//        b.setFont(new Font("Segoe UI", Font.BOLD, 15));
//        //CUIDAAAO model.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
//
//        panel1.add(scrollPane);
//        panel2.add(addNew);
//        panel2.add(inputText);
//        panel2.add(deleteBingo);
//        panel3.add(randomBingo);
//        Container contentPane = finestra.getContentPane();
//        contentPane.add(panel1, BorderLayout.NORTH);
//        contentPane.add(panel2, BorderLayout.CENTER);
//        contentPane.add(panel3, BorderLayout.SOUTH);
//        //PanelListener listener = new PanelListener();
//        finestra.setVisible(true);
//
//    }
//
//    public static void afegirBingo(java.awt.event.ActionEvent evt) {
//        //GET VALUE FROM INPUT
////        inputText.getText();
//        input = inputText.getText();
//        if ( !input.isEmpty() ) {
//            contadorLlista++;
//            model.addElement(contadorLlista + ". " + input);
//            inputText.setText(null);
//            if ( contadorLlista <= numBar ) {
//                barques[contadorLlista - 1] = input;
//            }
//        }
//        //ADD VALUE TO JLIST
//        //UPDATE
//    }
//
//    public static void eliminarBingo(java.awt.event.ActionEvent evt) {
//        String input = (String) b.getSelectedValue();
//        if ( input != null ) {
//            model.removeElement(input);
//            contadorLlista--;
//        }
//    }
//
//
//    public static void bingoBingo(java.awt.event.ActionEvent evt) {
//        //System.out.println(model.elementAt( (int)(Math.random()*contadorLlista)))
//        JOptionPane.showMessageDialog(b, model.elementAt((int) (Math.random() * contadorLlista)));
//    }
//
//    public static void open(java.awt.event.ActionEvent evt) {
//        try {
//            JFileChooser chooser = new JFileChooser();
//            FileNameExtensionFilter filter = new FileNameExtensionFilter(
//                    "Text Files", "txt");
//            chooser.setFileFilter(filter);
//            int returnVal = chooser.showOpenDialog(null);
//            if(returnVal == JFileChooser.APPROVE_OPTION) {
//                System.out.println("You chose to open this file: " +
//                        chooser.getSelectedFile().getName());
//            }
//            File myObj = new File(chooser.getSelectedFile().getName());
//            Scanner myReader = new Scanner(myObj);
//            while (myReader.hasNextLine()) {
//                String data = myReader.nextLine();
//                data = data.replace("[","");
//                data = data.replace("]","");
//                String[] dades = data.split(", ");
//                for (int e = 0; e < dades.length; e++) {
//                    contadorLlista++;
//                    model.addElement(dades[e]);
//                }
//            }
//            myReader.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//    }
//
//    public static void save(java.awt.event.ActionEvent evt) {
//        String elements = model.toString();
//        try {
//            JFileChooser fileChooser = new JFileChooser();
//            fileChooser.setDialogTitle("Specify a file to save");
//
//            int userSelection = fileChooser.showSaveDialog(Main.finestra);
//
//            if (userSelection == JFileChooser.APPROVE_OPTION) {
//                File fileToSave = fileChooser.getSelectedFile();
//                System.out.println("Save as file: " + fileToSave.getAbsolutePath());
//                FileWriter myWriter = new FileWriter(fileToSave.getAbsolutePath());
//                myWriter.write(elements);
//                myWriter.close();
//            }
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//    }
//
//    public static void close(java.awt.event.ActionEvent evt) {
//        Object[] opciones = {"Si", "No"};
//        int eleccion = JOptionPane.showOptionDialog(null, "¿Estas seguro que quieres cerrar el programa? \n Se perderán todos los datos no guardados.", "Mensaje de Confirmacion",
//                JOptionPane.YES_NO_OPTION,
//                JOptionPane.QUESTION_MESSAGE, null, opciones, "Si");
//        if ( eleccion == JOptionPane.YES_OPTION ) {
//            System.exit(0);
//        } else {
//        }
//    }
//
//}

//import javax.swing.*;
//import java.util.*;
//import java.awt.*;
//import java.io.*;
//
//
//
//// 1. Afegir imatge a la part inferior dreta
//// 2. Copiar l'arxiu guardat al paquet java Cofradia
//// 3. Alhora de eliminar l'arxiu, tambe s'elimine al paquet java Cofradia
//
//public class Main {
//    //Tenim que fer una llista amb un scrollbar per a visualitzar tots els elments de la llista https://stackoverflow.com/questions/14615888/list-of-jpanels-that-eventually-uses-a-scrollbar
//    //Com canviar/afegir valors a la llista amb els botons
//    //Disseny
//    //funcions importants "crec"
//    //validate();
//    //repaint();
//    static JTextField inputText;
//    final static ImageIcon Cofradia = new ImageIcon("https://www.google.com/imgres?imgurl=https://www.ebrebiosfera.org/sites/default/files/logo_web_8.jpg&imgrefurl=https://www.ebrebiosfera.org/es/copate/empreses/confraria-de-pescadors-verge-del-carme-de-sant-carles-de-la-rapita&tbnid=3bggvfYFt5S9lM&vet=1&docid=DDkVwE_QWzcMHM&w=960&h=720&source=sh/x/im");
//    static int contadorLlista = 0;
//    static DefaultListModel model = new DefaultListModel();
//    static JList b;
//    static Color color1 = new Color(200, 255, 255);
//    static JMenuItem abrir;
//    static JMenuItem guardar;
//    static JMenuItem cerrar;
//    static String input;
//    static int numBar = 100;
//    static String[] barques = new String[numBar];
//    static String bucle = null;
//    static JFrame finestra;
//    static JFileChooser fileChooser = new JFileChooser();
//
//
//    public static void main(String[] args) {
//        finestra = new JFrame("Bingo");
//        finestra.setSize(600, 440);
//        finestra.setLocationRelativeTo(null);
//        finestra.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
//        finestra.addWindowListener(new java.awt.event.WindowAdapter() {
//            @Override
//            public void windowClosing(java.awt.event.WindowEvent evt) {
//                close();
//            }
//        });
//
//        JMenuBar barra = new JMenuBar();
//
//        JMenu archivo = new JMenu("Archivo");
//
//        abrir = new JMenuItem("Abrir");
//        abrir.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                open(evt);
//            }
//        });
//
//        guardar = new JMenuItem("Guardar");
//        guardar.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                save(evt);
//            }
//        });
//
//        cerrar = new JMenuItem("Cerrar");
//        cerrar.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                close(evt);
//            }
//        });
//
//        barra.add(archivo);
//        archivo.add(abrir);
//        archivo.add(guardar);
//        archivo.add(cerrar);
//        finestra.setJMenuBar(barra);
//
//        JPanel panel1 = new JPanel(); // el panel no está visible en la salida
//        JPanel panel2 = new JPanel(); // el panel no està visible en la salida
//        JPanel panel3 = new JPanel(); // el panel no esta visible en la salida
//        JButton addNew = new JButton("Añadir");
//        addNew.setBackground(color1);
//        addNew.setFont(new Font("Segoe UI", Font.BOLD, 14));
//        addNew.setPreferredSize(new Dimension(100, 40));
//        addNew.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                afegirBingo(evt);
//            }
//        });
//        Main.inputText = new JTextField(10);
//        inputText.setFont(new Font("Segoe UI", Font.PLAIN, 15));
//        JButton deleteBingo = new JButton("Eliminar");
//        deleteBingo.setFont(new Font("Segoe UI", Font.BOLD, 14));
//        deleteBingo.setBackground(color1);
//        deleteBingo.setPreferredSize(new Dimension(100, 40));
//        deleteBingo.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                eliminarBingo(evt);
//            }
//        });
//        JButton randomBingo = new JButton("Bingo");
//        randomBingo.setFont(new Font("Segoe UI", Font.BOLD, 16));
//        randomBingo.setBackground(color1);
//        randomBingo.setPreferredSize(new Dimension(300, 40));
//        randomBingo.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                bingoBingo(evt);
//            }
//        });
////        addNew.addMouseListener(new MouseAdapter() {
////            @Override
////            public void mousePressed(MouseEvent e) {
////                System.out.println("Funciona");
////            }
////        });
//
//
//        JScrollPane scrollPane = new JScrollPane();
//        //create list
//        b = new JList(model);
//        scrollPane.setViewportView(b);
//        //scrollPane.setSize(new Dimension(300,250));
//        scrollPane.setPreferredSize(new Dimension(300, 250));
//        b.setFont(new Font("Segoe UI", Font.BOLD, 15));
//        //CUIDAAAO model.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
//
//        panel1.add(scrollPane);
//        panel2.add(addNew);
//        panel2.add(inputText);
//        panel2.add(deleteBingo);
//        panel3.add(randomBingo);
//        Container contentPane = finestra.getContentPane();
//        contentPane.add(panel1, BorderLayout.NORTH);
//        contentPane.add(panel2, BorderLayout.CENTER);
//        contentPane.add(panel3, BorderLayout.SOUTH);
//        //PanelListener listener = new PanelListener();
//        finestra.setVisible(true);
//
//    }
//
//    public static void afegirBingo(java.awt.event.ActionEvent evt) {
//        //GET VALUE FROM INPUT
////        inputText.getText();
//        input = inputText.getText();
//        if ( !input.isEmpty() ) {
//            contadorLlista++;
//            model.addElement(contadorLlista + ". " + input);
//            inputText.setText(null);
//            if ( contadorLlista <= numBar ) {
//                barques[contadorLlista - 1] = input;
//            }
//        }
//        //ADD VALUE TO JLIST
//        //UPDATE
//    }
//
//    public static void eliminarBingo(java.awt.event.ActionEvent evt) {
//        String input = (String) b.getSelectedValue();
//        if ( input != null ) {
//            model.removeElement(input);
//            contadorLlista--;
//        }
//    }
//
//
//    public static void bingoBingo(java.awt.event.ActionEvent evt) {
//        //System.out.println(model.elementAt( (int)(Math.random()*contadorLlista)))
//        JOptionPane.showMessageDialog(b, model.elementAt((int) (Math.random() * contadorLlista)));
//    }
//
//    public static void open(java.awt.event.ActionEvent evt) {
//        try {
//            JFileChooser chooser = new JFileChooser();
//            int returnVal = chooser.showOpenDialog(null);
//            if(returnVal == JFileChooser.APPROVE_OPTION) {
//                Object[] opciones = {"Si", "No"};
//                int eleccion = JOptionPane.showOptionDialog(null, "¿Estas seguro que quieres abrir el documento? \n Se perderán todos los datos no guardados.", "Mensaje de Confirmacion",
//                        JOptionPane.YES_NO_OPTION,
//                        JOptionPane.QUESTION_MESSAGE, null, opciones, "Si");
//                if ( eleccion == JOptionPane.YES_OPTION ) {
//                    File myObj = new File(chooser.getSelectedFile().getName());
//                    Scanner myReader = new Scanner(myObj);
//                    model.removeAllElements();
//                    while (myReader.hasNextLine()) {
//                        String data = myReader.nextLine();
//                        data = data.replace("[","");
//                        data = data.replace("]","");
//                        String[] dades = data.split(", ");
//                        for (int e = 0; e < dades.length; e++) {
//                            contadorLlista++;
//                            model.addElement(dades[e]);
//                        }
//                    }
//                    myReader.close();
//                }
//
//            }
//
//
//        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//    }
//
//    public static void save(java.awt.event.ActionEvent evt) {
//        String elements = model.toString();
//        try {
//
//            fileChooser.setDialogTitle("Specify a file to save");
//
//            int userSelection = fileChooser.showSaveDialog(Main.finestra);
//
//            if (userSelection == JFileChooser.APPROVE_OPTION) {
//                File fileToSave = fileChooser.getSelectedFile();
//                System.out.println("Save as file: " + fileToSave.getAbsolutePath());
//                FileWriter myWriter = new FileWriter(fileToSave.getAbsolutePath());
//                myWriter.write(elements);
//                myWriter.close();
//            }
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//    }
//
//    public static void close(java.awt.event.ActionEvent evt) {
//        String[] opciones = {"Si", "No"};
//        int eleccion = JOptionPane.showOptionDialog(null, "¿Estas seguro que quieres cerrar el programa? \n Se perderán todos los datos no guardados.", "Mensaje de Confirmacion",
//                JOptionPane.YES_NO_OPTION,
//                JOptionPane.QUESTION_MESSAGE, null, opciones, "Si");
//        if ( eleccion == JOptionPane.YES_OPTION ) {
//            System.exit(0);
//        } else {
//        }
//    }
//    public static void close() {
//        String[] opciones = {"Si", "No"};
//        int eleccion = JOptionPane.showOptionDialog(null, "¿Estas seguro que quieres cerrar el programa? \n Se perderán todos los datos no guardados.", "Mensaje de Confirmacion",
//                JOptionPane.YES_NO_OPTION,
//                JOptionPane.QUESTION_MESSAGE, null, opciones, "Si");
//        if ( eleccion == JOptionPane.YES_OPTION ) {
//            System.exit(0);
//        } else {
//        }
//    }
//
//}


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


// 1. Afegir imatge a la part inferior dreta

public class Main {
    //Tenim que fer una llista amb un scrollbar per a visualitzar tots els elments de la llista https://stackoverflow.com/questions/14615888/list-of-jpanels-that-eventually-uses-a-scrollbar
    //Com canviar/afegir valors a la llista amb els botons
    //Disseny
    //funcions importants "crec"
    //validate();
    //repaint();
    static JTextField inputText;
    final static ImageIcon Cofradia = new ImageIcon("https://www.google.com/imgres?imgurl=https://www.ebrebiosfera.org/sites/default/files/logo_web_8.jpg&imgrefurl=https://www.ebrebiosfera.org/es/copate/empreses/confraria-de-pescadors-verge-del-carme-de-sant-carles-de-la-rapita&tbnid=3bggvfYFt5S9lM&vet=1&docid=DDkVwE_QWzcMHM&w=960&h=720&source=sh/x/im");
    static int contadorLlista = 0;
    static DefaultListModel model = new DefaultListModel();
    static JList b;
    static Color color1 = new Color(200, 255, 255);
    static JMenuItem abrir;
    static JMenuItem guardar;
    static JMenuItem cerrar;
    static String input;
    static int numBar = 100;
    static String[] barques = new String[numBar];
    static String bucle = null;
    static JFrame finestra;
    static JFileChooser fileChooser = new JFileChooser();


    public static void main(String[] args) {
        int n = 3;

        double total = 0;
        total = (n*(n+1)*(2*n+1))/6;
//        for(int e=0;e<=n;e++){
//            total += Math.pow(e,2);
//        }
        System.out.println(total);

//        finestra = new JFrame("Bingo");
//        finestra.setSize(600, 450);
//        finestra.setLocationRelativeTo(null);
//        finestra.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
//        finestra.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent evt) {
//                close();
//            }
//        });
//
//        JPanel panel1 = new JPanel(); // el panel no está visible en la salida
//        JPanel panel2 = new JPanel(); // el panel no està visible en la salida
//        JPanel panel3 = new JPanel();
//        // el panel no esta visible en la salida
//        JPanel bottomPanel = new JPanel(new BorderLayout());
//
//
//        JButton addNew = new JButton("Añadir");
//        addNew.setBackground(color1);
//        addNew.setFont(new Font("Segoe UI", Font.BOLD, 14));
//        addNew.setPreferredSize(new Dimension(100, 40));
//        addNew.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                afegirBingo(evt);
//            }
//        });
//        Main.inputText = new JTextField(10);
//        inputText.setFont(new Font("Segoe UI", Font.PLAIN, 15));
//        JButton deleteBingo = new JButton("Eliminar");
//        deleteBingo.setFont(new Font("Segoe UI", Font.BOLD, 14));
//        deleteBingo.setBackground(color1);
//        deleteBingo.setPreferredSize(new Dimension(100, 40));
//        deleteBingo.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                eliminarBingo(evt);
//            }
//        });
//        JButton randomBingo = new JButton("Bingo");
//        randomBingo.setFont(new Font("Segoe UI", Font.BOLD, 16));
//        randomBingo.setBackground(color1);
//        randomBingo.setPreferredSize(new Dimension(300, 40));
//        randomBingo.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                bingoBingo(evt);
//            }
//        });
//
//        JButton icono = new JButton ("");
//        icono.setIcon(new ImageIcon("src/Imatges/Icono.png"));
//        icono.setPreferredSize(new Dimension(110, 90));
//
//        JScrollPane scrollPane = new JScrollPane();
//        //create list
//        b = new JList(model);
//        scrollPane.setViewportView(b);
//        //scrollPane.setSize(new Dimension(300,250));
//        scrollPane.setPreferredSize(new Dimension(300, 250));
//        b.setFont(new Font("Segoe UI", Font.BOLD, 15));
//        //CUIDAAAO model.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
//
//        panel1.add(scrollPane);
//        panel2.add(addNew);
//        panel2.add(inputText);
//        panel2.add(deleteBingo);
//        panel3.add(randomBingo);
//        panel3.add(icono);
//        //bottomPanel.add(icono, BorderLayout.LINE_END);
//        Container contentPane = finestra.getContentPane();
//        finestra.setContentPane(contentPane);
//        contentPane.add(panel1, BorderLayout.NORTH);
//        contentPane.add(panel2, BorderLayout.CENTER);
//        contentPane.add(panel3, BorderLayout.SOUTH);
//        //contentPane.add(bottomPanel, BorderLayout.SOUTH);
//        //PanelListener listener = new PanelListener();
//        finestra.setVisible(true);

    }

    public static void afegirBingo(java.awt.event.ActionEvent evt) {
        //GET VALUE FROM INPUT
//        inputText.getText();
        input = inputText.getText();
        if ( !input.isEmpty() ) {
            contadorLlista++;
            model.addElement(contadorLlista + ". " + input);
            inputText.setText(null);
            if ( contadorLlista <= numBar ) {
                barques[contadorLlista - 1] = input;
            }
        }
        //ADD VALUE TO JLIST
        //UPDATE
    }

    public static void eliminarBingo(java.awt.event.ActionEvent evt) {
        String input = (String) b.getSelectedValue();
        if ( input != null ) {
            model.removeElement(input);
            contadorLlista--;
        }
    }


    public static void bingoBingo(java.awt.event.ActionEvent evt) {
        //System.out.println(model.elementAt( (int)(Math.random()*contadorLlista)))
        if(model.isEmpty()){
            return;
        }
        JOptionPane.showMessageDialog(b, model.elementAt((int) (Math.random() * contadorLlista)));
    }

    public static void close() {
        if ( model.isEmpty() ){
            System.exit(0);
        }
        Object[] opciones = {"Si", "No"};
        int eleccion = JOptionPane.showOptionDialog(null, "¿Estas seguro que quieres cerrar el programa? \n              Se perderán todos los datos.", "Mensaje de Confirmacion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opciones, "Si");
        if ( eleccion == JOptionPane.YES_OPTION ) {
            System.exit(0);
        } else {
        }
    }


}