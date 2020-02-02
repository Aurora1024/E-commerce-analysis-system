package com.example.cc.controller;


import com.example.cc.service.OrderService;
import com.example.cc.util.ResJsonTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class orderController {

    @Autowired
    private OrderService orderService;


    @RequestMapping(value = "/detail/product", method = RequestMethod.GET)
    public ResJsonTemplate getProductDetailsById(@RequestParam String code){
        return orderService.getProductDetailsById(code);
    }

    @RequestMapping(value = "/product/index", method = RequestMethod.GET)
    public ResJsonTemplate updateProjectById(@RequestParam String product_id, @RequestParam String product,
                                  @RequestParam String category, @RequestParam double price,
                                  @RequestParam int inventory){
        return orderService.updateProduct(product_id, product, price, inventory, category);
    }

    @RequestMapping(value = "/product/insert", method = RequestMethod.GET)
    public ResJsonTemplate insertProjectById(@RequestParam String product_id, @RequestParam String product,
                                  @RequestParam String category, @RequestParam double price,
                                  @RequestParam int inventory){
        return orderService.insertProduct(product_id, product, price, inventory, category);
    }

    @RequestMapping(value = "/product/search", method = RequestMethod.GET)
    public ResJsonTemplate getProjectDetailsById2(@RequestParam String code){
        return orderService.getProductDetailsById2(code);
    }

    @RequestMapping(value = "/product/delete", method = RequestMethod.GET)
    public ResJsonTemplate deleteProductById(@RequestParam String code){
        return orderService.deleteProductById(code);
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ResJsonTemplate getDashboard(){
        return orderService.getCategoryAndSalesOfSeason();
    }

    @RequestMapping(value = "/show/product", method = RequestMethod.GET)
    public ResJsonTemplate getRankOfProductByGenre(@RequestParam String name){
        return orderService.getRankOfProductByGenre(name);
    }

    @RequestMapping(value = "/show/category", method = RequestMethod.GET)
    public ResJsonTemplate getCategoryDetailsByNameAndType(@RequestParam String category, @RequestParam int type){
        return orderService.getCategoryDetailsByNameAndType(category, type);
    }

    @RequestMapping(value = "/detail/order", method = RequestMethod.GET)
    public ResJsonTemplate getOrdersByProductId(@RequestParam String code){
        return orderService.getOrdersByProductId(code);
    }

    @RequestMapping(value = "/detail/chart", method = RequestMethod.GET)
    public ResJsonTemplate getSalesByProductIdAndType(@RequestParam String code, @RequestParam int type){
        return orderService.getSalesByProductIdAndType(code, type);
    }

    @RequestMapping(value = "/detail/pricechart", method = RequestMethod.GET)
    public ResJsonTemplate getPriceAndDaysByProductID(@RequestParam String code){
        return orderService.getPriceAndDaysByProductID(code);
    }

    @RequestMapping(value = "/dashboard/show", method = RequestMethod.GET)
    public ResJsonTemplate getALLC(){
        return orderService.getAllCategory();
    }

}
