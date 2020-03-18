package com.zhaoshy.guitarhelper.utils;

import cn.wanghaomiao.seimi.annotation.Crawler;
import cn.wanghaomiao.seimi.def.BaseSeimiCrawler;
import cn.wanghaomiao.seimi.struct.Response;
import com.zhaoshy.guitarhelper.entity.Guitar;
import com.zhaoshy.guitarhelper.mapper.GuitarMapper;
import com.zhaoshy.guitarhelper.mapper.GuitarMapperExtend;
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
 * @description : 设置一个执行周期为 10 分钟的爬虫
 * @create_time : 2020/3/18 17:31
 ****************************************
 */

@Crawler(name = "guitar", delay = 600)
public class GuitarReptile extends BaseSeimiCrawler {

    @Autowired
    GuitarMapper guitarMapper;

    @Autowired
    GuitarMapperExtend guitarMapperExtend;

    @Override
    public String[] startUrls() {
        return new String[] {"https://www.yamaha.com.cn/products/musical-instruments/guitars/acousticguitar" +
                "/folkguitar/fg_redlabel"};
    }

    @Override
    public void start(Response response) {
        //爬取数据之前先将以往数据状态设置为 1
        guitarMapperExtend.updateStatusToDel();
        //开始爬取数据
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
            String price_s = element.getElementsByTag("p").text();
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

            //插入数据
            guitarMapper.insertSelective(guitar);
        }
    }
}
