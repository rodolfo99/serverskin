/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.siabuc.apiskin.models.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author rodolfo
 */
@Entity
@Table(name="diccionariodatos")
public class Diccionario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_dic")
    private Long idDic;
    
    @Column(name="formulario", nullable=false)
    private String formulario;
    
    @Column(name="control", nullable=false)
    private String control;
    
    @Column(name="texto", nullable=false)
    private String texto;
    

    @Column(name="sustituto", nullable=false)
    private String sustituto;
    
    @Column(name="modulo",nullable=false)
    private String modulo;

    public Long getIdDic() {
        return idDic;
    }

    public void setIdDic(Long idDic) {
        this.idDic = idDic;
    }

    public String getFormulario() {
        return formulario;
    }

    public void setFormulario(String formulario) {
        this.formulario = formulario;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getSustituto() {
        return sustituto;
    }

    public void setSustituto(String sustituto) {
        this.sustituto = sustituto;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    
    
    
}
