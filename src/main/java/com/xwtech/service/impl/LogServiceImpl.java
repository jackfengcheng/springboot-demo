package com.xwtech.service.impl;

import com.xwtech.dao.LogRepository;
import com.xwtech.pojo.Log;
import com.xwtech.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jack on 2019/1/9.
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;

    @Override
    public void saveLog(Log log) {
        logRepository.save(log);
    }

    @Override
    public List<Log> getLogList() {
        return null;
    }

    @Override
    public Log finfById(Integer id) {
        return null;
    }
}
