package com.shanjupay.merchant.api;

import com.shanjupay.merchant.api.dto.MerchantDTO;

public interface MerchantService {

    /**
     * 根据id查询详细信息
     * @param id
     * @return
     */
    public MerchantDTO queryMerchantById(Long id);
}
