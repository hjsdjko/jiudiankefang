package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.ShangdianDao;
import com.entity.ShangdianEntity;
import com.service.ShangdianService;
import com.entity.view.ShangdianView;

/**
 * 酒店商店表 服务实现类
 * @since 2021-03-09
 */
@Service("shangdianService")
@Transactional
public class ShangdianServiceImpl extends ServiceImpl<ShangdianDao, ShangdianEntity> implements ShangdianService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ShangdianView> page =new Query<ShangdianView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
