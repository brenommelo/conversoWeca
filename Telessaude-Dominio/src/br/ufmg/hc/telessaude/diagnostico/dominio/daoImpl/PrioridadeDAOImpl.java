/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.dao.PrioridadeDAO;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.Prioridade;

/**
 *
 * @author paulo.gomes
 */
public class PrioridadeDAOImpl extends DaoBase<Prioridade> implements PrioridadeDAO{

    public PrioridadeDAOImpl() {
        super(Prioridade.class);
    }
    
}
