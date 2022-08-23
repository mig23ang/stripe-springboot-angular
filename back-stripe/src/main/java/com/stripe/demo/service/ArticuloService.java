/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stripe.demo.service;

import com.stripe.demo.model.Articulo;
import com.stripe.demo.repository.ArticuloRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author miguel-pc
 */
@Service
@Transactional(readOnly = true)
public class ArticuloService {

    @Autowired
    ArticuloRepository articuloRepository;

    //crear la lista de articulos
    public List<Articulo> lista() {
        List<Articulo> lista = articuloRepository.findAll();
        return lista;
    }

    //obtenr articulo apartir del @Id
    public Optional<Articulo> getById(Long id) {
        return articuloRepository.findById(id);
    }

    //traer unb articulo si existe por @id
    public boolean existeId(long id) {
        return articuloRepository.existsById(id);
    }
}
