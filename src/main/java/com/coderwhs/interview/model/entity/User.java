package com.coderwhs.interview.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @Author  whs
 * @Date  2024/10/3 12:30
 * @description:
*/

/**
 * 用户
 */
@Data
@TableName(value = "`user`")
public class User implements Serializable {
  @TableField(exist = false)
  private static final long serialVersionUID = 1L;
  /**
   * id
   */
  @TableId(value = "id", type = IdType.ASSIGN_ID)
  private Long id;

  /**
   * 账号
   */
  @TableField(value = "userAccount")
  private String userAccount;

  /**
   * 密码
   */
  @TableField(value = "userPassword")
  private String userPassword;

  /**
   * 微信开放平台id
   */
  @TableField(value = "unionId")
  private String unionId;

  /**
   * 公众号openId
   */
  @TableField(value = "mpOpenId")
  private String mpOpenId;

  /**
   * 用户昵称
   */
  @TableField(value = "userName")
  private String userName;

  /**
   * 用户头像
   */
  @TableField(value = "userAvatar")
  private String userAvatar;

  /**
   * 用户简介
   */
  @TableField(value = "userProfile")
  private String userProfile;

  /**
   * 用户角色：user/admin/ban
   */
  @TableField(value = "userRole")
  private String userRole;

  /**
   * 编辑时间
   */
  @TableField(value = "editTime")
  private Date editTime;

  /**
   * 创建时间
   */
  @TableField(value = "createTime")
  private Date createTime;

  /**
   * 更新时间
   */
  @TableField(value = "updateTime")
  private Date updateTime;

  /**
   * 是否删除
   */
  @TableField(value = "isDelete")
  @TableLogic
  private Byte isDelete;
}
