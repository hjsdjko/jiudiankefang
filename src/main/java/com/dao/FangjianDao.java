package com.dao;

import com.entity.FangjianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FangjianView;

/**
 * 房间表 Dao 接口
 *
 * @since 2021-03-09
 */
public interface FangjianDao extends BaseMapper<FangjianEntity> {

   List<FangjianView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
