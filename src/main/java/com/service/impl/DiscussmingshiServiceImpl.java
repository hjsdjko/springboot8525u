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


import com.dao.DiscussmingshiDao;
import com.entity.DiscussmingshiEntity;
import com.service.DiscussmingshiService;
import com.entity.vo.DiscussmingshiVO;
import com.entity.view.DiscussmingshiView;

@Service("discussmingshiService")
public class DiscussmingshiServiceImpl extends ServiceImpl<DiscussmingshiDao, DiscussmingshiEntity> implements DiscussmingshiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussmingshiEntity> page = this.selectPage(
                new Query<DiscussmingshiEntity>(params).getPage(),
                new EntityWrapper<DiscussmingshiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussmingshiEntity> wrapper) {
		  Page<DiscussmingshiView> page =new Query<DiscussmingshiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussmingshiVO> selectListVO(Wrapper<DiscussmingshiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussmingshiVO selectVO(Wrapper<DiscussmingshiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussmingshiView> selectListView(Wrapper<DiscussmingshiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussmingshiView selectView(Wrapper<DiscussmingshiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
