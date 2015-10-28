/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisal;

import br.unisal.dao.GenericDao;
import br.unisal.model.MateriaPrima;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Carlos
 */
public class MateriaPrimaTest extends TestBase {

    private GenericDao dao = new GenericDao();

    @Test
    public void testSalvar() {
        MateriaPrima c = new MateriaPrima();
        c.setNome("MateriaPrima 1");
        Long save = this.dao.save(c);

        MateriaPrima materiaPrimaEncontrada = this.dao.getById(MateriaPrima.class, save);

        Assert.assertEquals("MateriaPrima 1", materiaPrimaEncontrada.getNome());
    }

    @Test
    public void testBuscarTodos() {
        MateriaPrima c1 = new MateriaPrima();
        c1.setNome("MateriaPrima 1");
        this.dao.save(c1);
        MateriaPrima c2 = new MateriaPrima();
        c2.setNome("MateriaPrima 2");
        this.dao.save(c2);
        MateriaPrima c3 = new MateriaPrima();
        c3.setNome("MateriaPrima 3");
        this.dao.save(c3);

        List<MateriaPrima> lista = this.dao.getAll(MateriaPrima.class);

        Assert.assertEquals(3, lista.size());
    }

    @Test
    public void testAtualizar() {
        MateriaPrima c = new MateriaPrima();
        c.setNome("MateriaPrima 1");
        Long save = this.dao.save(c);

        MateriaPrima materiaPrimaEncontrada = this.dao.getById(MateriaPrima.class, save);
        materiaPrimaEncontrada.setNome("MateriaPrima 1 ainda");
        this.dao.update(materiaPrimaEncontrada);

        MateriaPrima materiaPrimaEncontradaNovamente = this.dao.getById(MateriaPrima.class, save);

        Assert.assertEquals("MateriaPrima 1 ainda", materiaPrimaEncontradaNovamente.getNome());
    }

    @Test
    public void testeDeletar() {
        MateriaPrima c = new MateriaPrima();
        c.setNome("MateriaPrima 1");
        Long save = this.dao.save(c);

        MateriaPrima materiaPrimaEncontrada = this.dao.getById(MateriaPrima.class, save);

        Assert.assertEquals("MateriaPrima 1", materiaPrimaEncontrada.getNome());

        this.dao.remove(materiaPrimaEncontrada);

        materiaPrimaEncontrada = this.dao.getById(MateriaPrima.class, save);

        Assert.assertNull(materiaPrimaEncontrada);

    }
}
