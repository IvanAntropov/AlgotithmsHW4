
// Что такое хеш-функция? Объяснить пятикласснику

// Хеш функция есть алгоритм (набор последовательных действий), который входные данные превращает в одну строчку данных
// (обычно состоящую из набора различных символов) длина строки фиксированна в большинстве случаев.
//
// Превед медвед -> Хеш функция, которая двигает буквы на два знака вперед -> Стжджё ожёджё
//
// В общем работает как шифр в записках шпионов.
//
// Благодаря тому что алгоритм строгий, одни и те же входные данные будут
// превращаться в одинаковые строки, что позволяет затем засунуть это все в массив, привязав данные к их хэш строке,
// а потом доставать нужные данные по индексу.
//
// Допустим;
// Наша функция:
// HashDef(data){
// data = data+5*2+3
// }
// data = 5
// после функция получим ключ 18,
// запишем в массив [key: 18, data: 5]
// а затем просто если надо найти data 5, пускаем data через функцию и ищем по получившемуся key индексу


package Seminar_4;
import java.util.*;

public class Tree {

    public static class Node {
        int value;
        Node right;
        Node left;

        public Node(int value) {
            this.value = value;
        }
    }

    // Обходы дерева
    // 1

    public static void directRun(Node root, String sp){
        if(root != null){
            System.out.println( sp + root.value);
            directRun(root.left, sp + "  ");
            directRun(root.right, sp + "  ");
        }
    }

    // 2
    public static void widthRun(Node tree){
        List<Node> line = new ArrayList<>();
        line.add(tree);
        String str = "";
        while (line.size() > 0){
            List<Node> currentLine = new ArrayList<>();
            for(Node node: line){
                System.out.println( str + node.value );
                if(node.right != null ){
                    currentLine.add(node.right);
                }
                if(node.left != null){
                    currentLine.add(node.left);
                }
            }
            str += "  ";
            line = currentLine;
        }
    }

    // 3

    public static void iterativeRun(Node tree) {
        if (tree == null) {
            return;
        }
        Stack<Node> stackOfNodes = new Stack<>();
        stackOfNodes.push(tree);
        List<Node> ListForHelp = new ArrayList<>();
        while (!stackOfNodes.empty())
        {
            Node currentNode = stackOfNodes.pop();
            ListForHelp.add(currentNode);
            if (currentNode.left != null) {
                stackOfNodes.push(currentNode.left);
            }
            if (currentNode.right != null) {
                stackOfNodes.push(currentNode.right);
            }

        }
        for (Node node : ListForHelp) {
            System.out.print(node.value + " ");
        }
    }


    public static void main(String[] args) {
        Node tree = new Node(5);
        Node l1 = new Node(4);
        Node r1 = new Node(3);
        Node l1l2 = new Node(2);
        Node l1r2 = new Node(1);
        Node r1l1 = new Node(6);
        Node r1l2 = new Node(7);

        tree.left = l1;
        tree.right = r1;
        tree.left.left = l1l2;
        tree.left.right = l1r2;
        tree.right.left = r1l1 ;
        tree.right.right = r1l2;

        directRun(tree,"");
        widthRun(tree);
        iterativeRun(tree);

    }

}