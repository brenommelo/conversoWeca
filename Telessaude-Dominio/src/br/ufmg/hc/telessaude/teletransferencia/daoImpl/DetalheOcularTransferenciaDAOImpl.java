/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.hc.telessaude.teletransferencia.daoImpl;

import br.ufmg.hc.telessaude.diagnostico.dominio.daoImpl.DaoBase;
import br.ufmg.hc.telessaude.teletransferencia.dao.DetalheOcularTransferenciaDAO;
import br.ufmg.hc.telessaude.teletransferencia.entity.DetalheOcularTransferencia;

/**
 *
 * @author paulo.gomes
 */
public class DetalheOcularTransferenciaDAOImpl extends DaoBase<DetalheOcularTransferencia> implements DetalheOcularTransferenciaDAO{

    public DetalheOcularTransferenciaDAOImpl() {
        super(DetalheOcularTransferencia.class);
    }
    
}
