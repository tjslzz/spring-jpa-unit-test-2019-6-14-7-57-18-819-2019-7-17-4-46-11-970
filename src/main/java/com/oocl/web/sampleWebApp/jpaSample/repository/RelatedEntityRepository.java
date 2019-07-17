package com.oocl.web.sampleWebApp.jpaSample.repository;

import com.oocl.web.sampleWebApp.jpaSample.entity.RelatedEntity;
import org.springframework.data.repository.CrudRepository;

public interface RelatedEntityRepository extends CrudRepository<RelatedEntity,Long> {
}
