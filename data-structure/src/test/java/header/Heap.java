package header;

import java.util.*;

public class Heap {

    public Queue<ValueIndexPair> queue;
    public Set<Integer> removeSet;

    // init
    public Heap() {
        queue = new PriorityQueue<ValueIndexPair>(new Comparator<ValueIndexPair>() {
            @Override
            public int compare(ValueIndexPair o1, ValueIndexPair o2) {
                return o2.value - o1.value;
            }
        });
        removeSet = new HashSet<>();
    }

    // isEmpty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // add
    public void offer(int index, int value) {
        queue.offer(new ValueIndexPair(index, value));
    }

    // remove
    public void remove(int index) {
        removeSet.add(index);
    }

    // lazy remove
    public void lazyRemove() {
        while (!queue.isEmpty() && removeSet.contains(queue.peek().index)) {
            ValueIndexPair poll = queue.poll();
            removeSet.remove(poll.index);
        }
    }

    // peek
    public ValueIndexPair peek() {
        lazyRemove();
        return queue.peek();
    }

    // poll
    public ValueIndexPair poll() {
        lazyRemove();
        return queue.poll();
    }

}
