package com.example.ones_demo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ones_demo.R;
import com.example.ones_demo.bean.GroupBean;

import java.util.List;

/**
 * @author kujin
 * @version 1.0
 * @date 2019/9/18 0018 14:58
 */
public class MyExpandableListViewAdapter extends BaseExpandableListAdapter {
    private List<GroupBean> list_data;
    private Context context;

    public MyExpandableListViewAdapter(Context context, List<GroupBean> list_data) {
        this.context = context;
        this.list_data = list_data;
    }

    @Override
    public int getGroupCount() {
        return list_data.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {

        return list_data.get(groupPosition).getList_child().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return list_data.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return list_data.get(groupPosition).getList_child().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        HolderGroup group = null;
        if (convertView == null) {
            convertView = View.inflate(context,R.layout.layout_group,null);
            group = new HolderGroup(convertView);
            convertView.setTag(group);
        } else {
            group = (HolderGroup) convertView.getTag();
        }
        group.img.setImageResource(list_data.get(groupPosition).getImg());
        group.tv.setText(list_data.get(groupPosition).getTxt());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
                             ViewGroup parent) {
        HolderChild child = null;
        if (convertView == null) {
            convertView = View.inflate(context,R.layout.layout_item,null);
            child = new HolderChild(convertView);
            convertView.setTag(child);
        } else {
            child = (HolderChild) convertView.getTag();
        }
        child.img.setImageResource(list_data.get(groupPosition).getList_child().get(childPosition).getImg());

        child.tv.setText(list_data.get(groupPosition).getList_child().get(childPosition).getTxt());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class HolderGroup {
        ImageView img;
        TextView tv;

        public HolderGroup(View convertView) {
            img = (ImageView) convertView.findViewById(R.id.iv_group);
            tv = (TextView) convertView.findViewById(R.id.tv_group);
        }
    }

    class HolderChild {
        ImageView img;
        TextView tv;

        public HolderChild(View convertView) {
            img = (ImageView) convertView.findViewById(R.id.iv_item);
            tv = (TextView) convertView.findViewById(R.id.tv_item);
        }
    }
}
