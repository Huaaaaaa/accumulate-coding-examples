package com.accumulate.coding.middle.controller;

import com.accumulate.coding.common.req.MiddleGetRedisReq;
import com.accumulate.coding.common.req.MiddleSetRedisReq;
import com.accumulate.coding.common.resp.BaseApiResponse;
import com.accumulate.coding.middle.redis.JedisDeleteService;
import com.accumulate.coding.middle.redis.JedisGetService;
import com.accumulate.coding.middle.redis.JedisSaveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Huaaaaaa
 * DateTime: 2021/1/27  11:38
 * Description:
 */

@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisController extends BaseController {

    @Autowired
    private JedisSaveService jedisSaveService;

    @Autowired
    private JedisGetService jedisGetService;

    @Autowired
    private JedisDeleteService jedisDeleteService;


    @GetMapping("/index")
    @ResponseBody
    public BaseApiResponse index() {
        return getResponse("This is millde,I am alive.");
    }


    /**
     * set data
     *
     * @param middleSetRedisReq
     * @return
     */
    @PostMapping("/saveData")
    @ResponseBody
    public BaseApiResponse saveData(@RequestBody MiddleSetRedisReq middleSetRedisReq) {
        log.info("saveData middleSetRedisReq={}", middleSetRedisReq);
        boolean saveRes = jedisSaveService.saveData(middleSetRedisReq.getKey(), middleSetRedisReq.getValue());
        return getResponse(saveRes);
    }


    /**
     * get data
     *
     * @param middleGetRedisReq
     * @return
     */
    @PostMapping("/getData")
    @ResponseBody
    public BaseApiResponse getData(@RequestBody MiddleGetRedisReq middleGetRedisReq) {
        log.info("getData middleGetRedisReq={}", middleGetRedisReq);
        Object getRes = jedisGetService.getData(middleGetRedisReq.getKey(), middleGetRedisReq.getType());
        return getResponse(getRes);
    }


    /**
     * delete data by key
     *
     * @param key
     * @return
     */
    @DeleteMapping("/delete/{key}")
    @ResponseBody
    public BaseApiResponse deleteData(@PathVariable String key) {
        log.info("deleteData key={}", key);
        Object delRes = jedisDeleteService.deleteData(key, null);
        return getResponse(delRes);
    }
}
