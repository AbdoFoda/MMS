
public class Partition {
	private int starting_adress;
	private int allocated_size;
	private int size;
	private Boolean empty;
	public Partition(int starting_adress,int size,Boolean empty) {  
		this.setStarting_adress(starting_adress);
		this.setSize(size);
		this.setEmpty(empty);
		this.setAllocated_size((empty?0:size));
	}
	/**
	 * @return the starting_adress
	 */
	public int getStarting_adress() {
		return starting_adress;
	}
	/**
	 * @param starting_adress the starting_adress to set
	 */
	public void setStarting_adress(int starting_adress) {
		this.starting_adress = starting_adress;
	}
	/**
	 * @return the allocated_size
	 */
	public int getAllocated_size() {
		return allocated_size;
	}
	/**
	 * @param allocated_size the allocated_size to set
	 */
	public void setAllocated_size(int allocated_size) {
		this.allocated_size = allocated_size;
	}
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * @return the empty
	 */
	public Boolean getEmpty() {
		return empty;
	}
	/**
	 * @param empty the empty to set
	 */
	public void setEmpty(Boolean empty) {
		this.empty = empty;
	}
}
