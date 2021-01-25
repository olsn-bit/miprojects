package Finestres.CrudPropostes;

import Clases.RepositoriEntitats;
import Clases.RepositoriProjectes;
import Clases.RepositoriPropostes;
import Finestres.FinestraPrincipal;

import javax.swing.*;
import java.awt.*;

public class CrudProposta {

    public JPanel panelCrudProposta;
    public JButton afegirProposta,editarProposta,eliminarProposta,llistarProposta,tornarAtras;

    public FinestraPrincipal finestraPrincipalRedireccionament;
    public RepositoriPropostes repositoriPropostes;
    public RepositoriEntitats repositoriEntitats;

    public CrudProposta(FinestraPrincipal framePrincipal, RepositoriPropostes repositoriPropostes, RepositoriEntitats repositoriEntitats) {
        this.finestraPrincipalRedireccionament = framePrincipal;
        this.repositoriPropostes = repositoriPropostes;
        this.repositoriEntitats = repositoriEntitats;
    }

    public JPanel crearCrudProposta() {

        panelCrudProposta = new JPanel();
        panelCrudProposta.setPreferredSize(new Dimension(finestraPrincipalRedireccionament.ampladaFinestra, finestraPrincipalRedireccionament.alturaFinestra));
        panelCrudProposta.setLayout(new GridLayout(5, 1, 1, 10));
        crearBotonsEmpleat();

        return panelCrudProposta;
    }

    public void crearBotonsEmpleat(){
        afegirProposta = new JButton("Afegir una Proposta");
        editarProposta = new JButton("Editar una Proposta");
        eliminarProposta = new JButton("Eliminar una Proposta");
        llistarProposta = new JButton("Llistar les Proposta");
        tornarAtras = new JButton("Tornar atras");

        panelCrudProposta.add(afegirProposta);
        panelCrudProposta.add(editarProposta);
        panelCrudProposta.add(eliminarProposta);
        panelCrudProposta.add(llistarProposta);
        panelCrudProposta.add(tornarAtras);

        afegirProposta.addActionListener(e ->{
            AltaProposta altaProposta = new AltaProposta(finestraPrincipalRedireccionament, repositoriPropostes, repositoriEntitats);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(altaProposta.crearPanelAfegirProposta());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

        llistarProposta.addActionListener(e ->{
            LlistarProposta llistarProposta = new LlistarProposta(finestraPrincipalRedireccionament, repositoriPropostes, repositoriEntitats);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(llistarProposta.crearPanelLlistarProposta());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

        editarProposta.addActionListener(e ->{
            EditarProposta editarProposta = new EditarProposta(finestraPrincipalRedireccionament, repositoriPropostes, repositoriEntitats);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(editarProposta.crearPanelEditarProposta());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

        eliminarProposta.addActionListener(e ->{
            EliminarProposta eliminarProposta = new EliminarProposta(finestraPrincipalRedireccionament, repositoriPropostes, repositoriEntitats);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(eliminarProposta.crearPanelEliminarProposta());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

        tornarAtras.addActionListener(e ->{
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(finestraPrincipalRedireccionament.panelPrincipal);
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });
    }
}

