package com.entity.model;

import com.entity.FangjianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 房间表
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @email
 * @date 2021-03-09
 */
public class FangjianModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 房间编号 Search
     */
    private String name;


    /**
     * 房间图片
     */
    private String imgPhoto;


    /**
     * 房间位置
     */
    private String thewhere;


    /**
     * 房间类型 Search
     */
    private Integer fjlxTypes;


    /**
     * 房间价格 Search
     */
    private Double money;


    /**
     * 房屋状态 Search
     */
    private Integer fjztTypes;


    /**
     * 房间详情
     */
    private String fangjianContent;


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
	 * 设置：房间编号 Search
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：房间编号 Search
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：房间图片
	 */
    public String getImgPhoto() {
        return imgPhoto;
    }


    /**
	 * 获取：房间图片
	 */

    public void setImgPhoto(String imgPhoto) {
        this.imgPhoto = imgPhoto;
    }
    /**
	 * 设置：房间位置
	 */
    public String getThewhere() {
        return thewhere;
    }


    /**
	 * 获取：房间位置
	 */

    public void setThewhere(String thewhere) {
        this.thewhere = thewhere;
    }
    /**
	 * 设置：房间类型 Search
	 */
    public Integer getFjlxTypes() {
        return fjlxTypes;
    }


    /**
	 * 获取：房间类型 Search
	 */

    public void setFjlxTypes(Integer fjlxTypes) {
        this.fjlxTypes = fjlxTypes;
    }
    /**
	 * 设置：房间价格 Search
	 */
    public Double getMoney() {
        return money;
    }


    /**
	 * 获取：房间价格 Search
	 */

    public void setMoney(Double money) {
        this.money = money;
    }
    /**
	 * 设置：房屋状态 Search
	 */
    public Integer getFjztTypes() {
        return fjztTypes;
    }


    /**
	 * 获取：房屋状态 Search
	 */

    public void setFjztTypes(Integer fjztTypes) {
        this.fjztTypes = fjztTypes;
    }
    /**
	 * 设置：房间详情
	 */
    public String getFangjianContent() {
        return fangjianContent;
    }


    /**
	 * 获取：房间详情
	 */

    public void setFangjianContent(String fangjianContent) {
        this.fangjianContent = fangjianContent;
    }

    }
