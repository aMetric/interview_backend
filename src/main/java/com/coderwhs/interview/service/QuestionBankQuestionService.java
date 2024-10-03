package com.coderwhs.interview.service;

import java.util.List;
import com.coderwhs.interview.model.entity.QuestionBankQuestion;
import com.baomidou.mybatisplus.extension.service.IService;
    /**
 * @Author  whs
 * @Date  2024/10/3 12:33
 * @description: 
*/

public interface QuestionBankQuestionService extends IService<QuestionBankQuestion>{


    int updateBatch(List<QuestionBankQuestion> list);

    int updateBatchSelective(List<QuestionBankQuestion> list);

    int batchInsert(List<QuestionBankQuestion> list);

    int insertOrUpdate(QuestionBankQuestion record);

    int insertOrUpdateSelective(QuestionBankQuestion record);

}
