package com.atsz.manager.service.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.lang.model.element.Parameterizable;

import org.springframework.beans.factory.annotation.Autowired;

import com.atsz.manager.mapper.CategoryMapper;
import com.atsz.manager.service.BaseService;
import com.github.abel533.entity.Example;
import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageHelper;

public class BaseServiceImpl<T> implements BaseService<T> {
	
	@Autowired
	private Mapper<T> mapper;
	
	Class<T> clazz;
	
	/**
	 * 构造器用来获取泛型类型
	 */
	public BaseServiceImpl() {
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
		this.clazz = (Class<T>) actualTypeArguments[0];
	}



	@Override
	public T selectOne(T t) {
		return mapper.selectOne(t);
	}

	@Override
	public List<T> selectAll() {
		return mapper.select(null);
	}

	@Override
	public List<T> selectByExample(T t) {
		return mapper.select(t);
	}

	@Override
	public T selectById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	/**
	 * 查询所有，分页
	 */
	@Override
	public List<T> selectByPage(Integer pageNum, Integer pageSize, T t) {
		PageHelper.startPage(pageNum, pageSize);
		List<T> list = mapper.selectByExample(null);
		
		return list;
	}

	@Override
	public Integer count(T t) {
		return mapper.selectCount(t);
	}

	@Override
	public void insert(T t) {
		mapper.insert(t);
	}

	@Override
	public void insertSelective(T t) {
		mapper.insertSelective(t);
	}

	@Override
	public void deleteById(Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteByIds(List<Object> ids) {
		Example example = new Example(clazz);
		example.createCriteria().andIn("id", ids);
		
		mapper.deleteByExample(example);
	}

	@Override
	public void updateById(T t) {
		mapper.updateByPrimaryKey(t);
	}

	@Override
	public void updateByIdSelective(T t) {
		mapper.updateByPrimaryKeySelective(t);
	}
	
	
}
