package com.coderwhs.interview.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
 * @Author  whs
 * @Date  2024/10/3 12:33
 * @description:
*/

/**
 * 题库题目
 */
@ApiModel(description="题库题目")
@Data
@TableName(value = "question_bank_question")
public class QuestionBankQuestion {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value="id")
    private Long id;

    /**
     * 题库 id
     */
    @TableField(value = "questionBankId")
    @ApiModelProperty(value="题库 id")
    private Long questionBankId;

    /**
     * 题目 id
     */
    @TableField(value = "questionId")
    @ApiModelProperty(value="题目 id")
    private Long questionId;

    /**
     * 创建用户 id
     */
    @TableField(value = "userId")
    @ApiModelProperty(value="创建用户 id")
    private Long userId;

    /**
     * 创建时间
     */
    @TableField(value = "createTime")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "updateTime")
    @ApiModelProperty(value="更新时间")
    private Date updateTime;
}
