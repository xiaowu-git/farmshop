package com.farm.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * 浮点型数字操作
 * @author zy20022630
 */
public class DoubleUtil {
	
	private static final int DEF_DIV_SCALE = 10;
	
	private static final int DECIMAL_SCALE = 2;

	/**
	 * 一个Double数平分为N份
	 * @param d 目标Double数
	 * @param n 份数(n >= 1)
	 * @param scale 保留scale位小数
	 * @return 由N份组成的数组
	 */
	public static Double[] div(Double d, int n, int scale){
		Double[] array = new Double[n];
		
		//获取格式化字符串
		StringBuffer buffer = new StringBuffer();
		buffer.append("0.");
		int i = 0;
		for (i = 0;i < scale;i++){
			buffer.append("#");
		}
		
		//设置格式化对象
		DecimalFormat decimalFormat = new DecimalFormat(buffer.toString());
		
		Double tmpDouble = null;
		if (n == 1){
			array[n - 1] = Double.valueOf(decimalFormat.format(d.doubleValue()));
		}else{
			tmpDouble = div(d.doubleValue(),Double.parseDouble(String.valueOf(n)),scale);
			for (i = 0;i < n - 1;i++){
				array[i] = tmpDouble;
			}
			tmpDouble = mul(tmpDouble.doubleValue(),Double.parseDouble(String.valueOf(n - 1)));
			tmpDouble = sub(d.doubleValue(),tmpDouble.doubleValue());
			array[n - 1] = Double.valueOf(decimalFormat.format(tmpDouble.doubleValue()));
		}
		
		//清空
		buffer = null;
		decimalFormat = null;
		tmpDouble = null;
		
		return array;
	}
    
    /**
     * 两个Double数相加
     * @param v1
     * @param v2
     * @return Double
     */
    public static Double add(Double v1,Double v2){
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.add(b2).doubleValue();
    }
    
    /**
     * 两个Double数相减
     * @param v1
     * @param v2
     * @return Double
     */
    public static Double sub(Double v1,Double v2){
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.subtract(b2).doubleValue();
    }
    
    /**
     * 两个Double数相除，并保留scale位小数
     * @param v1
     * @param v2
     * @param scale
     * @return Double
     */
    public static Double div(Double v1,Double v2,int scale){
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    
    /**
     * 两个Double数相乘
     * @param v1
     * @param v2
     * @return Double
     */
    public static Double mul(Double v1,Double v2){
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.multiply(b2).doubleValue();
    }
    
    /**
     * 两个Double数相除
     * @param v1
     * @param v2
     * @return Double
     */
    public static Double div(Double v1,Double v2){
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.divide(b2,DEF_DIV_SCALE,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 计算两个Double数的比率
     * @param v1 本期总数
     * @param v2 上期总数
     * @return
     */
    public static Double getRate(Double v1 , Double v2) {
    	if(v1 == 0 || v2 == 0)
    		return 0.0;
    	//计算出增长数量
    	Double increaseNumber = sub(v1, v2);
    	//计算增长率
    	Double rate = div(increaseNumber, v2);
    	return rate;
    }
    
    //四舍五入保留四位小数
    public static Double getRound(double rate){
    	if(rate == 0){
    		return  0.0;
    	}
		DecimalFormat fnum = new DecimalFormat("##0.0000"); 
		String dd=fnum.format(rate);   
		double result = Double.valueOf(dd);
		return result;
    }
    
    public static double changeLtoD(long number){
    	double param = (double)((Long)number);
    	return param;
    }
    
    
   /**
    * 计算出比率的百分数形式
    * @param v1
    * @return
    */
    public static String getRateString(Double v1) {
    	String result = null;
    	//百分数格式(保留两位小数)
    	NumberFormat percentInstance = NumberFormat.getPercentInstance();
    	percentInstance.setMaximumFractionDigits(DECIMAL_SCALE);
    	//获取增长率的百分数
    	result = percentInstance.format(v1);
    	if(result.contains(",")) {
    		result = result.replaceAll(",", "");
    	}
    	return result;
    }
}