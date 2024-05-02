package com.entity.vo;

import com.entity.ShangdianEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 酒店商店表
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @email
 * @date 2021-03-09
 */
@TableName("shangdian")
public class ShangdianVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 商品名称 Search
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
