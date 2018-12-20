package com.hss.boot6.provider;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
  * 如果你是想在非Spring管理的实体内使用ApplicationContext还不想采用注入ApplicationContextProvider来完成实例化，
 * 这时我们可以修改ApplicationContext实例对象为静态实例，
 * 方法改为静态方法，这样在外部同样是可以获取到指定Bean的实例。如下所示：
 *
 * 这里要注意ApplicationContextProvider类上的@Component注解是不可以去掉的，
 * 去掉后Spring就不会自动调用setApplicationContext方法来为我们设置上下文实例。
 */
@Component
public class ApplicationContextProvider1  implements ApplicationContextAware {
    /**
     * 上下文对象实例
     */
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 获取applicationContext
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 通过name获取 Bean.
     * @param name
     * @return
     */
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }

    /**
     * 通过class获取Bean.
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    /**
     * 通过name,以及Clazz返回指定的Bean
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }
}
