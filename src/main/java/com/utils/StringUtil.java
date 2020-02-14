package com.utils;

public class StringUtil {

    // 传入文件名，返回文件类型 eg: 12.12.jpg  => jpg
    public static String getFileType(String fileName){

       return StringUtil.parseFileName(fileName);

    }


    private static String parseFileName(String res){
        int resR=res.indexOf(".");
        if(resR>-1){
            res=res.substring(resR+1);
           return StringUtil.parseFileName(res);
        }else {
            return res;
        }
    }

}
