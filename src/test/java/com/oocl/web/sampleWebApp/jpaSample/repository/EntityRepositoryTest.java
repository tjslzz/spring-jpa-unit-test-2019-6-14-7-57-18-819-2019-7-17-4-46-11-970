package com.oocl.web.sampleWebApp.jpaSample.repository;

import com.oocl.web.sampleWebApp.jpaSample.entity.RelatedEntity;
import com.oocl.web.sampleWebApp.jpaSample.entity.SingleEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EntityRepositoryTest {

    @Autowired
    private SingleEntityRepository singleEntityRepository;
    @Autowired
    private RelatedEntityRepository relatedEntityRepository;

    @Test
    @DirtiesContext
    public void should_be_able_to_create_and_fetch_entity(){
        SingleEntity singleEntity = new SingleEntity("jerryLi");
        singleEntityRepository.save(singleEntity);
        List<SingleEntity> result = (List<SingleEntity>) singleEntityRepository.findAll();
        assertEquals(1,result.size());
    }

    @Test
    @DirtiesContext
    public void should_be_able_to_return_exception(){
        SingleEntity singleEntity = new SingleEntity("jerryLijerryLijerryLijerryLijerryLijerryLijerryLijerryLijerryLijerryLijerryLijerryLi");
        singleEntityRepository.save(singleEntity);
        assertThrows(Exception.class,()->singleEntityRepository.findAll());

    }


    @Test
    @DirtiesContext
    public void should_be_able_to_handle_one_to_one_relationship(){
        SingleEntity singleEntity = new SingleEntity("jerryLi");
        singleEntityRepository.save(singleEntity);
        RelatedEntity relatedEntity = new RelatedEntity("felicity",singleEntity);
        relatedEntityRepository.save(relatedEntity);

        List<RelatedEntity> result = (List<RelatedEntity>) relatedEntityRepository.findAll();
        assertEquals(1,result.size());
        assertEquals(singleEntity.getName(),result.get(0).getSingleEntity().getName());
    }
}