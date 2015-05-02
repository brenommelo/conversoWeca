/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.dao;

import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;


/**
 *
 * @author Igor
 */
public interface GenericDao<T> {
    
    /**
     * 
     * @return
     * @throws DAOException 
     */
    public List<T> findAll() throws DAOException;
    
    /**
     * 
     * @param obj
     * @return
     * @throws DAOException 
     */
    public T saveOrUpdate(final T obj) throws DAOException;

    /**
     * 
     * @param id
     * @return
     * @throws DAOException 
     */
    public T findById(final Integer id) throws DAOException;
    
    /**
     * 
     * @param obj
     * @return
     * @throws DAOException 
     */
    public boolean delete(final T obj) throws DAOException;
    
    /**
     * 
     * @param id
     * @return
     * @throws DAOException 
     */
    public boolean delete(final Integer id) throws DAOException;
    
    public List<T> findByLikeParams(final String key, final String value) throws DAOException ;
    
     public List<T> findByRestrictions(final int maxResults, final Criterion... criterions) throws DAOException;
     
     public List<Object> findByRestrictions(final int start, final int maxResults, final ProjectionList projections, final Criterion... criterions) throws DAOException;
     
     public List<T> findByRestrictions(final int start, final int maxResults, final Criterion... criterions) throws DAOException;
     
     public List<T> findByRestrictions(final int start, final int maxResults, final Order order,  final Criterion... criterions) throws DAOException;
    
}
