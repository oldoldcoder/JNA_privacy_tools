package com.xd;

import com.xd.library.*;
import com.xd.util.constant.ETPSSConstant;

/**测试JNA内容的效果*/
public class main {
    public static void main(String[] args) {
//        JNA_TEST_ScComputing();
        // 测试ReverseSQ
//        JNA_TEST_ReverseSQ1();
//        JNA_TEST_ReverseSQ2();
//        JNA_TEST_ReverseSQ2();
//        JNA_TEST_ReverseSQ2();

        // 测试SecureCollaborationQ
        SecureCollaborationQ1();
        SecureCollaborationQ2();
        SecureCollaborationQ2();
        SecureCollaborationQ2();
    }


    // SecureCollaborationQ用于预处理数据
    private static void SecureCollaborationQ1() {
        dd_SecureCollaborationQLibrary.dd_SecureCollaborationQInterface instance = dd_SecureCollaborationQLibrary.dd_SecureCollaborationQInterface.INSTANCE;
        // 获取当前时间
        long start = System.currentTimeMillis();
        instance.dealData("C:\\Users\\uu\\Desktop\\rawData.txt");
        // 以毫秒为单位输出时间
        long end = System.currentTimeMillis();
        System.out.println("预处理数据耗时：" + (end - start) + "ms");
    }

    // SecureCollaborationQ用于查询数据
    private static void SecureCollaborationQ2() {
        dd_SecureCollaborationQLibrary.dd_SecureCollaborationQInterface instance = dd_SecureCollaborationQLibrary.dd_SecureCollaborationQInterface.INSTANCE;
        long start = System.currentTimeMillis();
        int ret = instance.secureCollaborationQ("C:\\Users\\uu\\Desktop\\query.txt", "C:\\Users\\uu\\Desktop\\result.txt");
        long end = System.currentTimeMillis();
        System.out.println("查询数据耗时：" + (end - start) + "ms");

        if(ret != ETPSSConstant.SUCCESS){
            System.err.println("查询失败！");
        }
    }

    // ReverseSQ用于预处理数据
    private static void JNA_TEST_ReverseSQ1() {
        dd_ReverseSQLibrary.dd_ReverseSQInterface instance = dd_ReverseSQLibrary.dd_ReverseSQInterface.INSTANCE;
        // 先调用dealData预处理数据，只用处理一次，以后可以直接查询
        instance.dealData("C:\\Users\\uu\\Desktop\\data.txt", "C:\\Users\\uu\\Desktop\\data2.txt");
    }

    // ReverseSQ用于查询数据
    private static void JNA_TEST_ReverseSQ2() {
        dd_ReverseSQLibrary.dd_ReverseSQInterface instance = dd_ReverseSQLibrary.dd_ReverseSQInterface.INSTANCE;
        int ret = instance.reverseSQ("C:\\Users\\uu\\Desktop\\query2.txt", "C:\\Users\\uu\\Desktop\\result.txt");
        if(ret != ETPSSConstant.SUCCESS){
            System.err.println("查询失败！");
        }
    }

    private static void JNA_TEST_ScComputing(){
        ScComputingLibrary.ScComputingInterface instance = ScComputingLibrary.ScComputingInterface.INSTANCE;

        int ret = instance.deal("split", "D:\\study\\code\\github_project\\JNA_privacy_tools\\data\\avg\\data.txt", "D:\\study\\code\\github_project\\JNA_privacy_tools\\data\\avg\\res.txt");
        if(ret != ETPSSConstant.SUCCESS){
            System.err.println("执行协同计算失败");
        }

    }

    private static void JNA_TEST_SKQ(){
        SKQLibrary.SKQInterface instance = SKQLibrary.SKQInterface.INSTANCE;
        SKQLibrary.Structures.DataOwner data = new SKQLibrary.Structures.DataOwner();
        instance.init_constant();
        int initResult = instance.init_algo("D:\\study\\code\\ClionProject\\security_keyword_query\\data\\data.txt",data);
        if (initResult !=  ETPSSConstant.SUCCESS) {
            System.err.println("Failed to initialize algorithm");
        }
        int queryResult = instance.query_algo(data,"D:\\study\\code\\ClionProject\\security_keyword_query\\data\\query.txt","D:\\study\\code\\ClionProject\\security_keyword_query\\data\\res.txt");
        if (queryResult !=  ETPSSConstant.SUCCESS) {
            System.err.println("Failed to initialize algorithm");
        }
        int freeResult = instance.free_algo(data);
        if (freeResult !=  ETPSSConstant.SUCCESS) {
            System.err.println("Failed to initialize algorithm");
        }
    }

    private static void JNA_TEST_SKYLINE(){
        /**
         * SKYLINE内容
         * */
        SkylineLibrary.SkylineInterface skyline = SkylineLibrary.SkylineInterface.INSTANCE;
        SkylineLibrary.Structures.skyline_data data =  new SkylineLibrary.Structures.skyline_data();
        SkylineLibrary.Structures.rtree tree = new  SkylineLibrary.Structures.rtree();
        skyline.init_algo("",data,tree);
        skyline.query_algo(data,tree,"");
        skyline.free_algo(data,tree);

    }
    private static void JNA_TEST_SSQ(){
        /*JNA 测试SSQ的内容*/
        SSQLibrary.SSQInterface instance = SSQLibrary.SSQInterface.INSTANCE;
        SSQLibrary.Structures.SSQ_data data = new SSQLibrary.Structures.SSQ_data();

        SSQLibrary.Structures.SSQ_data kArr = new SSQLibrary.Structures.SSQ_data();

        SSQLibrary.Structures.kd_tree tree = new SSQLibrary.Structures.kd_tree();
        // 初始化算法
        int initResult = instance.init_algo("D:\\study\\code\\ClionProject\\security_similarity_query\\data\\SSQ_data_file.txt", data, tree, kArr);
        if (initResult !=  ETPSSConstant.SUCCESS) {
            System.err.println("Failed to initialize algorithm");
            return;
        }

        // 执行查询算法
        int result = instance.query_algo(data, tree, kArr, "D:\\study\\code\\ClionProject\\security_similarity_query\\data\\search_req.txt", "D:\\study\\code\\ClionProject\\security_similarity_query\\data\\search_res.txt");

        if (result != ETPSSConstant.SUCCESS) {
            System.err.println("Failed to initialize algorithm");
            return;
        }
        // 释放资源
        int freeResult = instance.free_algo(data, tree, kArr);
        if (freeResult !=  ETPSSConstant.SUCCESS) {
            System.err.println("Failed to free algorithm resources");
        }
    }
    private static void JNA_TEST_RSQ(){
        /*JNA 测试SSQ的内容*/
        RSQLibrary.RSQInterface instance = RSQLibrary.RSQInterface.INSTANCE;
        RSQLibrary.Structures.RSQ_data data = new RSQLibrary.Structures.RSQ_data();

        RSQLibrary.Structures.mr_tree tree = new RSQLibrary.Structures.mr_tree();
        // 初始化算法
        int initResult = instance.init_algo("D:\\study\\code\\ClionProject\\reverse_similarity_query\\data\\RSQ_DATA_FILE.txt", data, tree);
        if (initResult !=  ETPSSConstant.SUCCESS) {
            System.err.println("Failed to initialize algorithm");
            return;
        }

        // 执行查询算法
        int result = instance.query_algo(data, tree, "D:\\study\\code\\ClionProject\\reverse_similarity_query\\data\\REQ_DATA_FILE.txt", "D:\\study\\code\\ClionProject\\reverse_similarity_query\\data\\RESP_DATA_FILE.txt");
        if (result != ETPSSConstant.SUCCESS) {
            System.err.println("Failed to initialize algorithm");
            return;
        }
        // 释放资源
        int freeResult = instance.free_algo(data, tree);
        if (freeResult !=  ETPSSConstant.SUCCESS) {
            System.err.println("Failed to free algorithm resources");
        }
    }
    private static void JNA_TEST_RangeSearch(){
        /*JNA 测试SSQ的内容*/
        RangeSearchLibrary.RangeSearchInterface instance = RangeSearchLibrary.RangeSearchInterface.INSTANCE;
        RangeSearchLibrary.Structures.PtreeB_data data = new RangeSearchLibrary.Structures.PtreeB_data();

        RangeSearchLibrary.Structures.kd_tree tree = new RangeSearchLibrary.Structures.kd_tree();
        // 初始化算法
        int initResult = instance.init_algo("D:\\study\\code\\ClionProject\\PtreeB\\data\\data.txt", data, tree);
        if (initResult !=  ETPSSConstant.SUCCESS) {
            System.err.println("Failed to initialize algorithm");
            return;
        }

        // 执行查询算法
        int result = instance.query_algo(data, tree, "D:\\study\\code\\ClionProject\\PtreeB\\data\\search_req.txt", "D:\\study\\code\\ClionProject\\PtreeB\\data\\search_res.txt");
        if (result != ETPSSConstant.SUCCESS) {
            System.err.println("Failed to initialize algorithm");
            return;
        }
        // 释放资源
        int freeResult = instance.free_algo(data, tree);
        if (freeResult !=  ETPSSConstant.SUCCESS) {
            System.err.println("Failed to free algorithm resources");
        }
    }

}
