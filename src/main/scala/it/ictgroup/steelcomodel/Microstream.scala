package it.ictgroup.steelcomodel

import java.time.Instant
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

case class Tag(code: String, description: Option[String])

case class Operator(code: String, name: Option[String], surname: Option[String], role: Option[String])

case class Instrument(code: String, unicode: Option[String], description: Option[String])

case class InstrumentInfo(manufacturer: Option[String], tag: Option[Seq[Tag]], tracking: Option[Seq[Track]], archived: Lazy[Option[Seq[Track]]])

case class Program(code: String, description: Option[String], machineType: Option[String], destination: Option[Status])

case class Status(code: String, description: Option[String])

case class AresSite(code: String, description: Option[String], instruments: Option[Seq[Instrument]], machines: Option[Seq[SteelcoMachine]])

case class AresGroup(name: String, ldap: String, fullname: Option[String], role: Option[String], sites: Option[Seq[AresSite]])

case class AresUser(username: String, password: String, fullname: Option[String], group: Option[AresGroup])

case class AdditionalInfo(doctor: Option[String], nurse: Option[String], patient: Option[String], note: Option[String])

case class Track(created: Instant, status: Option[String], operator: Option[Operator], machine: Option[SteelcoMachine], cycleNumber: Option[Long], program: Option[String], result: Option[String], additionalInfo: Option[AdditionalInfo], rawData: Lazy[Map[String, Any]])

/**
 * Created by Riccardo Merolla on 09/06/2020.
 */
class AresApp extends DataLiveApp {

  final private val operators = new HashMap[String, Operator]

  final private val instruments = new HashMap[Instrument, InstrumentInfo]

  final private val archivedInstruments = new HashMap[Instrument, InstrumentInfo]

  final private val programs = new HashMap[String, Program]

  final private val sites = new HashMap[String, AresSite]

  final private val groups = new HashMap[String, AresGroup]

  final private val users = new HashMap[String, AresUser]

  final private val statuses = new HashMap[String, Status]

  final private val tags = new HashMap[String, Tag]

  def getOperators = this.operators

  def getInstruments = this.instruments

  def getArchivedInstruments = this.archivedInstruments

  def getPrograms = this.programs

  def getSites = this.sites

  def getGroups = this.groups

  def getUsers = this.users

  def getStatuses = this.statuses

  def getTags = this.tags

}