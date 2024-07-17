package com.xd.library;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class dd_ReverseSQLibrary {

    public interface dd_ReverseSQInterface extends Library {

        dd_ReverseSQInterface INSTANCE =  Native.load("dd_ReverseSQ", dd_ReverseSQInterface.class);
        /**
         * @Method: 数据预计算
         * @param fileString_x 读取数据集x的地址
         * @param fileString_y 读取数据集y的地址
         */
        void dealData(String fileString_x, String fileString_y);

        /**
         * @Method: 发起反向相似性查询
         * @param fileString 读取数据的地址
         * @param resultFilePath 输出数据的地址
         * @return 状态码，1：成功；0：失败
         */
        int reverseSQ(String fileString, String resultFilePath);

        /**
         * @Method: 释放所用分配的内存
         */
        void freeRawData();
    }
}
