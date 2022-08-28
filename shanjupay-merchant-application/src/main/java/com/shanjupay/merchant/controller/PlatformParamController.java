package com.shanjupay.merchant.controller;

/**
 * 平台支付参数配置相关的controller
 * @auther: sqx
 * @Date: 2022/8/23
 */

import com.shanjupay.transaction.api.PayChannelService;
import com.shanjupay.transaction.api.dto.PlatformChannelDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "商户平台-渠道和支付参数相关", tags = "商户平台-渠道和支付参数", description = "商户平台-渠道和支付参数相关")
@RestController
@Slf4j
public class PlatformParamController {

    @Reference
    PayChannelService payChannelService;


    @ApiOperation("获取平台服务类型")
    @GetMapping(value="/my/platform-channels")
    public List<PlatformChannelDTO> queryPlatformChannel(){
        return payChannelService.queryPlatformChannel();
    }
}