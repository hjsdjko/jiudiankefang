package com.dao;

import com.entity.FangjianyudingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FangjianyudingView;

/**
 * 房间预定表 Dao 接口
 *
 * @since 2021-03-09
 */
public interface FangjianyudingDao extends BaseMapper<FangjianyudingEntity> {

   List<FangjianyudingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
