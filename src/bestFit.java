import java.util.ArrayList;

public class bestFit implements Policy {
	private Integer OO = (int) 1e9;

	public Integer selectIndex(Integer memory_size) {
		int mn_size = OO, ret = -1;
		for (int i = 0; i < MMS.memory.size(); ++i) {
			if (MMS.memory.get(i).getPartitionSize() < mn_size && MMS.memory.get(i).isEmpty()
					&& MMS.memory.get(i).getPartitionSize() >= memory_size) {
				mn_size = MMS.memory.get(i).getPartitionSize();
				ret = i;
			}
		}
		return ret;
	}

}
