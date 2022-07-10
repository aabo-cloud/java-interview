package algorithm.header;

import lombok.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author aabo
 * @createTime 2022/6/11 20:51
 */
@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ListItem<T extends Number> implements Comparable<ListItem<T>> {

    public int index;

    public T data;

    public ListItem(int index, T data) {
        this.index = index;
        this.data = data;
    }

    @Override
    public int compareTo(ListItem o) {
        return this.data.intValue() - o.data.intValue();
    }

}
