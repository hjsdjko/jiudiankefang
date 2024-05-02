package com.entity.model;

import com.entity.ZhusuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 住宿表
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @email
 * @date 2021-03-09
 */
public class ZhusuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 住宿房间编号
     */
    private Integer fjTypes;


    /**
     * 住宿人
     */
    private Integer yhTypes;


    /**
     * 住宿开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date initiateTime;


    /**
     * 住宿结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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

    }
