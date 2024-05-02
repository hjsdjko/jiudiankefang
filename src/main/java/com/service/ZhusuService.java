package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhusuEntity;
import java.util.Map;

/**
 * 住宿表 服务类
 * @since 2021-03-09
 */
public interface ZhusuService extends IService<ZhusuEntity> {

     PageUtils queryPage(Map<String, Object> params);

}