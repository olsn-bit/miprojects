package Finestres.CrudPropostes;

import Clases.RepositoriEntitats;
import Clases.RepositoriPropostes;
import Finestres.FinestraPrincipal;

import javax.swing.*;
import java.awt.*;

public class EliminarProposta {

    public JPanel panelEliminarProposta;
    public JButton tornarAtras, eliminarProposta;
    public JList listaProposta;
    public JScrollPane scrollPane;

    public RepositoriEntitats repositoriEntitats;
    public RepositoriPropostes repositoriPropostes;
    public FinestraPrincipal finestraPrincipalRedireccionament;


    public EliminarProposta(FinestraPrincipal framePrincipal, RepositoriPropostes repositoriPropostes, RepositoriEntitats repositoriEntitats) {
        this.repositoriEntitats = repositoriEntitats;
        this.repositoriPropostes = repositoriPropostes;
        this.finestraPrincipalRedireccionament = framePrincipal;
    }


    public JPanel crearPanelEliminarProposta() {
        panelEliminarProposta = new JPanel();
        panelEliminarProposta.setPreferredSize(new Dimension(finestraPrincipalRedireccionament.ampladaFinestra, finestraPrincipalRedireccionament.alturaFinestra));
        panelEliminarProposta.setLayout(new GridLayout(3,1));

        tornarAtras = new JButton("Tornar enrere");
        eliminarProposta = new JButton("Eliminar");

        llistarProposta();
        panelEliminarProposta.add(scrollPane);
        panelEliminarProposta.add(tornarAtras);
        panelEliminarProposta.add(eliminarProposta);

        tornarAtras.addActionListener(e ->{
            CrudProposta crudProposta = new CrudProposta(finestraPrincipalRedireccionament, repositoriPropostes , repositoriEntitats);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(crudProposta.crearCrudProposta());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

        eliminarProposta.addActionListener(e ->{
            repositoriPropostes.eliminarProposta(listaProposta.getSelectedIndex()+1);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(panelEliminarProposta);
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

        return panelEliminarProposta;
    }

    public void llistarProposta() {
        listaProposta = new JList(repositoriPropostes.arrayPropostes);
        listaProposta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaProposta.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        listaProposta.setVisibleRowCount(-1);

        scrollPane = new JScrollPane(listaProposta);
        scrollPane.setPreferredSize(new Dimension(250,400));

    }

}
