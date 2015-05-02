/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.dao.CategoriaDAO;
import br.ufmg.hc.telessaude.diagnostico.dominio.entity.Categoria;

/**
 *
 * @author paulo.gomes
 */
public class CategoriaDAOImpl extends DaoBase<Categoria> implements CategoriaDAO{

    public CategoriaDAOImpl() {
        super(Categoria.class);
    }
    
}
