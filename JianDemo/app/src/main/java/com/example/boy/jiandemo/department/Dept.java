package com.example.boy.jiandemo.department;

/**
 * author：ZhouJian
 * date：2015/10/9 18:14
 * describe：部门类（继承Node），此处的泛型是String因为ID和parentID都为int
 * ，如果为Integer传入泛型Integer即可
 */
public class Dept extends Node<String>{

    private String id;//部门ID
    private String parentId;//父亲节点ID
    private String name;//部门名称

    public Dept() {
    }

    public Dept(String id, String parentId, String name) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
    }

    /**
     * 此处返回节点ID
     * @return
     */
    @Override
    public String get_id() {
        return id;
    }

    /**
     * 此处返回父亲节点ID
     * @return
     */
    @Override
    public String get_parentId() {
        return parentId;
    }

    @Override
    public String get_label() {
        return name;
    }

    @Override
    public boolean parent(Node dest) {
        if (id .equals(dest.get_parentId().toString())){
            return true;
        }
        return false;
    }

    @Override
    public boolean child(Node dest) {
        if (parentId .equals(dest.get_id().toString())){
            return true;
        }
        return false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
