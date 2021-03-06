package io.github.zh.cn.trio.aop.plug.format;

import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;

public interface Format {

	/**
	 * 填充
	 * @param formatBean 填充根
	 * @param expressionString 解析表达式
	 * @return 根据填充和表达式解析对象
	 */
	<T> T format(Object formatBean, String expressionString);

	
	<T> T format(RunTimeContext runTimeContext,RunTimeConfig runTimeConfig, String expressionString);

}
