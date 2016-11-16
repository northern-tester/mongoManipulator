Connect and Check Assets
========================

This is an executable specification file. This file follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

To execute this specification, run
	gauge specs/mongoConnector

* Connect to "workstation" I need a host of "33.33.34.10" and a port of "27017".


Check that the Mongo Instance is in a Cluster
---------------------------------------------

* The mongo instance "workstation" cluster status is "false".


Check that the Mongo Instance is a Primary
------------------------------------------

* The mongo instance "workstation" is set as "Primary".