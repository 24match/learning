package arrayList;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * learning ArrayList
 * 参考博客 : https://www.cnblogs.com/hzmark/archive/2012/12/20/ArrayList.html
 * @Author Liang
 * @Date 2019/10/14 11:48
 * @Version
 */
public class MyArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess ,Cloneable , Serializable {
    private static final long serialVersionUID = -9189397985924370353L;
    //默认容量
    private static final int DEFAULT_CAPACITY = 10;
    //代表数组数据
    private static final Object[] EMPTY_ELEMENTDATA = new Object[0];
    //默认容量 空的数据
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = new Object[0];
    //元素数据
    transient Object[] elementData;
    //声明size , 用于表示list的大小
    private int size;
    //数组的最大容量
    private static final int MAX_ARRAY_SIZE = 2147483639;

    /**
     * 创建一个arrayList
     * 判断如果数组的下标大于0的话就实例化一个数组对象
     * @param var1 这里的var1 代表list的下标
     */
    public MyArrayList(int var1) {
        if (var1 > 0) {
            this.elementData = new Object[var1];
        } else {
            if (var1 != 0) {
                throw new IllegalArgumentException("非法参数异常:" + var1);
            }
        }
    }

    /**
     * 当不传入参数时 , 数组中的数据就是默认的空的数据
     */
    public MyArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     * 传入一个集合对象 var1
     * @param var1 集合
     */
    public MyArrayList(Collection<? extends E> var1) {
        //将集合转化成数组
        this.elementData = var1.toArray();
        //声明size 变量 是集合中的值的长度
        if ((this.size = this.elementData.length) != 0)  {
            //如果数据中的类不等于对象数组的类  ???
            if (this.elementData.getClass() != Object[].class) {
                //将数据复制到数组中
                this.elementData = Arrays.copyOf(this.elementData , this.size,Object[].class);
            }
        } else {
            // 如果集合中没有值,则数据为空
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }

    /**
     * Appends the specified element to the end of this list.
     * 是否 将指定的元素追加到此列表的末尾
     * @param var1 下标
     * @return
     */
    public boolean add(E var1) {
        this.ensureCapacityInternal(this.size + 1);
        this.elementData[this.size++] = var1;
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * 将指定元素插入此列表中的指定位置。
     * @param var1 index
     * @param var2 数组 element
     */
    public void add(int var1 , E var2) {
        //检查当前的下标是否为正确
        this.rangeCheckForAdd(var1);
        //检查数组的容积大小是否正确
        this.ensureCapacityInternal(this.size + 1);
        //arrayCopy(原数组 , 原数据的起始位置开始 ,目标数组 ,目标数组的开始位置 ,要copy的数组的长度)
        System.arraycopy(this.elementData , var1 , this.elementData ,var1 + 1 , this.size - var1);
        this.elementData[var1] = var2;
        ++this.size;
    }

    /**
     * Appends all of the elements in the specified collection to the end of this list,
     * in the order that they are returned by the specified collection's Iterator.
     * 按照指定集合的Iterator返回的顺序，将指定集合中的所有元素追加到此列表的末尾。
     * @param var1
     * @return
     */
    public boolean addAll(Collection<? extends E> var1) {
        //按适当顺序（从第一个到最后一个元素）返回包含此列表中所有元素的数组。
        Object[] var2 = var1.toArray();
        //声明var3 = var2数组的长度
        int var3 = var2.length;
        this.ensureCapacityInternal(this.size + var3);
        //将var2数组从下标0开始,复制到arrayList的elementData里,复制的个数为所有的var2中的所有数据
        System.arraycopy(var2 , 0 ,this.elementData , this.size ,var3);
        this.size += var3;
        return var3 != 0;
    }

    /**
     * Inserts all of the elements in the specified collection into this list, starting at the specified position.
     * 从指定位置开始，将指定集合中的所有元素插入此列表。
     * @param var1 下标 index
     * @param var2 集合
     * @return
     */
    public boolean addAll(int var1 , Collection<? extends E> var2) {
        //检查数组下标是否越界
        this.rangeCheckForAdd(var1);
        //返回var3 = var2转成数组
        Object[] var3 = var2.toArray();
        int var4 = var3.length;
        this.ensureCapacityInternal(this.size + var4);
        int var5 = this.size - var1;
        //如果var5 > 0 证明 var5数组不为空
        if (var5 > 0) {
            System.arraycopy(this.elementData , var1 , this.elementData , var1 + var4 , var5);
        }
        //如果数组为空
        System.arraycopy(var3 , 0 , this.elementData ,var1 , var4);
        this.size += var4;
        return var4 != 0;
    }

    /**
     * removeRange源码分析
     * 大佬的参考博客:https://www.cnblogs.com/hzmark/archive/2012/12/19/ArrayList_removeRange.html
     * 执行过程是将elementData从toIndex位置开始的元素向前移动到fromIndex，然后将toIndex位置之后的元素全部置空顺便修改size。
     * 将elementData的下标向前移动,并将移动后的数据全部修改删掉,并修改数组的长度
     * @param var1 fromIndex
     * @param var2 toIndex
     */
    protected void removeRange(int var1 , int var2) {
        ++this.modCount;
        int var3 = this.size - var2;
        System.arraycopy(this.elementData, var2 , this.elementData, var1 ,var3);
        int var4 = this.size - (var2 - var1);

        //将后面的数据全部赋值null
        for (int var5 = var4 ; var5 < this.size ; ++var5) {
            this.elementData[var5] = null;
        }
        //长度改成下标移动后的数组长度
        this.size = var4;
    }

    /**
     * 当数组的长度快要超过数组的默认的长度10时,将会动态增长数组长度
     * 比如当数组的元素有9个的时候,数组将会创建出15个elementData,
     * 使用这个方法可以清除掉数组动态增长的空值
     */
    public void trimToSize() {
        //表示内部修改的次数 , ++modCount 先加??
        ++this.modCount;
        if (this.size < this.elementData.length) {
            this.elementData = this.size == 0 ? EMPTY_ELEMENTDATA : Arrays.copyOf(this.elementData , this.size);
        }
    }

    /**
     * 检查 当方法检测到对象的并发修改，但不允许这种修改时，抛出此异常。
     * 当add方法调用add方法的时候 , 与当前方法的modCount修改次数不一致时,就是发生了并发的问题,并抛出异常
     */
    private void checkForComodification() {
        //出现并发问题
        if (MyArrayList.this.modCount != this.modCount) {
            throw new ConcurrentModificationException();
        }
    }

    /**
     * 判断下标是否大于等于数组的长度
     * @param var1 传入的下标
     */
    private void rangeCheck(int var1) {
        if (var1 >= this.size) {
            throw new IndexOutOfBoundsException(this.outOfBoundsMsg(var1));
        }
    }

    /**
     * 检查数组是否下标越界
     * @param var1 index 下标
     */
    public void rangeCheckForAdd(int var1) {
        //如果下标的值大于数组的大小或者是下标<0
        if (var1 > this.size || var1 < 0) {
            //抛出数组下标越界异常
            throw new IndexOutOfBoundsException(this.outOfBoundsMsg(var1));
        }
    }

    /**
     * 确认数组的内部容量
     * @param var1 数组的最后一个值的下标
     */
    private void ensureCapacityInternal(int var1) {
        //调用这个方法的时候统计数组的容积 , 获取最后一个值的下标
        this.ensureExplicitCapacity(calculateCapacity(this.elementData , var1));
    }

    /**
     *
     * @param var1
     */
    private void ensureExplicitCapacity(int var1) {
       ++this.modCount;
       if (var1 - this.elementData.length > 0) {
           this.grow(var1);
       }
    }

    /**
     * 数组长度自动增长
     * @param var1
     */
    private void grow(int var1) {
        int var2 = this.elementData.length;
        int var3 = var2 + (var2 >> 1);
        if (var3 - var1 < 0) {
            var3 = var1;
        }
        // 判断是否大于最大内存
        if (var3 - 2147483639 > 0) {
            var3 = hugeCapacity(var1);
        }

        this.elementData = Arrays.copyOf(this.elementData, var3);
    }

    /**
     * 判断是否超过最大内存,如果超过最大内存则抛出内存溢出的错误
     * @param var0
     * @return
     */
    private static int hugeCapacity(int var0) {
        if (var0 < 0) {
            throw new OutOfMemoryError();
        } else {
            return var0 > 2147483639 ? 2147483647 : 2147483639;
        }
    }

    /**
     * 计算容积中有多少值
     * @param var0 elementData 传入数组
     * @param var1 下标
     * @return
     */
    private static int calculateCapacity(Object[] var0, int var1) {
        return var0 == DEFAULTCAPACITY_EMPTY_ELEMENTDATA ? Math.max(10, var1) : var1;
    }

    /**
     * 数组下标越界异常提示
     * @param var1 下标
     * @return
     */
    private String outOfBoundsMsg(int var1) {
        return "下标: " + var1 + ", 大小: " + this.size ;
    }

    public E get(int var1) {
        this.rangeCheck(var1);
        return (E) this.elementData;
    }

    public E set(int var1 , E var2) {
        this.rangeCheck(var1);
        Object var3 = this.elementData(var1);
        this.elementData[var1] = var2;
        return (E) var3;
    }

    @Override
    public void forEach(Consumer consumer) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 是否包含当前下标
     * @param var1
     * @return
     */
    public boolean contains(Object var1) {
        return this.indexOf(var1) >= 0;
    }

    /**
     * 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
     * @param var1 index下标,第一次出现的下标
     * @return
     */
    public int indexOf(Object var1) {
        int var2 ;
        if (var1 == null) {
            if (var1 == null) {
                for (var2 = 0 ;var2 <this.size ; ++var2) {
                    if (this.elementData[var2] == null) {
                        return var2;
                    }
                }
            }
        } else {
            for (var2 = 0; var2 < this.size; ++var2) {
                if (var1.equals(this.elementData[var2])) {
                    return var2;
                }
            }
        }

        return -1;
    }

    /**
     * 返回最后一次在数组（字符串）出现的位置,如果字符串中没有这样的字符则返回-1
     * @param var1
     * @return
     */
    public int lastIndexOf(Object var1) {
        int var2;
        if (var1 == null) {
            for (var2 = this.size - 1; var2 >= 0 ; --var2) {
                if (this.elementData[var2] == null) {
                    return var2;
                }
            }
        } else {
            for (var2 = 0;var2 < this.size ;++var2) {
                if (var1.equals(this.elementData[var2])) {
                    return var2;
                }
            }
        }

        return -1;
    }

    /**
     * 克隆数组
     * @return
     */
    public Object clone() {
        try {
            MyArrayList var1 = (MyArrayList) super.clone();
            var1.elementData = Arrays.copyOf(this.elementData, this.size);
            var1.modCount = 0;
            return var1;
        } catch (CloneNotSupportedException var2) {
            throw new InternalError(var2);
        }
    }

    /**
     * 调用Arrays.copyOf将返回一个数组，数组内容是size个elementData的元素，即拷贝elementData从0至size-1位置的元素到新数组并返回。
     */
    public Object[] toArray() {
        return Arrays.copyOf(this.elementData ,this.size);
    }

    /**
     * 如果传入数组的长度小于size，返回一个新的数组，大小为size，类型与传入数组相同。
     * 所传入数组长度与size相等，则将elementData复制到传入数组中并返回传入的数组。
     * 若传入数组长度大于size，除了复制elementData外，还将把返回数组的第size个元素置为空。
     * @param var1
     * @param <T>
     * @return
     */
    public <T> T[] toArray(T[] var1) {
        if (var1.length < this.size) {
            //返回一个新数组,类型与传入数组相同
            return (T[]) Arrays.copyOf(this.elementData , this.size, var1.getClass());
        } else {
            System.arraycopy(this.elementData, 0 , var1 , 0 ,this.size);
            //如果传入的数组长度太长,要把最大的那个元素清空
            if (var1.length > this.size) {
                var1[this.size] = null;
            }
        }

        return var1;
    }

    E elementData(int var1) {
        return (E) this.elementData[var1];
    }

    @Override
    public boolean removeIf(Predicate predicate) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator unaryOperator) {

    }

    @Override
    public void sort(Comparator comparator) {

    }










    /**
     * SbuList 作用是返回一个List集合的其中一部分视图。
     */
    private class SubList extends AbstractList<E> implements RandomAccess {
        private final AbstractList<E> parent;
        private final int parentOffset;
        private final int offset;
        int size;

        private SubList(AbstractList<E> var2,int var3 ,int var4 ,int var5) {
            this.parent = var2;
            this.parentOffset = var4;
            this.offset = var3 + var4;
            this.size = var5 - var4;
            this.modCount = MyArrayList.this.modCount;
        }

        /**
         *
         * @param var1
         * @param var2
         * @return
         */
        public E set(int var1, E var2) {
            return null;
        }

        @Override
        public E get(int i) {
            return null;
        }

        @Override
        public int size() {
            return this.size;
        }



        /**
         * 检查是否下标越界
         * @param var1
         */
        private void rangeCheck(int var1) {
            if (var1 < 0 || var1 >= this.size) {
                throw new IndexOutOfBoundsException(this.outOfBoundsMsg(var1));
            }
        }

        /**
         * 下标越界异常信息
         * @param var1
         * @return
         */
        private String outOfBoundsMsg(int var1) {
            return "下标: " + var1 + ", 大小: " + this.size;
        }

        /**
         * 检查是否发生并发安全问题
         */
        private void checkForComodification() {

        }
    }

}

