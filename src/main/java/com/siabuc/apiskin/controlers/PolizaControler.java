/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.siabuc.apiskin.controlers;

import com.siabuc.apiskin.models.entities.Diccionario;
import com.siabuc.apiskin.models.entities.Usuario;
import com.siabuc.apiskin.servicios.IServicioDiccionario;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rodolfo
 */
@CrossOrigin(origins = {"http://148.213.21.76"})
@RestController
@RequestMapping("/api")
public class PolizaControler {

    @Autowired
    private IServicioDiccionario servicio;

    //aqui empiezo
    @GetMapping("/diccionario")
    public List<Diccionario> listarDiccionario() {
        return (List<Diccionario>) servicio.listarDiccionario();
    }
    
    @GetMapping("/diccionario/page/{page}")
    public Page<Diccionario> listarDiccionario(@PathVariable Integer page) {
        return (Page<Diccionario>) servicio.listarDiccionario(PageRequest.of(page, 10));
    }
    
    @GetMapping("/diccionario/page/{page}/{busqueda}/{modulo}")
    public Page<Diccionario> listarDiccionarioporMyF(@PathVariable Integer page, @PathVariable String busqueda,@PathVariable String modulo) {
        System.out.println(busqueda);
        return (Page<Diccionario>) servicio.listarDiccionarioporMyF(modulo, busqueda, PageRequest.of(page, 10));
    }
    
    @GetMapping("/diccionario/page/{page}/mostrarmodulo/{modulo}")
    public Page<Diccionario> listarDiccionarioporM(@PathVariable Integer page, @PathVariable String modulo) {
        
        return (Page<Diccionario>) servicio.listarDiccionarioporM(modulo, PageRequest.of(page, 10));
    }
    
    @GetMapping("/diccionario/page/{page}/mostrarconsulta/{consulta}")
    public Page<Diccionario> listarDiccionarioporB(@PathVariable Integer page, @PathVariable String consulta) {
    
        return (Page<Diccionario>) servicio.listarDiccionarioporB( consulta, PageRequest.of(page, 10));
    }
    
    @PostMapping("/creardiccionario")
    public ResponseEntity<?> CrearDiccionario(@RequestBody Diccionario polizax) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicio.GuardarDiccionario(polizax));
    }

    @PutMapping("/actualizardiccionario/{id}")
    public ResponseEntity<?> GuardarDiccionario(@RequestBody Diccionario dicx, @PathVariable Long id) {
        //return servicio.GuardarPoliza(polizax);
        Optional<Diccionario> o = servicio.ObtenerDiccionarioId(id);
        if (o.isPresent()) {
            Diccionario diccionarioDB = o.get();
            diccionarioDB.setControl(dicx.getControl());
            diccionarioDB.setFormulario(dicx.getFormulario());
            diccionarioDB.setModulo(dicx.getModulo());
            diccionarioDB.setSustituto(dicx.getSustituto());
            diccionarioDB.setTexto(dicx.getTexto());
            
            return ResponseEntity.status(HttpStatus.CREATED).body(servicio.GuardarDiccionario(diccionarioDB));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/borrardiccionario/{id}")
    public ResponseEntity<?> BorrarDiccionario(@PathVariable Long id) {
        Optional<Diccionario> o = servicio.ObtenerDiccionarioId(id);

        if (o.isPresent()) {
            servicio.BorrarDiccionario(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping("/diccionario/{id}")
    public ResponseEntity<?> ObtenerDiccionarioporId(@PathVariable Long id) {
        Optional<Diccionario> polix = servicio.ObtenerDiccionarioId(id);
        if (polix.isPresent()) {
            return ResponseEntity.ok(polix.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usr) {
        
        Usuario o = servicio.login(usr.getNombre(), usr.getPassword());
        if (o!=null) {
            return ResponseEntity.status(HttpStatus.OK).body(o);
        }
        return ResponseEntity.notFound().build();
    }

}
