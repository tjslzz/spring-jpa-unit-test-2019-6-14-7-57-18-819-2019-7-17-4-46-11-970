package com.oocl.web.sampleWebApp.jpaSample.repository;

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
public class SingleEntityRepositoryTest {

    @Autowired
    private SingleEntityRepository singleEntityRepository;

    @Test
    @DirtiesContext
    public void should_be_able_to_create_and_fetch_entity(){
        SingleEntity singleEntity = new SingleEntity("jerryLi");
        singleEntityRepository.save(singleEntity);
        List<SingleEntity> result = (List<SingleEntity>) singleEntityRepository.findAll();
        assertEquals(1,result.size());
    }
}