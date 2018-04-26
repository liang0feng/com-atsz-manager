package com.atsz.manager.service;

import java.util.List;

public interface BaseService<T> {

	//查询单个
	public T selectOne(T t);
	
	//查询所有
	public List<T> selectAll();
	
	//按条件查，返回List
	public List<T> selectByExample(T t);
	
	//按id查询
	public T selectById(Long id);
	
	//分页查询
	public List<T> selectByPage(Integer pageNum, Integer pageSize,T t);
	
	//查数量
	public Integer count(T t);
	
	//新增
	public void insert(T t);
	
	//有选择的新增
	public void insertSelective(T t);
	
	//根据id删除
	public void deleteById(Long id);
	
	//根据ids批量删除
	public void deleteByIds(List<Object> ids);
	
	//更新
	public void updateById(T t);
	
	//有选择的更新
	public void updateByIdSelective(T t);
}
