package com.tthome.qrcode.dao;

import com.tthome.qrcode.entity.CheckData;

public interface CheckDataDao {
    int insert(CheckData checkData);
    CheckData selectIdMax();
    CheckData selectByKey(String key);
    int updateCheck(int id);
}
