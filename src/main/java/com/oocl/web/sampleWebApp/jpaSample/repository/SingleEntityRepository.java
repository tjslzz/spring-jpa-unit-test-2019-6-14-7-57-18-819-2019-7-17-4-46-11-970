package com.oocl.web.sampleWebApp.jpaSample.repository;

import com.oocl.web.sampleWebApp.jpaSample.entity.SingleEntity;
import org.springframework.data.repository.CrudRepository;

public interface SingleEntityRepository extends CrudRepository<SingleEntity,Long> {
}
