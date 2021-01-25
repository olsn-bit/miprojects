package Finestres.CrudEmpleats;

import Clases.Empleat;
import Clases.RepositoriPersones;
import Finestres.FinestraPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class AfegirEmpleat {

    public JPanel panelAfegirEmpleat;
    public JButton crearEmpleat, tornarAtras, editarEmpleat;
    public JLabel textNomEmpleat, textDniEmpleat, textNssEmpleat, textCodiEmpleat;
    public JTextField nomEmpleat, dniEmpleat, nssEmpleat, codiEmpleat;
    public RepositoriPersones repositoriPersones;
    public FinestraPrincipal finestraPrincipalRedireccionament;



    public AfegirEmpleat(FinestraPrincipal framePrincipal, RepositoriPersones repositoriPersones) {
        this.repositoriPersones = repositoriPersones;
        this.finestraPrincipalRedireccionament = framePrincipal;
    }


    public JPanel crearPanelAfegirEmpleat() {

        panelAfegirEmpleat = new JPanel();
        panelAfegirEmpleat.setPreferredSize(new Dimension(finestraPrincipalRedireccionament.ampladaFinestra, finestraPrincipalRedireccionament.alturaFinestra));
        panelAfegirEmpleat.setLayout(new GridLayout(5,2));

        this.crearBotonsAfegirEmpleats();

        return panelAfegirEmpleat;
    }

    public void crearBotonsAfegirEmpleats() {

        crearEmpleat = new JButton("Afegir");
        tornarAtras = new JButton("Tornar atras");
        editarEmpleat = new JButton("Guardar");

        textNomEmpleat = new JLabel("Nom:");
        textDniEmpleat = new JLabel("DNI:");
        textNssEmpleat = new JLabel("NSS:");
        textCodiEmpleat = new JLabel("Codi:");

        nomEmpleat = new JTextField();
        dniEmpleat = new JTextField();
        nssEmpleat = new JTextField();
        codiEmpleat = new JTextField();

        crearEmpleat.addActionListener(e -> {
            if(nomEmpleat.getText().isEmpty()){

                finestraPrincipalRedireccionament.crearAlertWindow("No s'apugut afegir, falta el nom.");

            }else if(dniEmpleat.getText().isEmpty()){

                finestraPrincipalRedireccionament.crearAlertWindow("No s'apugut afegir, falta el dni");

            }else if(nssEmpleat.getText().isEmpty()){

                finestraPrincipalRedireccionament.crearAlertWindow("No s'apugut afegir, falta el nss");

            }else if(codiEmpleat.getText().isEmpty()){

                finestraPrincipalRedireccionament.crearAlertWindow("No s'apugut afegir, falta el codi");

            }else{
                Empleat empleat = new Empleat(nomEmpleat.getText(), dniEmpleat.getText(),nssEmpleat.getText(),codiEmpleat.getText());
                this.repositoriPersones.afegirPersona(empleat);

                finestraPrincipalRedireccionament.crearAlertWindow("S'ha afegit correctament");

                nomEmpleat.setText("");
                dniEmpleat.setText("");
                nssEmpleat.setText("");
                codiEmpleat.setText("");
            }
        });

        tornarAtras.addActionListener(e -> {
            CrudEmpleat crudEmpleat = new CrudEmpleat(finestraPrincipalRedireccionament, repositoriPersones);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(crudEmpleat.crearCrudEmpleat());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

        this.panelAfegirEmpleat.add(textNomEmpleat);
        this.panelAfegirEmpleat.add(nomEmpleat);
        this.panelAfegirEmpleat.add(textDniEmpleat);
        this.panelAfegirEmpleat.add(dniEmpleat);
        this.panelAfegirEmpleat.add(textNssEmpleat);
        this.panelAfegirEmpleat.add(nssEmpleat);
        this.panelAfegirEmpleat.add(textCodiEmpleat);
        this.panelAfegirEmpleat.add(codiEmpleat);
        this.panelAfegirEmpleat.add(tornarAtras);
        this.panelAfegirEmpleat.add(crearEmpleat);

    }

    public void mostrarEmpleatSeleccionat(int index){
        Empleat empleatEditar = (Empleat) repositoriPersones.arrayPersones[index];

        this.nomEmpleat.setText(empleatEditar.getNom());
        this.dniEmpleat.setText(empleatEditar.getDni());
        this.nssEmpleat.setText(empleatEditar.getNss());
        this.codiEmpleat.setText(empleatEditar.getCodiEmpleat());

        editarEmpleat.addActionListener(e -> {
            editarEmpleat(empleatEditar);
        });
    }

    public void editarEmpleat(Empleat empleatAEditar){
        empleatAEditar.setNom(this.nomEmpleat.getText());
        empleatAEditar.setDni(this.dniEmpleat.getText());
        empleatAEditar.setNss(this.nssEmpleat.getText());
        empleatAEditar.setCodiEmpleat(this.codiEmpleat.getText());


        CrudEmpleat crudEmpleat = new CrudEmpleat(finestraPrincipalRedireccionament, repositoriPersones);
        finestraPrincipalRedireccionament.framePrincipal.setContentPane(crudEmpleat.crearCrudEmpleat());
        finestraPrincipalRedireccionament.framePrincipal.revalidate();

    }



}
