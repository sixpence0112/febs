package com.cxf.febs.server.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cxf.febs.common.core.entity.FebsResponse;
import com.cxf.febs.common.core.entity.QueryRequest;
import com.cxf.febs.server.system.entity.Movie;
import com.cxf.febs.server.system.service.IMovieService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author sixpence
 * @version 1.0 2020/12/3
 */
@Slf4j
@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private IMovieService movieService;

    @GetMapping
    @ApiOperation("电影列表")
    public FebsResponse listPage(QueryRequest request, Movie movie) {
        IPage<Movie> page = this.movieService.listPage(movie, request);
        return new FebsResponse().data(page);
    }

    @PostMapping
    @ApiOperation("添加电影")
    public void addMovie(Movie movie, MultipartFile file) throws IOException {
        if (!file.isEmpty())
            movie.setPoster(file.getBytes());
        this.movieService.addMovie(movie);
    }

    @PutMapping
    @ApiOperation("更新电影")
    public void updateMovie(Movie movie) {
        this.movieService.updateMovie(movie);
    }

    @DeleteMapping("/{ids}")
    @ApiOperation("删除电影")
    public void addMovie(@PathVariable String ids) {
        this.movieService.deleteMovie(ids);
    }
}
