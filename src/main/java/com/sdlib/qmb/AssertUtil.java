package com.sdlib.qmb;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Map;

/**
 * 类名： AssertUtil
 * 描述 TODO：
 * 创建时间： 2022/4/29 10:09
 * 创建人： Administrator
 */
public class AssertUtil {

//    //如果不是true，则抛异常
//    public static void isTrue(boolean expression, String msg) {
//        if (!expression) {
//            throw new BusinessException(msg);
//        }
//    }
//    //如果是true，则抛异常
//    public static void isFalse(boolean expression, String msg) {
//        if (expression) {
//            throw new BusinessException(msg);
//        }
//    }
//    //如果是空或者空字符串，则抛异常
//    public static void isNotEmpty(String str, String msg) {
//        if (StringUtils.isEmpty(str)) {
//            throw new BusinessException(msg);
//        }
//    }
//    //如果数组为空或者长度小于1，则抛异常
//    public static void isNotEmpty(Object[] str, String msg) {
//        if (CollectionUtils.isEmpty(str)) {
//            throw new BusinessException(msg);
//        }
//    }
//    //如果集合为空或者长度小于1，则抛异常
//    public static void isNotEmpty(Collection collection, String msg) {
//        if (CollectionUtils.isEmpty(collection)) {
//            throw new BusinessException(msg);
//        }
//    }
//    //如果字符串为空或者长度小于1，则放行，否则抛异常
//    public static void isEmpty(String str, String msg) {
//        if (StringUtils.isNotEmpty(str)) {
//            throw new BusinessException(msg);
//        }
//    }
//    //如果集合为空或者长度小于1，则放行，否则抛异常
//    public static void isEmpty(Collection collection, String msg) {
//        if (CollectionUtils.isNotEmpty(collection)) {
//            throw new BusinessException(msg);
//        }
//    }
//
//    //如果集合为空或者长度小于1，则抛异常
//    public static void isNotEmpty(Map map, String msg) {
//        if (MapUtils.isEmpty(map)) {
//            throw new BusinessException(msg);
//        }
//    }
//    //如果对象时空，则抛异常
//    public static void isNotNull(Object object, String msg) {
//        if (object == null) {
//            throw new BusinessException(msg);
//        }
//    }
//    public static void isNotNull(Object[] objects, String msg) {
//        if (CollectionUtils.isEmpty(objects)) {
//            throw new BusinessException(msg);
//        }
//    }
//    //对象数组空
//    public static void isNotNull(Object[] objects, ResponseCode responseCode, String msg) {
//        if (CollectionUtils.isEmpty(objects)) {
//            throw new BusinessException(responseCode, msg);
//        }
//    }
//    //如果不是true，则抛异常
//    public static void isTrue(boolean expression, ResponseCode responseCode, String msg) {
//        if (!expression) {
//            throw new BusinessException(responseCode, msg);
//        }
//    }
//    //如果是空或者空字符串，则抛异常
//    public static void isNotEmpty(String str, ResponseCode responseCode, String msg) {
//        if (StringUtils.isEmpty(str)) {
//            throw new BusinessException(responseCode, msg);
//        }
//    }
//    //如果数组为空或者长度小于1，则抛异常
//    public static void isNotEmpty(Object[] str, ResponseCode responseCode, String msg) {
//        if (CollectionUtils.isEmpty(str)) {
//            throw new BusinessException(responseCode, msg);
//        }
//    }
//    //如果集合为空或者长度小于1，则抛异常
//    public static void isNotEmpty(Collection collection, ResponseCode responseCode, String msg) {
//        if (CollectionUtils.isEmpty(collection)) {
//            throw new BusinessException(responseCode, msg);
//        }
//    }
//    //如果集合为空或者长度小于1，则抛异常
//    public static void isNotEmpty(Map map, ResponseCode responseCode, String msg) {
//        if (MapUtils.isEmpty(map)) {
//            throw new BusinessException(responseCode, msg);
//        }
//    }
//
//    //如果对象时空，则抛异常
//    public static void isNotNull(Object object, ResponseCode responseCode, String msg) {
//        if (object == null) {
//            throw new BusinessException(responseCode, msg);
//        }
//    }
//    //比较对象
//    public static void equals(Object obj1, Object obj2, String msg) {
//        if (!equals(obj1, obj2)) {
//            throw new BusinessException(msg);
//        }
//    }
//    //比较对象的相等
//    public static boolean equals(final Object cs1, final Object cs2) {
//        if (cs1 == cs2) {
//            return true;
//        }
//        if (null == cs1 && null != cs2) {
//            return false;
//        }
//        if (null != cs1 && null == cs2) {
//            return false;
//        }
//        if (cs1 == null || null == cs2) {
//            return true;
//        }
//        if (cs1 instanceof String && cs2 instanceof String) {
//            return cs1.equals(cs2);
//        }
//        return cs1.equals(cs2);
//    }
}
