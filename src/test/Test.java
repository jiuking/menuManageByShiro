import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        AgencyRechargeDistributeEntity agency = new AgencyRechargeDistributeEntity();
        agency.setBatchId("batchId");
        agency.setKey("asdf");
        agency.setTdUserName("asdf");
        agency.setTotalAmount("0");
        AgencyRechargeDistributeEntity.DetailList detailList =  agency.new DetailList();
        detailList.setRequestNo("request");
        detailList.setAmount("0.11");
        detailList.setUserId("上的");

        AgencyRechargeDistributeEntity.DetailList detailList2 =  agency.new DetailList();
        detailList2.setRequestNo("request");
        detailList2.setAmount("0.11");
//        detailList2.setUserId("上的");

        List<AgencyRechargeDistributeEntity.DetailList> detailLists = new ArrayList<>();
        detailLists.add(detailList);
        detailLists.add(detailList2);

        agency.setDetailList(detailLists);
        System.out.println(CheckObjEmptyUtil.checkField(agency));
    }

    }
