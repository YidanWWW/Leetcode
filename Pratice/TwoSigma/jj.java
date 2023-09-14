public static int countPythagoreanTriples(int treeNodes, List<Integer> treeFrom, List<Integer> treeTo, int x, int y, int z) {
    // 创建节点数组
    Node[] nodes = new Node[treeNodes];

    for (int i = 0; i < treeNodes; i++) {
        nodes[i] = new Node(i);
    }

    // 创建树的结构
    for (int i = 0; i < treeFrom.size(); i++) {
        int from = treeFrom.get(i);
        int to = treeTo.get(i);
        nodes[from].neighbors.add(to);
        nodes[to].neighbors.add(from); // 由于是双向边，需要添加反向连接
    }

    int specialNodeCount = 0;

    // 遍历所有可能的三个节点组合
    for (int i = 0; i < treeNodes; i++) {
        for (int j = i + 1; j < treeNodes; j++) {
            for (int k = j + 1; k < treeNodes; k++) {
                int distX = calculateDistance(nodes, i, j);
                int distY = calculateDistance(nodes, j, k);
                int distZ = calculateDistance(nodes, k, i);

                // 检查是否构成勾股定理三元组
                if (isPythagoreanTriple(distX, distY, distZ, x, y, z)) {
                    specialNodeCount++;
                }
            }
        }
    }

    return specialNodeCount;
}

// 计算两个节点之间的距离，使用DFS
private static int calculateDistance(Node[] nodes, int source, int target) {
    boolean[] visited = new boolean[nodes.length];
    int[] distance = new int[nodes.length];

    Stack<Integer> stack = new Stack<>();
    stack.push(source);
    visited[source] = true;

    while (!stack.isEmpty()) {
        int current = stack.pop();
        if (current == target) {
            return distance[current];
        }
        for (int neighbor : nodes[current].neighbors) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                stack.push(neighbor);
                distance[neighbor] = distance[current] + 1;
            }
        }
    }

    return -1; // 返回-1表示没有路径
}

// 检查是否构成勾股定理三元组
private static boolean isPythagoreanTriple(int a, int b, int c, int x, int y, int z) {
    return (a == x && b == y && c == z) ||
           (a == x && b == z && c == y) ||
           (a == y && b == x && c == z) ||
           (a == y && b == z && c == x) ||
           (a == z && b == x && c == y) ||
           (a == z && b == y && c == x);
}
