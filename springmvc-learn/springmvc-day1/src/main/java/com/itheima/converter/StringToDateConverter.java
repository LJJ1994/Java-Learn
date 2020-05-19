package com.itheima.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: LJJ
 * @Program: springmvc-day1
 * @Description:
 * @Create: 2020-05-10 04:01:01
 * @Modified By:
 */
public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        DateFormat format=null;
        try{
            if(StringUtils.isEmpty(s)){
                throw new NullPointerException("请输入要转换的日期字符串!");
            }
            format = new SimpleDateFormat("yyyy-MM-dd");
            return format.parse(s);
        } catch (Exception e){
            throw new RuntimeException("输入日期有误");
        }
    }
}
