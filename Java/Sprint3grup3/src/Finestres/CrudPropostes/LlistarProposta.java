package Finestres.CrudPropostes;

import Clases.RepositoriEntitats;
import Clases.RepositoriPersones;
import Clases.RepositoriPropostes;
import Finestres.CrudEmpleats.CrudEmpleat;
import Finestres.FinestraPrincipal;

import javax.swing.*;
import java.awt.*;

public class LlistarProposta {

    public JPanel panelLlistarProposta;
    public JButton tornarAtras;
    public JList listaProposta;
    public JScrollPane scrollPane;

    public FinestraPrincipal finestraPrincipalRedireccionament;
    public RepositoriPropostes repositoriPropostes;
    public RepositoriEntitats repositoriEntitats;


    public LlistarProposta(FinestraPrincipal framePrincipal, RepositoriPropostes repositoriPropostes, RepositoriEntitats  repositoriEntitats){
        this.finestraPrincipalRedireccionament = framePrincipal;
        this.repositoriPropostes = repositoriPropostes;
        this.repositoriEntitats = repositoriEntitats;
    }


    public JPanel crearPanelLlistarProposta() {
        panelLlistarProposta = new JPanel();
        panelLlistarProposta.setPreferredSize(new Dimension(finestraPrincipalRedireccionament.ampladaFinestra, finestraPrincipalRedireccionament.alturaFinestra));
        panelLlistarProposta.setLayout(new GridLayout(2,1));

        tornarAtras = new JButton("Tornar enrere");

        llistarProposta();
        panelLlistarProposta.add(scrollPane);
        panelLlistarProposta.add(tornarAtras);

        tornarAtras.addActionListener(e ->{
            CrudProposta crudProposta = new CrudProposta(finestraPrincipalRedireccionament, repositoriPropostes, repositoriEntitats);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(crudProposta.crearCrudProposta());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

        return panelLlistarProposta;
    }

    public void llistarProposta() {
        listaProposta = new JList(repositoriPropostes.arrayPropostes);
        listaProposta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaProposta.setLayoutOrientation(JList.VERTICAL_WRAP);
        listaProposta.setVisibleRowCount(-1);

        scrollPane = new JScrollPane(listaProposta);
        scrollPane.setPreferredSize(new Dimension(250,400));

    }

}
