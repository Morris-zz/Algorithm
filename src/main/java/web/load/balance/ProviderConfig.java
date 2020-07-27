package web.load.balance;

import java.io.Serializable;

/**
 * @Author: morris
 * @Date: 2020/7/27 16:44
 * @description
 * @reviewer
 */

@SuppressWarnings("AlibabaCommentsMustBeJavadocFormat")
public class ProviderConfig implements Serializable {
    private static final long serialVersionUID = 1;
    /**
     * 通信host
     */
    private String host;
    /**
     * 通信端口
     */
    private Integer port;

    /**
     * 请求接口名称
     */
    private String interfaceName;
    /**
     * 请求方法
     */
    private String[] methods;
    /**
     * 应用名称
     */
    private String application;
    /**
     * 权重
     */
    private int weight;
    /**
     * 调用时间
     */
    private int callTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String[] getMethods() {
        return methods;
    }

    public void setMethods(String[] methods) {
        this.methods = methods;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCallTime() {
        return callTime;
    }

    public void setCallTime(int callTime) {
        this.callTime = callTime;
    }
}
