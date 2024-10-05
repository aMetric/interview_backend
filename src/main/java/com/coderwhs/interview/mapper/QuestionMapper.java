package com.coderwhs.interview.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coderwhs.interview.model.entity.Question;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author  whs
 * @Date  2024/10/3 12:32
 * @description:
*/

public interface QuestionMapper extends BaseMapper<Question> {
    int updateBatch(List<Question> list);

    int updateBatchSelective(List<Question> list);

    int batchInsert(@Param("list") List<Question> list);

    int insertOrUpdate(Question record);

    int insertOrUpdateSelective(Question record);

    /**
     * 查询被逻辑删除的数据
     * @param fiveMinutesAgoDate
     * @return
     */
    List<Question> listQuestionWithDelete(Date fiveMinutesAgoDate);
}
