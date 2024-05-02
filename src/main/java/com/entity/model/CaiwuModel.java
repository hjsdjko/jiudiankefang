package com.entity.model;

import com.entity.CaiwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 财务表
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @email
 * @date 2021-03-09
 */
public class CaiwuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 消费人
     */
    private Integer yhTypes;


    /**
     * 用途 Search
     */
    private String purpose;


    /**
     * 花费金额
     */
    private Double maxMoney;


    /**
     * 花费时间 Search
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
