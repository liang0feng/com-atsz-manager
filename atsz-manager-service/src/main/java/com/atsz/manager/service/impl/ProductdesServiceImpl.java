package com.atsz.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atsz.manager.mapper.ProductMapper;
import com.atsz.manager.mapper.ProductdesMapper;
import com.atsz.manager.pojo.Product;
import com.atsz.manager.pojo.Productdesc;
import com.atsz.manager.service.ProductdesService;

@Service
public class ProductdesServiceImpl extends BaseServiceImpl<Productdesc> implements ProductdesService{
	@Autowired
	ProductMapper productMapper;
	
	@Autowired
	ProductdesMapper productdesMapper;
	
	@Override
    public void saveProuductAndDesc(Product product, String editorValue) {
        // spring使用jdbc来控制事务
        
        this.productMapper.insertSelective(product);
        
        Productdesc productdesc = new Productdesc();
        productdesc.setId(product.getId());
        productdesc.setProductdesc(editorValue);
        
        this.productdesMapper.insertSelective(productdesc);
    }


}
