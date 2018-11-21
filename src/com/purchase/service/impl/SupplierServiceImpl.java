package com.purchase.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.purchase.mapper.admin.TbSupplierMapper;
import com.purchase.pojo.admin.TbSupplier;
import com.purchase.pojo.admin.TbSupplierExample;
import com.purchase.service.SupplierService;
import com.purchase.util.ResultUtil;
import com.purchase.vo.admin.ChoseSupplierVO;
import com.purchase.vo.admin.SupplierSearch;
import com.purchase.vo.admin.SupplierVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {


    @Autowired
    public TbSupplierMapper tbSupplierMapper;


    @Override
    public ResultUtil selSuppliers(Integer page, Integer limit, SupplierSearch search) {
        PageHelper.startPage(page, limit);
        TbSupplierExample example=new TbSupplierExample();
        example.setOrderByClause("id DESC");
        TbSupplierExample.Criteria criteria = example.createCriteria();

        if(StringUtils.isNotEmpty(search.getName())){
            //注意：模糊查询需要进行拼接”%“  如下，不进行拼接是不能完成查询的哦。
            criteria.andNameLike("%"+search.getName()+"%");
        }
        if(search.getType() != null){
            criteria.andTypeEqualTo(search.getType());
        }
        if(search.getAreaId() != null){
            criteria.andAreaIdEqualTo(search.getAreaId());
        }
        if(search.getValid() != null){
            criteria.andValidEqualTo(search.getValid());
        }

        List<SupplierVo> users = tbSupplierMapper.selectByExampleExt(example);
        PageInfo<SupplierVo> pageInfo = new PageInfo<SupplierVo>(users);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public void updSupplier(TbSupplier supplier) {
        tbSupplierMapper.updateByPrimaryKey(supplier);
    }

    @Override
    public void insSupplier(TbSupplier supplier) {
        tbSupplierMapper.insert(supplier);
    }

    @Override
    public TbSupplier selSupplierById(Long id) {
        return tbSupplierMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delSupplierById(Long id) {
        tbSupplierMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<TbSupplier> selSuppliersAll() {
        return tbSupplierMapper.selectByExample(new TbSupplierExample());
    }

    @Override
    public List<ChoseSupplierVO> selectSupplier() {
        List<TbSupplier> supplier = tbSupplierMapper.selectByExample(new TbSupplierExample());
        List<ChoseSupplierVO> item = new ArrayList();
        if(!CollectionUtils.isEmpty(supplier)){
            for (TbSupplier s: supplier) {
                item.add(new ChoseSupplierVO(s.getId().toString(),s.getName()));
            }
        }
        return item;
    }
}
