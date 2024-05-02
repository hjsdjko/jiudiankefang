package com.entity.view;

import com.entity.ShangdianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 酒店商店表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @email
 * @date 2021-03-09
 */
@TableName("shangdian")
public class ShangdianView extends ShangdianEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public ShangdianView() {

	}

	public ShangdianView(ShangdianEntity shangdianEntity) {
		try {
			BeanUtils.copyProperties(this, shangdianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
