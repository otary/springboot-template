package cn.chenzw.springboot.infrastructure.domain.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 系统日志
 *
 * @author chenzw
 */
@Table(name = "sys_log")
public class SysLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 所属应用
     */
    private String appName;

    /**
     * 所属模块
     */
    private String moduleName;

    /**
     * http请求方法
     */
    private String httpMethod;

    /**
     * http请求链接
     */
    @Column(name = "request_uri")
    private String requestURI;

    /**
     * http请求参数
     */
    private String requestQueryString;

    /**
     * http请求body内容
     */
    private String requestBody;

    /**
     * 操作人
     */
    private Long operator;

    /**
     * 操作人姓名
     */
    private String operatorName;

    /**
     * 客户端IP
     */
    private String clientId;

    /**
     * 操作起始时间
     */
    private Date startTime;

    /**
     * 操作结束时间
     */
    private Date finishTime;

    /**
     * 操作耗时（单位: 毫秒）
     */
    private Long cost;

    /**
     * 操作结果
     */
    private Boolean isSuccess;

    /**
     * 异常信息
     */
    private String exMsg;

    /**
     * 返回值
     */
    private String returning;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getRequestURI() {
        return requestURI;
    }

    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public Long getOperator() {
        return operator;
    }

    public void setOperator(Long operator) {
        this.operator = operator;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getExMsg() {
        return exMsg;
    }

    public void setExMsg(String exMsg) {
        this.exMsg = exMsg;
    }

    public String getReturning() {
        return returning;
    }

    public void setReturning(String returning) {
        this.returning = returning;
    }

    public String getRequestQueryString() {
        return requestQueryString;
    }

    public void setRequestQueryString(String requestQueryString) {
        this.requestQueryString = requestQueryString;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    @Override
    public String toString() {
        return "SysLogEntity{" + "id=" + id + ", appName='" + appName + '\'' + ", moduleName='" + moduleName + '\''
                + ", httpMethod='" + httpMethod + '\'' + ", requestURI='" + requestURI + '\'' + ", requestQueryString='"
                + requestQueryString + '\'' + ", requestBody='" + requestBody + '\'' + ", operator=" + operator
                + ", operatorName='" + operatorName + '\'' + ", clientId='" + clientId + '\'' + ", startTime="
                + startTime + ", finishTime=" + finishTime + ", cost=" + cost + ", isSuccess=" + isSuccess + ", exMsg='"
                + exMsg + '\'' + ", returning='" + returning + '\'' + '}';
    }

}
