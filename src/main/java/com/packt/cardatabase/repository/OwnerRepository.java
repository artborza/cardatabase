package com.packt.cardatabase.repository;

import org.springframework.data.repository.CrudRepository;

import com.packt.cardatabase.domain.Owner;

public interface OwnerRepository  extends CrudRepository <Owner, Long> {

}
