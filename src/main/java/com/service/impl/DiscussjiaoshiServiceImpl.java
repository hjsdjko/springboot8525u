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


import com.dao.DiscussjiaoshiDao;
import com.entity.DiscussjiaoshiEntity;
import com.service.DiscussjiaoshiService;
import com.entity.vo.DiscussjiaoshiVO;
import com.entity.view.DiscussjiaoshiView;

@Service("discussjiaoshiService")
public class DiscussjiaoshiServiceImpl extends ServiceImpl<DiscussjiaoshiDao, DiscussjiaoshiEntity> implements DiscussjiaoshiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussjiaoshiEntity> page = this.selectPage(
                new Query<DiscussjiaoshiEntity>(params).getPage(),
                new EntityWrapper<DiscussjiaoshiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussjiaoshiEntity> wrapper) {
		  Page<DiscussjiaoshiView> page =new Query<DiscussjiaoshiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussjiaoshiVO> selectListVO(Wrapper<DiscussjiaoshiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussjiaoshiVO selectVO(Wrapper<DiscussjiaoshiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussjiaoshiView> selectListView(Wrapper<DiscussjiaoshiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussjiaoshiView selectView(Wrapper<DiscussjiaoshiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
