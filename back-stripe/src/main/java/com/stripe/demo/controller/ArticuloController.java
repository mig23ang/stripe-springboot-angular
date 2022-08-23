/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stripe.demo.controller;

import com.stripe.demo.http.Mensaje;
import com.stripe.demo.model.Articulo;
import com.stripe.demo.service.ArticuloService;
import com.stripe.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author miguel-pc
 */
@RestController
@RequestMapping("/articulo")
@CrossOrigin(origins = "*")
public class ArticuloController {

    @Autowired
    ArticuloService articuloService;

    //metodo get para obtener todos los articulos
    @GetMapping("/lista")
    public ResponseEntity<List<Articulo>> lista() {
        List<Articulo> lista = articuloService.lista();
        return new ResponseEntity<List<Articulo>>(lista, HttpStatus.OK);
    }

    //metodo get para obtener un articulo por id
    @GetMapping("/detalle/{id}")
    public ResponseEntity<Articulo> detalle(@PathVariable("id") long id) {
        Articulo articulo = articuloService.getById(id).get();
        return new ResponseEntity<Articulo>(articulo, HttpStatus.OK);
    }

}
