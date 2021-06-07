package com.cxf.febs.server.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxf.febs.common.entity.constant.FebsConstant;
import com.cxf.febs.common.entity.QueryRequest;
import com.cxf.febs.common.utils.SortUtil;
import com.cxf.febs.server.system.entity.Movie;
import com.cxf.febs.server.system.mapper.MovieMapper;
import com.cxf.febs.server.system.service.IMovieService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

/**
 * @author sixpence
 * @version 1.0 2020/12/2
 */
@Slf4j
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class MovieServiceImpl extends ServiceImpl<MovieMapper, Movie> implements IMovieService {

    @Override
    public IPage<Movie> listPage(Movie movie, QueryRequest request) {
        LambdaQueryWrapper<Movie> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(movie.getMovieName()))
            wrapper.like(Movie::getMovieName, movie.getMovieName());
        if (StringUtils.isNotBlank(movie.getMoviePerformers()))
            wrapper.like(Movie::getMoviePerformers, movie.getMoviePerformers());
        if (StringUtils.isNotBlank(movie.getStatus()))
            wrapper.eq(Movie::getStatus, movie.getStatus());
        if (StringUtils.isNotBlank(movie.getScoreFrom()))
            wrapper.ge(Movie::getScore, new BigDecimal(movie.getScoreFrom()));
        if (StringUtils.isNotBlank(movie.getScoreEnd()))
            wrapper.le(Movie::getScore, new BigDecimal(movie.getScoreEnd()));
        if (StringUtils.isNotBlank(movie.getCreateTimeFrom()))
            wrapper.ge(Movie::getCreateTime, movie.getCreateTimeFrom());
        if (StringUtils.isNotBlank(movie.getCreateTimeEnd()))
            wrapper.ge(Movie::getCreateTime, movie.getCreateTimeEnd());
        Page<Movie> page = new Page<>();
        SortUtil.handlePageSort(request, page, "createTime", FebsConstant.ORDER_DESC, true);
        return this.page(page, wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addMovie(Movie movie) {
        movie.setCreateTime(new Date());
        save(movie);
    }

    @Override
    public void updateMovie(Movie movie) {
        movie.setModifyTime(new Date());
        updateById(movie);
    }

    @Override
    public void deleteMovie(String movieIds) {
        String[] ids = movieIds.split(StringPool.COMMA);
        Arrays.stream(ids).forEach(id -> baseMapper.deleteById(Integer.parseInt(id)));
    }
}
