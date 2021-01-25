package Finestres.CrudProjectes;

import Clases.RepositoriPersones;
import Clases.RepositoriProjectes;
import Clases.RepositoriPropostes;
import Finestres.FinestraPrincipal;

import javax.swing.*;
import java.awt.*;

public class EliminarProjecte {

    public JPanel panelEliminarProjecte;
    public JButton tornarAtras, eliminarProjecte;
    public JList listaProjecte;
    public JScrollPane scrollPane;

    public RepositoriPersones repositoriPersones;
    public RepositoriPropostes repositoriPropostes;
    public RepositoriProjectes repositoriProjectes;
    public FinestraPrincipal finestraPrincipalRedireccionament;


    public EliminarProjecte(FinestraPrincipal framePrincipal, RepositoriPropostes repositoriPropostes, RepositoriProjectes repositoriProjectes, RepositoriPersones repositoriPersones) {
        this.repositoriPropostes = repositoriPropostes;
        this.repositoriProjectes = repositoriProjectes;
        this.repositoriPersones = repositoriPersones;
        this.finestraPrincipalRedireccionament = framePrincipal;
    }


    public JPanel crearPanelEliminarProjecte() {
        panelEliminarProjecte = new JPanel();
        panelEliminarProjecte.setPreferredSize(new Dimension(finestraPrincipalRedireccionament.ampladaFinestra, finestraPrincipalRedireccionament.alturaFinestra));
        panelEliminarProjecte.setLayout(new GridLayout(3,1));

        tornarAtras = new JButton("Tornar enrere");
        eliminarProjecte = new JButton("Eliminar");

        llistarProjectes();
        panelEliminarProjecte.add(scrollPane);
        panelEliminarProjecte.add(tornarAtras);
        panelEliminarProjecte.add(eliminarProjecte);

        tornarAtras.addActionListener(e ->{
            CrudProjecte crudProjecte = new CrudProjecte(finestraPrincipalRedireccionament, repositoriPersones, repositoriPropostes, repositoriProjectes);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(crudProjecte.crearCrudProjecte());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

        eliminarProjecte.addActionListener(e ->{
            repositoriProjectes.eliminarProjecte(listaProjecte.getSelectedIndex()+1);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(panelEliminarProjecte);
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

        return panelEliminarProjecte;
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



