package model;

import java.sql.Date;

public class IssuedBook {

	private int issueId;
	private int bookNo;
	private int issueQty;
	private Date issueDate;

	public IssuedBook() {

	}

	public IssuedBook(int issueId, int bookNo, int issueQty, Date issueDate) {
		this.issueId = issueId;
		this.bookNo = bookNo;
		this.issueQty = issueQty;
		this.issueDate = issueDate;
	}

	public int getIssueId() {
		return issueId;

	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public int getIssueQty() {
		return issueQty;
	}

	public void setIssueQty(int issueQty) {
		this.issueQty = issueQty;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

}
