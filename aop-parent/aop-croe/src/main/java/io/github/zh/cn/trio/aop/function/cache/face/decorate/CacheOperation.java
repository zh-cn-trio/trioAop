package io.github.zh.cn.trio.aop.function.cache.face.decorate;

import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.cache.context.CacheConfig;

public interface CacheOperation {

	/**
	 * 
	 * @param runTimeContext
	 *            上下文
	 * @param cacheConfig
	 *            配置
	 * @return 是否含有缓存信息
	 */
	boolean hasCache(RunTimeContext runTimeContext, CacheConfig cacheConfig);

	/**
	 *
	 * @param runTimeContext
	 *            上下文
	 * @param cacheConfig
	 *            配置
	 * @return 读取缓存信息
	 */
	Object getCache(RunTimeContext runTimeContext, CacheConfig cacheConfig);

	/**
	 * @param runTimeContext
	 *            上下文
	 * @param cacheConfig
	 *            配置
	 * 
	 * @return 写入缓存信息
	 */
	boolean setCache(RunTimeContext runTimeContext, CacheConfig cacheConfig);

	/**
	 * @param runTimeContext
	 *            上下文
	 * @param cacheConfig
	 *            配置
	 * @return 删除缓存信息
	 * 
	 */
	boolean removeCache(RunTimeContext runTimeContext, CacheConfig cacheConfig);
}
