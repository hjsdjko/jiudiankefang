package com.entity.view;

import com.entity.FangjianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 房间表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @email
 * @date 2021-03-09
 */
@TableName("fangjian")
public class FangjianView extends FangjianEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public FangjianView() {

	}

	public FangjianView(FangjianEntity fangjianEntity) {
		try {
			BeanUtils.copyProperties(this, fangjianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
