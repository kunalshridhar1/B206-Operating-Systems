import java.util.*;

public class MemoryManager {
    static class Block {
        int start;
        int size;
        boolean allocated;
        int pid;

        Block(int start, int size) {
            this.start = start;
            this.size = size;
            this.allocated = false;
            this.pid = -1;
        }
    }

    List<Block> memory;

    public MemoryManager(int totalSize) {
        memory = new ArrayList<>();
        memory.add(new Block(0, totalSize));
    }

    public boolean allocate(int pid, int size, String strategy) {
        Block bestFit = null;

        for (Block block : memory) {
            if (!block.allocated && block.size >= size) {
                if (strategy.equals("first") || bestFit == null || block.size < bestFit.size)
                    bestFit = block;

                if (strategy.equals("first"))
                    break;
            }
        }

        if (bestFit != null) {
            if (bestFit.size > size) {
                memory.add(memory.indexOf(bestFit) + 1, new Block(bestFit.start + size, bestFit.size - size));
            }

            bestFit.size = size;
            bestFit.allocated = true;
            bestFit.pid = pid;

            return true;
        }

        return false;
    }

    public void deallocate(int pid) {
        for (Block block : memory) {
            if (block.allocated && block.pid == pid) {
                block.allocated = false;
                block.pid = -1;
            }
        }
    }
}
