package com.nico.nuevoproyectotarea.repository;

import com.nico.nuevoproyectotarea.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findByEmail(String email);
    Cliente findByDni(String dni);
}
