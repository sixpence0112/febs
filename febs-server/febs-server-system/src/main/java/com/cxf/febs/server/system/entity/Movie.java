package com.cxf.febs.server.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author sixpence
 * @version 1.0 2020/12/2
 */
@Data
@Builder
@TableName("t_movie")
@NoArgsConstructor
@AllArgsConstructor
public class Movie implements Serializable {

    private static final long serialVersionUID = -3414965476339847097L;

    /**
     * 电影id
     */
    @TableId(value = "MOVIE_ID", type = IdType.AUTO)
    private Integer movieId;

    /**
     * 电影名字
     */
    @TableField("MOVIE_NAME")
    private String movieName;

    /**
     * 电影演员
     */
    @TableField("MOVIE_PERFORMERS")
    private String moviePerformers;

    /**
     * 上映日期
     */
    @TableField("RELEASE_DATE")
    @DateTimeFormat(pattern =  "yyyy-MM-dd")
    private Date releaseDate;

    /**
     * 0:未看，1：想看，2：已看
     */
    @TableField("STATUS")
    private String status;

    /**
     * 评分
     */
    @TableField("SCORE")
    private BigDecimal score;

    /**
     * 评论
     */
    @TableField("COMMENTS")
    private String comments;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("MODIFY_TIME")
    private Date modifyTime;

    /**
     * 电影海报
     */
    @TableField("POSTER")
    private byte[] poster;

    /**
     * 观看次数
     */
    @TableField("POSTER")
    private String frequency;

    /**
     * 最低评分
     */
    private transient String scoreFrom;
    /**
     * 最高评分
     */
    private transient String scoreEnd;
    /**
     * 创建时间起始
     */
    private transient String createTimeFrom;
    /**
     * 创建时间终止
     */
    private transient String createTimeEnd;
}
