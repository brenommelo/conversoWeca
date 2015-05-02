/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.teletransferencia.dao;

import br.ufmg.hc.telessaude.diagnostico.dominio.dao.GenericDao;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.teletransferencia.entity.VersaoTransferencia;
import java.util.List;

/**
 *
 * @author paulo.gomes
 */
public interface VersaoTransferenciaDAO extends GenericDao<VersaoTransferencia> {

    public VersaoTransferencia retornarUltimaVersao() throws DAOException;

    public VersaoTransferencia consultarVersao(String versao) throws DAOException;

    public Integer consultarQuantidade(String versao) throws DAOException;

    public List<VersaoTransferencia> consultarChave(String versao, int start, int maxResult) throws DAOException;

}
