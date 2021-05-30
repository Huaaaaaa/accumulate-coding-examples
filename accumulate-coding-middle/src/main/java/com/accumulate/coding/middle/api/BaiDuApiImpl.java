package com.accumulate.coding.middle.api;

import com.accumulate.coding.common.utils.JsonUtil;
import com.accumulate.coding.common.utils.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/13
 * Todo:
 * Time 11:44
 */
@Slf4j
@Service
@Component
public class BaiDuApiImpl implements IBaiDuApi {

    private static final String APP_ID = "20201213000646027";

    private static final String KEY = "KjvkJH9MJzWd8A60_fZs";

    private static final String URL_HTTP = "http://api.fanyi.baidu.com/api/trans/vip/translate";

    private static final String URL_HTTPS = "https://fanyi-api.baidu.com/api/trans/vip/translate";

    @Resource
    private RestTemplate restTemplate;

    @Override
    public String translate(String from, String to, String srcMsg) throws UnsupportedEncodingException {
        Map<String, Object> paramMap = new HashMap<>();
        String salt = String.valueOf(System.currentTimeMillis());
        paramMap.put("from", from);
        paramMap.put("to", to);
        paramMap.put("appid", APP_ID);
        paramMap.put("salt", salt);
        paramMap.put("sign", getSign(srcMsg, salt));
        srcMsg = new String(srcMsg.getBytes("UTF-8"));
        String dst = "";
        paramMap.put("q", srcMsg);
        log.info("BaiDuApiImpl translate begin:paramMap={}", JsonUtil.toJsonString(paramMap));
        BaiDuTranslateResult translateResult = restTemplate.getForObject(URL_HTTP, BaiDuTranslateResult.class, paramMap);
        log.info("BaiDuApiImpl translate end:translateResult={}", JsonUtil.toJsonString(translateResult));
        if (translateResult != null && translateResult.getError_code() == null) {
            TranslateResult[] results = translateResult.getTrans_result();
            dst = results[0].getDst();
        } else {
            dst = String.valueOf(translateResult.getError_code());
        }
        return dst;
    }

    private String getSign(String q, String salt) throws UnsupportedEncodingException {
        String originKey = APP_ID + q + salt + KEY;
        return DigestUtils.md5DigestAsHex(originKey.getBytes("UTF-8")).toLowerCase();
    }
}
