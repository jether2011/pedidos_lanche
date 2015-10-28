/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisal;

import br.unisal.dao.GenericDao;
import br.unisal.model.Cliente;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Carlos
 */
public class ClienteTest extends TestBase {

    private GenericDao dao = new GenericDao();

    @Test
    public void testSalvar() {
        Cliente c = new Cliente();
        c.setNome("Cliente 1");
        Long save = this.dao.save(c);

        Cliente clienteEncontrado = this.dao.getById(Cliente.class, save);

        Assert.assertEquals("Cliente 1", clienteEncontrado.getNome());
    }

    @Test
    public void testBuscarTodos() {
        Cliente c1 = new Cliente();
        c1.setNome("Cliente 1");
        this.dao.save(c1);
        Cliente c2 = new Cliente();
        c2.setNome("Cliente 2");
        this.dao.save(c2);
        Cliente c3 = new Cliente();
        c3.setNome("Cliente 3");
        this.dao.save(c3);

        List<Cliente> lista = this.dao.getAll(Cliente.class);

        Assert.assertEquals(3, lista.size());
    }

    @Test
    public void testAtualizar() {
        Cliente c = new Cliente();
        c.setNome("Cliente 1");
        Long save = this.dao.save(c);

        Cliente clienteEncontrado = this.dao.getById(Cliente.class, save);
        clienteEncontrado.setNome("Cliente 1 ainda");
        this.dao.update(clienteEncontrado);

        Cliente clienteEncontradoNovamente = this.dao.getById(Cliente.class, save);

        Assert.assertEquals("Cliente 1 ainda", clienteEncontradoNovamente.getNome());
    }

    @Test
    public void testeDeletar() {
        Cliente c = new Cliente();
        c.setNome("Cliente 1");
        Long save = this.dao.save(c);

        Cliente clienteEncontrado = this.dao.getById(Cliente.class, save);

        Assert.assertEquals("Cliente 1", clienteEncontrado.getNome());

        this.dao.remove(clienteEncontrado);

        clienteEncontrado = this.dao.getById(Cliente.class, save);

        Assert.assertNull(clienteEncontrado);
    }
    
}
