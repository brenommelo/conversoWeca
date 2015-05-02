/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.diagnostico.dominio.auditoria.dao;

import br.ufmg.hc.telessaude.diagnostico.dominio.auditoria.entity.AuditoriaECG;
import br.ufmg.hc.telessaude.diagnostico.dominio.dao.GenericDao;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;
import java.util.List;

/**
 *
 * @author paulo.gomes
 */
public interface AuditoriaECGDAO extends GenericDao<AuditoriaECG> {
    
    public List<AuditoriaECG> consultarAuditoria(Integer idLaudo) throws DAOException;
}
