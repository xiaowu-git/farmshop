package com.farm.service.interfaces;

import com.farm.bean.FsAdmin;

import java.util.List;

public interface IFsAdminService {

    int deleteByPrimaryKey(Integer adminId);

    int insert(FsAdmin record);

    int insertSelective(FsAdmin record);

    FsAdmin getFsAdminById(Integer adminId);

    int updateByPrimaryKeySelective(FsAdmin record);

    int updateByPrimaryKey(FsAdmin record);

    /**
     * 6.查询所有管理员信息
     *
     * @return 所有管理员实例集合(表格)
     */
    List<FsAdmin> getAllFsAdmin();

    /**
     * 7.通过管理员名类似进行模糊查询其信息
     *
     * @param name
     * @return 管理员实例集合(n行, n>=0)
     */
    List<FsAdmin> getFsAdminByNameLike(String name);

    int removeFsAdmin(Integer adminId);

    FsAdmin getAdminByPhone(String adminPhone);


}
