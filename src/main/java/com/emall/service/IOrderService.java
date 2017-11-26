package com.emall.service;

import com.emall.common.ServerResponse;

import java.util.Map;

/**
 * Created by Administrator on 2017/11/25.
 */
public interface IOrderService {

    ServerResponse pay(Long orderNo, Integer userId, String path);

    ServerResponse aliCallback(Map<String, String> params);

    ServerResponse queryOrderPayStatus(Integer userId, Long orderNo);
}
