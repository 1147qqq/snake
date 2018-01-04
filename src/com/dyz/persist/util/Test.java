package com.dyz.persist.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import com.dyz.gameserver.pojo.AllProducts;
import com.dyz.gameserver.pojo.Products;
import com.dyz.myBatis.services.ProductsService;
import com.easemob.lmc.model.TalkNode;
import com.easemob.lmc.service.TalkDataService;
import com.easemob.lmc.service.TalkHttpService;
import com.easemob.lmc.service.impl.TalkDataServiceImpl;
import com.easemob.lmc.service.impl.TalkHttpServiceImplApache;

public class Test {
public static void main(String[] args) { 
	  String str = "测试字符转换 hello word"; //默认环境，已是UTF-8编码
      try {
          String strGBK = URLEncoder.encode(str, "GBK");
          System.out.println(strGBK);
          String strUTF8 = URLDecoder.decode(str, "UTF-8");
          System.out.println(strUTF8);
      } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
      }
}
}
