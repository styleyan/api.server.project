package com.isyxf.blog.entity;

import java.util.Date;

public class Link {
    private Integer id;

    private Date gmtCreate;

    private Date gtmModify;

    private String websiteName;

    private String websiteUrl;

    private String desc;

    private String https;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGtmModify() {
        return gtmModify;
    }

    public void setGtmModify(Date gtmModify) {
        this.gtmModify = gtmModify;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHttps() {
        return https;
    }

    public void setHttps(String https) {
        this.https = https;
    }

    @Override
    public String toString() {
        return "Link{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", gtmModify=" + gtmModify +
                ", websiteName='" + websiteName + '\'' +
                ", websiteUrl='" + websiteUrl + '\'' +
                ", desc='" + desc + '\'' +
                ", https='" + https + '\'' +
                '}';
    }
}
