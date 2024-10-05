package com.coderwhs.interview.esdao;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author whs
 * @Date 2024/10/5 10:54
 * @description:
 */
@SpringBootTest
class QuestionEsDaoTest {

  @Resource
  private QuestionEsDao questionEsDao;

  @Test
  void findByUserId(){
    questionEsDao.findByUserId(1L);
  }

}
