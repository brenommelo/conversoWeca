/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.dao;

import br.ufmg.hc.telessaude.diagnostico.dominio.entity.Exame;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.PontoRemoto;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import java.util.List;
import org.hibernate.criterion.Criterion;

/**
 *
 * @author paulo.gomes
 */
public interface ExameDAO extends GenericDao<Exame> {
    
    public Integer salvarExame(Exame exame) throws DAOException;

    /**
     *
     * @param pontoRemoto
     * @param maxResult
     * @return
     * @throws DAOException
     */
    public List<Exame> consultarExamesNaoVisualizados(final PontoRemoto pontoRemoto, final int maxResult) throws DAOException;

    /**
     * 
     * @param pontoRemoto
     * @param start
     * @param maxResult
     * @return
     * @throws DAOException 
     */
    public List<Exame> consultarExamesNaoVisualizados(final PontoRemoto pontoRemoto, final int start, final int maxResult) throws DAOException;

    /**
     *
     * @param pontoRemoto
     * @param maxResult
     * @return
     * @throws DAOException
     */
    public List<Exame> consultarHistoricoExames(final PontoRemoto pontoRemoto, final int maxResult) throws DAOException;

    /**
     * 
     * @param pontoRemoto
     * @param start
     * @param maxResult
     * @return
     * @throws DAOException 
     */
    public List<Exame> consultarHistoricoExames(final PontoRemoto pontoRemoto, final int start, final int maxResult) throws DAOException;

    /**
     * 
     * @param pontoRemoto
     * @param visualizado
     * @return
     * @throws DAOException 
     */
    public int consultarQuantidadeExames(final PontoRemoto pontoRemoto, int visualizado) throws DAOException;

    /**
     *
     * @param nomePaciente
     * @param pontoRemoto
     * @return
     * @throws DAOException
     */
    public List<Exame> consultarExamesConcluidos(final String nomePaciente, final PontoRemoto pontoRemoto) throws DAOException;

    /**
     *
     * @param maxResults
     * @param criterions
     * @return
     * @throws DAOException
     */
    @Override
    public List<Exame> findByRestrictions(final int maxResults, final Criterion... criterions) throws DAOException;

    /**
     * 
     * @param id_ponto
     * @return
     * @throws DAOException 
     */
    public List<Exame> consultarExamesNaoLaudados(Integer id_ponto) throws DAOException;
    
    /**
     * 
     * @param id_ponto
     * @param id_tipo_exame
     * @return
     * @throws DAOException 
     */
    public List<Exame> consultarExamesNaoLaudados(final Integer id_ponto, final Integer id_tipo_exame) throws DAOException;

    /**
     * 
     * @param id_ponto
     * @return
     * @throws DAOException 
     */
    public List<Exame> consultarExamesLaudados(Integer id_ponto) throws DAOException;
    
    
    /**
     * 
     * @param id_ponto
     * @param id_tipo_exame
     * @return
     * @throws DAOException 
     */
    public List<Exame> consultarExamesLaudados(final Integer id_ponto, final Integer id_tipo_exame) throws DAOException;
    
    
}
