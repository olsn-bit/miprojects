package Finestres;

import Clases.RepositoriEntitats;
import Clases.RepositoriPersones;
import Clases.RepositoriProjectes;
import Clases.RepositoriPropostes;
import Finestres.CrudEmpleats.CrudEmpleat;
import Finestres.CrudPressupostos.CrudPressupost;
import Finestres.CrudProjectes.CrudProjecte;
import Finestres.CrudPropostes.CrudProposta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinestraPrincipal{

    public JFrame framePrincipal, frameAlerta;
    public JPanel panelPrincipal;
    public JButton crudEmpleat,crudPressupost,crudProjecte,crudProposta,sortir, aceptarAlerta;
    public JLabel missatgeError;

    public int ampladaFinestra = 400;
    public int alturaFinestra = 400;

    public RepositoriEntitats repositoriEntitats;
    public RepositoriPersones repositoriPersones;
    public RepositoriProjectes repositoriProjectes;
    public RepositoriPropostes repositoriPropostes;

    public FinestraPrincipal(RepositoriEntitats repositoriEntitats, RepositoriPersones repositoriPersones, RepositoriProjectes repositoriProjectes, RepositoriPropostes repositoriPropostes){
        this.repositoriEntitats = repositoriEntitats;
        this.repositoriPersones = repositoriPersones;
        this.repositoriProjectes = repositoriProjectes;
        this.repositoriPropostes = repositoriPropostes;
    }

    public void crearFramePrincipal(){
        framePrincipal = new JFrame("Aplicacio");
        framePrincipal.setSize(this.ampladaFinestra, this.alturaFinestra);
        framePrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        framePrincipal.setLocation(500,500);
        framePrincipal.setVisible(true);
        framePrincipal.setLayout(new GridLayout());

        crearPanelPrincipal();

        framePrincipal.add(panelPrincipal);
    }

    public void crearAlertWindow(String missatge){
        frameAlerta = new JFrame("Error");
        frameAlerta.setSize(300, 120);
        frameAlerta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameAlerta.setLocation(550,550);
        frameAlerta.setVisible(true);
        frameAlerta.setLayout(new GridLayout(2,1));

        aceptarAlerta = new JButton("Aceptar");

        this.missatgeError = new JLabel(missatge);

        frameAlerta.add(missatgeError);
        frameAlerta.add(aceptarAlerta);

        aceptarAlerta.addActionListener(e -> {
           frameAlerta.dispose();
        });
    }

    public JPanel crearPanelPrincipal() {
        panelPrincipal = new JPanel();
        panelPrincipal.setPreferredSize(new Dimension(this.ampladaFinestra, this.alturaFinestra));
        panelPrincipal.setLayout(new GridLayout(5, 1, 1, 10));
        crearBotons();

        crudEmpleat.addActionListener(e -> {
            CrudEmpleat crudEmpleat = new CrudEmpleat(this,repositoriPersones);


            framePrincipal.setContentPane(crudEmpleat.crearCrudEmpleat());
            framePrincipal.revalidate();
        });

        crudProjecte.addActionListener(e -> {
            CrudProjecte crudProjecte = new CrudProjecte(this, repositoriPersones, repositoriPropostes, repositoriProjectes);

            framePrincipal.setContentPane(crudProjecte.crearCrudProjecte());
            framePrincipal.revalidate();
        });
        crudPressupost.addActionListener(e -> {
            CrudPressupost crudPressupost = new CrudPressupost(this, repositoriProjectes);

            framePrincipal.setContentPane(crudPressupost.crearCrudPressupost());
            framePrincipal.revalidate();
        });

        crudProposta.addActionListener(e -> {
            CrudProposta crudProposta = new CrudProposta(this, repositoriPropostes, repositoriEntitats);

            framePrincipal.setContentPane(crudProposta.crearCrudProposta());
            framePrincipal.revalidate();
        });

        sortir.addActionListener(e -> {
            framePrincipal.dispose();
        });


        return panelPrincipal;

    }

    public void crearBotons(){
        crudEmpleat = new JButton("Gestionar Empleats");
        crudProjecte = new JButton("Gestionar Projectes");
        crudPressupost = new JButton("Gestionar Pressupostos");
        crudProposta = new JButton("Gestoionar Propostes");
        sortir = new JButton("Sortir");

        panelPrincipal.add(crudEmpleat);
        panelPrincipal.add(crudProjecte);
        panelPrincipal.add(crudPressupost);
        panelPrincipal.add(crudProposta);
        panelPrincipal.add(sortir);

    }





    public void defaultPanel(){
        framePrincipal.setContentPane(panelPrincipal);
    }





}
