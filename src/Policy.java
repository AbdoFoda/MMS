import java.util.ArrayList;

public interface Policy {
	public Integer selectIndex(ArrayList<Partition> p,Integer memory_size);
}
