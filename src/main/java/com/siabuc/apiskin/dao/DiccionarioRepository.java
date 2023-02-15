/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.siabuc.apiskin.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import com.siabuc.apiskin.models.entities.Diccionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author rodolfo
 */
public interface DiccionarioRepository extends JpaRepository< Diccionario,Long>
{
           @Query(value = "Select e from Diccionario e order by idDic")   
           Page<Diccionario> findAll(Pageable pageable);       
    
           @Query(value = "Select e from Diccionario e where modulo like %:modulo% and texto like %:buscado% order by idDic") 
           Page<Diccionario> listarDiccionarioporMyB(@Param("modulo") String modulo, @Param("buscado") String contenido, Pageable pageable);
           
          @Query(value = "Select e from Diccionario e where modulo like %:modulo%  order by idDic") 
           Page<Diccionario> listarDiccionarioporM(@Param("modulo") String modulo, Pageable pageable);
           
           @Query(value = "Select e from Diccionario e where texto like %:buscado% order by idDic") 
           Page<Diccionario> listarDiccionarioporB( @Param("buscado") String contenido, Pageable pageable);
           
}
