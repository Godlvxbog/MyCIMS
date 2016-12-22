package com.zju.model;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/12/22.
 */
public class ViewObject {

    HashMap<String,Object> vo = new HashMap<>();

    public void put(String String,Object object){
        vo.put(String,object);
    }
    public Object get(String s){
        return vo.get(s);
    }
}
