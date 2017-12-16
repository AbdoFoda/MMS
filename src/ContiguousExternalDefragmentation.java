
public class ContiguousExternalDefragmentation implements Method {
	public void eliminatingFragmentation() {
		int sz = MMS.memory.size();
		for (int i = 1; i < sz; i++) {
			Partition curPartition = MMS.memory.get(i);
			Partition prevPartition = MMS.memory.get(i - 1);
			if (prevPartition.isEmpty() && curPartition.isEmpty()) {
				prevPartition.setPartitionSize(curPartition.getPartitionSize() + prevPartition.getPartitionSize());
				MMS.memory.remove(i);
				i--;
			}

		}
	}
}
