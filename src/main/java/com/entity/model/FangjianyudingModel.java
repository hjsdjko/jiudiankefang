package com.entity.model;

import com.entity.FangjianyudingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 房间预定表
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @email
 * @date 2021-03-09
 */
public class FangjianyudingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 预定房间
     */
    private Integer fjTypes;


    /**
     * 预定人
     */
    private Integer yhTypes;


    /**
     * 是否到达
     */
    private Integer sfddTypes;


    /**
     * 预定时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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

    }
