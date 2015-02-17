package ie.tom.abp.entity;

import java.util.List;

public class BigData {
	private List<Integer> rows;
	private List<Integer> cols;
	private List<Data> data;
	
	public List<Integer> getRows() {
		return rows;
	}
	public void setRows(List<Integer> rows) {
		this.rows = rows;
	}
	public List<Integer> getCols() {
		return cols;
	}
	public void setCols(List<Integer> cols) {
		this.cols = cols;
	}
	public List<Data> getData() {
		return data;
	}
	public void setData(List<Data> data) {
		this.data = data;
	}
}
