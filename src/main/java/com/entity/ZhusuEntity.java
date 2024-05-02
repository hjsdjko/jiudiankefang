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
 * 住宿表
 *
 * @email
 * @date 2021-03-09
 */
@TableName("zhusu")
public class ZhusuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public ZhusuEntity() {

    }

    public ZhusuEntity(T t) {
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
     * 住宿房间编号
     */
    @TableField(value = "fj_types")

    private Integer fjTypes;


    /**
     * 住宿人
     */
    @TableField(value = "yh_types")

    private Integer yhTypes;
    @TableField(value = "zhuangt")

    private Integer zhuangt;

    public Integer getZhuangt() {
        return zhuangt;
    }

    public void setZhuangt(Integer zhuangt) {
        this.zhuangt = zhuangt;
    }

    /**
     * 住宿开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "initiate_time",fill = FieldFill.UPDATE)

    private Date initiateTime;


    /**
     * 住宿结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "finish_time",fill = FieldFill.UPDATE)

    private Date finishTime;


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
	 * 设置：住宿房间编号
	 */
    public Integer getFjTypes() {
        return fjTypes;
    }


    /**
	 * 获取：住宿房间编号
	 */

    public void setFjTypes(Integer fjTypes) {
        this.fjTypes = fjTypes;
    }
    /**
	 * 设置：住宿人
	 */
    public Integer getYhTypes() {
        return yhTypes;
    }


    /**
	 * 获取：住宿人
	 */

    public void setYhTypes(Integer yhTypes) {
        this.yhTypes = yhTypes;
    }
    /**
	 * 设置：住宿开始时间
	 */
    public Date getInitiateTime() {
        return initiateTime;
    }


    /**
	 * 获取：住宿开始时间
	 */

    public void setInitiateTime(Date initiateTime) {
        this.initiateTime = initiateTime;
    }
    /**
	 * 设置：住宿结束时间
	 */
    public Date getFinishTime() {
        return finishTime;
    }


    /**
	 * 获取：住宿结束时间
	 */

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    @Override
    public String toString() {
    return "Zhusu{" +
            "id=" + id +
            ", fjTypes=" + fjTypes +
            ", yhTypes=" + yhTypes +
            ", initiateTime=" + initiateTime +
            ", finishTime=" + finishTime +
    "}";
    }
    }
