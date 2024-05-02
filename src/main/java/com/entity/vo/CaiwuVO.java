package com.entity.vo;

import com.entity.CaiwuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 财务表
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @email
 * @date 2021-03-09
 */
@TableName("caiwu")
public class CaiwuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 消费人
     */

    @TableField(value = "yh_types")
    private Integer yhTypes;


    /**
     * 用途 Search
     */

    @TableField(value = "purpose")
    private String purpose;


    /**
     * 花费金额
     */

    @TableField(value = "maxMoney")
    private Double maxMoney;


    /**
     * 花费时间 Search
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "expenditure_time")
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
	 * 设置：用途 Search
	 */
    public String getPurpose() {
        return purpose;
    }


    /**
	 * 获取：用途 Search
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
	 * 设置：花费时间 Search
	 */
    public Date getExpenditureTime() {
        return expenditureTime;
    }


    /**
	 * 获取：花费时间 Search
	 */

    public void setExpenditureTime(Date expenditureTime) {
        this.expenditureTime = expenditureTime;
    }

}
