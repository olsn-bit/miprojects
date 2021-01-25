package Finestres.CrudEmpleats;

import Clases.RepositoriPersones;
import Finestres.FinestraPrincipal;

import javax.swing.*;
import java.awt.*;

public class EditarEmpleat {

    public JPanel panelEditarEmpleat;
    public JButton tornarAtras, editarEmpleat;
    public JList listaEditarEmpleats;
    public JScrollPane scrollPaneEditar;
    //public JTextField nomEmpleat, dniEmpleat, nssEmpleat, codiEmpleat;
    public RepositoriPersones repositoriPersones;
    public FinestraPrincipal finestraPrincipalRedireccionament;




    public EditarEmpleat(FinestraPrincipal framePrincipal, RepositoriPersones repositoriPersones) {
        this.repositoriPersones = repositoriPersones;
        this.finestraPrincipalRedireccionament = framePrincipal;
    }


    public JPanel crearPanelEditarEmpleat() {
        panelEditarEmpleat = new JPanel();
        panelEditarEmpleat.setPreferredSize(new Dimension(finestraPrincipalRedireccionament.ampladaFinestra, finestraPrincipalRedireccionament.alturaFinestra));
        panelEditarEmpleat.setLayout(new GridLayout(3,1));

        tornarAtras = new JButton("Tornar enrere");
        editarEmpleat = new JButton("Editar");


        llistarEmpleats();
        panelEditarEmpleat.add(scrollPaneEditar);
        panelEditarEmpleat.add(tornarAtras);
        panelEditarEmpleat.add(editarEmpleat);

        tornarAtras.addActionListener(e ->{
            CrudEmpleat crudEmpleat = new CrudEmpleat(finestraPrincipalRedireccionament, repositoriPersones);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(crudEmpleat.crearCrudEmpleat());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

        editarEmpleat.addActionListener(e ->{


                AfegirEmpleat afegirEmpleat = new AfegirEmpleat(finestraPrincipalRedireccionament, repositoriPersones);
                finestraPrincipalRedireccionament.framePrincipal.setContentPane(afegirEmpleat.crearPanelAfegirEmpleat());
                finestraPrincipalRedireccionament.framePrincipal.revalidate();

                afegirEmpleat.panelAfegirEmpleat.remove(afegirEmpleat.crearEmpleat);
                afegirEmpleat.panelAfegirEmpleat.add(afegirEmpleat.editarEmpleat);
                afegirEmpleat.panelAfegirEmpleat.revalidate();

                afegirEmpleat.mostrarEmpleatSeleccionat(listaEditarEmpleats.getSelectedIndex());

        });

        return panelEditarEmpleat;
    }

    public void llistarEmpleats() {
        listaEditarEmpleats = new JList(repositoriPersones.arrayPersones);
        listaEditarEmpleats.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaEditarEmpleats.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        listaEditarEmpleats.setVisibleRowCount(-1);

        scrollPaneEditar = new JScrollPane(listaEditarEmpleats);
        scrollPaneEditar.setPreferredSize(new Dimension(250,400));

    }

}
