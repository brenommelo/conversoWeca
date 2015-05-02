/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversorbdweka.entidades.origem;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author igor.santos
 */
@Entity
@Table(name = "\"CONTATO\"", schema = PojoBase.DB)
public class Contato extends PojoBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_CONTATO\"", nullable = false)
    private Integer id;
    @Column(name = "\"DESCRICAO\"")
    private String descricao;
    @Column(name = "\"VALOR\"", nullable = false)
    private String valor;
    @Column(name = "\"TIPOCONTATO\"", nullable = false)
    private String tipocontato;
    @JoinColumn(name = "\"ID_PONTOREMOTO\"")
    @ManyToOne
    private PontoRemoto pontoRemoto;
    @JoinColumn(name = "\"ID_CLIENTE\"")
    @ManyToOne
    private Cliente cliente;

    public Contato() {
    }

    public Contato(Integer id) {
        this.id = id;
    }

    public Contato(Integer id, String descricao, String valor, String tipocontato) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.tipocontato = tipocontato;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTipocontato() {
        return tipocontato;
    }

    public void setTipocontato(String tipocontato) {
        this.tipocontato = tipocontato;
    }

    public PontoRemoto getPontoRemoto() {
        if (pontoRemoto == null) {
            pontoRemoto = new PontoRemoto();
        }
        return pontoRemoto;
    }

    public void setPontoRemoto(PontoRemoto pontoRemoto) {
        this.pontoRemoto = pontoRemoto;
    }

    public Cliente getCliente() {
        if (cliente == null) {
            cliente = new Cliente();
        }
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
