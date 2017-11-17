package com.emall.util;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/11/10.
 */
public class BigDecimalUtil {
    private BigDecimalUtil(){

    }

    public static BigDecimal add(double y1, double y2){
        BigDecimal b1 = new BigDecimal(Double.toString(y1));
        BigDecimal b2 = new BigDecimal(Double.toString(y2));
        return b1.add(b2);
    }

    public static BigDecimal sub(double y1, double y2){
        BigDecimal b1 = new BigDecimal(Double.toString(y1));
        BigDecimal b2 = new BigDecimal(Double.toString(y2));
        return b1.subtract(b2);
    }

    public static BigDecimal mul(double y1, double y2){
        BigDecimal b1 = new BigDecimal(Double.toString(y1));
        BigDecimal b2 = new BigDecimal(Double.toString(y2));
        return b1.multiply(b2);
    }

    public static BigDecimal div(double y1, double y2){
        BigDecimal b1 = new BigDecimal(Double.toString(y1));
        BigDecimal b2 = new BigDecimal(Double.toString(y2));
        return b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP); //四舍五入,保留2位小数
        // 除不尽的情况
    }
}
