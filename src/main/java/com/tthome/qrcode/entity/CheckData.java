package com.tthome.qrcode.entity;


import lombok.Data;

import java.util.Date;

@Data
public class CheckData {
    private int id;
    private String key;
    private int isCheck;
    private Date isCheckTime;
}
