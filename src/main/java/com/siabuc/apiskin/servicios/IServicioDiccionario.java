/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.siabuc.apiskin.servicios;

import com.siabuc.apiskin.models.entities.Diccionario;
import com.siabuc.apiskin.models.entities.Usuario;
import java.util.Optional;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
/**
 *
 * @author rodolfo
 */
public interface IServicioDiccionario {
    
    public List<Diccionario> listarDiccionario();
    public Page<Diccionario> listarDiccionario(Pageable pageable);
    public Page<Diccionario> listarDiccionarioporMyF(String modulo,String contenido, Pageable pageable);
    public Diccionario GuardarDiccionario(Diccionario poliza);
    public void BorrarDiccionario(Long id);
    public Optional<Diccionario> ObtenerDiccionarioId(Long id);
    public Page<Diccionario> listarDiccionarioporM(String modul, Pageable pageable);
    public Page<Diccionario> listarDiccionarioporB(String contenido, Pageable pageable);
    
    public Usuario login(String nombre, String user);
}
