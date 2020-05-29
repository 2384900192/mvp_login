package com.example.day_ye;

import com.example.day_ye.bean.DatasBean;
import com.example.day_ye.db.DaoSession;
import com.example.day_ye.db.DatasBeanDao;

import java.util.List;

public class Dbeson {
    static {
        daoSession = BaseApp.getInstance().getDaoSession();
    }

    private static DaoSession daoSession;

    //插入数据
    public static void insert(DatasBean datasBean){
        if (!queryOne(datasBean)){
            daoSession.insert(datasBean);
        }
    }
    public static void deletr(DatasBean datasBean){
        if (!queryOne(datasBean)){
            daoSession.delete(datasBean);
        }
    }
    // 查询所有
    public static List<DatasBean> queryAll(  ) {
        List<DatasBean> list = daoSession.loadAll(DatasBean.class);
        return list;

    }
    public static void update(DatasBean list) {

        if (!queryOne(list)) {
            daoSession.update(list);
        }

    }
    private static boolean queryOne(DatasBean bean) {
        DatasBean unique = daoSession.queryBuilder(DatasBean.class).where(DatasBeanDao.Properties.Id.eq(bean.getId())).unique();
        return unique == null ? false : true;
    }
}
