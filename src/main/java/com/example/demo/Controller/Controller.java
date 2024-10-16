/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import com.example.demo.Models.Cliente;
import com.example.demo.Repository.Repository;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private Repository repo;

    @GetMapping("/")
    public String inicio() {

        return "Conectado";
    }

    @GetMapping("/Clientes")
    public List<Cliente> clientesLista() {

        return repo.findAll();
    }

    @PostMapping("/guardar")
    public String save(@RequestBody Cliente cliente) {
        repo.save(cliente);
        return "Correcto";
    }

    /* @PutMapping("/editar/{idCliente}")
    public String editar(@PathVariable Long idCliente,@RequestBody Cliente cliente){
        Cliente clienteViejo=repo.findById(idCliente).get();
        clienteViejo.setNombre(cliente.getNombre());
        clienteViejo.setApellidos(cliente.getApellidos());
        repo.save(clienteViejo);
        return "Actualizado";
    }*/
    @PutMapping("/editar/{idCliente}")
    public ResponseEntity<String> editar(@PathVariable Long idCliente, @RequestBody Cliente cliente) {
        try {
            Cliente clienteViejo = repo.findById(idCliente).orElseThrow(() -> new NoSuchElementException("Cliente no encontrado"));
            clienteViejo.setNombre(cliente.getNombre());
            clienteViejo.setApellidos(cliente.getApellidos());
            repo.save(clienteViejo);
            return new ResponseEntity<>("Actualizado", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Cliente no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/borrar/{idCliente}")
    public ResponseEntity<String> eliminar(@PathVariable Long idCliente) {
        try {
            Cliente cli = repo.findById(idCliente).orElseThrow(() -> new NoSuchElementException("Cliente no encontrado"));
        repo.delete(cli);
          return new ResponseEntity<>("Cliente borrado", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Cliente no encontrado", HttpStatus.NOT_FOUND);
        }
        
        
    }
}
