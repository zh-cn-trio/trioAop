package io.github.zh.cn.trio.aop.cache.model;

import io.github.zh.cn.trio.aop.cache.config.CacheBeanConfig;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;

public class ReadWriteFlushCacheModel extends AbstractCacheModel {

	@Override
	public String getModelName() {
		return READ_WRITE_FLUSH;
	}
	
	
	@Override
	public void execAfter(AopUtilContext<CacheBeanConfig> aopUtilContext) {
		getCacheFace().setCache(aopUtilContext);
	}
}