public class ArrayDeque<Jared> {

    private Jared[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    public ArrayDeque() {
        items = (Jared[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    public int size() {
        return this.size;
    }

    public ArrayDeque(Jared x) {
        items = (Jared[]) new Object[8];
        items[1] = x;
        nextFirst = 0;
        nextLast = 2;
        size = 1;
    }

    private void resize(int capacity) {
        Jared[] a = (Jared[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void addLast(Jared x) {
        if (size == items.length) {
            resize(size * 5);
            nextFirst = items.length - 1;
            nextLast = size;
        }

        items[nextLast] = x;
        size += 1;

        if(nextLast == items.length) {
            nextLast = 0;
            return;
        }

        nextLast += 1;

    }

    public void addFirst(Jared x) {
        if (size == items.length) {
            resize(size * 5);
            nextFirst = items.length - 1;
            nextLast = size;
        }

        items[nextFirst] = x;
        size += 1;

        if(nextFirst == 0) {
            nextFirst = items.length - 1;
            return;
        }

        nextFirst -= 1;
    }

    public Jared get(int i) {
        if (i > this.size) {
            return null;
        }

        int trueIndex = getTrueIndex(i);
        return items[trueIndex];
    }

    public Jared getFirst() {
        int firstIndex = getTrueIndex(0);
        return items[firstIndex];

    }

    public Jared getLast() {

        int lastIndex = 0;

        if ((nextLast-1) >= 0) {
            lastIndex = nextLast - 1;
        }
        else {
            lastIndex = nextLast - 1 + items.length;
        }
        return items[lastIndex];
    }

    public Jared removeFirst() {

        Jared removeItem = getFirst();

        int firstIndex = getTrueIndex(0);
        items[firstIndex] = null;
        nextFirst = firstIndex;
        size -= 1;

        return removeItem;
    }

    public Jared removeLast() {

        Jared removeItem = getLast();
        int lastIndex = 0;

        if ((nextLast-1) >= 0) {
            lastIndex = nextLast - 1;
        }
        else {
            lastIndex = nextLast - 1 + items.length;
        }
        items[lastIndex] = null;

        nextLast = lastIndex;
        size -= 1;

        return removeItem;
    }

    /* get first or last: input = 0 */
    public int getTrueIndex(int i) {
        return (i + nextFirst + 1) % items.length;
    }

    /* disc03 */
    public static int[] insert(int[] arr, int item, int position) {
        int[] temp = new int[arr.length + 1];
        position = Math.min(arr.length, position);

        /* 自己写的版本。*/
//        if(position > (arr.length - 1)) {
//            System.arraycopy(arr,0,temp,0, arr.length);
//            temp[temp.length-1] = item;
//        }

        temp[position] = item;
        for (int i=0;i<position; i++) {
            temp[i] = arr[i];
        }
        for(int i=position; i<arr.length; i++) {
            temp[i+1] = arr[i];
        }

        return temp;

    }

    /* disc03 */
    public static void reverse(int[] arr) {
        /* 自己写的 */
//        int[] temp = new int[arr.length];
//        System.arraycopy(arr, 0, temp, 0, arr.length);
//        for (int i=0; i<arr.length; i++) {
//            int j = arr.length - 1 - i;
//            arr[i] = temp[j];
//        }

        /* 答案 */

        for(int i=0; i<arr.length/2; i++) {
            int j = arr.length - 1 - i;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    /* disc03 */
    public static int[] replicate(int[] arr) {
        int[] temp = new int[arr.length*2];
        for (int i=0; i<arr.length; i=i+1) {
            temp[i*2] = arr[i];
            temp[i*2+1] = arr[i];
        }
        return temp;
    }



    public void printAll() {
        System.out.println("The size is " + size + ".");
        System.out.println("The first item is " + getFirst() + ".");
        System.out.println("The last item is " + getLast() + ".");
        for (int i=0; i<size; i++) {
            System.out.print(this.get(i) + " ");
        }

    }

    public static void main(String[] args) {
        ArrayDeque<Integer> aaaaa = new ArrayDeque<> (15);
        aaaaa.addFirst(15);
        aaaaa.addLast(16);
        aaaaa.addLast(16);
        aaaaa.addLast(16);
        aaaaa.addLast(16);
        aaaaa.addLast(16);
        aaaaa.addLast(16);
        aaaaa.addLast(16);
        aaaaa.addFirst(16);
        aaaaa.removeFirst();
        aaaaa.removeLast();
        aaaaa.printAll();

        int[] b = {1, 2, 3, 4, 5};
        int[] temp = insert(b, 10, 2);
        System.out.println(temp[2]);
        reverse(temp);
        int[] result = replicate(temp);
        System.out.println(temp[0]);
        System.out.println(temp[1]);
        System.out.println(temp[2]);
        System.out.println(temp[3]);
        System.out.println(temp[4]);
        System.out.println(temp[5]);

        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
        System.out.println(result[3]);
        System.out.println(result[4]);
        System.out.println(result[5]);

    }


}
