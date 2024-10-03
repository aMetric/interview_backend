package com.coderwhs.interview.service;

import com.coderwhs.interview.model.entity.QuestionBank;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
    /**
 * @Author  whs
 * @Date  2024/10/3 12:33
 * @description: 
*/

public interface QuestionBankService extends IService<QuestionBank>{


    int updateBatch(List<QuestionBank> list);

    int updateBatchSelective(List<QuestionBank> list);

    int batchInsert(List<QuestionBank> list);

    int insertOrUpdate(QuestionBank record);

    int insertOrUpdateSelective(QuestionBank record);

}
