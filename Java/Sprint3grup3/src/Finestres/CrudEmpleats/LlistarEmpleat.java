package Finestres.CrudEmpleats;

import Clases.Persona;
import Clases.RepositoriPersones;
import Finestres.FinestraPrincipal;

import javax.swing.*;
import java.awt.*;

public class LlistarEmpleat {

    public JPanel panelLlistarEmpleat;
    public JButton tornarAtras;
    public JList listaEmpleats;
    public JScrollPane scrollPane;

    public RepositoriPersones repositoriPersones;
    public FinestraPrincipal finestraPrincipalRedireccionament;


    public LlistarEmpleat(FinestraPrincipal framePrincipal, RepositoriPersones repositoriPersones) {
        this.repositoriPersones = repositoriPersones;
        this.finestraPrincipalRedireccionament = framePrincipal;
    }


    public JPanel crearPanelLlistarEmpleat() {
        panelLlistarEmpleat = new JPanel();
        panelLlistarEmpleat.setPreferredSize(new Dimension(finestraPrincipalRedireccionament.ampladaFinestra, finestraPrincipalRedireccionament.alturaFinestra));
        panelLlistarEmpleat.setLayout(new GridLayout(2,1));

        tornarAtras = new JButton("Tornar enrere");

        llistarEmpleats();
        panelLlistarEmpleat.add(scrollPane);
        panelLlistarEmpleat.add(tornarAtras);

        tornarAtras.addActionListener(e ->{
            CrudEmpleat crudEmpleat = new CrudEmpleat(finestraPrincipalRedireccionament, repositoriPersones);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(crudEmpleat.crearCrudEmpleat());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

        return panelLlistarEmpleat;
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


