package com.farm.service.impl;

import com.farm.bean.FsFarmnews;
import com.farm.dao.FsFarmnewsMapper;
import com.farm.service.interfaces.IFsFarmnewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FsFarmnewsServiceImpl implements IFsFarmnewsService {

    @Autowired
    private FsFarmnewsMapper fsFarmnewsMapper;

    @Override
    public List<FsFarmnews> getAllFsFarmnews() {
        return fsFarmnewsMapper.selectAllFsFarmnews();
    }

    @Override
    public FsFarmnews getFsFarmnewsById(Integer FarmnewsId) {
        return fsFarmnewsMapper.selectByPrimaryKey(FarmnewsId);
    }

    @Override
    public int deleteByPrimaryKey(Integer farmnewsId) {
        int deleteNum = fsFarmnewsMapper.deleteByPrimaryKey(farmnewsId);
        return deleteNum;
    }

    @Override
    public int insert(FsFarmnews record) {
        int insertNum = fsFarmnewsMapper.insert(record);
        return insertNum;
    }

    @Override
    public int insertSelective(FsFarmnews record) {
        int insertNum = fsFarmnewsMapper.insertSelective(record);
        return insertNum;
    }

    @Override
    public FsFarmnews selectByPrimaryKey(Integer farmnewsId) {
        FsFarmnews fsFarmnews = fsFarmnewsMapper.selectByPrimaryKey(farmnewsId);
        return fsFarmnews;
    }

    @Override
    public int updateByPrimaryKeySelective(FsFarmnews record) {
        int updateNum = fsFarmnewsMapper.updateByPrimaryKeySelective(record);
        return updateNum;
    }

    @Override
    public int updateByPrimaryKey(FsFarmnews record) {
        int updateNum = fsFarmnewsMapper.updateByPrimaryKey(record);
        return updateNum;
    }

    @Override
    public List<FsFarmnews> getFsFarmnewsByName(String farmnewsName) {
        List<FsFarmnews> fsFarmnews = fsFarmnewsMapper.selectFsFarmnewsByName(farmnewsName);
        return fsFarmnews;
    }
}
