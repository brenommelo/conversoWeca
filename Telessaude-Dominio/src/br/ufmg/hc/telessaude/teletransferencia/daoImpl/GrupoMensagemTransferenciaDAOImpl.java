/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.teletransferencia.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl.DaoBase;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.teletransferencia.dao.GrupoMensagemTransferenciaDAO;
import br.ufmg.hc.telessaude.teletransferencia.entity.GrupoMensagemTransferencia;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author paulo.gomes
 */
public class GrupoMensagemTransferenciaDAOImpl extends DaoBase<GrupoMensagemTransferencia> implements GrupoMensagemTransferenciaDAO{

    public GrupoMensagemTransferenciaDAOImpl() {
        super(GrupoMensagemTransferencia.class);
    }

    @Override
    public List<GrupoMensagemTransferencia> consultarPorUsuario(Integer id) throws DAOException {
        return findByRestrictions(0, Restrictions.eq("usuario.id", id));
    }

    @Override
    public List<GrupoMensagemTransferencia> consultarPorUsuarioNaoEnviada(Integer id) throws DAOException {
        return findByRestrictions(0, Restrictions.eq("usuario.id", id),Restrictions.isNull("dataCriacao"));
    }
    
}
