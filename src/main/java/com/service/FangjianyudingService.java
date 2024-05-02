package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FangjianyudingEntity;
import java.util.Map;

/**
 * 房间预定表 服务类
 * @since 2021-03-09
 */
public interface FangjianyudingService extends IService<FangjianyudingEntity> {

     PageUtils queryPage(Map<String, Object> params);

}