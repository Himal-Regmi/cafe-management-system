package com.edu.ismt.databaseproject.controller;

import com.edu.ismt.databaseproject.entity.Orders;
import com.edu.ismt.databaseproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    public String ShowOrders(Model model){
        List<Orders> ordersList = orderService.getAll();
        model.addAttribute("orderList", ordersList);
        return "orders/list";
    }
    @GetMapping("/add-form")
    public String ShowAddForm(Model model){
        Orders orders = new Orders();
        model.addAttribute("order", orders);
        return "orders/save";
    }
    @GetMapping("/update-form")
    public String updateOrder(@RequestParam("orderId") int id, Model model){
        Orders orders = orderService.getById(id);
        model.addAttribute("order", orders);
        return "orders/save";
    }
    @PostMapping("/save")
    public String saveOrder(@ModelAttribute("order") @Valid Orders orders,
                               BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "orders/save";
        }else{
            orderService.save(orders);
            return "redirect:/orders/list";
        }
    }
    @GetMapping("/delete")
    public String deleteOrder(@RequestParam("orderId") int id){
        orderService.delete(id);
        return "redirect:/customer-tables/list";
    }
//    public Date getDateFromString(String dateString){
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        Date parsedDate = null;
//        try {
//            parsedDate = (Date) format.parse(dateString);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return new Date(parsedDate.getTime());
//    }
}
