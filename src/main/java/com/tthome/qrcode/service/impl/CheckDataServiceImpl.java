package com.tthome.qrcode.service.impl;

import com.tthome.qrcode.dao.CheckDataDao;
import com.tthome.qrcode.entity.CheckData;
import com.tthome.qrcode.service.CheckDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckDataServiceImpl implements CheckDataService {
    @Autowired
    private CheckDataDao checkDataDao;
    @Override
    public int insert(CheckData checkData) {
        return checkDataDao.insert(checkData);
    }
}
