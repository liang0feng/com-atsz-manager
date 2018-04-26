package com.atsz.manager.service;

import com.atsz.manager.pojo.Product;
import com.atsz.manager.pojo.Productdesc;

public interface ProductdesService extends BaseService<Productdesc> {
	public void saveProuductAndDesc(Product product, String editorValue);
}
