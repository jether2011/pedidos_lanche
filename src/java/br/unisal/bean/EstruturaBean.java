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
import br.unisal.model.Estrutura;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ViewScoped
@ManagedBean(name = "estruturasBean")
public class EstruturaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Estrutura> estruturas = new ArrayList();
    private Estrutura estrutura;
    private GenericDao dao;

    //construtor
    public EstruturaBean() {
        this.estruturas = this.getDao().getAll(Estrutura.class);
        this.estrutura = new Estrutura();
    }

    //Métodos dos botões 
    public void cadastrar(ActionEvent actionEvent) {
        this.getDao().save(this.estruturas);
        this.estruturas = this.getDao().getAll(Estrutura.class);
        this.estrutura = new Estrutura();
    }

    public void alterar(ActionEvent actionEvent) {
        this.getDao().update(this.estruturas);
        this.estruturas = this.getDao().getAll(Estrutura.class);
        this.estrutura = new Estrutura();
    }

    public void excluir(ActionEvent actionEvent) {
        this.getDao().remove(this.estruturas);
        this.estruturas = this.getDao().getAll(Estrutura.class);
        this.estrutura = new Estrutura();
    }

    //getters and setters
    public Estrutura getEstrutura() {
        return this.estrutura;
    }

    public void setEstrutura(Estrutura arg) {
        this.estrutura = arg;
    }

    public List getEstruturasPedidos() {
        return this.estruturas;
    }

    public void setEstruturasPedidos(List arg) {
        this.estruturas = arg;
    }

    public final GenericDao getDao() {
        if (this.dao == null) {
            this.dao = new GenericDao();
        }
        return this.dao;
    }
}
