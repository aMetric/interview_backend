package com.coderwhs.interview.model.entity;

import com.baomidou.mybatisplus.annotation.*;
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
 * 题库
 */
@ApiModel(description="题库")
@Data
@TableName(value = "question_bank")
public class QuestionBank {
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
     * 描述
     */
    @TableField(value = "description")
    @ApiModelProperty(value="描述")
    private String description;

    /**
     * 图片
     */
    @TableField(value = "picture")
    @ApiModelProperty(value="图片")
    private String picture;

    /**
     * 创建用户 id
     */
    @TableField(value = "userId")
    @ApiModelProperty(value="创建用户 id")
    private Long userid;

    /**
     * 编辑时间
     */
    @TableField(value = "editTime")
    @ApiModelProperty(value="编辑时间")
    private Date edittime;

    /**
     * 创建时间
     */
    @TableField(value = "createTime")
    @ApiModelProperty(value="创建时间")
    private Date createtime;

    /**
     * 更新时间
     */
    @TableField(value = "updateTime")
    @ApiModelProperty(value="更新时间")
    private Date updatetime;

    /**
     * 是否删除
     */
    @TableField(value = "isDelete")
    @ApiModelProperty(value="是否删除")
    @TableLogic
    private Byte isdelete;
}
