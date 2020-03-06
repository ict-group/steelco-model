package it.ictgroup.steelcomodel

import java.util.{ Date, HashMap }
import one.microstream.reference.Lazy

/**
  * Created by Riccardo Merolla on 17/02/2020.
  */

case class Cycle(cycleNumber: Long, cycleDate: Date, order: Option[String], program: Option[String], result: Option[String], rawData: Lazy[Map[String, Any]])

case class SteelcoMachine(machineCode: String, serial: String = "")

case class MachineInfo(machineType: String, address: String, port: String, pointer: Int = 0, memoryMaxSize: Int = 0, cycles: Option[Map[Long, Cycle]] = None)

class DataLiveApp() {

  final private val machines = new HashMap[SteelcoMachine, MachineInfo]

  def getMachines = this.machines
}