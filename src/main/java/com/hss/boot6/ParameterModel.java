package com.hss.boot6;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 参数实体映射注解
 * 配置该注解的参数会使用 com.yuqiyu.chapter36.resovler.CustomerArgumentResolver类完成参数装载
 * ========================
 * Created with IntelliJ IDEA.
 * User：恒宇少年
 * Date：2017/9/16
 * Time：22:19
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
@Target(value = ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParameterModel
{
}
//该注解目前没有添加任何一个属性，这个也是可以根据项目的需求已经业务逻辑进行相应添加的，
// 比如@RequestParam内常用的属性required、defaultValue等属性，由于我们本章内容不需要自定义注解内的属性所以这里就不添加了。
