package com.train.business.controller;

import com.train.business.req.DailyTrainSeatQueryReq;
import com.train.business.resp.DailyTrainSeatQueryResp;
import com.train.business.service.DailyTrainSeatService;
import com.train.common.resp.CommonResp;
import com.train.common.resp.PageResp;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/daily-train-seat")
public class DailyTrainSeatController {

    @Resource
    private DailyTrainSeatService dailyTrainSeatService;



    @GetMapping("/query-list")
    public CommonResp<PageResp<DailyTrainSeatQueryResp>> queryList(@Valid DailyTrainSeatQueryReq req) {
        PageResp<DailyTrainSeatQueryResp> list = dailyTrainSeatService.queryList(req);
        return new CommonResp<>(list);
    }


}
