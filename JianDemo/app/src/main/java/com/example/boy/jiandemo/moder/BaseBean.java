package com.example.boy.jiandemo.moder;

/**
 *
 * 该类是所有bean需要继承的，因为有用共同的 c,m ,o ,e
 */

public class BaseBean<T> {

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;
    /**
     * c : 1
     * m : 查询成功
     * o : {"kecheng":[{"id":"1","cou_title":"课程1","cou_content":"辅导辅导","cou_img":null,"add_time":null,"cou_view":"0","state":"1"},{"id":"2","cou_title":"课程2","cou_content":"发的发的发的","cou_img":null,"add_time":null,"cou_view":"0","state":"1"}],"music":[{"id":"1","title":"好好玩音乐","img":null,"state":"1"},{"id":"2","title":"好好玩阅读","img":null,"state":"1"},{"id":"3","title":"好好玩数学","img":null,"state":"1"}],"lunbo":[{"id":"1","hour_conf_id":"1","img":null,"url":null,"state":"1"}]}
     * e :
     */
    private int c;
    private String m;
    private T o;

//    public String getE() {
//        return e;
//    }
//
//    public void setE(String e) {
//        this.e = e;
//    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public T getO() {
        return o;
    }

    public void setO(T o) {
        this.o = o;
    }
}
