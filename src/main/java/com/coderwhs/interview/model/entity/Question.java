package com.coderwhs.interview.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
 * @Author  whs
 * @Date  2024/10/3 12:32
 * @description:
*/

/**
 * 题目
 */
@ApiModel(description="题目")
@Data
@TableName(value = "question")
public class Question {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value="id")
    private Long id;

    /**
     * 标题
     */
    @TableField(value = "title")
    @ApiModelProperty(value="标题")
    private String title;

    /**
     * 内容
     */
    @TableField(value = "content")
    @ApiModelProperty(value="内容")
    private String content;

    /**
     * 标签列表（json 数组）
     */
    @TableField(value = "tags")
    @ApiModelProperty(value="标签列表（json 数组）")
    private String tags;

    /**
     * 推荐答案
     */
    @TableField(value = "answer")
    @ApiModelProperty(value="推荐答案")
    private String answer;

    /**
     * 创建用户 id
     */
    @TableField(value = "userId")
    @ApiModelProperty(value="创建用户 id")
    private Long userId;

    /**
     * 编辑时间
     */
    @TableField(value = "editTime")
    @ApiModelProperty(value="编辑时间")
    private Date editTime;

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

    /**
     * 是否删除
     */
    @TableField(value = "isDelete")
    @ApiModelProperty(value="是否删除")
    @TableLogic
    private Byte isDelete;
}
