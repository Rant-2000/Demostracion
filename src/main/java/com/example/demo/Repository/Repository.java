/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.Repository;

import com.example.demo.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Repository extends JpaRepository<Cliente, Long>{
     
}
