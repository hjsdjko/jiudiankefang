package com.dao;

import com.entity.CaiwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.CaiwuView;

/**
 * 财务表 Dao 接口
 *
 * @since 2021-03-09
 */
public interface CaiwuDao extends BaseMapper<CaiwuEntity> {

   List<CaiwuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
