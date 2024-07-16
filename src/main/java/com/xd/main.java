package com.xd;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;
import com.xd.library.*;
import com.xd.util.constant.ETPSSConstant;

/**测试JNA内容的效果*/
public class main {
    public static void main(String[] args) {
//        System.setProperty("jna.debug_load", "true");
//        System.setProperty("jna.debug_load.jna", "true");

        JNA_TEST_DD_SKQ();
    }

    private static void JNA_TEST_DD_SKYLINE(){
        DD_SKYLINELibrary.DD_SKYLINEInterface instance = DD_SKYLINELibrary.DD_SKYLINEInterface.INSTANCE;
        DD_SKYLINELibrary.Structures.DrqDataSet dataSet = new DD_SKYLINELibrary.Structures.DrqDataSet();

        int initResult = instance.init_algo(dataSet,"D:\\study\\code\\ClionProject\\dd_skyline\\data\\SKYLINE_DATA_FILE.txt");
        if (initResult !=  ETPSSConstant.SUCCESS) {
            System.err.println("Failed to initialize algorithm");
        }
        int queryResult = instance.query_algo(dataSet,"D:\\study\\code\\ClionProject\\dd_skyline\\data\\SKYLINE_QUERY_RANGE_FILE.txt",
                "D:\\study\\code\\ClionProject\\dd_skyline\\data\\SKYLINE_QUERY_POINT_Y_FILE.txt",
                "D:\\study\\code\\ClionProject\\dd_skyline\\data\\SKYLINE_RES_FILE.txt");
        if (queryResult !=  ETPSSConstant.SUCCESS) {
            System.err.println("Failed to query algorithm");
        }
        int freeResult = instance.free_algo(dataSet);
        if (freeResult !=  ETPSSConstant.SUCCESS) {
            System.err.println("Failed to free algorithm");
        }
    }


    private static void JNA_TEST_DD_SKQ(){
        DD_SKQLibrary.DD_SKQInterface instance = DD_SKQLibrary.DD_SKQInterface.INSTANCE;
        DD_SKQLibrary.Structures.DD_SKQDataSet dataSet = new DD_SKQLibrary.Structures.DD_SKQDataSet();

        int initResult = instance.init_algo("D:\\study\\code\\ClionProject\\dd_SKQ\\data\\data.txt",dataSet);
        if (initResult !=  ETPSSConstant.SUCCESS) {
            System.err.println("Failed to initialize algorithm");
        }
        int queryResult = instance.query_algo(dataSet,"D:\\study\\code\\ClionProject\\dd_SKQ\\data\\query.txt","D:\\study\\code\\ClionProject\\dd_SKQ\\data\\res.txt");
        if (queryResult !=  ETPSSConstant.SUCCESS) {
            System.err.println("Failed to query algorithm");
        }
        int freeResult = instance.free_algo(dataSet);
        if (freeResult !=  ETPSSConstant.SUCCESS) {
            System.err.println("Failed to free algorithm");
        }
    }
    private static void JNA_TEST_DRQ(){
        DRQLibrary.DRQInterface instance = DRQLibrary.DRQInterface.INSTANCE;
        DRQLibrary.Structures.DrqDataSet dataSet = new DRQLibrary.Structures.DrqDataSet();

        int initResult = instance.init_algo(dataSet,"D:\\study\\code\\ClionProject\\dstributed_range_query\\data\\DRQ_DATA_FILE.txt");
        if (initResult !=  ETPSSConstant.SUCCESS) {
            System.err.println("Failed to initialize algorithm");
        }
        int queryResult = instance.query_algo(dataSet,"D:\\study\\code\\ClionProject\\dstributed_range_query\\data\\DRQ_QUERY_FILE.txt","D:\\study\\code\\ClionProject\\dstributed_range_query\\data\\DRQ_RES_FILE.txt");
        if (queryResult !=  ETPSSConstant.SUCCESS) {
            System.err.println("Failed to query algorithm");
        }
        int freeResult = instance.free_algo(dataSet);
        if (freeResult !=  ETPSSConstant.SUCCESS) {
            System.err.println("Failed to free algorithm");
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
        skyline.init_algo("D:\\study\\code\\ClionProject\\skyline\\data\\RSQ_DATA_FILE.txt",data,tree);
        skyline.query_algo(data,tree,"D:\\study\\code\\ClionProject\\skyline\\data\\REQ_DATA_FILE.txt","D:\\study\\code\\ClionProject\\skyline\\data\\RESP_DATA_FILE.txt");

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
