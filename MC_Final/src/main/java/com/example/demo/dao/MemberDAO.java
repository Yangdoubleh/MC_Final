package com.example.demo.dao;

<<<<<<< HEAD
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

=======
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
>>>>>>> master
import com.example.demo.vo.MemberVO;

@Mapper
@Repository
public interface MemberDAO {
	
	public MemberVO login(MemberVO memberVO) throws DataAccessException;
<<<<<<< HEAD

=======
	public List<MemberVO> selectAllMember() throws DataAccessException;
	public void insertMember(MemberVO memberVO) throws DataAccessException;
	public void updateMemberPw(MemberVO memberVO) throws DataAccessException;
	public void deleteMember(String id) throws DataAccessException;
>>>>>>> master
}
