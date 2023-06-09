public class BinaryTreeOperation {

    public static class Node {
        Node left;
        Node right;
        int value;

        public Node(int data) {
            this.value = data;
            this.left = null;
            this.right = null;
        }
    }

    // Node Class 생성
    public static class NodeMgmt {
        Node root = null;

        // Node 생성 Method
        public boolean insertNode(int data) {
            // case 1. Node가 하나도 없을 때
            if(this.root == null) {
                this.root = new Node(data);
                return true;
            }
            // case 2. Node가 하나 이상 있을 때
            else {
                Node findNode = this.root;
                while(true) {
                    // case 2-1. 현재 Node의 value 보다 작을 때 (왼쪽 Child Node)
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
                    // case 2-2. 현재 Node의 value 보다 크거나 같을 때 (오른쪽 Child Node)
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

        public Node Search(int data) {
            // case 1. Node가 하나도 없을 때
            if(this.root == null) {
                return null;
            }
            // case 2. Node가 하나 이상 있을 때
            else {
                Node findNode = this.root;
                while(findNode != null) {
                    // case 2-1. 찾고 있는 Node이면 return
                    if(findNode.value == data) {
                        return findNode;
                    }
                    // case 2-2. 현재 Node의 value 보다 작을 때 (왼쪽 Child Node)
                    else if(findNode.value > data) {
                        findNode = findNode.left;
                    }
                    // case 2-3. 현재 Node의 value 보다 크거나 같을 때 (오른쪽 Child Node)
                    else {
                        findNode = findNode.right;
                    }
                }
                return null;
            }
        }

        public boolean delete (int findVal) {
            boolean searched = false;

            Node currParentNode = this.root;
            Node currNode = this.root;

            // Edge Case 1. Node가 하나도 없을 때
            if (this.root == null) {
                return false;
            }
            // Edge Case 2. Node가 하나만 있고, 해당 Node가 삭제할 Node일 때
            else {
                if (this.root.value == findVal
                    && this.root.left == null
                    && this.root.right == null) {
                    this.root = null;
                    return true;
                }

                while (currNode != null) {
                    if (currNode.value == findVal) {
                        searched = true;
                        break;
                    } else if (currNode.value > findVal) {
                        currParentNode = currNode;
                        currNode = currNode.left;
                    } else {
                        currParentNode = currNode;
                        currNode = currNode.right;
                    }
                }

                if(searched == false) {
                    return false;
                }
            }

            // currNode에 삭제 대상 Node가 있고,
            // currParentNode에는 삭제 대상 Node의 parent Node가 있다.
            // case 1. Leaf Node 삭제
            if (currNode.left == null && currNode.right == null) {
                if (currParentNode.value > findVal) {
                    currParentNode.left = null;
                    currNode = null;
                } else {
                    currParentNode.right = null;
                    currNode = null;
                }
                return true;
            }
            // case 2. Child Node가 하나인 Node 삭제
            // case 2-1. 왼쪽에 Child Node가 있는 경우
            else if (currNode.left != null && currNode.right == null) {
                if (currParentNode.value > currNode.value) {
                    currParentNode.left = currNode.left;
                    currNode = null;
                } else {
                    currParentNode.right = currNode.left;
                    currNode = null;
                }
                return true;
            }
            // case 2-2. 오른쪽에 Child Node가 있는 경우
            else if (currNode.left == null && currNode.right != null) {
                if (currParentNode.value > currNode.value) {
                    currParentNode.left = currNode.right;
                    currNode = null;
                } else {
                    currParentNode.right = currNode.right;
                    currNode = null;
                }
                return true;
            }
            // case 3. Child Node가 두 개인 Node 삭제
            else {
                // case 3-1. 삭제할 Node의 오른쪽 Child 중 가장 작은 값을 삭제할 Node의 Parent가 가리키도록 한다.
                //           (삭제할 Node가 Parent Node의 왼쪽에 있을 때)
                if (currParentNode.value > findVal) {
                    Node changeNode = currNode.right;
                    Node changeParentNode = currNode.right;
                    while (changeNode.left != null) {
                        changeParentNode = changeNode;
                        changeNode = changeNode.left;
                    }
                    // case 3-1-1. 가장 작은 값을 가진 Node(changeNode)가 Child Node를 갖지 않는 경우
                    if (changeNode.right == null) {
                        changeParentNode.left = null;
                    }
                    // case 3-1-2. 가장 작은 값을 가진 Node(changeNode)가 오른쪽 Child Node를 갖는 경우
                    else {
                        changeParentNode.left = changeNode.right;
                    }

                    // 삭제 대상 Node 자리에 changeNode로 대체
                    currParentNode.left = changeNode;

                    // 기존에 삭제 대상 Node에 연결되어있던 Child를 연결
                    changeNode.left = currNode.left;
                    changeNode.right = currNode.right;

                    currNode = null;

                }
                // case 3-2. 삭제할 Node의 오른쪽 Child 중 가장 작은 값을 삭제할 Node의 Parent가 가리키도록 한다.
                //           (삭제할 Node가 Parent Node의 오른쪽에 있을 때)
                else {
                    Node changeNode = currNode.right;
                    Node changeParentNode = currNode.right;
                    while (changeNode.left != null) {
                        changeParentNode = changeNode;
                        changeNode = changeNode.left;
                    }
                    // case 3-2-1. 가장 작은 값을 가진 Node(changeNode)가 Child Node를 갖지 않는 경우
                    if (changeNode.right == null) {
                        changeParentNode.left = null;
                    }
                    // case 3-2-2. 가장 작은 값을 가진 Node(changeNode)가 오른쪽 Child Node를 갖는 경우
                    else {
                        changeParentNode.left = changeNode.right;
                    }

                    // 삭제 대상 Node 자리에 changeNode로 대체
                    currParentNode.right = changeNode;

                    // 기존에 삭제 대상 Node에 연결되어있던 Child를 연결
                    changeNode.left = currNode.left;
                    changeNode.right = currNode.right;

                    currNode = null;
                }
            }
            return true;
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

        Node findNode = tree.Search(3);
        System.out.println(findNode.value);
        System.out.println(findNode.right.value);
        try {
            System.out.println(findNode.left.value);
        } catch (Exception e) {
            System.out.println("Node does not exist");
        }

        NodeMgmt tree2 = new NodeMgmt();

        tree2.insertNode(10);
        tree2.insertNode(7);
        tree2.insertNode(6);
        tree2.insertNode(8);
        tree2.insertNode(15);
        tree2.insertNode(13);
        tree2.insertNode(11);
        tree2.insertNode(14);
        tree2.insertNode(18);
        tree2.insertNode(16);
        tree2.insertNode(17);
        tree2.insertNode(19);
        tree2.delete(15);

        System.out.println("root : " + tree2.root.value);

        System.out.println("root.left : " + tree2.root.left.value);
        System.out.println("root.left.left : " + tree2.root.left.left.value);
        System.out.println("root.left.right : " + tree2.root.left.right.value);

        System.out.println("root.right : " + tree2.root.right.value);
        System.out.println("root.right.left : " + tree2.root.right.left.value);
        System.out.println("root.right.right : " + tree2.root.right.right.value);

        System.out.println("root.right.right.left : " + tree2.root.right.right.left.value);
        System.out.println("root.right.right.right : " + tree2.root.right.right.right.value);

    }
}
