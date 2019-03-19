package com.slabs.springbootjava.core.systemlog;

import com.slabs.springbootjava.model.SystemLog;
import com.slabs.springbootjava.service.SystemLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @create: 2019/03/19 16:57
 */
@Component
public class SystemLogConsumer implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(SystemLogConsumer.class);

    public static final int DEFAULT_BATCH_SIZE = 64;

    private SystemLogQueue auditLogQueue;

    private SystemLogService systemLogService;

    private int batchSize = DEFAULT_BATCH_SIZE;

    private boolean active = true;

    private Thread thread;




    @PostConstruct
    public void init() {
        thread = new Thread(this);
        thread.start();
    }

    @PreDestroy
    public void close() {
        active = false;
    }



    @Override
    public void run() {
        while (active) {
            execute();
        }
    }


    public void execute() {
        List<SystemLog> systemLogs = new ArrayList<>();
        try {
            int size = 0;
            while (size < batchSize) {
                SystemLog systemLog = auditLogQueue.poll();
                if (systemLog == null) {
                    break;
                }
                systemLogs.add(systemLog);
                size++;
            }
        } catch (Exception ex) {
            logger.info(ex.getMessage(), ex);
        }
        if (!systemLogs.isEmpty()) {
            try {
                systemLogService.insertByBatch(systemLogs);
            }catch (Exception e){
                logger.error("异常信息:{}", e.getMessage());
            }

        }
    }
    @Resource
    public void setAuditLogQueue(SystemLogQueue auditLogQueue) {
        this.auditLogQueue = auditLogQueue;
    }
    @Resource
    public void setSystemLogService(SystemLogService systemLogService) {
        this.systemLogService = systemLogService;
    }

    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }
}
