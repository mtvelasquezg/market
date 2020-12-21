package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompraCurdRepository extends CrudRepository<Compra, Integer> {

    public Optional<List<Compra>> findByIdCliente(String idCliente);

}
