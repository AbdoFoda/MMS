
public class ContiguousExternalDefragmentation implements Method {
	public void eliminatingFragmentation() {
		int sz = MMS.memory.size();
		for (int i = 0; i < sz; i++) {
			Partition curPartition = MMS.memory.get(i);
			curPartition.setStartAddress(i);
			if (!curPartition.isEmpty())
				continue;
			if (i > 0) {
				Partition prevPartition = MMS.memory.get(i - 1);
				if (prevPartition.isEmpty()) {
					prevPartition.setPartitionSize(curPartition.getPartitionSize() + prevPartition.getPartitionSize());
				}
				MMS.memory.remove(i);
				i--;
			}
		}
	}
}
