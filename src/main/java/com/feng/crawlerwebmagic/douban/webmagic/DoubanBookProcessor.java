package com.feng.crawlerwebmagic.douban.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author fengyadong
 * @date 2023/7/4 10:12
 * @Description
 */
public class DoubanBookProcessor implements PageProcessor {

    private final Site site = Site.me()
            .setDomain("book.douban.com")
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36 Edg/114.0.1823.67")
            .setRetryTimes(3)
            .setSleepTime(5000)
            .setTimeOut(10000);

    @Override
    public void process(Page page) {
        if (page.getUrl().get().matches("https://book\\.douban\\.com/top250.+")) {
            page.addTargetRequests(page.getHtml().links().regex("(https://book.douban.com/subject/\\w+)").all());
            page.setSkip(true);
        } else {
            String doubanId = page.getUrl().regex("https://book.douban.com/subject/(\\w+)").toString();
            page.putField("doubanId", doubanId);
            String rankLabel = page.getHtml().xpath("//*[@id=\"wrapper\"]/div[1]/span[1]/span/text()").get();
            page.putField("rankLabel", rankLabel);
            String bookName = page.getHtml().xpath("//*[@id=\"wrapper\"]/h1/span/text()").get();
            page.putField("bookName", bookName);
            String score = page.getHtml().xpath("//*[@id=\"interest_sectl\"]/div/div[2]/strong/text()").get();
            page.putField("score", score);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

}
