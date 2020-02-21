import java.util.*

class Graph (private val nodes : MutableList<Node> = mutableListOf()) {
    fun addNode(node : Node){
        nodes.add(node)
    }

    fun connectNodes(table : List<List<Int>>) {
        val n = nodes.size
        for(i in 0 until n){
            val currentNode = getNode(i)
            for(j in 0 until n)
                if(i != j && table[i][j] == 1)
                    currentNode.addConnection(getNode(j))
        }
    }

    fun getCount() : Int{
        return nodes.size
    }

    private fun getNode(index : Int) : Node{
        return nodes[index]
    }

    fun wideSearch(index : Int) : List<Int> {
        val usedIndexes = hashSetOf<Int>()

        val q = LinkedList<Node>()
        q.add(nodes[index])

        while (!q.isEmpty()){
            val currentNode = q.pop()

            if(!usedIndexes.add(currentNode.index))
                continue

            q.addAll(currentNode.getConnections())
        }

        return usedIndexes.toList()
    }
}