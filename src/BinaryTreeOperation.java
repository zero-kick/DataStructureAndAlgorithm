public class BinaryTreeOperation {

    // Node Class 생성
    public static class NodeMgmt {
        Node root = null;
        public class Node {
            Node left;
            Node right;
            int value;

            public Node(int data) {
                this.value = data;
                this.left = null;
                this.right = null;
            }
        }

        // Node 생성 Method
        public boolean insertNode(int data) {
            // case 1. Node가 하나도 없을 때
            if(this.root == null) {
                this.root = new Node(data);
                return true;
            }
            // case 2. Node가 하나 이상 있을 때}
            else {
                Node findNode = this.root;
                while(true) {
                    // case 2-1. 현재 Node의 왼쪽 Child Node가 될 때
                    if(findNode.value > data) {
                        // case 2-1-1. 왼쪽 Child Node에 이미 값이 있는 경우
                        if(findNode.left != null) {
                            findNode = findNode.left;           // findNode를 바꿔주고 다시 검색
                        }
                        // case 2-1-2. 왼쪽 Child Node에 값이 없는 경우
                        else {
                            findNode.left = new Node(data);     // 현재 데이터로 Node 생성
                            return true;
                        }
                    }
                    // case 2-2. 현재 Node의 오른쪽 Child Node가 될 때
                    else {
                        // case 2-2-1. 오른쪽 Child Node에 이미 값이 있는 경우
                        if(findNode.right != null) {
                            findNode = findNode.right;          // findNode를 바꿔주고 다시 검색
                        }
                        // case 2-2-2. 오른쪽 Child Node에 값이 없는 경우
                        else {
                            findNode.right = new Node(data);     // 현재 데이터로 Node 생성
                            return true;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        NodeMgmt tree = new NodeMgmt();

        boolean flag = false;

        flag = tree.insertNode(1);
        System.out.println("flag : " + flag);
        flag = tree.insertNode(2);
        System.out.println("flag : " + flag);
        flag = tree.insertNode(3);
        System.out.println("flag : " + flag);
        flag = tree.insertNode(4);
        System.out.println("flag : " + flag);
    }
}
