package com.coderwhs.interview.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coderwhs.interview.model.entity.QuestionBankQuestion;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author  whs
 * @Date  2024/10/3 12:33
 * @description:
*/

public interface QuestionBankQuestionMapper extends BaseMapper<QuestionBankQuestion> {
    int updateBatch(List<QuestionBankQuestion> list);

    int updateBatchSelective(List<QuestionBankQuestion> list);

    int batchInsert(@Param("list") List<QuestionBankQuestion> list);

    int insertOrUpdate(QuestionBankQuestion record);

    int insertOrUpdateSelective(QuestionBankQuestion record);
}
