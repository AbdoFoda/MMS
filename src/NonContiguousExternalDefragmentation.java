public class NonContiguousExternalDefragmentation implements Method {
	public void eliminatingFragmentation() {
		int sz = MMS.memory.size();
		int newPartitionSize = 0;
		for (int i = 0; i < sz; i++) {
			Partition curPartition = MMS.memory.get(i);
			curPartition.setStartAddress(i);
			if (curPartition.isEmpty()) {
				newPartitionSize += curPartition.getPartitionSize();
				MMS.memory.remove(i);
				i--;
			}
		}
		if (newPartitionSize > 0) {
			MMS.memory.add(new Partition(MMS.memory.size() - 1, newPartitionSize, 0, true));
		}
	}
}
