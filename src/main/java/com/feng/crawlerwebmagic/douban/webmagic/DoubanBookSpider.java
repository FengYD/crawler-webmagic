package com.feng.crawlerwebmagic.douban.webmagic;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.ProxyProvider;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengyadong
 * @date 2023/7/4 10:15
 * @Description
 */
public class DoubanBookSpider {

    public void crawl() {
        List<String> urlList = new ArrayList<>(10);
        for (int start = 0; start < 250; start += 25) {
            urlList.add("https://book.douban.com/top250?start=" + start);
        }
        HttpClientDownloader downloader = new HttpClientDownloader();
        ProxyProvider proxyProvider = SimpleProxyProvider.from(new Proxy("124.223.158.96", 23456, "http"));
        downloader.setProxyProvider(proxyProvider);
        Spider spider = Spider.create(new DoubanBookProcessor())
                .setDownloader(downloader)
                .addUrl(urlList.toArray(new String[0]))
                .addPipeline(new DoubanBookPipeline())
                .setSpawnUrl(true)
                .thread(1);
        spider.run();
    }

}
