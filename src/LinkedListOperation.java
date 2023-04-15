public class LinkedListOperation {

    // Node 클래스 구현
    public static class Node<T> {
        T data;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    // SingleLinkedList 구현
    public static class SingleLinkedList<T> {
        public Node<T> head = null;

        // Node 추가 메소드
        public void addNode(T data) {
            if(head == null) {
                head = new Node<T>(data);
            } else {
                Node<T> node = this.head;
                while(node.next != null) {
                    node = node.next;
                }
                node.next = new Node<T>(data);
            }
        }

        // Node 출력 메소드
        public void printAll() {
            String str = "";

            if(head != null) {
                Node<T> node = this.head;
                str = String.valueOf(node.data);

                while(node.next != null) {
                    node = node.next;
                    str += ", " + String.valueOf(node.data);
                }
            }

            System.out.println(str);
        }

        public Node<T> search(T data) {
            if(this.head == null) {
                return null;
            } else {
                Node<T> node = this.head;

                while(node != null) {
                    if(node.data == data) {
                        return node;
                    } else {
                        node = node.next;
                    }
                }

                return null;
            }
        }

        public void addNodeInside(T data, T isData) {
            Node<T> bfNode = this.search(isData);

            if(bfNode == null) {
                this.addNode(data);
            } else {
                Node<T> nextNode = bfNode.next;
                bfNode.next = new Node<T>(data);
                bfNode.next.next = nextNode;
            }
        }

        public boolean delNode(T isdata) {
            if(this.head == null) {
                return false;
            } else {
                Node<T> node = this.head;
                if(node.data == isdata) {
                    this.head = this.head.next;
                    return true;
                } else {
                    while(node.next != null) {
                        if(node.next.data == isdata) {
                            node.next = node.next.next;
                            return true;
                        }
                        node = node.next;
                    }

                    return false;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Node 선언
        System.out.println("======================== Node 선언 ========================");

        Node<Integer> node1 = new Node<Integer>(1);
        Node<Integer> node2 = new Node<Integer>(2);

        // 첫번째 노드
        Node head = node1;
        // 두번째 노드의 정보를 저장
        head.next = node2;

        System.out.println(head.data);
        System.out.println(head.next);
        System.out.println(head.next.data);

        // SingleLinkedList 선언
        System.out.println("");
        System.out.println("======================== LinkedList 선언 ========================");

        SingleLinkedList<Integer> linkedList = new SingleLinkedList<Integer>();
        
        // linkedList에 node 추가
        linkedList.addNode(1);
        System.out.println(linkedList.head.data);
        
        linkedList.addNode(2);
        System.out.println(linkedList.head.next);
        System.out.println(linkedList.head.next.data);

        // LinkedList 데이터 출력
        System.out.println("");
        System.out.println("======================== LinkedList 출력 ========================");

        SingleLinkedList<Integer> linkedList2 = new SingleLinkedList<Integer>();

        linkedList2.addNode(1);
        linkedList2.addNode(2);
        linkedList2.addNode(3);

        linkedList2.printAll();

        // LinkedList 중간 노드 삽입
        System.out.println("");
        System.out.println("======================== LinkedList 중간 노드 삽입 ========================");

        SingleLinkedList<Integer> linkedList3 = new SingleLinkedList<Integer>();

        linkedList3.addNode(1);
        linkedList3.addNode(2);
        linkedList3.addNode(3);
        linkedList3.printAll();

        // 2 뒤에 4 삽입
        linkedList3.addNodeInside(4, 2);
        linkedList3.printAll();

        // 3 뒤에 5 삽입
        linkedList3.addNodeInside(5, 3);
        linkedList3.printAll();

        // 없는 데이터를 찾도록 하여 맨 뒤에 6 삽입
        linkedList3.addNodeInside(6, 20);
        linkedList3.printAll();

        // LinkedList 특정 노드 삭제
        System.out.println("");
        System.out.println("======================== LinkedList 특정 노드 삭제 ========================");

        SingleLinkedList<Integer> linkedList4 = new SingleLinkedList<Integer>();

        linkedList4.addNode(1);
        linkedList4.addNode(2);
        linkedList4.addNode(3);
        linkedList4.addNode(4);
        linkedList4.addNode(5);
        linkedList4.printAll();

        boolean flag = true;

        // 중간 노드 삭제
        flag = linkedList4.delNode(2);
        System.out.print(flag + " : ");
        linkedList4.printAll();

        // 헤드 노드 삭제
        flag = linkedList4.delNode(1);
        System.out.print(flag + " : ");
        linkedList4.printAll();

        // 마지막 노드 삭제
        flag = linkedList4.delNode(5);
        System.out.print(flag + " : ");
        linkedList4.printAll();

        // 없는 데이터 노드 삭제
        flag = linkedList4.delNode(20);
        System.out.print(flag + " : ");
        linkedList4.printAll();
    }
}
