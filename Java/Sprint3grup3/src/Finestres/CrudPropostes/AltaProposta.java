package Finestres.CrudPropostes;

import Clases.*;
import Finestres.FinestraPrincipal;
import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AltaProposta {

    public JPanel panelAfegirProposta;
    public JButton crearProposta, tornarProposta, editarProposta, tornarAtras;
    public JLabel textNomProposta, textDescripcioProposta, textDataProposta, textSeleccionarEmpresaProposta;
    public JTextField nomProposta, descripcioProposta, dataProposta;
    public JList listaProposta;
    public JScrollPane scrollPane, scrollPanel;


    public RepositoriPropostes repositoriPropostes;
    public FinestraPrincipal finestraPrincipalRedireccionament;
    public RepositoriEntitats repositoriEntitats;


    public AltaProposta(FinestraPrincipal framePrincipal, RepositoriPropostes repositoriPropostes, RepositoriEntitats repositoriEntitats) {
        this.repositoriPropostes = repositoriPropostes;
        this.finestraPrincipalRedireccionament = framePrincipal;
        this.repositoriEntitats = repositoriEntitats;
    }


    public JPanel crearPanelAfegirProposta() {

        panelAfegirProposta = new JPanel();
        panelAfegirProposta.setPreferredSize(new Dimension(finestraPrincipalRedireccionament.ampladaFinestra, finestraPrincipalRedireccionament.alturaFinestra));
        panelAfegirProposta.setLayout(new GridLayout(5,2));

        this.crearBotonsAfegirProposta();

        return panelAfegirProposta;
    }

    public void crearBotonsAfegirProposta() {

        crearProposta = new JButton("Afegir");
        tornarAtras = new JButton("Tornar atras");
        editarProposta = new JButton("Guardar");

        textNomProposta = new JLabel("Nom:");
        textDescripcioProposta = new JLabel("Descripcio:");
        textDataProposta = new JLabel("Data  :"+ "  dia/"+"mes/"+"any"+"");
        textSeleccionarEmpresaProposta = new JLabel("Selecciona Empresa / Institut:");

        nomProposta = new JTextField();
        descripcioProposta = new JTextField();
        dataProposta = new JTextField();
        
        scrollPanel = new JScrollPane();

        this.panelAfegirProposta.add(textNomProposta);
        this.panelAfegirProposta.add(nomProposta);
        this.panelAfegirProposta.add(textDescripcioProposta);
        this.panelAfegirProposta.add(descripcioProposta);
        this.panelAfegirProposta.add(textDataProposta);
        this.panelAfegirProposta.add(dataProposta);
        this.panelAfegirProposta.add(textSeleccionarEmpresaProposta);

        llistarEntitats();

        this.panelAfegirProposta.add(scrollPane);
        this.panelAfegirProposta.add(crearProposta);
        this.panelAfegirProposta.add(tornarAtras);

        crearProposta.addActionListener(e -> {
            if(nomProposta.getText().isEmpty()){

                finestraPrincipalRedireccionament.crearAlertWindow("No s'apugut afegir, falta el nom.");

            }else if(descripcioProposta.getText().isEmpty()){

                finestraPrincipalRedireccionament.crearAlertWindow("No s'apugut afegir, falta la descripcio");

            }else if(dataProposta.getText().isEmpty()){

                finestraPrincipalRedireccionament.crearAlertWindow("No s'apugut afegir, falta la data");

            }else if(listaProposta.getSelectedIndex() < 0){

                finestraPrincipalRedireccionament.crearAlertWindow("No s'apugut afegir, falta la Empresa / Institut");

            }else{
                Date date1 = null;
                try {
                    date1 = new SimpleDateFormat("dd/MM/yyyy").parse(dataProposta.getText());
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }

                Proposta proposta = new Proposta(nomProposta.getText(), descripcioProposta.getText(), date1, repositoriEntitats.arrayEntitats[listaProposta.getSelectedIndex()], 3);
                this.repositoriPropostes.afegirPropostes(proposta);

                finestraPrincipalRedireccionament.crearAlertWindow("S'ha afegit correctament");

                nomProposta.setText("");
                descripcioProposta.setText("");
                dataProposta.setText("");

            }
        });

        tornarAtras.addActionListener(e -> {
            CrudProposta crudProposta = new CrudProposta(finestraPrincipalRedireccionament, repositoriPropostes, repositoriEntitats);
            finestraPrincipalRedireccionament.framePrincipal.setContentPane(crudProposta.crearCrudProposta());
            finestraPrincipalRedireccionament.framePrincipal.revalidate();
        });

    }

    public void llistarEntitats() {
        listaProposta = new JList(repositoriEntitats.arrayEntitats);
        listaProposta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaProposta.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        listaProposta.setVisibleRowCount(-1);

        scrollPane = new JScrollPane(listaProposta);
        scrollPane.setPreferredSize(new Dimension(250,400));

    }


    public void mostrarEntitatSeleccionat(int index){
        Proposta propostaEditar = (Proposta) repositoriPropostes.arrayPropostes[index];

        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(propostaEditar.getDataAlta());

        this.nomProposta.setText(propostaEditar.getNomProposta());
        this.descripcioProposta.setText(propostaEditar.getDescProposta());
        this.dataProposta.setText(strDate);

        editarProposta.addActionListener(e -> {
            editarProposta(propostaEditar);
        });
    }

    public void editarProposta(Proposta propostaEditar){
        Date date2 = null;
        try {
            date2 = new SimpleDateFormat("dd/MM/yyyy").parse(dataProposta.getText());
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }

        propostaEditar.setNomProposta(this.nomProposta.getText());
        propostaEditar.setDescProposta(this.descripcioProposta.getText());
        propostaEditar.setDataAlta(date2);

        CrudProposta crudProposta = new CrudProposta(finestraPrincipalRedireccionament, repositoriPropostes, repositoriEntitats);
        finestraPrincipalRedireccionament.framePrincipal.setContentPane(crudProposta.crearCrudProposta());
        finestraPrincipalRedireccionament.framePrincipal.revalidate();

    }



}
