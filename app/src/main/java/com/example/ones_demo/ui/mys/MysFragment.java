package com.example.ones_demo.ui.mys;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.ones_demo.R;
import com.example.ones_demo.adapter.MyExpandableListViewAdapter;
import com.example.ones_demo.bean.ChildBean;
import com.example.ones_demo.bean.GroupBean;

import java.util.ArrayList;
import java.util.List;

public class MysFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    // 准备数据
    private List<GroupBean> list_data;
    private int[] images = { R.drawable.wdzj, R.drawable.wdyy, R.drawable.didi };
    int[] arr = {R.drawable.wdzj,R.drawable.wdyy,R.drawable.wdones};
    private String[] str={"我的证件","我的预约","ONES信用"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        initData();

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_mys, container, false);

        initView(root);
        setLentse();
        return root;
    }

    private void init() {

    }

    private void initView(View root) {
        ExpandableListView listView = root.findViewById(R.id.expandableListView);
        MyExpandableListViewAdapter adapter = new MyExpandableListViewAdapter(getContext(),list_data);
        listView.setAdapter(adapter);
    }

    private void initData() {
        list_data = new ArrayList<GroupBean>();
        for (int i = 0; i < arr.length; i++) {
            GroupBean group = new GroupBean();
            group.setImg(arr[i]);
            group.setTxt(str[i]);
            List<ChildBean> child = new ArrayList<ChildBean>();
            for (int j = 0; j < 3; j++) {
                ChildBean chid = new ChildBean();
                chid.setImg(images[j]);
                chid.setTxt("子" + (j + 1));
                child.add(chid);
            }
            group.getList_child().addAll(child);
            list_data.add(group);
        }
    }

    private void setLentse() {

    }
}