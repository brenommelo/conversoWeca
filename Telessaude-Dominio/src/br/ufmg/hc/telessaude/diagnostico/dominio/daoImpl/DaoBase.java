package br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.dao.GenericDao;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.diagnostico.dominio.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Igor
 */
public class DaoBase<T> implements GenericDao<T> {

    protected Session session;
    protected Transaction transaction;
    protected Class c;

    public DaoBase(Class c) {
        this.c = c;
    }

    /**
     *
     * @param object
     * @return
     * @throws DAOException
     */
    @Override
    public T saveOrUpdate(final T object) throws DAOException {
        try {
            session = HibernateUtil.currentSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
            return (T) object;
        } catch (Exception ex) {
            transaction.rollback();
            throw new DAOException(ex.getMessage());
        } finally {
            this.closeSession();
        }
    }

    /**
     *
     * @param object
     * @return
     * @throws DAOException
     */
    @Override
    public boolean delete(final T object) throws DAOException {
        boolean confirmDelete = false;
        try {
            session = HibernateUtil.currentSession();
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
            confirmDelete = true;
            return confirmDelete;
        } catch (Exception ex) {
            transaction.rollback();
            throw new DAOException(ex.getMessage());
        } finally {
            this.closeSession();
        }
    }

    /**
     *
     * @param id
     * @return
     * @throws DAOException
     */
    @Override
    public boolean delete(final Integer id) throws DAOException {
        boolean confirmDelete = false;
        try {
            session = HibernateUtil.currentSession();
            transaction = session.beginTransaction();
            session.delete(session.get(c, id));
            transaction.commit();
            confirmDelete = true;
            return confirmDelete;
        } catch (Exception ex) {
            transaction.rollback();
            throw new DAOException(ex.getMessage());
        } finally {
            this.closeSession();
        }
    }

    /**
     *
     * @return @throws DAOException
     */
    @Override
    public List<T> findAll() throws DAOException {
        try {
            final DetachedCriteria crit = DetachedCriteria.forClass(c);
            return crit.getExecutableCriteria(HibernateUtil.currentSession()).list();
        } catch (Exception ex) {
            throw new DAOException(ex.getMessage());
        }
    }

    /**
     * Deve-se passar o atributo como par e o parametros como impar comparado
     * como modo ANYWHERE
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public List<T> findByLikeParams(String key, String value) throws DAOException {
        try {
            final DetachedCriteria crit = DetachedCriteria.forClass(c);
            crit.add(Restrictions.like(key, value, MatchMode.ANYWHERE));
            return crit.getExecutableCriteria(HibernateUtil.currentSession()).list();
        } catch (HibernateException ex) {
            throw new DAOException(ex.getMessage());
        }
    }

    /**
     *
     * @param maxResults
     * @param criterions
     * @return
     * @throws DAOException
     */
    @Override
    public List<T> findByRestrictions(final int maxResults, final Criterion... criterions) throws DAOException {
        return findByRestrictions(0, maxResults, criterions);
    }

    /**
     *
     * @param start
     * @param maxResults
     * @param projections
     * @param criterions
     * @return
     * @throws DAOException
     */
    @Override
    public List<Object> findByRestrictions(final int start, final int maxResults, final ProjectionList projections, final Criterion... criterions) throws DAOException {
        try {
            final DetachedCriteria crit = DetachedCriteria.forClass(c);
            final Criteria criteria = crit.getExecutableCriteria(HibernateUtil.currentSession());

            if (projections != null) {
                criteria.setProjection(projections);
            }

            if (criterions != null) {
                for (final Criterion cri : criterions) {
                    if (cri != null) {
                        criteria.add(cri);
                    }
                }
            }

            if (start > 0) {
                criteria.setFirstResult(start);
            }
            if (maxResults != 0) {
                criteria.setMaxResults(maxResults);
            }

            return criteria.list();

        } catch (HibernateException ex) {
            throw new DAOException(ex.getMessage());
        }
    }

    /**
     *
     * @param maxResults
     * @param criterions
     * @return
     * @throws DAOException
     */
    @Override
    public List<T> findByRestrictions(final int start, final int maxResults, final Criterion... criterions) throws DAOException {
        return findByRestrictions(start, maxResults, (Order) null, criterions);
    }

    /**
     *
     * @param maxResults
     * @param criterions
     * @return
     * @throws DAOException
     */
    @Override
    public List<T> findByRestrictions(final int start, final int maxResults, final Order order, final Criterion... criterions) throws DAOException {
        try {
            final DetachedCriteria crit = DetachedCriteria.forClass(c);
            final Criteria criteria = crit.getExecutableCriteria(HibernateUtil.currentSession());

            if (criterions != null) {
                for (final Criterion cri : criterions) {
                    if (cri != null) {
                        criteria.add(cri);
                    }
                }
            }

            if (start > 0) {
                criteria.setFirstResult(start);
            }
            if (maxResults != 0) {
                criteria.setMaxResults(maxResults);
            }
            if (order != null) {
                criteria.addOrder(order);
            }

            return criteria.list();

        } catch (HibernateException ex) {
            throw new DAOException(ex.getMessage());
        }
    }

    /**
     *
     * @param id
     * @return
     * @throws DAOException
     */
    @Override
    public T findById(final Integer id) throws DAOException {
        try {
            session = HibernateUtil.currentSession();
            return (T) session.get(c, id);
        } catch (Exception ex) {
            throw new DAOException(ex.getMessage());
        }
    }

    public Session getSession() {
        if (session == null) {
            session = HibernateUtil.currentSession();
        }
        return session;
    }

    public void closeSession() {
        if (session != null) {
            session.close();
        }
    }

    protected ProjectionList getProjectList(Projection... projections) {
        ProjectionList listProj = Projections.projectionList();
        for (Projection projection : projections) {
            listProj.add(projection);
        }
        return listProj;
    }

    /**
     *
     * @return
     */
    protected Criteria createCustomCriteria() {
        final DetachedCriteria detached = DetachedCriteria.forClass(c);
        final Criteria criteria = detached.getExecutableCriteria(HibernateUtil.currentSession());

        return criteria;
    }

}
