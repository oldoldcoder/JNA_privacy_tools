package com.xd.st.common;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;
@Structure.FieldOrder({"x","r1","r2"})
public class Cli extends Structure {
    public Pointer x;
    public Pointer r1;
    public Pointer r2;

    public Cli() {
        super();
    }
    public static class ByReference extends Cli implements Structure.ByReference {
    }
}
