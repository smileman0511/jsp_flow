package com.app.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.app.dto.OrderDTO;
import com.app.mybatis.config.MyBatisConfig;
import com.app.vo.OrderVO;

public class OrderDAO {
    private SqlSession sqlSession;

    public OrderDAO() {
        sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
    }

    public void save(OrderVO orderVO) {
        sqlSession.insert("order.insert", orderVO);
    }

    public int decreaseStock(OrderVO orderVO) {
        return sqlSession.update("order.decreaseStock", orderVO);
    }

    public int restoreStock(OrderVO orderVO) {
        return sqlSession.update("order.restoreStock", orderVO);
    }

    public List<OrderDTO> findAll() {
        return sqlSession.selectList("order.selectAll");
    }

    public OrderDTO findById(Long id) {
        return sqlSession.selectOne("order.selectById", id);
    }

    public void delete(Long id) {
        sqlSession.delete("order.delete", id);
    }
}