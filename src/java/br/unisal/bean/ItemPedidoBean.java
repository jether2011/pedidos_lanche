/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisal.bean;

/**
 * @author carlos.oliveira
 */
import br.unisal.dao.GenericDao;
import br.unisal.model.ItemPedido;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ViewScoped
@ManagedBean(name = "itemPedidoBean")
public class ItemPedidoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<ItemPedido> itensPedido = new ArrayList();
    private ItemPedido itemPedido;
    private GenericDao dao;

    //construtor
    public ItemPedidoBean() {
        this.itensPedido = this.getDao().getAll(ItemPedido.class);
        this.itemPedido = new ItemPedido();
    }

    //Métodos dos botões 
    public void cadastrar(ActionEvent actionEvent) {
        this.getDao().save(this.itensPedido);
        this.itensPedido = this.getDao().getAll(ItemPedido.class);
        this.itemPedido = new ItemPedido();
    }

    public void alterar(ActionEvent actionEvent) {
        this.getDao().update(this.itensPedido);
        this.itensPedido = this.getDao().getAll(ItemPedido.class);
        this.itemPedido = new ItemPedido();
    }

    public void excluir(ActionEvent actionEvent) {
        this.getDao().remove(this.itensPedido);
        this.itensPedido = this.getDao().getAll(ItemPedido.class);
        this.itemPedido = new ItemPedido();
    }

    //getters and setters
    public ItemPedido getItemPedido() {
        return this.itemPedido;
    }

    public void setItemPedido(ItemPedido arg) {
        this.itemPedido = arg;
    }

    public List getEstruturasPedidos() {
        return this.itensPedido;
    }

    public void setEstruturasPedidos(List arg) {
        this.itensPedido = arg;
    }

    public final GenericDao getDao() {
        if (this.dao == null) {
            this.dao = new GenericDao();
        }
        return this.dao;
    }
}
