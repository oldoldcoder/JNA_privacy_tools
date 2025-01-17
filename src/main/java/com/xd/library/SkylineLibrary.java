package com.xd.library;


import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.Structure;
import com.xd.st.common.ETPSS;

import java.util.List;

public class SkylineLibrary {

    // 定义JNA接口，映射导出的函数
    public interface SkylineInterface extends Library {
        SkylineInterface INSTANCE = Native.load("SKYLINE", SkylineInterface.class);

        int init_algo(String dataFilePath, Structures.skyline_data data, Structures.rtree tree);

        // 定义query_algo方法，参数为skyline_data结构体指针、rtree结构体指针、查询文件路径
        int query_algo(Structures.skyline_data data, Structures.rtree tree, String queryFilePath,String resultFilePath);

        // 定义free_algo方法，参数为skyline_data结构体指针、rtree结构体指针
        int free_algo(Structures.skyline_data data, Structures.rtree tree);

    }

    // 定义结构体
    public static class Structures {

        public static class skyline_data extends Structure {
            public int dim;
            public int n;
            public Pointer x_data;  // set_x**

            @Override
            protected List<String> getFieldOrder() {
                return List.of("dim", "n", "x_data");
            }

            public static class ByReference extends skyline_data implements Structure.ByReference {}
            public static class ByValue extends skyline_data implements Structure.ByValue {}
        }

        public static class rtree extends Structure {
            public Pointer root;

            @Override
            protected List<String> getFieldOrder() {
                return List.of("root");
            }

            public static class ByReference extends rtree implements Structure.ByReference {}
            public static class ByValue extends rtree implements Structure.ByValue {}
        }


    }
}
