package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShangdianEntity;
import java.util.Map;

/**
 * 酒店商店表 服务类
 * @since 2021-03-09
 */
public interface ShangdianService extends IService<ShangdianEntity> {

     PageUtils queryPage(Map<String, Object> params);

}