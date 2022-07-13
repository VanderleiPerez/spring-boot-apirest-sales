package com.empresa.mitosales.controller;

import com.empresa.mitosales.exception.ModelNotFoundException;
import com.empresa.mitosales.model.Category;
import com.empresa.mitosales.service.ICategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private ICategoryService service;

    public CategoryController(ICategoryService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<Category>> readAll() throws Exception{
        List<Category> list =  service.readAll();
        return new ResponseEntity<>(list, HttpStatus.OK); //200: Petición resuelta correctamente
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> readById(@PathVariable("id") Integer id) throws Exception{
        Category obj = service.readById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: "+id);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category cat) throws Exception{
        Category obj = service.create(cat);
        return new ResponseEntity<>(obj, HttpStatus.CREATED); //201: Recurso creado correctamente
    }

    @PutMapping
    public ResponseEntity<Category> update(@RequestBody Category cat) throws Exception{
        //verificar si existe
        Category findObj = service.readById(cat.getIdCategory());
        if(findObj == null){
            throw new ModelNotFoundException("ID NOT FOUND: "+cat.getIdCategory());
        }
        //actualizar
        Category obj = service.update(cat);
        return new ResponseEntity<>(obj, HttpStatus.OK); //200
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable("id") Integer id) throws Exception{
        //verificar si existe
        Category obj = service.readById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: "+id);
        }
        //eliminar
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204: No hay contenido
    }
}
