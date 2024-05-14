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


import com.dao.MingshiDao;
import com.entity.MingshiEntity;
import com.service.MingshiService;
import com.entity.vo.MingshiVO;
import com.entity.view.MingshiView;

@Service("mingshiService")
public class MingshiServiceImpl extends ServiceImpl<MingshiDao, MingshiEntity> implements MingshiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MingshiEntity> page = this.selectPage(
                new Query<MingshiEntity>(params).getPage(),
                new EntityWrapper<MingshiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MingshiEntity> wrapper) {
		  Page<MingshiView> page =new Query<MingshiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<MingshiVO> selectListVO(Wrapper<MingshiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MingshiVO selectVO(Wrapper<MingshiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MingshiView> selectListView(Wrapper<MingshiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MingshiView selectView(Wrapper<MingshiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
