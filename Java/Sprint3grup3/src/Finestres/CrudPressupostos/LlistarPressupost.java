package Finestres.CrudPressupostos;

import Clases.Pressupost;
import Clases.RepositoriPersones;
import Clases.RepositoriProjectes;
import Clases.RepositoriPropostes;
import Finestres.CrudProjectes.CrudProjecte;
import Finestres.FinestraPrincipal;

import javax.swing.*;
import java.awt.*;

public class LlistarPressupost {

    public JPanel panelLlistarPressupost;
    public JButton tornarAtras;
    public JList listaPressupost;
    public JScrollPane scrollPane;
    public Pressupost[] arraiPressupostos = new Pressupost[10];

    public RepositoriProjectes repositoriProjectes;
    public FinestraPrincipal finestraPrincipalRedireccionament;


    public LlistarPressupost(FinestraPrincipal framePrincipal, RepositoriProjectes repositoriProjectes) {
        this.repositoriProjectes = repositoriProjectes;
        this.finestraPrincipalRedireccionament = framePrincipal;
    }


    public JPanel crearPanelLlistarPressupost() {
        panelLlistarPressupost = new JPanel();
        panelLlistarPressupost.setPreferredSize(new Dimension(finestraPrincipalRedireccionament.ampladaFinestra, finestraPrincipalRedireccionament.alturaFinestra));
        panelLlistarPressupost.setLayout(new GridLayout(2,1));

        tornarAtras = new JButton("Tornar enrere");

        llistarPressupost();
        panelLlistarPressupost.add(scrollPane);
        panelLlistarPressupost.add(tornarAtras);


        tornarAtras.addActionListener(e -> {
            CrudPressupost crudPressupost = new CrudPressupost(finestraPrincipalRedireccionament, repositoriProjectes);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(crudPressupost.crearCrudPressupost());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });
        return panelLlistarPressupost;
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
