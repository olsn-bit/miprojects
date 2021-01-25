package Finestres.CrudProjectes;

import Clases.RepositoriPersones;
import Clases.RepositoriProjectes;
import Clases.RepositoriPropostes;
import Finestres.FinestraPrincipal;

import javax.swing.*;
import java.awt.*;

public class EditarProjecte {
        public JPanel panelEditarProjecte;
        public JButton tornarAtras, editarProjecte;
        public JList listaEditarProjecte;
        public JScrollPane scrollPaneEditar;

        public RepositoriPersones repositoriPersones;
        public RepositoriPropostes repositoriPropostes;
        public RepositoriProjectes repositoriProjectes;
        public FinestraPrincipal finestraPrincipalRedireccionament;




        public EditarProjecte(FinestraPrincipal framePrincipal, RepositoriPropostes repositoriPropostes, RepositoriProjectes repositoriProjectes, RepositoriPersones repositoriPersones) {
            this.repositoriPropostes = repositoriPropostes;
            this.repositoriProjectes = repositoriProjectes;
            this.repositoriPersones = repositoriPersones;
            this.finestraPrincipalRedireccionament = framePrincipal;
        }


        public JPanel crearPanelEditarProjecte() {
            panelEditarProjecte = new JPanel();
            panelEditarProjecte.setPreferredSize(new Dimension(finestraPrincipalRedireccionament.ampladaFinestra, finestraPrincipalRedireccionament.alturaFinestra));
            panelEditarProjecte.setLayout(new GridLayout(3,1));

            tornarAtras = new JButton("Tornar enrere");
            editarProjecte = new JButton("Editar");


            llistarProjecte();
            panelEditarProjecte.add(scrollPaneEditar);
            panelEditarProjecte.add(tornarAtras);
            panelEditarProjecte.add(editarProjecte);

            tornarAtras.addActionListener(e ->{
                CrudProjecte crudProjecte = new CrudProjecte(finestraPrincipalRedireccionament, repositoriPersones, repositoriPropostes, repositoriProjectes);
                finestraPrincipalRedireccionament.framePrincipal.setContentPane(crudProjecte.crearCrudProjecte());
                finestraPrincipalRedireccionament.framePrincipal.revalidate();
            });

            editarProjecte.addActionListener(e ->{
                AltaProjecte altaProjecte = new AltaProjecte(finestraPrincipalRedireccionament, repositoriPersones, repositoriPropostes, repositoriProjectes);
                finestraPrincipalRedireccionament.framePrincipal.setContentPane(altaProjecte.crearPanelAfegirProjecte());
                finestraPrincipalRedireccionament.framePrincipal.revalidate();

                altaProjecte.panelAfegirProjecte.remove(altaProjecte.crearProjecte);
                altaProjecte.panelAfegirProjecte.add(altaProjecte.editarProjecte);
                altaProjecte.panelAfegirProjecte.revalidate();

                altaProjecte.mostrarEntitatSeleccionat(listaEditarProjecte.getSelectedIndex());

            });

            return panelEditarProjecte;
        }

        public void llistarProjecte() {
            listaEditarProjecte = new JList(repositoriProjectes.arrayProjectes);
            listaEditarProjecte.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            listaEditarProjecte.setLayoutOrientation(JList.VERTICAL_WRAP);
            listaEditarProjecte.setVisibleRowCount(-1);

            scrollPaneEditar = new JScrollPane(listaEditarProjecte);
            scrollPaneEditar.setPreferredSize(new Dimension(250,400));

        }

    }




