
public class InternalDefragmentation implements Method {

	public void eliminatingFragmentation() {
		for (int i = 0; i < MMS.memory.size(); i++) {
			Partition curPartition = MMS.memory.get(i);
			if (!curPartition.isEmpty() && curPartition.getReservedSize() < curPartition.getPartitionSize()) {
				int sz = curPartition.getPartitionSize() - curPartition.getReservedSize();
				Partition p = new Partition(curPartition.getStartAddress() + curPartition.getReservedSize(), sz, 0,
						true);
				curPartition.setPartitionSize(curPartition.getReservedSize());
				MMS.memory.add(i + 1, p);
			}
		}
	}
}
