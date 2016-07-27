package com.abc.app.memberapp;

import java.util.List;

/**
 * Created by hb2002 on 2016-07-27.
 */
public class MemberServiceImpl implements MemberService{
    private MemberDAO dao = MemberDAO.getInstance();
    private MemberBean session;
    private static MemberServiceImpl instance = new MemberServiceImpl();  //싱글턴 패턴(보안때문에 getter만 보유한패턴)

    public static MemberServiceImpl getInstance() {
        return instance;
    }
    private MemberServiceImpl() {
        session = new MemberBean();
    }
    @Override
    public String regist(MemberBean mem) {
        String msg = "";
        MemberBean temp = this.findById(mem.getId());
        if (temp == null) {
            System.out.println(mem.getId()+"은(는) 사용 가능한 ID 입니다.");
            int result = dao.insert(mem);
            if (result==1) {
                msg = "success";
            } else {
                msg = "fail";
            }
        }else{
            System.out.println(mem.getId()+"은(는) 사용 불가능한 ID 입니다.");
            msg = "fail";
        }
        return msg;
    }
    @Override
    public String show() {
        // TODO 2.보기
        return session.toString();
    }
    @Override
    public void update(MemberBean mem) {
        // TODO 3.수정
        int result = dao.update(mem);
        if (result == 1) {
            System.out.println("서비스 수정결과 성공");
        }else{
            System.out.println("서비스 수정결과 실패");
        }
    }
    @Override
    public String delete(MemberBean member) {
        // TODO 4.삭제
        String result = "";
        if (dao.delete(member) == 1) {
            result = "삭제성공";
        } else {
            result = "삭제실패";
        }
        return  result;
    }
    @Override
    public int count() {
        // TODO Auto-generated method stub
        return dao.count();
    }
    @Override
    public MemberBean findById(String findID) {
        return dao.findById(findID);
    }
    @Override
    public List<?> list() {

        return dao.list();
    }
    @Override
    public List<?> findBy(String keyword) {
        return dao.findByName(keyword);
    }
    @Override
    public MemberBean getSession() {
        return session;
    }
    @Override
    public void logout(MemberBean member) {
        if (member.getId().equals(session.getId())&&member.getPw().equals(session.getPw())) {
            session = null;
        }
    }
}
