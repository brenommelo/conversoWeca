/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.teletransferencia.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl.DaoBase;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.diagnostico.dominio.hibernate.HibernateUtil;
import br.ufmg.hc.telessaude.teletransferencia.dao.ExameTransferenciaDAO;
import br.ufmg.hc.telessaude.teletransferencia.dao.StatusExameTransferenciaDAO;
import br.ufmg.hc.telessaude.teletransferencia.entity.ExameTransferencia;
import br.ufmg.hc.telessaude.teletransferencia.entity.MunicipioTransferencia;
import br.ufmg.hc.telessaude.teletransferencia.entity.PacienteTransferencia;
import br.ufmg.hc.telessaude.teletransferencia.entity.PontoRemotoTransferencia;
import br.ufmg.hc.telessaude.teletransferencia.entity.StatusTransferencia;
import br.ufmg.hc.telessaude.teletransferencia.entity.TipoExameTransferencia;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author paulo.gomes
 */
public class ExameTransferenciaDAOImpl extends DaoBase<ExameTransferencia> implements ExameTransferenciaDAO {

    public ExameTransferenciaDAOImpl() {
        super(ExameTransferencia.class);
    }

    @Override
    public int consultarQuantidadeExames(int id_pontoRemoto, String status) throws DAOException {
        Integer quantidade = 0;
        try {
            final DetachedCriteria crit = DetachedCriteria.forClass(c);
            final Criteria criteria = crit.getExecutableCriteria(HibernateUtil.currentSession());

            if (!status.isEmpty()) {
                criteria.createAlias("status", "st");
                criteria.add(Restrictions.eq("st.nome", status));
            }

            criteria.add(Restrictions.eq("pontoRemoto.id", id_pontoRemoto));

            criteria.setProjection(Projections.count("id"));
            quantidade = (Integer) criteria.uniqueResult();
            return quantidade != null ? quantidade : 0;

        } catch (HibernateException ex) {
            throw new DAOException(ex.getMessage());
        }
    }

    @Override
    public List<ExameTransferencia> consultarExamesConcluidos(final String nomePaciente, final int id_pontoRemoto, final int start, final int maxResult) throws DAOException {
        return findByRestrictions(start, maxResult,
                Restrictions.like("pc.nome", nomePaciente, MatchMode.ANYWHERE),
                Restrictions.eq("pontoRemoto.id", id_pontoRemoto));
    }

    @Override
    public List<ExameTransferencia> findByRestrictions(final int start, final int maxResults, final Criterion... criterions) throws DAOException {
        try {
            final DetachedCriteria crit = DetachedCriteria.forClass(c);
            final Criteria criteria = crit.getExecutableCriteria(HibernateUtil.currentSession());
            criteria.createAlias("paciente", "pc");
            criteria.createAlias("status", "st");
            criteria.createAlias("tipoExame", "tipo");
            criteria.createAlias("pontoRemoto", "pr");
            criteria.createAlias("pr.municipio", "mun");

            criteria.setProjection(Projections.projectionList()
                    .add(Projections.property("id"))
                    .add(Projections.property("pc.nome"))
                    .add(Projections.property("mun.nome"))
                    .add(Projections.property("dataInclusao"))
                    .add(Projections.property("st.nome"))
                    .add(Projections.property("tipo.nome")));

            criteria.addOrder(Order.desc("dataInclusao"));

            for (final Criterion cri : criterions) {
                criteria.add(cri);
            }

            if (maxResults != 0) {
                criteria.setMaxResults(maxResults);
            }
            if (start > 0) {
                criteria.setFirstResult(start);
            }

//            return criteria.list();
            final List<Object[]> arrays = criteria.list();
            final List<ExameTransferencia> exames = new ArrayList<>();

            for (Object[] array : arrays) {
                final ExameTransferencia exame = new ExameTransferencia(Integer.parseInt(String.valueOf(array[0])));
                exame.setPaciente(new PacienteTransferencia());
                exame.getPaciente().setNome(String.valueOf(array[1]));
                exame.setPontoRemoto(new PontoRemotoTransferencia());
                exame.getPontoRemoto().setMunicipio(new MunicipioTransferencia());
                exame.getPontoRemoto().getMunicipio().setNome(String.valueOf(array[2]));
                exame.setDataInclusao((Date) array[3]);
                exame.setStatus(new StatusTransferencia());
                exame.getStatus().setNome(String.valueOf(array[4]));
                exame.setTipoExame(new TipoExameTransferencia());
                exame.getTipoExame().setNome(String.valueOf(array[5]));

                exames.add(exame);
            }

            return exames;

        } catch (HibernateException ex) {
            throw new DAOException(ex.getMessage());
        }
    }

    public List<ExameTransferencia> findByRestrictions(final Criterion... criterions) throws DAOException {
        try {
            final DetachedCriteria crit = DetachedCriteria.forClass(c);
            final Criteria criteria = crit.getExecutableCriteria(HibernateUtil.currentSession());
            criteria.createAlias("paciente", "pc");
            criteria.createAlias("status", "st");
            criteria.createAlias("pontoRemoto", "pr");
            criteria.createAlias("tipoExame", "tipo");
//            criteria.createAlias("pr.municipio", "mun");

            criteria.addOrder(Order.desc("dataInclusao"));

            for (final Criterion cri : criterions) {
                criteria.add(cri);
            }

            return criteria.list();

        } catch (HibernateException ex) {
            throw new DAOException(ex.getMessage());
        }
    }

    @Override
    public List<ExameTransferencia> consultarExames(int id_pontoRemoto, int start, int maxResult) throws DAOException {
        return findByRestrictions(start, maxResult,
                Restrictions.eq("pontoRemoto.id", id_pontoRemoto));
    }

    @Override
    public List<ExameTransferencia> consultarExamesConcluidos(Integer id_usuario) throws DAOException {
        return findByRestrictions(Restrictions.eq("usuario.id", id_usuario), Restrictions.eq("st.nome", StatusExameTransferenciaDAO.STATUS.CONCLUIDO.toString()));
    }

    @Override
    public List<ExameTransferencia> consultarExamesConcluidos(final Integer id_usuario, final Integer id_tipo_exame) throws DAOException {
        return findByRestrictions(Restrictions.eq("usuario.id", id_usuario),
                Restrictions.eq("st.nome", StatusExameTransferenciaDAO.STATUS.CONCLUIDO.toString()),
                Restrictions.eq("tipo.id", id_tipo_exame));
    }

    @Override
    public List<ExameTransferencia> consultarExamesNaoLaudados(Integer id_usuario) throws DAOException {
        return findByRestrictions(Restrictions.eq("usuario.id", id_usuario), Restrictions.ne("st.nome", StatusExameTransferenciaDAO.STATUS.CONCLUIDO.toString()));
    }

    @Override
    public List<ExameTransferencia> consultarExamesNaoLaudados(final Integer id_usuario, final Integer id_tipo_exame) throws DAOException {
        return findByRestrictions(Restrictions.eq("usuario.id", id_usuario),
                Restrictions.ne("st.nome", StatusExameTransferenciaDAO.STATUS.CONCLUIDO.toString()),
                Restrictions.eq("tipo.id", id_tipo_exame));
    }

    @Override
    public ExameTransferencia consultarPorId(Integer id_exame) throws DAOException {
        return findById(id_exame);
    }

    @Override
    public ExameTransferencia retornarProximoExameNaFila(Integer id_usuario) throws DAOException {
        List<Object> ids = new PermissoesTransferenciaDAOImpl().consultarIdsTipoExamePorUsuario(id_usuario);
        if (ids == null || ids.size() == 0) {
            return null;
        }
        ExameTransferencia exame = null;
        try {
            final DetachedCriteria crit = DetachedCriteria.forClass(c);
            crit.add(Restrictions.in("tipoExame.id", ids));
            crit.add(Restrictions.eq("status.id", new StatusExameTransferenciaDAOImpl().consultarId(StatusExameTransferenciaDAOImpl.STATUS.EM_PROCESSAMENTO.toString())));
            crit.add(Restrictions.isNull("cod_especialista"));
            crit.addOrder(Order.asc("dataInclusao"));

            final Criteria criteria = crit.getExecutableCriteria(HibernateUtil.currentSession());
            criteria.setMaxResults(1);
            exame = (ExameTransferencia) criteria.uniqueResult();
            if (exame != null) {
                exame.setCod_especialista(id_usuario.toString());
                exame.setStatus(new StatusTransferencia(new StatusExameTransferenciaDAOImpl().consultarId(StatusExameTransferenciaDAOImpl.STATUS.LAUDANDO.toString())));
                this.saveOrUpdate(exame);
            }
        } catch (HibernateException ex) {
            throw new DAOException(ex.getMessage());
        }
        return exame;
    }

    @Override
    public Integer retornarQuantExameNaFila(Integer id_usuario) throws DAOException {
        List<Object> ids = new PermissoesTransferenciaDAOImpl().consultarIdsTipoExamePorUsuario(id_usuario);
        if (ids == null || ids.size() == 0) {
            return null;
        }
        Integer quant = null;
        try {
            final DetachedCriteria crit = DetachedCriteria.forClass(c);
            crit.add(Restrictions.in("tipoExame.id", ids));
            crit.add(Restrictions.eq("status.id", new StatusExameTransferenciaDAOImpl().consultarId(StatusExameTransferenciaDAOImpl.STATUS.EM_PROCESSAMENTO.toString())));
            crit.add(Restrictions.isNull("cod_especialista"));
//            crit.addOrder(Order.asc("dataInclusao"));

            final Criteria criteria = crit.getExecutableCriteria(HibernateUtil.currentSession());
            criteria.setProjection(Projections.count("id"));
            quant = (Integer) criteria.uniqueResult();
        } catch (HibernateException ex) {
            throw new DAOException(ex.getMessage());
        }
        return quant;
    }
}
