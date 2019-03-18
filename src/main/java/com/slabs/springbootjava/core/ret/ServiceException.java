package com.slabs.springbootjava.core.ret;


import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 业务异常类
 * @create: 2019/03/18 13:39
 */
@NoArgsConstructor
public class ServiceException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = -4529057940006722538L;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
