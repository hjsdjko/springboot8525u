package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.KechengguanliyuanDao;
import com.entity.KechengguanliyuanEntity;
import com.service.KechengguanliyuanService;
import com.entity.vo.KechengguanliyuanVO;
import com.entity.view.KechengguanliyuanView;

@Service("kechengguanliyuanService")
public class KechengguanliyuanServiceImpl extends ServiceImpl<KechengguanliyuanDao, KechengguanliyuanEntity> implements KechengguanliyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KechengguanliyuanEntity> page = this.selectPage(
                new Query<KechengguanliyuanEntity>(params).getPage(),
                new EntityWrapper<KechengguanliyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KechengguanliyuanEntity> wrapper) {
		  Page<KechengguanliyuanView> page =new Query<KechengguanliyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KechengguanliyuanVO> selectListVO(Wrapper<KechengguanliyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KechengguanliyuanVO selectVO(Wrapper<KechengguanliyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KechengguanliyuanView> selectListView(Wrapper<KechengguanliyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KechengguanliyuanView selectView(Wrapper<KechengguanliyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
