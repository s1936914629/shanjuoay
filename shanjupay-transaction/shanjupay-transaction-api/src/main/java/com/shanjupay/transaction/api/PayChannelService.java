package com.shanjupay.transaction.api;

import com.shanjupay.common.domain.BusinessException;
import com.shanjupay.transaction.api.dto.PlatformChannelDTO;

import java.util.List;

/**
 * 支付渠道服务 管理平台支付渠道，原始支付渠道，以及相关配置
 * @auther: sqx
 * @Date: 2022/8/23
 */
public interface PayChannelService {
    /**
     * 获取平台服务类型
     * @return
     * @throws BusinessException
     */
    List<PlatformChannelDTO> queryPlatformChannel() throws BusinessException;

    /**
     * 为某个应用绑定一个服务类型
     * @param appId 应用id
     * @param platformChannelCodes  服务类型的code
     * @throws BusinessException
     */
    void bindPlatformChannelForApp(String appId,String platformChannelCodes) throws BusinessException;

    /**
     * 应用绑定服务类型的状态
     * @param appId 应用id
     * @param platformChannel
     * @return  已绑定 1,否则0
     * @throws BusinessException
     */
    int queryAppBindPlatformChannel(String appId,String platformChannel) throws BusinessException;



}
