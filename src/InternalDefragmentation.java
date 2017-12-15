
public class InternalDefragmentation implements Method {

	public void eliminatingFragmentation() {
		for (int i = 0; i < MMS.memory.size(); i++) {
			Partition curPartition = MMS.memory.get(i);
			curPartition.setStartAddress(i);
			if (curPartition.isEmpty() == true)
				continue;
			if (curPartition.getReservedSize() < curPartition.getPartitionSize()) {
				int sz = curPartition.getPartitionSize() - curPartition.getReservedSize();
				Partition p = new Partition(0, sz, 0, false);
				curPartition.setPartitionSize(curPartition.getReservedSize());
				MMS.memory.add(i + 1, p);
			}
		}
	}
}
