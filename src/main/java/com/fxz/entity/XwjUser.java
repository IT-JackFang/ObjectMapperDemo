package com.fxz.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 描述：
 *
 * @author Fang
 * @date 2021-02-18 09:12:06
 */
public class XwjUser implements Serializable {

    private static final long serialVersionUID = -1868367275624799861L;

    private int id;
    private String message;
    private Date sendTime;
    private String NodeName;
    private List<Integer> intList;

    public XwjUser() {
    }

    public XwjUser(int id, String message, Date sendTime) {
        this.id = id;
        this.message = message;
        this.sendTime = sendTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getNodeName() {
        return NodeName;
    }

    public void setNodeName(String nodeName) {
        NodeName = nodeName;
    }

    public List<Integer> getIntList() {
        return intList;
    }

    public void setIntList(List<Integer> intList) {
        this.intList = intList;
    }

    @Override
    public String toString() {
        return "{\"XwjUser\":{"
                + "\"id\":"
                + id
                + ",\"message\":\""
                + message + '\"'
                + ",\"sendTime\":\""
                + sendTime + '\"'
                + ",\"intList\":"
                + intList
                + "}}";
    }
}
