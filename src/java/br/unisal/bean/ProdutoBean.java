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
import br.unisal.model.Produto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ViewScoped
@ManagedBean(name = "produtoBean")
public class ProdutoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Produto> produtos = new ArrayList();
    private Produto produto;
    private GenericDao dao;

    //construtor
    public ProdutoBean() {
        this.produtos = this.getDao().getAll(Produto.class);
        this.produto = new Produto();
    }

    //Métodos dos botões 
    public void cadastrar(ActionEvent actionEvent) {
        this.getDao().save(this.produto);
        this.produtos = this.getDao().getAll(Produto.class);
        this.produto = new Produto();
    }

    public void alterar(ActionEvent actionEvent) {
        this.getDao().update(this.produto);
        this.produtos = this.getDao().getAll(Produto.class);
        this.produto = new Produto();
    }

    public void excluir(ActionEvent actionEvent) {
        this.getDao().remove(this.produto);
        this.produtos = this.getDao().getAll(Produto.class);
        this.produto = new Produto();
    }

    //getters and setters
    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto arg) {
        this.produto = arg;
    }

    public List getProdutos() {
        return this.produtos;
    }

    public void setProdutos(List arg) {
        this.produtos = arg;
    }

    public final GenericDao getDao() {
        if (this.dao == null) {
            this.dao = new GenericDao();
        }
        return this.dao;
    }
}
