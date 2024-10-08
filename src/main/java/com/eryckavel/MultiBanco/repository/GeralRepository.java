package com.eryckavel.MultiBanco.repository;

import com.eryckavel.MultiBanco.model.Geral;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface GeralRepository extends JpaRepository<Geral, Long> {

    @Override
    List<Geral> findAll();

}