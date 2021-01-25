package Finestres.CrudEmpleats;

import Clases.RepositoriPersones;
import Finestres.FinestraPrincipal;

import javax.swing.*;
import java.awt.*;

public class EliminarEmpleat {

    public JPanel panelEliminarEmpleat;
    public JButton tornarAtras, eliminarEmpleat;
    public JList listaEmpleats;
    public JScrollPane scrollPane;

    public RepositoriPersones repositoriPersones;
    public FinestraPrincipal finestraPrincipalRedireccionament;


    public EliminarEmpleat(FinestraPrincipal framePrincipal, RepositoriPersones repositoriPersones) {
        this.repositoriPersones = repositoriPersones;
        this.finestraPrincipalRedireccionament = framePrincipal;
    }


    public JPanel crearPanelEliminarEmpleat() {
        panelEliminarEmpleat = new JPanel();
        panelEliminarEmpleat.setPreferredSize(new Dimension(finestraPrincipalRedireccionament.ampladaFinestra, finestraPrincipalRedireccionament.alturaFinestra));
        panelEliminarEmpleat.setLayout(new GridLayout(3,1));

        tornarAtras = new JButton("Tornar enrere");
        eliminarEmpleat = new JButton("Eliminar");

        llistarEmpleats();
        panelEliminarEmpleat.add(scrollPane);
        panelEliminarEmpleat.add(tornarAtras);
        panelEliminarEmpleat.add(eliminarEmpleat);

        tornarAtras.addActionListener(e ->{
            CrudEmpleat crudEmpleat = new CrudEmpleat(finestraPrincipalRedireccionament, repositoriPersones);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(crudEmpleat.crearCrudEmpleat());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

        eliminarEmpleat.addActionListener(e ->{
            repositoriPersones.eliminarPersona(listaEmpleats.getSelectedIndex());
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(panelEliminarEmpleat);
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

        return panelEliminarEmpleat;
    }

    public void llistarEmpleats() {
        listaEmpleats = new JList(repositoriPersones.arrayPersones);
        listaEmpleats.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaEmpleats.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        listaEmpleats.setVisibleRowCount(-1);


        scrollPane = new JScrollPane(listaEmpleats);
        scrollPane.setPreferredSize(new Dimension(250,400));

    }

}
