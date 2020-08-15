package com.weds.edpf.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeEntity {
    @JsonIgnore
    private String root;
    private String id;
    private String pid;
    private String name;
    private String icon;
    private String url;
    private Object entity;
    private boolean leaf;
    private List<TreeNodeEntity> children = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public Object getEntity() {
        return entity;
    }

    public void setEntity(Object entity) {
        this.entity = entity;
    }

    public List<TreeNodeEntity> getChildren() {
        return children;
    }

    public TreeNodeEntity(String root) {
        this.id = root;
        this.root = root;
    }

    public TreeNodeEntity(String root, Object entity) {
        this.id = root;
        this.root = root;
        this.entity = entity;
    }

    public TreeNodeEntity(String id, String pid, String name, String icon, String url) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.icon = icon;
        this.url = url;
    }

    public TreeNodeEntity(String id, String pid, String name, String icon, String url, Object entity) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.icon = icon;
        this.url = url;
        this.entity = entity;
    }

    public TreeNodeEntity(String id, String name, boolean leaf) {
        this.id = id;
        this.name = name;
        this.leaf = leaf;
    }

    public TreeNodeEntity(String id, String name, boolean leaf, Object entity) {
        this.id = id;
        this.name = name;
        this.leaf = leaf;
        this.entity = entity;
    }

    public void add(TreeNodeEntity node) {//递归添加节点
        node.root = this.root;
        if (this.root.equals(node.pid)) {
            this.children.add(node);
            this.leaf = true;
        } else if (node.pid.equals(this.id)) {
            this.children.add(node);
            this.leaf = true;
        } else {
            for (TreeNodeEntity treeNodeEntity : children) {
                treeNodeEntity.add(node);
            }
        }
    }
}
