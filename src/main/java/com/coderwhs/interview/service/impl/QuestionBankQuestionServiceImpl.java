package com.coderwhs.interview.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderwhs.interview.model.entity.QuestionBankQuestion;
import com.coderwhs.interview.mapper.QuestionBankQuestionMapper;
import com.coderwhs.interview.service.QuestionBankQuestionService;
/**
 * @Author  whs
 * @Date  2024/10/3 12:33
 * @description:
*/

@Service
public class QuestionBankQuestionServiceImpl extends ServiceImpl<QuestionBankQuestionMapper, QuestionBankQuestion> implements QuestionBankQuestionService{

    @Override
    public int updateBatch(List<QuestionBankQuestion> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int updateBatchSelective(List<QuestionBankQuestion> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<QuestionBankQuestion> list) {
        return baseMapper.batchInsert(list);
    }
    @Override
    public int insertOrUpdate(QuestionBankQuestion record) {
        return baseMapper.insertOrUpdate(record);
    }
    @Override
    public int insertOrUpdateSelective(QuestionBankQuestion record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
