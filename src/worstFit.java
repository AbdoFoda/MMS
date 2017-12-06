import java.util.ArrayList;

public class worstFit implements Policy {

	@Override
	public Integer selectIndex(ArrayList<Partition> p, Integer memory_size) {
		// TODO Auto-generated method stub
		int mx_size = 0, ret = -1;
		for (int i = 0; i < p.size(); ++i) {
			if (p.get(i).getPartitionSize() > mx_size && p.get(i).isEmpty()
					&& p.get(i).getPartitionSize() >= memory_size) {
				mx_size = p.get(i).getPartitionSize();
				ret = i;
			}
		}
		return ret;
	}
}
