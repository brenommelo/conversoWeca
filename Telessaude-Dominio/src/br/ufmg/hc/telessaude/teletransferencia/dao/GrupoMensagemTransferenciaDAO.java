/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.teletransferencia.dao;

import br.ufmg.hc.telessaude.diagnostico.dominio.dao.GenericDao;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.teletransferencia.entity.GrupoMensagemTransferencia;
import java.util.List;

/**
 *
 * @author paulo.gomes
 */
public interface GrupoMensagemTransferenciaDAO extends GenericDao<GrupoMensagemTransferencia> {

    public List<GrupoMensagemTransferencia> consultarPorUsuario(Integer id) throws DAOException;
    
    public List<GrupoMensagemTransferencia> consultarPorUsuarioNaoEnviada(Integer id) throws DAOException;
    
}
