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
import br.unisal.model.EstruturaPedido;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ViewScoped
@ManagedBean(name = "estruturasPedidoBean")
public class EstruturaPedidoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<EstruturaPedido> estruturasPedido = new ArrayList();
    private EstruturaPedido estruturaPedido;
    private GenericDao dao;

    //construtor
    public EstruturaPedidoBean() {
        this.estruturasPedido = this.getDao().getAll(EstruturaPedido.class);
        this.estruturaPedido = new EstruturaPedido();
    }

    //Métodos dos botões 
    public void cadastrar(ActionEvent actionEvent) {
        this.getDao().save(this.estruturasPedido);
        this.estruturasPedido = this.getDao().getAll(EstruturaPedido.class);
        this.estruturaPedido = new EstruturaPedido();
    }

    public void alterar(ActionEvent actionEvent) {
        this.getDao().update(this.estruturasPedido);
        this.estruturasPedido = this.getDao().getAll(EstruturaPedido.class);
        this.estruturaPedido = new EstruturaPedido();
    }

    public void excluir(ActionEvent actionEvent) {
        this.getDao().remove(this.estruturasPedido);
        this.estruturasPedido = this.getDao().getAll(EstruturaPedido.class);
        this.estruturaPedido = new EstruturaPedido();
    }

    //getters and setters
    public EstruturaPedido getEstruturaPedido() {
        return this.estruturaPedido;
    }

    public void setEstruturaPedido(EstruturaPedido arg) {
        this.estruturaPedido = arg;
    }

    public List getEstruturasPedidos() {
        return this.estruturasPedido;
    }

    public void setEstruturasPedidos(List arg) {
        this.estruturasPedido = arg;
    }

    public final GenericDao getDao() {
        if (this.dao == null) {
            this.dao = new GenericDao();
        }
        return this.dao;
    }
}
