package com.feng.crawlerwebmagic.douban.webmagic;

import com.feng.crawlerwebmagic.common.ApplicationContextUtil;
import com.feng.crawlerwebmagic.douban.domian.DoubanBookTop;
import com.feng.crawlerwebmagic.douban.mapper.DoubanBookTopMapper;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * @author fengyadong
 * @date 2023/7/4 10:20
 * @Description
 */
public class DoubanBookPipeline implements Pipeline {

    private final DoubanBookTopMapper doubanBookTopMapper;

    public DoubanBookPipeline() {
        this.doubanBookTopMapper = ApplicationContextUtil.getBean("doubanBookTopMapper");
    }


    @Override
    public void process(ResultItems resultItems, Task task) {
        DoubanBookTop doubanBookTop = new DoubanBookTop();
        doubanBookTop.setDoubanId(Integer.parseInt(resultItems.get("doubanId")));
        doubanBookTop.setRankLabel(resultItems.get("rankLabel"));
        doubanBookTop.setBookName(resultItems.get("bookName"));
        doubanBookTop.setScore(resultItems.get("score"));
        doubanBookTopMapper.insert(doubanBookTop);
    }
}
