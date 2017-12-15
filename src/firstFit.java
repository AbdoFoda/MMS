public class firstFit implements Policy {
	public Integer selectIndex(Integer memory_size) {
		Integer ret = -1;
		for (int i = 0; i < MMS.memory.size(); ++i) {
			if (MMS.memory.get(i).isEmpty() && MMS.memory.get(i).getPartitionSize() >= memory_size) {
				ret = i;
				break;
			}
		}
		return ret;
	}

}
