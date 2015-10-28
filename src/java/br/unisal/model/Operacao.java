/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unisal.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author JETHER
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"v1", "v2", "resultado"})
public class Operacao implements Serializable{
    private Double v1;
    private Double v2; 
    private Double resultado;

    public Operacao() {
    }

    public Operacao(Double v1, Double v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public Double getV1() {
        return v1;
    }

    public void setV1(Double v1) {
        this.v1 = v1;
    }

    public Double getV2() {
        return v2;
    }

    public void setV2(Double v2) {
        this.v2 = v2;
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }
        
    public void soma(){
        setResultado(getV1()+getV2());
    }
    
    public void subtracao(){
        setResultado(getV1()-getV2());
    }
    
    public void multiplicacao(){
        setResultado(getV1()*getV2());
    }
    
    public void divisao(){
        try {
            setResultado(getV1()/getV2());
        } catch (Exception e) {
            setResultado(null);
        }
        
    }
}
