/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.siabuc.apiskin.dao;


import com.siabuc.apiskin.models.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author rodolfo
 */
public interface UsuarioRepo extends JpaRepository< Usuario,Long> {
    
    @Query(value = "Select e from Usuario e where nombre=:nombre and password=:pass") 
    Usuario login(@Param("nombre") String nombre, @Param("pass") String pass);
           
}
