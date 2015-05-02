/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversorbdweka.entidades.origem;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author igor.santos
 */
@Entity
@Table(name = "\"USUARIO\"", schema = PojoBase.DB)
public class Usuario extends PojoBase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ID_USUARIO\"")
    private Integer id;
    @Column(name = "\"NOME\"")
    private String nome;
    @Column(name = "\"EMAIL\"")
    private String email;
    @Column(name = "\"USUARIO\"", nullable = false)
    private String usuario;
    @Column(name = "\"SENHA\"", nullable = false)
    private String senha;
    @Column(name = "\"PERMISSOES\"")
    private String permissoes;
    @Column(name = "\"DATAINCLUSAO\"", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date datainclusao;
    @Column(name = "\"STATUS\"", nullable = false)
    private int status;
    @JoinColumn(name = "\"ID_PONTOREMOTO\"") //, referencedColumnName = "\"ID_PONTOREMOTO\"")
    @ManyToOne(optional = false)
    private PontoRemoto pontoRemoto;
    @JoinColumn(name = "\"ID_PERFILUSUARIO\"") //, referencedColumnName = "\"ID_PERFILUSUARIO\"")
    @ManyToOne(optional = false)
    private PerfilUsuario perfilUsuario;

    @Transient
    private boolean ativo; // respons�vel por setar selectBooleanCheckbox do view Cadastro de Usuario

    @Transient
    private boolean transf; // reponsavel por controlar se o usuario cadastrado no diagnostico esta ou n�o na tabela de usuario do TeleTransferencia

    @Transient
    private Especialista especialista;

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, String nome, String email, String usuario, String senha, String permissoes, Date datainclusao, int status) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.usuario = usuario;
        this.senha = senha;
        this.permissoes = permissoes;
        this.datainclusao = datainclusao;
        this.status = status;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(String permissoes) {
        this.permissoes = permissoes;
    }

    public Date getDatainclusao() {
        return datainclusao;
    }

    public void setDatainclusao(Date datainclusao) {
        this.datainclusao = datainclusao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;

        if (this.status == 1) {
            this.setAtivo(true);
        } else {
            this.setAtivo(false);
        }
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

    public PerfilUsuario getPerfilUsuario() {
        if (perfilUsuario == null) {
            perfilUsuario = new PerfilUsuario();
        }
        return perfilUsuario;
    }

    public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }

    /**
     * @return the especialista
     */
    public Especialista getEspecialista() {
        return especialista;
    }

    /**
     * @param especialista the especialista to set
     */
    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;

        //this.setStatus(ativo ? 0 : 1);
    }

    public boolean isTransf() {
        return transf;
    }

    public void setTransf(boolean transf) {
        this.transf = transf;
    }

}
