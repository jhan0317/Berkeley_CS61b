

public class LinkedListDeque<Erlich> {
    private ErNode sentFront;
    private ErNode sentBack;
    private int size;


    private class ErNode<Erlich> {
        public ErNode prev;
        public Erlich item;
        public ErNode next;

        public ErNode(ErNode m, Erlich i, ErNode n) {
            prev = m;
            item = i;
            next = n;
        }
    }



    public LinkedListDeque(){
        sentFront = new ErNode(null, 64, null);
        sentBack = new ErNode(null, 65, null);
        sentFront.next = sentBack;
        sentBack.prev = sentFront;
        size = 0;
    }


    public LinkedListDeque(Erlich x) {
        sentFront = new ErNode(null, 64, null);
        sentBack = new ErNode(null, 65, null);
        sentFront.next = new ErNode (sentFront, x, sentBack);
        sentBack.prev = sentFront.next;
        size = 1;
    }

    public void addFirst(Erlich x) {
        sentFront.next = new ErNode (sentFront, x, sentFront.next);
        sentFront.next.next.prev = sentFront.next;
        size += 1;
    }


    public void addLast(Erlich x) {
        sentBack.prev = new ErNode (sentBack.prev, x, sentBack);
        sentBack.prev.prev.next = sentBack.prev;
        size += 1;
    }


    public boolean isEmpty() {
        if(sentFront.next == sentBack) {
            return true;
        }
        return false;
    }


    public int size() {
        return size;
    }


    public void printDeque() {
        ErNode temp = sentFront.next;

        for (int i=0; i<size; i++) {
            System.out.print(temp.item+" ");
            temp = temp.next;
        }
    }


    public Erlich removeFirst() {
        if (sentFront.next == sentBack) {
            return null;
        }
        Erlich firstItem = (Erlich) sentFront.next.item;
        sentFront.next = sentFront.next.next;
        size -= 1;
        return firstItem;
    }


    public Erlich removeLast() {
        if (sentFront.next == sentBack) {
            return null;
        }
        Erlich lastItem = (Erlich) sentBack.prev.item;
        sentBack.prev = sentBack.prev.prev;
        size -= 1;
        return lastItem;
    }


    public Erlich get(int t) {
        if (sentFront.next == sentBack) {
            return null;
        }
        ErNode temp = sentFront;

        for (int i=1; i<=t;i++) {
            temp = temp.next;
        }
        return (Erlich) temp.item;

    }


    public static void main(String[] args){
        LinkedListDeque<String> S = new LinkedListDeque<>("init");
        S.addFirst("First");
        S.addLast("Last");
        S.addFirst("VeryFirst");
//        System.out.println(S.isEmpty());
//        System.out.println(S.sentFront.next.next.item);
//        System.out.println(S.sentFront.next.item);
        S.printDeque();
        System.out.println(" ");
        System.out.println(S.removeFirst());
        S.printDeque();
        System.out.println(S.removeLast());
        S.printDeque();
        System.out.println(" ");
        System.out.println(S.get(1));
        System.out.println(" ");
        S.printDeque();

    }

//    public void addFirst(Erlich item){
//
//    }
//
//    public void addLast(Erlich item){
//        IntNode p = sentinel;
//
//

}
