package com.accumulate.coding.common.spring.init;

import com.accumulate.coding.common.error.BaseError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/3/30  10:11
 * @Description: 初始化错误码
 */
@Component
@Slf4j
public class InitHttpCode implements InitializingBean {

    public Map<Integer, BaseError> ERROR_MAP = new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        ERROR_MAP.put(200, new BaseError(100, "Continue：这个临时响应表明，迄今为止的所有内容都是可行的，客户端应该继续请求，如果已经完成，则忽略它"));
        ERROR_MAP.put(101, new BaseError(101, "Switching Protocol：该代码是响应客户端的 Upgrade (en-US) 标头发送的，并且指示服务器也正在切换的协议。"));
        ERROR_MAP.put(200, new BaseError(102, "Processing (WebDAV)：此代码表示服务器已收到并正在处理该请求，但没有响应可用。"));
        ERROR_MAP.put(200, new BaseError(103, "Early Hints：此状态代码主要用于与Link 链接头一起使用，以允许用户代理在服务器仍在准备响应时开始预加载资源。"));

        ERROR_MAP.put(200, new BaseError(200, "OK:请求成功。"));
        ERROR_MAP.put(201, new BaseError(201, "Created：该请求已成功，并因此创建了一个新的资源。这通常是在POST请求，或是某些PUT请求之后返回的响应。"));
        ERROR_MAP.put(202, new BaseError(202, "Accepted：请求已经接收到，但还未响应，没有结果。意味着不会有一个异步的响应去表明当前请求的结果，预期另外的进程和服务去处理请求，或者批处理。"));
        ERROR_MAP.put(203, new BaseError(203, "Non-Authoritative Information：服务器已成功处理了请求，但返回的实体头部元信息不是在原始服务器上有效的确定集合，而是来自本地或者第三方的拷贝。当前的信息可能是原始版本的子集或者超集。例如，包含资源的元数据可能导致原始服务器知道元信息的超集。使用此状态码不是必须的，而且只有在响应不使用此状态码便会返回200 OK的情况下才是合适的。"));
        ERROR_MAP.put(204, new BaseError(204, "No Content:服务器成功处理了请求，但不需要返回任何实体内容，并且希望返回更新了的元信息。响应可能通过实体头部的形式，返回新的或更新后的元信息。如果存在这些头部信息，则应当与所请求的变量相呼应。如果客户端是浏览器的话，那么用户浏览器应保留发送了该请求的页面，而不产生任何文档视图上的变化，即使按照规范新的或更新后的元信息应当被应用到用户浏览器活动视图中的文档。由于204响应被禁止包含任何消息体，因此它始终以消息头后的第一个空行结尾。"));
        ERROR_MAP.put(205, new BaseError(205, "Reset Content:服务器成功处理了请求，且没有返回任何内容。但是与204响应不同，返回此状态码的响应要求请求者重置文档视图。该响应主要是被用于接受用户输入后，立即重置表单，以便用户能够轻松地开始另一次输入。与204响应一样，该响应也被禁止包含任何消息体，且以消息头后的第一个空行结束。"));
        ERROR_MAP.put(206, new BaseError(206, "Partial Content：服务器已经成功处理了部分 GET 请求。类似于 FlashGet 或者迅雷这类的 HTTP 下载工具都是使用此类响应实现断点续传或者将一个大文档分解为多个下载段同时下载。该请求必须包含 Range 头信息来指示客户端希望得到的内容范围，并且可能包含 If-Range 来作为请求条件。"));
        ERROR_MAP.put(200, new BaseError(207, "Multi-Status (WebDAV)：由WebDAV(RFC 2518)扩展的状态码，代表之后的消息体将是一个XML消息，并且可能依照之前子请求数量的不同，包含一系列独立的响应代码。"));
        ERROR_MAP.put(200, new BaseError(208, "Already Reported (WebDAV):在 DAV 里面使用: propstat 响应元素以避免重复枚举多个绑定的内部成员到同一个集合。"));
        ERROR_MAP.put(200, new BaseError(226, "226 IM Used (HTTP Delta encoding)：服务器已经完成了对资源的 GET 请求，并且响应是对当前实例应用的一个或多个实例操作结果的表示。"));
        log.info("InitHttpCode end:ERROR_MAP={}", ERROR_MAP.toString());
    }
}
