package com.lst.malls.service.impl;

import com.lst.malls.mapper.ShoppingCarMapper;
import com.lst.malls.pojo.*;
import com.lst.malls.service.ForeService;
import com.lst.malls.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author :Nibelung
 * @Date ：Created in 10:45 2019/9/26
 * @Description :
 * @Modified By :
 * @Version : $
 */
@Service
public class ForeServiceImpl implements ForeService {

    @Autowired
    OrderDetailService orderDetailService;
    @Autowired
    ShoppingCarMapper shoppingCarMapper;

    /**
     * 立即购买
     * @param id
     * @param num
     * @param goods
     * @return
     */
    @Override
    public OrderDetail puyNow(Integer id, Integer num, Goods goods) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setNumber(num);
        orderDetail.setGoods_id(id);
        orderDetail.setGoods(goods);
        return orderDetail;
    }

    /**
     * 创建订单
     * @param order
     * @param orderDetails
     * @param user
     * @return
     */
    @Override
    public Order creatOrder(Order order, List<OrderDetail> orderDetails, User user) {
        //生成订单号
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String timeStr = sdf.format(new Date());
        // 17位时间+用户id
        Long i = Long.valueOf(timeStr + user.getId());

        order.setOrderDetails(orderDetails);

        for (OrderDetail o:orderDetails) {
            o.setOrder_id(i);
            orderDetailService.add(o);
        }
        //将订单ID和创建时间存入到订单中
        order.setOrder_ID(i);
        order.setCreator_time(new Date());

        return order;
    }


    @Override
    public void shoppingCarAdd(Integer userId, Integer goodsId, Integer numbers) {
        ShoppingCar shoppingCar = new ShoppingCar();
        shoppingCar.setUser_id(userId);
        shoppingCar.setGoods_id(goodsId);
        shoppingCar.setNumbers(numbers);
        shoppingCarMapper.insert(shoppingCar);
    }

    @Override
    public List<ShoppingCar> selectShoppingByUserId(Integer userId) {
        ShoppingCarExample example = new ShoppingCarExample();
        example.createCriteria().andUser_idEqualTo(userId);
        List<ShoppingCar> shoppingCars = shoppingCarMapper.selectByExample(example);
        return shoppingCars;
    }

    @Override
    public boolean selectShoppingCarByGoodsAndUser(Integer userId, Integer goodsId) {
        ShoppingCarExample example = new ShoppingCarExample();
        example.createCriteria().andUser_idEqualTo(userId).andGoods_idEqualTo(goodsId);
        List<ShoppingCar> shoppingCars = shoppingCarMapper.selectByExample(example);
        if (shoppingCars.isEmpty()){
            return true;
        }
        return false;
    }



    @Override
    public void updateGoodsNumbers(Integer userId, Integer goodsId, Integer numbers) {
        Integer originalNumbers = shoppingCarMapper.selectByNumbers(userId,goodsId);
        Integer presentNumbers = originalNumbers+numbers;
        shoppingCarMapper.updateByNumbers(userId,goodsId,presentNumbers);
    }

    @Override
    public void deleteShoppingCar(Integer id) {
        shoppingCarMapper.delete(id);
    }

    @Override
    public ShoppingCar selectShoppingCar(Integer id) {
       ShoppingCar shoppingCar = shoppingCarMapper.selectById(id);
        return shoppingCar;
    }


}
