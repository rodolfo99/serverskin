/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.siabuc.apiskin.servicios;

import com.siabuc.apiskin.dao.DiccionarioRepository;
import com.siabuc.apiskin.dao.UsuarioRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.siabuc.apiskin.models.entities.Diccionario;
import com.siabuc.apiskin.models.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 *
 * @author rodolfo
 */
@Service
public class ServicioDiccionario implements IServicioDiccionario {
    
    @Autowired
    private DiccionarioRepository repoDiccionario;
    
    @Autowired
    private UsuarioRepo repoUsuario;


    @Override
    @Transactional(readOnly=true)
    public List<Diccionario> listarDiccionario() {
           return (List<Diccionario>)repoDiccionario.findAll();
    }
    
    @Override
    @Transactional(readOnly=true)
    public Page<Diccionario> listarDiccionario(Pageable pageable) {
        return (Page<Diccionario>)repoDiccionario.findAll( pageable);
    }

    @Override
    @Transactional()
    public Diccionario GuardarDiccionario(Diccionario poliza) {
           return repoDiccionario.save(poliza);
    }

    @Override
    @Transactional()
    public void BorrarDiccionario(Long id) {
           repoDiccionario.deleteById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Diccionario> ObtenerDiccionarioId(Long id) {
           return repoDiccionario.findById(id);
    }

    @Override
    public Page<Diccionario> listarDiccionarioporMyF(String modulo,String contenido, Pageable pageable) {
        return (Page<Diccionario>)repoDiccionario.listarDiccionarioporMyB(modulo,contenido, pageable);
    }

    @Override
    public Page<Diccionario> listarDiccionarioporM(String modulo, Pageable pageable) {
        return (Page<Diccionario>)repoDiccionario.listarDiccionarioporM(modulo, pageable);
    }
    
    @Override
    public Page<Diccionario> listarDiccionarioporB(String contenido, Pageable pageable) {
        return (Page<Diccionario>)repoDiccionario.listarDiccionarioporB(contenido, pageable);
    }

    @Override
    public Usuario login(String nombre, String pass) {
        return  repoUsuario.login(nombre, pass);
    }
}
