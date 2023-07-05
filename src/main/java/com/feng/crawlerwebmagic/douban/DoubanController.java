package com.feng.crawlerwebmagic.douban;

import com.feng.crawlerwebmagic.douban.webmagic.DoubanBookSpider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fengyadong
 * @date 2023/7/4 10:43
 * @Description
 */
@Slf4j
@RequestMapping("/douban")
@RestController
public class DoubanController {

    @GetMapping("/book/top250")
    public String bookTop250() {
        new Thread(() -> new DoubanBookSpider().crawl()).start();
        return "开始获取豆瓣图书Top250";
    }

}
