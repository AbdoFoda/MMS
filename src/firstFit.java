import java.util.ArrayList;

public class firstFit implements Policy {

	@Override
	public Integer selectIndex(ArrayList<Partition> p, Integer memory_size) {
		// TODO Auto-generated method stub
		Integer ret = -1;
		for (int i = 0; i < p.size(); ++i) {
			if (p.get(i).isEmpty() && p.get(i).getPartitionSize() >= memory_size) {
				ret = i;
				break;
			}
		}
		return ret;
	}

}
