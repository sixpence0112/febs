package com.cxf.febs.auth.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cxf.febs.auth.entity.OAuthClientDetails;
import com.cxf.febs.common.entity.QueryRequest;
import com.cxf.febs.common.exception.FebsException;

/**
 * @author sixpence
 * @version 1.0 2020/12/30
 */
public interface OAuthClientDetailsService extends IService<OAuthClientDetails> {

    /**
     * 查询（分页）
     *
     * @param request            QueryRequest
     * @param oauthClientDetails oauthClientDetails
     * @return IPage<OAuthClientDetails>
     */
    IPage<OAuthClientDetails> findOAuthClientDetails(QueryRequest request, OAuthClientDetails oauthClientDetails);

    /**
     * 根据主键查询
     *
     * @param clientId clientId
     * @return OAuthClientDetails
     */
    OAuthClientDetails findById(String clientId);

    /**
     * 新增
     *
     * @param oauthClientDetails oauthClientDetails
     */
    void createOAuthClientDetails(OAuthClientDetails oauthClientDetails) throws FebsException;

    /**
     * 修改
     *
     * @param oauthClientDetails oauthClientDetails
     */
    void updateOAuthClientDetails(OAuthClientDetails oauthClientDetails);

    /**
     * 删除
     *
     * @param clientIds clientIds
     */
    void deleteOAuthClientDetails(String clientIds);
}
