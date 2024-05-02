package com.entity.model;

import com.entity.ShangdianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 酒店商店表
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @email
 * @date 2021-03-09
 */
public class ShangdianModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 商品名称 Search
     */
    private String name;


    /**
     * 商品价格
     */
    private Double money;


    /**
     * 商品图片
     */
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
	 * 设置：商品名称 Search
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：商品名称 Search
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

    }
