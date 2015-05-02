/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.dao.ExameDAO;
import br.ufmg.hc.telessaude.diagnostico.dominio.dao.PacienteDAO;
import br.ufmg.hc.telessaude.diagnostico.dominio.dao.StatusDAO;
import br.ufmg.hc.telessaude.diagnostico.dominio.dao.TipoExameDAO;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.ConteudoExame;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.Exame;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.HistoricoClinico;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.ModeloConteudoExame;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.ModeloHistoricoClinico;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.Paciente;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.PontoRemoto;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.Status;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.TipoExame;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import br.ufmg.hc.telessaude.diagnostico.dominio.hibernate.HibernateUtil;
import br.ufmg.hc.telessaude.teletransferencia.dao.StatusExameTransferenciaDAO;
import br.ufmg.hc.telessaude.teletransferencia.daoImpl.StatusExameTransferenciaDAOImpl;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
public class ExameDAOImpl extends DaoBase<Exame> implements ExameDAO {
    
    private StatusDAO daoStatus;
    private TipoExameDAO daoTipo;
    private PacienteDAO daoPaciente;
    
    public ExameDAOImpl() {
        super(Exame.class);
    }

    /**
     *
     * @param pontoRemoto
     * @param maxResults
     * @return
     * @throws DAOException
     */
    @Override
    public List<Exame> consultarExamesNaoVisualizados(final PontoRemoto pontoRemoto, final int maxResults) throws DAOException {
        return this.consultarExamesNaoVisualizados(pontoRemoto, 0, maxResults);
    }

    /**
     *
     * @param pontoRemoto
     * @param start
     * @param maxResults
     * @return
     * @throws DAOException
     */
    @Override
    public List<Exame> consultarExamesNaoVisualizados(PontoRemoto pontoRemoto, int start, int maxResults) throws DAOException {
        return findByRestrictions(start, maxResults,
                Restrictions.eq("pontoRemoto.id", pontoRemoto.getId()),
                Restrictions.eq("visualizado", 0),
                Restrictions.eq("st.nome", "CONCLUIDO"));
    }

    /**
     *
     * @param pontoRemoto
     * @param visualizado
     * @return
     * @throws DAOException
     */
    @Override
    public int consultarQuantidadeExames(PontoRemoto pontoRemoto, int visualizado) throws DAOException {
        Integer quantidade = 0;
        try {
            final DetachedCriteria crit = DetachedCriteria.forClass(c);
            final Criteria criteria = crit.getExecutableCriteria(HibernateUtil.currentSession());
            criteria.createAlias("status", "st");
            
            criteria.add(Restrictions.eq("pontoRemoto.id", pontoRemoto.getId()));
            criteria.add(Restrictions.eq("visualizado", visualizado));
            criteria.add(Restrictions.eq("st.nome", "CONCLUIDO"));
            
            criteria.setProjection(Projections.count("id"));
            quantidade = (int) criteria.uniqueResult();
            return quantidade;
            
        } catch (HibernateException ex) {
            throw new DAOException(ex.getMessage());
        }
    }

    /**
     *
     * @param pontoRemoto
     * @param maxResults
     * @return
     * @throws DAOException
     */
    @Override
    public List<Exame> consultarHistoricoExames(final PontoRemoto pontoRemoto, final int maxResults) throws DAOException {
        return this.consultarHistoricoExames(pontoRemoto, 0, maxResults);
    }

    /**
     *
     * @param pontoRemoto
     * @param start
     * @param maxResult
     * @return
     * @throws DAOException
     */
    @Override
    public List<Exame> consultarHistoricoExames(PontoRemoto pontoRemoto, int start, int maxResult) throws DAOException {
        return findByRestrictions(start, maxResult,
                Restrictions.eq("pontoRemoto.id", pontoRemoto.getId()),
                Restrictions.eq("visualizado", 1),
                Restrictions.eq("st.nome", "CONCLUIDO"));
    }

    /**
     *
     * @param nomePaciente
     * @param pontoRemoto
     * @return
     * @throws DAOException
     */
    @Override
    public List<Exame> consultarExamesConcluidos(final String nomePaciente, final PontoRemoto pontoRemoto) throws DAOException {
        return findByRestrictions(0,
                Restrictions.like("pc.nome", nomePaciente, MatchMode.ANYWHERE),
                Restrictions.eq("pontoRemoto.id", pontoRemoto.getId()),
                Restrictions.eq("st.nome", "CONCLUIDO"),
                Restrictions.between("datainclusao", getDate(true), getDate(false)));
    }

    /**
     *
     * @param start
     * @param maxResults
     * @param criterions
     * @return
     * @throws DAOException
     */
    @Override
    public List<Exame> findByRestrictions(final int start, final int maxResults, final Criterion... criterions) throws DAOException {
        try {
            final DetachedCriteria crit = DetachedCriteria.forClass(c);
            final Criteria criteria = crit.getExecutableCriteria(HibernateUtil.currentSession());
            
            crit.createAlias("paciente", "pc");
            crit.createAlias("status", "st");
            
            criteria.setProjection(Projections.projectionList()
                    .add(Projections.property("id"))
                    .add(Projections.property("pc.nome"))
                    .add(Projections.property("datainclusao"))
                    .add(Projections.property("st.nome")));
            
            criteria.addOrder(Order.desc("datainclusao"));
            
            for (final Criterion cri : criterions) {
                criteria.add(cri);
            }
            
            if (maxResults != 0) {
                criteria.setMaxResults(maxResults);
            }
            if (start > 0) {
                criteria.setFirstResult(start);
            }
            
            final List<Object[]> arrays = criteria.list();
            final List<Exame> exames = new ArrayList<>();
            
            for (Object[] array : arrays) {
                final Exame exame = new Exame(Integer.parseInt(String.valueOf(array[0])));
                exame.getPaciente().setNome(String.valueOf(array[1]));
                exame.setDatainclusao((Date) array[2]);
                exame.getStatus().setNome(String.valueOf(array[3]));
                
                exames.add(exame);
            }
            
            return exames;
            
        } catch (HibernateException ex) {
            throw new DAOException(ex.getMessage());
        }
    }
    
    private Date getDate(boolean lastFileDay) {
        final Calendar data = GregorianCalendar.getInstance();
        data.set(Calendar.DAY_OF_MONTH, data.get(Calendar.DATE));
        if (lastFileDay) {
            data.add(Calendar.MONTH, 0);
            data.add(Calendar.DAY_OF_MONTH, -5);
        }
        return data.getTime();
    }

    /**
     *
     * @param id_ponto
     * @return
     * @throws DAOException
     */
    @Override
    public List<Exame> consultarExamesNaoLaudados(Integer id_ponto) throws DAOException {
        return consultarExamesPorStatus(id_ponto, StatusExameTransferenciaDAO.STATUS.EM_PROCESSAMENTO, null);
    }

    /**
     *
     * @param id_ponto
     * @param id_tipo_exame
     * @return
     * @throws DAOException
     */
    @Override
    public List<Exame> consultarExamesNaoLaudados(final Integer id_ponto, final Integer id_tipo_exame) throws DAOException {
        return consultarExamesPorStatus(id_ponto, StatusExameTransferenciaDAO.STATUS.EM_PROCESSAMENTO, id_tipo_exame);
    }

    /**
     *
     * @param id_ponto
     * @param status
     * @param id_tipo_exame
     * @return
     * @throws DAOException
     */
    public List<Exame> consultarExamesPorStatus(Integer id_ponto, StatusExameTransferenciaDAO.STATUS status, Integer id_tipo_exame) throws DAOException {
        try {
            final DetachedCriteria crit = DetachedCriteria.forClass(c);
            final Criteria criteria = crit.getExecutableCriteria(HibernateUtil.currentSession());
            criteria.createAlias("paciente", "pc");
            criteria.createAlias("status", "st");
            criteria.createAlias("tipoExame", "tipo");
            criteria.createAlias("pontoRemoto", "pr");
            
            criteria.setProjection(Projections.projectionList()
                    .add(Projections.property("id"))
                    .add(Projections.property("pc.nome"))
                    .add(Projections.property("pr.nome"))
                    .add(Projections.property("datainclusao"))
                    .add(Projections.property("st.nome"))
                    .add(Projections.property("tipo.nome"))
                    .add(Projections.property("pc.datanascimento"))
                    .add(Projections.property("datarealizacao")));
            
            criteria.add(Restrictions.eq("st.nome", status.toString()));
            criteria.add(Restrictions.eq("pr.id", id_ponto));
            criteria.addOrder(Order.desc("datainclusao"));
            
            if (status == StatusExameTransferenciaDAO.STATUS.CONCLUIDO) {
                criteria.add(Restrictions.between("datainclusao", getDate(true), getDate(false)));
            }
            
            if (id_tipo_exame != null) {
                criteria.add(Restrictions.eq("tipo.id", id_tipo_exame));
            }
            
            criteria.setMaxResults(30);

//            return criteria.list();
            final List<Object[]> arrays = criteria.list();
            final List<Exame> exames = new ArrayList<>();
            
            for (Object[] array : arrays) {
                final Exame exame = new Exame(Integer.parseInt(String.valueOf(array[0])));
                exame.setPaciente(new Paciente());
                exame.getPaciente().setNome(String.valueOf(array[1]));
                exame.setPontoRemoto(new PontoRemoto());
                exame.getPontoRemoto().setNome(String.valueOf(array[2]));
                exame.setDatainclusao((Date) array[3]);
                exame.setStatus(new Status());
                exame.getStatus().setNome(String.valueOf(array[4]));
                exame.setTipoExame(new TipoExame());
                exame.getTipoExame().setNome(String.valueOf(array[5]));
                exame.getPaciente().setDatanascimento((Date) array[6]);
                exame.setDatarealizacao((Date) array[7]);
                
                exames.add(exame);
            }
            
            return exames;
            
        } catch (HibernateException ex) {
            throw new DAOException(ex.getMessage());
        }
    }

    /**
     *
     * @param id_ponto
     * @return
     * @throws DAOException
     */
    @Override
    public List<Exame> consultarExamesLaudados(Integer id_ponto) throws DAOException {
        return consultarExamesPorStatus(id_ponto, StatusExameTransferenciaDAO.STATUS.CONCLUIDO, null);
    }

    /**
     *
     * @param id_ponto
     * @param id_tipo_exame
     * @return
     * @throws DAOException
     */
    @Override
    public List<Exame> consultarExamesLaudados(final Integer id_ponto, final Integer id_tipo_exame) throws DAOException {
        return consultarExamesPorStatus(id_ponto, StatusExameTransferenciaDAO.STATUS.CONCLUIDO, id_tipo_exame);
    }
    
    protected boolean verificarExistenciaExame(Exame exame) throws DAOException {
        try {
            final DetachedCriteria crit = DetachedCriteria.forClass(c);
            final Criteria criteria = crit.getExecutableCriteria(HibernateUtil.currentSession());
            
            crit.createAlias("paciente", "pc");
            
            criteria.setProjection(Projections.projectionList()
                    .add(Projections.property("id")));
            criteria.add(Restrictions.eq("datarealizacao", exame.getDatarealizacao()));
            criteria.add(Restrictions.eq("pontoRemoto.id", exame.getPontoRemoto().getId()));
            criteria.add(Restrictions.eq("pc.nome", exame.getPaciente().getNome()));
            criteria.add(Restrictions.eq("pc.datanascimento", exame.getPaciente().getDatanascimento()));
            
            criteria.setMaxResults(1);
            return criteria.uniqueResult() != null;
        } catch (HibernateException ex) {
            throw new DAOException(ex.getMessage());
        }
    }
    
    @Override
    public Integer salvarExame(Exame exame) throws DAOException {
        if (verificarExistenciaExame(exame)) {
            return -1;
        }
        exame.setStatus(getDaoStatus().findByName("EM PROCESSAMENTO"));
        exame.setTipoExame(getDaoTipo().findByName("ECG 12 DERIVACOES"));
        getDaoPaciente().verificarPaciente(exame.getPaciente());
        try {
            session = HibernateUtil.currentSession();
            transaction = session.beginTransaction();
            // Salvando Paciente
            session.saveOrUpdate(exame.getPaciente());
//            session.flush();
            // Salvando exame
            exame.setDatainclusao(Calendar.getInstance().getTime());
            session.saveOrUpdate(exame);
            // Salvando Conteudo exame
            for (ConteudoExame conteudoExame : exame.getConteudosExames()) {
                conteudoExame.setExame(exame);
                conteudoExame.setModeloConteudoExame(new ModeloConteudoExame(1));
                session.saveOrUpdate(conteudoExame);
            }
            // Salvando Historico
            for (HistoricoClinico historicoClinico : exame.getHistoricosClinicos()) {
                historicoClinico.setExame(exame);
                historicoClinico.setModeloHistoricoClinico(new ModeloHistoricoClinico(1));
                session.saveOrUpdate(historicoClinico);
            }
            // Commit
            transaction.commit();
            return exame.getId();
        } catch (Exception ex) {
            transaction.rollback();
            throw new DAOException(ex.getMessage());
        } finally {
            this.closeSession();
        }
    }
    
    public StatusDAO getDaoStatus() {
        if (daoStatus == null) {
            daoStatus = new StatusDAOImpl();
        }
        return daoStatus;
    }
    
    public TipoExameDAO getDaoTipo() {
        if (daoTipo == null) {
            daoTipo = new TipoExameDAOImpl();
        }
        return daoTipo;
    }
    
    public PacienteDAO getDaoPaciente() {
        if (daoPaciente == null) {
            daoPaciente = new PacienteDAOImpl();
        }
        return daoPaciente;
    }
}
