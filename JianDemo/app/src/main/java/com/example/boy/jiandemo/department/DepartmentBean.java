package com.example.boy.jiandemo.department;

import java.io.Serializable;
import java.util.List;

/**
 * author：ZhouJian
 * date：2018/7/23 14:41
 * describe：
 */
public class DepartmentBean implements Serializable {



    private DataBean data;
    private String id;
    private String state;
    private String label;
    private String parentId;
    private String parentLabel;
    private List<DepartmentBean> children;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentLabel() {
        return parentLabel;
    }

    public void setParentLabel(String parentLabel) {
        this.parentLabel = parentLabel;
    }

    public List<DepartmentBean> getChildren() {
        return children;
    }

    public void setChildren(List<DepartmentBean> children) {
        this.children = children;
    }

    public static class DataBean implements Serializable {
        /**
         * checked : false
         * children : []
         * fclass : 2
         * id : 920701
         * isLeaf : false
         * leaf : false
         * parentId : 2A6CDE6A327D40DCAB9000A4274135D2
         * text : 陈军
         */

        private boolean checked;
        private String fclass;
        private String id;
        private boolean isLeaf;
        private boolean leaf;
        private String parentId;
        private String text;
        private List<DepartmentBean> children;

        public boolean isChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }

        public String getFclass() {
            return fclass;
        }

        public void setFclass(String fclass) {
            this.fclass = fclass;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isIsLeaf() {
            return isLeaf;
        }

        public void setIsLeaf(boolean isLeaf) {
            this.isLeaf = isLeaf;
        }

        public boolean isLeaf() {
            return leaf;
        }

        public void setLeaf(boolean leaf) {
            this.leaf = leaf;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public List<?> getChildren() {
            return children;
        }

        public void setChildren(List<DepartmentBean> children) {
            this.children = children;
        }
    }
}
