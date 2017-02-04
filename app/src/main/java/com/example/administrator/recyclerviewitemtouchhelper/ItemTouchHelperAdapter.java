package com.example.administrator.recyclerviewitemtouchhelper;

/**
 * author:  wujinli
 * date:    2017/2/4
 * desc:   定义接口实现拖拽和删除
 */

public interface ItemTouchHelperAdapter {
    //移动数据
    void onItemMove(int fromPosition, int toPosition);

    //移除数据
    void onItemRemoved(int position);
}
