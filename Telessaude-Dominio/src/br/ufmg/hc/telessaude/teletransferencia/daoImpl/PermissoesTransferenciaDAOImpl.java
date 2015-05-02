/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.teletransferencia.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl.DaoBase;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.teletransferencia.dao.PermissoesTransferenciaDAO;
import br.ufmg.hc.telessaude.teletransferencia.entity.PermissaoTransferencia;
import java.util.List;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author paulo.gomes
 */
public class PermissoesTransferenciaDAOImpl extends DaoBase<PermissaoTransferencia> implements PermissoesTransferenciaDAO{

    public PermissoesTransferenciaDAOImpl() {
        super(PermissaoTransferencia.class);
    }

    @Override
    public List<PermissaoTransferencia> consultarPorUsuario(final int id_usuario) throws DAOException {
       return findByRestrictions(0, Restrictions.eq("usuario.id", id_usuario));
    }
    
    @Override
    public List<Object> consultarIdsTipoExamePorUsuario(final int id_usuario) throws DAOException {
       return findByRestrictions(0,0, getProjectList(Projections.property("tipoExame.id")),Restrictions.eq("usuario.id", id_usuario));
    }
}
