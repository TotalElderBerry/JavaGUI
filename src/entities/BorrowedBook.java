package entities;

public class BorrowedBook extends Book{
	private String borroweddate;
	private String returndate;
	
	
	public BorrowedBook(Book b,String borroweddate,String returndate) {
		super(b);
		this.borroweddate = borroweddate;
		this.returndate = returndate;
	}
	
	public Object[] toObject() {
		Object[] obj = {super.getTitle(),borroweddate,returndate};
		return obj;
	}
	
	public String getBorrowedDate() {
		return borroweddate;
	}
	public String getReturnDate() {
		return returndate;
	}
}
