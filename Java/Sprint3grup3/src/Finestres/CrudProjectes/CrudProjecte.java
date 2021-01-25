package Finestres.CrudProjectes;

import Clases.RepositoriPersones;
import Clases.RepositoriProjectes;
import Clases.RepositoriPropostes;
import Finestres.FinestraPrincipal;
import javax.swing.*;
import java.awt.*;

public class CrudProjecte {

    public JPanel panelCrudProjecte;
    public JButton afegirProjecte,editarProjecte,eliminarProjecte,llistarProjecte,tornarAtras;

    public RepositoriPersones repositoriPersones;
    public RepositoriPropostes repositoriPropostes;
    public RepositoriProjectes repositoriProjectes;
    public FinestraPrincipal finestraPrincipalRedireccionament;

    public CrudProjecte(FinestraPrincipal finestraPrincipalRedireccionament, RepositoriPersones repositoriPersones, RepositoriPropostes repositoriPropostes, RepositoriProjectes repositoriProjectes){
        this.repositoriPersones = repositoriPersones;
        this.repositoriPropostes = repositoriPropostes;
        this.repositoriProjectes = repositoriProjectes;
        this.finestraPrincipalRedireccionament = finestraPrincipalRedireccionament;
    }

    public JPanel crearCrudProjecte() {

        panelCrudProjecte = new JPanel();
        panelCrudProjecte.setPreferredSize(new Dimension(finestraPrincipalRedireccionament.ampladaFinestra, finestraPrincipalRedireccionament.alturaFinestra));
        panelCrudProjecte.setLayout(new GridLayout(5, 1, 1, 10));
        crearBotonsEmpleat();

        return panelCrudProjecte;
    }

    public void crearBotonsEmpleat(){
        afegirProjecte = new JButton("Afegir un Projecte");
        editarProjecte = new JButton("Editar un Projecte");
        eliminarProjecte = new JButton("Eliminar un Projecte");
        llistarProjecte = new JButton("Llistar els Projectes");
        tornarAtras = new JButton("Tornar atras");

        panelCrudProjecte.add(afegirProjecte);
        panelCrudProjecte.add(editarProjecte);
        panelCrudProjecte.add(eliminarProjecte);
        panelCrudProjecte.add(llistarProjecte);
        panelCrudProjecte.add(tornarAtras);

        afegirProjecte.addActionListener(e ->{
           AltaProjecte altaProjecte = new AltaProjecte(finestraPrincipalRedireccionament, repositoriPersones, repositoriPropostes, repositoriProjectes);
           finestraPrincipalRedireccionament.framePrincipal.setContentPane(altaProjecte.crearPanelAfegirProjecte());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

        llistarProjecte.addActionListener(e ->{
            LlistarProjecte llistarProjecte = new LlistarProjecte(finestraPrincipalRedireccionament, repositoriPropostes, repositoriProjectes, repositoriPersones);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(llistarProjecte.crearPanelLlistarProjecte());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

        editarProjecte.addActionListener(e ->{
            EditarProjecte editarProjecte = new EditarProjecte(finestraPrincipalRedireccionament, repositoriPropostes, repositoriProjectes, repositoriPersones);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(editarProjecte.crearPanelEditarProjecte());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

        eliminarProjecte.addActionListener(e ->{
            EliminarProjecte eliminarProjecte = new EliminarProjecte(finestraPrincipalRedireccionament, repositoriPropostes, repositoriProjectes, repositoriPersones);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(eliminarProjecte.crearPanelEliminarProjecte());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

        tornarAtras.addActionListener(e ->{
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(finestraPrincipalRedireccionament.panelPrincipal);
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });
    }
}
