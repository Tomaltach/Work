package ie.tom.abp.entity;

public class Employee {
	private String clock;
	private String jobtype;
	private String jobarea;
	
	public Employee(String clock, String jobtype, String jobarea) {
		this.clock = clock;
		this.jobtype = jobtype;
		this.jobarea = jobarea;
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
	public String getJobarea() {
		return jobarea;
	}
	public void setJobarea(String jobarea) {
		this.jobarea = jobarea;
	}
}
