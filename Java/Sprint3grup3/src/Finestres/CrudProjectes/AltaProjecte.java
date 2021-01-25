package Finestres.CrudProjectes;

import Clases.*;
import Finestres.CrudPropostes.CrudProposta;
import Finestres.FinestraPrincipal;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AltaProjecte {

    public JPanel panelAfegirProjecte;
    public JButton crearProjecte, tornarAtras, editarProjecte;
    public JLabel escollirEmpleat, escollirProposta;
    public JList listaPropostes, listaEmpleats;
    public JScrollPane scrollPane,scrollPaneEmpleats;

    public RepositoriPersones repositoriPersones;
    public RepositoriPropostes repositoriPropostes;
    public RepositoriProjectes repositoriProjectes;
    public FinestraPrincipal finestraPrincipalRedireccionament;

    public AltaProjecte(FinestraPrincipal finestraPrincipalRedireccionament, RepositoriPersones repositoriPersones, RepositoriPropostes repositoriPropostes, RepositoriProjectes repositoriProjectes){
        this.repositoriPersones = repositoriPersones;
        this.repositoriPropostes = repositoriPropostes;
        this.repositoriProjectes = repositoriProjectes;
        this.finestraPrincipalRedireccionament = finestraPrincipalRedireccionament;
    }

    public JPanel crearPanelAfegirProjecte() {

        panelAfegirProjecte = new JPanel();
        panelAfegirProjecte.setPreferredSize(new Dimension(finestraPrincipalRedireccionament.ampladaFinestra, finestraPrincipalRedireccionament.alturaFinestra));
        panelAfegirProjecte.setLayout(new GridLayout(3,2));

        this.crearBotonsAfegirProjecte();

        return panelAfegirProjecte;
    }

    public void crearBotonsAfegirProjecte() {

        crearProjecte = new JButton("Afegir");
        tornarAtras = new JButton("Tornar atras");
        editarProjecte = new JButton("Guardar");

        escollirEmpleat = new JLabel("Cap del projecte:");
        escollirProposta = new JLabel("Proposta del projecte:");

        llistarEntitats();
        this.panelAfegirProjecte.add(escollirEmpleat);
        this.panelAfegirProjecte.add(scrollPaneEmpleats);
        this.panelAfegirProjecte.add(escollirProposta);
        this.panelAfegirProjecte.add(scrollPane);
        this.panelAfegirProjecte.add(tornarAtras);
        this.panelAfegirProjecte.add(crearProjecte);




        crearProjecte.addActionListener(e -> {
            if(listaEmpleats.getSelectedIndex() < 0){

                finestraPrincipalRedireccionament.crearAlertWindow("No s'apugut crear falta el cap");

            }else if(listaPropostes.getSelectedIndex() < 0){

                finestraPrincipalRedireccionament.crearAlertWindow("No s'apugut afegir, falta la proposta");

            }else{
                repositoriProjectes.afegirProjecte(Projecte.crearProjecte(repositoriPersones.arrayPersones[listaEmpleats.getSelectedIndex()], repositoriPropostes.arrayPropostes[listaPropostes.getSelectedIndex()]));
                finestraPrincipalRedireccionament.crearAlertWindow("S'ha afegit correctament");

                listaEmpleats.setSelectedValue(null,false);
                listaPropostes.setSelectedValue(null,false);

            }
        });

        tornarAtras.addActionListener(e -> {
            CrudProjecte crudProjecte = new CrudProjecte(finestraPrincipalRedireccionament, repositoriPersones, repositoriPropostes, repositoriProjectes);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(crudProjecte.crearCrudProjecte());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

    }

    public void llistarEntitats() {
        listaEmpleats = new JList(repositoriPersones.arrayPersones);
        listaEmpleats.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaEmpleats.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        listaEmpleats.setVisibleRowCount(-1);

        listaPropostes = new JList(repositoriPropostes.arrayPropostes);
        listaPropostes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaPropostes.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        listaPropostes.setVisibleRowCount(-1);

        scrollPaneEmpleats = new JScrollPane(listaEmpleats);
        scrollPaneEmpleats.setPreferredSize(new Dimension(250,400));

        scrollPane = new JScrollPane(listaPropostes);
        scrollPane.setPreferredSize(new Dimension(250,400));

    }

    public void mostrarEntitatSeleccionat(int index){


        Proposta propostaSeleccionar = repositoriPropostes.arrayPropostes[0];

        for (int i = 0; i < repositoriPropostes.arrayPropostes.length; i++) {
            if(repositoriPropostes.arrayPropostes[i].getNomProposta() == repositoriProjectes.arrayProjectes[index].getNom()){
                propostaSeleccionar = repositoriPropostes.arrayPropostes[i];
                break;
            }

        }

        this.listaPropostes.setSelectedValue(propostaSeleccionar, true);
        this.listaEmpleats.setSelectedValue(repositoriProjectes.arrayProjectes[index].getCap(), true);

        editarProjecte.addActionListener(e -> {
            editarProjecte(repositoriProjectes.arrayProjectes[index]);
        });
    }

    public void editarProjecte(Projecte projecteAEditar){

        Empleat empleatEditar = (Empleat) repositoriPersones.arrayPersones[listaEmpleats.getSelectedIndex()];

        projecteAEditar.setNom(repositoriPropostes.arrayPropostes[listaPropostes.getSelectedIndex()].getNomProposta());
        projecteAEditar.setDescripcio(repositoriPropostes.arrayPropostes[listaPropostes.getSelectedIndex()].getDescProposta());
        projecteAEditar.setCap(empleatEditar);

        CrudProjecte crudProjecte = new CrudProjecte(finestraPrincipalRedireccionament, repositoriPersones, repositoriPropostes, repositoriProjectes);
        finestraPrincipalRedireccionament.framePrincipal.setContentPane(crudProjecte.crearCrudProjecte());
        finestraPrincipalRedireccionament.framePrincipal.revalidate();


    }
    }


