import java.io.File
import java.io.FileNotFoundException
import java.util.*
import kotlin.collections.HashSet

fun main(vararg args : String) {
    val file = File("in.txt")

    try{
        val input = file.inputStream()
        val sc = Scanner(input)
        val n = sc.nextLine().toInt()

        val graph = Graph()

        val table = fillTable(graph, n, sc)

        graph.connectNodes(table)

        File("out.txt").writeText(calculateCount(graph).toString())
    } catch (e : FileNotFoundException){
        println("in.txt file doesn't exists")
    }
}

fun calculateCount(graph: Graph) : Int{
    val n = graph.getCount()
    var count = 0

    val usedIndexes = HashSet<Int>()

    for(i in 0 until n){
        if(usedIndexes.add(i)){
            usedIndexes.addAll(graph.wideSearch(i))
            count++
        }
    }

    return count
}

fun fillTable(graph : Graph, n : Int, sc : Scanner) : List<List<Int>> {
    val table = mutableListOf<List<Int>>()

    for(i in 0 until n){
        val node = Node(i)
        graph.addNode(node)

        val arr = sc.nextLine().split(" ")

        val currentList = mutableListOf<Int>()

        arr.map { it.toInt() }.forEach {
            currentList.add(it)
        }

        table.add(currentList)
    }

    return table

}
