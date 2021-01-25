package Finestres.CrudPressupostos;

import Clases.Pressupost;
import Clases.RepositoriProjectes;
import Finestres.FinestraPrincipal;

import javax.swing.*;
import java.awt.*;

public class EliminarPressupost {

    public JPanel panelEliminarPressupost;
    public JButton tornarAtras, eliminarPressupost;
    public JList listaPressupost;
    public JScrollPane scrollPane;
    public Pressupost[] arraiPressupostos = new Pressupost[10];

    public RepositoriProjectes repositoriProjectes;
    public FinestraPrincipal finestraPrincipalRedireccionament;


    public EliminarPressupost(FinestraPrincipal framePrincipal, RepositoriProjectes repositoriProjectes) {
        this.repositoriProjectes = repositoriProjectes;
        this.finestraPrincipalRedireccionament = framePrincipal;
    }


    public JPanel crearPanelEliminarPressupost() {
        panelEliminarPressupost = new JPanel();
        panelEliminarPressupost.setPreferredSize(new Dimension(finestraPrincipalRedireccionament.ampladaFinestra, finestraPrincipalRedireccionament.alturaFinestra));
        panelEliminarPressupost.setLayout(new GridLayout(3,1));

        tornarAtras = new JButton("Tornar enrere");
        eliminarPressupost = new JButton("Eliminar Pressupost");

        llistarPressupost();
        panelEliminarPressupost.add(scrollPane);
        panelEliminarPressupost.add(tornarAtras);
        panelEliminarPressupost.add(eliminarPressupost);

        tornarAtras.addActionListener(e -> {
            CrudPressupost crudPressupost = new CrudPressupost(finestraPrincipalRedireccionament, repositoriProjectes);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(crudPressupost.crearCrudPressupost());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

        eliminarPressupost.addActionListener(e -> {
            for (int i = 0; i <= repositoriProjectes.arrayProjectes.length; i++) {
                if(arraiPressupostos[listaPressupost.getSelectedIndex()] == repositoriProjectes.arrayProjectes[i].getPressupostDelProjecte()){
                    repositoriProjectes.arrayProjectes[i].setPressupostDelProjecte(null);
                    break;
                }

            }
            CrudPressupost crudPressupost = new CrudPressupost(finestraPrincipalRedireccionament, repositoriProjectes);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(crudPressupost.crearCrudPressupost());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();


        });
        return panelEliminarPressupost;
    }

    public void llistarPressupost() {

        for (int i = 0; i < repositoriProjectes.arrayProjectes.length; i++) {

            if(repositoriProjectes.arrayProjectes[i] != null) {
                arraiPressupostos[i] = repositoriProjectes.arrayProjectes[i].getPressupostDelProjecte();
            }else{break;}
        }

        listaPressupost = new JList(arraiPressupostos);
        listaPressupost.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaPressupost.setLayoutOrientation(JList.VERTICAL_WRAP);
        listaPressupost.setVisibleRowCount(-1);

        scrollPane = new JScrollPane(listaPressupost);
        scrollPane.setPreferredSize(new Dimension(250,400));

    }

}


