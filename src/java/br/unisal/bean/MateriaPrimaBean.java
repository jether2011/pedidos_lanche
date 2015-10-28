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
import br.unisal.model.MateriaPrima;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ViewScoped
@ManagedBean(name = "materiaPrimaBean")
public class MateriaPrimaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<MateriaPrima> materiasPrima = new ArrayList();
    private MateriaPrima materiaPrima;
    private GenericDao dao;

    //construtor
    public MateriaPrimaBean() {
        this.materiasPrima = this.getDao().getAll(MateriaPrima.class);
        this.materiaPrima = new MateriaPrima();
    }

    //Métodos dos botões 
    public void cadastrar(ActionEvent actionEvent) {
        this.getDao().save(this.materiaPrima);
        this.materiasPrima = this.getDao().getAll(MateriaPrima.class);
        this.materiaPrima = new MateriaPrima();
    }

    public void alterar(ActionEvent actionEvent) {
        this.getDao().update(this.materiaPrima);
        this.materiasPrima = this.getDao().getAll(MateriaPrima.class);
        this.materiaPrima = new MateriaPrima();
    }

    public void excluir(ActionEvent actionEvent) {
        this.getDao().remove(this.materiaPrima);
        this.materiasPrima = this.getDao().getAll(MateriaPrima.class);
        this.materiaPrima = new MateriaPrima();
    }

    //getters and setters
    public MateriaPrima getMateriaPrima() {
        return this.materiaPrima;
    }

    public void setMateriaPrima(MateriaPrima pessoa) {
        this.materiaPrima = pessoa;
    }

    public List getMateriaPrimas() {
        return this.materiasPrima;
    }

    public void setMateriaPrimas(List pessoas) {
        this.materiasPrima = pessoas;
    }

    public final GenericDao getDao() {
        if (this.dao == null) {
            this.dao = new GenericDao();
        }
        return this.dao;
    }
}
