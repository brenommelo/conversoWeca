/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.teletransferencia.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl.DaoBase;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.teletransferencia.dao.EspecialistaTransferenciaDAO;
import br.ufmg.hc.telessaude.teletransferencia.entity.EspecialistaTransferencia;
import java.util.List;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author paulo.gomes
 */
public class EspecialistaTransferenciaDAOImpl extends DaoBase<EspecialistaTransferencia> implements EspecialistaTransferenciaDAO {

    public EspecialistaTransferenciaDAOImpl() {
        super(EspecialistaTransferencia.class);
    }

    @Override
    public EspecialistaTransferencia consultarPeloIdUsuario(Integer idUsuario) throws DAOException {
        if (idUsuario == null) {
            return null;
        }
        List<EspecialistaTransferencia> especialistas = findByRestrictions(1, Restrictions.eq("usuario.id", idUsuario));
        if (especialistas != null && especialistas.size() > 0) {
            return especialistas.get(0);
        }
        return null;
    }

    @Override
    public List<EspecialistaTransferencia> consultarPeloNome(String nome) throws DAOException {
        return consultarPeloNome(nome, 0, 0);
    }

    @Override
    public List<EspecialistaTransferencia> consultarPeloNome(String nome, int start, int maxResults) throws DAOException {
        return findByRestrictions(start, maxResults, Restrictions.ilike("nome", nome, MatchMode.ANYWHERE));
    }

}
