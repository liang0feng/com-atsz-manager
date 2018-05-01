package com.atsz.manager.service.redis.utils;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import com.atsz.manager.service.redis.Function;
import com.atsz.manager.service.redis.RedisService;

@Service
public class RedisServiceImpl implements RedisService{
	
	private static final Logger logger = Logger
			.getLogger(RedisServiceImpl.class);
	
	@Autowired(required=false) //需要在时才注入
	private ShardedJedisPool shardedJedisPool;
	
	
	//抽取出来的过程一样，返回类型不一样的代码
	public <T> T execute(Function<ShardedJedis, T> fun) {
		ShardedJedis jedisCli = null;
		  // 从连接池中获取到jedis分片对象
		try {
			logger.debug("缓存连接池对象：" + shardedJedisPool);
			jedisCli= shardedJedisPool.getResource();
			return fun.callback(jedisCli);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (jedisCli != null) {
				jedisCli.close();
				logger.debug("释放连接成功为null：" + jedisCli);
			}
		}
		return null;
	}

	/**
	 * 设置缓存
	 */
	@Override
	public String set(final String key,final String value) {
		return this.execute(new Function<ShardedJedis, String>() {

			@Override
			public String callback(ShardedJedis e) {
				logger.debug("设置缓存==============="+key+":"+value);
				return e.set(key, value);
			}

		});
	}

	/**
	 * 获取缓存
	 */
	@Override
	public String get(final String key) {
		return this.execute(new Function<ShardedJedis, String>() {

			@Override
			public String callback(ShardedJedis e) {
				String string = e.get(key);
				logger.debug("读取缓存==============="+key+":" + string);
				return string;
			}
			
		});
	}

	/**
	 * 删除缓存
	 */
	@Override
	public Long del(final String key) {
		return this.execute(new Function<ShardedJedis, Long>() {

			@Override
			public Long callback(ShardedJedis e) {
				return e.del(key);
			}
		});
	}

	/**
	 * 设置缓存生命周期
	 */
	@Override
	public Long expire(final String key, final Integer seconds) {
		return this.execute(new Function<ShardedJedis, Long>() {

			@Override
			public Long callback(ShardedJedis e) {
				logger.debug("设置缓存==============="+key+":" + seconds + "seconds");
				return e.expire(key, seconds);
			}
		});
	}

	/**
	 * 新建并设置缓存的生命周期
	 */
	@Override
	public Long expire(final String key, final String value, final Integer seconds) {
		return this.execute(new Function<ShardedJedis, Long>() {

			@Override
			public Long callback(ShardedJedis e) {
				e.set(key, value);
				logger.debug("设置缓存==============="+key+":" + value +" life"+ seconds + "seconds");
				return e.expire(key, seconds);
			}
		});
	}

}
