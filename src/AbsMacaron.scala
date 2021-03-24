package src

import java.util.OptionalInt

abstract class AbsMacaron(protected var values: Array[Int]) extends IMacaron{
  protected var c: Array[OptionalInt] =
    Array.ofDim[OptionalInt](this.values.length)

  def initTable(): Unit = {
    for (i <- 0 until values.length) {
      if (i == 0)
        this.c(i) = OptionalInt.of(values(0))
      else if (i == 1) {
        this.c(i) = OptionalInt.of(values(0).max(values(1)))
      }
      else {
        this.c(i) = OptionalInt.empty()
      }
    }
  }

  def fillTable()
  /**
   * @return - An int representing the optimal value achievable with the given
   *         data.
   */
  override def optimizeValue(): Int = null

  /**
   * @return - A boolean array, representing the indices used in reaching the
   *         optimal value.
   */
  override def optimizeSubSeq(): Array[Boolean] = null
}
