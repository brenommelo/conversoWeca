package br.ufmg.hc.telessaude.telediagnostico.xmlfactory.estruturaantiga;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import java.io.Serializable;

/**
 * @author weslley.matos
 */
@XStreamAlias("INVESTIGACAODADOR")
public class Investigacao implements Serializable{
    
    
    private DorNoExame DORNOEXAME;
    
    private LocalizacaoIrradiacao LOCALIZACAOIRRADIACAODADOR;
    
    private SintomasAssociados SINTOMASASSOCIADOS;
    
    private String CLASSIFICACAODADOR;
    
    private Intensidade INTENSIDADEDADOR;
    
    private Caracterizacao CARACTERIZACAODADORTORACICA;

    /**
     * @return the DORNOEXAME
     */
    public DorNoExame getDorNoExame() {
        if(DORNOEXAME == null) {
            DORNOEXAME = new DorNoExame();
        }
        
        return DORNOEXAME;
    }

    /**
     * @param dorNoExame the DORNOEXAME to set
     */
    public void setDorNoExame(DorNoExame dorNoExame) {
        this.DORNOEXAME = dorNoExame;
    }

    /**
     * @return the LOCALIZACAOIRRADIACAODADOR
     */
    public LocalizacaoIrradiacao getLocalizacaoIrradiacaoDaDor() {
        if(LOCALIZACAOIRRADIACAODADOR == null) {
            LOCALIZACAOIRRADIACAODADOR = new LocalizacaoIrradiacao();
        }
        
        return LOCALIZACAOIRRADIACAODADOR;
    }

    /**
     * @param localizacaoIrradiacaoDaDor the LOCALIZACAOIRRADIACAODADOR to set
     */
    public void setLocalizacaoIrradiacaoDaDor(LocalizacaoIrradiacao localizacaoIrradiacaoDaDor) {
        this.LOCALIZACAOIRRADIACAODADOR = localizacaoIrradiacaoDaDor;
    }

    /**
     * @return the SINTOMASASSOCIADOS
     */
    public SintomasAssociados getSintomasAssociados() {
        if(SINTOMASASSOCIADOS == null) {
            SINTOMASASSOCIADOS = new SintomasAssociados();
        }
        
        return SINTOMASASSOCIADOS;
    }

    /**
     * @param sintomasAssociados the SINTOMASASSOCIADOS to set
     */
    public void setSintomasAssociados(SintomasAssociados sintomasAssociados) {
        this.SINTOMASASSOCIADOS = sintomasAssociados;
    }

    public String getCLASSIFICACAODADOR() {        
        return CLASSIFICACAODADOR;
    }

    public void setCLASSIFICACAODADOR(String CLASSIFICACAODADOR) {
        this.CLASSIFICACAODADOR = CLASSIFICACAODADOR;
    }

    /**
     * @return the INTENSIDADEDADOR
     */
    public Intensidade getIntensidadeDaDor() {
        if(INTENSIDADEDADOR == null) {
            INTENSIDADEDADOR = new Intensidade();
        }
        
        return INTENSIDADEDADOR;
    }

    /**
     * @param intensidadeDaDor the INTENSIDADEDADOR to set
     */
    public void setIntensidadeDaDor(Intensidade intensidadeDaDor) {
        this.INTENSIDADEDADOR = intensidadeDaDor;
    }

    /**
     * @return the CARACTERIZACAODADORTORACICA
     */
    public Caracterizacao getCaracterizacaoDaDorToracica() {
        if(CARACTERIZACAODADORTORACICA == null) {
            CARACTERIZACAODADORTORACICA = new Caracterizacao();
        }
        
        return CARACTERIZACAODADORTORACICA;
    }

    /**
     * @param caracterizacaoDaDorToracica the CARACTERIZACAODADORTORACICA to set
     */
    public void setCaracterizacaoDaDorToracica(Caracterizacao caracterizacaoDaDorToracica) {
        this.CARACTERIZACAODADORTORACICA = caracterizacaoDaDorToracica;
    }
    
    
}
