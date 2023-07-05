package com.feng.crawlerwebmagic.douban.domian;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author fengyadong
 * @date 2023/7/4 11:02
 * @Description
 */
@Data
@TableName("douban_book_top")
public class DoubanBookTop {

    private Long id;

    private Integer doubanId;

    private String rankLabel;

    private String bookName;

    private String score;

    private Date createTime;

    private Date updateTime;
}
