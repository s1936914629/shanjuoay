package com.shanjupay.merchant.api;

import com.shanjupay.common.domain.BusinessException;
import com.shanjupay.merchant.api.dto.AppDTO;
import com.shanjupay.merchant.api.dto.MerchantDTO;

import java.util.List;

/**
 * @auther: sqx
 * @Date: 2022/8/21
 */
public interface AppService {

    /**
     * 创建应用
     * @param merchantId 商户id
     * @param appDTO 应用信息
     * @return 创建成功的应用信息
     * @throws BusinessException
     */
    AppDTO createApp(Long merchantId, AppDTO appDTO) throws BusinessException;

    /**
     * 根据商户id查询应用列表
     * @param merchantId
     * @return
     * @throws BusinessException
     */
    List<AppDTO> queryAppByMerchant(Long merchantId) throws BusinessException;

    /**
     * 根据应用id查询应用信息
     * @param appId
     * @return
     * @throws BusinessException
     */
    AppDTO getAppById(String appId)throws BusinessException;

}