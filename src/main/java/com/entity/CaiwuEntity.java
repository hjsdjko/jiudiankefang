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
 * 财务表
 *
 * @email
 * @date 2021-03-09
 */
@TableName("caiwu")
public class CaiwuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public CaiwuEntity() {

    }

    public CaiwuEntity(T t) {
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
     * 消费人
     */
    @TableField(value = "yh_types")

    private Integer yhTypes;


    /**
     * 用途
     */
    @TableField(value = "purpose")

    private String purpose;


    /**
     * 花费金额
     */
    @TableField(value = "maxMoney")

    private Double maxMoney;


    /**
     * 花费时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "expenditure_time",fill = FieldFill.UPDATE)

    private Date expenditureTime;


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
	 * 设置：消费人
	 */
    public Integer getYhTypes() {
        return yhTypes;
    }


    /**
	 * 获取：消费人
	 */

    public void setYhTypes(Integer yhTypes) {
        this.yhTypes = yhTypes;
    }
    /**
	 * 设置：用途
	 */
    public String getPurpose() {
        return purpose;
    }


    /**
	 * 获取：用途
	 */

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
    /**
	 * 设置：花费金额
	 */
    public Double getMaxMoney() {
        return maxMoney;
    }


    /**
	 * 获取：花费金额
	 */

    public void setMaxMoney(Double maxMoney) {
        this.maxMoney = maxMoney;
    }
    /**
	 * 设置：花费时间
	 */
    public Date getExpenditureTime() {
        return expenditureTime;
    }


    /**
	 * 获取：花费时间
	 */

    public void setExpenditureTime(Date expenditureTime) {
        this.expenditureTime = expenditureTime;
    }

    @Override
    public String toString() {
    return "Caiwu{" +
            "id=" + id +
            ", yhTypes=" + yhTypes +
            ", purpose=" + purpose +
            ", maxMoney=" + maxMoney +
            ", expenditureTime=" + expenditureTime +
    "}";
    }
    }
