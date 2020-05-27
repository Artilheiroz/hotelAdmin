package com.hotalAdmin.hta.estadia;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadiaRepository extends JpaRepository<Estadia, Long> {
	

}
