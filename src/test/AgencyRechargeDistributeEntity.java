import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author : Administrator
 * @date : 2018/6/27 0027 15:22
 * @description : 代充值资金分发接口
 */
public class AgencyRechargeDistributeEntity {
    /**
     * 签名摘要
     */
    @FieldValidate(status = FieldValidate.Status.NotEmpty,message = "签名摘要不能为空！")
    private String key;
    /**
     * 团贷网用户名
     */
//    @JSONField(name = "td_user_name")
            @FieldValidate(status = FieldValidate.Status.NotEmpty,message = "团贷网用户名不能为空")
    private String tdUserName;
    /**
     * 资产端账户唯一编号
     */
//    @JSONField(name="oid_partner")
    private String oidPartner;
    /**
     * 出款方账号
     */
//    @JSONField(name = "user_id")
    private String userId;
    /**
     * 分发批次号
     */
    @JSONField(name = "batch_id")
    private String batchId;
    /**
     * 分发总金额（元）保留两位小数 起初BigDecimal类型 反射会丢失精度 so，用String来。然后看文档需要啥格式在JSON转换成对应得格式
     */
    @FieldValidate(status = FieldValidate.Status.NoNegativeDecimal,message = "总金额不能为负数")
    private String totalAmount;
    /**
     * 客户端ip
     */
    private String userIp;
    /**
     * 用户分发列表
     */
    @FieldValidate(status = FieldValidate.Status.NotEmpty,message = "用户分发列表不能为空")
    private List<DetailList> detailList;

    public class DetailList{
        /**
         * 请求号
         */
        @FieldValidate(status = FieldValidate.Status.NotEmpty,message = "请求号不能为空")
        private String requestNo;
        /**
         * 用户编号
         */
        @FieldValidate(status = FieldValidate.Status.NotEmpty,message = "用户编号不能为空字符串")
        private String userId;
        /**
         * 金额（元）保留两位小数 起初BigDecimal类型 反射会丢失精度 so，用String来。然后看文档需要啥格式在JSON转换成对应得格式
         */
        @FieldValidate(status = FieldValidate.Status.NoNegativeDecimal,message = "金额不能为非负数")
        private String amount;

        public String getRequestNo() {
            return requestNo;
        }

        public void setRequestNo(String requestNo) {
            this.requestNo = requestNo;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTdUserName() {
        return tdUserName;
    }

    public void setTdUserName(String tdUserName) {
        this.tdUserName = tdUserName;
    }

    public String getOidPartner() {
        return oidPartner;
    }

    public void setOidPartner(String oidPartner) {
        this.oidPartner = oidPartner;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public List<DetailList> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<DetailList> detailList) {
        this.detailList = detailList;
    }
}
