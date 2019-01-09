package com.xwtech.service;

import com.xwtech.pojo.Log;

import java.util.List;

/**
 * Created by jack on 2019/1/9.
 */
public interface LogService {

    void saveLog(Log log);
    List<Log> getLogList();
    Log finfById(Integer id);
}
