package com.hxt.controlbackend.pojo;

import java.util.List;

public class PermissionRouter {
    private String path;
    private Mata mata;
    private String name;
    private String redirect;
    private List<PermissionRouter> children;

    public PermissionRouter() {
    }

    public PermissionRouter(String path, Mata mata, String name, String redirect, List<PermissionRouter> children) {
        this.path = path;
        this.mata = mata;
        this.name = name;
        this.redirect = redirect;
        this.children = children;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Mata getMata() {
        return mata;
    }

    public void setMata(Mata mata) {
        this.mata = mata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public List<PermissionRouter> getChildren() {
        return children;
    }

    public void setChildren(List<PermissionRouter> children) {
        this.children = children;
    }

    public static class Mata{
        private String title;
        private String icon;
        private Integer rank;
        private Boolean showLink;
        private List<String> roles;
        private List<String> auths;

        public Mata() {
        }

        public Mata(String title, String icon, Integer rank, Boolean showLink, List<String> roles, List<String> auths) {
            this.title = title;
            this.icon = icon;
            this.rank = rank;
            this.showLink = showLink;
            this.roles = roles;
            this.auths = auths;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public Integer getRank() {
            return rank;
        }

        public void setRank(Integer rank) {
            this.rank = rank;
        }

        public Boolean getShowLink() {
            return showLink;
        }

        public void setShowLink(Boolean showLink) {
            this.showLink = showLink;
        }

        public List<String> getRoles() {
            return roles;
        }

        public void setRoles(List<String> roles) {
            this.roles = roles;
        }

        public List<String> getAuths() {
            return auths;
        }

        public void setAuths(List<String> auths) {
            this.auths = auths;
        }
    }
}
