package com.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.log4j.Logger;
import org.w3c.dom.css.CSSStyleSheet;

import com.util.CssParserUtil;

public class OrderService {
    private final static Logger log = Logger.getLogger(OrderService.class);
    /**
     * 设置背景图
     * @param imgUri
     * @param targetCssName
     * @return
     */
	public boolean uploadAndSetBgImg(String imgUri, String cssFileName){
		boolean flag = false;
		FileInputStream inStream;
		try{
			inStream = new FileInputStream(new File(cssFileName));		
		
			CSSStyleSheet sheet = CssParserUtil.updatePoperty(inStream, "body","background-image", "url("+imgUri+") no-repeat","important");
	        String cssRule = sheet.getCssRules().toString();
	        FileOutputStream out = new FileOutputStream(cssFileName);
	        out.write(cssRule.getBytes("utf-8"));
	        out.close();
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return flag;
	}
}