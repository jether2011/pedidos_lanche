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
import br.unisal.model.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ViewScoped
@ManagedBean(name = "clienteBean")
public class ClienteBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List clientes = new ArrayList();
    private Cliente cliente;
    private GenericDao dao;

    //construtor
    public ClienteBean() {
        this.clientes = this.getDao().getAll(Cliente.class);
        this.cliente = new Cliente();
    }

    //Métodos dos botões 
    public void cadastrar(ActionEvent actionEvent) {
        this.getDao().save(this.cliente);
        this.clientes = this.getDao().getAll(Cliente.class);
        this.cliente = new Cliente();
    }

    public void alterar(ActionEvent actionEvent) {
        this.getDao().update(this.cliente);
        this.clientes = this.getDao().getAll(Cliente.class);
        this.cliente = new Cliente();
    }

    public void excluir(ActionEvent actionEvent) {
        this.getDao().remove(this.cliente);
        this.clientes = this.getDao().getAll(Cliente.class);
        this.cliente = new Cliente();
    }

    //getters and setters
    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente arg) {
        this.cliente = arg;
    }

    public List getClientes() {
        return this.clientes;
    }

    public void setClientes(List arg) {
        this.clientes = arg;
    }

    public final GenericDao getDao() {
        if (this.dao == null) {
            this.dao = new GenericDao();
        }
        return this.dao;
    }
}
