Connect and Count Assets
========================

This is an executable specification file. This file follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

To execute this specification, run
	gauge specs/mongoConnector

* To connect to "workstation" I need a host of "33.33.34.10" and a port of "27017".

Number of Databases In Cosmos
-----------------------------

tags:

* The number of dbs within "workstation" is "7".


Number of Collections within Databases
--------------------------------------

This is the second scenario in this specification

Here's a step that takes a table

* Each db will have a specified number of collections.
     |DB            |Collections|
     |--------------|-----------|
     |content-store |10         |
     |event-store   |6          |
     |feed-store    |2          |
     |link-store    |3          |
     |view-builder  |3          |
     |view-store    |9          |
