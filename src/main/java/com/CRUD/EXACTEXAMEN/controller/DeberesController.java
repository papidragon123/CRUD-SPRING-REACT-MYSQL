package com.CRUD.EXACTEXAMEN.controller;

import com.CRUD.EXACTEXAMEN.exception.DeberesNotFoundException;
import com.CRUD.EXACTEXAMEN.model.Deberes;
import com.CRUD.EXACTEXAMEN.repository.DeberesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class DeberesController {

    @Autowired
    private DeberesRepository deberesRepository;

    @PostMapping("/deber")
    Deberes getNewDeberes(@RequestBody Deberes newDeberes) {

        return deberesRepository.save(newDeberes);
    }

    @GetMapping("/deberes")
    List<Deberes> getAllDeberes() {
        return deberesRepository.findAll();
    }

    @GetMapping("/deber/{id}")
    Deberes getDeberesById(@PathVariable Long id) {
        return deberesRepository.findById(id)
                .orElseThrow(() -> new DeberesNotFoundException(id));
    }

    @PutMapping("/deber/{id}")
    Deberes updateDeberes(@RequestBody Deberes newDeberes, @PathVariable Long id) {
        return deberesRepository.findById(id)
                .map(deberes -> {
                    deberes.setDescripcion(newDeberes.getDescripcion());
                    return deberesRepository.save(deberes);
                }).orElseThrow(() -> new DeberesNotFoundException(id));
    }

    @DeleteMapping("/deber/{id}")
    String deleteDeberes(@PathVariable Long id){
        if(!deberesRepository.existsById(id)){
            throw new DeberesNotFoundException(id);
        }
        deberesRepository.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }



}
