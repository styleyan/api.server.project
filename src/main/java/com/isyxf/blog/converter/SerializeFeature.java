package com.isyxf.blog.converter;

/**
 * Created by guolongcang on 16/11/24.
 */
public class SerializeFeature {

    public final static int WRITE_NULL_MAP_VALUE = 1;

    public static boolean hasFeature(int flag, int feature) {
        // TODO: 这里需要做为空判断
        if ((flag & feature) == feature){
            return true;
        }

        return false;
    }

}
