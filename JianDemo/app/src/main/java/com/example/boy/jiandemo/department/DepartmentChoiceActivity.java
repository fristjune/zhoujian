package com.example.boy.jiandemo.department;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.example.boy.jiandemo.R;
import com.example.boy.jiandemo.ThreadUtils;
import com.example.boy.jiandemo.ToastUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * author：ZhouJian
 * date：2018/7/23 15:51
 * describe：选择部门
 */
public class DepartmentChoiceActivity extends Activity implements NodeTreeAdapter.OnChoiceListener {


    private ListView mListView;
    private NodeTreeAdapter mAdapter;
    private LinkedList<Node> mLinkedList = new LinkedList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_dept_layout);
        Gson gson = new Gson();
        ArrayList<DepartmentBean> departmentBeans = gson.fromJson(json, new TypeToken<List<DepartmentBean>>() {
        }.getType());
        mListView = (ListView) findViewById(R.id.id_tree);
        mAdapter = new NodeTreeAdapter(this, mListView, mLinkedList);
        mAdapter.setParentIsChoice(true);
        mListView.setAdapter(mAdapter);
        mAdapter.setOnChoiceListener(this);
        initData(departmentBeans);


    }

    private void initData(final ArrayList<DepartmentBean> departmentBeans) {
        final List<Node> data = new ArrayList<>();
        ThreadUtils.runOnSubThread(new Runnable() {
            @Override
            public void run() {
                adaData(data, departmentBeans, "0");
                mLinkedList.addAll(NodeHelper.sortNodes(data));
                ThreadUtils.runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter.notifyDataSetChanged();
                    }
                });

            }
        });


    }


    private void adaData(List<Node> data, List<DepartmentBean> results, String parentId) {
        for (DepartmentBean result : results) {
            String orgname = result.getLabel();
            String orgid = result.getId();
            List<DepartmentBean> children = result.getChildren();
            //核心代码--------------------------------------------
            data.add(new Dept(orgid, parentId, orgname));
            //-----------------------------------------------------------
            if (children != null && children.size() > 0) {
                adaData(data, children, orgid);
            }
        }

    }

    @Override
    public void onChoice(String name, String id) {

        ToastUtil.makeToast(this, "name=" + name + "id=" + id);
    }


    private String json = "[\n" +
            "    {\n" +
            "        \"children\": [\n" +
            "            {\n" +
            "                \"children\": [\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"8DF4A33C39B94651A223259AAAADD808\",\n" +
            "                        \"label\": \"公司领导\",\n" +
            "                        \"orgcode\": \"0101\",\n" +
            "                        \"orgid\": \"8DF4A33C39B94651A223259AAAADD808\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"公司领导\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"企业管理\",\n" +
            "                        \"parentorgid\": \"32318705BD9141E0B7D405B92E14D9B5\",\n" +
            "                        \"pid\": \"32318705BD9141E0B7D405B92E14D9B5\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"7B6F4DD2B7EE42F1AB56E8FAE0ECC3DB\",\n" +
            "                        \"label\": \"网络信息管理中心\",\n" +
            "                        \"orgcode\": \"0102\",\n" +
            "                        \"orgid\": \"7B6F4DD2B7EE42F1AB56E8FAE0ECC3DB\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"网络信息管理中心\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"企业管理\",\n" +
            "                        \"parentorgid\": \"32318705BD9141E0B7D405B92E14D9B5\",\n" +
            "                        \"pid\": \"32318705BD9141E0B7D405B92E14D9B5\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"131BB9146E554A1FBA5449C5B30D9CA4\",\n" +
            "                        \"label\": \"办公室\",\n" +
            "                        \"orgcode\": \"0103\",\n" +
            "                        \"orgid\": \"131BB9146E554A1FBA5449C5B30D9CA4\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"办公室\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"企业管理\",\n" +
            "                        \"parentorgid\": \"32318705BD9141E0B7D405B92E14D9B5\",\n" +
            "                        \"pid\": \"32318705BD9141E0B7D405B92E14D9B5\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"7EA06B7F6B6F43FDB64F8F25C54D8002\",\n" +
            "                        \"label\": \"办公室档案室\",\n" +
            "                        \"orgcode\": \"0104\",\n" +
            "                        \"orgid\": \"7EA06B7F6B6F43FDB64F8F25C54D8002\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"办公室档案室\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"企业管理\",\n" +
            "                        \"parentorgid\": \"32318705BD9141E0B7D405B92E14D9B5\",\n" +
            "                        \"pid\": \"32318705BD9141E0B7D405B92E14D9B5\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"988326B413C546B0A6DE2358F1BDB18A\",\n" +
            "                        \"label\": \"办公室法制办\",\n" +
            "                        \"orgcode\": \"0105\",\n" +
            "                        \"orgid\": \"988326B413C546B0A6DE2358F1BDB18A\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"办公室法制办\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"企业管理\",\n" +
            "                        \"parentorgid\": \"32318705BD9141E0B7D405B92E14D9B5\",\n" +
            "                        \"pid\": \"32318705BD9141E0B7D405B92E14D9B5\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"FF1C10A65EF24779B50293B2462E315F\",\n" +
            "                        \"label\": \"办公室行政事务中心\",\n" +
            "                        \"orgcode\": \"0106\",\n" +
            "                        \"orgid\": \"FF1C10A65EF24779B50293B2462E315F\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"办公室行政事务中心\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"企业管理\",\n" +
            "                        \"parentorgid\": \"32318705BD9141E0B7D405B92E14D9B5\",\n" +
            "                        \"pid\": \"32318705BD9141E0B7D405B92E14D9B5\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"96A9A2CF2A6D4342B7A3DED0D5E1626F\",\n" +
            "                        \"label\": \"企业管理部\",\n" +
            "                        \"orgcode\": \"0107\",\n" +
            "                        \"orgid\": \"96A9A2CF2A6D4342B7A3DED0D5E1626F\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"企业管理部\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"企业管理\",\n" +
            "                        \"parentorgid\": \"32318705BD9141E0B7D405B92E14D9B5\",\n" +
            "                        \"pid\": \"32318705BD9141E0B7D405B92E14D9B5\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"D826E96BAB36450987830279D2C4013E\",\n" +
            "                        \"label\": \"人力资源部\",\n" +
            "                        \"orgcode\": \"0108\",\n" +
            "                        \"orgid\": \"D826E96BAB36450987830279D2C4013E\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"人力资源部\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"企业管理\",\n" +
            "                        \"parentorgid\": \"32318705BD9141E0B7D405B92E14D9B5\",\n" +
            "                        \"pid\": \"32318705BD9141E0B7D405B92E14D9B5\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"84D680CDE4684CF2A9CD5E7BE8B1F939\",\n" +
            "                        \"label\": \"人力资源部职工培训中心\",\n" +
            "                        \"orgcode\": \"0109\",\n" +
            "                        \"orgid\": \"84D680CDE4684CF2A9CD5E7BE8B1F939\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"人力资源部职工培训中心\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"企业管理\",\n" +
            "                        \"parentorgid\": \"32318705BD9141E0B7D405B92E14D9B5\",\n" +
            "                        \"pid\": \"32318705BD9141E0B7D405B92E14D9B5\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"BFD9BA4527D4478CB3763BB78A80B2C0\",\n" +
            "                        \"label\": \"财务管理部\",\n" +
            "                        \"orgcode\": \"0110\",\n" +
            "                        \"orgid\": \"BFD9BA4527D4478CB3763BB78A80B2C0\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"财务管理部\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"企业管理\",\n" +
            "                        \"parentorgid\": \"32318705BD9141E0B7D405B92E14D9B5\",\n" +
            "                        \"pid\": \"32318705BD9141E0B7D405B92E14D9B5\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"id\": \"32318705BD9141E0B7D405B92E14D9B5\",\n" +
            "                \"label\": \"企业管理\",\n" +
            "                \"orgcode\": \"01\",\n" +
            "                \"orgid\": \"32318705BD9141E0B7D405B92E14D9B5\",\n" +
            "                \"orglevel\": 2,\n" +
            "                \"orgname\": \"企业管理\",\n" +
            "                \"orgseq\": \".\",\n" +
            "                \"parentLabel\": \"北京市常务委员会\",\n" +
            "                \"parentorgid\": \"15\",\n" +
            "                \"pid\": \"15\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"children\": [\n" +
            "                    {\n" +
            "                        \"children\": [\n" +
            "                            {\n" +
            "                                \"children\": [\n" +
            "                                    {\n" +
            "                                        \"children\": [],\n" +
            "                                        \"id\": \"0AED4B14F0C94C5097D26A27386A81B2\",\n" +
            "                                        \"label\": \"城东营业所\",\n" +
            "                                        \"orgcode\": \"02010101\",\n" +
            "                                        \"orgid\": \"0AED4B14F0C94C5097D26A27386A81B2\",\n" +
            "                                        \"orglevel\": 5,\n" +
            "                                        \"orgname\": \"城东营业所\",\n" +
            "                                        \"orgseq\": \".\",\n" +
            "                                        \"parentLabel\": \"营业所\",\n" +
            "                                        \"parentorgid\": \"87D881FB689F4791A3F419961A42D413\",\n" +
            "                                        \"pid\": \"87D881FB689F4791A3F419961A42D413\"\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"children\": [],\n" +
            "                                        \"id\": \"64A77425D50844888AAEB13A2956DDB8\",\n" +
            "                                        \"label\": \"城西营业所\",\n" +
            "                                        \"orgcode\": \"02010102\",\n" +
            "                                        \"orgid\": \"64A77425D50844888AAEB13A2956DDB8\",\n" +
            "                                        \"orglevel\": 5,\n" +
            "                                        \"orgname\": \"城西营业所\",\n" +
            "                                        \"orgseq\": \".\",\n" +
            "                                        \"parentLabel\": \"营业所\",\n" +
            "                                        \"parentorgid\": \"87D881FB689F4791A3F419961A42D413\",\n" +
            "                                        \"pid\": \"87D881FB689F4791A3F419961A42D413\"\n" +
            "                                    }\n" +
            "                                ],\n" +
            "                                \"id\": \"87D881FB689F4791A3F419961A42D413\",\n" +
            "                                \"label\": \"营业所\",\n" +
            "                                \"orgcode\": \"020101\",\n" +
            "                                \"orgid\": \"87D881FB689F4791A3F419961A42D413\",\n" +
            "                                \"orglevel\": 4,\n" +
            "                                \"orgname\": \"营业所\",\n" +
            "                                \"orgseq\": \".\",\n" +
            "                                \"parentLabel\": \"江北\",\n" +
            "                                \"parentorgid\": \"2BEAA6430F934BA8AF79910D0B0BFEE5\",\n" +
            "                                \"pid\": \"2BEAA6430F934BA8AF79910D0B0BFEE5\"\n" +
            "                            },\n" +
            "                            {\n" +
            "                                \"children\": [\n" +
            "                                    {\n" +
            "                                        \"children\": [\n" +
            "                                            {\n" +
            "                                                \"children\": [],\n" +
            "                                                \"id\": \"F03D5E40EF9748D9A7715A9390BEA415\",\n" +
            "                                                \"label\": \"政务中心\",\n" +
            "                                                \"orgcode\": \"0201020101\",\n" +
            "                                                \"orgid\": \"F03D5E40EF9748D9A7715A9390BEA415\",\n" +
            "                                                \"orglevel\": 6,\n" +
            "                                                \"orgname\": \"政务中心\",\n" +
            "                                                \"orgseq\": \".\",\n" +
            "                                                \"parentLabel\": \"客户服务部城东客户服务中心\",\n" +
            "                                                \"parentorgid\": \"50F8C2E601B541699D05177AB7D0A4CF\",\n" +
            "                                                \"pid\": \"50F8C2E601B541699D05177AB7D0A4CF\"\n" +
            "                                            },\n" +
            "                                            {\n" +
            "                                                \"children\": [],\n" +
            "                                                \"id\": \"2F955B882B964E0FA20B097D99483DA8\",\n" +
            "                                                \"label\": \"竹楠山\",\n" +
            "                                                \"orgcode\": \"0201020102\",\n" +
            "                                                \"orgid\": \"2F955B882B964E0FA20B097D99483DA8\",\n" +
            "                                                \"orglevel\": 6,\n" +
            "                                                \"orgname\": \"竹楠山\",\n" +
            "                                                \"orgseq\": \".\",\n" +
            "                                                \"parentLabel\": \"客户服务部城东客户服务中心\",\n" +
            "                                                \"parentorgid\": \"50F8C2E601B541699D05177AB7D0A4CF\",\n" +
            "                                                \"pid\": \"50F8C2E601B541699D05177AB7D0A4CF\"\n" +
            "                                            }\n" +
            "                                        ],\n" +
            "                                        \"id\": \"50F8C2E601B541699D05177AB7D0A4CF\",\n" +
            "                                        \"label\": \"客户服务部城东客户服务中心\",\n" +
            "                                        \"orgcode\": \"02010201\",\n" +
            "                                        \"orgid\": \"50F8C2E601B541699D05177AB7D0A4CF\",\n" +
            "                                        \"orglevel\": 5,\n" +
            "                                        \"orgname\": \"客户服务部城东客户服务中心\",\n" +
            "                                        \"orgseq\": \".\",\n" +
            "                                        \"parentLabel\": \"客服部 \",\n" +
            "                                        \"parentorgid\": \"67DBA2D2CFC849EB9E719D0F7B6F30D7\",\n" +
            "                                        \"pid\": \"67DBA2D2CFC849EB9E719D0F7B6F30D7\"\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"children\": [\n" +
            "                                            {\n" +
            "                                                \"children\": [],\n" +
            "                                                \"id\": \"BB941707F9EB4BBA8FF9C60BAA6B3BC8\",\n" +
            "                                                \"label\": \"西门\",\n" +
            "                                                \"orgcode\": \"0201020201\",\n" +
            "                                                \"orgid\": \"BB941707F9EB4BBA8FF9C60BAA6B3BC8\",\n" +
            "                                                \"orglevel\": 6,\n" +
            "                                                \"orgname\": \"西门\",\n" +
            "                                                \"orgseq\": \".\",\n" +
            "                                                \"parentLabel\": \"客户服务部城西客户服务中心\",\n" +
            "                                                \"parentorgid\": \"537CAC74579940D28F28DC326ED82ABC\",\n" +
            "                                                \"pid\": \"537CAC74579940D28F28DC326ED82ABC\"\n" +
            "                                            },\n" +
            "                                            {\n" +
            "                                                \"children\": [],\n" +
            "                                                \"id\": \"9D2A4207FDB64CAFB496614628803A9D\",\n" +
            "                                                \"label\": \"沙岗\",\n" +
            "                                                \"orgcode\": \"0201020202\",\n" +
            "                                                \"orgid\": \"9D2A4207FDB64CAFB496614628803A9D\",\n" +
            "                                                \"orglevel\": 6,\n" +
            "                                                \"orgname\": \"沙岗\",\n" +
            "                                                \"orgseq\": \".\",\n" +
            "                                                \"parentLabel\": \"客户服务部城西客户服务中心\",\n" +
            "                                                \"parentorgid\": \"537CAC74579940D28F28DC326ED82ABC\",\n" +
            "                                                \"pid\": \"537CAC74579940D28F28DC326ED82ABC\"\n" +
            "                                            },\n" +
            "                                            {\n" +
            "                                                \"children\": [],\n" +
            "                                                \"id\": \"096035331CA34DD6B054F494D925746E\",\n" +
            "                                                \"label\": \"高新区\",\n" +
            "                                                \"orgcode\": \"0201020203\",\n" +
            "                                                \"orgid\": \"096035331CA34DD6B054F494D925746E\",\n" +
            "                                                \"orglevel\": 6,\n" +
            "                                                \"orgname\": \"高新区\",\n" +
            "                                                \"orgseq\": \".\",\n" +
            "                                                \"parentLabel\": \"客户服务部城西客户服务中心\",\n" +
            "                                                \"parentorgid\": \"537CAC74579940D28F28DC326ED82ABC\",\n" +
            "                                                \"pid\": \"537CAC74579940D28F28DC326ED82ABC\"\n" +
            "                                            }\n" +
            "                                        ],\n" +
            "                                        \"id\": \"537CAC74579940D28F28DC326ED82ABC\",\n" +
            "                                        \"label\": \"客户服务部城西客户服务中心\",\n" +
            "                                        \"orgcode\": \"02010202\",\n" +
            "                                        \"orgid\": \"537CAC74579940D28F28DC326ED82ABC\",\n" +
            "                                        \"orglevel\": 5,\n" +
            "                                        \"orgname\": \"客户服务部城西客户服务中心\",\n" +
            "                                        \"orgseq\": \".\",\n" +
            "                                        \"parentLabel\": \"客服部 \",\n" +
            "                                        \"parentorgid\": \"67DBA2D2CFC849EB9E719D0F7B6F30D7\",\n" +
            "                                        \"pid\": \"67DBA2D2CFC849EB9E719D0F7B6F30D7\"\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"children\": [],\n" +
            "                                        \"id\": \"A0F866184D1D4C798511BA8D1DA44CAF\",\n" +
            "                                        \"label\": \"客户服务部\",\n" +
            "                                        \"orgcode\": \"02010203\",\n" +
            "                                        \"orgid\": \"A0F866184D1D4C798511BA8D1DA44CAF\",\n" +
            "                                        \"orglevel\": 5,\n" +
            "                                        \"orgname\": \"客户服务部\",\n" +
            "                                        \"orgseq\": \".\",\n" +
            "                                        \"parentLabel\": \"客服部 \",\n" +
            "                                        \"parentorgid\": \"67DBA2D2CFC849EB9E719D0F7B6F30D7\",\n" +
            "                                        \"pid\": \"67DBA2D2CFC849EB9E719D0F7B6F30D7\"\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"children\": [],\n" +
            "                                        \"id\": \"F5981F0F214E4A4C82320C5936928033\",\n" +
            "                                        \"label\": \"客户服务部热线中心\",\n" +
            "                                        \"orgcode\": \"02010204\",\n" +
            "                                        \"orgid\": \"F5981F0F214E4A4C82320C5936928033\",\n" +
            "                                        \"orglevel\": 5,\n" +
            "                                        \"orgname\": \"客户服务部热线中心\",\n" +
            "                                        \"orgseq\": \".\",\n" +
            "                                        \"parentLabel\": \"客服部 \",\n" +
            "                                        \"parentorgid\": \"67DBA2D2CFC849EB9E719D0F7B6F30D7\",\n" +
            "                                        \"pid\": \"67DBA2D2CFC849EB9E719D0F7B6F30D7\"\n" +
            "                                    }\n" +
            "                                ],\n" +
            "                                \"id\": \"67DBA2D2CFC849EB9E719D0F7B6F30D7\",\n" +
            "                                \"label\": \"客服部 \",\n" +
            "                                \"orgcode\": \"020102\",\n" +
            "                                \"orgid\": \"67DBA2D2CFC849EB9E719D0F7B6F30D7\",\n" +
            "                                \"orglevel\": 4,\n" +
            "                                \"orgname\": \"客服部 \",\n" +
            "                                \"orgseq\": \".\",\n" +
            "                                \"parentLabel\": \"江北\",\n" +
            "                                \"parentorgid\": \"2BEAA6430F934BA8AF79910D0B0BFEE5\",\n" +
            "                                \"pid\": \"2BEAA6430F934BA8AF79910D0B0BFEE5\"\n" +
            "                            }\n" +
            "                        ],\n" +
            "                        \"id\": \"2BEAA6430F934BA8AF79910D0B0BFEE5\",\n" +
            "                        \"label\": \"江北\",\n" +
            "                        \"orgcode\": \"0201\",\n" +
            "                        \"orgid\": \"2BEAA6430F934BA8AF79910D0B0BFEE5\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"江北\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"营销管理\",\n" +
            "                        \"parentorgid\": \"C90FCA96D46E425EB7F6E6A672FDDF2B\",\n" +
            "                        \"pid\": \"C90FCA96D46E425EB7F6E6A672FDDF2B\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [\n" +
            "                            {\n" +
            "                                \"children\": [\n" +
            "                                    {\n" +
            "                                        \"children\": [],\n" +
            "                                        \"id\": \"67507E722CFA44E68978FE66A62B5A7D\",\n" +
            "                                        \"label\": \"德山分公司\",\n" +
            "                                        \"orgcode\": \"02020101\",\n" +
            "                                        \"orgid\": \"67507E722CFA44E68978FE66A62B5A7D\",\n" +
            "                                        \"orglevel\": 5,\n" +
            "                                        \"orgname\": \"德山分公司\",\n" +
            "                                        \"orgseq\": \".\",\n" +
            "                                        \"parentLabel\": \"营业所\",\n" +
            "                                        \"parentorgid\": \"6A83DA4F26B64706B16A705BFB638040\",\n" +
            "                                        \"pid\": \"6A83DA4F26B64706B16A705BFB638040\"\n" +
            "                                    }\n" +
            "                                ],\n" +
            "                                \"id\": \"6A83DA4F26B64706B16A705BFB638040\",\n" +
            "                                \"label\": \"营业所\",\n" +
            "                                \"orgcode\": \"020201\",\n" +
            "                                \"orgid\": \"6A83DA4F26B64706B16A705BFB638040\",\n" +
            "                                \"orglevel\": 4,\n" +
            "                                \"orgname\": \"营业所\",\n" +
            "                                \"orgseq\": \".\",\n" +
            "                                \"parentLabel\": \"德山\",\n" +
            "                                \"parentorgid\": \"7304748DCBA749938523E195136E2A65\",\n" +
            "                                \"pid\": \"7304748DCBA749938523E195136E2A65\"\n" +
            "                            },\n" +
            "                            {\n" +
            "                                \"children\": [\n" +
            "                                    {\n" +
            "                                        \"children\": [\n" +
            "                                            {\n" +
            "                                                \"children\": [],\n" +
            "                                                \"id\": \"DD2BAE8E99E8400B93F7B684C5A1CC3B\",\n" +
            "                                                \"label\": \"德山收费厅\",\n" +
            "                                                \"orgcode\": \"0202020101\",\n" +
            "                                                \"orgid\": \"DD2BAE8E99E8400B93F7B684C5A1CC3B\",\n" +
            "                                                \"orglevel\": 6,\n" +
            "                                                \"orgname\": \"德山收费厅\",\n" +
            "                                                \"orgseq\": \".\",\n" +
            "                                                \"parentLabel\": \"德山营业厅\",\n" +
            "                                                \"parentorgid\": \"22F5884AC91B4D8FB6E75483E6B8BE1A\",\n" +
            "                                                \"pid\": \"22F5884AC91B4D8FB6E75483E6B8BE1A\"\n" +
            "                                            },\n" +
            "                                            {\n" +
            "                                                \"children\": [],\n" +
            "                                                \"id\": \"25320FB683F34E77ACE7DA811B8030B7\",\n" +
            "                                                \"label\": \"德山政务客服中心\",\n" +
            "                                                \"orgcode\": \"0202020102\",\n" +
            "                                                \"orgid\": \"25320FB683F34E77ACE7DA811B8030B7\",\n" +
            "                                                \"orglevel\": 6,\n" +
            "                                                \"orgname\": \"德山政务客服中心\",\n" +
            "                                                \"orgseq\": \".\",\n" +
            "                                                \"parentLabel\": \"德山营业厅\",\n" +
            "                                                \"parentorgid\": \"22F5884AC91B4D8FB6E75483E6B8BE1A\",\n" +
            "                                                \"pid\": \"22F5884AC91B4D8FB6E75483E6B8BE1A\"\n" +
            "                                            }\n" +
            "                                        ],\n" +
            "                                        \"id\": \"22F5884AC91B4D8FB6E75483E6B8BE1A\",\n" +
            "                                        \"label\": \"德山营业厅\",\n" +
            "                                        \"orgcode\": \"02020201\",\n" +
            "                                        \"orgid\": \"22F5884AC91B4D8FB6E75483E6B8BE1A\",\n" +
            "                                        \"orglevel\": 5,\n" +
            "                                        \"orgname\": \"德山营业厅\",\n" +
            "                                        \"orgseq\": \".\",\n" +
            "                                        \"parentLabel\": \"营业厅\",\n" +
            "                                        \"parentorgid\": \"A6700CAEDA75444A97EE4718D639107A\",\n" +
            "                                        \"pid\": \"A6700CAEDA75444A97EE4718D639107A\"\n" +
            "                                    }\n" +
            "                                ],\n" +
            "                                \"id\": \"A6700CAEDA75444A97EE4718D639107A\",\n" +
            "                                \"label\": \"营业厅\",\n" +
            "                                \"orgcode\": \"020202\",\n" +
            "                                \"orgid\": \"A6700CAEDA75444A97EE4718D639107A\",\n" +
            "                                \"orglevel\": 4,\n" +
            "                                \"orgname\": \"营业厅\",\n" +
            "                                \"orgseq\": \".\",\n" +
            "                                \"parentLabel\": \"德山\",\n" +
            "                                \"parentorgid\": \"7304748DCBA749938523E195136E2A65\",\n" +
            "                                \"pid\": \"7304748DCBA749938523E195136E2A65\"\n" +
            "                            }\n" +
            "                        ],\n" +
            "                        \"id\": \"7304748DCBA749938523E195136E2A65\",\n" +
            "                        \"label\": \"德山\",\n" +
            "                        \"orgcode\": \"0202\",\n" +
            "                        \"orgid\": \"7304748DCBA749938523E195136E2A65\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"德山\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"营销管理\",\n" +
            "                        \"parentorgid\": \"C90FCA96D46E425EB7F6E6A672FDDF2B\",\n" +
            "                        \"pid\": \"C90FCA96D46E425EB7F6E6A672FDDF2B\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [\n" +
            "                            {\n" +
            "                                \"children\": [],\n" +
            "                                \"id\": \"E423CEA6DD5048A6BE946520F8EB86BD\",\n" +
            "                                \"label\": \"北京市党员群众有限公司营业所\",\n" +
            "                                \"orgcode\": \"020301\",\n" +
            "                                \"orgid\": \"E423CEA6DD5048A6BE946520F8EB86BD\",\n" +
            "                                \"orglevel\": 4,\n" +
            "                                \"orgname\": \"北京市党员群众有限公司营业所\",\n" +
            "                                \"orgseq\": \".\",\n" +
            "                                \"parentLabel\": \"北京市党员群众有限公司\",\n" +
            "                                \"parentorgid\": \"DA2CF422A25C4899B7E55941DD016A8A\",\n" +
            "                                \"pid\": \"DA2CF422A25C4899B7E55941DD016A8A\"\n" +
            "                            },\n" +
            "                            {\n" +
            "                                \"children\": [],\n" +
            "                                \"id\": \"1450E4CA98E44D8B9F4D55E5AD43E7C8\",\n" +
            "                                \"label\": \"北京市党员群众有限公司收费厅\",\n" +
            "                                \"orgcode\": \"020302\",\n" +
            "                                \"orgid\": \"1450E4CA98E44D8B9F4D55E5AD43E7C8\",\n" +
            "                                \"orglevel\": 4,\n" +
            "                                \"orgname\": \"北京市党员群众有限公司收费厅\",\n" +
            "                                \"orgseq\": \".\",\n" +
            "                                \"parentLabel\": \"北京市党员群众有限公司\",\n" +
            "                                \"parentorgid\": \"DA2CF422A25C4899B7E55941DD016A8A\",\n" +
            "                                \"pid\": \"DA2CF422A25C4899B7E55941DD016A8A\"\n" +
            "                            }\n" +
            "                        ],\n" +
            "                        \"id\": \"DA2CF422A25C4899B7E55941DD016A8A\",\n" +
            "                        \"label\": \"北京市党员群众有限公司\",\n" +
            "                        \"orgcode\": \"0203\",\n" +
            "                        \"orgid\": \"DA2CF422A25C4899B7E55941DD016A8A\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"北京市党员群众有限公司\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"营销管理\",\n" +
            "                        \"parentorgid\": \"C90FCA96D46E425EB7F6E6A672FDDF2B\",\n" +
            "                        \"pid\": \"C90FCA96D46E425EB7F6E6A672FDDF2B\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"id\": \"C90FCA96D46E425EB7F6E6A672FDDF2B\",\n" +
            "                \"label\": \"营销管理\",\n" +
            "                \"orgcode\": \"02\",\n" +
            "                \"orgid\": \"C90FCA96D46E425EB7F6E6A672FDDF2B\",\n" +
            "                \"orglevel\": 2,\n" +
            "                \"orgname\": \"营销管理\",\n" +
            "                \"orgseq\": \".\",\n" +
            "                \"parentLabel\": \"北京市常务委员会\",\n" +
            "                \"parentorgid\": \"15\",\n" +
            "                \"pid\": \"15\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"children\": [\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"660658E93E1A453E8618E07934356CBC\",\n" +
            "                        \"label\": \"管理部\",\n" +
            "                        \"orgcode\": \"0501\",\n" +
            "                        \"orgid\": \"660658E93E1A453E8618E07934356CBC\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"管理部\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"生产管理\",\n" +
            "                        \"parentorgid\": \"76526897D5844C32B0E2CC9CBA939E50\",\n" +
            "                        \"pid\": \"76526897D5844C32B0E2CC9CBA939E50\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"459F61B8696D47E1A77321E7ECC2FAA6\",\n" +
            "                        \"label\": \"管理部水表检定站\",\n" +
            "                        \"orgcode\": \"0502\",\n" +
            "                        \"orgid\": \"459F61B8696D47E1A77321E7ECC2FAA6\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"管理部水表检定站\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"生产管理\",\n" +
            "                        \"parentorgid\": \"76526897D5844C32B0E2CC9CBA939E50\",\n" +
            "                        \"pid\": \"76526897D5844C32B0E2CC9CBA939E50\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"56E3E4B3D28D4268A4E4744D806861DA\",\n" +
            "                        \"label\": \"稽查队\",\n" +
            "                        \"orgcode\": \"0503\",\n" +
            "                        \"orgid\": \"56E3E4B3D28D4268A4E4744D806861DA\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"稽查队\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"生产管理\",\n" +
            "                        \"parentorgid\": \"76526897D5844C32B0E2CC9CBA939E50\",\n" +
            "                        \"pid\": \"76526897D5844C32B0E2CC9CBA939E50\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"2A201A1209C34411BD1FDFB537C17322\",\n" +
            "                        \"label\": \"管道维修中心\",\n" +
            "                        \"orgcode\": \"0504\",\n" +
            "                        \"orgid\": \"2A201A1209C34411BD1FDFB537C17322\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"管道维修中心\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"生产管理\",\n" +
            "                        \"parentorgid\": \"76526897D5844C32B0E2CC9CBA939E50\",\n" +
            "                        \"pid\": \"76526897D5844C32B0E2CC9CBA939E50\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"C9F849999EFC4C32B742992EDD740129\",\n" +
            "                        \"label\": \"管网工程管理部\",\n" +
            "                        \"orgcode\": \"0505\",\n" +
            "                        \"orgid\": \"C9F849999EFC4C32B742992EDD740129\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"管网工程管理部\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"生产管理\",\n" +
            "                        \"parentorgid\": \"76526897D5844C32B0E2CC9CBA939E50\",\n" +
            "                        \"pid\": \"76526897D5844C32B0E2CC9CBA939E50\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"173D605EBF4D46F2AA78FF58AFAACF02\",\n" +
            "                        \"label\": \"管网工程管理部管网信息管理办\",\n" +
            "                        \"orgcode\": \"0506\",\n" +
            "                        \"orgid\": \"173D605EBF4D46F2AA78FF58AFAACF02\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"管网工程管理部管网信息管理办\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"生产管理\",\n" +
            "                        \"parentorgid\": \"76526897D5844C32B0E2CC9CBA939E50\",\n" +
            "                        \"pid\": \"76526897D5844C32B0E2CC9CBA939E50\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"48A34717502C43DBAD719F18BAD1A9C5\",\n" +
            "                        \"label\": \"生产安全部\",\n" +
            "                        \"orgcode\": \"0507\",\n" +
            "                        \"orgid\": \"48A34717502C43DBAD719F18BAD1A9C5\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"生产安全部\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"生产管理\",\n" +
            "                        \"parentorgid\": \"76526897D5844C32B0E2CC9CBA939E50\",\n" +
            "                        \"pid\": \"76526897D5844C32B0E2CC9CBA939E50\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"81B7412E5A914A30951843034C35111A\",\n" +
            "                        \"label\": \"生产安全部调度与检修中心\",\n" +
            "                        \"orgcode\": \"0508\",\n" +
            "                        \"orgid\": \"81B7412E5A914A30951843034C35111A\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"生产安全部调度与检修中心\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"生产管理\",\n" +
            "                        \"parentorgid\": \"76526897D5844C32B0E2CC9CBA939E50\",\n" +
            "                        \"pid\": \"76526897D5844C32B0E2CC9CBA939E50\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"22F44F92DCD543D395B0F14F363B6160\",\n" +
            "                        \"label\": \"生产安全部综治内保办\",\n" +
            "                        \"orgcode\": \"0509\",\n" +
            "                        \"orgid\": \"22F44F92DCD543D395B0F14F363B6160\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"生产安全部综治内保办\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"生产管理\",\n" +
            "                        \"parentorgid\": \"76526897D5844C32B0E2CC9CBA939E50\",\n" +
            "                        \"pid\": \"76526897D5844C32B0E2CC9CBA939E50\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"B12A701A07BC43F296E93B53BFB65708\",\n" +
            "                        \"label\": \"水质监测站\",\n" +
            "                        \"orgcode\": \"0510\",\n" +
            "                        \"orgid\": \"B12A701A07BC43F296E93B53BFB65708\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"水质监测站\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"生产管理\",\n" +
            "                        \"parentorgid\": \"76526897D5844C32B0E2CC9CBA939E50\",\n" +
            "                        \"pid\": \"76526897D5844C32B0E2CC9CBA939E50\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"BFBA926A695D41A09C8046A7792F06F7\",\n" +
            "                        \"label\": \"沅北水厂\",\n" +
            "                        \"orgcode\": \"0511\",\n" +
            "                        \"orgid\": \"BFBA926A695D41A09C8046A7792F06F7\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"沅北水厂\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"生产管理\",\n" +
            "                        \"parentorgid\": \"76526897D5844C32B0E2CC9CBA939E50\",\n" +
            "                        \"pid\": \"76526897D5844C32B0E2CC9CBA939E50\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"84B2387B1541470987AEF90F4ABFD6F8\",\n" +
            "                        \"label\": \"沅南水厂\",\n" +
            "                        \"orgcode\": \"0512\",\n" +
            "                        \"orgid\": \"84B2387B1541470987AEF90F4ABFD6F8\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"沅南水厂\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"生产管理\",\n" +
            "                        \"parentorgid\": \"76526897D5844C32B0E2CC9CBA939E50\",\n" +
            "                        \"pid\": \"76526897D5844C32B0E2CC9CBA939E50\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"D2D4AE86D466486D96DB92B4D251F13C\",\n" +
            "                        \"label\": \"沃特市政工程总公司\",\n" +
            "                        \"orgcode\": \"0513\",\n" +
            "                        \"orgid\": \"D2D4AE86D466486D96DB92B4D251F13C\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"沃特市政工程总公司\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"生产管理\",\n" +
            "                        \"parentorgid\": \"76526897D5844C32B0E2CC9CBA939E50\",\n" +
            "                        \"pid\": \"76526897D5844C32B0E2CC9CBA939E50\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"F0D541ABDC544A1D83C3E322175AE3B0\",\n" +
            "                        \"label\": \"盛益满饮用水经营有限责任公司\",\n" +
            "                        \"orgcode\": \"0514\",\n" +
            "                        \"orgid\": \"F0D541ABDC544A1D83C3E322175AE3B0\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"盛益满饮用水经营有限责任公司\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"生产管理\",\n" +
            "                        \"parentorgid\": \"76526897D5844C32B0E2CC9CBA939E50\",\n" +
            "                        \"pid\": \"76526897D5844C32B0E2CC9CBA939E50\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"D237EC9C31C54BF6BAC00A8633B4E17F\",\n" +
            "                        \"label\": \"中翰水务\",\n" +
            "                        \"orgcode\": \"0515\",\n" +
            "                        \"orgid\": \"D237EC9C31C54BF6BAC00A8633B4E17F\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"中翰水务\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"生产管理\",\n" +
            "                        \"parentorgid\": \"76526897D5844C32B0E2CC9CBA939E50\",\n" +
            "                        \"pid\": \"76526897D5844C32B0E2CC9CBA939E50\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"32CBCA1B5ECE4B70977648DA2172BB1A\",\n" +
            "                        \"label\": \"物业公司\",\n" +
            "                        \"orgcode\": \"0516\",\n" +
            "                        \"orgid\": \"32CBCA1B5ECE4B70977648DA2172BB1A\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"物业公司\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"生产管理\",\n" +
            "                        \"parentorgid\": \"76526897D5844C32B0E2CC9CBA939E50\",\n" +
            "                        \"pid\": \"76526897D5844C32B0E2CC9CBA939E50\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"id\": \"76526897D5844C32B0E2CC9CBA939E50\",\n" +
            "                \"label\": \"生产管理\",\n" +
            "                \"orgcode\": \"05\",\n" +
            "                \"orgid\": \"76526897D5844C32B0E2CC9CBA939E50\",\n" +
            "                \"orglevel\": 2,\n" +
            "                \"orgname\": \"生产管理\",\n" +
            "                \"orgseq\": \".\",\n" +
            "                \"parentLabel\": \"北京市常务委员会\",\n" +
            "                \"parentorgid\": \"15\",\n" +
            "                \"pid\": \"15\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"children\": [\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"654F515333BA4D70A4B05E74CA4431B6\",\n" +
            "                        \"label\": \"工会办\",\n" +
            "                        \"orgcode\": \"0601\",\n" +
            "                        \"orgid\": \"654F515333BA4D70A4B05E74CA4431B6\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"工会办\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"其他\",\n" +
            "                        \"parentorgid\": \"0995BFCAD5514E60A487E4B426E4B203\",\n" +
            "                        \"pid\": \"0995BFCAD5514E60A487E4B426E4B203\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"388852E868C844A3BB58402333C506A2\",\n" +
            "                        \"label\": \"纪检监察室\",\n" +
            "                        \"orgcode\": \"0602\",\n" +
            "                        \"orgid\": \"388852E868C844A3BB58402333C506A2\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"纪检监察室\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"其他\",\n" +
            "                        \"parentorgid\": \"0995BFCAD5514E60A487E4B426E4B203\",\n" +
            "                        \"pid\": \"0995BFCAD5514E60A487E4B426E4B203\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"DF65B0D797724B4DAA1915E16CAA52ED\",\n" +
            "                        \"label\": \"党群工作部\",\n" +
            "                        \"orgcode\": \"0603\",\n" +
            "                        \"orgid\": \"DF65B0D797724B4DAA1915E16CAA52ED\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"党群工作部\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"其他\",\n" +
            "                        \"parentorgid\": \"0995BFCAD5514E60A487E4B426E4B203\",\n" +
            "                        \"pid\": \"0995BFCAD5514E60A487E4B426E4B203\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"A8184CA2415E4877B4C01153AA88ED4A\",\n" +
            "                        \"label\": \"党群工作部团委\",\n" +
            "                        \"orgcode\": \"0604\",\n" +
            "                        \"orgid\": \"A8184CA2415E4877B4C01153AA88ED4A\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"党群工作部团委\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"其他\",\n" +
            "                        \"parentorgid\": \"0995BFCAD5514E60A487E4B426E4B203\",\n" +
            "                        \"pid\": \"0995BFCAD5514E60A487E4B426E4B203\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"653E1614877947DBABCB309B3D417017\",\n" +
            "                        \"label\": \"党群工作部新闻宣传中心\",\n" +
            "                        \"orgcode\": \"0605\",\n" +
            "                        \"orgid\": \"653E1614877947DBABCB309B3D417017\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"党群工作部新闻宣传中心\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"其他\",\n" +
            "                        \"parentorgid\": \"0995BFCAD5514E60A487E4B426E4B203\",\n" +
            "                        \"pid\": \"0995BFCAD5514E60A487E4B426E4B203\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"18AF958FBF64455B83F36AD1E2AE97F2\",\n" +
            "                        \"label\": \"其他人员\",\n" +
            "                        \"orgcode\": \"0606\",\n" +
            "                        \"orgid\": \"18AF958FBF64455B83F36AD1E2AE97F2\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"其他人员\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"其他\",\n" +
            "                        \"parentorgid\": \"0995BFCAD5514E60A487E4B426E4B203\",\n" +
            "                        \"pid\": \"0995BFCAD5514E60A487E4B426E4B203\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"22852390437C46DD90B6A1663C9D3915\",\n" +
            "                        \"label\": \"停薪留职\",\n" +
            "                        \"orgcode\": \"0607\",\n" +
            "                        \"orgid\": \"22852390437C46DD90B6A1663C9D3915\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"停薪留职\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"其他\",\n" +
            "                        \"parentorgid\": \"0995BFCAD5514E60A487E4B426E4B203\",\n" +
            "                        \"pid\": \"0995BFCAD5514E60A487E4B426E4B203\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"children\": [],\n" +
            "                        \"id\": \"ED8D2435BD7048C49F4BD0D5B987F70E\",\n" +
            "                        \"label\": \"长期病休\",\n" +
            "                        \"orgcode\": \"0608\",\n" +
            "                        \"orgid\": \"ED8D2435BD7048C49F4BD0D5B987F70E\",\n" +
            "                        \"orglevel\": 3,\n" +
            "                        \"orgname\": \"长期病休\",\n" +
            "                        \"orgseq\": \".\",\n" +
            "                        \"parentLabel\": \"其他\",\n" +
            "                        \"parentorgid\": \"0995BFCAD5514E60A487E4B426E4B203\",\n" +
            "                        \"pid\": \"0995BFCAD5514E60A487E4B426E4B203\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"id\": \"0995BFCAD5514E60A487E4B426E4B203\",\n" +
            "                \"label\": \"其他\",\n" +
            "                \"orgcode\": \"06\",\n" +
            "                \"orgid\": \"0995BFCAD5514E60A487E4B426E4B203\",\n" +
            "                \"orglevel\": 2,\n" +
            "                \"orgname\": \"其他\",\n" +
            "                \"orgseq\": \".\",\n" +
            "                \"parentLabel\": \"北京市常务委员会\",\n" +
            "                \"parentorgid\": \"15\",\n" +
            "                \"pid\": \"15\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"dataorg\": \"0\",\n" +
            "        \"id\": \"15\",\n" +
            "        \"label\": \"北京市常务委员会\",\n" +
            "        \"orgcode\": \"001\",\n" +
            "        \"orgid\": \"15\",\n" +
            "        \"orglevel\": 1,\n" +
            "        \"orgname\": \"北京市常务委员会\",\n" +
            "        \"orgseq\": \".15.\",\n" +
            "        \"parentorgid\": \"0\"\n" +
            "    }\n" +
            "]";
}
