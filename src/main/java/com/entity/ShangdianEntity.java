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
 * 酒店商店表
 *
 * @email
 * @date 2021-03-09
 */
@TableName("shangdian")
public class ShangdianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public ShangdianEntity() {

    }

    public ShangdianEntity(T t) {
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
     * 商品名称
     */
    @TableField(value = "name")

    private String name;


    /**
     * 商品价格
     */
    @TableField(value = "money")

    private Double money;


    /**
     * 商品图片
     */
    @TableField(value = "img_photo")

    private String imgPhoto;


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
	 * 设置：商品名称
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：商品名称
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：商品价格
	 */
    public Double getMoney() {
        return money;
    }


    /**
	 * 获取：商品价格
	 */

    public void setMoney(Double money) {
        this.money = money;
    }
    /**
	 * 设置：商品图片
	 */
    public String getImgPhoto() {
        return imgPhoto;
    }


    /**
	 * 获取：商品图片
	 */

    public void setImgPhoto(String imgPhoto) {
        this.imgPhoto = imgPhoto;
    }

    @Override
    public String toString() {
    return "Shangdian{" +
            "id=" + id +
            ", name=" + name +
            ", money=" + money +
            ", imgPhoto=" + imgPhoto +
    "}";
    }
    }
