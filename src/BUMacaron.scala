package src
import java.util.OptionalInt

class BUMacaron(values: Array[Int]) extends AbsMacaron(values){
  override def fillTable(): Unit = {
    for (i <- c.indices) {
      if (!c(i).isPresent) {
        if (c(i-1).getAsInt > c(i-2).getAsInt + values(i)) {
          c(i) = c(i-1)
        }
        else {
          c(i) = OptionalInt.of(c(i-2).getAsInt + values(i))
        }
      }
    }
  }
  /**
   * @return - An int representing the optimal value achievable with the given
   *         data.
   */
  override def optimizeValue(): Int = {
    var max = 0
    for (elt <- c) {
      if (elt.isPresent) {
        if (elt.getAsInt > max)
          max = elt.getAsInt
      }
    }
    max
  }

  /**
   * @return - A boolean array, representing the indices used in reaching the
   *         optimal value.
   */
  def optimizeSubSeq(): Array[Boolean] = {
    val optimalValue = optimizeValue()
  }
}
