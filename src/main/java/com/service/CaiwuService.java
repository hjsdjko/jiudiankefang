package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CaiwuEntity;
import java.util.Map;

/**
 * 财务表 服务类
 * @since 2021-03-09
 */
public interface CaiwuService extends IService<CaiwuEntity> {

     PageUtils queryPage(Map<String, Object> params);

}