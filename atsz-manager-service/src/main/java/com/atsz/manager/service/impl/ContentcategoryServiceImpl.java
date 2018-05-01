package com.atsz.manager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.atsz.manager.pojo.Contentcategory;
import com.atsz.manager.service.ContentcategoryService;

@Service
public class ContentcategoryServiceImpl extends BaseServiceImpl<Contentcategory> implements ContentcategoryService {

	/**
	 * 根据id递归删除当前分类及子分类
	 */
	@Override
	public void deleteByPrimarykey(Contentcategory contentcategory) {
		
		List<Object> idslist = new ArrayList<Object>();
		idslist.add(contentcategory.getId());
		
		findAndAddIds(idslist,contentcategory.getId());
		
		this.deleteByIds(idslist);
	}

	private void findAndAddIds(List<Object> idslist, Long id) {
		//查询parentId是id的集合
		Contentcategory contentcategory = new Contentcategory();
		contentcategory.setParentid(id);
		
		List<Contentcategory> contentcategoryList = this.selectByExample(contentcategory);
		
		if (contentcategoryList != null) {
			for (Contentcategory contentcategory2 : contentcategoryList) {
				idslist.add(contentcategory2.getId());
				findAndAddIds(idslist, contentcategory2.getId());
			}
			
		}
		
	}

}
