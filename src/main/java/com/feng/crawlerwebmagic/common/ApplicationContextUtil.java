package com.feng.crawlerwebmagic.common;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author fengyadong
 * @date 2023/7/4 11:39
 * @Description
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    //获取Bean
    public static <T> T getBean(Class<T> requiredType) {
        //assertContextInjected();
        return getApplicationContext().getBean(requiredType);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        assertContextInjected();
        return (T) getApplicationContext().getBean(name);
    }

    //判断application是否为空
    public static void assertContextInjected() {
        Validate.isTrue(applicationContext != null, "application未注入 ，请在springContext.xml中注入SpringHolder!");
    }


}
