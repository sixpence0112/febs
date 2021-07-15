package com.cxf.febs.server.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cxf.febs.common.core.entity.QueryRequest;
import com.cxf.febs.server.system.entity.Movie;

/**
 * @author sixpence
 * @version 1.0 2020/12/2
 */
public interface IMovieService extends IService<Movie> {

    /**
     * 分页查询电影
     * @param movie 电影对象，用于传递查询参数
     * @param request request
     * @return
     */
    IPage<Movie> listPage(Movie movie, QueryRequest request);

    /**
     * 添加电影
     *
     * @param movie movie
     */
    void addMovie(Movie movie);

    /**
     * 修改电影
     *
     * @param movie movie
     */
    void updateMovie(Movie movie);

    /**
     * 删除电影
     * @param movieIds movieId，多个id用","隔开
     */
    void deleteMovie(String movieIds);
}