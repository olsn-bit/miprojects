package Finestres.CrudPressupostos;

import Clases.RepositoriPersones;
import Clases.RepositoriProjectes;
import Finestres.CrudEmpleats.AfegirEmpleat;
import Finestres.CrudEmpleats.EditarEmpleat;
import Finestres.CrudEmpleats.EliminarEmpleat;
import Finestres.CrudEmpleats.LlistarEmpleat;
import Finestres.FinestraPrincipal;
import javax.swing.*;
import java.awt.*;

public class CrudPressupost {

    public JPanel panelCrudPressupost;
    public JButton afegirPressupost,editarPressupost,eliminarPressupost,llistarPressupost,tornarAtras;

    public FinestraPrincipal finestraPrincipalRedireccionament;
    public RepositoriProjectes repositoriProjectes;

    public CrudPressupost(FinestraPrincipal framePrincipal, RepositoriProjectes repositoriProjectes) {
        this.finestraPrincipalRedireccionament = framePrincipal;
        this.repositoriProjectes = repositoriProjectes;
    }

    public JPanel crearCrudPressupost() {

        panelCrudPressupost = new JPanel();
        panelCrudPressupost.setPreferredSize(new Dimension(finestraPrincipalRedireccionament.ampladaFinestra, finestraPrincipalRedireccionament.alturaFinestra));
        panelCrudPressupost.setLayout(new GridLayout(5, 1, 1, 10));
        crearBotonsPressupost();

        return panelCrudPressupost;
    }

    public void crearBotonsPressupost(){
        afegirPressupost = new JButton("Afegir un Pressupost");
        editarPressupost = new JButton("Editar un Pressupost");
        eliminarPressupost = new JButton("Eliminar un Pressupost");
        llistarPressupost = new JButton("Llistar els Pressupost");
        tornarAtras = new JButton("Tornar atras");

        panelCrudPressupost.add(afegirPressupost);
        panelCrudPressupost.add(editarPressupost);
        panelCrudPressupost.add(eliminarPressupost);
        panelCrudPressupost.add(llistarPressupost);
        panelCrudPressupost.add(tornarAtras);

        afegirPressupost.addActionListener(e ->{
            CrearPressupost crearPressupost = new CrearPressupost(finestraPrincipalRedireccionament, repositoriProjectes);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(crearPressupost.crearPanelAfegirPressupost());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

        llistarPressupost.addActionListener(e ->{
            LlistarPressupost llistarPressupost = new LlistarPressupost(finestraPrincipalRedireccionament, repositoriProjectes);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(llistarPressupost.crearPanelLlistarPressupost());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

        editarPressupost.addActionListener(e ->{
            EditarPressupost editarPressupost = new EditarPressupost(finestraPrincipalRedireccionament, repositoriProjectes);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(editarPressupost.crearPanelEditarPressupost());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

        eliminarPressupost.addActionListener(e ->{
            EliminarPressupost eliminarPressupost = new EliminarPressupost(finestraPrincipalRedireccionament, repositoriProjectes);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(eliminarPressupost.crearPanelEliminarPressupost());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

        tornarAtras.addActionListener(e ->{
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(finestraPrincipalRedireccionament.panelPrincipal);
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });
    }

}
