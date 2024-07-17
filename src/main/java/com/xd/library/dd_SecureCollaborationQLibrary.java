package com.xd.library;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class dd_SecureCollaborationQLibrary {

    public interface dd_SecureCollaborationQInterface extends Library {
        dd_SecureCollaborationQInterface INSTANCE =  Native.load("dd_SecureCollaborationQ", dd_SecureCollaborationQInterface.class);
        /**
         * @Method: 读取数据集
         * @param fileString 读取数据集的地址
         */
        void dealData(String fileString);

        /**
         * @Method: 发起查询请求
         * @param fileString 读取数据的地址
         * @param resultFilePath 输出数据的地址
         * @return 状态码，1：成功；0：失败
         */
        int secureCollaborationQ(String fileString, String resultFilePath);

        /**
         * @Method: 清理函数，用于释放 rawData 中的 BIGNUM 对象的内存
         */
        void cleanupRawData();
    }
}
