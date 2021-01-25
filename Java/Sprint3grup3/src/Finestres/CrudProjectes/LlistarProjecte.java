package Finestres.CrudProjectes;

import Clases.RepositoriPersones;
import Clases.RepositoriProjectes;
import Clases.RepositoriPropostes;
import Finestres.FinestraPrincipal;

import javax.swing.*;
import java.awt.*;

public class LlistarProjecte {

    public JPanel panelLlistarProjecte;
    public JButton tornarAtras;
    public JList listaProjecte;
    public JScrollPane scrollPane;

    public RepositoriPersones repositoriPersones;
    public RepositoriPropostes repositoriPropostes;
    public RepositoriProjectes repositoriProjectes;
    public FinestraPrincipal finestraPrincipalRedireccionament;


    public LlistarProjecte(FinestraPrincipal framePrincipal, RepositoriPropostes repositoriPropostes, RepositoriProjectes repositoriProjectes, RepositoriPersones repositoriPersones) {
        this.repositoriPropostes = repositoriPropostes;
        this.repositoriProjectes = repositoriProjectes;
        this.repositoriPersones = repositoriPersones;
        this.finestraPrincipalRedireccionament = framePrincipal;
    }


    public JPanel crearPanelLlistarProjecte() {
        panelLlistarProjecte = new JPanel();
        panelLlistarProjecte.setPreferredSize(new Dimension(finestraPrincipalRedireccionament.ampladaFinestra, finestraPrincipalRedireccionament.alturaFinestra));
        panelLlistarProjecte.setLayout(new GridLayout(2,1));

        tornarAtras = new JButton("Tornar enrere");

        llistarProjectes();
        panelLlistarProjecte.add(scrollPane);
        panelLlistarProjecte.add(tornarAtras);

        tornarAtras.addActionListener(e ->{
            CrudProjecte crudProjecte = new CrudProjecte(finestraPrincipalRedireccionament, repositoriPersones, repositoriPropostes, repositoriProjectes);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(crudProjecte.crearCrudProjecte());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

        return panelLlistarProjecte;
    }

    public void llistarProjectes() {
        listaProjecte = new JList(repositoriProjectes.arrayProjectes);
        listaProjecte.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaProjecte.setLayoutOrientation(JList.VERTICAL_WRAP);
        listaProjecte.setVisibleRowCount(-1);

        scrollPane = new JScrollPane(listaProjecte);
        scrollPane.setPreferredSize(new Dimension(250,400));

    }

}


