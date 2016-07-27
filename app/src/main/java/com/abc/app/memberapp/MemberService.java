package com.abc.app.memberapp;

import java.util.List;

/**
 * Created by hb2002 on 2016-07-27.
 */
public interface MemberService {
    public String regist(MemberBean mem);
    public String show();
    public void update(MemberBean stu2);
    public String delete(MemberBean member);
    public MemberBean findById(String findID);
    public MemberBean getSession();
    public void logout(MemberBean member);
    public int count();
    public List<?> list();
    public List<?> findBy(String keyword);

}
