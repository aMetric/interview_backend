package com.coderwhs.interview.service;

import java.util.List;
import com.coderwhs.interview.model.entity.Question;
import com.baomidou.mybatisplus.extension.service.IService;
    /**
 * @Author  whs
 * @Date  2024/10/3 12:32
 * @description: 
*/

public interface QuestionService extends IService<Question>{


    int updateBatch(List<Question> list);

    int updateBatchSelective(List<Question> list);

    int batchInsert(List<Question> list);

    int insertOrUpdate(Question record);

    int insertOrUpdateSelective(Question record);

}
