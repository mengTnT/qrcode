package com.tthome.qrcode.service;

import com.tthome.qrcode.entity.CheckData;

public interface CheckDataService {
    int insert(CheckData checkData);
    CheckData selectIdMax();
    CheckData selectByKey(String key);
    int updateCheck(int id);
}
