package com.atsz.manager.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.atsz.manager.mapper.CategoryMapper;
import com.atsz.manager.pojo.Category;
import com.atsz.manager.service.CategoryService;
import com.atsz.manager.service.redis.RedisService;
import com.atsz.manager.service.redis.utils.RedisServiceImpl;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionLikeType;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

	@Autowired
	CategoryMapper categoryMapper;
	@Autowired
	RedisServiceImpl redisService;

	// 缓存中key的值
	private static final String ATSZ_MANAGER_CATEGORY_TREE = "ATSZ_MANAGER_CATEGORY_TREE";
	
	private static final Logger logger = Logger.getLogger(CategoryServiceImpl.class);
	
	// json格式转java对象工具
	private static final ObjectMapper MAPPER = new ObjectMapper();

	/**
	 * 重写base查询方法，使用redis缓存技术
	 */
	@Override
	public List<Category> selectAll() {
		String value = redisService.get(ATSZ_MANAGER_CATEGORY_TREE);
		List<Category> list = new ArrayList<Category>();
		
		// 1.查缓存是否有
		try {
			if (value != null) {
				logger.info(ATSZ_MANAGER_CATEGORY_TREE+"命中！");
				// 有缓存，将缓存中的json格式转化为List<Category>返回
				JavaType vlueType = MAPPER.getTypeFactory().constructCollectionType(List.class, Category.class);

				// 获取
				list = MAPPER.readValue(value, vlueType);
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 2.缓存没有走数据库
		logger.debug("从数据库查询。。。");
		list = categoryMapper.select(null);

		try {
			// 3.数据库查出后，保存到缓存中
			redisService.expire(ATSZ_MANAGER_CATEGORY_TREE, MAPPER.writeValueAsString(list), 60*60*24*30);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 返回
		return list;

	}
	
}
