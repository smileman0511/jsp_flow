package com.app.order.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.app.Action;
import com.app.Result;
import com.app.dao.OrderDAO;
import com.app.dto.OrderDTO;
import com.app.vo.OrderVO;

public class OrderCancelController implements Action {
    @Override
    public Result excute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Result result = new Result();
        OrderDAO orderDAO = new OrderDAO();

        Long id = Long.parseLong(req.getParameter("id"));

        OrderDTO orderDTO = orderDAO.findById(id);

        OrderVO orderVO = new OrderVO();
        orderVO.setProductId(orderDTO.getProductId());
        orderVO.setOrderCount(orderDTO.getOrderCount());
        orderDAO.restoreStock(orderVO);

        orderDAO.delete(id);

        result.setRedirect(true);
        result.setPath("/flow/list.order");

        return result;
    }
}