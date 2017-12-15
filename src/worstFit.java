import java.util.ArrayList;

public class worstFit implements Policy {
	public Integer selectIndex(Integer memory_size) {
		int mx_size = 0, ret = -1;
		for (int i = 0; i < MMS.memory.size(); ++i) {
			if (MMS.memory.get(i).getPartitionSize() > mx_size && MMS.memory.get(i).isEmpty()
					&& MMS.memory.get(i).getPartitionSize() >= memory_size) {
				mx_size = MMS.memory.get(i).getPartitionSize();
				ret = i;
			}
		}
		return ret;
	}
}
