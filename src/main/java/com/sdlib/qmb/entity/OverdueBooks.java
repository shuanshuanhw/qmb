package com.sdlib.qmb.entity;

import lombok.Data;

/**
 * 类名： OverdueBooks
 * 描述 TODO：
 * 创建时间： 2022/4/29 14:39
 * 创建人： Administrator
 */
@Data
public class OverdueBooks {
    private String barCode;// 文献条码
    private String title;// 文献题名
    private String orgLib;// 文献所有馆
    private String orgLocal;// 文献所有馆藏点
    private String callno;// 索取号
    private String volInfo;// 卷期信息
    private String LoanDate;// 借书时间
    private String returnTime;// 应还时间
    private String identifier;// 读者证号
    private String phone;// 手机号码
}
