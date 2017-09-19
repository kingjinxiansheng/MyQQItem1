package com.example.administrator.myqqitem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Administrator on 2017/9/1.
 */

public class SlideAdapter extends BaseAdapter  {
    private List<String> dataList;
    private Context context;
    private LayoutInflater inflater;
    Listener listener;
    public SlideAdapter(Context context, List<String> dataList) {
        this.context = context;
        this.dataList = dataList;
        this.inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return dataList.size();
    }
    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         View content=inflater.inflate(R.layout.adapter_item_content,null);
         View menu=inflater.inflate(R.layout.adapter_item_menu,null);
         TextView title = content.findViewById(R.id.text1);
        title.setText(dataList.get(position));
        TextView itemTvToTop = menu.findViewById(R.id.item_to_top);
        TextView itemTvNoRead = menu.findViewById(R.id.item_no_read);
        TextView itemTvDelete = menu.findViewById(R.id.item_delete);
        SlideItem slideItem=new SlideItem(context);
        slideItem.setContentView(content,menu);
        listener.setListener(itemTvToTop,itemTvNoRead,itemTvDelete,position);
        return slideItem;
    }

    public interface Listener{
       void setListener(View one ,View two,View three,int position);
    }
    public void setOnClickenListener(Listener listener){
        this.listener=listener;
    }

}
