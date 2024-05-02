package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 房间预定表
 *
 * @email
 * @date 2021-03-09
 */
@TableName("fangjianyuding")
public class FangjianyudingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public FangjianyudingEntity() {

    }

    public FangjianyudingEntity(T t) {
    try {
    BeanUtils.copyProperties(this, t);
    } catch (IllegalAccessException | InvocationTargetException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    }
    }


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 预定房间
     */
    @TableField(value = "fj_types")

    private Integer fjTypes;


    /**
     * 预定人
     */
    @TableField(value = "yh_types")

    private Integer yhTypes;


    /**
     * 是否到达
     */
    @TableField(value = "sfdd_types")

    private Integer sfddTypes;


    /**
     * 预定时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：预定房间
	 */
    public Integer getFjTypes() {
        return fjTypes;
    }


    /**
	 * 获取：预定房间
	 */

    public void setFjTypes(Integer fjTypes) {
        this.fjTypes = fjTypes;
    }
    /**
	 * 设置：预定人
	 */
    public Integer getYhTypes() {
        return yhTypes;
    }


    /**
	 * 获取：预定人
	 */

    public void setYhTypes(Integer yhTypes) {
        this.yhTypes = yhTypes;
    }
    /**
	 * 设置：是否到达
	 */
    public Integer getSfddTypes() {
        return sfddTypes;
    }


    /**
	 * 获取：是否到达
	 */

    public void setSfddTypes(Integer sfddTypes) {
        this.sfddTypes = sfddTypes;
    }
    /**
	 * 设置：预定时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：预定时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
    return "Fangjianyuding{" +
            "id=" + id +
            ", fjTypes=" + fjTypes +
            ", yhTypes=" + yhTypes +
            ", sfddTypes=" + sfddTypes +
            ", createTime=" + createTime +
    "}";
    }
    }
