package com.example.cc.service;

import com.example.cc.util.ResJsonTemplate;

public interface OrderService {

    ResJsonTemplate getProductDetailsById(String id);

    ResJsonTemplate getCategoryDetailsByNameAndType(String category, int type);

    ResJsonTemplate getOrdersByProductId(String product_id);

    ResJsonTemplate getSalesByProductIdAndType(String product_id, int type);

    ResJsonTemplate getPriceAndDaysByProductID(String product_id);

    ResJsonTemplate getCPOTotal();

    ResJsonTemplate getCategoryAndSalesOfSeason();

    ResJsonTemplate getRankOfYearSalesOfCategory();

    ResJsonTemplate getRankOfProductByGenre(String category);

    ResJsonTemplate deleteProductById(String product_id);

    ResJsonTemplate insertProduct(String product_id,
                                  String product,
                                  double price,
                                  int inventory,
                                  String category);

    ResJsonTemplate updateProduct(String product_id,
                                  String product,
                                  double price,
                                  int inventory,
                                  String category);

    ResJsonTemplate getProductDetailsById2(String product_id);

    ResJsonTemplate getAllCategory();


}
