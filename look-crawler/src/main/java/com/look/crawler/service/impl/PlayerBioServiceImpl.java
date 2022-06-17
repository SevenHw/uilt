package com.look.crawler.service.impl;

import com.look.common.util.HttpClientUtil;
import com.look.common.util.Message;
import com.look.crawler.CrawlerLication;
import com.look.crawler.mapper.PlayerBioMapper;
import com.look.crawler.model.PlayerBio;
import com.look.crawler.model.PlayerBio;
import com.look.crawler.mapper.PlayerBioMapper;
import com.look.crawler.service.IPlayerBioService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 * 球员信息 服务实现类
 * </p>
 *
 * @author astupidcoder
 * @since 2022-05-18
 */
@Service
public class PlayerBioServiceImpl extends ServiceImpl<PlayerBioMapper, PlayerBio> implements IPlayerBioService {
    private static final Logger logger = LoggerFactory.getLogger(PlayerBioServiceImpl.class);
    @Autowired
    private PlayerBioMapper playerBioMapper;

    @Override
    public Message crawlerBioMain() {
        try {
            logger.info("正在生成客户端...");
            HttpClient client = null;
            logger.info("客户端生成完毕.");


            String[] city = {"重庆","西安"};


            String[] value = {
                    "060000","200200"
            };


            int pagesize = 1;
            boolean splider = true;
//            for (int num = 0; num <410; num ++) {
            while (splider) {
//                000000,0000,01,9,99 其中01是计算机的 打开51job网,搜索对应的之后看他的url地址栏变化
//                    String url = "https://search.51job.com/list/"+ value[num] +  ",000000,0000,01,9,99," + city[num] + ",2," + pagesize++ + ".html";
                String url = "http://nba.hupu.com/players/";

                logger.error("正在爬取当前第" + pagesize + "页数据");
//                    logger.error("正在爬取:" + city[num] + "城市" );
                logger.info(url);

                List<PlayerBio> jobsList = null;

                logger.info("正在生成客户端...");
                client = HttpClientBuilder.create().build();
                logger.info("客户端生成完毕.");

                //开始解析
                try {
                    logger.info("开始响应客户端...");
                    try {
                        Thread.sleep(200);
                        jobsList = this.urlParser(client, url);

                        if (jobsList.iterator().next().getBioName() == null) {
//                            pagesize  = 1;
                            break;
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    logger.info("响应完成.");
                } catch (Exception e) {
                    e.printStackTrace();
                }


                logger.info("开始输出结果...");

                for (PlayerBio job : jobsList) {

                }
                logger.info("整个结果输出完毕，程序结束.");
            }
//            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Message.success();
    }

    public List<PlayerBio> urlParser(HttpClient client, String url) throws IOException {

        List<PlayerBio> data = new ArrayList<PlayerBio>();

        //获取响应资源
        HttpResponse response = HttpClientUtil.getHtml(client,url);

        //获取响应状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        if(statusCode == 200) {
            //页面编码
            String entity = EntityUtils.toString(response.getEntity(),"gbk");
            System.out.println("开始解析...");
            data = this.getData(entity);
            System.out.println("URL解析完成.");
        } else {
            //释放资源实体
            EntityUtils.consume(response.getEntity());
        }
        System.out.println("返回数据.");
        return data;
    }

    public List<PlayerBio> getData(String entity){
        /**
         * 读取mybatis配置文件
         */
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = null;
//        try {
//            inputStream = Resources.getResourceAsStream(resource);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        /**
         * 得到连接对象注册sqlsession
         */
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        PlayerBioDao jobsMapper = sqlSession.getMapper(PlayerBioDao.class);


        List<PlayerBio> data = new ArrayList<PlayerBio>();
        Document doc = Jsoup.parse(entity);
        Elements elements = doc.select("tr");
        for (int i = 0; i < elements.size(); i++) {
            Elements element = elements.get(i).select("td");
            for (Iterator it = element.iterator(); it.hasNext();) {
                Element elm = (Element) it.next();
                System.out.println(elm.text());
            }
        }

        PlayerBio jobs = new PlayerBio();

        if (elements !=null || "".equals(elements)) {
            for (Element element : elements) {
                logger.info(element.className());
            }
        }
//
//        if (complany !=null || "".equals(complany)) {
//            for (Element element : complany) {
//                jobs.setCompanyName(element.text());
//            }
//        }
//
//        if (address !=null || "".equals(address)) {
//            for (Element element : address) {
//                jobs.setWorkAddr(element.text());
//            }
//        }
//
//        if (salary !=null || "".equals(salary)) {
//            for (Element element : salary) {
//                jobs.setSalary(element.text());
//            }
//        }
//
//        if (datas !=null || "".equals(datas)) {
//            for (Element element : datas) {
//                jobs.setPushDate(element.text());
//            }
//        }
//
//        if (SrcId !=null || "".equals(SrcId)) {
//            for (Element element : SrcId) {
//                jobs.setJobKey(element.attr("value"));
//            }
//        }
        playerBioMapper.insert(jobs);

        data.add(jobs);
        return data;
    }
}
