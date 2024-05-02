package com.entity.vo;

import com.entity.ZhusuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 住宿表
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @email
 * @date 2021-03-09
 */
@TableName("zhusu")
public class ZhusuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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


    /**
     * 住宿开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "initiate_time")
    private Date initiateTime;


    /**
     * 住宿结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "finish_time")
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
