/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.teletransferencia.dao;

import br.ufmg.hc.telessaude.diagnostico.dominio.dao.GenericDao;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.teletransferencia.entity.ExameTransferencia;
import java.util.List;

/**
 *
 * @author paulo.gomes
 */
public interface ExameTransferenciaDAO extends GenericDao<ExameTransferencia> {

    public int consultarQuantidadeExames(final int id_pontoRemoto, String status) throws DAOException;

    public List<ExameTransferencia> consultarExames(final int id_pontoRemoto, final int start, final int maxResult) throws DAOException;

    public List<ExameTransferencia> consultarExamesConcluidos(final String nomePaciente, final int id_pontoRemoto, final int start, final int maxResult) throws DAOException;
    
    public List<ExameTransferencia> consultarExamesConcluidos(final Integer id_usuario) throws DAOException;
    
    public List<ExameTransferencia> consultarExamesConcluidos(final Integer id_usuario, final Integer id_tipo_exame) throws DAOException;
    
    public List<ExameTransferencia> consultarExamesNaoLaudados(final Integer id_usuario) throws DAOException;
    
    public List<ExameTransferencia> consultarExamesNaoLaudados(final Integer id_usuario, final Integer id_tipo_exame) throws DAOException;
    
    public ExameTransferencia retornarProximoExameNaFila(final Integer id_usuario) throws DAOException;   
    
    public Integer retornarQuantExameNaFila(final Integer id_usuario) throws DAOException;   
    
    public ExameTransferencia consultarPorId(Integer id_exame) throws DAOException;

}
