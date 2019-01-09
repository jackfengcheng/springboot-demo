package com.xwtech.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jack on 2019/1/9.
 */
@Entity
@Table(name = "t_log")
public class Log  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "uri")
    private String uri;

    @Column(name = "method")
    private String method;

    @Column(name = "remoteAddr")
    private String remoteAddr;

    @Column(name = "typeName")
    private String typeName;

    @Column(name = "timeMillis")
    private long timeMillis;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public long getTimeMillis() {
        return timeMillis;
    }

    public void setTimeMillis(long timeMillis) {
        this.timeMillis = timeMillis;
    }
}
