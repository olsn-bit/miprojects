package Clases;

import java.util.Date;

/**
 * Grup 3 Sprint 2 2020 - Alberto Dos Santos, Cristian Diac, Isaac Brull, Carlos Masana -
 */
public class Proposta {
    private String nomProposta;
    private String descProposta;
    private Date dataAlta;
    private int contadorConsultes;
    private int contadorGrupsClasseAssociats;
    private Entitat entitat;


    public Proposta(String nomProposta, String descProposta, Date dataAlta, Entitat entitat, int contadorGrupsClasseAssociats) {
        this.nomProposta = nomProposta;
        this.descProposta = descProposta;
        this.dataAlta = dataAlta;
        this.contadorConsultes = 0;
        this.contadorGrupsClasseAssociats = contadorGrupsClasseAssociats;
        this.entitat = entitat;
    }

    /**
     * Método que permite modificar una propuesta
     */

    @Override
    public String toString() {
        this.contadorConsultes++;
        return "Nom: " + nomProposta + " | " +
                "Descripció: " + descProposta + " | " +
                "Data d'alta: " + dataAlta + " | " +
                "Entitat associada: " + entitat.nom + " | " +
                "Consultada: " + contadorConsultes + " vegades | " +
                "Grups associats: " + contadorGrupsClasseAssociats;
    }

    public String getNomProposta() {
        return nomProposta;
    }

    public void setNomProposta(String nomProposta) {
        this.nomProposta = nomProposta;
    }

    public String getDescProposta() {
        return descProposta;
    }

    public void setDescProposta(String descProposta) {
        this.descProposta = descProposta;
    }

    public Date getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(Date dataAlta) {
        this.dataAlta = dataAlta;
    }

    public int getContadorConsultes() {
        return contadorConsultes;
    }

    public void setContadorConsultes(int contadorConsultes) {
        this.contadorConsultes = contadorConsultes;
    }

    public int getContadorGrupsClasseAssociats() {
        return contadorGrupsClasseAssociats;
    }

    public void setContadorGrupsClasseAssociats(int contadorGrupsClasseAssociats) {
        this.contadorGrupsClasseAssociats = contadorGrupsClasseAssociats;
    }
}
