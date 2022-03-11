import scala.io.StdIn.readLine
import scala.util.control.Breaks.break

class TicTacToe {
  val board: Array[Array[String]] = Array.ofDim[String](3,3)
  var hasWon = false
  var columnN = ""
  def play() ={
    var x = ""
    while(x != "q"){
      var player1Signature = ""
      var player2Signature = ""
      boardCreation()
      println("First player chose your X or 0")
      player1Signature = readLine("Enter X or O: ")
      if(player1Signature == "X"){
        player2Signature = "O"
      }else{
        player2Signature = "X"
      }
      var moveCounter = 0
      while(moveCounter < 5 && !checkIfThereIsAWin()){
        turn(player1Signature)
        moveCounter = moveCounter + 1
        if(moveCounter < 5 && !checkIfThereIsAWin()) {
          turn(player2Signature)
        }else{
          println("Game has ended")
        }
        //println(moveCounter)
      }
      x = readLine("Do you want to quit press q to exit: ")
    }
  }
  def turn(x: String)={
      printBoard()
      println(s"Player $x makes a move... ")
      columnN =  readLine("Enter number of cell: ")
      columnN = checkMove(columnN)
      writeAMoveToABoard(columnN,x)
      if(checkIfThereIsAWin()){
        println(s"Player $x won")
      }else{
        println("game continues")
      }
//      printBoard()
//      println("Second player makes a move: ")
//      columnN =  readLine("Enter number of cell: ")
//      columnN = checkMove(columnN)
//      writaAMoveToABoard(columnN,"O")
//      if(checkIfThereIsAWin()){
//        println("Player 2 won")
//      }else{
//        println("game continues")
//      }
  }
  def checkMove(x: String): String={
    if(checkValueInBoard(x)){
      println("Allowed move")
      x
    }else{
      var z = ""
      while(!checkValueInBoard(z)){
      println("That move isnt allowed! There is allready a move there!")
      z = readLine("Enter number of a cell: ")
      }
      z
    }
  }
  def printBoard(): Unit ={
    for (i <- 0 to 2){
        for (j <- 0 to 2){
          print(" " +board(i)(j))
        }
      println()
    }
  }
  def boardCreation(): Unit ={
    var numberOfCell = 0
    for (i <- 0 to 2){
      for (j <- 0 to 2){
        board(i)(j) = numberOfCell.toString
        //print(" " +board(i)(j))
        numberOfCell = numberOfCell + 1
      }
      //println()
    }
  }
  def checkValueInBoard(x: String): Boolean={
    var valueExsist = false
    for (i <- 0 to 2){
      for (j <- 0 to 2){
        if(board(i)(j) == x){
          valueExsist = true
        }else{

        }
      }
    }
    valueExsist
  }
  def writeAMoveToABoard(x: String, y: String): Unit ={
    x match {
      case "0" => board(0)(0) = y
      case "1" => board(0)(1) = y
      case "2" => board(0)(2) = y
      case "3" => board(1)(0) = y
      case "4" => board(1)(1) = y
      case "5" => board(1)(2) = y
      case "6" => board(2)(0) = y
      case "7" => board(2)(1) = y
      case "8" => board(2)(2) = y
    }
  }
  def checkIfThereIsAWin(): Boolean={
    var x = false
    var z = false
    var y = false
    x = checkRow(0) || checkRow(1) || checkRow(2)
    z = checkColumn(0) || checkColumn(1) || checkColumn(2)
    y = x || z || checkAxis()
    y
  }
  def checkColumn(x: Int): Boolean={
    var z = false
    z = board(x)(0) == board(x)(1) && board(x)(0) == board(x)(2)
    z
  }
  def checkRow(x :Int): Boolean={
    var z = false
    z = board(0)(x) == board(1)(x) && board(0)(x) == board(2)(x)
    z
  }
  def checkAxis(): Boolean={
    var x = false
    var y = false
    var z = false
    x = board(0)(0) == board(1)(1) && board(0)(0) == board(2)(2)
    y = board(2)(0) == board(1)(1) && board(2)(0) == board(0)(2)
    z = x || y
    z
  }
}
