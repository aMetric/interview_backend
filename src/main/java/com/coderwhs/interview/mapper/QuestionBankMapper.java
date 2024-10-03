package com.coderwhs.interview.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coderwhs.interview.model.entity.QuestionBank;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author  whs
 * @Date  2024/10/3 12:33
 * @description:
*/

public interface QuestionBankMapper extends BaseMapper<QuestionBank> {
    int updateBatch(List<QuestionBank> list);

    int updateBatchSelective(List<QuestionBank> list);

    int batchInsert(@Param("list") List<QuestionBank> list);

    int insertOrUpdate(QuestionBank record);

    int insertOrUpdateSelective(QuestionBank record);
}
