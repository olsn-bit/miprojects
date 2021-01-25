package Finestres.CrudPropostes;

import Clases.RepositoriEntitats;
import Clases.RepositoriPropostes;
import Finestres.FinestraPrincipal;

import javax.swing.*;
import java.awt.*;

public class EditarProposta {

        public JPanel panelEditarProposta;
        public JButton tornarAtras, editarProposta;
        public JList listaEditarPropostes;
        public JScrollPane scrollPaneEditar;

        public RepositoriPropostes repositoriPropostes;
        public FinestraPrincipal finestraPrincipalRedireccionament;
        public RepositoriEntitats repositoriEntitats;




        public EditarProposta(FinestraPrincipal framePrincipal, RepositoriPropostes repositoriPropostes, RepositoriEntitats repositoriEntitats) {
            this.repositoriPropostes = repositoriPropostes;
            this.finestraPrincipalRedireccionament = framePrincipal;
            this.repositoriEntitats = repositoriEntitats;
        }


        public JPanel crearPanelEditarProposta() {
            panelEditarProposta = new JPanel();
            panelEditarProposta.setPreferredSize(new Dimension(finestraPrincipalRedireccionament.ampladaFinestra, finestraPrincipalRedireccionament.alturaFinestra));
            panelEditarProposta.setLayout(new GridLayout(3,1));

            tornarAtras = new JButton("Tornar enrere");
            editarProposta = new JButton("Editar");


            llistarProposta();
            panelEditarProposta.add(scrollPaneEditar);
            panelEditarProposta.add(tornarAtras);
            panelEditarProposta.add(editarProposta);

            tornarAtras.addActionListener(e ->{
                CrudProposta crudProposta = new CrudProposta(finestraPrincipalRedireccionament, repositoriPropostes, repositoriEntitats);
                finestraPrincipalRedireccionament.framePrincipal.setContentPane(crudProposta.crearCrudProposta());
                finestraPrincipalRedireccionament.framePrincipal.revalidate();
            });

            editarProposta.addActionListener(e ->{
                AltaProposta altaProposta = new AltaProposta(finestraPrincipalRedireccionament, repositoriPropostes, repositoriEntitats);
                finestraPrincipalRedireccionament.framePrincipal.setContentPane(altaProposta.crearPanelAfegirProposta());
                finestraPrincipalRedireccionament.framePrincipal.revalidate();

                altaProposta.panelAfegirProposta.remove(altaProposta.crearProposta);
                altaProposta.panelAfegirProposta.add(altaProposta.editarProposta);
                altaProposta.panelAfegirProposta.revalidate();

                altaProposta.mostrarEntitatSeleccionat(listaEditarPropostes.getSelectedIndex());

            });

            return panelEditarProposta;
        }

        public void llistarProposta() {
            listaEditarPropostes = new JList(repositoriPropostes.arrayPropostes);
            listaEditarPropostes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            listaEditarPropostes.setLayoutOrientation(JList.HORIZONTAL_WRAP);
            listaEditarPropostes.setVisibleRowCount(-1);

            scrollPaneEditar = new JScrollPane(listaEditarPropostes);
            scrollPaneEditar.setPreferredSize(new Dimension(250,400));

        }

    }

