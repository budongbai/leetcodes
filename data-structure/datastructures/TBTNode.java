package datastructures;

/**
 * @author budongbai
 * @version 2017年5月10日下午7:28:53
 */
public class TBTNode<T extends Comparable<T>> {

    T key;
    TBTNode<T> left;
    TBTNode<T> right;
    boolean lTag;// false表示孩子，true表示前驱
    boolean rTag;// fasle表示孩子，true表示后继

    public TBTNode(T key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "key：" + key;
    }

}
