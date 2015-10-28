/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisal;

import br.unisal.dao.GenericDao;
import br.unisal.hibernateutil.HibernateUtil;
import br.unisal.model.Cliente;
import br.unisal.model.Estrutura;
import br.unisal.model.EstruturaPedido;
import br.unisal.model.ItemPedido;
import br.unisal.model.MateriaPrima;
import br.unisal.model.Pedido;
import br.unisal.model.Produto;
import org.junit.After;
import org.junit.Before;

/**
 *
 * @author Carlos
 */
public class TestBase {

    @Before
    public void setUp() {
        HibernateUtil.getInstance("hibernate.test.cfg.xml");
    }

    @After
    public void setDown() {
        new GenericDao().deleteAll(Estrutura.class);
        new GenericDao().deleteAll(EstruturaPedido.class);
        new GenericDao().deleteAll(MateriaPrima.class);
        new GenericDao().deleteAll(ItemPedido.class);
        new GenericDao().deleteAll(Produto.class);
        new GenericDao().deleteAll(Pedido.class);
        new GenericDao().deleteAll(Cliente.class);
    }
}
