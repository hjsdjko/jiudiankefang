package com.entity.view;

import com.entity.ZhusuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 住宿表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @email
 * @date 2021-03-09
 */
@TableName("zhusu")
public class ZhusuView extends ZhusuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public ZhusuView() {

	}

	public ZhusuView(ZhusuEntity zhusuEntity) {
		try {
			BeanUtils.copyProperties(this, zhusuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
