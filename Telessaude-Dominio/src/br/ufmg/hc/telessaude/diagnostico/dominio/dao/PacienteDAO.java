/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.dao;

import br.ufmg.hc.telessaude.diagnostico.dominio.entity.Paciente;
import br.ufmg.hc.telessaude.diagnostico.dominio.exceptions.DAOException;

/**
 *
 * @author paulo.gomes
 */
public interface PacienteDAO extends GenericDao<Paciente>{
    
    public void verificarPaciente(Paciente paciente) throws DAOException;
    
}
