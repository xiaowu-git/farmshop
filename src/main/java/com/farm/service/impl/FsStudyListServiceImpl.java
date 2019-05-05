package com.farm.service.impl;

import com.farm.bean.FsStudylist;
import com.farm.dao.FsStudylistMapper;
import com.farm.service.interfaces.IFsStudyListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FsStudyListServiceImpl implements IFsStudyListService {

    @Autowired
    private FsStudylistMapper fsStudylistMapper;

    @Override
    public List<FsStudylist> getAllChildFsStudylist() {
        return fsStudylistMapper.selectAllChildFsStudylist();
    }

    @Override
    public List<FsStudylist> getAllFsStudylist() {
        return fsStudylistMapper.selectAllFsStudylist();
    }

    @Override
    public FsStudylist getStudyListById(Integer studylistId) {
        return fsStudylistMapper.selectByPrimaryKey(studylistId);
    }

    @Override
    public FsStudylist getStudyListBySeq(Integer studylistSeq) {
        return fsStudylistMapper.selectStudyListBySeq(studylistSeq);
    }
}
