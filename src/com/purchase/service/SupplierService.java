package com.purchase.service;

import com.purchase.pojo.admin.TbSupplier;
import com.purchase.util.ResultUtil;
import com.purchase.vo.admin.SupplierSearch;

import java.util.List;

/**
 * Created by xuqiang
 * 2018/8/1.
 */
public interface SupplierService {
    ResultUtil selSuppliers(Integer page, Integer limit, SupplierSearch search);

    void updSupplier(TbSupplier supplier);

    void insSupplier(TbSupplier supplier);

    TbSupplier selSupplierById(Long id);

    void delSupplierById(Long id);

    List<TbSupplier> selSuppliersAll();
}
