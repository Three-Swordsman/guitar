package com.zhaoshy.guitarhelper.utils;

import cn.wanghaomiao.seimi.annotation.Crawler;
import cn.wanghaomiao.seimi.def.BaseSeimiCrawler;
import cn.wanghaomiao.seimi.struct.Response;
import com.zhaoshy.guitarhelper.entity.Guitar;
import com.zhaoshy.guitarhelper.mapper.GuitarMapper;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.seimicrawler.xpath.JXDocument;
import org.seimicrawler.xpath.JXNode;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/****************************************
 * @author : zhaoshy
 * @description : 
 * @create_time : 2020/3/18 17:31
 ****************************************
 */

@Crawler(name = "guitar")
public class GuitarReptile extends BaseSeimiCrawler {

    @Autowired
    GuitarMapper guitarMapper;

    @Override
    public String[] startUrls() {
        return new String[] {"https://www.yamaha.com.cn/products/musical-instruments/guitars/acousticguitar" +
                "/folkguitar/fg_redlabel"};
    }

    @Override
    public void start(Response response) {
        JXDocument document = response.document();
        String index = "https://www.yamaha.com.cn";
        String xpath = "//a[@class='display-block']";
        List<JXNode> jxNodes = document.selN(xpath);
        for (int i = 0; i < jxNodes.size() / 2; i++) {
            Element element = jxNodes.get(i).asElement();
            //获取图片路径
            Elements img_e = element.getElementsByTag("img");
            String img = index + img_e.attr("src");
            //获取型号
            Elements model_e = element.getElementsByTag("span");
            String model = model_e.text();
            //获取价格
            Elements price_e = element.getElementsByTag("p");
            String price_s = price_e.text();
            String result = Pattern.compile("[^0-9]").matcher(price_s).replaceAll("").trim();
            double price = Double.parseDouble(result);

            Guitar guitar = new Guitar();
            guitar.setBrand("雅马哈");
            guitar.setModelNum(model);
            guitar.setImg(img);
            guitar.setPrice(price);
            guitar.setType(1);
            guitar.setCreateBy("zhaoshy");
            guitar.setCreateDate(new Date());

            guitarMapper.insertSelective(guitar);
        }
    }
}
