package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.FangjianDao;
import com.entity.FangjianEntity;
import com.service.FangjianService;
import com.entity.view.FangjianView;

/**
 * 房间表 服务实现类
 * @since 2021-03-09
 */
@Service("fangjianService")
@Transactional
public class FangjianServiceImpl extends ServiceImpl<FangjianDao, FangjianEntity> implements FangjianService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<FangjianView> page =new Query<FangjianView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
