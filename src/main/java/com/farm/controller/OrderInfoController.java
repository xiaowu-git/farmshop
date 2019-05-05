package com.farm.controller;

import com.alibaba.fastjson.JSONObject;
import com.farm.bean.FsOrderUser;
import com.farm.bean.FsSupplyProducts;
import com.farm.bean.FsUser;
import com.farm.response.OrderUserResponse;
import com.farm.service.interfaces.IFsOrderUserService;
import com.farm.service.interfaces.IFsUserService;
import com.farm.service.interfaces.IFsSupplyProductsService;
import com.farm.utils.DoubleUtil;
import com.farm.utils.OrderNum;
import com.farm.utils.PageUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;

@Controller
public class OrderInfoController {

    @Autowired
    private IFsSupplyProductsService fsSupplyProductsService;
    @Autowired
    private IFsUserService userService;
    @Autowired
    private IFsOrderUserService fsOrderUserService;

    OrderNum orderNum = new OrderNum();
    DoubleUtil doubleUtil = new DoubleUtil();
    private PageUtil pageUtil = new PageUtil();

    @RequestMapping("/user-orderpay-show")
    public String userOrderpayShow (HttpServletRequest request,Map<String, Object> requestMap,@RequestParam("supplyProdId") String supplyProdId, @RequestParam("supplyProdAmount") String supplyProdAmount){

        FsSupplyProducts fsSupplyProducts = fsSupplyProductsService.getFsSupplyProductById(Integer.valueOf(supplyProdId));
        int amount = Integer.valueOf(supplyProdAmount);
        BigDecimal singePrice = new BigDecimal(fsSupplyProducts.getSupplyProdPrice());
        BigDecimal allPrice =  singePrice.multiply(BigDecimal.valueOf(amount));
        requestMap.put("fsSupplyProducts",fsSupplyProducts);
        requestMap.put("supplyProdAmount",supplyProdAmount);
        requestMap.put("allPrice",allPrice.toString());
        return "person/orderpay";
    }

    @RequestMapping("/user-paysuccess-show")
    public String userPaySuccessShow (HttpServletRequest request){
        return "person/paysuccess";
    }



    @ResponseBody
    @RequestMapping(value = "/user-orderpay-toshow",method = RequestMethod.POST)
    public Object userOrderpayToshow (HttpServletRequest request, @RequestParam("supplyProdId") int supplyProdId, @RequestParam("supplyProdAmount") int supplyProdAmount){
        JSONObject jsonObject = new JSONObject();
        FsSupplyProducts fsSupplyProducts = fsSupplyProductsService.getFsSupplyProductById(supplyProdId);
        int prodNum = Integer.valueOf(fsSupplyProducts.getSupplyProdNum());

        if(prodNum== 0 || prodNum== 0|| prodNum - supplyProdAmount< 0){
            jsonObject.put("msg","库存不够!");
            jsonObject.put("success",false);
            return jsonObject;
        }else {
            BigDecimal singePrice = new BigDecimal(fsSupplyProducts.getSupplyProdPrice());
            BigDecimal allPrice =  singePrice.multiply(BigDecimal.valueOf(supplyProdAmount));
            jsonObject.put("supplyProdId",fsSupplyProducts.getSupplyProdId());
            jsonObject.put("supplyProdAmount",supplyProdAmount);
            jsonObject.put("allPrice",allPrice.toString());
            jsonObject.put("msg","可以下单!");
            jsonObject.put("success",true);
            return jsonObject;
        }
    }



    @ResponseBody
    @RequestMapping("/user-orderpay-execute")
    public Object userOrderPayExecute(HttpSession session, @RequestParam("supplyProdId") int supplyProdId, @RequestParam("orderRemark") String orderRemark,@RequestParam("supplyProdAmount") String supplyProdAmount){
        JSONObject jsonObject = new JSONObject();
        FsUser user = (FsUser) session.getAttribute("obj");
        if(user == null){
            jsonObject.put("msg","请前往登录页面登录!");
            jsonObject.put("success",false);
            return jsonObject;
        }else {
            if(user.getUserIdcard() == null){
                jsonObject.put("msg","请前往实名认证页面实名认证!");
                jsonObject.put("success",false);
                return jsonObject;
            }else if(user.getUserAddress() == null){
                jsonObject.put("msg","请前往个人信息页面补全个人信息!");
                jsonObject.put("success",false);
                return jsonObject;
            }
        }
        FsSupplyProducts fsSupplyProducts = fsSupplyProductsService.getFsSupplyProductById(Long.valueOf(supplyProdId).intValue());
        if(fsSupplyProducts.getUserId() == user.getUserId()){
            jsonObject.put("msg","您不能购买自己发布的商品!");
            jsonObject.put("success",false);
            return jsonObject;
        }

        FsUser seller = userService.getUserById(fsSupplyProducts.getUserId());
        //计价
        Double sinPrice = Double.valueOf(fsSupplyProducts.getSupplyProdPrice());
        Double amount = Double.valueOf(supplyProdAmount);

        BigDecimal allPrice = new BigDecimal(doubleUtil.mul(sinPrice,amount));

        FsOrderUser fsOrderUser = new FsOrderUser();
        fsOrderUser.setOrderNumber(orderNum.getOrderNum());
        fsOrderUser.setProdId(fsSupplyProducts.getSupplyProdId());
        fsOrderUser.setUserId(user.getUserId());
        fsOrderUser.setUserPhone(user.getUserPhone());
        fsOrderUser.setSellerId(seller.getUserId().toString());
        fsOrderUser.setSellerPhone(seller.getUserPhone());
        fsOrderUser.setOrderState("2");  //订单状态 支付完成
        fsOrderUser.setStationStart(fsSupplyProducts.getSupplyProdAddress());
        fsOrderUser.setStationEnd(user.getUserAddress());
        fsOrderUser.setCreateTime(new Date());
        fsOrderUser.setPayTime(new Date());
        fsOrderUser.setOrderAmount(allPrice);
        fsOrderUser.setOrderRemark(orderRemark);

        Boolean flag = fsOrderUserService.addOrder(fsOrderUser);

        //去库存
        int supplyProdNum = Integer.valueOf(fsSupplyProducts.getSupplyProdNum()).intValue() - Integer.valueOf(supplyProdAmount).intValue();
        fsSupplyProducts.setSupplyProdNum(supplyProdNum+"");
        fsSupplyProductsService.updateFsSupplyProducts(fsSupplyProducts);

        if(flag){
            jsonObject.put("msg","购买成功!");
            jsonObject.put("success",true);
            return jsonObject;
        }else {
            jsonObject.put("msg","购买失败!");
            jsonObject.put("success",false);
            return jsonObject;
        }


    }

    @RequestMapping("/user-order-list")
    public  String userOrderList(HttpSession session, Map<String, Object> requestMap){
        requestMap.put("nav","userorder");
        FsUser fsUser = (FsUser) session.getAttribute("obj");
        if(null == fsUser) {
            return "home/login";
        }
        List<FsOrderUser> fsOrderUserListOld = fsOrderUserService.getOrderByUser(fsUser.getUserId());
        List<OrderUserResponse> fsOrderUserList = new ArrayList<OrderUserResponse>();
        FsSupplyProducts fsSupplyProducts = new FsSupplyProducts();
        if(fsOrderUserListOld != null && fsOrderUserListOld.size()>0){
            for(FsOrderUser fsOrderUser : fsOrderUserListOld){
                fsSupplyProducts = fsSupplyProductsService.getFsSupplyProductById(fsOrderUser.getProdId());
                OrderUserResponse orderUserResponse = new OrderUserResponse(
                        fsOrderUser.getOrderId(),fsOrderUser.getOrderNumber(),fsOrderUser.getProdId(),fsOrderUser.getUserId(),
                        fsOrderUser.getSellerPhone(),fsOrderUser.getOrderState(),fsOrderUser.getStationStart(),fsOrderUser.getStationEnd(),
                        fsOrderUser.getPayTime(),fsOrderUser.getReceiveTime(),fsOrderUser.getExpirationTime(),fsOrderUser.getOrderAmount(),
                        fsOrderUser.getOrderRemark(),fsSupplyProducts.getSupplyProdName(),fsSupplyProducts.getSupplyProdPicture());
                fsOrderUserList.add(orderUserResponse);
            }
        }
        requestMap.put("fsOrderUserList",fsOrderUserList);
        return "person/userorderlist";
    }



    @RequestMapping("/user-sellerorder-list")
    public  String userSellerOrderList(HttpSession session, Map<String, Object> requestMap){
        requestMap.put("nav","sellerorder");
        FsUser fsUser = (FsUser) session.getAttribute("obj");
        if(null == fsUser) {
            return "home/login";
        }
        List<FsOrderUser> fsOrderUserListOld = fsOrderUserService.getOrderBySeller(fsUser.getUserId());
        List<OrderUserResponse> fsOrderUserList = new ArrayList<OrderUserResponse>();
        FsSupplyProducts fsSupplyProducts = new FsSupplyProducts();
        if(fsOrderUserListOld != null && fsOrderUserListOld.size()>0){
            for(FsOrderUser fsOrderUser : fsOrderUserListOld){
                fsSupplyProducts = fsSupplyProductsService.getFsSupplyProductById(fsOrderUser.getProdId());
                OrderUserResponse orderUserResponse = new OrderUserResponse(
                        fsOrderUser.getOrderId(),fsOrderUser.getOrderNumber(),fsOrderUser.getProdId(),fsOrderUser.getUserId(),
                        fsOrderUser.getUserPhone(),fsOrderUser.getOrderState(),fsOrderUser.getStationStart(),fsOrderUser.getStationEnd(),
                        fsOrderUser.getPayTime(),fsOrderUser.getReceiveTime(),fsOrderUser.getExpirationTime(),fsOrderUser.getOrderAmount(),
                        fsOrderUser.getOrderRemark(),fsSupplyProducts.getSupplyProdName(),fsSupplyProducts.getSupplyProdPicture());
                fsOrderUserList.add(orderUserResponse);
            }
        }
        requestMap.put("fsOrderUserList",fsOrderUserList);
        return "person/sellerorderlist";
    }


    @RequestMapping("/user-orderinfo-show")
    public String userOrderinfoShow (Map<String, Object> requestMap,@RequestParam("userOrderId") String userOrderId){
        FsOrderUser fsOrderUser = fsOrderUserService.getOrderById(Integer.valueOf(userOrderId));
        FsSupplyProducts fsSupplyProducts = fsSupplyProductsService.getFsSupplyProductById(fsOrderUser.getProdId());
        OrderUserResponse orderUserResponse = new OrderUserResponse(
                fsOrderUser.getOrderId(),fsOrderUser.getOrderNumber(),fsOrderUser.getProdId(),fsOrderUser.getUserId(),
                fsOrderUser.getSellerPhone(),fsOrderUser.getOrderState(),fsOrderUser.getStationStart(),fsOrderUser.getStationEnd(),
                fsOrderUser.getPayTime(),fsOrderUser.getReceiveTime(),fsOrderUser.getExpirationTime(),fsOrderUser.getOrderAmount(),
                fsOrderUser.getOrderRemark(),fsSupplyProducts.getSupplyProdName(),fsSupplyProducts.getSupplyProdPicture());

        requestMap.put("orderUserResponse",orderUserResponse);
        return "person/userorderinfo";
    }




    @RequestMapping("/user-seller-orderinfo-show")
    public String userSellerOrderinfoShow (Map<String, Object> requestMap,@RequestParam("userOrderId") String userOrderId){
        FsOrderUser fsOrderUser = fsOrderUserService.getOrderById(Integer.valueOf(userOrderId));
        FsSupplyProducts fsSupplyProducts = fsSupplyProductsService.getFsSupplyProductById(fsOrderUser.getProdId());
        OrderUserResponse orderUserResponse = new OrderUserResponse(
                fsOrderUser.getOrderId(),fsOrderUser.getOrderNumber(),fsOrderUser.getProdId(),fsOrderUser.getUserId(),
                fsOrderUser.getSellerPhone(),fsOrderUser.getOrderState(),fsOrderUser.getStationStart(),fsOrderUser.getStationEnd(),
                fsOrderUser.getPayTime(),fsOrderUser.getReceiveTime(),fsOrderUser.getExpirationTime(),fsOrderUser.getOrderAmount(),
                fsOrderUser.getOrderRemark(),fsSupplyProducts.getSupplyProdName(),fsSupplyProducts.getSupplyProdPicture());

        requestMap.put("orderUserResponse",orderUserResponse);
        return "person/sellerorderinfo";
    }

    /**
     * 前台卖家发货
     * @param id
     * @return
     */
    @RequestMapping(value = "user-order-send-execute/{id}", method = RequestMethod.GET)
    public String userStopSupplyExecute(@PathVariable Integer id) {
        FsOrderUser fsOrderUser = fsOrderUserService.selectByPrimaryKey(id);
        fsOrderUser.setOrderState("3");
        fsOrderUserService.updateByPrimaryKeySelective(fsOrderUser);
        return "redirect:/user-sellerorder-list";
    }

    /**
     * 前台买家收货
     * @param id
     * @return
     */
    @RequestMapping(value = "user-order-receive-execute/{id}", method = RequestMethod.GET)
    public String userOrderReceiveExecute(@PathVariable Integer id) {
        FsOrderUser fsOrderUser = fsOrderUserService.selectByPrimaryKey(id);
        fsOrderUser.setOrderState("4");
        fsOrderUser.setReceiveTime(new Date());
        fsOrderUserService.updateByPrimaryKeySelective(fsOrderUser);
        return "redirect:/user-order-list";
    }

    /**
     * 前台买家删除订单
     * @param id
     * @return
     */
    @RequestMapping(value = "user-order-remove-execute/{id}", method = RequestMethod.GET)
    public String userOrderRemoveExecute(@PathVariable Integer id) {
        FsOrderUser fsOrderUser = fsOrderUserService.selectByPrimaryKey(id);
        fsOrderUser.setIsDeleted("1");
        fsOrderUserService.updateByPrimaryKeySelective(fsOrderUser);
        return "redirect:/user-order-list";
    }



    @RequestMapping("/user-orderchange-list")
    public String userOrderChangeList (HttpSession session,Map<String, Object> requestMap){
        requestMap.put("nav","orderchange");
        FsUser fsUser = (FsUser) session.getAttribute("obj");
        if(null == fsUser) {
            return "home/login";
        }
        List<FsOrderUser> fsOrderUserListOld = fsOrderUserService.getOrderUserChangeByUser(fsUser.getUserId());
        List<OrderUserResponse> fsOrderUserList = new ArrayList<OrderUserResponse>();
        FsSupplyProducts fsSupplyProducts = new FsSupplyProducts();
        if(fsOrderUserListOld != null && fsOrderUserListOld.size()>0){
            for(FsOrderUser fsOrderUser : fsOrderUserListOld){
                fsSupplyProducts = fsSupplyProductsService.getFsSupplyProductById(fsOrderUser.getProdId());
                OrderUserResponse orderUserResponse = new OrderUserResponse(
                        fsOrderUser.getOrderId(),fsOrderUser.getOrderNumber(),fsOrderUser.getProdId(),fsOrderUser.getUserId(),
                        fsOrderUser.getSellerPhone(),fsOrderUser.getOrderState(),fsOrderUser.getStationStart(),fsOrderUser.getStationEnd(),
                        fsOrderUser.getPayTime(),fsOrderUser.getReceiveTime(),fsOrderUser.getExpirationTime(),fsOrderUser.getOrderAmount(),
                        fsOrderUser.getOrderRemark(),fsSupplyProducts.getSupplyProdName(),fsSupplyProducts.getSupplyProdPicture());
                fsOrderUserList.add(orderUserResponse);
            }
        }
        requestMap.put("orderChangeList",fsOrderUserList);
        return "person/userorderchange";
    }


    /**
     * 1.订单列表显示 后台使用
     * @return admin/order_list.jsp
     */
    @RequestMapping(value="admin-order-list-show", method= RequestMethod.GET)
    public String orderListShow(Map<String, Object> requestMap, @RequestParam("page") Integer page) {
        requestMap.put("nav", "order");
        ArrayList<FsOrderUser> orderList = (ArrayList<FsOrderUser>) fsOrderUserService.getAllOrder();
        requestMap.put("orderList", orderList);

        List<FsOrderUser> pageOrderList = new ArrayList();
        Map map = pageUtil.getPaging(page, orderList, pageOrderList);

        requestMap.put("pageMax", map.get("pageMax"));
        requestMap.put("pagePoint", map.get("pagePoint"));
        requestMap.put("pageOrderList", map.get("listPage"));
        return "admin/order_list";
    }

    @RequestMapping(value = "admin-order-search-show", method = RequestMethod.GET)
    public String searchSupplyShow(Map<String, Object> requestMap, @RequestParam("orderNumber") String orderNumber) {
        requestMap.put("nav", "order");
        if(StringUtils.isNotBlank(orderNumber)){
            ArrayList<FsOrderUser> fsSupplyProductsByName = (ArrayList<FsOrderUser>) fsOrderUserService.getFsOrderUserByorderNumber(orderNumber);
            requestMap.put("pageOrderList", fsSupplyProductsByName);
            return "admin/order_list";
        }else{
            ArrayList<FsOrderUser> fsOrderUsers = (ArrayList<FsOrderUser>) fsOrderUserService.getAllOrder();
            requestMap.put("pageOrderList", fsOrderUsers);
            return "admin/order_list";
        }

    }

    /**
     * 后台用户删除
     * @param id
     * @return
     */
    @RequestMapping(value = "admin-order-remove-execute/{id}", method = RequestMethod.GET)
    public String adminRemoveOrderExecute(@PathVariable Integer id) {
        FsOrderUser fsOrderUser = fsOrderUserService.selectByPrimaryKey(id);
        fsOrderUser.setIsDeleted("1");
        fsOrderUserService.updateByPrimaryKeySelective(fsOrderUser);
        return "redirect:/admin-order-list-show?page=1";
    }


}
