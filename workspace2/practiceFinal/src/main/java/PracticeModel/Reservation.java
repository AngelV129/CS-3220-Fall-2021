package PracticeModel;

public class Reservation {
	
	private int id;
	private String customerName;
	private String day;
	private String time;
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Reservation() {}
	
	public Reservation(String name, String day, String time) {
		this.customerName = name;
		this.day= day;
		this.time = time;
		
	}
	
	public Reservation(int id, String name, String day, String time) {
		this.id= id;
		this.customerName = name;
		this.day= day;
		this.time = time;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
	
	
	
//	public int getStartTime() {
//		return startTime;
//	}
//	public void setStartTime(int startTime) {
//		this.startTime = startTime;
//		this.endtime = startTime + 1;
//	}
//	public int getEndtime() {
//		return endtime;
//	}
////	public void setEndtime(int endtime) {
////		this.endtime = endtime;
////	}

}
