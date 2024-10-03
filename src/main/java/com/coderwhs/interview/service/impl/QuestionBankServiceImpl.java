package com.coderwhs.interview.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coderwhs.interview.model.entity.QuestionBank;
import com.coderwhs.interview.mapper.QuestionBankMapper;
import com.coderwhs.interview.service.QuestionBankService;
/**
 * @Author  whs
 * @Date  2024/10/3 12:33
 * @description:
*/

@Service
public class QuestionBankServiceImpl extends ServiceImpl<QuestionBankMapper, QuestionBank> implements QuestionBankService{

    @Override
    public int updateBatch(List<QuestionBank> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int updateBatchSelective(List<QuestionBank> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<QuestionBank> list) {
        return baseMapper.batchInsert(list);
    }
    @Override
    public int insertOrUpdate(QuestionBank record) {
        return baseMapper.insertOrUpdate(record);
    }
    @Override
    public int insertOrUpdateSelective(QuestionBank record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
