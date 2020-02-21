class Node (val index : Int, private val connectedNodes : MutableList<Node> = mutableListOf()) {
    fun addConnection(node : Node){
        connectedNodes.add(node)
    }

    fun getConnections() : List<Node> {
        return connectedNodes
    }
}