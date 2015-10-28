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
import br.unisal.model.Pedido;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ViewScoped
@ManagedBean(name = "pedidoBean")
public class PedidoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List pedidos = new ArrayList();
    private Pedido pedido;
    private GenericDao dao;

    //construtor
    public PedidoBean() {
        this.pedidos = this.getDao().getAll(Pedido.class);
        this.pedido = new Pedido();
    }

    //Métodos dos botões 
    public void cadastrar(ActionEvent actionEvent) {
        this.getDao().save(this.pedido);
        this.pedidos = this.getDao().getAll(Pedido.class);
        this.pedido = new Pedido();
    }

    public void alterar(ActionEvent actionEvent) {
        this.getDao().update(this.pedido);
        this.pedidos = this.getDao().getAll(Pedido.class);
        this.pedido = new Pedido();
    }

    public void excluir(ActionEvent actionEvent) {
        this.getDao().remove(this.pedido);
        this.pedidos = this.getDao().getAll(Pedido.class);
        this.pedido = new Pedido();
    }

    //getters and setters
    public Pedido getPedido() {
        return this.pedido;
    }

    public void setPedido(Pedido arg) {
        this.pedido = arg;
    }

    public List getPedidos() {
        return this.pedidos;
    }

    public void setPedidos(List args) {
        this.pedidos = args;
    }

    public final GenericDao getDao() {
        if (this.dao == null) {
            this.dao = new GenericDao();
        }
        return this.dao;
    }
}
