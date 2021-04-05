package com.edu.ismt.databaseproject.controller;

import com.edu.ismt.databaseproject.entity.OrderDetail;
import com.edu.ismt.databaseproject.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("order-detail")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/list")
    public String ShowOrders(Model model){
        List<OrderDetail> orderDetailList = orderDetailService.getAll();
        model.addAttribute("orderDetailList", orderDetailList);
        return "orderDetail/list";
    }
    @GetMapping("/add-form")
    public String ShowAddForm(Model model){
        OrderDetail orderDetail = new OrderDetail();
        model.addAttribute("orderDetail", orderDetail);
        return "orderDetail/save";
    }
    @GetMapping("/update-form")
    public String updateOrder(@RequestParam("orderDetailId") int id, Model model){
        OrderDetail orderDetail = orderDetailService.getById(id);
        model.addAttribute("orderDetail", orderDetailService);
        return "orderDetail/save";
    }
    @PostMapping("/save")
    public String saveOrder(@ModelAttribute("order") @Valid OrderDetail orderDetail,
                               BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "orderDetail/save";
        }else{
            orderDetailService.save(orderDetail);
            return "redirect:/orderDetail/list";
        }
    }
    @GetMapping("/delete")
    public String deleteOrder(@RequestParam("orderDetailId") int id){
        orderDetailService.delete(id);
        return "redirect:/orderDetail/list";
    }
}
