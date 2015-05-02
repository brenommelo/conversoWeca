/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.dao.PacienteDAO;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.Paciente;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.diagnostico.dominio.hibernate.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author paulo.gomes
 */
public class PacienteDAOImpl extends DaoBase<Paciente> implements PacienteDAO {

    public PacienteDAOImpl() {
        super(Paciente.class);
    }

    @Override
    public void verificarPaciente(Paciente paciente) throws DAOException {
        try {
            final DetachedCriteria crit = DetachedCriteria.forClass(c);
            final Criteria criteria = crit.getExecutableCriteria(HibernateUtil.currentSession());
            criteria.setProjection(Projections.property("id"));
            criteria.add(Restrictions.eq("sexo", paciente.getSexo()));
            criteria.add(Restrictions.eq("nome", paciente.getNome()));
            criteria.add(Restrictions.eq("datanascimento", paciente.getDatanascimento()));
            if (paciente.getCidade() != null && !paciente.getCidade().isEmpty()) {
                criteria.add(Restrictions.eq("cidade", paciente.getCidade()));
            }
            criteria.setMaxResults(1);
            Integer id = (Integer) criteria.uniqueResult();
            paciente.setId(id);
        } catch (HibernateException ex) {
            throw new DAOException(ex.getMessage());
        }
    }

}
