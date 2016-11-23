package com.chen.poi;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/**
 * POI导出Excel表
 * @author chenhongjie
 *@Tool
 * 2016年11月22日
 */
public class ExportExcel<T> {

private static Logger logger = LogManager.getLogger(ExportExcel.class); 
private HSSFWorkbook workbook;

public void exportExcel(String[] headers,Collection<T> dataset, OutputStream out) {
      		workbook = new HSSFWorkbook();
      	// 生成一个表格
        HSSFSheet sheet = workbook.createSheet();
	    HSSFRow row = sheet.createRow(0);// 创建行,从0开始
	  /***************************/
	       workbook.createInformationProperties();//创建文档信息
		  //摘要信息
		    DocumentSummaryInformation dsi= workbook.getDocumentSummaryInformation();
		    dsi.setCategory("Excel文件");//类别
		    dsi.setManager("开发者:陈洪杰");//管理者
		    dsi.setCompany("电子与通信工程学院");//单位
		    SummaryInformation si = workbook.getSummaryInformation();//摘要信息
		    si.setSubject("毕业设计");//主题
		    si.setTitle("毕业设计");//标题
		    si.setAuthor("陈洪杰");//作者
		    si.setComments("POI文档");//备注
		    si.setCreateDateTime(new Date());
	  /***************************/
	   //创建表头
      for (short i = 0; i < headers.length; i++) {
         HSSFCell cell = row.createCell(i);
         HSSFRichTextString text = new HSSFRichTextString(headers[i]);
         cell.setCellValue(text);
      }
      //遍历集合数据，产生数据行
      Iterator<T> it = dataset.iterator();
      int index = 0;
      while (it.hasNext()) {
         index++;
         row = sheet.createRow(index);
         T t = (T) it.next();
         //利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
         Field[] fields = t.getClass().getDeclaredFields();
         int j=0;
         for (short i = 0; i <fields.length; i++) {
            Field field = fields[i];
            String fieldName = field.getName();
            String getMethodName = "get"
                   + fieldName.substring(0, 1).toUpperCase()
                   + fieldName.substring(1);
            System.out.println(getMethodName);
            if ("getSerialVersionUID".equalsIgnoreCase(getMethodName)) {
            	continue;
            }
            HSSFCell cell = row.createCell(j);
            j++;
            try {
                Class<? extends Object>  tCls= t.getClass();
                Method getMethod = tCls.getMethod(getMethodName,new Class[] {});
                Object value = getMethod.invoke(t, new Object[] {});
                //判断值的类型后进行强制类型转换
                String textValue = null;
                if (value instanceof Integer) {

                 int intValue = (Integer) value;

                 cell.setCellValue(intValue);

               } else if (value instanceof Double) {
                  double dValue = (Double) value;
                  cell.setCellValue(dValue);

               } else if (value instanceof Long) {
                 long longValue = (Long) value;
                  cell.setCellValue(longValue);
               } 
                if (value instanceof Date) {
                   Date date = (Date) value;
                   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                   textValue = sdf.format(date);
                } else{
                   textValue = value.toString();
                }
                if(textValue!=null){
                      HSSFRichTextString richString = new HSSFRichTextString(textValue);
                      cell.setCellValue(richString);
                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("",e);
            } 
         }
       }
      try {
		workbook.write(out);
	} catch (IOException e) {
		e.printStackTrace();
		logger.error("",e);
	}  
     }
 }


