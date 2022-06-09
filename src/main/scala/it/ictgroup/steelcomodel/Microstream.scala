package it.ictgroup.steelcomodel

import java.time.Instant
import java.util.{Date, HashMap}
import one.microstream.reference.Lazy

/**
  * Created by Riccardo Merolla on 17/02/2020.
  */

case class Cycle(cycleNumber: Long, cycleDate: Date, order: Option[String], program: Option[String], result: Option[String], rawData: Lazy[Map[String, Any]])

case class SteelcoMachine(machineCode: String, serial: String = "")

case class MachineInfo(machineType: String, address: String, port: String, pointer: Int = 0, memoryMaxSize: Int = 0, cycles: Lazy[Option[Map[Long, Cycle]]] = Lazy.Reference(None), archivedCycles: Lazy[Option[Map[Long, Cycle]]] = Lazy.Reference(None))

case class NCGSensorData(machineCode: String, serial: String, order: String, cycleNumber: String, data: Lazy[Option[Map[String, Any]]] = Lazy.Reference(None))


class DataLiveApp() {

  final private val machines = new HashMap[SteelcoMachine, MachineInfo]
  final private val ncgSensorData = new HashMap[String, NCGSensorData]

  def getMachines = this.machines
  def getNCGSensorData = this.ncgSensorData
}

case class Tag(code: String = "", description: Option[String] = None)

case class Operator(code: String, name: Option[String] = None, surname: Option[String] = None, role: Option[String] = None)

case class Instrument(code: String, unicode: Option[String] = None, description: Option[String] = None)

case class InstrumentInfo(manufacturer: Option[String] = None, tag: Option[Map[String, Tag]] = None, tracking: Lazy[Option[Map[Long, Track]]] = Lazy.Reference(None), archived: Lazy[Option[Map[Long, Track]]] = Lazy.Reference(None))

case class Program(code: String, description: Option[String] = None, machineType: Option[String] = None, destination: Option[Status] = None)

case class Status(code: String, description: Option[String] = None)

case class AresSite(code: String, description: Option[String] = None, instruments: Option[Map[String, Instrument]] = None, machines: Option[Map[String, SteelcoMachine]] = None)

case class AresGroup(name: String, ldap: Option[String] = None, fullname: Option[String] = None, role: Option[String] = None, sites: Option[Map[String, AresSite]] = None)

case class AresUser(username: String, password: String, fullname: Option[String] = None, group: Option[AresGroup] = None)

case class AdditionalInfo(doctor: Option[String] = None, nurse: Option[String] = None, patient: Option[String] = None, room: Option[String] = None, note: Option[String] = None)

case class Track(created: Instant, status: Option[String] = None, operator: Option[Operator] = None, machine: Option[SteelcoMachine] = None, cycleNumber: Option[Long] = None, program: Option[String] = None, result: Option[String] = None, additionalInfo: Option[AdditionalInfo] = None, rawData: Lazy[Map[String, Any]])

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
