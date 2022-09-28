package com.Jaqune.Dao;


import com.Jaqune.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BaseDao<T> {

    private QueryRunner queryRunner = new QueryRunner();


    public T getBean(String sql, Class<T> clazz, Object...param){
        Connection conn = JDBCUtil.getConnection();
        try {
            return queryRunner.query(conn,sql, new BeanHandler<>(clazz),param);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }finally {
            JDBCUtil.releaseConnection(conn);
        }
    }

    public int update(String sql,Object...params)  {

        Connection conn = JDBCUtil.getConnection();

        try {
            return queryRunner.update(conn,sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }finally {
            JDBCUtil.releaseConnection(conn);
        }


    }
    public List<T> getBeanList(String sql,Class<T> clazz,Object...params)  {
        Connection conn = JDBCUtil.getConnection();

        try {
            return queryRunner.query(conn,sql, new BeanListHandler<>(clazz), params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            JDBCUtil.releaseConnection(conn);
        }

    }

}
