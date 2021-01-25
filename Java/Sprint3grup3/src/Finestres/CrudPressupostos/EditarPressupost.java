package Finestres.CrudPressupostos;

import Clases.Pressupost;
import Clases.RepositoriProjectes;
import Finestres.FinestraPrincipal;

import javax.swing.*;
import java.awt.*;

public class EditarPressupost {

    public JPanel panelEditarPressupost;
    public JButton tornarAtras, editarPressupost;
    public JList listaPressupost;
    public JScrollPane scrollPane;
    public Pressupost[] arraiPressupostos = new Pressupost[10];

    public RepositoriProjectes repositoriProjectes;
    public FinestraPrincipal finestraPrincipalRedireccionament;


    public EditarPressupost(FinestraPrincipal framePrincipal, RepositoriProjectes repositoriProjectes) {
        this.repositoriProjectes = repositoriProjectes;
        this.finestraPrincipalRedireccionament = framePrincipal;
    }


    public JPanel crearPanelEditarPressupost() {
        panelEditarPressupost = new JPanel();
        panelEditarPressupost.setPreferredSize(new Dimension(finestraPrincipalRedireccionament.ampladaFinestra, finestraPrincipalRedireccionament.alturaFinestra));
        panelEditarPressupost.setLayout(new GridLayout(3,1));

        tornarAtras = new JButton("Tornar enrere");
        editarPressupost = new JButton("Editar Pressupost");

        llistarPressupost();
        panelEditarPressupost.add(scrollPane);
        panelEditarPressupost.add(tornarAtras);
        panelEditarPressupost.add(editarPressupost);

        tornarAtras.addActionListener(e -> {
            CrudPressupost crudPressupost = new CrudPressupost(finestraPrincipalRedireccionament, repositoriProjectes);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(crudPressupost.crearCrudPressupost());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

        editarPressupost.addActionListener(e -> {
            for (int i = 0; i < repositoriProjectes.arrayProjectes.length; i++) {
                if (arraiPressupostos[listaPressupost.getSelectedIndex()] == repositoriProjectes.arrayProjectes[i].getPressupostDelProjecte()){

                    CrearPressupost crearPressupost = new CrearPressupost(finestraPrincipalRedireccionament, repositoriProjectes);
                    finestraPrincipalRedireccionament.framePrincipal.setContentPane(crearPressupost.crearPanelAfegirPressupost());
                    finestraPrincipalRedireccionament.framePrincipal.revalidate();

                    crearPressupost.panelAfegirPressupost.remove(crearPressupost.crearPressupost);
                    crearPressupost.panelAfegirPressupost.add(crearPressupost.editarPressupost);
                    finestraPrincipalRedireccionament.framePrincipal.revalidate();


                    crearPressupost.mostrarPressupostSeleccionat(i);
                    break;
                }
            }
        });
        return panelEditarPressupost;
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
