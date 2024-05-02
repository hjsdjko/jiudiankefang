package com.entity.vo;

import com.entity.FangjianEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 房间表
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @email
 * @date 2021-03-09
 */
@TableName("fangjian")
public class FangjianVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 房间编号 Search
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
     * 房间类型 Search
     */

    @TableField(value = "fjlx_types")
    private Integer fjlxTypes;


    /**
     * 房间价格 Search
     */

    @TableField(value = "money")
    private Double money;


    /**
     * 房屋状态 Search
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
