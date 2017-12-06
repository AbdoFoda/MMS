import java.util.ArrayList;

public class bestFit implements Policy {
	private Integer OO = (int) 1e9;

	@Override
	public Integer selectIndex(ArrayList<Partition> p, Integer memory_size) {
		// TODO Auto-generated method stub
		int mn_size = OO, ret = -1;
		for (int i = 0; i < p.size(); ++i) {
			if (p.get(i).getPartitionSize() < mn_size && p.get(i).isEmpty()
					&& p.get(i).getPartitionSize() >= memory_size) {
				mn_size = p.get(i).getPartitionSize();
				ret = i;
			}
		}
		return ret;
	}

}
