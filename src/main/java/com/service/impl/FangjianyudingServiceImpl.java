package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.FangjianyudingDao;
import com.entity.FangjianyudingEntity;
import com.service.FangjianyudingService;
import com.entity.view.FangjianyudingView;

/**
 * 房间预定表 服务实现类
 * @since 2021-03-09
 */
@Service("fangjianyudingService")
@Transactional
public class FangjianyudingServiceImpl extends ServiceImpl<FangjianyudingDao, FangjianyudingEntity> implements FangjianyudingService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<FangjianyudingView> page =new Query<FangjianyudingView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
