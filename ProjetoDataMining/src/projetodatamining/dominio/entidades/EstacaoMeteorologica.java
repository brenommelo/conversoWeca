/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetodatamining.dominio.entidades;

/**
 *
 * @author breno
 */
public class EstacaoMeteorologica {
    
    
    private Long id;
    private String nome;
    private String latitude;
    private String longitude;
    private String Altitude;

    public EstacaoMeteorologica() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAltitude() {
        return Altitude;
    }

    public void setAltitude(String Altitude) {
        this.Altitude = Altitude;
    }

}
