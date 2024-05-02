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
 * 房间表
 *
 * @email
 * @date 2021-03-09
 */
@TableName("fangjian")
public class FangjianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public FangjianEntity() {

    }

    public FangjianEntity(T t) {
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
     * 房间编号
     */
    @TableField(value = "name")

    private String name;


    /**
     * 房间图片
     */
    @TableField(value = "img_photo")

    private String imgPhoto;


    /**
     * 房间位置
     */
    @TableField(value = "thewhere")

    private String thewhere;


    /**
     * 房间类型
     */
    @TableField(value = "fjlx_types")

    private Integer fjlxTypes;


    /**
     * 房间价格
     */
    @TableField(value = "money")

    private Double money;


    /**
     * 房屋状态
     */
    @TableField(value = "fjzt_types")

    private Integer fjztTypes;


    /**
     * 房间详情
     */
    @TableField(value = "fangjian_content")

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
	 * 设置：房间编号
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：房间编号
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
	 * 设置：房间类型
	 */
    public Integer getFjlxTypes() {
        return fjlxTypes;
    }


    /**
	 * 获取：房间类型
	 */

    public void setFjlxTypes(Integer fjlxTypes) {
        this.fjlxTypes = fjlxTypes;
    }
    /**
	 * 设置：房间价格
	 */
    public Double getMoney() {
        return money;
    }


    /**
	 * 获取：房间价格
	 */

    public void setMoney(Double money) {
        this.money = money;
    }
    /**
	 * 设置：房屋状态
	 */
    public Integer getFjztTypes() {
        return fjztTypes;
    }


    /**
	 * 获取：房屋状态
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

    @Override
    public String toString() {
    return "Fangjian{" +
            "id=" + id +
            ", name=" + name +
            ", imgPhoto=" + imgPhoto +
            ", thewhere=" + thewhere +
            ", fjlxTypes=" + fjlxTypes +
            ", money=" + money +
            ", fjztTypes=" + fjztTypes +
            ", fangjianContent=" + fangjianContent +
    "}";
    }
    }
