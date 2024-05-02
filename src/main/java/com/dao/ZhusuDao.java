package com.dao;

import com.entity.ZhusuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhusuView;

/**
 * 住宿表 Dao 接口
 *
 * @since 2021-03-09
 */
public interface ZhusuDao extends BaseMapper<ZhusuEntity> {

   List<ZhusuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
