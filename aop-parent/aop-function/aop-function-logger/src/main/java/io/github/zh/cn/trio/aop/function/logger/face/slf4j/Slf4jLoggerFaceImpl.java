package io.github.zh.cn.trio.aop.function.logger.face.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.zh.cn.trio.aop.croe.utils.FormatConvertUtils;
import io.github.zh.cn.trio.aop.function.logger.context.LoggerBeanContext;
import io.github.zh.cn.trio.aop.function.logger.face.LoggerFace;
import io.github.zh.cn.trio.aop.plug.format.Format;
import io.github.zh.cn.trio.aop.plug.format.bean.FormatBean;

/**
 * 
 * slf4j 实现的日志
 *
 */
@Component
public class Slf4jLoggerFaceImpl implements LoggerFace {

	@Autowired
	private Format format;

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	@Override
	public void logger(LoggerBeanContext aopUtilContext, String targetTime) {
		// 读配置
		String level = aopUtilContext.getLevel(targetTime);
		String name = aopUtilContext.getName(level);
		String model = aopUtilContext.getModel(name);
		FormatBean formatBean = FormatConvertUtils.convertContext(aopUtilContext);
		String info = getFormat().format(formatBean, model);
		logger(level, name, info, aopUtilContext.getThrowable());
	}

	public void logger(String level, String name, String info, Throwable e) {
		Logger logger = LoggerFactory.getLogger(name);
		switch (level) {
		case LoggerBeanContext.LEVEL_DEBUG:
			logger.debug(info, e);
			break;
		case LoggerBeanContext.LEVEL_INFO:
			logger.info(info, e);
			break;
		case LoggerBeanContext.LEVEL_ERROR:
			logger.error(info, e);
			break;
		case LoggerBeanContext.LEVEL_WARN:
			logger.warn(info, e);
			break;
		default:
			logger.debug(info, e);
			break;
		}
	}

}