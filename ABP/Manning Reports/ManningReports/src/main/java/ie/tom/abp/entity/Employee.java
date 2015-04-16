package ie.tom.abp.entity;

public class Employee {
	private String clock;
	private String jobtype;
	
	public Employee(String clock, String jobtype) {
		this.clock = clock;
		this.jobtype = jobtype;
	}
	public String getClock() {
		return clock;
	}
	public void setClock(String clock) {
		this.clock = clock;
	}
	public String getJobtype() {
		return jobtype;
	}
	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}
}
