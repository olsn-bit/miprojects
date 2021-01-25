package Finestres.CrudPressupostos;

import Clases.Pressupost;
import Clases.Projecte;
import Clases.RepositoriProjectes;
import Finestres.FinestraPrincipal;

import javax.swing.*;
import java.awt.*;


public class CrearPressupost {

    public JPanel panelAfegirPressupost;
    public JButton crearPressupost, tornarAtras, editarPressupost;
    public JLabel textNomPressupost,textLiniaPressupost,textpreuLiniaPressupost,textPressupost;
    public JTextField nomPressupost,nomLiniaPressupost,preuLiniaPressupost;
    public JList listaPressupost;
    public JScrollPane scrollPane;
    public int preuTotalPressupost;

    public RepositoriProjectes repositoriProjectes;
    public FinestraPrincipal finestraPrincipalRedireccionament;


    public CrearPressupost(FinestraPrincipal framePrincipal,RepositoriProjectes repositoriProjectes) {
        this.repositoriProjectes = repositoriProjectes;
        this.finestraPrincipalRedireccionament = framePrincipal;
    }


    public JPanel crearPanelAfegirPressupost() {

        panelAfegirPressupost = new JPanel();
        panelAfegirPressupost.setPreferredSize(new Dimension(finestraPrincipalRedireccionament.ampladaFinestra, finestraPrincipalRedireccionament.alturaFinestra));
        panelAfegirPressupost.setLayout(new GridLayout(5,2));

        crearBotonsAfegirPressupost();

        return panelAfegirPressupost;
    }

    public void crearBotonsAfegirPressupost() {

        crearPressupost = new JButton("Afegir");
        tornarAtras = new JButton("Tornar atras");
        editarPressupost = new JButton("Guardar");

        textNomPressupost = new JLabel("Nom Pressupost : ");
        textLiniaPressupost = new JLabel("Nom Linia Pressupost : ");
        textpreuLiniaPressupost = new JLabel("Cost Linia Pressupost");
        textPressupost = new JLabel("Selecciona el Projecte");

        nomPressupost = new JTextField();
        nomLiniaPressupost = new JTextField();
        preuLiniaPressupost = new JTextField();


        crearPressupost.addActionListener(e -> {
            if(nomPressupost.getText().isEmpty()){

                finestraPrincipalRedireccionament.crearAlertWindow("No s'apugut afegir, falta el nom.");

            }else if(nomLiniaPressupost.getText().isEmpty()){

                finestraPrincipalRedireccionament.crearAlertWindow("No s'apugut afegir, falten les linies del Pressupost");

            }else if(preuLiniaPressupost.getText().isEmpty()){

                finestraPrincipalRedireccionament.crearAlertWindow("No s'apugut afegir, falta els preus de les linies del Pressupost");

            }else if(listaPressupost.getSelectedIndex() < 0){

                finestraPrincipalRedireccionament.crearAlertWindow("No s'apugut afegir, falta el projecte del pressupost");

            }else{
                Integer[] arrayIntegers = {Integer.parseInt(preuLiniaPressupost.getText())};
                String[] arrayString = {nomLiniaPressupost.getText()};
                preuTotalPressupost=Integer.parseInt(preuLiniaPressupost.getText());
                Pressupost pressupost = new Pressupost(preuTotalPressupost, arrayIntegers, arrayString, nomPressupost.getText());

                finestraPrincipalRedireccionament.crearAlertWindow("S'ha afegit correctament");
                repositoriProjectes.arrayProjectes[listaPressupost.getSelectedIndex()].setPressupostDelProjecte(pressupost);

                nomPressupost.setText("");
                preuLiniaPressupost.setText("");
                nomLiniaPressupost.setText("");
                listaPressupost.setSelectedValue(null,false);

            }
        });

        tornarAtras.addActionListener(e -> {
            CrudPressupost crudPressupost = new CrudPressupost(finestraPrincipalRedireccionament, repositoriProjectes);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(crudPressupost.crearCrudPressupost());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });
        llistarProjecte();
        this.panelAfegirPressupost.add(textNomPressupost);
        this.panelAfegirPressupost.add(nomPressupost);
        this.panelAfegirPressupost.add(textLiniaPressupost);
        this.panelAfegirPressupost.add(nomLiniaPressupost);
        this.panelAfegirPressupost.add(textpreuLiniaPressupost);
        this.panelAfegirPressupost.add(preuLiniaPressupost);
        this.panelAfegirPressupost.add(textPressupost);
        this.panelAfegirPressupost.add(listaPressupost);
        this.panelAfegirPressupost.add(crearPressupost);
        this.panelAfegirPressupost.add(tornarAtras);



    }

    public void llistarProjecte() {
        listaPressupost = new JList(repositoriProjectes.arrayProjectes);
        listaPressupost.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaPressupost.setLayoutOrientation(JList.VERTICAL_WRAP);
        listaPressupost.setVisibleRowCount(-1);

        scrollPane = new JScrollPane(listaPressupost);
        scrollPane.setPreferredSize(new Dimension(250,400));

    }

    public void mostrarPressupostSeleccionat(int index){

        this.nomPressupost.setText(repositoriProjectes.arrayProjectes[index].getPressupostDelProjecte().getNom());
        this.nomLiniaPressupost.setText(repositoriProjectes.arrayProjectes[index].getPressupostDelProjecte().getnomPreus());
        this.preuLiniaPressupost.setText(repositoriProjectes.arrayProjectes[index].getPressupostDelProjecte().getLlistaPreus().toString());

        listaPressupost.setSelectedValue(repositoriProjectes.arrayProjectes[index], true);
        editarPressupost.addActionListener(e -> {
            editarPressupost(repositoriProjectes.arrayProjectes[index].getPressupostDelProjecte(), repositoriProjectes.arrayProjectes[index]);
        });
    }

    public void editarPressupost(Pressupost pressupostAEditar, Projecte projecteAEditar){

        Integer[] arrayIntegers = {Integer.parseInt(preuLiniaPressupost.getText())};
        String[] arrayString = {nomLiniaPressupost.getText()};
        preuTotalPressupost=Integer.parseInt(preuLiniaPressupost.getText());

        pressupostAEditar.setNom(nomPressupost.getText());
        pressupostAEditar.setnomPreus(arrayString);
        pressupostAEditar.setLlistaPreus(arrayIntegers);
        pressupostAEditar.setPreuTotal(preuTotalPressupost);


        projecteAEditar.setPressupostDelProjecte(pressupostAEditar);

        CrudPressupost crudPressupost = new CrudPressupost(finestraPrincipalRedireccionament, repositoriProjectes);
        finestraPrincipalRedireccionament.framePrincipal.setContentPane(crudPressupost.crearCrudPressupost());
        finestraPrincipalRedireccionament.framePrincipal.revalidate();

    }



}
