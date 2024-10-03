package com.coderwhs.interview.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderwhs.interview.mapper.QuestionMapper;
import com.coderwhs.interview.model.entity.Question;
import com.coderwhs.interview.service.QuestionService;
/**
 * @Author  whs
 * @Date  2024/10/3 12:32
 * @description:
*/

@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService{

    @Override
    public int updateBatch(List<Question> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int updateBatchSelective(List<Question> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<Question> list) {
        return baseMapper.batchInsert(list);
    }
    @Override
    public int insertOrUpdate(Question record) {
        return baseMapper.insertOrUpdate(record);
    }
    @Override
    public int insertOrUpdateSelective(Question record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
