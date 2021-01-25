package Finestres.CrudEmpleats;

import Clases.RepositoriPersones;
import Finestres.FinestraPrincipal;
import javax.swing.*;
import java.awt.*;

public class CrudEmpleat{

    public JPanel panelCrudEmpleat;
    public JButton afegirEmpleat,editarEmpleat,eliminarEmpleat,llistarEnpleat,tornarAtras;
    public FinestraPrincipal finestraPrincipalRedireccionament;
    public RepositoriPersones repositoriPersones;

    public CrudEmpleat(FinestraPrincipal framePrincipal, RepositoriPersones repositoriPersones) {
        this.finestraPrincipalRedireccionament = framePrincipal;
        this.repositoriPersones = repositoriPersones;
    }

    public JPanel crearCrudEmpleat() {

        panelCrudEmpleat = new JPanel();
        panelCrudEmpleat.setPreferredSize(new Dimension(finestraPrincipalRedireccionament.ampladaFinestra, finestraPrincipalRedireccionament.alturaFinestra));
        panelCrudEmpleat.setLayout(new GridLayout(5, 1, 1, 10));
        crearBotonsEmpleat();

        return panelCrudEmpleat;
    }

    public void crearBotonsEmpleat(){
        afegirEmpleat = new JButton("Afegir un Empleat");
        editarEmpleat = new JButton("Editar un Empleat");
        eliminarEmpleat = new JButton("Eliminar un Empleat");
        llistarEnpleat = new JButton("Llistar els Empleats");
        tornarAtras = new JButton("Tornar atras");

        panelCrudEmpleat.add(afegirEmpleat);
        panelCrudEmpleat.add(editarEmpleat);
        panelCrudEmpleat.add(eliminarEmpleat);
        panelCrudEmpleat.add(llistarEnpleat);
        panelCrudEmpleat.add(tornarAtras);

        afegirEmpleat.addActionListener(e ->{
            AfegirEmpleat afegirEmpleat = new AfegirEmpleat(finestraPrincipalRedireccionament,repositoriPersones);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(afegirEmpleat.crearPanelAfegirEmpleat());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

        llistarEnpleat.addActionListener(e ->{
            LlistarEmpleat llistarEmpleats = new LlistarEmpleat(finestraPrincipalRedireccionament, repositoriPersones);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(llistarEmpleats.crearPanelLlistarEmpleat());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

        editarEmpleat.addActionListener(e ->{
            EditarEmpleat editarEmpleat = new EditarEmpleat(finestraPrincipalRedireccionament, repositoriPersones);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(editarEmpleat.crearPanelEditarEmpleat());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

        eliminarEmpleat.addActionListener(e ->{
            EliminarEmpleat eliminarEmpleat = new EliminarEmpleat(finestraPrincipalRedireccionament, repositoriPersones);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(eliminarEmpleat.crearPanelEliminarEmpleat());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

        tornarAtras.addActionListener(e ->{
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(finestraPrincipalRedireccionament.panelPrincipal);
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });
    }

}
