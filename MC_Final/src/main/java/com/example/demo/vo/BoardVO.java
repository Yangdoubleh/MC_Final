package com.example.demo.vo;

import java.util.Date;

public class BoardVO {
	private int no,grp,seq,lvl;
	private String memberID,title,content,fileName;
	private Date writeDate;
	
	
	
	
	public BoardVO() {
		
	}
	public BoardVO(int no, int grp, int seq, int lvl, String memberID, String title, String content, String fileName,
			Date writeDate) {
		super();
		this.no = no;
		this.grp = grp;
		this.seq = seq;
		this.lvl = lvl;
		this.memberID = memberID;
		this.title = title;
		this.content = content;
		this.fileName = fileName;
		this.writeDate = writeDate;
	}
	@Override
	public String toString() {
		return "BoardVO [memberID=" + memberID + ", title="	+ title + ", content=" + content + ", fileName=" + fileName + ", writeDate=" + writeDate + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getGrp() {
		return grp;
	}
	public void setGrp(int grp) {
		this.grp = grp;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
	
}

